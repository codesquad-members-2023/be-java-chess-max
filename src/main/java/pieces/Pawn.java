package pieces;

public class Pawn {

    public static final String COLOR_BLACK = "black";
    public static final String COLOR_WHITE = "white";
    public static final String BLACK_FIGURE = "P";
    public static final String WHITE_FIGURE = "p";
    private final String color;
    private final String figure;

    public Pawn() {
        this.color = COLOR_WHITE;
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
}
