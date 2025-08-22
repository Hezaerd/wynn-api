package com.hezaerd.wapi.exceptions;

/**
 * Exception thrown when a requested resource is not found.
 * This typically happens when requesting data for non-existent players, guilds, or items.
 */
public class ResourceNotFoundException extends WynnApiException {

	private final String resourceType;
	private final String resourceId;

	/**
	 * Creates a new ResourceNotFoundException.
	 *
	 * @param resourceType The type of resource (e.g., "Player", "Guild", "Item")
	 * @param resourceId The identifier of the resource
	 */
	public ResourceNotFoundException(String resourceType, String resourceId) {
		super(String.format("%s '%s' not found", resourceType, resourceId), 404);
		this.resourceType = resourceType;
		this.resourceId = resourceId;
	}

	/**
	 * Creates a new ResourceNotFoundException with a custom message.
	 *
	 * @param message The error message
	 * @param resourceType The type of resource
	 * @param resourceId The identifier of the resource
	 */
	public ResourceNotFoundException(String message, String resourceType, String resourceId) {
		super(message, 404);
		this.resourceType = resourceType;
		this.resourceId = resourceId;
	}

	/**
	 * Gets the type of resource that was not found.
	 *
	 * @return The resource type
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * Gets the identifier of the resource that was not found.
	 *
	 * @return The resource identifier
	 */
	public String getResourceId() {
		return resourceId;
	}
}
