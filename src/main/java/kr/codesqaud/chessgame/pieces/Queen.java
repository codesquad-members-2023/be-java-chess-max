package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.pieces.config.Color.WHITE;
import static kr.codesqaud.chessgame.pieces.config.Direction.everyDirection;
import static kr.codesqaud.chessgame.pieces.config.Type.QUEEN;

import kr.codesqaud.chessgame.pieces.config.Color;

public class Queen extends Piece {

    public Queen(final Color color, final Position position) {
        super(color, QUEEN, position, everyDirection());
    }

    public static Queen createWhite(final Position position) {
        return new Queen(WHITE, position);
    }

    public static Queen createBlack(final Position position) {
        return new Queen(BLACK, position);
    }
}
