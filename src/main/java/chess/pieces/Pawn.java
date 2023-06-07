package chess.pieces;

import chess.Color;

public abstract class Pawn implements Piece {


    public abstract boolean verifyPawn(Color color);

    public abstract PawnRepresentation getRepresentation();
}
