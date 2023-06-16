package kr.codesqaud.chessgame.chess.board;


import static kr.codesqaud.chessgame.chess.pieces.Position.createPosition;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.WHITE;
import static kr.codesqaud.chessgame.chess.pieces.config.Type.KING;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.chess.pieces.Blank;
import kr.codesqaud.chessgame.chess.pieces.Piece;
import kr.codesqaud.chessgame.chess.pieces.Position;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
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
    public boolean move(final String sourcePosition, final String targetPosition) {
        Position from = createPosition(sourcePosition);
        Position to = createPosition(targetPosition);

        if (from.empty() || to.empty()) {
            return false;
        }

        Piece sourcePiece = findPiece(from);
        Piece targetPiece = findPiece(to);
        
        List<Position> moreCheckedPositions = sourcePiece.verifyMovePosition(targetPiece);
        if (moreCheckedPositions.isEmpty()) {
            sourcePiece.move(targetPiece);
        } else {
            verifySameTeam(sourcePiece, moreCheckedPositions);
            sourcePiece.move(targetPiece);
        }
        setPiece(Blank.create(from));
        setPiece(sourcePiece);
        return true;
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
    public void setPiece(final Piece piece) {
        ranks.get(piece.getPosition().getRankIndex())
            .setPiece(piece.getPosition().getFileIndex(), piece);
    }

    // 입력받은 Position에 따른 기물 객체 반환
    @Override
    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex())
            .findPiece(position.getFileIndex());
    }

    @Override
    public Optional<Piece> findPieceBy(final Color color, final Type type) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .filter(piece -> Objects.equals(piece.getType(), type))
            .findAny();
    }

    @Override
    public boolean checkmate(final Color color) {
        return findPieceBy(color, KING).isEmpty();
    }

    // 색상을 기준으로 기물들의 점수합을 반환
    @Override
    public double getPointBy(final Color color) {
        List<Piece> pieces = findPiecesBy(color);
        return pieces.stream()
            .mapToDouble(piece -> piece.getPoint(pieces))
            .sum();
    }

    @Override
    public List<Rank> getReverseRanks() {
        return ranks.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toUnmodifiableList());
    }

    private void verifySameTeam(final Piece piece, final List<Position> moreCheckedPositions) {
        for (Position position : moreCheckedPositions) {
            Piece checkedPiece = findPiece(position);
            if (piece.isSameTeam(checkedPiece)) {
                throw new InvalidMovingPieceException(
                    "이동하려는 위치에 같은 색상의 말이 존재합니다. : " + piece.getPosition() + "->" + checkedPiece.getPosition());
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

    public boolean isCheckByColor(final Color color) {
        if (color == WHITE) {
            return white_king_check;
        }
        return black_king_check;
    }
}
