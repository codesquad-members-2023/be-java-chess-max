package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.StringUtil.NEW_LINE;

public class Board {

    private final List<Rank> board;

    public Board() {
        this.board = new ArrayList<>(8);
    }

    public void initialize() {
        board.add(Rank.initializeBlackPieces());
        board.add(Rank.initializeBlackPawns());
        board.addAll(IntStream.range(0, 4).mapToObj(o -> Rank.createBlankRank()).collect(Collectors.toList()));
        board.add(Rank.initializeWhitePawns());
        board.add(Rank.initializeWhitePieces());
    }

    public int countPieces() {
        return board.stream().mapToInt(Rank::countPieces).sum();
    }

    public String show() {
        return board.stream().map(Rank::show).collect(Collectors.joining(NEW_LINE));
    }

}
