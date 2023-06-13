package chess.view;

import chess.Board;
import chess.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static chess.util.StringUtil.NEW_LINE;

public class ChessView {

    public String view(final Board board) {
        final List<Rank> ranks = new ArrayList<>(board.getRanks());
        Collections.reverse(ranks);
        return ranks.stream().map(Rank::show).collect(Collectors.joining(NEW_LINE));
    }

}
