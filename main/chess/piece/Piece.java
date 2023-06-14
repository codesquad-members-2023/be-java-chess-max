package chess.piece;

import java.util.List;

public interface Piece {

    boolean isColor(Color color);
    boolean isType(Type type);
    String getRepresentation();
    Position getPosition();
    double getPoint();
    void setPosition(Position position);
    List<Position> getValidMovePositions();

}
