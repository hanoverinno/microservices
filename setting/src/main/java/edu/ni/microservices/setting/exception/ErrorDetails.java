package edu.ni.microservices.setting.exception;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class ErrorDetails {

	private LocalDateTime time;
	private String message;
	private HttpStatus status;
	@JsonIgnore
	private String developerMessage;
	private String path;

	public ErrorDetails(String message, HttpStatus status, String developerMessage, String path) {
		this.message = message;
		this.time = LocalDateTime.now();
		this.status = status;
		this.developerMessage = developerMessage;
		this.path = path;

	}
}