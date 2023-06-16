package kr.codesqaud.chessgame.chess.pieces;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class Blank extends Piece {

    public Blank(final Position position) {
        super(Color.NOCOLOR, Type.NO_PIECE, position);
    }

    public static Blank create(final Position position) {
        return new Blank(position);
    }

    @Override
    public String getWhiteSymbol() {
        return "&#32;";
    }

    @Override
    public String getBlackSymbol() {
        return "&#32;";
    }
}
