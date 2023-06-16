package web.exception;

import chess.exception.ErrorCode;

public class ErrorResponse {

	private final String errorMessage;
	private final ErrorCode errorCode;

	private ErrorResponse(ErrorCode errorCode) {
		this.errorMessage = errorCode.getDescription();
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public static ErrorResponse from(ErrorCode errorCode) {
		return new ErrorResponse(errorCode);
	}
}
