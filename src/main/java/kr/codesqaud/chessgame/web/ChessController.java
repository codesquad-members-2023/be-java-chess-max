package kr.codesqaud.chessgame.web;

import kr.codesqaud.chessgame.chess.ChessGame;
import kr.codesqaud.chessgame.chess.board.ChessBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChessController {

    private static final Logger logger = LoggerFactory.getLogger(ChessController.class);

    public static ChessGame chessGame;

    public ChessController() {
        chessGame = new ChessGame(new ChessBoard());
        chessGame.initialize();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("chessGame", ChessDto.from(chessGame));
        logger.debug("call /");
        return "chessBoard";
    }

    @PostMapping("/move")
    public String move(String source, String target, Model model) {
        chessGame.move(source, target);
        model.addAttribute("chessGame", ChessDto.from(chessGame));
        return "chessBoard";
    }
}
