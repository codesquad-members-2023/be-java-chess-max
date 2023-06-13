package kr.codesqaud.chessgame.pieces;

import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;

public class Blank extends Piece {

    public Blank(final Position position) {
        super(Color.NOCOLOR, Type.NO_PIECE, position);
    }

    public static Blank create(final Position position) {
        return new Blank(position);
    }


}
