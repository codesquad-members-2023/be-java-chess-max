package chess.pieces.pawn;

import chess.pieces.Color;
import chess.pieces.Piece;

public abstract class Pawn implements Piece {


    public abstract boolean verifyPawn(Color color);

    public abstract PawnRepresentation getRepresentation();
}
