package com.project.one.exceptions;

/**
 * This class is a custom exception indicating a field is attempting to be set
 * to null.
 *
 * @see Exception
 * @author Ben
 */
public class NullFieldException extends Exception {

	private static final long serialVersionUID = 2551281852717229808L;

	/**
	 * Constructor.
	 *
	 * @param errorMessage The error message describing the error.
	 */
	public NullFieldException(final String errorMessage) {
		super(errorMessage);
	}

}
