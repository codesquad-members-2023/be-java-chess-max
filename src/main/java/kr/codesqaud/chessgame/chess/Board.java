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
        return (int) ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getColor(), color))
            .filter(piece -> Objects.equals(piece.getType(), type))
            .count();
    }

    public Piece findPiece(final String position) {
        Position pos = createPosition(position);
        return ranks.stream()
            .flatMap(rank -> rank.getPieces().stream())
            .filter(piece -> Objects.equals(piece.getPosition(), pos))
            .findAny()
            .orElseThrow(() -> new RuntimeException("기물을 찾을 수 없습니다. : " + position));
    }

    // position에 위치한 기물을 piece로 설정
    public void move(final String position, final Piece piece) {
        move(createPosition(position), piece);
    }

    public void move(final Position position, final Piece piece) {
        ranks.get(position.getRankIndex())
            .setPiece(position.getFileIndex(), piece);
    }
}
