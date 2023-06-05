package pieces;

import lombok.Getter;

import static pieces.PieceColor.BLACK_COLOR;
import static pieces.PieceColor.WHITE_COLOR;

@Getter
public class Pawn {
    private final String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(final String color) {
        validatePawn(color);
        this.color = color;
    }

    /**
     * black 또는 white 색상이 아닌 경우 예외를 던짐
     * TODO: 던진 예외를 처리해야 함
     */
    private void validatePawn(final String color) {
        if (!color.equals(BLACK_COLOR) && !color.equals(WHITE_COLOR)) {
            throw new IllegalArgumentException("[ERROR] black 또는 white 폰을 입력해야 합니다. color: " + color);
        }
    }
}
