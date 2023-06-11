package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.PieceCreator;
import chess.pieces.Type;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public static final String NEXT_LINE = "\n";
    public static final String EMPTY_DELIMITER = ".";
    public static final String COLUMN_DELIMITER = "abcdefgh";
    public static final String SPACING = "  ";
    public static final String RANK_FORMAT = "%d (rank %d)";
    public static final int LAST_LINE = 8;
    public static final int FIRST_LINE = 1;
    private final Piece[][] pieces;

    public Board() {
        this.pieces = initialize();
    }


    private Piece[][] initialize() {
        Piece[][] pieces = new Piece[LAST_LINE][LAST_LINE];
        initMainPieces(pieces[0], Color.BLACK);
        initPawnPieces(pieces[FIRST_LINE], Color.BLACK);
        initPawnPieces(pieces[6], Color.WHITE);
        initMainPieces(pieces[7], Color.WHITE);
        return pieces;
    }

    private void initPawnPieces(Piece[] pieces, Color color) {
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = PieceCreator.create(Type.PAWN, color);
        }
    }

    private void initMainPieces(Piece[] pieces, Color color) {
        pieces[0] = PieceCreator.create(Type.ROOK, color);
        pieces[1] = PieceCreator.create(Type.KNIGHT, color);
        pieces[2] = PieceCreator.create(Type.BISHOP, color);
        pieces[3] = PieceCreator.create(Type.QUEEN, color);
        pieces[4] = PieceCreator.create(Type.KING, color);
        pieces[5] = PieceCreator.create(Type.BISHOP, color);
        pieces[6] = PieceCreator.create(Type.KNIGHT, color);
        pieces[7] = PieceCreator.create(Type.ROOK, color);
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

    private static Consumer<String> RowInfoToString(StringBuilder stringBuilder,
            AtomicInteger atomicInteger) {
        return s -> stringBuilder.append(s).append(SPACING)
                .append(getSuffix(atomicInteger)).append(NEXT_LINE);
    }

    private static Function<Piece[], String> getRowInfo() {
        return rowPieces -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(rowPieces)
                    .map(piece -> piece == null ? EMPTY_DELIMITER
                            : piece.getRepresentation().getValue())
                    .forEach(sb::append);
            return sb.toString();
        };
    }

    private static String getSuffix(AtomicInteger atomicInteger) {
        int index = atomicInteger.getAndDecrement();
        return index == LAST_LINE || index == FIRST_LINE ? String.format(RANK_FORMAT, index, index)
                : String.valueOf(index);
    }

    public Optional<Piece> findPiece(String targetPosition) {
        try {
            Position position = Position.parse(targetPosition);
            int row = position.getRow();
            int column = position.getColumn();
            Piece piece = pieces[row][column];
            return Optional.ofNullable(piece);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, e.getMessage());
            return Optional.empty();
        }
    }
}
