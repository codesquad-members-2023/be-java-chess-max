package chess.pieces;

import chess.color.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Piece {

	private Color color;
	private Character symbol;

}
