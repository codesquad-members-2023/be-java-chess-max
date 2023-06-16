package kr.codesqaud.chessgame.view;

import kr.codesqaud.chessgame.chess.pieces.config.Color;

public interface View {

    void showMessage(String message);

    void showPrompt();

    void showCommands();

    void showStartCommands();

    void showCurrentTurn(Color currentTurn);
}
