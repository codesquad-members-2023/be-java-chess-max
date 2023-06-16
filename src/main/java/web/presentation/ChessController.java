package web.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.application.ChessService;
import web.presentation.dto.MoveRequest;
import web.presentation.dto.MoveResponse;

@RestController
public class ChessController {

	private final ChessService chessService;

	public ChessController(ChessService chessService) {
		this.chessService = chessService;
	}

	@PostMapping("/api/move")
	public ResponseEntity<MoveResponse> move(@RequestBody MoveRequest moveRequest) {
		MoveResponse response = chessService.move(moveRequest.getFrom(), moveRequest.getTo());
		return ResponseEntity.ok(response);
	}
}
