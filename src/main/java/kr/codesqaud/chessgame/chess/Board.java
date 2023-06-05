package kr.codesqaud.chessgame.chess;

import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Board {
    private final List<Pawn> pawns = new ArrayList<>();

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public void initialize() {
        initializePawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        initializePawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    private void initializePawn(Color color, String representation) {
        for (int i = 0; i < 8; i++) {
            pawns.add(new Pawn(color, representation));
        }
    }

    public String getWhitePawnsResult() {
        return pawns.stream()
                .filter(pawn -> pawn.getColor().equals(Color.WHITE))
                .map(Pawn::getRepresentation)
                .collect(Collectors.joining());
    }


    public String getBlackPawnsResult() {
        return pawns.stream()
                .filter(pawn -> pawn.getColor().equals(Color.BLACK))
                .map(Pawn::getRepresentation)
                .collect(Collectors.joining());
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("........").append(lineSeparator());
        sb.append(getBlackPawnsResult()).append(lineSeparator());
        sb.append("........").append(lineSeparator());
        sb.append("........").append(lineSeparator());
        sb.append("........").append(lineSeparator());
        sb.append("........").append(lineSeparator());
        sb.append(getWhitePawnsResult()).append(lineSeparator());
        sb.append("........").append(lineSeparator());

        System.out.println(sb);
        return sb.toString();
    }
}
