package com.hezaerd.wapi.exceptions;

/**
 * Exception thrown when network-related errors occur.
 * This includes connection timeouts, network failures, and HTTP errors.
 */
public class NetworkException extends WynnApiException {

	private final String url;
	private final String method;

	/**
	 * Creates a new NetworkException.
	 *
	 * @param message The error message
	 * @param url The URL that was being accessed
	 * @param method The HTTP method that was used
	 */
	public NetworkException(String message, String url, String method) {
		super(message);
		this.url = url;
		this.method = method;
	}

	/**
	 * Creates a new NetworkException with a cause.
	 *
	 * @param message The error message
	 * @param cause The cause of the exception
	 * @param url The URL that was being accessed
	 * @param method The HTTP method that was used
	 */
	public NetworkException(String message, Throwable cause, String url, String method) {
		super(message, cause);
		this.url = url;
		this.method = method;
	}

	/**
	 * Creates a new NetworkException with status code.
	 *
	 * @param message The error message
	 * @param statusCode The HTTP status code
	 * @param url The URL that was being accessed
	 * @param method The HTTP method that was used
	 */
	public NetworkException(String message, int statusCode, String url, String method) {
		super(message, statusCode);
		this.url = url;
		this.method = method;
	}

	/**
	 * Gets the URL that was being accessed.
	 *
	 * @return The URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the HTTP method that was used.
	 *
	 * @return The HTTP method
	 */
	public String getMethod() {
		return method;
	}

	@Override
	public String getMessage() {
		return String.format("Network error for %s %s: %s", method, url, super.getMessage());
	}
}
