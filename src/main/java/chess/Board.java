package chess;

import static chess.BoardUtility.RowInfoToString;
import static chess.BoardUtility.getRowInfo;
import static chess.BoardUtility.getRowScore;
import static chess.BoardUtility.initBoard;

import chess.pieces.BlankPiece;
import chess.pieces.Color;
import chess.pieces.Piece;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {

    private static final String NEXT_LINE = "\n";
    private static final String COLUMN_DELIMITER = "abcdefgh";

    private static final int LAST_LINE = 8;
    private Piece[][] pieces;

    public void initialize() {
        this.pieces = initBoard();
    }

    public String print() {
        var stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger(LAST_LINE);
        Arrays.stream(this.pieces)
                .map(getRowInfo())
                .forEach(RowInfoToString(stringBuilder, atomicInteger));
        stringBuilder.append(NEXT_LINE).append(COLUMN_DELIMITER);
        return stringBuilder.toString();
    }

    public Piece findPiece(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return pieces[row][column];
    }

    public void move(Position position, Piece piece) {
        int row = position.getRow();
        int column = position.getColumn();
        pieces[row][column] = piece;
    }

    public double calculatePoint(Color color) {
        return Arrays.stream(pieces)
                .map(getRowScore(color))
                .reduce((double) 0, Double::sum);
    }

    public void move(Position sourcePosition, Position targetPosition) {
        Piece target = findPiece(sourcePosition);
        move(sourcePosition, new BlankPiece());
        move(targetPosition, target);
    }

}
