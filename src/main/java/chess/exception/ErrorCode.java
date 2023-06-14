package chess.exception;

public enum ErrorCode {

	NO_MATCH_COLOR("유효하지 않은 색깔"),
	INVALID_POSITION("유효하지 않은 위치정보"),
	INVALID_TURN("현재 사용자의 턴이 아님");

	private final String description;

	ErrorCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
