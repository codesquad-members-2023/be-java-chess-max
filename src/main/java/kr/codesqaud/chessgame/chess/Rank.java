package kr.codesqaud.chessgame.chess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.pieces.Piece;

public class Rank implements Comparable<Rank> {

    private final List<Piece> pieces = new ArrayList<>(Board.SIZE);
    private final int value;

    public Rank(final int value) {
        this.value = value;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public List<Piece> getPieces() {
        return new ArrayList<>(pieces);
    }

    public String getPieceResult() {
        return pieces.stream()
            .map(Piece::getRepresentation)
            .collect(Collectors.joining());
    }

    @Override
    public int compareTo(final Rank rank) {
        return Integer.compare(value, rank.value);
    }
}
