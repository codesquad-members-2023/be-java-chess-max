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
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
        int blackPawnCount = board.countPieceBy(BLACK, Type.PAWN);
        int blackRookCount = board.countPieceBy(BLACK, Type.ROOK);
        int blackKnightCount = board.countPieceBy(BLACK, Type.KNIGHT);
        int blackBishopCount = board.countPieceBy(BLACK, Type.BISHOP);
        int blackQueenCount = board.countPieceBy(BLACK, Type.QUEEN);
        int blackKingCount = board.countPieceBy(BLACK, Type.KING);
        int whitePawnCount = board.countPieceBy(WHITE, Type.PAWN);
        int whiteRookCount = board.countPieceBy(WHITE, Type.ROOK);
        int whiteKnightCount = board.countPieceBy(WHITE, Type.KNIGHT);
        int whiteBishopCount = board.countPieceBy(WHITE, Type.BISHOP);
        int whiteQueenCount = board.countPieceBy(WHITE, Type.QUEEN);
        int whiteKingCount = board.countPieceBy(WHITE, Type.KING);
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
        Piece blackRook = board.findPiece(createPosition("a8"));
        Piece blackRook2 = board.findPiece(createPosition("h8"));
        Piece whiteRook = board.findPiece(createPosition("a1"));
        Piece whiteRook2 = board.findPiece(createPosition("h1"));
        Piece emptyPiece = board.findPiece(createPosition("a6"));
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
        board.setPiece(createPosition(sourcePosition), piece);
        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                .isEqualTo(Rook.createBlack(createPosition(sourcePosition)));
        });
    }

    @Test
    @DisplayName("체스판 위에 기물이 주어지고 흑색과 백색을 구분해서 점수가 높은 순서로 정렬을 요청시 높은 순서로 정렬되어 응답한다")
    public void sortByColor() {
        // given
        board.initializeEmpty();
        // 흑색 기물 초기화
        board.setPiece(createPosition("b6"), Pawn.createBlack(createPosition("b6")));
        board.setPiece(createPosition("e6"), Queen.createBlack(createPosition("e6")));
        board.setPiece(createPosition("b8"), King.createBlack(createPosition("b8")));
        board.setPiece(createPosition("c8"), Rook.createBlack(createPosition("c8")));
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
        board.setPiece(createPosition("b6"), Pawn.createBlack(createPosition("b6")));
        board.setPiece(createPosition("e6"), Queen.createBlack(createPosition("e6")));
        board.setPiece(createPosition("b8"), King.createBlack(createPosition("b8")));
        board.setPiece(createPosition("c8"), Rook.createBlack(createPosition("c8")));
        // 백색 초기화
        board.setPiece(createPosition("f2"), Pawn.createWhite(createPosition("f2")));
        board.setPiece(createPosition("g2"), Pawn.createWhite(createPosition("g2")));
        board.setPiece(createPosition("e1"), Rook.createWhite(createPosition("e1")));
        board.setPiece(createPosition("f1"), King.createWhite(createPosition("f1")));
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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
                softAssertions.assertThat(board.findPiece(createPosition("a2")))
                    .isEqualTo(Pawn.createWhite(createPosition("a2")));
                softAssertions.assertThat(board.findPiece(createPosition("a5")))
                    .isEqualTo(Blank.create(createPosition("a5")));

                softAssertions.assertThatThrownBy(() -> {
                    board.move("a2", "b3");
                }).isInstanceOf(InvalidMovingPieceException.class);
                softAssertions.assertThat(board.findPiece(createPosition("a2")))
                    .isEqualTo(Pawn.createWhite(createPosition("a2")));
                softAssertions.assertThat(board.findPiece(createPosition("b3")))
                    .isEqualTo(Blank.create(createPosition("b3")));
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
                softAssertions.assertThat(board.findPiece(createPosition("a4")))
                    .isEqualTo(Pawn.createWhite(createPosition("a4")));
                softAssertions.assertThat(board.findPiece(createPosition("a2")))
                    .isEqualTo(Blank.create(createPosition("a2")));
            });
        }

        @Test
        @DisplayName("a2백폰과 b3흑폰이 주어지고 a2백폰이 b3로 대각이동합니다.")
        public void move_WhitePawn_a2_b3_success() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("a2"), Pawn.createWhite(createPosition("a2")));
            board.setPiece(createPosition("b2"), Pawn.createWhite(createPosition("b2")));
            board.setPiece(createPosition("b3"), Pawn.createBlack(createPosition("b3")));
            // when
            board.move("a2", "b3");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(createPosition("a2")))
                    .isEqualTo(Blank.create(createPosition("a2")));
                softAssertions.assertThat(board.findPiece(createPosition("b3")))
                    .isEqualTo(Pawn.createWhite(createPosition("b3")));
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
                    .isEqualTo(Pawn.createBlack(createPosition(targetPosition)));
                softAssertions.assertThat(board.findPiece(createPosition(enPassantPosition)))
                    .isEqualTo(Pawn.createBlack(createPosition(enPassantPosition)));
            });
        }

        @Test
        @DisplayName("b4백폰이 c4흑폰을 앙파상하여 c5로 이동한다")
        public void move_whitePawn_b4_c5() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("b4"), Pawn.createWhite(createPosition("b4")));
            board.setPiece(createPosition("c4"), Pawn.createBlack(createPosition("c4")));
            // when
            board.move("b4", "c5");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(createPosition("b4")))
                    .isEqualTo(Blank.create(createPosition("b4")));
                softAssertions.assertThat(board.findPiece(createPosition("c5")))
                    .isEqualTo(Pawn.createWhite(createPosition("c5")));
                softAssertions.assertThat(board.findPiece(createPosition("c4")))
                    .isEqualTo(Blank.create(createPosition("c4")));
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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
                softAssertions.assertThat(board.move("e8", "e9")).isFalse(); // 체스판 밖으로 이동하는 경우
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition))).isEqualTo(Blank.create(d8));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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
                softAssertions.assertThat(board.findPiece(createPosition(sourcePosition)))
                    .isEqualTo(Blank.create(createPosition(sourcePosition)));
                softAssertions.assertThat(board.findPiece(createPosition(targetPosition)))
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

        @Test
        @DisplayName("흑백룩이 a8->a6 이동시 a6에 있는 폰을 잡으며 이동한다")
        public void move_blackRook_a8_a6_success() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("a8"), Rook.createBlack(createPosition("a8")));
            board.setPiece(createPosition("a6"), Pawn.createWhite(createPosition("a6")));
            // when
            board.move("a8", "a6");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.findPiece(createPosition("a8")))
                    .isEqualTo(Blank.create(createPosition("a8")));
                softAssertions.assertThat(board.findPiece(createPosition("a6")))
                    .isEqualTo(Rook.createBlack(createPosition("a6")));
            });
        }
    }

    @Nested
    @DisplayName("이동 가능한 경로 테스트")
    class PossiblePathTest {

        @Test
        @DisplayName("백색폰이 주어지고 이동 가능한 경로 요청시 경로를 응답한다")
        public void possiblePath_pawn() {
            // given
            board.initialize();
            // when
            List<Position> positions = board.possiblePath(createPosition("a2"));
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(positions)
                    .containsExactly(createPosition("a3"), createPosition("a4"));
                softAssertions.assertThat(positions.size()).isEqualTo(2);
            });
        }

        @Test
        @DisplayName("백킹이 주어지고 이동 가능한 경로 요청시 경로를 응답한다.")
        public void possiblePath_king() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("e1"), King.createWhite(createPosition("e1")));
            // when
            List<Position> positions = board.possiblePath(createPosition("e1"));
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(positions).containsAll(
                    List.of(createPosition("d1"),
                        createPosition("d2"),
                        createPosition("e2"),
                        createPosition("f2"),
                        createPosition("f1")));
                softAssertions.assertThat(positions.size()).isEqualTo(5);
            });
        }

    }

    @Nested
    @DisplayName("체크 테스트")
    class KingCheckTest {

        @Test
        @DisplayName("흑백룩이 a8->a5로 이동했을때 c5 백색킹이 체크된다")
        public void givenBlackRookWhenA8ToA5ThenKingIsCheck() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("a8"), Rook.createBlack(createPosition("a8")));
            board.setPiece(createPosition("c5"), King.createWhite(createPosition("c5")));
            // when
            board.move("a8", "a5");
            // then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(board.isCheckByColor(WHITE)).isTrue();
            });
        }

        @Test
        @DisplayName("c5 백색킹이 체크된 상태에서 백색킹을 제외한 다른 백색 기물을 이동하려고 할때 예외가 발생한다")
        @Disabled
        public void testCheckState_MoveWhitePiece_ExceptionThrown() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("a8"), Rook.createBlack(createPosition("a8")));
            board.setPiece(createPosition("c5"), King.createWhite(createPosition("c5")));
            board.setPiece(createPosition("c2"), Pawn.createWhite(createPosition("c2")));
            board.move("a8", "a5");
            // when, then
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThatThrownBy(() -> {
                    board.move("c2", "c3");
                }).isInstanceOf(InvalidMovingPieceException.class);
            });
        }
    }

    @Nested
    @DisplayName("체크메이트 테스트")
    class CheckMateTest {

        @Test
        @DisplayName("백룩이 2개 흑킹 1개 있을때 룩이 이동하여 흑킹이 체크메이트 된다.")
        @Disabled
        public void testDoubleRook_checkMate() {
            // given
            board.initializeEmpty();
            board.setPiece(createPosition("a1"), Rook.createWhite(createPosition("a1")));
            board.setPiece(createPosition("h6"), Rook.createWhite(createPosition("h6")));
            board.setPiece(createPosition("e1"), King.createWhite(createPosition("e1")));
            board.setPiece(createPosition("d7"), King.createBlack(createPosition("d7")));
            // when
            board.move("a1", "a7"); // 룩이동
            board.move("d7", "e8"); // 킹이동
            board.move("h6", "h8"); // 룩이동
            // then
            List<Position> positions = board.possiblePath(createPosition("e8")); // e8에서 이동 가능한 경로 조회
            SoftAssertions.assertSoftly(softAssertions -> {
                softAssertions.assertThat(positions.size()).isEqualTo(0);
                softAssertions.assertThatThrownBy(() -> {
                    board.move("e8", "f8");
                }).isInstanceOf(InvalidMovingPieceException.class);
            });
        }
    }
}
