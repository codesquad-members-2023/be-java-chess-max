package kr.codesqaud.chessgame.web;

import kr.codesqaud.chessgame.chess.ChessGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiChessController {

    @GetMapping("/api/move")
    public Result move(String source, String target) {
        ChessGame chessGame = ChessController.chessGame;
        if (chessGame.move(source, target)) {
            return Result.ok(source, target, chessGame.nextTurn());
        }
        return Result.fail(source, target, chessGame.getCurrentTurn());
    }
}
