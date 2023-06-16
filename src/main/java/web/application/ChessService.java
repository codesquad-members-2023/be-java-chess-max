package web.application;

import chess.game.ChessGame;
import org.springframework.stereotype.Service;
import web.presentation.dto.MoveResponse;

@Service
public class ChessService {

	private final ChessGame chessGame;

	public ChessService() {
		chessGame = new ChessGame();
		chessGame.initialize();
	}

	public MoveResponse move(final String from, final String to) {
		chessGame.move(from, to);
		return MoveResponse.of(from, to);
	}
}
