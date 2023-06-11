package chess.exception;

public enum ErrorCode {

	NO_MATCH_COLOR("유효하지 않은 색깔"),
	INVALID_POSITION("유효하지 않은 위치정보");

	private final String description;

	ErrorCode(String description) {
		this.description = description;
	}
}
