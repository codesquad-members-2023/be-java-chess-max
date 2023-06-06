package chess.board;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private final List<Pawn> pawns;

	public Board() {
		this.pawns = new ArrayList<>();
	}

	public int size() {
		return pawns.size();
	}

	public void addPiece(final Pawn piece) {
		pawns.add(piece);
	}

	public Pawn findPawn(final int idx) {
		return pawns.get(idx);
	}
}
