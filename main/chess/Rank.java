package chess;

import chess.piece.Piece;
import chess.piece.Piece.Color;
import chess.piece.Piece.Type;
import chess.piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.piece.Piece.Type.BLANK;

public class Rank {
    private final List<Piece> rank;

    private Rank(final List<Piece> rank) {
        this.rank = rank;
    }

    public int countPieces() {
        return (int) rank.stream().filter(piece -> piece.getType() != BLANK).count();
    }

    public static Rank createBlankRank(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createBlank(new Position(o, index))).collect(Collectors.toList()));
    }

    public static Rank initializeWhitePieces(int index) {
        List<Piece> white = new ArrayList<>(8);

        white.add(Piece.createWhiteRook(new Position(0, index)));
        white.add(Piece.createWhiteKnight(new Position(1, index)));
        white.add(Piece.createWhiteBishop(new Position(2, index)));
        white.add(Piece.createWhiteQueen(new Position(3, index)));
        white.add(Piece.createWhiteKing(new Position(4, index)));
        white.add(Piece.createWhiteBishop(new Position(5, index)));
        white.add(Piece.createWhiteKnight(new Position(6, index)));
        white.add(Piece.createWhiteRook(new Position(7, index)));

        return new Rank(white);
    }

    public static Rank initializeWhitePawns(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createWhitePawn(new Position(o, index))).collect(Collectors.toList()));
    }

    public static Rank initializeBlackPieces(int index) {
        List<Piece> black = new ArrayList<>(8);

        black.add(Piece.createBlackRook(new Position(0, index)));
        black.add(Piece.createBlackKnight(new Position(1, index)));
        black.add(Piece.createBlackBishop(new Position(2, index)));
        black.add(Piece.createBlackQueen(new Position(3, index)));
        black.add(Piece.createBlackKing(new Position(4, index)));
        black.add(Piece.createBlackBishop(new Position(5, index)));
        black.add(Piece.createBlackKnight(new Position(6, index)));
        black.add(Piece.createBlackRook(new Position(7, index)));

        return new Rank(black);
    }

    public static Rank initializeBlackPawns(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Piece.createBlackPawn(new Position(o, index))).collect(Collectors.toList()));
    }

    public int countPiecesByColorAndType(Color color, Type type) {
        return (int) this.rank
                .stream()
                .filter(piece -> piece.getType().equals(type) && piece.getColor().equals(color))
                .count();
    }

    public Piece findPiece(int indexX) {
        return rank.get(indexX);
    }

    public String show() {
        return this.rank.stream().map(Piece::getRepresentation).collect(Collectors.joining());
    }

    public void move(final int indexX, final Piece piece) {
        this.rank.set(indexX, piece);
    }
}
