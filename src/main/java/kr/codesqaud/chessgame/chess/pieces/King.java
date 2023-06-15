package kr.codesqaud.chessgame.chess.pieces;

import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;

public class King extends Piece {

    public King(final Color color, final Position position) {
        super(color, Type.KING, position, Direction.everyDirection());
    }

    public static King createWhite(final Position position) {
        return new King(Color.WHITE, position);
    }

    public static King createBlack(final Position position) {
        return new King(Color.BLACK, position);
    }

    @Override
    public void verifyMovePosition(final Piece target) {
        verifySameTeam(target);
        verifyDirection(target);
        verifyDirectionMatch(target);
    }
}
