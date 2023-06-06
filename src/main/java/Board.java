import pieces.Piece;
import static utils.StringUtil.appendNewLine;

import java.util.ArrayList;

public class Board {

    private static final String EMPTY_LINE = "........";

    private final ArrayList<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public void initialize() {
        pieces.clear();
        addBlackPieces();
        addWhitePieces();
    }

    private void addBlackPieces() {
        addBlackPawns();
        addBlackRooks();
        addBlackKnights();
        addBlackBishops();
        addBlackQueen();
        addBlackKing();
    }

    private void addWhitePieces() {
        addWhitePawns();
        addWhiteRooks();
        addWhiteKnights();
        addWhiteBishops();
        addWhiteQueen();
        addWhiteKing();
    }

    private void addBlackPawns() {
        for (int i = 0; i < 8; i++) {
            Piece blackPawn = Piece.createBlackPawn();
            add(blackPawn);
        }
    }
    private void addBlackRooks() {
        for (int i = 0; i < 2; i++) {
            Piece blackRook = Piece.createBlackRook();
            add(blackRook);
        }
    }
    private void addBlackKnights() {
        for (int i = 0; i < 2; i++) {
            Piece blackKnight = Piece.createBlackKnight();
            add(blackKnight);
        }
    }
    private void addBlackBishops() {
        for (int i = 0; i < 2; i++) {
            Piece blackBishop = Piece.createBlackBishop();
            add(blackBishop);
        }
    }

    private void addBlackQueen() {
        Piece blackQueen = Piece.createBlackQueen();
        add(blackQueen);
    }


    private void addBlackKing() {
        Piece blackKing = Piece.createBlackKing();
        add(blackKing);
    }

    private void addWhitePawns() {
        for (int i = 0; i < 8; i++) {
            Piece whitePawn = Piece.createWhitePawn();
            add(whitePawn);
        }
    }

    private void addWhiteRooks() {
        for (int i = 0; i < 2; i++) {
            Piece whiteRook = Piece.createWhiteRook();
            add(whiteRook);
        }
    }

    private void addWhiteKnights() {
        for (int i = 0; i < 2; i++) {
            Piece whiteKnight = Piece.createWhiteKnight();
            add(whiteKnight);
        }
    }

    private void addWhiteBishops() {
        for (int i = 0; i < 2; i++) {
            Piece whiteBishop = Piece.createWhiteBishop();
            add(whiteBishop);
        }
    }

    private void addWhiteQueen() {
        Piece whiteQueen = Piece.createWhiteQueen();
        add(whiteQueen);
    }

    private void addWhiteKing() {
        Piece whiteKing = Piece.createWhiteKing();
        add(whiteKing);
    }

    public String print() {
        return appendNewLine(printBlackPieces()) +
                appendNewLine(printBlackPawns()) +
                appendNewLine(EMPTY_LINE) +
                appendNewLine(EMPTY_LINE) +
                appendNewLine(EMPTY_LINE) +
                appendNewLine(EMPTY_LINE) +
                appendNewLine(printWhitePawns()) +
                appendNewLine(printWhitePieces());
    }

    public String printBlackPieces() {
        return "RNBQKBNR";
    }

    public String printWhitePieces() {
        return "rnbqkbnr";
    }

    public String printBlackPawns() {
        StringBuilder sb = new StringBuilder();

        for (Piece piece : pieces) {
            if (piece.isBlackPawn()) {
                sb.append(piece.getFigure());
            }
        }
        return sb.toString();
    }

    public String printWhitePawns() {
        StringBuilder sb = new StringBuilder();

        for (Piece piece : pieces) {
            if (piece.isWhitePawn()) {
                sb.append(piece.getFigure());
            }
        }
        return sb.toString();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public boolean contains(Piece piece) {
        return pieces.contains(piece);
    }

    public int getSize() {
        return pieces.size();
    }
}
