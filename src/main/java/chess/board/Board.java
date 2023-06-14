package chess.board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import chess.color.Color;
import chess.pieces.Blank;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Board {

	public List<List<Piece>> board = new ArrayList<>();
	List<Piece> whitePawns = new ArrayList<>();
	List<Piece> blackPawns = new ArrayList<>();
	List<Piece> blank = new ArrayList<>();

	public int size() {
		return board.size();
	}

	public List<Piece> findPawn(int number) {
		return board.get(number);
	}

	public void initialize() {

		for (int i = 0; i < 8; i++) {
			whitePawns.add(new Pawn(Color.WHITE));
			blackPawns.add(new Pawn(Color.BLACK));
			blank.add(new Blank());
		}
		board.add(new ArrayList<>(blank));
		board.add(blackPawns);
		board.add(new ArrayList<>(blank));
		board.add(new ArrayList<>(blank));
		board.add(new ArrayList<>(blank));
		board.add(new ArrayList<>(blank));
		board.add(whitePawns);
		board.add(new ArrayList<>(blank));
	}

	public String getPawn(Color color) {
		List<Piece> pawns = null;
		if (color == Color.WHITE) {
			pawns = whitePawns;
		} else {
			pawns = blackPawns;
		}
		return toString(pawns);
	}

	public String toString(List<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for (Piece piece : pieces) {
			sb.append(piece.getSymbol());
		}
		return sb.toString();
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		for (List<Piece> pieces : board) {
			sb.append(toString(pieces)).append('\n');
		}
		System.out.println(sb);
	}
}
