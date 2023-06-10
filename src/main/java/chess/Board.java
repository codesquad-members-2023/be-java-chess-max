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
		whitePieces.add(Piece.createWhiteRook());
		whitePieces.add(Piece.createWhiteKnight());
		whitePieces.add(Piece.createWhiteBishop());
		whitePieces.add(Piece.createWhiteQueen());
		whitePieces.add(Piece.createWhiteKing());
		whitePieces.add(Piece.createWhiteBishop());
		whitePieces.add(Piece.createWhiteKnight());
		whitePieces.add(Piece.createWhiteRook());
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece whitePawn = Piece.createWhitePawn();
			addWhitePawn(whitePawn);
		}
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece blackPawn = Piece.createBlackPawn();
			addBlackPawn(blackPawn);
		}
		blackPieces.add(Piece.createBlackRook());
		blackPieces.add(Piece.createBlackKnight());
		blackPieces.add(Piece.createBlackBishop());
		blackPieces.add(Piece.createBlackQueen());
		blackPieces.add(Piece.createBlackKing());
		blackPieces.add(Piece.createBlackBishop());
		blackPieces.add(Piece.createBlackKnight());
		blackPieces.add(Piece.createBlackRook());
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
			.map(p -> Character.toString(p.getRepresentation()))
			.collect(Collectors.joining());
	}

	public int pieceCount() {
		return whitePieces.size() + whitePawns.size() + blackPieces.size() + blackPawns.size();
	}
}
