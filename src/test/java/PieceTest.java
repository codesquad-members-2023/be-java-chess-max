import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("createWhitePawn(): 흰색 폰이 생성된다")
    void createWhitePawn() {
        Piece whitePawn = Piece.createWhitePawn();

        assertThat(whitePawn.getColor()).isEqualTo("white");
        assertThat(whitePawn.getType()).isEqualTo("pawn");
        assertThat(whitePawn.getFigure()).isEqualTo("p");
        assertThat(whitePawn.isWhitePawn()).isTrue();
        assertThat(whitePawn.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createWhiteRook(): 흰색 룩이 생성된다")
    void createWhiteRook() {
        Piece whiteRook = Piece.createWhiteRook();

        assertThat(whiteRook.getColor()).isEqualTo("white");
        assertThat(whiteRook.getType()).isEqualTo("rook");
        assertThat(whiteRook.getFigure()).isEqualTo("R");
        assertThat(whiteRook.isWhitePawn()).isTrue();
        assertThat(whiteRook.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createWhiteKnight(): 흰색 나이트가 생성된다")
    void createWhiteKnight() {
        Piece whiteKnight = Piece.createWhiteKnight();

        assertThat(whiteKnight.getColor()).isEqualTo("white");
        assertThat(whiteKnight.getType()).isEqualTo("knight");
        assertThat(whiteKnight.getFigure()).isEqualTo("N");
        assertThat(whiteKnight.isWhitePawn()).isTrue();
        assertThat(whiteKnight.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createWhiteBishop(): 흰색 비숍이 생성된다")
    void createWhiteBishop() {
        Piece whiteBishop = Piece.createWhiteBishop();

        assertThat(whiteBishop.getColor()).isEqualTo("white");
        assertThat(whiteBishop.getType()).isEqualTo("bishop");
        assertThat(whiteBishop.getFigure()).isEqualTo("B");
        assertThat(whiteBishop.isWhitePawn()).isTrue();
        assertThat(whiteBishop.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createWhiteQueen(): 흰색 퀸이 생성된다")
    void createWhiteQueen() {
        Piece whiteQueen = Piece.createWhiteQueen();

        assertThat(whiteQueen.getColor()).isEqualTo("white");
        assertThat(whiteQueen.getType()).isEqualTo("queen");
        assertThat(whiteQueen.getFigure()).isEqualTo("Q");
        assertThat(whiteQueen.isWhitePawn()).isTrue();
        assertThat(whiteQueen.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createWhiteKing(): 흰색 킹이 생성된다")
    void createWhiteKing() {
        Piece whiteKing = Piece.createWhiteKing();

        assertThat(whiteKing.getColor()).isEqualTo("white");
        assertThat(whiteKing.getType()).isEqualTo("king");
        assertThat(whiteKing.getFigure()).isEqualTo("K");
        assertThat(whiteKing.isWhitePawn()).isTrue();
        assertThat(whiteKing.isBlackPawn()).isFalse();
    }

    @Test
    @DisplayName("createBlackPawn(): 검은색 폰이 생성된다")
    void createBlackPawn() {
        Piece blackPawn = Piece.createBlackPawn();

        assertThat(blackPawn.getColor()).isEqualTo("black");
        assertThat(blackPawn.getType()).isEqualTo("pawn");
        assertThat(blackPawn.getFigure()).isEqualTo("p");
        assertThat(blackPawn.isWhitePawn()).isFalse();
        assertThat(blackPawn.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("createBlackRook(): 검은색 룩이 생성된다")
    void createBlackRook() {
        Piece blackRook = Piece.createBlackRook();

        assertThat(blackRook.getColor()).isEqualTo("black");
        assertThat(blackRook.getType()).isEqualTo("rook");
        assertThat(blackRook.getFigure()).isEqualTo("R");
        assertThat(blackRook.isWhitePawn()).isFalse();
        assertThat(blackRook.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("createBlackKnight(): 검은색 나이트가 생성된다")
    void createBlackKnight() {
        Piece blackKnight = Piece.createBlackKnight();

        assertThat(blackKnight.getColor()).isEqualTo("black");
        assertThat(blackKnight.getType()).isEqualTo("knight");
        assertThat(blackKnight.getFigure()).isEqualTo("N");
        assertThat(blackKnight.isWhitePawn()).isFalse();
        assertThat(blackKnight.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("createBlackBishop(): 검은색 비숍이 생성된다")
    void createBlackBishop() {
        Piece blackBishop = Piece.createBlackBishop();

        assertThat(blackBishop.getColor()).isEqualTo("black");
        assertThat(blackBishop.getType()).isEqualTo("bishop");
        assertThat(blackBishop.getFigure()).isEqualTo("B");
        assertThat(blackBishop.isWhitePawn()).isFalse();
        assertThat(blackBishop.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("createBlackQueen(): 검은색 퀸이 생성된다")
    void createBlackQueen() {
        Piece blackQueen = Piece.createBlackQueen();

        assertThat(blackQueen.getColor()).isEqualTo("black");
        assertThat(blackQueen.getType()).isEqualTo("queen");
        assertThat(blackQueen.getFigure()).isEqualTo("Q");
        assertThat(blackQueen.isWhitePawn()).isFalse();
        assertThat(blackQueen.isBlackPawn()).isTrue();
    }

    @Test
    @DisplayName("createBlackKing(): 검은색 킹이 생성된다")
    void createBlackKing() {
        Piece blackKing = Piece.createBlackKing();

        assertThat(blackKing.getColor()).isEqualTo("black");
        assertThat(blackKing.getType()).isEqualTo("king");
        assertThat(blackKing.getFigure()).isEqualTo("K");
        assertThat(blackKing.isWhitePawn()).isFalse();
        assertThat(blackKing.isBlackPawn()).isTrue();
    }
}
