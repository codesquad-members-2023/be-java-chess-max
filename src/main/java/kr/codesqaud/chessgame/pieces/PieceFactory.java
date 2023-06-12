package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Type.BISHOP;
import static kr.codesqaud.chessgame.pieces.config.Type.KING;
import static kr.codesqaud.chessgame.pieces.config.Type.KNIGHT;
import static kr.codesqaud.chessgame.pieces.config.Type.NO_PIECE;
import static kr.codesqaud.chessgame.pieces.config.Type.PAWN;
import static kr.codesqaud.chessgame.pieces.config.Type.QUEEN;
import static kr.codesqaud.chessgame.pieces.config.Type.ROOK;

import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;

public class PieceFactory {

    private static PieceFactory instance;

    private PieceFactory() {

    }

    public static PieceFactory getInstance() {
        if (instance == null) {
            instance = new PieceFactory();
        }
        return instance;
    }

    public Piece createWhitePawn(Position position) {
        return createWhite(PAWN, position);
    }

    public Piece createBlackPawn(Position position) {
        return createBlack(PAWN, position);
    }

    public Piece createWhiteKnight(Position position) {
        return createWhite(KNIGHT, position);
    }

    public Piece createBlackKnight(Position position) {
        return createBlack(KNIGHT, position);
    }

    public Piece createWhiteRook(Position position) {
        return createWhite(ROOK, position);
    }

    public Piece createBlackRook(Position position) {
        return createBlack(ROOK, position);
    }

    public Piece createWhiteBishop(Position position) {
        return createWhite(BISHOP, position);
    }

    public Piece createBlackBishop(Position position) {
        return createBlack(BISHOP, position);
    }

    public Piece createWhiteQueen(Position position) {
        return createWhite(QUEEN, position);
    }

    public Piece createBlackQueen(Position position) {
        return createBlack(QUEEN, position);
    }

    public Piece createWhiteKing(Position position) {
        return createWhite(KING, position);
    }

    public Piece createBlackKing(Position position) {
        return createBlack(KING, position);
    }

    public Piece createBlank(Position position) {
        return new Piece(Color.NOCOLOR, NO_PIECE, position);
    }

    private Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, position);
    }

    private Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, position);
    }
}
