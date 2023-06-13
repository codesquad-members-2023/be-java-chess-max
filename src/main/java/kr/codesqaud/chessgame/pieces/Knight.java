package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Direction.knightDirection;
import static kr.codesqaud.chessgame.pieces.config.Type.KNIGHT;

import kr.codesqaud.chessgame.pieces.config.Color;

public class Knight extends Piece {

    public Knight(final Color color, final Position position) {
        super(color, KNIGHT, position, knightDirection());
    }

    public static Knight createWhite(final Position position) {
        return new Knight(Color.WHITE, position);
    }

    public static Knight createBlack(final Position position) {
        return new Knight(Color.BLACK, position);
    }
}
