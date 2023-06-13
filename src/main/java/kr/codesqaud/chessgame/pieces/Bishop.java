package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Type.BISHOP;

import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Direction;

public class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, BISHOP, position, Direction.diagonalDirection());
    }

    public static Bishop createWhite(final Position position) {
        return new Bishop(Color.WHITE, position);
    }

    public static Bishop createBlack(final Position position) {
        return new Bishop(Color.BLACK, position);
    }
}
