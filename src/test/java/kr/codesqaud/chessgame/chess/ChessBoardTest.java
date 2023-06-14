package kr.codesqaud.chessgame.chess;


import static kr.codesqaud.chessgame.chess.pieces.Position.createPosition;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.chess.pieces.config.Color.WHITE;
import static org.assertj.core.data.Offset.offset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kr.codesqaud.chessgame.chess.board.ChessBoard;
import kr.codesqaud.chessgame.chess.pieces.Bishop;
import kr.codesqaud.chessgame.chess.pieces.Blank;
import kr.codesqaud.chessgame.chess.pieces.King;
import kr.codesqaud.chessgame.chess.pieces.Knight;
import kr.codesqaud.chessgame.chess.pieces.Pawn;
import kr.codesqaud.chessgame.chess.pieces.Piece;
import kr.codesqaud.chessgame.chess.pieces.Position;
import kr.codesqaud.chessgame.chess.pieces.Queen;
import kr.codesqaud.chessgame.chess.pieces.Rook;
import kr.codesqaud.chessgame.chess.pieces.config.Type;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.exception.InvalidPositionException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ChessBoardTest {

    private static final Logger logger = LoggerFactory.getLogger(ChessBoardTest.class);

    private ChessBoard board;

    @BeforeEach
    public void setup() {
        board = new ChessBoard();
    }

    @Test
    @DisplayName("체스판 객체에 초기화를 요청하면 흑백 기물들이 특정한 위치에 초기화된다")
    public void initialize() throws IOException {
        // given
        String expectedBoardFilePath = "src/test/resources/chessBoard.txt";
        // when
        board.initialize();
        // then
        String expectedBoard = Files.readString(Paths.get(expectedBoardFilePath));
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(board.countAllPiece()).isEqualTo(32);
            softAssertions.assertThat(board.showBoard()).isEqualTo(expectedBoard);
        });
    }

    @Test
    @DisplayName("체스판 위에 기물들이 초기화된 상태에서 색상과 종류에 따른 기물 개수를 요청할때 초기화된 상태에서의 기물 개수랑 동일하다")
    public void countPieceByColorAndType() {
        // given
        board.initialize();
        // when
        int blackPawnCount = board.countPieceByColorAndType(BLACK, Type.PAWN);
        int blackRookCount = board.countPieceByColorAndType(BLACK, Type.ROOK);
        int blackKnightCount = board.countPieceByColorAndType(BLACK, Type.KNIGHT);
        int blackBishopCount = board.countPieceByColorAndType(BLACK, Type.BISHOP);
        int blackQueenCount = board.countPieceByColorAndType(BLACK, Type.QUEEN);
        int blackKingCount = board.countPieceByColorAndType(BLACK, Type.KING);
        int whitePawnCount = board.countPieceByColorAndType(WHITE, Type.PAWN);
        int whiteRookCount = board.countPieceByColorAndType(WHITE, Type.ROOK);
        int whiteKnightCount = board.countPieceByColorAndType(WHITE, Type.KNIGHT);
        int whiteBishopCount = board.countPieceByColorAndType(WHITE, Type.BISHOP);
        int whiteQueenCount = board.countPieceByColorAndType(WHITE, Type.QUEEN);
        int whiteKingCount = board.countPieceByColorAndType(WHITE, Type.KING);
        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(blackPawnCount).isEqualTo(8);
            softAssertions.assertThat(blackRookCount).isEqualTo(2);
            softAssertions.assertThat(blackKnightCount).isEqualTo(2);
            softAssertions.assertThat(blackBishopCount).isEqualTo(2);
            softAssertions.assertThat(blackQueenCount).isEqualTo(1);
            softAssertions.assertThat(blackKingCount).isEqualTo(1);
            softAssertions.assertThat(whitePawnCount).isEqualTo(8);
            softAssertions.assertThat(whiteRookCount).isEqualTo(2);
            softAssertions.assertThat(whiteKnightCount).isEqualTo(2);
            softAssertions.assertThat(whiteBishopCount).isEqualTo(2);
            softAssertions.assertThat(whiteQueenCount).isEqualTo(1);
            softAssertions.assertThat(whiteKingCount).isEqualTo(1);
        });
    }

    @Test
    @DisplayName("체스판이 초기화된 상태에서 특정 위치의 기물을 탐색하고자 요청할때 초기화된 상태에서의 기물과 동일하다")
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
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(blackRook).isEqualTo(Rook.createBlack(createPosition("a8")));
            softAssertions.assertThat(blackRook2).isEqualTo(Rook.createBlack(createPosition("h8")));
            softAssertions.assertThat(whiteRook).isEqualTo(Rook.createWhite(createPosition("a1")));
            softAssertions.assertThat(whiteRook2).isEqualTo(Rook.createWhite(createPosition("h1")));
            softAssertions.assertThat(emptyPiece).isEqualTo(Blank.create(createPosition("a6")));
        });
    }

    @Test
    @DisplayName("빈 체스판이 주어지고 특정 위치에 기물을 설정을 요청할때 해당 위치에 기물이 존재한다")
    public void setPiece() {
        // given
        board.initializeEmpty();
        String sourcePosition = "b5";
        Piece piece = Rook.createBlack(createPosition(sourcePosition));
        // when
        board.setPiece(sourcePosition, piece);
        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(board.findPiece(sourcePosition))
                .isEqualTo(Rook.createBlack(createPosition(sourcePosition)));
        });
    }

    @Test
    @DisplayName("체스판 위에 기물이 주어지고 흑색과 백색을 구분해서 점수가 높은 순서로 정렬을 요청시 높은 순서로 정렬되어 응답한다")
    public void sortByColor() {
        // given
        board.initializeEmpty();
        // 흑색 기물 초기화
        board.setPiece("b6", Pawn.createBlack(createPosition("b6")));
        board.setPiece("e6", Queen.createBlack(createPosition("e6")));
        board.setPiece("b8", King.createBlack(createPosition("b8")));
        board.setPiece("c8", Rook.createBlack(createPosition("c8")));
        // when
        List<Piece> increasePieces = board.sortIncreaseByColor(BLACK); // 오름차순 정렬
        List<Piece> decreasePieces = board.sortDecreaseByColor(BLACK); // 내림차순 정렬
        // then
        List<Piece> expectedDecreasePiece = new ArrayList<>();
        expectedDecreasePiece.add(Queen.createBlack(createPosition("e6")));
        expectedDecreasePiece.add(Rook.createBlack(createPosition("c8")));
        expectedDecreasePiece.add(Pawn.createBlack(createPosition("b6")));
        expectedDecreasePiece.add(King.createBlack(createPosition("b8")));

        List<Piece> expectedIncreasePiece = new ArrayList<>();
        expectedIncreasePiece.add(King.createBlack(createPosition("b8")));
        expectedIncreasePiece.add(Pawn.createBlack(createPosition("b6")));
        expectedIncreasePiece.add(Rook.createBlack(createPosition("c8")));
        expectedIncreasePiece.add(Queen.createBlack(createPosition("e6")));

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(decreasePieces).isEqualTo(expectedDecreasePiece);
            softAssertions.assertThat(increasePieces).isEqualTo(expectedIncreasePiece);
        });
    }

    @Test
    @DisplayName("체스판 위에 기물이 주어지고 남아있는 기물에 대한 색상별 점수합계를 요청할때 점수합계가 일치한다")
    public void calculatePoint() {
        // given
        board.initializeEmpty();
        // 흑색 초기화
        board.setPiece("b6", Pawn.createBlack(createPosition("b6")));
        board.setPiece("e6", Queen.createBlack(createPosition("e6")));
        board.setPiece("b8", King.createBlack(createPosition("b8")));
        board.setPiece("c8", Rook.createBlack(createPosition("c8")));
        // 백색 초기화
        board.setPiece("f2", Pawn.createWhite(createPosition("f2")));
        board.setPiece("g2", Pawn.createWhite(createPosition("g2")));
        board.setPiece("e1", Rook.createWhite(createPosition("e1")));
        board.setPiece("f1", King.createWhite(createPosition("f1")));
        // when
        double blackScore = board.calculatePoint(BLACK);
        double whiteScore = board.calculatePoint(WHITE);
        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(blackScore).isEqualTo(15.0, offset(0.01));
            softAssertions.assertThat(whiteScore).isEqualTo(7.0, offset(0.01));
        });
    }

    @Nested
    @DisplayName("기물 이동 테스트")
    class BoardMoveTest {

        private ChessBoard board;

        @BeforeEach
        public void setup() {
            board = new ChessBoard();
        }

        @Test
        @DisplayName("백폰 b2->b3 이동")
        public void move_whitePawn_b2_b3() {
            // given
            board.initialize();
            String sourcePosition = "b2";
            String targetPosition = "b3";
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Pawn.createWhite(createPosition(targetPosition)));
            });
        }


        @Test
        @DisplayName("백폰 a2->a5 부적절한 이동시 거부됩니다.")
        public void move_whitePawn_a2_a5_rejection() {
            // given
            board.initialize();
            // when, then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThatThrownBy(() -> {
                    board.move("a2", "a5");
                }).isInstanceOf(InvalidMovingPieceException.class);
                softAssertions.assertThat(board.findPiece("a2")).isEqualTo(Pawn.createWhite(createPosition("a2")));
                softAssertions.assertThat(board.findPiece("a5")).isEqualTo(Blank.create(createPosition("a5")));

                softAssertions.assertThatThrownBy(() -> {
                    board.move("a2", "b3");
                }).isInstanceOf(InvalidMovingPieceException.class);
                softAssertions.assertThat(board.findPiece("a2")).isEqualTo(Pawn.createWhite(createPosition("a2")));
                softAssertions.assertThat(board.findPiece("b3")).isEqualTo(Blank.create(createPosition("b3")));
            });
        }

        @Test
        @DisplayName("백폰 a2->a4 첫 이동시에 2칸 전진한다")
        public void move_pawn_twpStep_moving() {
            // given
            board.initialize();
            // when
            board.move("a2", "a4");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece("a4")).isEqualTo(Pawn.createWhite(createPosition("a4")));
                softAssertions.assertThat(board.findPiece("a2")).isEqualTo(Blank.create(createPosition("a2")));
            });
        }

        @Test
        @DisplayName("백폰 대각선 이동 요청시 앙파상 조건 불만족으로 거부됩니다.")
        public void move_WhitePawn_enPassant_rejection() {
            // given
            board.initialize();
            // when
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThatThrownBy(() -> {
                    board.move("b2", "c3");
                }).isInstanceOf(InvalidMovingPieceException.class);

                softAssertions.assertThatThrownBy(() -> {
                    board.move("b2", "a3");
                }).isInstanceOf(InvalidMovingPieceException.class);
            });
        }

        @Test
        @DisplayName("흑폰이 a7->a6 이동시 b7흑폰이 존재해야 한다.")
        public void move_BlackPawn_enPassant_rejection() {
            // given
            board.initialize();
            String sourcePosition = "a7";
            String targetPosition = "a6";
            String enPassantPosition = "b7";
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Pawn.createBlack(createPosition(targetPosition)));
                softAssertions.assertThat(board.findPiece(enPassantPosition))
                    .isEqualTo(Pawn.createBlack(createPosition(enPassantPosition)));
            });
        }

        @Test
        @DisplayName("b4백폰이 c4흑폰을 앙파상하여 c5로 이동한다")
        public void move_whitePawn_b4_c5() {
            // given
            board.initializeEmpty();
            board.setPiece("b4", Pawn.createWhite(createPosition("b4")));
            board.setPiece("c4", Pawn.createBlack(createPosition("c4")));
            // when
            board.move("b4", "c5");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece("b4")).isEqualTo(Blank.create(createPosition("b4")));
                softAssertions.assertThat(board.findPiece("c5")).isEqualTo(Pawn.createWhite(createPosition("c5")));
                softAssertions.assertThat(board.findPiece("c4")).isEqualTo(Blank.create(createPosition("c4")));
            });
        }

        @Test
        @DisplayName("흑킹 e8->e7 이동")
        public void move_blackKing_e8_e7() {
            // given
            board.initializeEmpty();
            String sourcePosition = "e8";
            String targetPosition = "e7";
            Position position = createPosition(sourcePosition);
            board.setPiece(position, King.createBlack(position));
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(King.createBlack(createPosition(targetPosition)));
            });
        }

        @Test
        @DisplayName("흑킹의 잘못된 이동하는 경우 예외가 발생합니다.")
        public void move_blackKing_invalidMoving() {
            // given
            board.initialize();
            // when
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThatThrownBy(() -> {
                    board.move("e8", "e9"); // 체스판 밖으로 이동하는 경우
                }).isInstanceOf(InvalidPositionException.class);

                softAssertions.assertThatThrownBy(() -> {
                    board.move("e8", "e7"); // 이동하려는 위치에 같은 편의 기물이 있는 경우
                }).isInstanceOf(InvalidMovingPieceException.class);

                softAssertions.assertThatThrownBy(() -> {
                    board.move("e8", "e6"); // King이 2칸 앞으로 이동하려는 경우
                }).isInstanceOf(InvalidMovingPieceException.class);
            });
        }

        @Test
        @DisplayName("흑퀸 d8->d6 이동")
        public void move_blackQueen_d8_d6() {
            // given
            board.initializeEmpty();
            String sourcePosition = "d8";
            String targetPosition = "d6";
            Position d8 = createPosition(sourcePosition);
            board.setPiece(d8, Queen.createBlack(d8));
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition)).isEqualTo(Blank.create(d8));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Queen.createBlack(createPosition(targetPosition)));
            });
        }

        @Test
        @DisplayName("흑룩이 a8->a1 이동")
        public void move_blackRook_a8_a1() {
            // given
            board.initializeEmpty();
            String sourcePosition = "a8";
            String targetPosition = "a1";
            Position a8 = createPosition(sourcePosition);
            board.setPiece(a8, Rook.createBlack(a8));
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Rook.createBlack(createPosition(targetPosition)));
            });
        }

        @Test
        @DisplayName("흑나이트가 b8->c6 이동")
        public void move_blackKnight_b8_c6() {
            // given
            board.initialize();
            String sourcePosition = "b8";
            String targetPosition = "c6";
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Knight.createBlack(createPosition(targetPosition)));
            });
        }

        @Test
        @DisplayName("흑비숍 c8->e6 이동")
        public void move_blackBishop_c8_e6() {
            // given
            board.initializeEmpty();
            String sourcePosition = "c8";
            String targetPosition = "e6";
            Position c8 = createPosition(sourcePosition);
            board.setPiece(c8, Bishop.createBlack(c8));
            // when
            board.move(sourcePosition, targetPosition);
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(sourcePosition))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(targetPosition))
                    .isEqualTo(Bishop.createBlack(createPosition(targetPosition)));
            });
        }

        @Test
        @DisplayName("흑백룩이 a8->a6 이동시 a7흑폰에 막혀 이동이 거부된다")
        public void move_blackRook_a8_a6_rejection() {
            // given
            board.initialize();
            // when
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThatThrownBy(() -> {
                    board.move("a8", "a6");
                }).isInstanceOf(InvalidMovingPieceException.class);
            });
        }
    }

    @Nested
    @DisplayName("킹 체크 테스트")
    class KingCheckTest {

        @Test
        @DisplayName("흑백룩이 a8->a5로 이동했을때 c5 백색킹이 체크된다")
        public void givenBlackRookWhenA8ToA5ThenKingIsCheck() {
            // given
            board.initializeEmpty();
            board.setPiece("a8", Rook.createBlack(createPosition("a8")));
            board.setPiece("c5", King.createWhite(createPosition("c5")));
            // when
            board.move("a8", "a5");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.isCheckByColor(WHITE)).isTrue();
            });
        }
    }
}
