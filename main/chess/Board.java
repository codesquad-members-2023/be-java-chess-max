package chess;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chess.StringUtil.NEW_LINE;

public class Board {

    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private final List<Piece> whitePawns;
    private final List<Piece> blackPawns;
    public static final String BLANK_LINE = "........";

    public Board() {
        this.whitePieces = new ArrayList<>(8);
        this.blackPieces = new ArrayList<>(8);
        this.whitePawns = new ArrayList<>(8);
        this.blackPawns = new ArrayList<>(8);
    }

    public void initialize() {
        whitePawns.addAll(IntStream.range(0, 8).mapToObj(o -> Piece.createWhitePawn()).collect(Collectors.toList()));
        blackPawns.addAll(IntStream.range(0, 8).mapToObj(o -> Piece.createBlackPawn()).collect(Collectors.toList()));

        addWhitePieces(Piece.createWhiteRook());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteQueen());
        addWhitePieces(Piece.createWhiteKing());
        addWhitePieces(Piece.createWhiteBishop());
        addWhitePieces(Piece.createWhiteKnight());
        addWhitePieces(Piece.createWhiteRook());

        addBlackPieces(Piece.createBlackRook());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackQueen());
        addBlackPieces(Piece.createBlackKing());
        addBlackPieces(Piece.createBlackBishop());
        addBlackPieces(Piece.createBlackKnight());
        addBlackPieces(Piece.createBlackRook());
    }


    public int countPieces() {
        return this.whitePieces.size() + this.blackPieces.size() + this.blackPawns.size() + this.whitePawns.size();
    }

    private void addWhitePieces(Piece piece) {
        whitePieces.add(piece);
    }

    private void addBlackPieces(Piece piece) {
        blackPieces.add(piece);
    }

    public String show() {
        StringBuilder builder = new StringBuilder();

        builder.append(blackPieces.stream().map(Piece::getRepresentation).collect(Collectors.joining())).append(NEW_LINE);
        builder.append(blackPawns.stream().map(Piece::getRepresentation).collect(Collectors.joining()))
                .append(NEW_LINE);
        IntStream.range(0, 4).forEach(o -> builder.append(BLANK_LINE).append(NEW_LINE));
        builder.append(whitePawns.stream().map(Piece::getRepresentation).collect(Collectors.joining()))
                .append(NEW_LINE);
        builder.append(whitePieces.stream().map(Piece::getRepresentation).collect(Collectors.joining())).append(NEW_LINE);

        return builder.toString();
    }

}
