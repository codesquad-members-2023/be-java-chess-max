package chess;

import chess.pieces.BlankPiece;
import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.PieceCreator;
import chess.pieces.Type;
import chess.pieces.pawn.Pawn;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

public class BoardUtility {

    private static final String SPACING = "  ";
    private static final String RANK_FORMAT = "%d (rank %d)";
    private static final int FIRST_LINE = 1;
    private static final String NEXT_LINE = "\n";
    private static final int LAST_LINE = 8;


    private BoardUtility() {
    }

    static void initPawnPieces(Piece[] pieces, Color color) {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = PieceCreator.create(Type.PAWN, color);
        }
    }

    static void initMainPieces(Piece[] pieces, Color color) {
        pieces[0] = PieceCreator.create(Type.ROOK, color);
        pieces[1] = PieceCreator.create(Type.KNIGHT, color);
        pieces[2] = PieceCreator.create(Type.BISHOP, color);
        pieces[3] = PieceCreator.create(Type.QUEEN, color);
        pieces[4] = PieceCreator.create(Type.KING, color);
        pieces[5] = PieceCreator.create(Type.BISHOP, color);
        pieces[6] = PieceCreator.create(Type.KNIGHT, color);
        pieces[7] = PieceCreator.create(Type.ROOK, color);
    }

    static Consumer<String> RowInfoToString(StringBuilder stringBuilder,
            AtomicInteger atomicInteger) {
        return s -> stringBuilder.append(s).append(SPACING)
                .append(getSuffix(atomicInteger)).append(NEXT_LINE);
    }

    static Function<Piece[], String> getRowInfo() {
        return rowPieces -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(rowPieces)
                    .map(Piece::getRepresentation)
                    .forEach(sb::append);
            return sb.toString();
        };
    }

    private static String getSuffix(AtomicInteger atomicInteger) {
        int index = atomicInteger.getAndDecrement();
        return index == LAST_LINE || index == FIRST_LINE ? String.format(RANK_FORMAT, index, index)
                : String.valueOf(index);
    }

    static Function<Piece[], Double> getRowScore(Color color) {
        return pieceRow -> {
            Double sum = getTotalRowScore(color, pieceRow);
            Double pawn = getTotalRowPawnScore(color, pieceRow);
            if (sum.equals(pawn)) {
                return sum;
            }
            return sum - (pawn / 2);
        };
    }

    private static Double getTotalRowPawnScore(Color color, Piece[] pieceRow) {
        return Arrays.stream(pieceRow)
                .filter(piece -> piece instanceof Pawn)
                .filter(piece -> piece.verifyColor(color))
                .map(Piece::getScore)
                .reduce((double) 0, Double::sum);
    }

    private static Double getTotalRowScore(Color color, Piece[] pieceRow) {
        return Arrays.stream(pieceRow)
                .map(piece -> piece == null || !piece.verifyColor(color)
                        ? 0
                        : piece.getScore())
                .reduce((double) 0, Double::sum);
    }

    static void initAllToBlankPiece(Piece[][] pieces) {
        for (Piece[] rowPieces : pieces) {
            for (int i = 0; i < LAST_LINE; i++) {
                rowPieces[i] = new BlankPiece();
            }
        }
    }

    static Piece[][] initBoard() {
        Piece[][] pieces = new Piece[LAST_LINE][LAST_LINE];
        initAllToBlankPiece(pieces);
        initMainPieces(pieces[0], Color.BLACK);
        initPawnPieces(pieces[1], Color.BLACK);
        initPawnPieces(pieces[6], Color.WHITE);
        initMainPieces(pieces[7], Color.WHITE);
        return pieces;
    }
}
