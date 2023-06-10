package chess;

import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private ArrayList<Piece> rank;

    private Rank() {
        rank = new ArrayList<>();
    }

    public static Rank createFirstRank(Color color) {
        Rank rank = new Rank();
        if (color.equals(Color.BLACK)) {
            int yPos = 7;
            rank.addPiece(Rook.createBlack(new Position(0, yPos)));
            rank.addPiece(Knight.createBlack(new Position(1, yPos)));
            rank.addPiece(Bishop.createBlack(new Position(2, yPos)));
            rank.addPiece(Queen.createBlack(new Position(3, yPos)));
            rank.addPiece(King.createBlack(new Position(4, yPos)));
            rank.addPiece(Bishop.createBlack(new Position(5, yPos)));
            rank.addPiece(Knight.createBlack(new Position(6, yPos)));
            rank.addPiece(Rook.createBlack(new Position(7, yPos)));
        } else {
            int yPos = 0;
            rank.addPiece(Rook.createWhite(new Position(0, yPos)));
            rank.addPiece(Knight.createWhite(new Position(1, yPos)));
            rank.addPiece(Bishop.createWhite(new Position(2, yPos)));
            rank.addPiece(Queen.createWhite(new Position(3, yPos)));
            rank.addPiece(King.createWhite(new Position(4, yPos)));
            rank.addPiece(Bishop.createWhite(new Position(5, yPos)));
            rank.addPiece(Knight.createWhite(new Position(6, yPos)));
            rank.addPiece(Rook.createWhite(new Position(7, yPos)));
        }
        return rank;
    }

    public static Rank createPawnRank(Color color) {
        Rank rank = new Rank();
        if (color.equals(Color.BLACK)) {
            for (int i = 0; i < 8; i++) {
                rank.addPiece(Pawn.createBlack(new Position(i, 6)));
            }
        } else {
            for (int i = 0; i < 8; i++) {
                rank.addPiece(Pawn.createWhite(new Position(i, 1)));
            }
        }
        return rank;
    }

    public static Rank createBlankRank(int index) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Blank.createBlank(new Position(i, index)));
        }
        return rank;
    }

    public Piece getPiece(int index) {
        return rank.get(index);
    }

    public void addPiece(Piece piece) {
        rank.add(piece);
    }

    public void addPiece(int index, Piece piece) {
        rank.set(index, piece);
    }

    public int getPieceCount() {
        int pieceCount = 0;
        for (Piece piece : rank) {
            if (piece.getType() != Type.NO_PIECE) {
                pieceCount += 1;
            }
        }
        return pieceCount;
    }

    public int getPieceCount(Color color, Type type) {
        int pieceCount = 0;
        for (Piece piece : rank) {
            if (piece.matchColor(color) && piece.matchType(type)) {
                pieceCount += 1;
            }
        }
        return pieceCount;
    }

    public String getRankString() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : rank) {
            if (piece.matchColor(color)) {
                pieces.add(piece);
            }
        }
        return pieces;
    }
}
