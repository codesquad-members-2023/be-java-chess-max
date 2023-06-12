package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Type.KING;
import static kr.codesqaud.chessgame.pieces.config.Type.PAWN;
import static kr.codesqaud.chessgame.pieces.config.Type.QUEEN;

import java.util.Objects;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Type;

public class Piece {

    private final Color color;
    private final Type type;
    private Position position;

    Piece(final Color color, final Type type, final Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
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

    // 기물이 가진 행마법으로 입력받은 위치로 이동할 수 있는지 판단
    public boolean isMovable(final Position position) {
        if (Objects.equals(type, KING)) {
            // 두 위치의 Rank간 거리가 1이하여야 합니다.
            if (diffDistance(position.getRank(), this.position.getRank()) > 1) {
                return false;
            }
            if (diffDistance(position.getFile(), this.position.getFile()) > 1) {
                return false;
            }
            return true;
        }

        if (Objects.equals(type, QUEEN)) {
            // 두 위치간의 관계가 직선, 대각선이 아닌 경우 false, 상하좌우, 대각선인 경우 true
            if (this.position.isStraight(position)) {
                return true;
            }
            return this.position.isDiagonal(position);
        }

        if (Objects.equals(type, PAWN)) {
            if (diffDistance(position.getRank(), this.position.getRank()) != 1) {
                return false;
            }
            if (diffDistance(position.getFile(), this.position.getFile()) != 0) {
                return false;
            }
            return true;
        }

        return false;
    }

    public int diffDistance(final int source, final int target) {
        return Math.abs(source - target);
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
