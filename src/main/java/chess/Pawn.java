package chess;

public record Pawn(Color color) implements Piece {

    public boolean verifyPawn(Color color) {
        return this.color.equals(color);
    }
}
