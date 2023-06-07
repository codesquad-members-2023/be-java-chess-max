package kr.codesqaud.chessgame.chess;

import static kr.codesqaud.chessgame.pieces.Piece.createBlackRook;
import static kr.codesqaud.chessgame.pieces.Piece.createBlank;
import static kr.codesqaud.chessgame.pieces.Piece.createWhiteRook;
import static kr.codesqaud.chessgame.pieces.Position.createPosition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import kr.codesqaud.chessgame.pieces.Piece;
import kr.codesqaud.chessgame.pieces.Piece.Color;
import kr.codesqaud.chessgame.pieces.Piece.Type;
import kr.codesqaud.chessgame.pieces.Position;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BoardTest {

    private static final Logger logger = LoggerFactory.getLogger(BoardTest.class);

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
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
        assertions.assertThat(blackRook).isEqualTo(createBlackRook(createPosition("a8")));
        assertions.assertThat(blackRook2).isEqualTo(createBlackRook(createPosition("h8")));
        assertions.assertThat(whiteRook).isEqualTo(createWhiteRook(createPosition("a1")));
        assertions.assertThat(whiteRook2).isEqualTo(createWhiteRook(createPosition("h1")));
        assertions.assertThat(emptyPiece).isEqualTo(createBlank(createPosition("a6")));
        assertions.assertAll();
    }

    @Test
    @DisplayName("빈 체스판이 주어지고 흑백룩을 특정 위치로 이동시킨다")
    public void move() {
        // given
        board.initializeEmpty();
        String position = "b5";
        Piece piece = createBlackRook(Position.createPosition(position));
        // when
        board.move(position, piece);
        // then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(board.findPiece(position)).isEqualTo(piece);
        assertions.assertAll();
        logger.debug("board : \r\n{}", board.showBoard());
    }

    @Test
    @Disabled
    @DisplayName("board.findPiece 메소드를 100번 호출했을때 속도 측정 테스트")
    public void findPiece_speed() {
        // given
        board.initialize();
        // when
        // 100만번 기준 2.239초
        for (int i = 0; i < 1000000; i++) {
            board.findPiece("h1");
        }
        // then
    }
}
