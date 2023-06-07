import utils.StringUtil;

import static utils.StringUtil.appendNewLine;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Integer, Rank> pieces;

    public Board() {
        this.pieces = new HashMap<>();
    }

    public void initialize() {
        pieces.clear();
        for (int i = 1; i < 9; i++) {
            Rank rank = Rank.initialize(i);

            pieces.put(i, rank);
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        for (int key = 8; key > 0; key--) {
            Rank rank = pieces.get(key);
            String rawShape = rank.getShape();
            String editedShape = StringUtil.appendNewLine(rawShape);

            sb.append(editedShape);
        }
        return sb.toString();
    }

    public int getSize() {
        return pieces.size();
    }
}
