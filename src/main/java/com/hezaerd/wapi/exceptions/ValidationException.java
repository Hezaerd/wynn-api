package com.hezaerd.wapi.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception thrown when input validation fails.
 * This includes invalid parameters, malformed requests, and constraint violations.
 */
public class ValidationException extends WynnApiException {

	private final List<String> validationErrors;

	/**
	 * Creates a new ValidationException.
	 *
	 * @param message The error message
	 */
	public ValidationException(String message) {
		super(message, 400);
		this.validationErrors = new ArrayList<>();
	}

	/**
	 * Creates a new ValidationException with validation errors.
	 *
	 * @param message The error message
	 * @param validationErrors The list of validation errors
	 */
	public ValidationException(String message, List<String> validationErrors) {
		super(message, 400);
		this.validationErrors = new ArrayList<>(validationErrors);
	}

	/**
	 * Adds a validation error.
	 *
	 * @param error The validation error message
	 * @return This exception for chaining
	 */
	public ValidationException addError(String error) {
		validationErrors.add(error);
		return this;
	}

	/**
	 * Gets all validation errors.
	 *
	 * @return The list of validation errors
	 */
	public List<String> getValidationErrors() {
		return new ArrayList<>(validationErrors);
	}

	/**
	 * Checks if there are any validation errors.
	 *
	 * @return true if there are validation errors
	 */
	public boolean hasErrors() {
		return !validationErrors.isEmpty();
	}

	/**
	 * Gets the number of validation errors.
	 *
	 * @return The number of validation errors
	 */
	public int getErrorCount() {
		return validationErrors.size();
	}

	@Override
	public String getMessage() {
		if (validationErrors.isEmpty()) {
			return super.getMessage();
		}
		return String.format("%s. Validation errors: %s",
				super.getMessage(), String.join(", ", validationErrors));
	}
}
