package kr.codesqaud.chessgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Pattern;
import kr.codesqaud.chessgame.chess.ChessGame;
import kr.codesqaud.chessgame.chess.board.ChessBoard;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.exception.InvalidPositionException;
import kr.codesqaud.chessgame.exception.InvalidTurnException;
import kr.codesqaud.chessgame.view.View;

public class ConsoleChessGameController implements ChessGameController {

    private static final Pattern moveCommandPattern = Pattern.compile("move [a-h][1-8] [a-h][1-8]");
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";
    private final ChessGame game;
    private final View view;

    public ConsoleChessGameController(final View view) {
        this.view = view;
        this.game = new ChessGame(new ChessBoard());
    }

    public void service(final InputStream in) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            view.showStartCommands();
            view.showPrompt();
            String command = br.readLine();
            boolean isRunning = executeStartEndCommand(command);

            while (isRunning) {
                showIntroduce();
                command = br.readLine();
                isRunning = executeCommand(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean executeStartEndCommand(final String command) {
        if (Objects.equals(command, START_COMMAND)) {
            view.showMessage("게임을 시작합니다.");
            game.initialize();
            view.showMessage(game.showBoard());
            return true;
        } else if (Objects.equals(command, END_COMMAND)) {
            view.showMessage("게임을 종료합니다.");
            return false;
        } else {
            view.showMessage("명령어가 올바르지 않습니다. 다시 시작해주세요 : " + command);
            return false;
        }
    }

    private boolean executeCommand(final String command) {
        if (Objects.equals(command, END_COMMAND)) {
            return false;
        } else if (moveCommandPattern.matcher(command).matches()) {
            boolean result = executeMoveCommand(command);
            if (result) {
                Color winner = game.checkmate();
                if (winner != Color.NOCOLOR) {
                    view.showMessage("승자 : " + winner);
                    return false;
                }
                game.nextTurn();
            }
            return true;
        } else {
            view.showMessage("명령어가 올바르지 않습니다. : " + command);
            return true;
        }
    }

    private boolean executeMoveCommand(final String command) {
        final int SOURCE_POSITION_INDEX = 1;
        final int TARGET_POSITION_INDEX = 2;
        final String BLANK = "\\s";
        String[] commands = command.split(BLANK);

        try {
            boolean success = game.move(commands[SOURCE_POSITION_INDEX], commands[TARGET_POSITION_INDEX]);
            view.showMessage(game.showBoard());
            return success;
        } catch (InvalidMovingPieceException | InvalidPositionException | InvalidTurnException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    private void showIntroduce() {
        view.showCommands();
        view.showCurrentTurn(game.getCurrentTurn());
        view.showPrompt();
    }
}
