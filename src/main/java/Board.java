
import pieces.Piece;

import static utils.StringUtil.appendNewLine;

import java.util.*;

public class Board {

    private final Map<Integer, Rank> pieces;

    public Board() {
        this.pieces = new HashMap<>();
    }

    public void initializeDefaultBoard() {
        pieces.clear();
        for (int i = 1; i < 9; i++) {
            Rank rank = Rank.initialize(i);

            pieces.put(i, rank);
        }
    }

    public void initializeVoidBoard() {
        pieces.clear();
        for (int i = 1; i < 9; i++) {
            Rank rank = Rank.initialize(0);

            pieces.put(i, rank);
        }
    }

    public void insert(Piece piece, String index) {
        String[] splitIndex = index.split("");
        char file = splitIndex[0].charAt(0);
        int rank = Integer.parseInt(splitIndex[1]);
        Rank target = pieces.get(rank);

        target.insert(piece, file);
    }

    public Piece getPieceAt(String index) {
        String[] splitIndex = index.split("");
        char file = splitIndex[0].charAt(0);
        int rank = Integer.parseInt(splitIndex[1]);
        Rank target = pieces.get(rank);

        return target.getPieceAt(file);
    }

    public double calculateScoreOf(Piece.Color color) {
        double score = 0;

        score += calculatePawnScore(color);
        score += calculateOtherPiecesScore(color);
        return score;
    }

    private double calculateOtherPiecesScore(Piece.Color color) {
        double score = 0;

        for (Rank rank : pieces.values()) {
            score += rank.calculateOtherPiecesScore(color);
        }
        return score;
    }

    private double calculatePawnScore(Piece.Color color) {
        List<Character> index = new ArrayList<>();

        for (Rank rank : pieces.values()) {
            index.addAll(rank.getPawnIndex(color));
        }
        Set<Character> indexWithoutDuplication = new HashSet<>(index);
        return indexWithoutDuplication.size() * Piece.Type.PAWN.getScore();
    }



    public String print() {
        StringBuilder sb = new StringBuilder();

        for (int key = 8; key > 0; key--) {
            Rank rank = pieces.get(key);
            String rawShape = rank.getShape();
            String editedShape = appendNewLine(rawShape);

            sb.append(editedShape);
        }
        return sb.toString();
    }

    public int getSize() {
        return pieces.size();
    }
}
