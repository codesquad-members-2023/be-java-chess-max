package chess;

public record Pawn(Color color) {

    public boolean verifyPawn(Color color) {
        return this.color.equals(color);
    }
}
