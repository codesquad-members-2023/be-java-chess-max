package kr.codesqaud.chessgame.chess.pieces;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class Bishop extends Piece {

    public Bishop(final Color color, final Position position) {
        super(color, Type.BISHOP, position, Direction.diagonalDirection());
    }

    public static Bishop createWhite(final Position position) {
        return new Bishop(Color.WHITE, position);
    }

    public static Bishop createBlack(final Position position) {
        return new Bishop(Color.BLACK, position);
    }
}
