package com.hezaerd.wapi.exceptions;

/**
 * Exception thrown when the API rate limit is exceeded.
 * Wynncraft API allows 120 requests per minute.
 */
public class RateLimitException extends WynnApiException {

	private final long resetTime;
	private final int remainingRequests;

	/**
	 * Creates a new RateLimitException.
	 *
	 * @param message The error message
	 * @param resetTime The time when the rate limit resets (in seconds)
	 * @param remainingRequests The number of remaining requests
	 */
	public RateLimitException(String message, long resetTime, int remainingRequests) {
		super(message, 429);
		this.resetTime = resetTime;
		this.remainingRequests = remainingRequests;
	}

	/**
	 * Gets the time when the rate limit resets.
	 *
	 * @return The reset time in seconds from now
	 */
	public long getResetTime() {
		return resetTime;
	}

	/**
	 * Gets the number of remaining requests.
	 *
	 * @return The remaining requests
	 */
	public int getRemainingRequests() {
		return remainingRequests;
	}

	/**
	 * Gets the time until rate limit resets in milliseconds.
	 *
	 * @return The time until reset in milliseconds
	 */
	public long getTimeUntilReset() {
		return resetTime * 1000;
	}

	@Override
	public String getMessage() {
		return String.format("Rate limit exceeded. Reset in %d seconds. Remaining requests: %d",
				resetTime, remainingRequests);
	}
}
