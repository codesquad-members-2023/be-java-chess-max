package chess;

import chess.piece.Piece;
import chess.piece.Piece.Color;
import chess.piece.Piece.Type;
import chess.piece.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public String show() {
        final List<Rank> reversedBoard = new ArrayList<>(this.board);
        Collections.reverse(reversedBoard);
        return reversedBoard.stream().map(Rank::show).collect(Collectors.joining(NEW_LINE));
    }

}
