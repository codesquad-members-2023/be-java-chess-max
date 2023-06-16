package kr.codesqaud.chessgame.chess.pieces;

import static java.lang.Character.getNumericValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.exception.InvalidPositionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Position {

    private static final Logger logger = LoggerFactory.getLogger(Position.class);

    private final int file;
    private final int rank;

    public Position(final int file, final int rank) {
        this.rank = rank;
        this.file = file;
    }

    public static Position createPosition(final int file, final int rank) {
        String position = String.format("%s%d", (char) ('a' + file - 1), rank);
        return createPosition(position);
    }

    public static Position createPosition(final String position) {
        try {
            validatePosition(position);
        } catch (InvalidPositionException e) {
            return emptyPosition();
        }

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

    public Direction direction(final Position position) {
        return Direction.valueOf(position.rank - rank, position.file - file);
    }


    public Degree degree(final Position position) {
        return new Degree(position.rank - this.rank, position.file - this.file);
    }

    public boolean empty() {
        return file == 0 && rank == 0;
    }

    public Position move(final Direction direction) {
        try {
            return createPosition(file + direction.getxDegree(), rank + direction.getyDegree());
        } catch (InvalidPositionException e) {
            return emptyPosition();
        }
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
        return String.format("%s%d", (char) ('a' + file - 1), rank);
    }

    @JsonIgnore
    public List<Position> getColumnNeighbors() {
        List<Position> columnNeighbors = new ArrayList<>();
        Position position = createPosition(rank - 1, file);

        if (!position.empty()) {
            columnNeighbors.add(position);
        }

        position = createPosition(rank + 1, file);
        if (!position.empty()) {
            columnNeighbors.add(position);
        }
        return columnNeighbors;
    }

    public List<Position> getMovablePositions(final Direction direction, final Piece target) {
        List<Position> movablePositions = new ArrayList<>();
        getMovablePositions(movablePositions, direction, target);
        return movablePositions;
    }

    private void getMovablePositions(final List<Position> movablePositions, final Direction direction,
        final Piece target) {
        Position movablePosition = move(direction);
        if (!movablePosition.equals(target.getPosition())) {
            movablePositions.add(movablePosition);
            movablePosition.getMovablePositions(movablePositions, direction, target);
        }
    }

    public String getCharPosition() {
        return String.format("%s%d", (char) ('a' + file - 1), rank);
    }
}
