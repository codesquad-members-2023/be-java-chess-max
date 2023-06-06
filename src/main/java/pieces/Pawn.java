package pieces;

import lombok.Getter;

import static pieces.PieceColor.*;

@Getter
public class Pawn {
    private final String color;
    private final char representation;

    /**
     * 기본 생생자는 white 기반
     */
    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(final String color, final char representation) {
        validatePawn(color, representation);
        this.color = color;
        this.representation = representation;
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePawn(final String color, final char representation) {
        if (!color.equals(BLACK_COLOR) && !color.equals(WHITE_COLOR)
                && representation != BLACK_REPRESENTATION && representation != WHITE_REPRESENTATION) {
            throw new IllegalArgumentException("[ERROR] color: " + color + ", " + "representation: " + representation);
        }
    }
}
