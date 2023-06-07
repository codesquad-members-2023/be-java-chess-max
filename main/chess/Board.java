package chess;

import chess.piece.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.Color.BLACK;
import static chess.Color.WHITE;
import static chess.StringUtil.NEW_LINE;

public class Board {

    private final List<Pawn> whitePawns;
    private final List<Pawn> blackPawns;
    public static final String BLANK_LINE = "........";

    public Board() {
        this.whitePawns = new ArrayList<>(8);
        this.blackPawns = new ArrayList<>(8);
    }

    public void initialize() {
        whitePawns.addAll(IntStream.range(0, 8).mapToObj(o -> new Pawn(WHITE)).collect(Collectors.toList()));
        blackPawns.addAll(IntStream.range(0, 8).mapToObj(o -> new Pawn(BLACK)).collect(Collectors.toList()));
    }

    public void addWhitePawn(final Pawn pawn) {
        this.whitePawns.add(pawn);
    }

    public void addBlackPawn(final Pawn pawn) {
        this.blackPawns.add(pawn);
    }

    public int size() {
        return this.whitePawns.size() + this.blackPawns.size();
    }

    public Pawn findWhitePawn(final int index) {
        return this.whitePawns.get(index);
    }

    public Pawn findBlackPawn(final int index) {
        return this.blackPawns.get(index);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        builder.append(BLANK_LINE).append(NEW_LINE);
        builder.append(blackPawns.stream().map(Pawn::getRepresentation).collect(Collectors.joining()))
                .append(NEW_LINE);
        IntStream.range(0, 4).forEach(o -> builder.append(BLANK_LINE).append(NEW_LINE));
        builder.append(whitePawns.stream().map(Pawn::getRepresentation).collect(Collectors.joining()))
                .append(NEW_LINE);
        builder.append(BLANK_LINE).append(NEW_LINE);

        System.out.println(builder);
    }
}
