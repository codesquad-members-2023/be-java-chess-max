package kr.codesqaud.chessgame.pieces;

import java.util.Objects;

public class Position {

    private final String file;
    private final int rank;

    private Position(final String file, final int rank) {
        this.rank = rank;
        this.file = file;
    }

    public static Position createPosition(final String position) {
        final int FILE_INDEX = 0;
        final int RANK_INDEX = 1;
        String file = position.split("")[FILE_INDEX];
        int rank = Integer.parseInt(position.split("")[RANK_INDEX]);
        return new Position(file, rank);
    }

    public static Position emptyPosition() {
        return new Position(" ", 0);
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
        return file + rank;
    }
}
