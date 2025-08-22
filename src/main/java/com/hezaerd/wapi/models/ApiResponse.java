package com.hezaerd.wapi.models;

import java.util.function.Consumer;
import java.util.function.Function;

import com.google.gson.annotations.SerializedName;

/**
 * Generic wrapper for all Wynncraft API responses.
 * This class provide a consistent structure for handling API responses
 * with proper error handling and data extraction.
 *
 * @param <T> The type of the data.
 */
public class ApiResponse<T> {
	@SerializedName("success")
	private final boolean success;

	@SerializedName("data")
	private final T data;

	@SerializedName("error")
	private final String error;

	@SerializedName("timestamp")
	private final long timestamp;

	/**
	 * Create a successful ApiResponse.
	 *
	 * @param data The response data.
	 * @param <T> The type of the data.
	 * @return A successful ApiResponse.
	 */
	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(true, data, null, System.currentTimeMillis());
	}

	/**
	 * Create a failed ApiResponse.
	 *
	 * @param errorMessage The error message.
	 * @param <T> The type of the data.
	 * @return An error ApiResponse.
	 */
	public static <T> ApiResponse<T> failure(String errorMessage) {
		return new ApiResponse<>(false, null, errorMessage, System.currentTimeMillis());
	}

	/**
	 * Create a failed ApiResponse with a specific timestamp.
	 *
	 * @param errorMessage The error message.
	 * @param timestamp The timestamp of the error.
	 * @param <T> The type of the data.
	 * @return An error ApiResponse.
	 */
	public static <T> ApiResponse<T> failure(String errorMessage, long timestamp) {
		return new ApiResponse<>(false, null, errorMessage, timestamp);
	}

	/**
	 * Private constructor to enforce the use of the builder pattern.
	 */
	protected ApiResponse(boolean success, T data, String error, long timestamp) {
		this.success = success;
		this.data = data;
		this.error = error;
		this.timestamp = timestamp;
	}


	/**
	 * Checks if the response was successful.
	 *
	 * @return true if successful, false otherwise
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Gets the response data.
	 * Throws an exception if the response was not successful.
	 *
	 * @return The response data
	 * @throws IllegalStateException if the response was not successful
	 */
	public T getData() {
		if (!success) {
			throw new IllegalStateException("Cannot get data from failed response: " + error);
		}
		return data;
	}

	/**
	 * Gets the response data safely, returning null if the response failed.
	 *
	 * @return The response data, or null if failed
	 */
	public T getDataOrNull() {
		return data;
	}

	/**
	 * Gets the error message.
	 *
	 * @return The error message, or null if successful
	 */
	public String getError() {
		return error;
	}

	/**
	 * Gets the timestamp when the response was created.
	 *
	 * @return The timestamp in milliseconds since epoch
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * Maps the response data to a new type using the provided mapper function.
	 * If the response is not successful, returns a failed response with the same error.
	 *
	 * @param mapper The function to map the data
	 * @param <R> The new data type
	 * @return A new ApiResponse with the mapped data
	 */
	public <R> ApiResponse<R> map(Function<T, R> mapper) {
		if (!success) {
			return ApiResponse.failure(error, timestamp);
		}
		try {
			R mappedData = mapper.apply(data);
			return ApiResponse.success(mappedData);
		} catch (Exception e) {
			return ApiResponse.failure("Mapping failed: " + e.getMessage(), timestamp);
		}
	}

	/**
	 * Executes the provided consumer if the response is successful.
	 *
	 * @param consumer The consumer to execute with the data
	 * @return This ApiResponse for chaining
	 */
	public ApiResponse<T> ifSuccess(Consumer<T> consumer) {
		if (success && data != null) {
			consumer.accept(data);
		}
		return this;
	}

	/**
	 * Executes the provided consumer if the response failed.
	 *
	 * @param consumer The consumer to execute with the error
	 * @return This ApiResponse for chaining
	 */
	public ApiResponse<T> ifError(Consumer<String> consumer) {
		if (!success && error != null) {
			consumer.accept(error);
		}
		return this;
	}

	@Override
	public String toString() {
		return "ApiResponse{" +
				"success=" + success +
				", data=" + data +
				", error='" + error + '\'' +
				", timestamp=" + timestamp +
				'}';
	}
}
