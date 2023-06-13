package chess;

import chess.pieces.Position;
import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.stream.Collectors;

import chess.pieces.Piece;

public class Board {
	public final static int PAWN_NUMBER = 8;
	public final static int RANK_NUMBER = 8;
	public final static String BLANK_LINE = "........";

	private final ArrayList<Rank> ranks;

	public Board() {
		this.ranks = new ArrayList<>(RANK_NUMBER);
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
		for (int i = 7; i >= 0; i--) {
			stringBuilder.append(StringUtils.appendNewLine(ranks.get(i).toString()));
		}
		return stringBuilder.toString();
	}

	public int count(Piece.Color color, Piece.Type type) {
		int count = 0;
		for (Rank rank : ranks) {
			count += rank.count(color, type);
		}
		return count;
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

	public Piece findPiece(String position) {
		Position p = new Position(position);

		return ranks.get(p.getY()).getPiece(p.getX());
	}

	public void initializeEmpty() {
		for (int i = 0; i < RANK_NUMBER; i++) {
			ranks.add(initBlank());
		}
	}

	public void move(Position position, Piece piece) {
		ranks.get(position.getY()).setPiece(position.getX(), piece);
	}

	public double calculatePoint(Piece.Color color) {
		double point = 0.0;
		for (Rank rank: ranks) {
			point += rank.calculate(color);
		}
		point += calculatePawn(color);
		return point;
	}

	private double calculatePawn(Piece.Color color) {
		double point = 0.0;
		for (int i = 0; i < ranks.size(); i++) {
			int pawn = 0;
			for (Rank rank : ranks) {
				if (rank.getPiece(i).getType().equals(Piece.Type.PAWN) && rank.getPiece(i).getColor().equals(color)) {
					pawn++;
				}
			}
			if (pawn > 1) {
				point -= pawn * 0.5;
			}
		}
		return point;
	}
}
