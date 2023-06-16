package kr.codesqaud.chessgame.chess.pieces;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class Rook extends Piece {

    public Rook(final Color color, final Position position) {
        super(color, Type.ROOK, position, Direction.linearDirection());
    }

    public static Rook createWhite(final Position position) {
        return new Rook(Color.WHITE, position);
    }

    public static Rook createBlack(final Position position) {
        return new Rook(Color.BLACK, position);
    }
}
