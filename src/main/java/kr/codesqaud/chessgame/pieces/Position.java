package kr.codesqaud.chessgame.pieces;

import static java.lang.Character.getNumericValue;

import java.util.Objects;

public class Position {

    private final int file;
    private final int rank;

    private Position(final int file, final int rank) {
        this.rank = rank;
        this.file = file;
    }

    public static Position createPosition(final String position) {
        final int FILE_INDEX = 0;
        final int RANK_INDEX = 1;
        int file = position.charAt(FILE_INDEX) - 'a' + 1;
        int rank = getNumericValue(position.charAt(RANK_INDEX));
        return new Position(file, rank);
    }

    public static Position emptyPosition() {
        return new Position(0, 0);
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public int getFileIndex() {
        return file - 1;
    }

    public int getRankIndex() {
        return rank - 1;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return rank == position.rank && Objects.equals(file, position.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return String.format("%d%d", file, rank);
    }
}
