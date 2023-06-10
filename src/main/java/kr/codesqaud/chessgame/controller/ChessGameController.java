package kr.codesqaud.chessgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import kr.codesqaud.chessgame.chess.Board;
import kr.codesqaud.chessgame.chess.ChessBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessGameController {

    private static final Logger logger = LoggerFactory.getLogger(ChessGameController.class);

    private Board board;

    public void service(final InputStream in) {
        System.out.println("체스게임을 시작합니다.");
        System.out.println("게임 시작: start, 게임 종료: end");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            while (true) {
                String command = br.readLine();

                if (checkEndCommand(command)) {
                    break;
                }

                logger.debug("command : {}", command);
                processCommand(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkEndCommand(final String command) {
        return Objects.equals(command, "end");
    }

    private void processCommand(final String command) {
        if (Objects.equals(command, "start")) {
            board = new ChessBoard();
            board.initialize();
            board.printBoard();
        } else if (command.startsWith("move")) {
            processMoveCommand(command);
        } else {
            System.out.printf("%s 명령어는 지원하지 않습니다.%n", command);
        }
    }

    private void processMoveCommand(final String command) {
        final int SOURCE_POSITION_INDEX = 1;
        final int TARGET_POSITION_INDEX = 2;
        final String BLANK = " ";
        String[] commands = command.split(BLANK);
        board.move(commands[SOURCE_POSITION_INDEX], commands[TARGET_POSITION_INDEX]);
        board.printBoard();
    }
}
