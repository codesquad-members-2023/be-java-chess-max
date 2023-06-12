package kr.codesqaud.chessgame.chess;


import static kr.codesqaud.chessgame.pieces.Position.createPosition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.PieceFactory;
import kr.codesqaud.chessgame.pieces.Position;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;
import kr.codesqaud.chessgame.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessBoard implements Board {

    public static final int SIZE = 8;
    private static final Logger logger = LoggerFactory.getLogger(ChessBoard.class);
    private final List<Rank> ranks;
    private final ChessGame game;
    private int pieceCount;

    public ChessBoard() {
        ranks = new ArrayList<>(SIZE);
        pieceCount = 0;
        game = new ChessGame();
    }

    // 체스판 초기화
    @Override
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

    // sourcePosition에서 targetPosition으로 기물 이동
    @Override
    public void move(final String sourcePosition, final String targetPosition) {
        Piece sourcePiece = findPiece(sourcePosition);
        Piece targetPiece = findPiece(targetPosition);
        validateMovingPiece(sourcePiece, targetPiece);
        move(targetPosition, sourcePiece);
        move(sourcePosition, targetPiece);
    }

    // 체스판 위에 기물 상태를 문자열로 반환
    @Override
    public String showBoard() {
        return ranks.stream()
            .sorted(Comparator.reverseOrder())
            .map(Rank::getPieceResult)
            .map(StringUtils::appendNewLine)
            .collect(Collectors.joining());
    }

    private void validateMovingPiece(Piece sourcePiece, Piece targetPiece) {
        // 기물인지 검증
        if (Objects.equals(sourcePiece.getType(), Type.NO_PIECE)) {
            throw new InvalidMovingPieceException("빈칸을 선택하셨습니다. : " + sourcePiece.getPosition());
        }

        // 이동하려는 위치에 같은 색상의 기물이 있는지 검증
        if (Objects.equals(sourcePiece.getColor(), targetPiece.getColor())) {
            throw new InvalidMovingPieceException(
                "이동하고자 하는 기물이 같은 색상입니다. 선택 : " + sourcePiece.getPosition() + ", 이동 : " + targetPiece.getPosition());
        }

        if (!sourcePiece.isMovable(targetPiece.getPosition())) {
            throw new InvalidMovingPieceException("해당 기물이 이동할 수 없는 위치입니다.");
        }
    }

    // Position 위치로 기물 이동
    public void move(final String position, final Piece piece) {
        piece.setPosition(createPosition(position));
        move(createPosition(position), piece);
    }

    // Position 위치로 기물 이동
    public void move(final Position position, final Piece piece) {
        ranks.get(position.getRankIndex())
            .setPiece(position.getFileIndex(), piece);
    }

    // 빈 체스판 초기화
    public void initializeEmpty() {
        initializeRank();
        IntStream.rangeClosed(1, SIZE)
            .forEach(this::initializeBlank);
    }

    // 빈칸 초기화
    private void initializeBlank(int rank) {
        PieceFactory pieceFactory = PieceFactory.getInstance();
        IntStream.range(0, SIZE)
            .mapToObj(i -> String.format("%s%d", (char) ('a' + i), rank))
            .forEach(position -> addPiece(rank, pieceFactory.createBlank(createPosition(position))));
    }

    // Rank 객체 초기화
    private void initializeRank() {
        IntStream.rangeClosed(1, SIZE)
            .mapToObj(Rank::new)
            .forEach(ranks::add);
    }

    // 입력받은 RANK에 기물 추가
    private void addPiece(final int rank, final Piece piece) {
        pieceCount++;
        ranks.get(rank - 1).addPiece(piece);
    }

    // Color와 기물 종류에 따른 기물 개수를 반환
    public int countPiece(final Color color, final Type type) {
        return ranks.stream()
            .mapToInt(rank -> rank.getPieceCount(color, type))
            .sum();
    }

    // 체스판 위에 있는 기물들 개수 반환
    public int size() {
        return pieceCount;
    }

    // 입력받은 Position에 따른 기물 객체 반환
    public Piece findPiece(final String position) {
        return findPiece(createPosition(position));
    }

    // 입력받은 Position에 따른 기물 객체 반환
    public Piece findPiece(final Position position) {
        return ranks.get(position.getRankIndex())
            .findPiece(position.getFileIndex());
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

    // 색상을 기준으로 기물들의 점수합을 반환
    public double calculatePoint(final Color color) {
        return game.calculatePoint(ranks, color);
    }
}
