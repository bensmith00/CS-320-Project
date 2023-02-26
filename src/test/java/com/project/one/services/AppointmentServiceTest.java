package com.project.one.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.exceptions.PastDateException;

/**
 * This class tests the functionality of the AppointmentService class.
 *
 * @see AppointmentService
 * @see Appointment
 * @author Ben
 */
public class AppointmentServiceTest {

	private static String INVALID_MIN = "";
	private static String VALID_INPUT = "TEST";
	private static String INVALID_MAX_51 = "012345678901234567890123456789012345678901234567890";
	private static String VALID_APPOINTMENT_ID = "AppointID";
	private static String VALID_DESCRIPTION = "Description";
	private AppointmentService appointmentService;
	private Appointment appointment;
	private Date pastDate;
	private Date futureDate;

	/**
	 * Retrieves the AppointmentService singleton before every test. Creates a valid
	 * Appointment object before every test.
	 *
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
	@BeforeEach
	void init() throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException, PastDateException {
		this.appointmentService = AppointmentService.getInstance();

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -1);
		this.pastDate = calendar.getTime();

		calendar.add(Calendar.YEAR, 2);
		this.futureDate = calendar.getTime();

		this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, VALID_DESCRIPTION);
	}

	/**
	 * Removes the Appointment object from the AppointmentService instance after every test.
	 */
	@AfterEach
	void tearDown() {
		this.appointmentService.deleteAppointment(VALID_APPOINTMENT_ID);
	}

	// Testing addAppointment(final Appointment appointment)
	/**
	 * Asserts an addAppointment call to the AppointmentService returns true when the
	 * Appointment is unique.
	 */
	@Test
	void addUniqueAppointmentTest() {
		assertTrue(this.appointmentService.addAppointment(this.appointment));
	}

	/**
	 * Asserts an addAppointment call to the AppointmentService returns false when the
	 * Appointment is not unique.
	 */
	@Test
	void addDuplicateAppointmentTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.addAppointment(this.appointment));
	}

	// Testing deleteAppointment(final String appointmentId)
	/**
	 * Asserts a deleteAppointment call to the AppointmentService returns false when the
	 * Appointment is unique.
	 */
	@Test
	void deleteUniqueAppointmentTest() {
		assertFalse(this.appointmentService.deleteAppointment(VALID_APPOINTMENT_ID));
	}

	/**
	 * Asserts a deleteAppointment call to the AppointmentService returns true when the
	 * Appointment is not unique.
	 */
	@Test
	void deleteDuplicateAppointmentTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertTrue(this.appointmentService.deleteAppointment(VALID_APPOINTMENT_ID));
	}

	// Testing updateAppointmentDate(final String appointmentId, final Date updateDate)
	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns false
	 * when the appointment is unique and the Date is valid.
	 */
	@Test
	void updateUniqueAppointmentDateValidInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, this.futureDate));
	}

	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns false
	 * when the appointment is unique and the Date is null.
	 */
	@Test
	void updateUniqueAppointmentDateNullInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, null));
	}

	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns false
	 * when the appointment is unique and the Date is an invalid past Date.
	 */
	@Test
	void updateUniqueAppointmentDateInvalidDateInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, this.pastDate));
	}

	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns true
	 * when the appointment is not unique and the Date is valid.
	 */
	@Test
	void updateDuplicateAppointmentDateValidInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertTrue(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, this.futureDate));
	}

	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns false
	 * when the appointment is not unique and the Date is null.
	 */
	@Test
	void updateDuplicateAppointmentDateNullInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, null));
	}

	/**
	 * Asserts an updateAppointmentDate call to the AppointmentService returns false
	 * when the appointment is not unique and the Date is an invalid past Date.
	 */
	@Test
	void updateDuplicateAppointmentDateInvalidDateInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.updateAppointmentDate(VALID_APPOINTMENT_ID, this.pastDate));
	}

	// Testing updateAppointmentDescription(final String appointmentId, final String updateDescription)
	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is unique and the description is valid.
	 */
	@Test
	void updateUniqueAppointmentDescriptionValidInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is unique and the description is null.
	 */
	@Test
	void updateUniqueAppointmentDescriptionNullInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, null));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is unique and the description is an invalid minimum.
	 */
	@Test
	void updateUniqueAppointmentDescriptionInvalidMinInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is unique and the description is an invalid maximum.
	 */
	@Test
	void updateUniqueAppointmentDescriptionInvalidMaxInputTest() {
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, INVALID_MAX_51));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns true when
	 * the appointment is not unique and the description is valid.
	 */
	@Test
	void updateDuplicateAppointmentDescriptionValidInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertTrue(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is not unique and the description is null.
	 */
	@Test
	void updateDuplicateAppointmentDescriptionNullInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, null));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is not unique and the description is an invalid minimum.
	 */
	@Test
	void updateDuplicateAppointmentDescriptionInvalidMinInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateAppointmentDescription call to the AppointmentService returns false
	 * when the appointment is not unique and the description is an invalid maximum.
	 */
	@Test
	void updateDuplicateAppointmentDescriptionInvalidMaxInputTest() {
		this.appointmentService.addAppointment(this.appointment);
		assertFalse(this.appointmentService.updateAppointmentDescription(VALID_APPOINTMENT_ID, INVALID_MAX_51));
	}
}

