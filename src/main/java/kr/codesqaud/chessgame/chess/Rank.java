package kr.codesqaud.chessgame.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;

public class Rank implements Comparable<Rank> {

    private final List<Piece> pieces = new ArrayList<>(ChessBoard.SIZE);
    private final int value;

    public Rank(final int value) {
        this.value = value;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void setPiece(final int file, final Piece piece) {
        pieces.set(file, piece);
    }

    public Piece findPiece(final int file) {
        return pieces.get(file);
    }

    public String getPieceResult() {
        return pieces.stream()
            .map(Piece::getRepresentation)
            .collect(Collectors.joining());
    }

    public int getPieceCount(final Color color, final Type type) {
        return (int) pieces.stream()
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .filter(piece -> Objects.equals(piece.getType(), type))
            .count();
    }

    public boolean isMatchRank(int rank) {
        return this.value == rank;
    }

    @Override
    public int compareTo(final Rank rank) {
        return Integer.compare(value, rank.value);
    }


}
