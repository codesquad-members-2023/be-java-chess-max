package piecesTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("createWhitePawn(): 흰색 폰이 생성된다")
    void createWhitePawn() {
        Piece whitePawn = Piece.createWhitePawn();

        assertThat(whitePawn.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whitePawn.getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(whitePawn.getShape()).isEqualTo('p');
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();
        assertThat(whitePawn.isPawn()).isTrue();
        assertThat(whitePawn.isRook()).isFalse();
        assertThat(whitePawn.isKnight()).isFalse();
        assertThat(whitePawn.isBishop()).isFalse();
        assertThat(whitePawn.isQueen()).isFalse();
        assertThat(whitePawn.isKing()).isFalse();
        assertThat(whitePawn.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createWhiteRook(): 흰색 룩이 생성된다")
    void createWhiteRook() {
        Piece whiteRook = Piece.createWhiteRook();

        assertThat(whiteRook.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whiteRook.getType()).isEqualTo(Piece.Type.ROOK);
        assertThat(whiteRook.getShape()).isEqualTo('r');
        assertThat(whiteRook.isWhite()).isTrue();
        assertThat(whiteRook.isBlack()).isFalse();
        assertThat(whiteRook.isPawn()).isFalse();
        assertThat(whiteRook.isRook()).isTrue();
        assertThat(whiteRook.isKnight()).isFalse();
        assertThat(whiteRook.isBishop()).isFalse();
        assertThat(whiteRook.isQueen()).isFalse();
        assertThat(whiteRook.isKing()).isFalse();
        assertThat(whiteRook.isBlank()).isFalse();

    }

    @Test
    @DisplayName("createWhiteKnight(): 흰색 나이트가 생성된다")
    void createWhiteKnight() {
        Piece whiteKnight = Piece.createWhiteKnight();

        assertThat(whiteKnight.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whiteKnight.getType()).isEqualTo(Piece.Type.KNIGHT);
        assertThat(whiteKnight.getShape()).isEqualTo('n');
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(whiteKnight.isBlack()).isFalse();
        assertThat(whiteKnight.isPawn()).isFalse();
        assertThat(whiteKnight.isRook()).isFalse();
        assertThat(whiteKnight.isKnight()).isTrue();
        assertThat(whiteKnight.isBishop()).isFalse();
        assertThat(whiteKnight.isQueen()).isFalse();
        assertThat(whiteKnight.isKing()).isFalse();
        assertThat(whiteKnight.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createWhiteBishop(): 흰색 비숍이 생성된다")
    void createWhiteBishop() {
        Piece whiteBishop = Piece.createWhiteBishop();

        assertThat(whiteBishop.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whiteBishop.getType()).isEqualTo(Piece.Type.BISHOP);
        assertThat(whiteBishop.getShape()).isEqualTo('b');
        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
        assertThat(whiteBishop.isPawn()).isFalse();
        assertThat(whiteBishop.isRook()).isFalse();
        assertThat(whiteBishop.isKnight()).isFalse();
        assertThat(whiteBishop.isBishop()).isTrue();
        assertThat(whiteBishop.isQueen()).isFalse();
        assertThat(whiteBishop.isKing()).isFalse();
        assertThat(whiteBishop.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createWhiteQueen(): 흰색 퀸이 생성된다")
    void createWhiteQueen() {
        Piece whiteQueen = Piece.createWhiteQueen();

        assertThat(whiteQueen.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whiteQueen.getType()).isEqualTo(Piece.Type.QUEEN);
        assertThat(whiteQueen.getShape()).isEqualTo('q');
        assertThat(whiteQueen.isWhite()).isTrue();
        assertThat(whiteQueen.isBlack()).isFalse();
        assertThat(whiteQueen.isPawn()).isFalse();
        assertThat(whiteQueen.isRook()).isFalse();
        assertThat(whiteQueen.isKnight()).isFalse();
        assertThat(whiteQueen.isBishop()).isFalse();
        assertThat(whiteQueen.isQueen()).isTrue();
        assertThat(whiteQueen.isKing()).isFalse();
        assertThat(whiteQueen.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createWhiteKing(): 흰색 킹이 생성된다")
    void createWhiteKing() {
        Piece whiteKing = Piece.createWhiteKing();

        assertThat(whiteKing.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(whiteKing.getType()).isEqualTo(Piece.Type.KING);
        assertThat(whiteKing.getShape()).isEqualTo('k');
        assertThat(whiteKing.isWhite()).isTrue();
        assertThat(whiteKing.isBlack()).isFalse();
        assertThat(whiteKing.isPawn()).isFalse();
        assertThat(whiteKing.isRook()).isFalse();
        assertThat(whiteKing.isKnight()).isFalse();
        assertThat(whiteKing.isBishop()).isFalse();
        assertThat(whiteKing.isQueen()).isFalse();
        assertThat(whiteKing.isKing()).isTrue();
        assertThat(whiteKing.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackPawn(): 검은색 폰이 생성된다")
    void createBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(blackPawn.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackPawn.getType()).isEqualTo(Piece.Type.PAWN);
        assertThat(blackPawn.getShape()).isEqualTo('P');
        assertThat(blackPawn.isWhite()).isFalse();
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(blackPawn.isPawn()).isTrue();
        assertThat(blackPawn.isRook()).isFalse();
        assertThat(blackPawn.isKnight()).isFalse();
        assertThat(blackPawn.isBishop()).isFalse();
        assertThat(blackPawn.isQueen()).isFalse();
        assertThat(blackPawn.isKing()).isFalse();
        assertThat(blackPawn.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackRook(): 검은색 룩이 생성된다")
    void createBlackRook() {
        Piece blackRook = Piece.createBlackRook();

        assertThat(blackRook.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackRook.getType()).isEqualTo(Piece.Type.ROOK);
        assertThat(blackRook.getShape()).isEqualTo('R');
        assertThat(blackRook.isWhite()).isFalse();
        assertThat(blackRook.isBlack()).isTrue();
        assertThat(blackRook.isPawn()).isFalse();
        assertThat(blackRook.isRook()).isTrue();
        assertThat(blackRook.isKnight()).isFalse();
        assertThat(blackRook.isBishop()).isFalse();
        assertThat(blackRook.isQueen()).isFalse();
        assertThat(blackRook.isKing()).isFalse();
        assertThat(blackRook.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackKnight(): 검은색 나이트가 생성된다")
    void createBlackKnight() {
        Piece blackKnight = Piece.createBlackKnight();

        assertThat(blackKnight.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackKnight.getType()).isEqualTo(Piece.Type.KNIGHT);
        assertThat(blackKnight.getShape()).isEqualTo('N');
        assertThat(blackKnight.isWhite()).isFalse();
        assertThat(blackKnight.isBlack()).isTrue();
        assertThat(blackKnight.isPawn()).isFalse();
        assertThat(blackKnight.isRook()).isFalse();
        assertThat(blackKnight.isKnight()).isTrue();
        assertThat(blackKnight.isBishop()).isFalse();
        assertThat(blackKnight.isQueen()).isFalse();
        assertThat(blackKnight.isKing()).isFalse();
        assertThat(blackKnight.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackBishop(): 검은색 비숍이 생성된다")
    void createBlackBishop() {
        Piece blackBishop = Piece.createBlackBishop();

        assertThat(blackBishop.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackBishop.getType()).isEqualTo(Piece.Type.BISHOP);
        assertThat(blackBishop.getShape()).isEqualTo('B');
        assertThat(blackBishop.isWhite()).isFalse();
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(blackBishop.isPawn()).isFalse();
        assertThat(blackBishop.isRook()).isFalse();
        assertThat(blackBishop.isKnight()).isFalse();
        assertThat(blackBishop.isBishop()).isTrue();
        assertThat(blackBishop.isQueen()).isFalse();
        assertThat(blackBishop.isKing()).isFalse();
        assertThat(blackBishop.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackQueen(): 검은색 퀸이 생성된다")
    void createBlackQueen() {
        Piece blackQueen = Piece.createBlackQueen();

        assertThat(blackQueen.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackQueen.getType()).isEqualTo(Piece.Type.QUEEN);
        assertThat(blackQueen.getShape()).isEqualTo('Q');
        assertThat(blackQueen.isWhite()).isFalse();
        assertThat(blackQueen.isBlack()).isTrue();
        assertThat(blackQueen.isPawn()).isFalse();
        assertThat(blackQueen.isRook()).isFalse();
        assertThat(blackQueen.isKnight()).isFalse();
        assertThat(blackQueen.isBishop()).isFalse();
        assertThat(blackQueen.isQueen()).isTrue();
        assertThat(blackQueen.isKing()).isFalse();
        assertThat(blackQueen.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlackKing(): 검은색 킹이 생성된다")
    void createBlackKing() {
        Piece blackKing = Piece.createBlackKing();

        assertThat(blackKing.getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(blackKing.getType()).isEqualTo(Piece.Type.KING);
        assertThat(blackKing.getShape()).isEqualTo('K');
        assertThat(blackKing.isWhite()).isFalse();
        assertThat(blackKing.isBlack()).isTrue();
        assertThat(blackKing.isPawn()).isFalse();
        assertThat(blackKing.isRook()).isFalse();
        assertThat(blackKing.isKnight()).isFalse();
        assertThat(blackKing.isBishop()).isFalse();
        assertThat(blackKing.isQueen()).isFalse();
        assertThat(blackKing.isKing()).isTrue();
        assertThat(blackKing.isBlank()).isFalse();
    }

    @Test
    @DisplayName("createBlank(): 빈 칸이 생성된다")
    void createBlank() {
        Piece blank = Piece.createBlank();

        assertThat(blank.getColor()).isEqualTo(Piece.Color.NOCOLOR);
        assertThat(blank.getType()).isEqualTo(Piece.Type.NOTYPE);
        assertThat(blank.getShape()).isEqualTo('.');
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isPawn()).isFalse();
        assertThat(blank.isRook()).isFalse();
        assertThat(blank.isKnight()).isFalse();
        assertThat(blank.isBishop()).isFalse();
        assertThat(blank.isQueen()).isFalse();
        assertThat(blank.isKing()).isFalse();
        assertThat(blank.isBlank()).isTrue();
    }
}
