package kr.codesqaud.chessgame.chess;


import static kr.codesqaud.chessgame.pieces.Position.createPosition;
import static kr.codesqaud.chessgame.pieces.Position.emptyPosition;
import static kr.codesqaud.chessgame.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.pieces.config.Color.WHITE;
import static kr.codesqaud.chessgame.pieces.config.Direction.NORTHEAST;
import static kr.codesqaud.chessgame.pieces.config.Direction.NORTHWEST;
import static kr.codesqaud.chessgame.pieces.config.Direction.SOUTHWEST;
import static kr.codesqaud.chessgame.pieces.config.Type.NO_PIECE;
import static kr.codesqaud.chessgame.pieces.config.Type.PAWN;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.pieces.Blank;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Position;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Direction;
import kr.codesqaud.chessgame.pieces.config.Type;
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
        Piece sourcePiece = findPiece(sourcePosition);
        Piece targetPiece = findPiece(targetPosition);
        Position prevPosition = sourcePiece.getPosition();
        if (sourcePiece.matchType(PAWN)) {
            Direction direction = sourcePiece.getPosition().direction(targetPiece.getPosition());
            Position removePosition = verifyEnPassant(direction, sourcePiece);

            if (!removePosition.empty()) {
                setPiece(removePosition, Blank.create(removePosition));
            }
        }
        // 이동 경로 중간에 다른 기물이 있는지 확인합니다.
        if (isPathBlocked(sourcePiece, targetPiece)) {
            throw new InvalidMovingPieceException(targetPiece.getPosition() + "로 이동할 수 없습니다.");
        }

        sourcePiece.move(targetPiece);
        setPiece(prevPosition, Blank.create(prevPosition));
        setPiece(sourcePiece.getPosition(), sourcePiece);
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
        return findPiece(position).getColor();
    }

    private boolean isPathBlocked(final Piece sourcePiece, final Piece target) {
        Direction direction = sourcePiece.getPosition().direction(target.getPosition());
        Position currentPosition = sourcePiece.getPosition();

        while (!Objects.equals(currentPosition, target.getPosition())) {
            currentPosition = currentPosition.move(direction);
            if (!findPiece(currentPosition).matchType(NO_PIECE)) {
                return true;
            }
        }
        return false;
    }

    // 백색폰 북서쪽 앙파상 조건 : 현재 백색폰 위치 기준으로 왼쪽(file - 1)에 흑백 기물이 있는 경우
    // 백색폰 북동쪽 앙파상 조건 : 현재 백색폰 위치 기준으로 오른쪽(file + 1)에 흑백 기물이 있는 경우
    // 흑백폰 남서쪽 앙파상 조건 : 현재 흑백폰 위치 기준으로 왼쪽(file - 1)에 백색 기물이 있는 경우
    // 흑백폰 남동쪽 앙파상 조건 : 현재 흑백폰 위치 기준으로 오른쪽(file + 1)에 흑백 기물이 있는 경우
    private Position verifyEnPassant(Direction direction, Piece target) {
        if (target.isWhite()) {
            return verifyWhitePawnEnPassant(direction, target);
        } else if (target.isBlack()) {
            return verifyBlackPawnEnPassant(direction, target);
        }
        return Position.emptyPosition();
    }

    private Position verifyWhitePawnEnPassant(Direction direction, Piece target) {
        Position position = emptyPosition();
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(NORTHWEST) && !leftPiece.matchColor(BLACK)) {
                throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
            } else if (target.isSameTeam(leftPiece)) {
                position = emptyPosition();
            } else {
                position = leftPiece.getPosition();
            }
        }
        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(NORTHEAST) && !rightPiece.matchColor(BLACK)) {
                throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
            } else if (target.isSameTeam(rightPiece)) {
                position = emptyPosition();
            } else {
                position = rightPiece.getPosition();
            }
        }
        return position;
    }

    private Position verifyBlackPawnEnPassant(Direction direction, Piece target) {
        Position position = emptyPosition();
        if (!target.getPosition().getLeftPosition().empty()) {
            Piece leftPiece = findPiece(target.getPosition().getLeftPosition());
            if (direction.matchDirection(SOUTHWEST) && !leftPiece.matchColor(WHITE)) {
                throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
            } else if (target.isSameTeam(leftPiece)) {
                position = emptyPosition();
            } else {
                position = leftPiece.getPosition();
            }
        }

        if (!target.getPosition().getRightPosition().empty()) {
            Piece rightPiece = findPiece(target.getPosition().getRightPosition());
            if (direction.matchDirection(SOUTHWEST) && !rightPiece.matchColor(WHITE)) {
                throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
            } else if (target.isSameTeam(rightPiece)) {
                position = emptyPosition();
            } else {
                position = rightPiece.getPosition();
            }
        }
        return position;
    }

    // Position 위치로 기물 설정
    public void setPiece(final String position, final Piece piece) {
        piece.setPosition(createPosition(position));
        setPiece(createPosition(position), piece);
    }

    // Position 위치로 기물 설정
    public void setPiece(final Position position, final Piece piece) {
        ranks.get(position.getRankIndex())
            .setPiece(position.getFileIndex(), piece);
    }

    // 빈 체스판 초기화
    public void initializeEmpty() {
        for (int i = 1; i <= SIZE; i++) {
            ranks.add(Rank.initializeBlankLine(i));
        }
    }

    // Color와 기물 종류에 따른 기물 개수를 반환
    public int countPieceByColorAndType(final Color color, final Type type) {
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

    // 입력받은 Position에 따른 기물 객체 반환
    public Piece findPiece(final String position) {
        return findPiece(createPosition(position));
    }

    // 입력받은 Position에 따른 기물 객체 반환
    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex())
            .findPiece(position.getFileIndex());
    }

    // 컬러를 기준으로 점수가 높은 순서로 정렬하여 반환합니다.
    public List<Piece> sortDecreaseByColor(final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .sorted(Comparator.comparingDouble(p -> ((Piece) p).getType().getDefaultPoint()).reversed())
            .collect(Collectors.toUnmodifiableList());
    }

    // 컬러를 기준으로 점수가 낮은 순서로 정렬하여 반환합니다.
    public List<Piece> sortIncreaseByColor(final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .sorted(Comparator.comparingDouble(p -> p.getType().getDefaultPoint()))
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
