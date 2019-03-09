package edu.ni.microservices.setting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UniqueConstraintException extends Exception {

	public UniqueConstraintException(String message, String conflictingValue) {
		super(String.format("%s: %s", message, conflictingValue));
	}
}
