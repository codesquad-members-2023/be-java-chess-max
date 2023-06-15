package kr.codesqaud.chessgame.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kr.codesqaud.chessgame.chess.pieces.config.Color;
import kr.codesqaud.chessgame.chess.pieces.config.Direction;
import kr.codesqaud.chessgame.chess.pieces.config.Type;
import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;

public abstract class Piece {

    private final Color color;
    private final Type type;
    private final List<Direction> directions;
    private Position position;

    public Piece(final Color color, final Type type, final Position position) {
        this(color, type, position, new ArrayList<>());
    }

    public Piece(final Color color, final Type type, final Position position, final List<Direction> directions) {
        this.color = color;
        this.type = type;
        this.position = position;
        this.directions = directions;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public String getRepresentation() {
        if (isWhite()) {
            return type.getWhiteRepresentation();
        }
        return type.getBlackRepresentation();
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public void move(Piece target) {
        this.position = target.position;
    }

    public void verifyMovePosition(final Piece target) {
        if (isSameTeam(target)) {
            throw new InvalidMovingPieceException(target.position + "로 이동할 수 없습니다. 같은 색상의 기물입니다.");
        }
        Direction direction = position.direction(target.position);
        if (!directions.contains(direction)) {
            throw new InvalidMovingPieceException(target.position + "로 이동할 수 없습니다.");
        }
    }

    public boolean isSameTeam(Piece target) {
        return Objects.equals(color, target.getColor());
    }

    public Degree degree(Piece target) {
        return position.degree(target.getPosition());
    }

    public boolean matchType(Type type) {
        return this.type == type;
    }

    public boolean matchColor(Color color) {
        return this.color == color;
    }

    public Direction direction(final Piece targetPiece) {
        return position.direction(targetPiece.position);
    }

    public boolean isMoving(final Piece target) {
        try {
            verifyMovePosition(target);
            return true;
        } catch (InvalidMovingPieceException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType(), getPosition());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) o;
        return getColor() == piece.getColor() && getType() == piece.getType() && Objects.equals(getPosition(),
            piece.getPosition());
    }

    @Override
    public String toString() {
        return "Piece{" +
            "color=" + color +
            ", type=" + type +
            ", position=" + position +
            '}';
    }


}
