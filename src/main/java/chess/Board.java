package chess;

import java.chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Piece;

public class Board {
	public final static int PAWN_NUMBER = 8;
	public final static String BLANK_LINE = "........";

	private final ArrayList<Piece> whitePawns;
	private final ArrayList<Piece> blackPawns;

	public Board() {
		this.whitePawns = new ArrayList<>();
		this.blackPawns = new ArrayList<>();
	}

	public void addWhitePawn(Piece pawn) {
		whitePawns.add(pawn);
	}

	public void addBlackPawn(Piece pawn) {
		blackPawns.add(pawn);
	}

	public int size() {
		return whitePawns.size() + blackPawns.size();
	}

	public void initialize() {
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece whitePawn = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
			addWhitePawn(whitePawn);
		}
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece blackPawn = new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
			addBlackPawn(blackPawn);
		}
	}

	public String print() {
		StringBuilder stringBuilder = new StringBuilder();
		makeBlankLine(stringBuilder);
		stringBuilder.append(StringUtils.appendNewLine(getBlackPawnsResult()));
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		stringBuilder.append(StringUtils.appendNewLine(getWhitePawnsResult()));
		makeBlankLine(stringBuilder);
		return stringBuilder.toString();
	}

	private void makeBlankLine(StringBuilder stringBuilder) {
		stringBuilder.append(StringUtils.appendNewLine(BLANK_LINE));
	}

	public String getWhitePawnsResult() {
		return getPawnsResult(whitePawns);
	}

	public String getBlackPawnsResult() {
		return getPawnsResult(blackPawns);
	}

	public String getPawnsResult(ArrayList<Piece> pawns) {
		return pawns.stream()
			.map(p -> Character.toString(p.getRepresentation()))
			.collect(Collectors.joining());
	}
}
