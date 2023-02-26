package com.project.one.services;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.exceptions.PastDateException;

/**
 * This class is a singleton service handling CRUD operations to the Appointment
 * database. NOTE: The current implementation uses an in-memory solution. This
 * should be replaced with a permanent persistence option.
 *
 * @see Appointment
 * @author Ben
 */
public class AppointmentService {
	// TODO This should be replaced with a permanent persistence option.
	private final Map<String, Appointment> appointmentMap;
	private static AppointmentService instance = new AppointmentService();

	/**
	 * Private Constructor.
	 */
	private AppointmentService() {
		this.appointmentMap = new ConcurrentHashMap<>();
	}

	/**
	 * Gets the only instance of AppointmentService.
	 *
	 * @return Returns the only instance of AppointmentService.
	 */
	public static AppointmentService getInstance() {
		return instance;
	}

	/**
	 * Adds an Appointment object.
	 *
	 * @param appointment The Appointment object that will be added.
	 * @return Returns true if the add was successful.
	 */
	public boolean addAppointment(final Appointment appointment) {
		if (!appointmentExists(appointment.getAppointmentId())) {
			this.appointmentMap.put(appointment.getAppointmentId(), appointment);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes an Appointment object based on a appointmentId.
	 *
	 * @param appointmentId The appointmentId that indicates the Appointment object
	 *                      that should be deleted.
	 * @return Returns true if the delete was successful.
	 */
	public boolean deleteAppointment(final String appointmentId) {
		if (appointmentExists(appointmentId)) {
			this.appointmentMap.remove(appointmentId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Updates the appointment date of an Appointment object based on a
	 * appointmentId.
	 *
	 * @param appointmentId The appointmentId that indicates the Appointment object
	 *                      that should be updated.
	 * @param updateDate    The updated appointment date of the Appointment object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateAppointmentDate(final String appointmentId, final Date updateDate) {
		if (!appointmentExists(appointmentId)) {
			return false;
		} else {
			final Appointment appointment = this.appointmentMap.get(appointmentId);
			try {
				appointment.setAppointmentDate(updateDate);
				return true;
			} catch (NullFieldException | PastDateException e) {
				return false;
			}
		}

	}

	/**
	 * Updates the description of a Appointment object based on a appointmentId.
	 *
	 * @param appointmentId     The appointmentId that indicates the Appointment
	 *                          object that should be updated.
	 * @param updateDescription The updated description of the Appointment object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateAppointmentDescription(final String appointmentId, final String updateDescription) {
		if (!appointmentExists(appointmentId)) {
			return false;
		} else {
			final Appointment appointment = this.appointmentMap.get(appointmentId);
			try {
				appointment.setDescription(updateDescription);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}
	}

	/**
	 * Searches for an existing Appointment object based on a appointmentId.
	 *
	 * @param appointmentId The appointmentId being searched for.
	 * @return Returns true if the contact exists.
	 */
	private boolean appointmentExists(final String appointmentId) {
		if (this.appointmentMap.containsKey(appointmentId)) {
			return true;
		} else {
			return false;
		}
	}

}
