package chess.pieces;

import chess.color.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Piece {

	private Color color;
	private Character symbol;

	public Piece(Color color) {
		this.color = color;
		if (color == Color.WHITE) {
			symbol = 'p';
		}
		else if (color == Color.BLACK) {
			symbol = 'P';
		}
	}
}
