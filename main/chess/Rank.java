package chess;

import chess.piece.Bishop;
import chess.piece.Blank;
import chess.piece.Color;
import chess.piece.King;
import chess.piece.Knight;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Position;
import chess.piece.Queen;
import chess.piece.Rook;
import chess.piece.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.piece.Type.BLANK;

public class Rank {
    private final List<Piece> rank;

    private Rank(final List<Piece> rank) {
        this.rank = rank;
    }

    public int countPieces() {
        return (int) rank.stream().filter(piece -> !piece.isType(BLANK)).count();
    }

    public static Rank createBlankRank(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Blank.create(new Position(o, index))).collect(Collectors.toList()));
    }

    public static Rank initializeWhitePieces(int index) {
        List<Piece> white = new ArrayList<>(8);

        white.add(Rook.createWhite(new Position(0, index)));
        white.add(Knight.createWhite(new Position(1, index)));
        white.add(Bishop.createWhite(new Position(2, index)));
        white.add(Queen.createWhite(new Position(3, index)));
        white.add(King.createWhite(new Position(4, index)));
        white.add(Bishop.createWhite(new Position(5, index)));
        white.add(Knight.createWhite(new Position(6, index)));
        white.add(Rook.createWhite(new Position(7, index)));

        return new Rank(white);
    }

    public static Rank initializeWhitePawns(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Pawn.createWhite(new Position(o, index))).collect(Collectors.toList()));
    }

    public static Rank initializeBlackPieces(int index) {
        List<Piece> black = new ArrayList<>(8);

        black.add(Rook.createBlack(new Position(0, index)));
        black.add(Knight.createBlack(new Position(1, index)));
        black.add(Bishop.createBlack(new Position(2, index)));
        black.add(Queen.createBlack(new Position(3, index)));
        black.add(King.createBlack(new Position(4, index)));
        black.add(Bishop.createBlack(new Position(5, index)));
        black.add(Knight.createBlack(new Position(6, index)));
        black.add(Rook.createBlack(new Position(7, index)));

        return new Rank(black);
    }

    public static Rank initializeBlackPawns(int index) {
        return new Rank(IntStream.range(0, 8).mapToObj(o -> Pawn.createBlack(new Position(o, index))).collect(Collectors.toList()));
    }

    public int countPiecesByColorAndType(Color color, Type type) {
        return (int) this.rank
                .stream()
                .filter(piece -> piece.isType(type) && piece.isColor(color))
                .count();
    }

    public Piece findPiece(int indexX) {
        return rank.get(indexX);
    }

    public List<Piece> findPiecesByColor(final Color color) {
        return this.rank.stream().filter(piece -> piece.isColor(color)).collect(Collectors.toList());
    }

    public String show() {
        return this.rank.stream().map(Piece::getRepresentation).collect(Collectors.joining());
    }

    public void put(final int indexX, final Piece piece) {
        this.rank.set(indexX, piece);
    }
}
