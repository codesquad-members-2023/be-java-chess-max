package chess.pieces;

import chess.Color;

public class PawnCreator {

    private PawnCreator() {
    }

    public static Pawn create(Color color) {
        if (color.equals(Color.WHITE)) {
            return new WhitePawn();
        }
        return new BlackPawn();
    }


}
