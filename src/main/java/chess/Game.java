package chess;

import static chess.ChessView.printCanMovePositions;

import chess.pieces.Color;
import chess.pieces.Piece;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {

    private final Board board;
    Logger logger = Logger.getLogger(Game.class.getName());
    private Color turn;

    public Game() {
        this.board = new Board();
        this.turn = Color.BLACK;
    }

    public void start() {
        init();
        while (!isGameOver()) {
            print();
            continueGame();
        }
    }

    private void continueGame() {
        Position selectPiecePosition = null;
        Optional<Position> targetPosition = Optional.empty();
        while (targetPosition.isEmpty()) {
            selectPiecePosition = getValidedSelectPiecePosition();
            Position[] canMovePositions = getCanMovePositions(selectPiecePosition, board);
            targetPosition = getTargetPosition(canMovePositions);
        }
        move(selectPiecePosition, targetPosition.get());
    }

    private boolean isGameOver() {
        return board.isGameOver();
    }

    private Position getValidedSelectPiecePosition() {
        Position selectPiecePosition = getSelectPiecePosition();
        while (!checkSelect(selectPiecePosition)) {
            selectPiecePosition = getSelectPiecePosition();
        }
        return selectPiecePosition;
    }

    private Position[] getCanMovePositions(Position targetPiecePosition, Board board) {
        Piece piece = board.findPiece(targetPiecePosition);
        Position[] canMovePositions = piece.getCanMovePositions(targetPiecePosition, board);
        printCanMovePositions(canMovePositions);
        return canMovePositions;
    }

    private Position getSelectPiecePosition() {
        System.out.println("선택할 기물의 위치를 입력하세요.");
        System.out.print(turn.name() + " : ");
        Optional<Position> position = InputView.getPosition();
        while (position.isEmpty()) {
            logger.log(Level.WARNING, "기물의 위치를 잘못 입력 했습니다.");
            System.out.println("선택할 기물의 위치를 입력하세요.");
            System.out.print(turn.name() + " : ");
            position = InputView.getPosition();
        }
        return position.get();
    }

    private boolean checkSelect(Position position) {
        Piece piece = board.findPiece(position);
        return piece.getColor().equals(turn);
    }

    Optional<Position> getTargetPosition(Position[] canMovePositions) {
        List<Position> positions = Arrays.stream(canMovePositions).toList();
        System.out.println("이동할 위치를 입력하세요.");
        Optional<Position> position = InputView.getPosition();
        if (position.isEmpty() || !positions.contains(position.get())) {
            logger.log(Level.WARNING, "이동할 위치를 잘못 입력 했습니다.");
            return Optional.empty();
        }
        return position;
    }

    private void move(Position selectPosition, Position targetPosition) {
        board.move(selectPosition, targetPosition);
        this.turn = turn.equals(Color.BLACK) ? Color.WHITE
                : Color.BLACK;
    }


    private void print() {
        board.print();
    }

    void init() {
        board.initialize();
    }


}
