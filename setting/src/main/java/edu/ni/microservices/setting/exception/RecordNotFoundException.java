package edu.ni.microservices.setting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8674012963975185046L;

	public RecordNotFoundException(String message, long id) {
		super(String.format("%s: %d", message, id));
	}
}
