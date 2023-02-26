package com.project.one.services;

import java.util.Date;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.exceptions.PastDateException;
import com.project.one.utils.ProjectUtils;

/**
 * This class is a container for Appointment related information.
 *
 * @author Ben
 */
public class Appointment {

	/**
	 * The minimum length that is acceptable for a field.
	 */
	public static int MIN_CHAR_LENGTH = 1;
	/**
	 * The maximum length that is acceptable for the appointmentId field.
	 */
	public static int APPOINTMENT_ID_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the description field.
	 */
	public static int DESCRIPTION_MAX_CHAR_LENGTH = 50;

	private String appointmentId;
	private Date appointmentDate;
	private String description;

	/**
	 * Constructor.
	 *
	 * @param appointmentId   Unique Identifier of the appointment.
	 * @param appointmentDate The date of the appointment.
	 * @param description     The description of the appointment.
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @see PastDateException
	 * @param address The address to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 * @throws PastDateException              Exception indicating a date field is
	 *                                        in the past.
	 */
	public Appointment(final String appointmentId, final Date appointmentDate, final String description)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException, PastDateException {
		if (ProjectUtils.validStringField("appointment ID", appointmentId, MIN_CHAR_LENGTH,
				APPOINTMENT_ID_MAX_CHAR_LENGTH)) {
			this.appointmentId = appointmentId;
		}

		setAppointmentDate(appointmentDate);
		setDescription(description);
	}

	/**
	 * Gets the appointmentDate.
	 *
	 * @return Returns the appointmentDate.
	 */
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	/**
	 * Sets the appointmentDate.
	 *
	 * @see NullFieldException
	 * @see PastDateException
	 * @param appointmentDate The appointmentDate to set.
	 * @throws NullFieldException Exception indicating a field is null.
	 * @throws PastDateException  Exception indicating a date field is in the past.
	 */
	public void setAppointmentDate(final Date appointmentDate) throws NullFieldException, PastDateException {
		if (ProjectUtils.validAfterDateField("appointment Date", appointmentDate)) {
			this.appointmentDate = appointmentDate;
		}
	}

	/**
	 * Gets the description.
	 *
	 * @return Returns the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param description The description to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setDescription(final String description)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("description", description, MIN_CHAR_LENGTH, DESCRIPTION_MAX_CHAR_LENGTH)) {
			this.description = description;
		}
	}

	/**
	 * Gets the appointmentId.
	 *
	 * @return Returns the appointmentId.
	 */
	public String getAppointmentId() {
		return this.appointmentId;
	}

}
