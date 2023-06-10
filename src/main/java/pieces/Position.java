package pieces;

public class Position {

    public static final int MAX_POS = 7;

    private int xPos;
    private int yPos;

    public Position(String position) {
        xPos = position.charAt(0) - 'a';
        yPos = Character.getNumericValue(position.charAt(1)) - 1;
    }

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    /**
     * other와 x좌표는 같고 y좌표는 다른 Position인 경우
     */
    public boolean matchVerticalPosition(Position other) {
        return yPos != other.yPos && xPos == other.xPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (xPos != position.xPos) return false;
        return yPos == position.yPos;
    }

    @Override
    public int hashCode() {
        int result = xPos;
        result = 31 * result + yPos;
        return result;
    }
}
