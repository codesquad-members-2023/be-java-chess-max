package chess;

import static chess.BoardUtility.RowInfoToString;
import static chess.BoardUtility.getRowInfo;
import static chess.BoardUtility.getRowScore;

import chess.pieces.Color;
import chess.pieces.Piece;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ChessView {

    private static final String NEXT_LINE = "\n";
    private static final String COLUMN_DELIMITER = "abcdefgh";
    private static final int LAST_LINE = 8;

    private ChessView() {
    }

    static String print(Piece[][] pieces) {
        var stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger(LAST_LINE);
        Arrays.stream(pieces)
                .map(getRowInfo())
                .forEach(RowInfoToString(stringBuilder, atomicInteger));
        stringBuilder.append(NEXT_LINE)
                .append(COLUMN_DELIMITER)
                .append(NEXT_LINE)
                .append(NEXT_LINE)
                .append(Color.WHITE.name())
                .append(" : ")
                .append(calculatePoint(Color.WHITE, pieces)).append("점")
                .append(NEXT_LINE)
                .append(Color.BLACK.name())
                .append(" : ")
                .append(calculatePoint(Color.BLACK, pieces)).append("점")
                .append(NEXT_LINE);
        return stringBuilder.toString();
    }

    static double calculatePoint(Color color, Piece[][] pieces) {
        return Arrays.stream(pieces)
                .map(getRowScore(color))
                .reduce((double) 0, Double::sum);
    }
}
