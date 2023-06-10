package chess;

import pieces.Piece;
import pieces.Position;

import java.util.ArrayList;
import java.util.List;

import static pieces.Piece.Color;
import static pieces.Piece.Type;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int MAX_LENGTH = 8;

    private final List<Rank> board = new ArrayList<>(MAX_LENGTH);

    public void initialize() {
        board.add(Rank.createFirstRank(Color.WHITE));
        board.add(Rank.createPawnRank(Color.WHITE));
        board.add(Rank.createBlankRank(5));
        board.add(Rank.createBlankRank(4));
        board.add(Rank.createBlankRank(3));
        board.add(Rank.createBlankRank(2));
        board.add(Rank.createPawnRank(Color.BLACK));
        board.add(Rank.createFirstRank(Color.BLACK));
    }

    public void initializeEmpty() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            board.add(Rank.createBlankRank(i));
        }
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : board) {
            count += rank.getPieceCount();
        }
        return count;
    }

    public int pieceCount(Color color, Type type) {
        int count = 0;
        for (Rank rank : board) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = MAX_LENGTH - 1; i >= 0; i--) {
            sb.append(appendNewLine(board.get(i).getRankString()));
        }
        return sb.toString();
    }

    public Piece findPiece(Position position) {
        return board.get(position.getYPos()).getPiece(position.getXPos());
    }

    public void move(Position position, Piece piece) {
        board.get(position.getYPos()).addPiece(position.getXPos(), piece);
    }

    public double calculatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint(pieces);
        }
        return point;
    }

    private List<Piece> findPiecesByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Rank rank : board) {
            pieces.addAll(rank.findPiecesByColor(color));
        }
        return pieces;
    }
}
