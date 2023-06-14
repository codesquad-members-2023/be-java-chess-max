package kr.codesqaud.chessgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import kr.codesqaud.chessgame.chess.ChessGame;
import kr.codesqaud.chessgame.chess.board.ChessBoard;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.exception.InvalidPositionException;
import kr.codesqaud.chessgame.exception.InvalidTurnException;
import kr.codesqaud.chessgame.view.View;

public class ChessGameController {

    private final ChessGame game;
    private final View view;

    public ChessGameController(final View view) {
        this.view = view;
        this.game = new ChessGame(new ChessBoard());
    }

    public void service(final InputStream in) {
        view.showMessage("체스 게임");
        view.showMessage("게임 시작: start, 게임 종료: end");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            while (true) {
                view.showPrompt();
                String command = br.readLine();
                if (checkStartCommand(command)) {
                    view.showMessage("게임을 시작합니다.");
                    game.initialize();
                    view.showMessage(game.showBoard());
                    break;
                } else if (checkEndCommand(command)) {
                    view.showMessage("게임을 종료합니다.");
                    return;
                }
                view.showMessage("명령어가 올바르지 않습니다. : " + command);
            }

            while (true) {
                view.showMessage("기물이동 : move {시작} {도착} ex) move a2 a3");
                view.showMessage("게임종료 : end");
                view.showMessage("현재 차례 : " + game.getCurrentTurn());
                view.showPrompt();
                String command = br.readLine();

                // 게임 종료
                if (checkEndCommand(command)) {
                    break;
                }

                // 명령어 처리
                if (processCommand(command)) {
                    game.nextTurn();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkEndCommand(final String command) {
        return Objects.equals(command, "end");
    }

    private boolean checkStartCommand(final String command) {
        return Objects.equals(command, "start");
    }

    private boolean processCommand(final String command) {
        if (command.startsWith("move")) {
            try {
                return processMoveCommand(command);
            } catch (ArrayIndexOutOfBoundsException e) {
                view.showMessage("올바르지 않은 move 명령어 형식입니다.");
            }
        } else {
            view.showMessage(command + " 명령어는 지원하지 않습니다.");
        }
        return false;
    }

    private boolean processMoveCommand(final String command) {
        final int SOURCE_POSITION_INDEX = 1;
        final int TARGET_POSITION_INDEX = 2;
        final String BLANK = " ";
        String[] commands = command.split(BLANK);

        try {
            game.move(commands[SOURCE_POSITION_INDEX], commands[TARGET_POSITION_INDEX]);
            view.showMessage(game.showBoard());
            return true;
        } catch (InvalidMovingPieceException | InvalidPositionException | InvalidTurnException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }
}
