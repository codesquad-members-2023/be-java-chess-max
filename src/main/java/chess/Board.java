package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Pawn;

public class Board {
	private final List<Pawn> pawns;

	public Board() {
		this.pawns = new ArrayList<>();
	}

	public void add(Pawn pawn) {
		pawns.add(pawn);
	}

	public int size() {
		return pawns.size();
	}

	public String findPawnColor(int index) {
		return pawns.get(index).getColor();
	}
}
