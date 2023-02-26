package com.project.one.exceptions;

/**
 * This class is a custom exception indicating the maximum length has been
 * exceeded.
 *
 * @see Exception
 * @author Ben
 */
public class MaximumLengthExceededException extends Exception {

	private static final long serialVersionUID = -4096523318676040666L;

	/**
	 * Constructor.
	 *
	 * @param errorMessage The error message describing the error.
	 */
	public MaximumLengthExceededException(final String errorMessage) {
		super(errorMessage);
	}
}
