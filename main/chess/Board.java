package chess;

import chess.piece.Blank;
import chess.piece.Color;
import chess.piece.Piece;
import chess.piece.Position;
import chess.piece.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.piece.Type.PAWN;
import static chess.util.StringUtil.NEW_LINE;

public class Board {

    private final List<Rank> board;

    public Board() {
        this.board = new ArrayList<>(8);
    }

    public void initialize() {
        board.add(Rank.initializeWhitePieces(0));
        board.add(Rank.initializeWhitePawns(1));
        board.addAll(IntStream.range(0, 4).mapToObj(o -> Rank.createBlankRank(o + 2)).collect(Collectors.toList()));
        board.add(Rank.initializeBlackPawns(6));
        board.add(Rank.initializeBlackPieces(7));
    }

    public void initializeEmpty() {
        board.addAll(IntStream.range(0, 8).mapToObj(Rank::createBlankRank).collect(Collectors.toList()));
    }

    public int countPieces() {
        return board.stream().mapToInt(Rank::countPieces).sum();
    }

    public int countPiecesByColorAndType(Color color, Type type) {
        return board.stream().mapToInt(rank -> rank.countPiecesByColorAndType(color, type)).sum();
    }

    public Piece findPiece(String position) {
        final Position findPosition = new Position(position);
        return board.get(findPosition.getIndexY()).findPiece(findPosition.getIndexX());
    }

    public List<Piece> findPiecesByColor(Color color) {
        return board.stream().flatMap(rank -> rank.findPiecesByColor(color).stream()).collect(Collectors.toList());
    }

    public String show() {
        final List<Rank> reversedBoard = new ArrayList<>(this.board);
        Collections.reverse(reversedBoard);
        return reversedBoard.stream().map(Rank::show).collect(Collectors.joining(NEW_LINE));
    }

    public void put(final String position, final Piece piece) {
        final Position targetPosition = new Position(position);
        board.get(targetPosition.getIndexY()).put(targetPosition.getIndexX(), piece);
    }

    public void put(final Position targetPosition, final Piece piece) {
        board.get(targetPosition.getIndexY()).put(targetPosition.getIndexX(), piece);
    }

    public void move(final String sourcePosition, final String targetPosition) {
        final Piece sourcePiece = findPiece(sourcePosition);
        sourcePiece.setPosition(new Position(targetPosition));
        put(sourcePosition, Blank.create(new Position(sourcePosition)));
        put(targetPosition, sourcePiece);
    }

    public double calculatePoint(final Color color) {
        return findPiecesByColor(color).stream().mapToDouble(Piece::getPoint).sum() - calculateSameColorPawnInColumn(color);
    }

    public double calculateSameColorPawnInColumn(final Color color) {
        final List<Integer> indexes = findPiecesByColor(color)
                .stream().filter(piece -> piece.isType(PAWN))
                .map(piece -> piece.getPosition().getIndexX())
                .collect(Collectors.toUnmodifiableList());

        Map<Integer, Integer> count = new HashMap<>();
        for (Integer index : indexes) {
            count.put(index, count.getOrDefault(index, 0) + 1);
        }

        final int countPawns = count.values().stream().mapToInt(i -> i).filter(o -> o > 1).sum();
        return 0.5 * countPawns;
    }
}
