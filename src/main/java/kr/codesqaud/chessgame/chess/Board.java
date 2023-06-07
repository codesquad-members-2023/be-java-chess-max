package kr.codesqaud.chessgame.chess;

import static kr.codesqaud.chessgame.pieces.Piece.createBlackBishop;
import static kr.codesqaud.chessgame.pieces.Piece.createBlackKing;
import static kr.codesqaud.chessgame.pieces.Piece.createBlackKnight;
import static kr.codesqaud.chessgame.pieces.Piece.createBlackPawn;
import static kr.codesqaud.chessgame.pieces.Piece.createBlackQueen;
import static kr.codesqaud.chessgame.pieces.Piece.createBlackRook;
import static kr.codesqaud.chessgame.pieces.Piece.createBlank;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteBishop;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteKing;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteKnight;
import static kr.codesqaud.chessgame.pieces.Piece.createWhitePawn;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteQueen;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteRook;
import static kr.codesqaud.chessgame.pieces.Position.createPosition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Piece.Color;
import kr.codesqaud.chessgame.pieces.Piece.Type;
import kr.codesqaud.chessgame.pieces.Position;
import kr.codesqaud.chessgame.utils.StringUtils;

public class Board {

    public static final int SIZE = 8;
    private final List<Rank> ranks = new ArrayList<>(SIZE);

    private int pieceCount = 0;

    private void addPiece(final int rank, final Piece piece) {
        pieceCount++;
        ranks.get(rank - 1).addPiece(piece);
    }

    public int size() {
        return pieceCount;
    }


    public void initializeEmpty() {
        initializeRank();

        for (int i = 1; i <= SIZE; i++) {
            initializeBlank(i);
        }
    }

    public void initialize() {
        initializeRank();

        // 흑색 기물 간부 초기화
        addPiece(8, createBlackRook(createPosition("a8")));
        addPiece(8, createBlackKnight(createPosition("b8")));
        addPiece(8, createBlackBishop(createPosition("c8")));
        addPiece(8, createBlackQueen(createPosition("d8")));
        addPiece(8, createBlackKing(createPosition("e8")));
        addPiece(8, createBlackBishop(createPosition("f8")));
        addPiece(8, createBlackKnight(createPosition("g8")));
        addPiece(8, createBlackRook(createPosition("h8")));

        // 흑색 폰 초기화
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), 7);
            addPiece(7, createBlackPawn(createPosition(position)));
        }

        // 빈칸 초기화
        for (int i = 6; i >= 3; i--) {
            initializeBlank(i);
        }

        // 백색 폰 초기화
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), 2);
            addPiece(2, createWhitePawn(createPosition(position)));
        }

        // 백색 기물 간부 초기화
        addPiece(1, createWhiteRook(createPosition("a1")));
        addPiece(1, createWhiteKnight(createPosition("b1")));
        addPiece(1, createWhiteBishop(createPosition("c1")));
        addPiece(1, createWhiteQueen(createPosition("d1")));
        addPiece(1, createWhiteKing(createPosition("e1")));
        addPiece(1, createWhiteBishop(createPosition("f1")));
        addPiece(1, createWhiteKnight(createPosition("g1")));
        addPiece(1, createWhiteRook(createPosition("h1")));
    }

    private void initializeBlank(int rank) {
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), rank);
            addPiece(rank, createBlank(createPosition(position)));
        }
    }

    private void initializeRank() {
        for (int i = 1; i <= SIZE; i++) {
            ranks.add(new Rank(i));
        }
    }

    public String showBoard() {
        return ranks.stream()
            .sorted(Comparator.reverseOrder())
            .map(Rank::getPieceResult)
            .map(StringUtils::appendNewLine)
            .collect(Collectors.joining());
    }

    public int getPieceCount(final Color color, final Type type) {
        return ranks.stream()
            .mapToInt(rank -> rank.getPieceCount(color, type))
            .sum();
    }

    public Piece findPiece(final String position) {
        return findPiece(createPosition(position));
    }

    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex()).findPiece(position.getFileIndex());
    }

    // position에 위치한 기물을 piece로 설정
    public void move(final String position, final Piece piece) {
        move(createPosition(position), piece);
    }

    public void move(final Position position, final Piece piece) {
        ranks.get(position.getRankIndex())
            .setPiece(position.getFileIndex(), piece);
    }

    public double calculatePoint(final Color color) {
        final double PAWN_SCORE = 0.5;
        double score = 0.0;
        for (Rank rank : ranks) {
            for (Piece piece : rank.getPieces()) {
                // 색깔이 동일하고 폰이 아닌경우
                if (Objects.equals(piece.getColor(), color) &&
                    !Objects.equals(piece.getType(), Type.PAWN)) {
                    score += piece.getType().getDefaultPoint();
                    continue;
                }
                if (Objects.equals(piece.getColor(), color) &&
                    Objects.equals(piece.getType(), Type.PAWN)) {
                    if (existPawnInVeritable(piece.getPosition())) {
                        score += PAWN_SCORE;
                    } else {
                        score += piece.getType().getDefaultPoint();
                    }
                }
            }
        }
        return score;
    }

    private boolean existPawnInVeritable(final Position position) {
        int file = position.getFile();
        return ranks.stream()
            .filter(rank -> !rank.isMatchRank(position.getRank()))
            .anyMatch(rank -> Objects.equals(rank.findPiece(file).getType(), Type.PAWN));
    }
}
