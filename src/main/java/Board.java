import java.util.ArrayList;

public class Board {

    private final ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
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
