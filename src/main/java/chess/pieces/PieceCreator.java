package chess.pieces;

import chess.pieces.bishop.BlackBishop;
import chess.pieces.bishop.WhiteBishop;
import chess.pieces.king.BlackKing;
import chess.pieces.king.WhiteKing;
import chess.pieces.knight.BlackKnight;
import chess.pieces.knight.WhiteKnight;
import chess.pieces.pawn.BlackPawn;
import chess.pieces.pawn.WhitePawn;
import chess.pieces.queen.BlackQueen;
import chess.pieces.queen.WhiteQueen;
import chess.pieces.rook.BlackRook;
import chess.pieces.rook.WhiteRook;

public class PieceCreator {

    private PieceCreator() {
    }

    public static Piece create(Type type, Color color) {
        return switch (type) {
            case PAWN -> switch (color) {
                case WHITE -> new WhitePawn();
                case BLACK -> new BlackPawn();
                case NONE -> throw new IllegalArgumentException();
            };
            case KNIGHT -> switch (color) {
                case WHITE -> new WhiteKnight();
                case BLACK -> new BlackKnight();
                case NONE -> throw new IllegalArgumentException();
            };
            case ROOK -> switch (color) {
                case WHITE -> new WhiteRook();
                case BLACK -> new BlackRook();
                case NONE -> throw new IllegalArgumentException();
            };

            case BISHOP -> switch (color) {
                case WHITE -> new WhiteBishop();
                case BLACK -> new BlackBishop();
                case NONE -> throw new IllegalArgumentException();
            };
            case QUEEN -> switch (color) {
                case WHITE -> new WhiteQueen();
                case BLACK -> new BlackQueen();
                case NONE -> throw new IllegalArgumentException();
            };
            case KING -> switch (color) {
                case WHITE -> new WhiteKing();
                case BLACK -> new BlackKing();
                case NONE -> throw new IllegalArgumentException();
            };
            case BLANK -> new BlankPiece();
        };
    }
}
