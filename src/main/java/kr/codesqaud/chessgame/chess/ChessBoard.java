package kr.codesqaud.chessgame.chess;


import static kr.codesqaud.chessgame.pieces.Position.createPosition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.PieceFactory;
import kr.codesqaud.chessgame.pieces.Position;
import kr.codesqaud.chessgame.pieces.Type;
import kr.codesqaud.chessgame.utils.StringUtils;

public class ChessBoard implements Board {

    public static final int SIZE = 8;
    private final List<Rank> ranks = new ArrayList<>(SIZE);

    private int pieceCount = 0;

    public ChessBoard() {

    }

    private void addPiece(final int rank, final Piece piece) {
        pieceCount++;
        ranks.get(rank - 1).addPiece(piece);
    }

    public void initialize() {
        initializeRank();

        // 흑색 기물 간부 초기화
        PieceFactory pieceFactory = PieceFactory.getInstance();
        addPiece(8, pieceFactory.createBlackRook(createPosition("a8")));
        addPiece(8, pieceFactory.createBlackKnight(createPosition("b8")));
        addPiece(8, pieceFactory.createBlackBishop(createPosition("c8")));
        addPiece(8, pieceFactory.createBlackQueen(createPosition("d8")));
        addPiece(8, pieceFactory.createBlackKing(createPosition("e8")));
        addPiece(8, pieceFactory.createBlackBishop(createPosition("f8")));
        addPiece(8, pieceFactory.createBlackKnight(createPosition("g8")));
        addPiece(8, pieceFactory.createBlackRook(createPosition("h8")));

        // 흑색 폰 초기화
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), 7);
            addPiece(7, pieceFactory.createBlackPawn(createPosition(position)));
        }

        // 빈칸 초기화
        for (int i = 6; i >= 3; i--) {
            initializeBlank(i);
        }

        // 백색 폰 초기화
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), 2);
            addPiece(2, pieceFactory.createWhitePawn(createPosition(position)));
        }

        // 백색 기물 간부 초기화
        addPiece(1, pieceFactory.createWhiteRook(createPosition("a1")));
        addPiece(1, pieceFactory.createWhiteKnight(createPosition("b1")));
        addPiece(1, pieceFactory.createWhiteBishop(createPosition("c1")));
        addPiece(1, pieceFactory.createWhiteQueen(createPosition("d1")));
        addPiece(1, pieceFactory.createWhiteKing(createPosition("e1")));
        addPiece(1, pieceFactory.createWhiteBishop(createPosition("f1")));
        addPiece(1, pieceFactory.createWhiteKnight(createPosition("g1")));
        addPiece(1, pieceFactory.createWhiteRook(createPosition("h1")));
    }

    public void initializeEmpty() {
        initializeRank();

        for (int i = 1; i <= SIZE; i++) {
            initializeBlank(i);
        }
    }

    private void initializeBlank(int rank) {
        PieceFactory pieceFactory = PieceFactory.getInstance();
        for (int i = 0; i < SIZE; i++) {
            String position = String.format("%s%d", (char) ('a' + i), rank);
            addPiece(rank, pieceFactory.createBlank(createPosition(position)));
        }
    }

    private void initializeRank() {
        for (int i = 1; i <= SIZE; i++) {
            ranks.add(new Rank(i));
        }
    }

    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex()).findPiece(position.getFileIndex());
    }

    // position에 위치한 기물을 piece로 설정
    @Override
    public void move(final String position, final Piece piece) {
        move(createPosition(position), piece);
    }

    @Override
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

    public int size() {
        return pieceCount;
    }

    public Piece findPiece(final String position) {
        return findPiece(createPosition(position));
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
                // 색깔도 동일하고 폰인 경우
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
        int file = position.getFile(); // a=1, b=2, ... pawn
        return ranks.stream()
            .filter(rank -> !rank.isMatchRank(position.getRank()))
            .anyMatch(rank -> Objects.equals(rank.findPiece(file).getType(), Type.PAWN));
    }

    // 컬러를 기준으로 점수가 높은 순서로 정렬하여 반환합니다.
    public List<Piece> sortDecreaseByColor(final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .sorted(Comparator.comparingDouble(p -> ((Piece) p).getType().getDefaultPoint()).reversed())
            .collect(Collectors.toUnmodifiableList());
    }

    // 컬러를 기준으로 점수가 낮은 순서로 정렬하여 반환합니다.
    public List<Piece> sortIncreaseByColor(final Color color) {
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .sorted(Comparator.comparingDouble(p -> p.getType().getDefaultPoint()))
            .collect(Collectors.toUnmodifiableList());
    }
}
