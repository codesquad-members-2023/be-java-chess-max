import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

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
        rank.insert(one, 'a');
        rank.insert(two, 'b');
        rank.insert(three, 'c');
        rank.insert(four, 'd');
        rank.insert(five, 'e');
        rank.insert(six, 'f');
        rank.insert(seven, 'g');
        rank.insert(eight, 'h');

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
        rank.insert(one, 'a');
        rank.insert(two, 'b');
        rank.insert(three, 'c');
        rank.insert(four, 'd');
        rank.insert(five, 'e');
        rank.insert(six, 'f');
        rank.insert(seven, 'g');
        rank.insert(eight, 'h');

        return rank;
    }

    private static Rank initialize7thRank() {
        Rank rank = new Rank();

        for (char ch = 'a'; ch < 'i'; ch++) {
            Piece blackPawn = Piece.createBlackPawn();
            rank.insert(blackPawn, ch);
        }
        return rank;
    }

    private static Rank initialize2ndRank() {
        Rank rank = new Rank();

        for (char ch = 'a'; ch < 'i'; ch++) {
            Piece whitePawn = Piece.createWhitePawn();
            rank.insert(whitePawn, ch);
        }
        return rank;
    }

    private static Rank initializeEmptyRank() {
        Rank rank = new Rank();

        for (char ch = 'a'; ch < 'i'; ch++) {
            Piece Blank = Piece.createBlank();
            rank.insert(Blank, ch);
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

    public Piece getPieceAt(char index) {
        int intIndex = index - 'a';

        return rank[intIndex];
    }

    public void insert(Piece piece, char index) {
        int intIndex = index - 'a';
        rank[intIndex] = piece;
    }

    public int countBlack() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isBlack()) {
                count += 1;
            }
        }
        return count;
    }

    public int countWhite() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isWhite()) {
                count += 1;
            }
        }
        return count;
    }

    public int countPawn() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isPawn()) {
                count += 1;
            }
        }
        return count;
    }

    public int countKnight() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isKnight()) {
                count += 1;
            }
        }
        return count;
    }

    public int countBishop() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isBishop()) {
                count += 1;
            }
        }
        return count;
    }

    public int countQueen() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isQueen()) {
                count += 1;
            }
        }
        return count;
    }

    public int countKing() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isKing()) {
                count += 1;
            }
        }
        return count;
    }

    public int countBlank() {
        int count = 0;

        for (Piece piece : rank) {
            if (piece.isBlank()) {
                count += 1;
            }
        }
        return count;
    }

    public double calculateOtherPiecesScore(Piece.Color color) {
        double score = 0;

        for (Piece piece : rank) {
            if (piece.isColor(color) && !piece.isPawn()) {
                score += piece.getScore();
            }
        }
        return score;
    }

    public List<Character> getPawnIndex(Piece.Color color) {
        List<Character> index = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            if (rank[i].isColor(color) && rank[i].isPawn()) {
                index.add((char) ('a' + i));
            }
        }
        return index;
    }

    public Piece[] getRank() {
        return rank;
    }
}
