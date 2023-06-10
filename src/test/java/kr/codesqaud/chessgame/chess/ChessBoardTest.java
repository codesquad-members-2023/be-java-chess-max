package kr.codesqaud.chessgame.chess;


import static kr.codesqaud.chessgame.pieces.Position.createPosition;
import static org.assertj.core.data.Offset.offset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kr.codesqaud.chessgame.pieces.Color;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.PieceFactory;
import kr.codesqaud.chessgame.pieces.Type;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ChessBoardTest {

    private static final Logger logger = LoggerFactory.getLogger(ChessBoardTest.class);

    private ChessBoard board;
    private PieceFactory pieceFactory;

    @BeforeEach
    public void setup() {
        board = new ChessBoard();
        pieceFactory = PieceFactory.getInstance();
    }

    @Test
    @DisplayName("board가 initialize 메소드를 호출했을때 체스판의 기물들을 초기화한다")
    public void create() throws IOException {
        // given

        // when
        board.initialize();
        // then
        String expectedBoard = Files.readString(Paths.get("src/test/resources/chessBoard.txt"));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.size()).isEqualTo(64);
        assertions.assertThat(board.showBoard()).isEqualTo(expectedBoard);
        assertions.assertAll();
    }

    @Test
    @DisplayName("기물의 색상과 종류가 주어질때 Board가 가지고 있는 기물의 개수를 요청했을때 개수를 응답한다")
    public void getPieceCount() {
        // given
        board.initialize();
        // when
        int blackPawnCount = board.getPieceCount(Color.BLACK, Type.PAWN);
        int blackRookCount = board.getPieceCount(Color.BLACK, Type.ROOK);
        int blackKnightCount = board.getPieceCount(Color.BLACK, Type.KNIGHT);
        int blackBishopCount = board.getPieceCount(Color.BLACK, Type.BISHOP);
        int blackQueenCount = board.getPieceCount(Color.BLACK, Type.QUEEN);
        int blackKingCount = board.getPieceCount(Color.BLACK, Type.KING);
        int whitePawnCount = board.getPieceCount(Color.WHITE, Type.PAWN);
        int whiteRookCount = board.getPieceCount(Color.WHITE, Type.ROOK);
        int whiteKnightCount = board.getPieceCount(Color.WHITE, Type.KNIGHT);
        int whiteBishopCount = board.getPieceCount(Color.WHITE, Type.BISHOP);
        int whiteQueenCount = board.getPieceCount(Color.WHITE, Type.QUEEN);
        int whiteKingCount = board.getPieceCount(Color.WHITE, Type.KING);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(blackPawnCount).isEqualTo(8);
        assertions.assertThat(blackRookCount).isEqualTo(2);
        assertions.assertThat(blackKnightCount).isEqualTo(2);
        assertions.assertThat(blackBishopCount).isEqualTo(2);
        assertions.assertThat(blackQueenCount).isEqualTo(1);
        assertions.assertThat(blackKingCount).isEqualTo(1);
        assertions.assertThat(whitePawnCount).isEqualTo(8);
        assertions.assertThat(whiteRookCount).isEqualTo(2);
        assertions.assertThat(whiteKnightCount).isEqualTo(2);
        assertions.assertThat(whiteBishopCount).isEqualTo(2);
        assertions.assertThat(whiteQueenCount).isEqualTo(1);
        assertions.assertThat(whiteKingCount).isEqualTo(1);
        assertions.assertAll();
    }

    @Test
    @DisplayName("위치가 주어질때 Board 객체에게 위치에 따른 기물을 조회하면 해당 위치에 있는 기물(빈칸 포함)을 응답합니다.")
    public void findPiece() {
        // given
        board.initialize();
        // when
        Piece blackRook = board.findPiece("a8");
        Piece blackRook2 = board.findPiece("h8");
        Piece whiteRook = board.findPiece("a1");
        Piece whiteRook2 = board.findPiece("h1");
        Piece emptyPiece = board.findPiece("a6");
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(blackRook).isEqualTo(pieceFactory.createBlackRook(createPosition("a8")));
        assertions.assertThat(blackRook2).isEqualTo(pieceFactory.createBlackRook(createPosition("h8")));
        assertions.assertThat(whiteRook).isEqualTo(pieceFactory.createWhiteRook(createPosition("a1")));
        assertions.assertThat(whiteRook2).isEqualTo(pieceFactory.createWhiteRook(createPosition("h1")));
        assertions.assertThat(emptyPiece).isEqualTo(pieceFactory.createBlank(createPosition("a6")));
        assertions.assertAll();
    }

    @Test
    @DisplayName("빈 체스판이 주어지고 흑백룩을 특정 위치로 이동시킨다")
    public void move() {
        // given
        board.initializeEmpty();
        String position = "b5";
        Piece piece = pieceFactory.createBlackRook(createPosition(position));
        // when
        board.move(position, piece);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.findPiece(position)).isEqualTo(piece);
        assertions.assertAll();
        logger.debug("board : \r\n{}", board.showBoard());
    }

    @Test
    @DisplayName("체스판 위에 기물이 주어지고 남아있는 기물에 대한 점수를 요청했을때 점수합계를 응답합니다.")
    public void calculatePoint() {
        // given
        board.initializeEmpty();
        // when
        addPiece("b6", pieceFactory.createBlackPawn(createPosition("b6")));
        addPiece("e6", pieceFactory.createBlackQueen(createPosition("e6")));
        addPiece("b8", pieceFactory.createBlackKing(createPosition("b8")));
        addPiece("c8", pieceFactory.createBlackRook(createPosition("c8")));

        addPiece("f2", pieceFactory.createWhitePawn(createPosition("f2")));
        addPiece("g2", pieceFactory.createWhitePawn(createPosition("g2")));
        addPiece("e1", pieceFactory.createWhiteRook(createPosition("e1")));
        addPiece("f1", pieceFactory.createWhiteKing(createPosition("f1")));

        double blackScore = board.calculatePoint(Color.BLACK);
        double whiteScore = board.calculatePoint(Color.WHITE);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(blackScore).isEqualTo(15.0, offset(0.01));
        assertions.assertThat(whiteScore).isEqualTo(7.0, offset(0.01));
        assertions.assertAll();
    }

    @Test
    @DisplayName("체스판 위에 기물이 주어지고 흑색과 백색을 구분해서 점수가 높은 순서로 정렬을 요청시 높은 순서로 정렬되어 응답한다")
    public void sortByColor() {
        // given
        board.initializeEmpty();
        // when
        addPiece("b6", pieceFactory.createBlackPawn(createPosition("b6")));
        addPiece("e6", pieceFactory.createBlackQueen(createPosition("e6")));
        addPiece("b8", pieceFactory.createBlackKing(createPosition("b8")));
        addPiece("c8", pieceFactory.createBlackRook(createPosition("c8")));

        addPiece("f2", pieceFactory.createWhitePawn(createPosition("f2")));
        addPiece("g2", pieceFactory.createWhitePawn(createPosition("g2")));
        addPiece("e1", pieceFactory.createWhiteRook(createPosition("e1")));
        addPiece("f1", pieceFactory.createWhiteKing(createPosition("f1")));
        // when
        List<Piece> decreasePieces = board.sortDecreaseByColor(Color.BLACK);
        List<Piece> increasePieces = board.sortIncreaseByColor(Color.BLACK);
        // then
        List<Piece> expectedDecreasePiece = new ArrayList<>();
        expectedDecreasePiece.add(pieceFactory.createBlackQueen(createPosition("e6")));
        expectedDecreasePiece.add(pieceFactory.createBlackRook(createPosition("c8")));
        expectedDecreasePiece.add(pieceFactory.createBlackPawn(createPosition("b6")));
        expectedDecreasePiece.add(pieceFactory.createBlackKing(createPosition("b8")));

        List<Piece> expectedIncreasePiece = new ArrayList<>();
        expectedIncreasePiece.add(pieceFactory.createBlackKing(createPosition("b8")));
        expectedIncreasePiece.add(pieceFactory.createBlackPawn(createPosition("b6")));
        expectedIncreasePiece.add(pieceFactory.createBlackRook(createPosition("c8")));
        expectedIncreasePiece.add(pieceFactory.createBlackQueen(createPosition("e6")));

        logger.debug("piece : {}", decreasePieces);
        logger.debug("expectedDecreasePiece : {}", expectedDecreasePiece);
        logger.debug("expectedIncreasePiece : {}", expectedIncreasePiece);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(decreasePieces).isEqualTo(expectedDecreasePiece);
        assertions.assertThat(increasePieces).isEqualTo(expectedIncreasePiece);
        assertions.assertAll();
    }


    @Test
    @DisplayName("출발 좌표와 도착좌표가 주어지고 기물 이동 요청시 기물이 도착 좌표를 갖게 된다")
    public void givenSourceAndTargetPositionWhenMoveThenPieceHasTargetPosition() {
        // given
        board.initialize();
        String sourcePosition = "b2";
        String targetPosition = "b3";
        // when
        board.move(sourcePosition, targetPosition);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.findPiece(sourcePosition))
            .isEqualTo(pieceFactory.createBlank(createPosition(sourcePosition)));
        assertions.assertThat(board.findPiece(targetPosition))
            .isEqualTo(pieceFactory.createWhitePawn(createPosition(targetPosition)));
        assertions.assertAll();
    }

    @Test
    @Disabled
    @DisplayName("board.findPiece 메소드를 100번 호출했을때 속도 측정 테스트")
    public void findPiece_speed() {
        // given
        Board board = new ChessBoard();
        // when
        // 100만번 기준 2.239초
        for (int i = 0; i < 1000000; i++) {
            this.board.findPiece("h1");
        }
        // then
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
