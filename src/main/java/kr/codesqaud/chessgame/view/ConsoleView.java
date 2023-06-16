package kr.codesqaud.chessgame.view;

import kr.codesqaud.chessgame.chess.pieces.config.Color;

public class ConsoleView implements View {

    @Override
    public void showMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void showPrompt() {
        System.out.print("> ");
    }

    @Override
    public void showCommands() {
        println("기물이동 : move {시작} {도착} ex) move a2 a3");
        println("게임종료 : end");
    }

    @Override
    public void showStartCommands() {
        println("체스 게임");
        println("게임 시작: start, 게임 종료: end");
    }

    @Override
    public void showCurrentTurn(final Color color) {
        println("현재 차례 : " + color);
    }

    private void println(String text) {
        System.out.println(text);
    }
}
