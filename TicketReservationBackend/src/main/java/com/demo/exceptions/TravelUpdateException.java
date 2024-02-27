package com.demo.exceptions;

public class TravelUpdateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TravelUpdateException(Long travelId) {
        super("Unable to update travel with ID: " + travelId + ". Travel not found.");
    }
}