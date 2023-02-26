package com.project.one.exceptions;

/**
 * This class is a custom exception indicating a Data is in the past.
 *
 * @see Exception
 * @author Ben
 */
public class PastDateException extends Exception {

	private static final long serialVersionUID = -4255480404050611945L;

	/**
	 * Constructor.
	 *
	 * @param errorMessage The error message describing the error.
	 */
	public PastDateException(final String errorMessage) {
		super(errorMessage);
	}
}
