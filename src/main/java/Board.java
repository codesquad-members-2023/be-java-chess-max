import pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private static final String LINE_SEPERATOR = System.lineSeparator();
    private static final String EMPTY_LINE = "........" + LINE_SEPERATOR;

    private final ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void initialize() {
        pawns.clear();
        addBlackPawnSet();
        addWhitePawnSet();
    }

    private void addBlackPawnSet() {
        for (int i = 0; i < 8; i ++) {
            Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_FIGURE);
            add(black);
        }
    }

    private void addWhitePawnSet() {
        for (int i = 0; i < 8; i ++) {
            Pawn white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_FIGURE);
            add(white);
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(EMPTY_LINE);
        sb.append(printBlackPawns());
        sb.append(EMPTY_LINE);
        sb.append(EMPTY_LINE);
        sb.append(EMPTY_LINE);
        sb.append(EMPTY_LINE);
        sb.append(printWhitePawns());
        sb.append(EMPTY_LINE);
        return sb.toString();
    }

    public String printBlackPawns() {
        StringBuilder sb = new StringBuilder();

        for (Pawn pawn : pawns) {
            if (pawn.isBlack()) {
                sb.append(pawn.getFigure());
            }
        }
        sb.append(LINE_SEPERATOR);
        return sb.toString();
    }

    public String printWhitePawns() {
        StringBuilder sb = new StringBuilder();

        for (Pawn pawn : pawns) {
            if (pawn.isWhite()) {
                sb.append(pawn.getFigure());
            }
        }
        sb.append(LINE_SEPERATOR);
        return sb.toString();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public boolean contains(Pawn pawn) {
        return pawns.contains(pawn);
    }

    public int getSize() {
        return pawns.size();
    }
}
