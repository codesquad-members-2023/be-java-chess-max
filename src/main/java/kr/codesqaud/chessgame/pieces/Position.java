package kr.codesqaud.chessgame.pieces;

import static java.lang.Character.getNumericValue;
import static java.lang.Math.abs;

import java.util.Objects;
import kr.codesqaud.chessgame.exception.InvalidPositionException;

public class Position {

    private final int file;
    private final int rank;

    private Position(final int file, final int rank) {
        this.rank = rank;
        this.file = file;
    }

    public static Position createPosition(final String position) {
        validatePosition(position);
        final int FILE_INDEX = 0;
        final int RANK_INDEX = 1;
        int file = position.charAt(FILE_INDEX) - 'a' + 1;
        int rank = getNumericValue(position.charAt(RANK_INDEX));
        return new Position(file, rank);
    }

    private static void validatePosition(final String position) {
        // position 길이 검증
        if (position.length() != 2) {
            throw new InvalidPositionException("부적절한 위치 값입니다. : " + position);
        }
        // position File 입력값 범위 검증
        int file = position.charAt(0) - 'a' + 1;
        if (file < 1 || file > 8) {
            throw new InvalidPositionException("부적절한 File 값입니다. : " + file);
        }

        // position Rank 입력값 범위 검증
        int rank = getNumericValue(position.charAt(1));
        if (rank < 1 || rank > 8) {
            throw new InvalidPositionException("부적절한 Rank 값입니다. : " + rank);
        }
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

    /**
     * 두 위치간에 관계가 직선인지 확인합니다.
     * <p>
     * 직선 조건 : 같은 행 또는 같은 열에 있다면 직선입니다.
     */
    public boolean isStraight(final Position position) {
        // 같은 행에 있는 경우
        if (rank == position.rank) {
            return true;
        }
        // 같은 열에 있는 경우
        return file == position.file;
    }

    /**
     * 두 위치간에 관계가 대각선인지 판단
     * <p>
     * 대각선 조건 : 기울기가 1인 경우 = abs(x2 - x1) == abs(y2 - y1)
     */
    public boolean isDiagonal(final Position position) {
        return abs(file - position.file) == abs(rank - position.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
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
    public String toString() {
        return String.format("%d%d", file, rank);
    }

}
