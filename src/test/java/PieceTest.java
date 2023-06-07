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
    }

    @Test
    @DisplayName("createBlank(): 빈 칸이 생성된다")
    void createBlank() {
        Piece blackKing = Piece.createBlank();

        assertThat(blackKing.getColor()).isEqualTo(Piece.Color.NOCOLOR);
        assertThat(blackKing.getType()).isEqualTo(Piece.Type.NOTYPE);
        assertThat(blackKing.getShape()).isEqualTo('.');
        assertThat(blackKing.isWhite()).isFalse();
        assertThat(blackKing.isBlack()).isFalse();
    }
}
