package kr.codesqaud.chessgame.chess.pieces;

import static kr.codesqaud.chessgame.chess.pieces.config.Color.WHITE;

import java.util.List;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;

public class Pawn extends Piece {

    private static final int WHITE_STARTING_RANK = 2;
    private static final int BLACK_STARTING_RANK = 7;

    public Pawn(final Color color, final Position position, final List<Direction> directions) {
        super(color, Type.PAWN, position, directions);
    }

    public static Pawn createWhite(final Position position) {
        return new Pawn(WHITE, position, Direction.whitePawnDirection());
    }

    public static Pawn createBlack(final Position position) {
        return new Pawn(Color.BLACK, position, Direction.blackPawnDirection());
    }

    public static Pawn create(final Color color, final Position position) {
        return color == WHITE ? createWhite(position) : createBlack(position);
    }

    public boolean isStartingPosition() {
        int rank = getPosition().getRank();

        if (isWhite()) {
            return rank == WHITE_STARTING_RANK;
        }
        return rank == BLACK_STARTING_RANK;
    }

    @Override
    public void verifyMovePosition(final Piece target) {
        // 같은 색의 기물인지 확인
        verifySameTeam(target);
        // 방향 검증
        verifyDirection(target);
        // 대각선 이동시 target이 적기물인지 검증
        verifyDiagonal(target);
        // 폰 두칸 이동 검증
        verifyFirstMove(target);
    }

    private void verifyDiagonal(final Piece target) {
        Direction direction = direction(target);
        if (isWhite() && (direction != Direction.NORTH) && !target.isBlack()) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
        }
        if (isBlack() && (direction != Direction.SOUTH) && !target.isWhite()) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
        }
    }

    private void verifyFirstMove(final Piece target) {
        Degree degree = degree(target);
        if (!isStartingPosition() && degree.isOverOneYDegree()) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
        }
        if (isStartingPosition() && !degree.isUnderThreeYDegree()) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
        }
    }
}
