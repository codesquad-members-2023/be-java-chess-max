import pieces.Piece;

public class Rank {

    private final Piece[] rank;

    public Rank() {
        this.rank = new Piece[8];
    }

    public static Rank initialize(int index) {
        switch (index) {
            case 8:
                return initialize8thRank();
            case 7:
                return initialize7thRank();
            case 2:
                return initialize2ndRank();
            case 1:
                return initialize1stRank();
            default:
                break;
        }
        return initializeEmptyRank();
    }

    private static Rank initialize8thRank() {
        Rank rank = new Rank();
        Piece one = Piece.createBlackRook();
        Piece two = Piece.createBlackKnight();
        Piece three = Piece.createBlackBishop();
        Piece four = Piece.createBlackQueen();
        Piece five = Piece.createBlackKing();
        Piece six = Piece.createBlackBishop();
        Piece seven = Piece.createBlackKnight();
        Piece eight = Piece.createBlackRook();
        rank.add(one, 0);
        rank.add(two, 1);
        rank.add(three, 2);
        rank.add(four, 3);
        rank.add(five, 4);
        rank.add(six, 5);
        rank.add(seven, 6);
        rank.add(eight, 7);

        return rank;
    }

    private static Rank initialize1stRank() {
        Rank rank = new Rank();
        Piece one = Piece.createWhiteRook();
        Piece two = Piece.createWhiteKnight();
        Piece three = Piece.createWhiteBishop();
        Piece four = Piece.createWhiteQueen();
        Piece five = Piece.createWhiteKing();
        Piece six = Piece.createWhiteBishop();
        Piece seven = Piece.createWhiteKnight();
        Piece eight = Piece.createWhiteRook();
        rank.add(one, 0);
        rank.add(two, 1);
        rank.add(three, 2);
        rank.add(four, 3);
        rank.add(five, 4);
        rank.add(six, 5);
        rank.add(seven, 6);
        rank.add(eight, 7);

        return rank;
    }

    private static Rank initialize7thRank() {
        Rank rank = new Rank();

        for (int i = 0; i < 8; i++) {
            Piece blackPawn = Piece.createBlackPawn();
            rank.add(blackPawn, i);
        }
        return rank;
    }

    private static Rank initialize2ndRank() {
        Rank rank = new Rank();

        for (int i = 0; i < 8; i++) {
            Piece whitePawn = Piece.createWhitePawn();
            rank.add(whitePawn, i);
        }
        return rank;
    }

    private static Rank initializeEmptyRank() {
        Rank rank = new Rank();

        for (int i = 0; i < 8; i++) {
            Piece whitePawn = Piece.createBlank();
            rank.add(whitePawn, i);
        }
        return rank;
    }

    public String getShape() {
        StringBuilder sb = new StringBuilder();

        for (Piece piece : rank) {
            sb.append(piece.getShape());
        }
        return sb.toString();
    }

    public void add(Piece piece, int index) {
        rank[index] = piece;
    }

    public Piece[] getRank() {
        return rank;
    }
}
