package pieces;

public class Pawn {

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_FIGURE = "P";
    public static final String WHITE_FIGURE = "p";

    private final String color;
    private final String figure;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.figure = WHITE_FIGURE;
    }

    public Pawn(String color, String figure) {
        this.color = color;
        this.figure = figure;
    }

    public String getColor() {
        return color;
    }

    public String getFigure() {
        return figure;
    }

    public boolean isBlack() {
        if (color.equals(BLACK_COLOR)) {
            return true;
        }
        return false;
    }

    public boolean isWhite() {
        if (color.equals(WHITE_COLOR)) {
            return true;
        }
        return false;
    }
}
