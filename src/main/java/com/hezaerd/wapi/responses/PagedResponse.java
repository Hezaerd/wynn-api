package com.hezaerd.wapi.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Wrapper for paginated API responses.
 *
 * @param <T> The type of data contained in the response
 */
public class PagedResponse<T> {

	private final ApiResponse<List<T>> response;

	@SerializedName("page")
	private final int page;

	@SerializedName("totalPages")
	private final int totalPages;

	@SerializedName("totalResults")
	private final int totalResults;

	@SerializedName("resultsPerPage")
	private final int resultsPerPage;

	/**
	 * Creates a successful paged response.
	 */
	public static <T> PagedResponse<T> success(List<T> data, int page, int totalPages,
											   int totalResults, int resultsPerPage) {
		return new PagedResponse<>(ApiResponse.success(data), page, totalPages, totalResults, resultsPerPage);
	}

	/**
	 * Creates a failed paged response.
	 */
	public static <T> PagedResponse<T> failure(String error) {
		return new PagedResponse<>(ApiResponse.<List<T>>failure(error), 0, 0, 0, 0);
	}

	/**
	 * Private constructor to enforce use of static factory methods.
	 * @param response The wrapped ApiResponse
	 * @param page current page number
	 * @param totalPages total number of pages
	 * @param totalResults total number of results
	 * @param resultsPerPage number of results per page
	 */
	private PagedResponse(ApiResponse<List<T>> response, int page, int totalPages,
						  int totalResults, int resultsPerPage) {
		this.response = response;
		this.page = page;
		this.totalPages = totalPages;
		this.totalResults = totalResults;
		this.resultsPerPage = resultsPerPage;
	}

	// Delegate methods to the wrapped response
	public boolean isSuccess() { return response.isSuccess(); }
	public List<T> getData() { return response.getData(); }
	public List<T> getDataOrNull() { return response.getDataOrNull(); }
	public String getError() { return response.getError(); }
	public long getTimestamp() { return response.getTimestamp(); }

	// Pagination methods
	public int getPage() { return page; }
	public int getTotalPages() { return totalPages; }
	public int getTotalResults() { return totalResults; }
	public int getResultsPerPage() { return resultsPerPage; }
	public boolean hasNextPage() { return page < totalPages; }
	public boolean hasPreviousPage() { return page > 1; }
	public int getNextPage() { return hasNextPage() ? page + 1 : -1; }
	public int getPreviousPage() { return hasPreviousPage() ? page - 1 : -1; }

	@Override
	public String toString() {
		return "PagedResponse{" +
				"response=" + response +
				", page=" + page +
				", totalPages=" + totalPages +
				", totalResults=" + totalResults +
				", resultsPerPage=" + resultsPerPage +
				'}';
	}
}
