package kr.codesqaud.chessgame.web;

import kr.codesqaud.chessgame.chess.pieces.Position;
import kr.codesqaud.chessgame.chess.pieces.config.Color;

public class Result {

    private final boolean status;
    private final Position source;
    private final Position target;
    private final Color turn;

    private Result(final boolean status, final String source, final String target, final Color turn) {
        this.status = status;
        this.source = Position.createPosition(source);
        this.target = Position.createPosition(target);
        this.turn = turn;
    }

    public static Result ok(String source, String target, Color turn) {
        return new Result(true, source, target, turn);
    }

    public static Result fail(final String source, final String target, final Color turn) {
        return new Result(false, source, target, turn);
    }

    public boolean isStatus() {
        return status;
    }

    public Position getSource() {
        return source;
    }

    public Position getTarget() {
        return target;
    }

    public Color getTurn() {
        return turn;
    }
}
