package chess.pieces;

import chess.Color;

public record Pawn(Color color) implements Piece {

    public boolean verifyPawn(Color color) {
        return this.color.equals(color);
    }
}
