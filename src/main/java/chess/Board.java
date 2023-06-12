package chess;

import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Piece;

public class Board {
	public final static int PAWN_NUMBER = 8;
	public final static String BLANK_LINE = "........";

	private final ArrayList<Rank> ranks;

	public Board() {
		this.ranks = new ArrayList<>();
	}

	public void initialize() {
		ranks.add(initWhitePieces());
		ranks.add(initWhitePawns());
		ranks.add(initBlank());
		ranks.add(initBlank());
		ranks.add(initBlank());
		ranks.add(initBlank());
		ranks.add(initBlackPawns());
		ranks.add(initBlackPieces());
	}

	private Rank initBlackPieces() {
		Rank blackPieces = new Rank();
		blackPieces.addPieces(Piece.createBlack(Piece.Type.ROOK));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.KNIGHT));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.BISHOP));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.QUEEN));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.KING));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.BISHOP));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.KNIGHT));
		blackPieces.addPieces(Piece.createBlack(Piece.Type.ROOK));
		return blackPieces;
	}

	private Rank initBlackPawns() {
		Rank blackPawns = new Rank();
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece blackPawn = Piece.createBlack(Piece.Type.PAWN);
			blackPawns.addPieces(blackPawn);
		}

		return blackPawns;
	}

	private Rank initBlank() {
		Rank blanks = new Rank();
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece blank = Piece.createBlank();
			blanks.addPieces(blank);
		}

		return blanks;
	}

	private Rank initWhitePawns() {
		Rank whitePawns = new Rank();
		for (int i = 0; i < PAWN_NUMBER; i++) {
			Piece whitePawn = Piece.createWhite(Piece.Type.PAWN);
			whitePawns.addPieces(whitePawn);
		}

		return whitePawns;
	}

	private Rank initWhitePieces() {
		Rank whitePieces = new Rank();

		whitePieces.addPieces(Piece.createWhite(Piece.Type.ROOK));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.KNIGHT));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.BISHOP));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.QUEEN));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.KING));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.BISHOP));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.KNIGHT));
		whitePieces.addPieces(Piece.createWhite(Piece.Type.ROOK));

		return whitePieces;
	}

	public String showBoard() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Rank rank: ranks) {
			stringBuilder.append(StringUtils.appendNewLine(rank.toString()));
		}
		return stringBuilder.toString();
	}

	private void makeBlankLine(StringBuilder stringBuilder) {
		stringBuilder.append(StringUtils.appendNewLine(BLANK_LINE));
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
}
