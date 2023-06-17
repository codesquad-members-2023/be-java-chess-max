package kr.codesqaud.chessgame.chess.pieces;

import static kr.codesqaud.chessgame.chess.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.WHITE;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class Queen extends Piece {

    public Queen(final Color color, final Position position) {
        super(color, Type.QUEEN, position, Direction.everyDirection());
    }

    public static Queen createWhite(final Position position) {
        return new Queen(WHITE, position);
    }

    public static Queen createBlack(final Position position) {
        return new Queen(BLACK, position);
    }

    @Override
    public String getWhiteSymbol() {
        return "&#9813;";
    }

    @Override
    public String getBlackSymbol() {
        return "&#9819;";
    }
}
