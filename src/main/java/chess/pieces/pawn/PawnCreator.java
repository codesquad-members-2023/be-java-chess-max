package chess.pieces.pawn;

import chess.pieces.Color;

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
