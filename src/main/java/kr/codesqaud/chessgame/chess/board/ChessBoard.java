package kr.codesqaud.chessgame.chess.board;


import static kr.codesqaud.chessgame.chess.pieces.Position.createPosition;
import static kr.codesqaud.chessgame.chess.pieces.Position.emptyPosition;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.WHITE;
import static kr.codesqaud.chessgame.chess.pieces.config.Direction.NORTHEAST;
import static kr.codesqaud.chessgame.chess.pieces.config.Direction.NORTHWEST;
import static kr.codesqaud.chessgame.chess.pieces.config.Direction.SOUTHWEST;
import static kr.codesqaud.chessgame.chess.pieces.config.Type.KING;
import static kr.codesqaud.chessgame.chess.pieces.config.Type.NO_PIECE;
import static kr.codesqaud.chessgame.chess.pieces.config.Type.PAWN;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesqaud.chessgame.chess.pieces.Blank;
import kr.codesqaud.chessgame.chess.pieces.King;
import kr.codesqaud.chessgame.chess.pieces.Piece;
import kr.codesqaud.chessgame.chess.pieces.Position;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessBoard implements Board {

    private static final Logger logger = LoggerFactory.getLogger(ChessBoard.class);
    private final List<Rank> ranks;
    private boolean white_king_check;
    private boolean black_king_check;

    public ChessBoard() {
        ranks = new ArrayList<>(SIZE);
    }

    // 체스판 초기화
    @Override
    public void initialize() {
        ranks.add(Rank.initializeWhitePieces(1));
        ranks.add(Rank.initializeWhitePawns(2));
        ranks.add(Rank.initializeBlankLine(3));
        ranks.add(Rank.initializeBlankLine(4));
        ranks.add(Rank.initializeBlankLine(5));
        ranks.add(Rank.initializeBlankLine(6));
        ranks.add(Rank.initializeBlackPawns(7));
        ranks.add(Rank.initializeBlackPieces(8));

        white_king_check = false;
        black_king_check = false;
    }

    // sourcePosition에서 targetPosition으로 기물 이동
    @Override
    public void move(final String sourcePosition, final String targetPosition) {
        Piece sourcePiece = findPiece(createPosition(sourcePosition));
        Piece targetPiece = findPiece(createPosition(targetPosition));
        Position prevPosition = sourcePiece.getPosition();

        // 앙파상인 경우 처리
        if (sourcePiece.matchType(PAWN) && isEnPassant(sourcePiece, targetPiece)) {
            Position removePosition = getEnPassant(sourcePiece, targetPiece);
            Piece removePiece = findPiece(removePosition);
            removePiece.setPosition(targetPiece.getPosition());
            // 기물 옆에 있는 적기물 제거
            setPiece(removePosition, Blank.create(removePosition));
            // target 자리에 적 기물 설정
            setPiece(removePiece.getPosition(), removePiece);
            targetPiece = removePiece;
        }

        if (!isMoving(sourcePiece, targetPiece)) {
            throw new InvalidMovingPieceException("해당 위치로 이동할 수 없습니다." + targetPosition);
        }

        sourcePiece.move(targetPiece);
        setPiece(prevPosition, Blank.create(prevPosition));
        setPiece(sourcePiece.getPosition(), sourcePiece);
        setKingCheck(sourcePiece);
    }

    // 체스판 위에 기물 상태를 문자열로 반환
    @Override
    public String showBoard() {
        return ranks.stream()
            .sorted(Comparator.reverseOrder())
            .map(Rank::getPieceResult)
            .map(StringUtils::appendNewLine)
            .collect(Collectors.joining());
    }

    @Override
    public Color getColorByPosition(final String position) {
        return findPiece(createPosition(position)).getColor();
    }

    @Override
    public void setPiece(final Position position, final Piece piece) {
        ranks.get(position.getRankIndex())
            .setPiece(position.getFileIndex(), piece);
    }

    // 입력받은 Position에 따른 기물 객체 반환
    @Override
    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex())
            .findPiece(position.getFileIndex());
    }

    // 입력받은 위치에서 이동할 수 있는 경로를 응답합니다.
    @Override
    public List<Position> possiblePath(final Position position) {
        Piece sourcePiece = findPiece(position);
        List<Position> positions = new ArrayList<>();
        for (Direction direction : sourcePiece.getDirections()) {
            Position target = sourcePiece.getPosition();
            while (!target.empty()) {
                target = target.move(direction);

                if (target.empty()) {
                    break;
                }

                Piece targetPiece = findPiece(target);
                if (isMoving(sourcePiece, targetPiece)) {
                    positions.add(target);
                }
            }
        }
        return positions;
    }

    private boolean isEnPassant(final Piece sourcePiece, final Piece targetPiece) {
        Direction direction = sourcePiece.direction(targetPiece);
        if (sourcePiece.isWhite()) {
            return isWhitePawnEnPassant(direction, sourcePiece);
        } else if (sourcePiece.isBlack()) {
            return isBlackPawnEnPassant(direction, sourcePiece);
        }
        return false;
    }

    private boolean isWhitePawnEnPassant(Direction direction, Piece target) {
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(NORTHWEST) && !leftPiece.matchColor(BLACK)) {
                return false;
            } else if (target.isSameTeam(leftPiece)) {
                return false;
            } else {
                return true;
            }
        }
        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(NORTHEAST) && !rightPiece.matchColor(BLACK)) {
                return false;
            } else if (target.isSameTeam(rightPiece)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isBlackPawnEnPassant(Direction direction, Piece target) {
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(SOUTHWEST) && !leftPiece.matchColor(WHITE)) {
                return false;
            } else if (target.isSameTeam(leftPiece)) {
                return false;
            } else {
                return true;
            }
        }

        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(SOUTHWEST) && !rightPiece.matchColor(WHITE)) {
                return false;
            } else if (target.isSameTeam(rightPiece)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private Position getEnPassant(final Piece sourcePiece, final Piece targetPiece) {
        Direction direction = sourcePiece.direction(targetPiece);
        if (sourcePiece.isWhite()) {
            return getWhitePawnEnPassant(direction, sourcePiece);
        } else if (sourcePiece.isBlack()) {
            return getBlackPawnEnPassant(direction, sourcePiece);
        }
        return emptyPosition();
    }

    private Position getWhitePawnEnPassant(Direction direction, Piece target) {
        Position position = emptyPosition();
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(NORTHWEST) && !leftPiece.matchColor(BLACK)) {
                return position;
            } else if (target.isSameTeam(leftPiece)) {
                return position;
            } else {
                position = leftPiece.getPosition();
            }
        }
        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(NORTHEAST) && !rightPiece.matchColor(BLACK)) {
                return position;
            } else if (target.isSameTeam(rightPiece)) {
                return position;
            } else {
                position = rightPiece.getPosition();
            }
        }
        return position;
    }

    private Position getBlackPawnEnPassant(Direction direction, Piece target) {
        Position position = emptyPosition();
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(SOUTHWEST) && !leftPiece.matchColor(WHITE)) {
                return position;
            } else if (target.isSameTeam(leftPiece)) {
                return position;
            } else {
                position = leftPiece.getPosition();
            }
        }

        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(SOUTHWEST) && !rightPiece.matchColor(WHITE)) {
                return position;
            } else if (target.isSameTeam(rightPiece)) {
                return position;
            } else {
                position = rightPiece.getPosition();
            }
        }
        return position;
    }

    private boolean isMoving(final Piece sourcePiece, final Piece targetPiece) {
        try {
            // target 위치로 이동하고자 할시 체크가 되는지 검증
            verifyCheckStatusAt(sourcePiece, targetPiece);

            // 체크 상태에서 다른 기물을 이동하려는지 검증합니다.
            verifyMoveFromCheck(sourcePiece);

            // 이동 경로 중간에 다른 기물이 있는지 확인합니다.
            verifyPathBlocked(sourcePiece, targetPiece);

            return sourcePiece.isMoving(targetPiece);
        } catch (InvalidMovingPieceException e) {
            return false;
        }
    }

    // target 위치로 이동하고자 할시 체크가 되는지 검증
    private void verifyCheckStatusAt(final Piece sourcePiece, final Piece targetPiece) {
        if (!sourcePiece.matchType(KING)) {
            return;
        }

        if (sourcePiece.isWhite()) {
            King whiteKing = King.createWhite(targetPiece.getPosition());
            if (isCheckKing(whiteKing)) {
                throw new InvalidMovingPieceException("해당 위치로 이동시 체크입니다");
            }
        } else if (sourcePiece.isBlack()) {
            King blackKign = King.createBlack(targetPiece.getPosition());
            if (isCheckKing(blackKign)) {
                throw new InvalidMovingPieceException("해당 위치로 이동시 체크입니다.");
            }
        }
    }

    // king이 위치한 자리에서 king 기물의 적기물들이 king 자리로 이동이 가능한지 검사합니다.
    private boolean isCheckKing(final Piece king) {
        Color color = king.isWhite() ? BLACK : WHITE;
        List<Piece> pieces = findPiecesBy(color);
        return pieces.stream()
            .anyMatch(piece -> piece.isMoving(king));
    }

    private void verifyMoveFromCheck(final Piece sourcePiece) {
        if (sourcePiece.isWhite() && white_king_check && !sourcePiece.matchType(KING)) {
            throw new InvalidMovingPieceException(sourcePiece.getColor() + "색 킹이 체크상태입니다. 킹을 이동해주세요.");
        } else if (sourcePiece.isBlack() && black_king_check && !sourcePiece.matchType(KING)) {
            throw new InvalidMovingPieceException(sourcePiece.getColor() + "색 킹이 체크상태입니다. 킹을 이동해주세요.");
        }
    }

    private void setKingCheck(final Piece sourcePiece) {
        if (sourcePiece.isWhite()) {
            black_king_check = isCheckKing(sourcePiece.getColor());
        }
        if (sourcePiece.isBlack()) {
            white_king_check = isCheckKing(sourcePiece.getColor());
        }
    }

    // 입력받은 color의 King이 체크 상태인지 검사합니다.
    private boolean isCheckKing(final Color sourcePieceColor) {
        Color color = sourcePieceColor == WHITE ? BLACK : WHITE;
        Optional<Piece> king = findPieceBy(color, KING);
        if (king.isPresent()) {
            List<Piece> pieces = findPiecesBy(sourcePieceColor);
            return pieces.stream().anyMatch(piece -> isMoving(piece, king.get()));
        }
        return false;
    }

    // 중간 경로에 다른 기물이 있는지 검증합니다.
    private void verifyPathBlocked(final Piece sourcePiece, final Piece targetPiece) {
        Direction direction = sourcePiece.direction(targetPiece);
        Position currentPosition = sourcePiece.getPosition();
        Position targetPosition = targetPiece.getPosition();

        while (!Objects.equals(currentPosition.move(direction), targetPosition)) {
            currentPosition = currentPosition.move(direction);
            if (!findPiece(currentPosition).matchType(NO_PIECE)) {
                throw new InvalidMovingPieceException(targetPiece.getPosition() + "로 이동할 수 없습니다.");
            }
        }

    }


    // 빈 체스판 초기화
    public void initializeEmpty() {
        for (int i = 1; i <= SIZE; i++) {
            ranks.add(Rank.initializeBlankLine(i));
        }
    }

    // Color와 기물 종류에 따른 기물 개수를 반환
    public int countPieceBy(final Color color, final Type type) {
        return ranks.stream()
            .mapToInt(rank -> rank.getPieceCount(color, type))
            .sum();
    }

    // 체스판 위에 있는 기물들 개수 반환
    public int countAllPiece() {
        return ranks.stream()
            .mapToInt(Rank::countPieces)
            .sum();
    }

    private Optional<Piece> findPieceBy(final Color color, final Type type) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .filter(piece -> Objects.equals(piece.getType(), type))
            .findAny();
    }

    private List<Piece> findPiecesBy(final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .collect(Collectors.toUnmodifiableList());
    }

    // 컬러를 기준으로 점수가 낮은 순서로 정렬하여 반환합니다.
    public List<Piece> sortIncreaseByColor(final Color color) {
        return sortByColorAndPoint(color,
            (p1, p2) -> (int) Math.floor(p1.getType().getDefaultPoint() - p2.getType().getDefaultPoint()));
    }

    // 컬러를 기준으로 점수가 높은 순서로 정렬하여 반환합니다.
    public List<Piece> sortDecreaseByColor(final Color color) {
        return sortByColorAndPoint(color,
            (p1, p2) -> (int) Math.floor(p2.getType().getDefaultPoint() - p1.getType().getDefaultPoint()));
    }

    // 컬러와 정렬 기준에 따라서 정렬하여 반환합니다.
    private List<Piece> sortByColorAndPoint(final Color color, final Comparator<Piece> comparator) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .sorted(comparator)
            .collect(Collectors.toUnmodifiableList());
    }

    // 색상을 기준으로 기물들의 점수합을 반환
    public double calculatePoint(final Color color) {
        final double PAWN_SCORE = 0.5;
        double score = 0.0;
        // 폰이 아닌 다른 기물의 점수합
        score += getPieceStream(ranks, color)
            .map(Piece::getType)
            .filter(type -> !Objects.equals(type, PAWN))
            .mapToDouble(Type::getDefaultPoint)
            .sum();

        // 폰이고 수직적인 위치에 다른 폰이 없는 경우의 기물 점수합
        score += getPieceStream(ranks, color)
            .filter(piece -> Objects.equals(piece.getType(), PAWN))
            .filter(piece -> !existPawnInVeritable(ranks, piece.getPosition()))
            .map(Piece::getType)
            .mapToDouble(Type::getDefaultPoint)
            .sum();

        // 폰이고 수직적인 위치에 다른 폰이 있는 경우의 기물 점수합
        score += getPieceStream(ranks, color)
            .filter(piece -> Objects.equals(piece.getType(), PAWN))
            .filter(piece -> existPawnInVeritable(ranks, piece.getPosition()))
            .map(Piece::getType)
            .mapToDouble(value -> PAWN_SCORE)
            .sum();

        return score;
    }

    private Stream<Piece> getPieceStream(final List<Rank> ranks, final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color));
    }

    // 입력받은 Position을 기준으로 수직에 같은 색상의 다른 Pawn이 있는지 확인
    private boolean existPawnInVeritable(final List<Rank> ranks, final Position position) {
        int file = position.getFile();
        return ranks.stream()
            .filter(rank -> !rank.isMatchRank(position.getRank()))
            .map(rank -> rank.findPiece(file))
            .map(Piece::getType)
            .anyMatch(type -> Objects.equals(type, PAWN));
    }

    public boolean isCheckByColor(final Color color) {
        if (color == WHITE) {
            return white_king_check;
        }
        return black_king_check;
    }
}
