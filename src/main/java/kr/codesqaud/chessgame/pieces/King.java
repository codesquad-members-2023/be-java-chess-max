package kr.codesqaud.chessgame.pieces;

import static kr.codesqaud.chessgame.pieces.config.Color.BLACK;
import static kr.codesqaud.chessgame.pieces.config.Color.WHITE;
import static kr.codesqaud.chessgame.pieces.config.Direction.everyDirection;
import static kr.codesqaud.chessgame.pieces.config.Type.KING;

import kr.codesqaud.chessgame.exception.InvalidMovingPieceException;
import kr.codesqaud.chessgame.pieces.config.Color;
import kr.codesqaud.chessgame.pieces.config.Direction;

public class King extends Piece {

    public King(final Color color, final Position position) {
        super(color, KING, position, everyDirection());
    }

    public static King createWhite(final Position position) {
        return new King(WHITE, position);
    }

    public static King createBlack(final Position position) {
        return new King(BLACK, position);
    }

    @Override
    public void verifyMovePosition(final Piece target) {
        if (isSameTeam(target)) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다. 같은 색상의 기물입니다.");
        }
        Direction direction = getPosition().direction(target.getPosition());
        int y = target.getPosition().getRank() - getPosition().getRank();
        int x = target.getPosition().getFile() - getPosition().getFile();
        if (!getDirections().contains(direction) || !direction.match(y, x)) {
            throw new InvalidMovingPieceException(target.getPosition() + "로 이동할 수 없습니다.");
        }
    }
}
