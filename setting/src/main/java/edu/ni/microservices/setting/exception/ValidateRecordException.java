package edu.ni.microservices.setting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidateRecordException extends Exception {

	public ValidateRecordException(String message) {
		super(String.format("%s", message));
	}

}
