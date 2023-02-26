package com.project.one.exceptions;

/**
 * This class is a custom exception indicating the minimum length has not been
 * met.
 *
 * @see Exception
 * @author Ben
 */
public class MinimumLengthNotMetException extends Exception {

	private static final long serialVersionUID = -4096523318676040666L;

	/**
	 * Constructor.
	 *
	 * @param errorMessage The error message describing the error.
	 */
	public MinimumLengthNotMetException(final String errorMessage) {
		super(errorMessage);
	}
}
