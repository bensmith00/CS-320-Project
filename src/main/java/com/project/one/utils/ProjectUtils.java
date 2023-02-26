package com.project.one.utils;

import java.util.Date;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.exceptions.PastDateException;

public class ProjectUtils {

	public static boolean validStringField(final String fieldName, final String fieldValue, final int minCharLength,
			final int maxCharLength)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (fieldValue == null) {
			throw new NullFieldException(String.format("The %s field cannot be NULL.", fieldName));
		} else if (fieldValue.length() > maxCharLength) {
			throw new MaximumLengthExceededException(
					String.format("The %s field must not exceed %s characters.", fieldName, maxCharLength));
		} else if (fieldValue.length() < minCharLength) {
			throw new MinimumLengthNotMetException(
					String.format("The %s field must be at least %s characters.", fieldName, minCharLength));
		} else {
			return true;
		}
	}

	public static boolean validAfterDateField(final String fieldName, final Date fieldValue)
			throws NullFieldException, PastDateException {
		if (fieldValue == null) {
			throw new NullFieldException(String.format("The %s field cannot be NULL.", fieldName));
		} else if (fieldValue.before(new Date())) {
			throw new PastDateException(String.format("The %s field cannot be in the past.", fieldName));
		} else {
			return true;
		}
	}

}
