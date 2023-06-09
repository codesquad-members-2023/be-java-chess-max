package chess;

import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Pawn;

public class Board {
	public final static int PAWN_NUMBER = 8;
	public final static String BLANK_LINE = "........";

	private final ArrayList<Pawn> whitePawns;
	private final ArrayList<Pawn> blackPawns;

	public Board() {
		this.whitePawns = new ArrayList<>();
		this.blackPawns = new ArrayList<>();
	}

	public void addWhitePawn(Pawn pawn) {
		whitePawns.add(pawn);
	}

	public void addBlackPawn(Pawn pawn) {
		blackPawns.add(pawn);
	}

	public int size() {
		return whitePawns.size() + blackPawns.size();
	}

	public void initialize() {
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Pawn whitePawn = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
			addWhitePawn(whitePawn);
		}
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Pawn blackPawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
			addBlackPawn(blackPawn);
		}
	}

	public String print() {
		StringBuilder stringBuilder = new StringBuilder();
		makeBlankLine(stringBuilder);
		stringBuilder.append(getBlackPawnsResult());
		stringBuilder.append("\n");
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		stringBuilder.append(getWhitePawnsResult());
		stringBuilder.append("\n");
		makeBlankLine(stringBuilder);
		return stringBuilder.toString();
	}

	private void makeBlankLine(StringBuilder stringBuilder) {
		stringBuilder.append(BLANK_LINE);
		stringBuilder.append("\n");
	}

	public String getWhitePawnsResult() {
		return getPawnsResult(whitePawns);
	}

	public String getBlackPawnsResult() {
		return getPawnsResult(blackPawns);
	}

	public String getPawnsResult(ArrayList<Pawn> pawns) {
		return pawns.stream()
			.map(p -> Character.toString(p.getRepresentation()))
			.collect(Collectors.joining());
	}
}
