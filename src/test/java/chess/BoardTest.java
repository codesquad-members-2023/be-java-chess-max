package chess;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.PieceCreator;
import chess.pieces.Type;
import chess.pieces.pawn.BlackPawn;
import chess.pieces.pawn.WhitePawn;
import chess.pieces.queen.WhiteQueen;
import chess.pieces.rook.BlackRook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    @DisplayName("Board 초기화 출력")
    @Test
    void initAndPrint() {
        Board board = new Board();
        assertThat(board.print()).isEqualTo(
                """
                        RNBQKBNR  8 (rank 8)
                        PPPPPPPP  7
                        ........  6
                        ........  5
                        ........  4
                        ........  3
                        pppppppp  2
                        rnbqkbnr  1 (rank 1)

                        abcdefgh"""
        );
    }

    @DisplayName("주어진 위치의 기물을 조회")
    @Test
    void findPiece() {
        Board board = new Board();

        assertThat(board.findPiece(Position.parse("a8"))).containsInstanceOf(BlackRook.class);
        assertThat(board.findPiece(Position.parse("c7"))).containsInstanceOf(BlackPawn.class);
        assertThat(board.findPiece(Position.parse("c4"))).isEmpty();
        assertThat(board.findPiece(Position.parse("c2"))).containsInstanceOf(WhitePawn.class);
        assertThat(board.findPiece(Position.parse("d1"))).containsInstanceOf(WhiteQueen.class);

    }

    @DisplayName("임의의 기물을 체스판 위에 추가")
    @Test
    void move() {
        // given
        Board board = new Board();
        Position position = Position.parse("b5");
        Piece piece = PieceCreator.create(Type.ROOK, Color.BLACK);

        // when
        board.move(position, piece);

        // then
        assertThat(board.findPiece(position)).contains(piece);
    }

    @DisplayName("체스 프로그램 점수 계산하기")
    @Test
    public void calculatePoint() {
        Board board = new Board();

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(38);
        board.move(Position.parse("a8"), null);
        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(33);
        board.move(Position.parse("a7"), new BlackRook());
        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(33.5);

        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(38);

        board.move(Position.parse("b1"), null);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(35.5);
    }
}

