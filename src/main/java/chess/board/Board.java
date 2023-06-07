package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Board {

	public List<Pawn> board = new ArrayList<>();

	public void add(Pawn pawn) {
		board.add(pawn);
	}

	public int size() {
		return board.size();
	}

	public Pawn findPawn(int number) {
		return board.get(number);
	}
}
