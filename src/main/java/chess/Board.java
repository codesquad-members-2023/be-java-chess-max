package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_LENGTH = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> blackPawns = new ArrayList<>();

    public Board() {
    }

    public void addWhitePawns(final Piece piece) {
        whitePawns.add(piece);
    }

    public void addBlackPawns(final Piece piece) {
        blackPawns.add(piece);
    }

    public void addWhitePieces(final Piece piece) {
        whitePieces.add(piece);
    }

    public void addBlackPieces(final Piece piece) {
        blackPieces.add(piece);
    }

    public String getWhitePawnsResult() {
        return createPiecesResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return createPiecesResult(blackPawns);
    }

    public String getWhitePiecesResult() {
        return createPiecesResult(whitePieces);
    }

    public String getBlackPiecesResult() {
        return createPiecesResult(blackPieces);
    }

    private String createPiecesResult(final List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece p : pieces) {
            sb.append(p.getRepresentation());
        }

        return sb.toString();
    }

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            addWhitePawns(Piece.createWhitePawn());
            addBlackPawns(Piece.createBlackPawn());
        }
        addWhitePieces(Piece.createWhiteRook());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteQueen());
        addWhitePieces(Piece.createWhiteKing());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteRook());
        addBlackPieces(Piece.createBlackRook());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackQueen());
        addBlackPieces(Piece.createBlackKing());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackRook());

        // TODO: output 클래스 분리
        printChessBoard();
    }

    public int pieceCount() {
        return (createChessBoard().replace(".", "").replace("\n", "")).length();
    }

    // TODO: 출력 메서드는 클래스 분리
    private void printChessBoard() {
        System.out.println(createChessBoard());
    }

    public String createChessBoard() {
        final String BLANK_LINE = "........";

        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));

        return sb.toString();
    }
}
