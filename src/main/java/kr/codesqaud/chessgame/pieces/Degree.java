package kr.codesqaud.chessgame.pieces;

public class Degree {

    private int yDegree;
    private int xDegree;

    public Degree(final int yDegree, final int xDegree) {
        this.yDegree = yDegree;
        this.xDegree = xDegree;
    }

    public boolean isOverOneXDegree() {
        return this.xDegree > 1;
    }

    public boolean isOverOneYDegree() {
        return this.yDegree > 1;
    }

    public boolean isUnderThreeYDegree() {
        return yDegree > -3 && yDegree < 3;
    }
}
