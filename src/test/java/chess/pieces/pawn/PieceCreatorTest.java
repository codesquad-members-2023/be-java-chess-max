package chess.pieces.pawn;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.PieceCreator;
import chess.pieces.Type;
import chess.pieces.bishop.BlackBishop;
import chess.pieces.bishop.WhiteBishop;
import chess.pieces.king.BlackKing;
import chess.pieces.king.WhiteKing;
import chess.pieces.knight.BlackKnight;
import chess.pieces.knight.WhiteKnight;
import chess.pieces.queen.BlackQueen;
import chess.pieces.queen.WhiteQueen;
import chess.pieces.rook.BlackRook;
import chess.pieces.rook.WhiteRook;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PieceCreatorTest {

    @DisplayName("색상에 따라 Pawn를 생성한다")
    @MethodSource("provideCreatePiece")
    @ParameterizedTest
    void create(Type type, Color color, Class<Piece> clazz) {
        Piece piece = PieceCreator.create(type, color);

        assertThat(piece.getClass()).isEqualTo(clazz);
    }

    private static Stream<Arguments> provideCreatePiece() {
        return Stream.of(
                Arguments.of(Type.PAWN, Color.WHITE, WhitePawn.class),
                Arguments.of(Type.PAWN, Color.BLACK, BlackPawn.class),
                Arguments.of(Type.ROOK, Color.WHITE, WhiteRook.class),
                Arguments.of(Type.ROOK, Color.BLACK, BlackRook.class),
                Arguments.of(Type.KNIGHT, Color.WHITE, WhiteKnight.class),
                Arguments.of(Type.KNIGHT, Color.BLACK, BlackKnight.class),
                Arguments.of(Type.BISHOP, Color.WHITE, WhiteBishop.class),
                Arguments.of(Type.BISHOP, Color.BLACK, BlackBishop.class),
                Arguments.of(Type.QUEEN, Color.WHITE, WhiteQueen.class),
                Arguments.of(Type.QUEEN, Color.BLACK, BlackQueen.class),
                Arguments.of(Type.KING, Color.WHITE, WhiteKing.class),
                Arguments.of(Type.KING, Color.BLACK, BlackKing.class)
        );
    }
}
