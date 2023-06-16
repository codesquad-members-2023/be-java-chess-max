package chess.board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import chess.color.Color;
import chess.pieces.Bishop;
import chess.pieces.Blank;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Board {

	public List<List<Piece>> board = new ArrayList<>();
	List<Piece> whitePawns = new ArrayList<>();
	List<Piece> blackPawns = new ArrayList<>();
	List<Piece> whitePieces = new ArrayList<>();
	List<Piece> blackPieces = new ArrayList<>();
	List<Piece> blank = new ArrayList<>();
	public static final String NEW_LINE = System.lineSeparator();


	public int size() {
		return board.size();
	}

	public List<Piece> findPawn(int number) {
		return board.get(number);
	}

	public void initialize() {
		createPieces();
		for (int i = 0; i < 8; i++) {
			if (i == 0) {
				board.add(blackPieces);
			} else if (i == 1) {
				board.add(blackPawns);
			} else if (i == 6) {
				board.add(whitePawns);
			} else if (i == 7) {
				board.add(whitePieces);
			} else {
				board.add(new ArrayList<>(blank));
			}
		}
	}

	public void createPieces() {
		for (int i = 0; i < 8; i++) {
			whitePawns.add(new Pawn(Color.WHITE, 'p'));
			blackPawns.add(new Pawn(Color.BLACK, 'P'));
			blank.add(new Blank());
		}
		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 7) {
				whitePieces.add(new Rook(Color.WHITE, 'r'));
				blackPieces.add(new Rook(Color.BLACK,'R'));
			} else if (i == 1 || i == 6) {
				whitePieces.add(new Knight(Color.WHITE, 'n'));
				blackPieces.add(new Knight(Color.BLACK, 'N'));
			} else if (i == 2 || i == 5) {
				whitePieces.add(new Bishop(Color.WHITE, 'b'));
				blackPieces.add(new Bishop(Color.BLACK, 'B'));
			} else if (i == 3) {
				whitePieces.add(new Queen(Color.WHITE, 'q'));
				blackPieces.add(new Bishop(Color.BLACK, 'Q'));
			} else if (i == 4) {
				whitePieces.add(new King(Color.WHITE, 'k'));
				blackPieces.add(new King(Color.BLACK, 'K'));
			}
		}
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

	public String getPiece(Color color) {
		List<Piece> pieces = null;
		if (color == Color.WHITE) {
			pieces = whitePieces;
		} else {
			pieces = blackPieces;
		}
		return toString(pieces);
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
			sb.append(toString(pieces)).append(NEW_LINE);
		}
		System.out.println(sb);
	}
}
