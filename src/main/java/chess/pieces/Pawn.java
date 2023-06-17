package chess.pieces;

import chess.color.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Pawn extends Piece{
	public Pawn(Color color, char symbol) {
		super(color, symbol);
	}
}
