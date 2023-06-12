package chess;

import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Piece;

public class Board {
	public final static int PAWN_NUMBER = 8;
	public final static String BLANK_LINE = "........";

	private final ArrayList<Piece> whitePieces;
	private final ArrayList<Piece> whitePawns;
	private final ArrayList<Piece> blackPawns;
	private final ArrayList<Piece> blackPieces;

	public Board() {
		this.whitePieces = new ArrayList<>();
		this.whitePawns = new ArrayList<>();
		this.blackPieces = new ArrayList<>();
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
		whitePieces.add(Piece.createWhite(Piece.Type.ROOK));
		whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
		whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
		whitePieces.add(Piece.createWhite(Piece.Type.QUEEN));
		whitePieces.add(Piece.createWhite(Piece.Type.KING));
		whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
		whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
		whitePieces.add(Piece.createWhite(Piece.Type.ROOK));
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece whitePawn = Piece.createWhite(Piece.Type.PAWN);
			addWhitePawn(whitePawn);
		}
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece blackPawn = Piece.createBlack(Piece.Type.PAWN);
			addBlackPawn(blackPawn);
		}
		blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
		blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
		blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
		blackPieces.add(Piece.createBlack(Piece.Type.QUEEN));
		blackPieces.add(Piece.createBlack(Piece.Type.KING));
		blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
		blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
		blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
	}

	public String showBoard() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(StringUtils.appendNewLine(getBlackPiecesResult()));
		stringBuilder.append(StringUtils.appendNewLine(getBlackPawnsResult()));
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		makeBlankLine(stringBuilder);
		stringBuilder.append(StringUtils.appendNewLine(getWhitePawnsResult()));
		stringBuilder.append(StringUtils.appendNewLine(getWhitePiecesResult()));
		return stringBuilder.toString();
	}

	private void makeBlankLine(StringBuilder stringBuilder) {
		stringBuilder.append(StringUtils.appendNewLine(BLANK_LINE));
	}

	public String getWhitePiecesResult() {
		return getPiecesResult(whitePieces);
	}

	public String getWhitePawnsResult() {
		return getPiecesResult(whitePawns);
	}

	public String getBlackPiecesResult() {
		return getPiecesResult(blackPieces);
	}

	public String getBlackPawnsResult() {
		return getPiecesResult(blackPawns);
	}

	public String getPiecesResult(ArrayList<Piece> pieces) {
		return pieces.stream()
			.map(p -> {
				if (p.getColor().equals(Piece.Color.WHITE)) {
					return Character.toString(p.getType().getWhiteRepresentation());
				} else {
					return Character.toString(p.getType().getBlackRepresentation());
				}
			})
			.collect(Collectors.joining());
	}

	public int pieceCount() {
		return whitePieces.size() + whitePawns.size() + blackPieces.size() + blackPawns.size();
	}
}
