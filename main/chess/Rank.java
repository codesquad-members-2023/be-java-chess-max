package chess;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rank {
    private final List<Piece> rank;

    private Rank(final List<Piece> rank) {
        this.rank = rank;
    }

    public int countPieces() {
        return (int) rank.stream().filter(piece -> piece.getType() != Piece.Type.BLANK).count();
    }

    public static Rank createBlankRank() {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createBlank()).collect(Collectors.toList()));
    }

    public static Rank initializeWhitePieces() {
        List<Piece> white = new ArrayList<>(8);

        white.add(Piece.createWhiteRook());
        white.add(Piece.createWhiteKnight());
        white.add(Piece.createWhiteBishop());
        white.add(Piece.createWhiteQueen());
        white.add(Piece.createWhiteKing());
        white.add(Piece.createWhiteBishop());
        white.add(Piece.createWhiteKnight());
        white.add(Piece.createWhiteRook());

        return new Rank(white);
    }

    public static Rank initializeWhitePawns() {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createWhitePawn()).collect(Collectors.toList()));
    }

    public static Rank initializeBlackPieces() {
        List<Piece> black = new ArrayList<>(8);

        black.add(Piece.createBlackRook());
        black.add(Piece.createBlackKnight());
        black.add(Piece.createBlackBishop());
        black.add(Piece.createBlackQueen());
        black.add(Piece.createBlackKing());
        black.add(Piece.createBlackBishop());
        black.add(Piece.createBlackKnight());
        black.add(Piece.createBlackRook());

        return new Rank(black);
    }

    public static Rank initializeBlackPawns() {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createBlackPawn()).collect(Collectors.toList()));
    }

    public String show() {
        return this.rank.stream().map(Piece::getRepresentation).collect(Collectors.joining());
    }

}
