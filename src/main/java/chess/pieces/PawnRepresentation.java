package chess.pieces;

public enum PawnRepresentation {
    WHITE("p"), BLACK("value");

    private final String value;

    PawnRepresentation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
