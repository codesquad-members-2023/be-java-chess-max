package kr.codesqaud.chessgame.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ChessGame {

    private static final Logger logger = LoggerFactory.getLogger(ChessGame.class);

    private final InputStream in;

    public ChessGame(InputStream in) {
        this.in = in;
    }

    public void start() {
        System.out.println("체스게임을 시작합니다.");
        System.out.println("게임 시작: start, 게임 종료: end");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String command;
            boolean gameContinue = true;
            while (gameContinue && (command = br.readLine()) != null) {
                logger.debug("command : {}", command);
                gameContinue = processCommand(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean processCommand(String command) {
        if (command.equals("start")) {
            Board board = new Board();
            board.initialize();
            System.out.println(board.showBoard());
        } else if (command.equals("end")) {
            System.out.println("게임을 종료하였습니다.");
            return false;
        } else {
            System.out.printf("%s 명령어는 지원하지 않습니다.%n", command);
        }
        return true;
    }
}
