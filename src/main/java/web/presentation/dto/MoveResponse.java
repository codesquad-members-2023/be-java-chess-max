package web.presentation.dto;

import chess.board.Position;

public class MoveResponse {

	private Position from;
	private Position to;

	private MoveResponse(Position from, Position to) {
		this.from = from;
		this.to = to;
	}

	public Position getFrom() {
		return from;
	}

	public Position getTo() {
		return to;
	}

	public static MoveResponse of(final String from, final String to) {
		return new MoveResponse(new Position(from), new Position(to));
	}
}
