package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static kr.codesqaud.chessgame.utils.StringUtils.*;

public class Board {

    private static final int SIZE = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();
    private final List<Piece> blackPawns = new ArrayList<>();

    private int pieceCount = 0;

    private void addWhitePiece(final Piece piece) {
        pieceCount++;
        whitePieces.add(piece);
    }

    private void addBlackPiece(final Piece piece) {
        pieceCount++;
        blackPieces.add(piece);
    }

    private void addWhitePawn(final Piece piece) {
        pieceCount++;
        whitePawns.add(piece);
    }

    private void addBlackPawn(final Piece piece) {
        pieceCount++;
        blackPawns.add(piece);
    }

    public int size() {
        return pieceCount;
    }

    public void initialize() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
        for (int i = 0; i < SIZE; i++) {
            addBlackPawn(Piece.createBlackPawn());
            addWhitePawn(Piece.createWhitePawn());
        }
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    private String getWhitePawnsResult() {
        return getPawnsResult(whitePawns, Color.WHITE);
    }

    private String getBlackPawnsResult() {
        return getPawnsResult(blackPawns, Color.BLACK);
    }

    private String getPawnsResult(List<Piece> pawns, Color color) {
        return pawns.stream()
            .filter(piece -> piece.getColor().equals(color))
            .map(Piece::getRepresentation)
            .collect(Collectors.joining());
    }

    private String getWhitePieceResult() {
        return getPieceResult(whitePieces);
    }

    private String getBlackPieceResult() {
        return getPieceResult(blackPieces);
    }

    private String getPieceResult(List<Piece> pieces) {
        return pieces.stream()
            .map(Piece::getRepresentation)
            .collect(Collectors.joining());
    }

    public String showBoard() {
        String blankRank = "........";
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlackPieceResult()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(blankRank));
        sb.append(appendNewLine(blankRank));
        sb.append(appendNewLine(blankRank));
        sb.append(appendNewLine(blankRank));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getWhitePieceResult()));
        return sb.toString();
    }
}
