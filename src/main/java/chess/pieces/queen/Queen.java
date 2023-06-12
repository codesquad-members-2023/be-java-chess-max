package chess.pieces.queen;

import static chess.pieces.PieceUtility.getDirectDirectionPositions;

import chess.Board;
import chess.Position;
import chess.pieces.Color;
import chess.pieces.DefaultPiece;
import chess.pieces.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public abstract class Queen extends DefaultPiece {

    private static final List<Position> directions = List.of(
            new Position(-1, -1),
            new Position(-1, 0),
            new Position(-1, 1),
            new Position(0, 1),
            new Position(1, 1),
            new Position(1, 0),
            new Position(1, -1),
            new Position(0, -1)
    );

    public Queen(Color color) {
        super(color);
    }

    public double getScore() {
        return Type.QUEEN.getScore();
    }

    @Override
    public Position[] getCanMovePositions(Position position, Board board) {
        return directions.stream()
                .map(direction -> getDirectDirectionPositions(position, board,
                        getColor(), direction, 8))
                .reduce((Position[] a, Position[] b) ->
                        Stream.concat(Arrays.stream(a), Arrays.stream(b))
                                .toArray(Position[]::new))
                .orElse(new Position[0]);
    }
}
