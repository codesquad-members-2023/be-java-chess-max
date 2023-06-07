import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("initialize(): 첫번째 rank를 초기화한다.")
    public void initialize1stLine() {
        Rank rank = Rank.initialize(1);

        assertThat(rank.getShape()).isEqualTo("rnbqkbnr");
    }

    @Test
    @DisplayName("initialize(): 두번째 rank를 초기화한다.")
    public void initialize2ㅜㅇLine() {
        Rank rank = Rank.initialize(2);

        assertThat(rank.getShape()).isEqualTo("pppppppp");
    }

    @Test
    @DisplayName("initialize(): 일곱번째 rank를 초기화한다.")
    public void initialize7thLine() {
        Rank rank = Rank.initialize(7);

        assertThat(rank.getShape()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("initialize(): 여덟번째 rank를 초기화한다.")
    public void initialize8thLine() {
        Rank rank = Rank.initialize(8);

        assertThat(rank.getShape()).isEqualTo("RNBQKBNR");
    }

    @Test
    @DisplayName("initialize(): 기물이 없는 rank를 초기화한다.")
    public void initializeEmptyLine() {
        Rank rank = Rank.initialize(0);

        assertThat(rank.getShape()).isEqualTo("........");
    }

    @Test
    @DisplayName("insert(): 특정 index에 piece를 넣는다")
    public void insertPiece() {
        Rank rank = Rank.initialize(0);
        Piece piece = Piece.createBlackBishop();

        rank.insert(piece, 'd');

        assertThat(rank.getShape()).isEqualTo("...B....");
    }

    @Test
    @DisplayName("getPieceAt(): 특정 index의 piece를 가져온다")
    public void getPieceAtIndex() {
        Rank rank = Rank.initialize(1);

        Piece piece = rank.getPieceAt('e');

        assertThat(piece.getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(piece.getType()).isEqualTo(Piece.Type.KING);
    }
}
