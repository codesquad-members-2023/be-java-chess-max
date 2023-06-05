package pieces;

public class Pawn {

    public static final String COLOR_BLACK = "black";
    public static final String COLOR_WHITE = "white";
    private final String color;

    public Pawn() {
        this.color = COLOR_WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
