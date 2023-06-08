package chess.piece;

import chess.Color;
import chess.Name;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static chess.Name.BISHOP;
import static chess.Name.KING;
import static chess.Name.KNIGHT;
import static chess.Name.PAWN;
import static chess.Name.QUEEN;
import static chess.Name.ROOK;

public class Piece {

    private final Color color;
    private final Name name;
    private final String representation;
    public static final String WHITE_PAWN= "p";
    public static final String BLACK_PAWN = "P";
    public static final String WHITE_KNIGHT= "n";
    public static final String BLACK_KNIGHT = "N";
    public static final String WHITE_ROOK = "r";
    public static final String BLACK_ROOK = "R";
    public static final String WHITE_BISHOP = "b";
    public static final String BLACK_BISHOP = "B";
    public static final String WHITE_QUEEN= "q";
    public static final String BLACK_QUEEN = "Q";
    public static final String WHITE_KING = "k";
    public static final String BLACK_KING = "K";

    public static Piece createWhitePawn() {
        return new Piece(WHITE, PAWN, WHITE_PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK, PAWN, BLACK_PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE, KNIGHT, WHITE_KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK, KNIGHT, BLACK_KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE, ROOK, WHITE_ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK, ROOK, BLACK_ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE, BISHOP, WHITE_BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK, BISHOP, BLACK_BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE, QUEEN, WHITE_QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK, QUEEN, BLACK_QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE, KING, WHITE_KING);
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK, KING, BLACK_KING);
    }

    private Piece(Color color, Name name, String representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;
    }

    public Color getColor() {
        return this.color;
    }

    public Name getName() {
        return this.name;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public boolean isBlack() {
        return this.color.equals(BLACK);
    }

    public boolean isWhite() {
        return this.color.equals(WHITE);
    }

}
