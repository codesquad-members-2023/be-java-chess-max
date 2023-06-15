package web.exception;

import chess.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException ex) {
		return ResponseEntity.badRequest()
				.body(ErrorResponse.from(ex.getErrorCode()));
	}
}
