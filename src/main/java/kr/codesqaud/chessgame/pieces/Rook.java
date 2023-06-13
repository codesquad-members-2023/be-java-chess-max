package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Type.ROOK;

import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Direction;

public class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, ROOK, position, Direction.linearDirection());
    }

    public static Rook createWhite(final Position position) {
        return new Rook(Color.WHITE, position);
    }

    public static Rook createBlack(final Position position) {
        return new Rook(Color.BLACK, position);
    }
}
