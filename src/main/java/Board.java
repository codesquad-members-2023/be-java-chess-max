import pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private final ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void initialize() {
        addBlackPawnSet();
        addWhitePawnSet();
    }

    private void addBlackPawnSet() {
        for (int i = 0; i < 8; i ++) {
            Pawn black = new Pawn(Pawn.COLOR_BLACK, Pawn.BLACK_FIGURE);
            add(black);
        }
    }

    private void addWhitePawnSet() {
        for (int i = 0; i < 8; i ++) {
            Pawn black = new Pawn(Pawn.COLOR_WHITE, Pawn.WHITE_FIGURE);
            add(black);
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(printEmptyLine());
        sb.append(printBlackPawns());
        sb.append(printEmptyLine());
        sb.append(printEmptyLine());
        sb.append(printEmptyLine());
        sb.append(printEmptyLine());
        sb.append(printWhitePawns());
        sb.append(printEmptyLine());
        return sb.toString();
    }

    public String printBlackPawns() {
        StringBuilder sb = new StringBuilder();

        for (Pawn pawn : pawns) {
            if (pawn.getColor().equals("black")) {
                sb.append(pawn.getFigure());
            }
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public String printWhitePawns() {
        StringBuilder sb = new StringBuilder();

        for (Pawn pawn : pawns) {
            if (pawn.getColor().equals("white")) {
                sb.append(pawn.getFigure());
            }
        }
        sb.append("\r\n");
        return sb.toString();
    }

    private String printEmptyLine() {
        return "........\r\n";
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
