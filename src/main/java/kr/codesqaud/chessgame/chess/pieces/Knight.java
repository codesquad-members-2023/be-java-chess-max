package kr.codesqaud.chessgame.chess.pieces;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class Knight extends Piece {

    public Knight(final Color color, final Position position) {
        super(color, Type.KNIGHT, position, Direction.knightDirection());
    }

    public static Knight createWhite(final Position position) {
        return new Knight(Color.WHITE, position);
    }

    public static Knight createBlack(final Position position) {
        return new Knight(Color.BLACK, position);
    }

    @Override
    public void verifyMovePosition(final Piece target) {
        verifySameTeam(target);
        verifyDirection(target);
        verifyDirectionMatch(target);
    }
}
