package com.hezaerd.wapi.exceptions;

/**
 * Base exception for all Wynncraft API related errors.
 * Provides a common exception hierarchy for the library.
 */
public class WynnApiException extends RuntimeException {

	private final int statusCode;
	private final String requestId;

	/**
	 * Creates a new WynnApiException.
	 *
	 * @param message The error message
	 */
	public WynnApiException(String message) {
		super(message);
		this.statusCode = -1;
		this.requestId = null;
	}

	/**
	 * Creates a new WynnApiException with a cause.
	 *
	 * @param message The error message
	 * @param cause The cause of the exception
	 */
	public WynnApiException(String message, Throwable cause) {
		super(message, cause);
		this.statusCode = -1;
		this.requestId = null;
	}

	/**
	 * Creates a new WynnApiException with status code.
	 *
	 * @param message The error message
	 * @param statusCode The HTTP status code
	 */
	public WynnApiException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
		this.requestId = null;
	}

	/**
	 * Creates a new WynnApiException with status code and request ID.
	 *
	 * @param message The error message
	 * @param statusCode The HTTP status code
	 * @param requestId The unique request identifier
	 */
	public WynnApiException(String message, int statusCode, String requestId) {
		super(message);
		this.statusCode = statusCode;
		this.requestId = requestId;
	}

	/**
	 * Gets the HTTP status code.
	 *
	 * @return The status code, or -1 if unknown
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the unique request identifier.
	 *
	 * @return The request ID, or null if none
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * Checks if this is a client error (4xx).
	 *
	 * @return true if this is a client error
	 */
	public boolean isClientError() {
		return statusCode >= 400 && statusCode < 500;
	}

	/**
	 * Checks if this is a server error (5xx).
	 *
	 * @return true if this is a server error
	 */
	public boolean isServerError() {
		return statusCode >= 500;
	}

	/**
	 * Checks if this is a rate limit error (429).
	 *
	 * @return true if this is a rate limit error
	 */
	public boolean isRateLimitError() {
		return statusCode == 429;
	}
}
