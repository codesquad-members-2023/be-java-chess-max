package chess;

import chess.piece.Blank;
import chess.piece.King;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Position;
import chess.piece.Queen;
import chess.piece.Rook;
import chess.view.ChessView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.piece.Color.BLACK;
import static chess.piece.Color.WHITE;
import static chess.piece.Type.BISHOP;
import static chess.piece.Type.PAWN;
import static chess.util.StringUtil.NEW_LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;
    private ChessView view;

    @BeforeEach
    public void setUp() {
        board = new Board();
        view = new ChessView();
    }

    @Test
    @DisplayName("initialize: 체스판의 모든 칸을 Piece로 초기화한다")
    public void initialize() {
        board.initialize();

        String blankLine = "........" + NEW_LINE;
        String blackPieces = "RNBQKBNR" + NEW_LINE;
        String blackPawns = "PPPPPPPP" + NEW_LINE;
        String whitePawns = "pppppppp" + NEW_LINE;
        String whitePieces = "rnbqkbnr";

        assertAll(() -> assertThat(board.countPieces()).isEqualTo(32),
                  () -> assertThat(view.view(board)).isEqualTo(
                          blackPieces + blackPawns +
                                  blankLine + blankLine + blankLine + blankLine +
                                  whitePawns + whitePieces));
    }

    @Test
    @DisplayName("countPiecesByColorAndType: 색과 종류가 일치하는 기물의 개수를 반환한다")
    public void countPiecesByColorAndType() {
        board.initialize();

        assertAll(() -> assertThat(board.countPiecesByColorAndType(WHITE, PAWN)).isEqualTo(8),
                  () -> assertThat(board.countPiecesByColorAndType(BLACK, BISHOP)).isEqualTo(2));
    }

    @Test
    @DisplayName("findPiece: 주어진 위치의 기물을 조회한다")
    public void findPiece() {
        board.initialize();

        assertAll(() -> assertThat(Rook.createBlack(new Position("a8"))).isEqualTo(board.findPiece("a8")),
                  () -> assertThat(Rook.createBlack(new Position("h8"))).isEqualTo(board.findPiece("h8")),
                  () -> assertThat(Rook.createWhite(new Position("a1"))).isEqualTo(board.findPiece("a1")),
                  () -> assertThat(Rook.createWhite(new Position("h1"))).isEqualTo(board.findPiece("h1")));
    }

    @Test
    @DisplayName("빈 체스판에 임의의 기물을 추가한다")
    public void move() {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Rook.createBlack(new Position(position));
        board.put(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
    }

    @Test
    @DisplayName("calculatePoint: 체스판의 점수를 계산한다")
    public void calculatePoint() {
        board.initializeEmpty();

        addPiece(Pawn.createBlack(new Position("b6")));
        addPiece(Queen.createBlack(new Position("e6")));
        addPiece(King.createBlack(new Position("b8")));
        addPiece(Rook.createBlack(new Position("c8")));

        addPiece(Pawn.createWhite(new Position("f2")));
        addPiece(Pawn.createWhite(new Position("g2")));
        addPiece(Rook.createWhite(new Position("e1")));
        addPiece(King.createWhite(new Position("f1")));

        assertAll(() -> assertThat(board.calculatePoint(BLACK)).isEqualTo(15.0),
                  () -> assertThat(board.calculatePoint(WHITE)).isEqualTo(7.0));
    }

    @Test
    @DisplayName("같은 세로 방향에 있는 같은 색의 Pawn의 점수는 0.5점으로 계산한다")
    public void calculatePawnPoint() {
        board.initializeEmpty();

        addPiece(Pawn.createBlack(new Position("b6")));
        addPiece(Pawn.createBlack(new Position("b5")));
        addPiece(Pawn.createBlack(new Position("b4")));

        addPiece(Pawn.createWhite(new Position("g6")));
        addPiece(Pawn.createWhite(new Position("f5")));
        addPiece(Pawn.createWhite(new Position("e4")));

        assertAll(() -> assertThat(board.calculatePoint(BLACK)).isEqualTo(1.5),
                  () -> assertThat(board.calculatePoint(WHITE)).isEqualTo(3.0));
    }

    private void addPiece(Piece piece) {
        board.put(piece.getPosition(), piece);
    }

    @Test
    @DisplayName("move: 기물을 특정 위치로 이동한다")
    public void movePiece() {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);

        assertAll(() -> assertThat(Blank.create(new Position(sourcePosition))).isEqualTo(board.findPiece(sourcePosition)),
                  () -> assertThat(Pawn.createWhite(new Position(targetPosition))).isEqualTo(board.findPiece(targetPosition)));
    }

}
