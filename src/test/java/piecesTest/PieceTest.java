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

        assertThat(whitePawn.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whitePawn.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whitePawn.isType(Piece.Type.PAWN)).isTrue();
        assertThat(whitePawn.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whitePawn.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whitePawn.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(whitePawn.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whitePawn.isType(Piece.Type.KING)).isFalse();
        assertThat(whitePawn.isBlank()).isFalse();
        assertThat(whitePawn.getShape()).isEqualTo('p');
        assertThat(whitePawn.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("createWhiteRook(): 흰색 룩이 생성된다")
    void createWhiteRook() {
        Piece whiteRook = Piece.createWhiteRook();

        assertThat(whiteRook.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whiteRook.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whiteRook.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteRook.isType(Piece.Type.ROOK)).isTrue();
        assertThat(whiteRook.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whiteRook.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(whiteRook.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whiteRook.isType(Piece.Type.KING)).isFalse();
        assertThat(whiteRook.isBlank()).isFalse();
        assertThat(whiteRook.getShape()).isEqualTo('r');
        assertThat(whiteRook.getScore()).isEqualTo(5);
    }

    @Test
    @DisplayName("createWhiteKnight(): 흰색 나이트가 생성된다")
    void createWhiteKnight() {
        Piece whiteKnight = Piece.createWhiteKnight();

        assertThat(whiteKnight.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whiteKnight.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whiteKnight.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteKnight.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whiteKnight.isType(Piece.Type.KNIGHT)).isTrue();
        assertThat(whiteKnight.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(whiteKnight.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whiteKnight.isType(Piece.Type.KING)).isFalse();
        assertThat(whiteKnight.isBlank()).isFalse();
        assertThat(whiteKnight.getShape()).isEqualTo('n');
        assertThat(whiteKnight.getScore()).isEqualTo(2.5);
    }

    @Test
    @DisplayName("createWhiteBishop(): 흰색 비숍이 생성된다")
    void createWhiteBishop() {
        Piece whiteBishop = Piece.createWhiteBishop();

        assertThat(whiteBishop.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whiteBishop.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.BISHOP)).isTrue();
        assertThat(whiteBishop.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.KING)).isFalse();
        assertThat(whiteBishop.isBlank()).isFalse();
        assertThat(whiteBishop.getShape()).isEqualTo('b');
        assertThat(whiteBishop.getScore()).isEqualTo(3);
    }

    @Test
    @DisplayName("createWhiteQueen(): 흰색 퀸이 생성된다")
    void createWhiteQueen() {
        Piece whiteQueen = Piece.createWhiteQueen();

        assertThat(whiteQueen.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whiteQueen.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whiteQueen.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteQueen.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whiteQueen.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whiteQueen.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(whiteQueen.isType(Piece.Type.QUEEN)).isTrue();
        assertThat(whiteQueen.isType(Piece.Type.KING)).isFalse();
        assertThat(whiteQueen.isBlank()).isFalse();
        assertThat(whiteQueen.getShape()).isEqualTo('q');
        assertThat(whiteQueen.getScore()).isEqualTo(9);
    }

    @Test
    @DisplayName("createWhiteKing(): 흰색 킹이 생성된다")
    void createWhiteKing() {
        Piece whiteKing = Piece.createWhiteKing();

        assertThat(whiteKing.isColor(Piece.Color.WHITE)).isTrue();
        assertThat(whiteKing.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whiteKing.isType(Piece.Type.KING)).isTrue();
        assertThat(whiteKing.isBlank()).isFalse();
        assertThat(whiteKing.getShape()).isEqualTo('k');
        assertThat(whiteKing.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("createBlackPawn(): 검정색 폰이 생성된다")
    void createBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(blackPawn.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blackPawn.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(blackPawn.isType(Piece.Type.PAWN)).isTrue();
        assertThat(blackPawn.isType(Piece.Type.ROOK)).isFalse();
        assertThat(blackPawn.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(blackPawn.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blackPawn.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(blackPawn.isType(Piece.Type.KING)).isFalse();
        assertThat(blackPawn.isBlank()).isFalse();
        assertThat(blackPawn.getShape()).isEqualTo('P');
        assertThat(blackPawn.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("createBlackRook(): 검정색 룩이 생성된다")
    void createBlackRook() {
        Piece blackRook = Piece.createBlackRook();

        assertThat(blackRook.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blackRook.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(blackRook.isType(Piece.Type.PAWN)).isFalse();
        assertThat(blackRook.isType(Piece.Type.ROOK)).isTrue();
        assertThat(blackRook.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(blackRook.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blackRook.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(blackRook.isType(Piece.Type.KING)).isFalse();
        assertThat(blackRook.isBlank()).isFalse();
        assertThat(blackRook.getShape()).isEqualTo('R');
        assertThat(blackRook.getScore()).isEqualTo(5);
    }

    @Test
    @DisplayName("createBlackKnight(): 검정색 나이트가 생성된다")
    void createBlackKnight() {
        Piece blackKnight = Piece.createBlackKnight();

        assertThat(blackKnight.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blackKnight.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(blackKnight.isType(Piece.Type.PAWN)).isFalse();
        assertThat(blackKnight.isType(Piece.Type.ROOK)).isFalse();
        assertThat(blackKnight.isType(Piece.Type.KNIGHT)).isTrue();
        assertThat(blackKnight.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blackKnight.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(blackKnight.isType(Piece.Type.KING)).isFalse();
        assertThat(blackKnight.isBlank()).isFalse();
        assertThat(blackKnight.getShape()).isEqualTo('N');
        assertThat(blackKnight.getScore()).isEqualTo(2.5);
    }

    @Test
    @DisplayName("createBlackBishop(): 검정색 비숍이 생성된다")
    void createBlackBishop() {
        Piece whiteBishop = Piece.createBlackBishop();

        assertThat(whiteBishop.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(whiteBishop.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(whiteBishop.isType(Piece.Type.PAWN)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.ROOK)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.BISHOP)).isTrue();
        assertThat(whiteBishop.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(whiteBishop.isType(Piece.Type.KING)).isFalse();
        assertThat(whiteBishop.isBlank()).isFalse();
        assertThat(whiteBishop.getShape()).isEqualTo('B');
        assertThat(whiteBishop.getScore()).isEqualTo(3);
    }

    @Test
    @DisplayName("createBlackQueen(): 검정색 퀸이 생성된다")
    void createBlackQueen() {
        Piece blackQueen = Piece.createBlackQueen();

        assertThat(blackQueen.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blackQueen.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(blackQueen.isType(Piece.Type.PAWN)).isFalse();
        assertThat(blackQueen.isType(Piece.Type.ROOK)).isFalse();
        assertThat(blackQueen.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(blackQueen.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blackQueen.isType(Piece.Type.QUEEN)).isTrue();
        assertThat(blackQueen.isType(Piece.Type.KING)).isFalse();
        assertThat(blackQueen.isBlank()).isFalse();
        assertThat(blackQueen.getShape()).isEqualTo('Q');
        assertThat(blackQueen.getScore()).isEqualTo(9);
    }

    @Test
    @DisplayName("createBlackKing(): 검정색 킹이 생성된다")
    void createBlackKing() {
        Piece blackKing = Piece.createBlackKing();

        assertThat(blackKing.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blackKing.isColor(Piece.Color.BLACK)).isTrue();
        assertThat(blackKing.isType(Piece.Type.PAWN)).isFalse();
        assertThat(blackKing.isType(Piece.Type.ROOK)).isFalse();
        assertThat(blackKing.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(blackKing.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blackKing.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(blackKing.isType(Piece.Type.KING)).isTrue();
        assertThat(blackKing.isBlank()).isFalse();
        assertThat(blackKing.getShape()).isEqualTo('K');
        assertThat(blackKing.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("createBlank(): 빈 칸이 생성된다")
    void createBlank() {
        Piece blank = Piece.createBlank();

        assertThat(blank.isColor(Piece.Color.WHITE)).isFalse();
        assertThat(blank.isColor(Piece.Color.BLACK)).isFalse();
        assertThat(blank.isType(Piece.Type.PAWN)).isFalse();
        assertThat(blank.isType(Piece.Type.ROOK)).isFalse();
        assertThat(blank.isType(Piece.Type.KNIGHT)).isFalse();
        assertThat(blank.isType(Piece.Type.BISHOP)).isFalse();
        assertThat(blank.isType(Piece.Type.QUEEN)).isFalse();
        assertThat(blank.isType(Piece.Type.KING)).isFalse();
        assertThat(blank.isBlank()).isTrue();
        assertThat(blank.getShape()).isEqualTo('.');
        assertThat(blank.getScore()).isEqualTo(0);
    }
}
