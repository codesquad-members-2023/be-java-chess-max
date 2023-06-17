package kr.codesqaud.chessgame.chess.board;

import static kr.codesqaud.chessgame.chess.pieces.Position.createPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.chess.pieces.Bishop;
import kr.codesqaud.chessgame.chess.pieces.Blank;
import kr.codesqaud.chessgame.chess.pieces.King;
import kr.codesqaud.chessgame.chess.pieces.Knight;
import kr.codesqaud.chessgame.chess.pieces.Pawn;
import kr.codesqaud.chessgame.chess.pieces.Piece;
import kr.codesqaud.chessgame.chess.pieces.Queen;
import kr.codesqaud.chessgame.chess.pieces.Rook;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rank implements Comparable<Rank> {

    private static final Logger logger = LoggerFactory.getLogger(Rank.class);

    private final List<Piece> pieces = new ArrayList<>(ChessBoard.SIZE);
    private final int value;

    public Rank(final int value) {
        this.value = value;
    }

    public static Rank initializeBlankLine(final int rankValue) {
        Rank rank = new Rank(rankValue);
        for (int i = 1; i <= Board.SIZE; i++) {
            rank.addPiece(Blank.create(createPosition(i, rankValue)));
        }
        return rank;
    }

    public static Rank initializeWhitePieces(final int rankValue) {
        Rank rank = new Rank(rankValue);
        rank.addPiece(Rook.createWhite(createPosition(1, rankValue)));
        rank.addPiece(Knight.createWhite(createPosition(2, rankValue)));
        rank.addPiece(Bishop.createWhite(createPosition(3, rankValue)));
        rank.addPiece(Queen.createWhite(createPosition(4, rankValue)));
        rank.addPiece(King.createWhite(createPosition(5, rankValue)));
        rank.addPiece(Bishop.createWhite(createPosition(6, rankValue)));
        rank.addPiece(Knight.createWhite(createPosition(7, rankValue)));
        rank.addPiece(Rook.createWhite(createPosition(8, rankValue)));
        return rank;
    }

    public static Rank initializeWhitePawns(final int rankValue) {
        Rank rank = new Rank(rankValue);
        for (int i = 1; i <= Board.SIZE; i++) {
            rank.addPiece(Pawn.createWhite(createPosition(i, rankValue)));
        }
        return rank;
    }

    public static Rank initializeBlackPawns(final int rankValue) {
        Rank rank = new Rank(rankValue);
        for (int i = 1; i <= Board.SIZE; i++) {
            rank.addPiece(Pawn.createBlack(createPosition(i, rankValue)));
        }
        return rank;
    }

    public static Rank initializeBlackPieces(final int rankValue) {
        Rank rank = new Rank(rankValue);
        rank.addPiece(Rook.createBlack(createPosition(1, rankValue)));
        rank.addPiece(Knight.createBlack(createPosition(2, rankValue)));
        rank.addPiece(Bishop.createBlack(createPosition(3, rankValue)));
        rank.addPiece(Queen.createBlack(createPosition(4, rankValue)));
        rank.addPiece(King.createBlack(createPosition(5, rankValue)));
        rank.addPiece(Bishop.createBlack(createPosition(6, rankValue)));
        rank.addPiece(Knight.createBlack(createPosition(7, rankValue)));
        rank.addPiece(Rook.createBlack(createPosition(8, rankValue)));
        return rank;
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
            .map(Piece::getSymbol)
            .map(symbol -> symbol.replaceAll("[&#;]", ""))
            .mapToInt(Integer::parseInt)
            .mapToObj(num -> (char) num)
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

    public int getPieceCount(final Color color, final Type type) {
        return (int) pieces.stream()
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .filter(piece -> Objects.equals(piece.getType(), type))
            .count();
    }

    public int countPieces() {
        return (int) pieces.stream()
            .filter(piece -> !Objects.equals(piece.getType(), Type.NO_PIECE))
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
