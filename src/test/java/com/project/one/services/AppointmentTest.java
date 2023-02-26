package com.project.one.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.exceptions.PastDateException;

/**
 * This class tests the functionality of the Appointment class.
 *
 * @see Appointment
 * @author Ben
 */
public class AppointmentTest {

	private static String INVALID_MIN = "";
	private static String INVALID_MAX_11 = "01234567890";
	private static String INVALID_MAX_51 = "012345678901234567890123456789012345678901234567890";
	private static String VALID_APPOINTMENT_ID = "AppointID";
	private static String VALID_DESCRIPTION = "Description";
	private Appointment appointment;
	private Date pastDate;
	private Date futureDate;

	/**
	 * Creates a valid Appointment object before every test.
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
	void init()
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException, PastDateException {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -1);
		this.pastDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 2);
		this.futureDate = calendar.getTime();
		this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, VALID_DESCRIPTION);
	}

	// Constructor Tests
	/**
	 * Asserts a valid Appointment object construction returns true.
	 */
	@Test
	void constructorValid() {
		boolean valid = true;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid Appointment object construction with the appointmentId set to null
	 * throws a NullFieldException.
	 */
	@Test
	void constructorAppointmentIdNull() {
		boolean nullFails = false;
		try {
			this.appointment = new Appointment(null, this.futureDate, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Appointment object construction with the appointmentId set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorAppointmentIdMinNotMet() {
		boolean minFails = false;
		try {
			this.appointment = new Appointment(INVALID_MIN, this.futureDate, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Appointment object construction with the appointmentId set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorAppointmentIdMaxExceeded() {
		boolean maxFails = false;
		try {
			this.appointment = new Appointment(INVALID_MAX_11, this.futureDate, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Appointment object construction with the AppointmentDate set to
	 * null throws a NullFieldException.
	 */
	@Test
	void constructorAppointmentDateNull() {
		boolean nullFails = false;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, null, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Appointment object construction with the name set to an invalid
	 * minimum value throws a PastDateException.
	 */
	@Test
	void constructorAppointmentDateInPast() {
		boolean minFails = false;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.pastDate, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), PastDateException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Appointment object construction with the description set to null
	 * throws a NullFieldException.
	 */
	@Test
	void constructorDescriptionNull() {
		boolean nullFails = false;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Appointment object construction with the description set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorDescriptionMinNotMet() {
		boolean minFails = false;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Appointment object construction with the description set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorDescriptionMaxExceeded() {
		boolean maxFails = false;
		try {
			this.appointment = new Appointment(VALID_APPOINTMENT_ID, this.futureDate, INVALID_MAX_51);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException
				| PastDateException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Setter Tests
	/**
	 * Asserts a valid setAppointmentDate call on an Appointment object returns true.
	 */
	@Test
	void setterAppointmentDateValid() {
		boolean valid = true;
		try {
			this.appointment.setAppointmentDate(this.futureDate);
		} catch (NullFieldException | PastDateException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setAppointmentDate call on an Appointment object with the Date set
	 * to null value throws a NullFieldException.
	 */
	@Test
	void setterAppointmentDateNull() {
		boolean nullFails = false;
		try {
			this.appointment.setAppointmentDate(null);
		} catch (NullFieldException | PastDateException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setAppointmentDate call on an Appointment object with the Date set
	 * to a past Date throws a PastDateException.
	 */
	@Test
	void setterAppointmentDateIsPastDate() {
		boolean minFails = false;
		try {
			this.appointment.setAppointmentDate(this.pastDate);
		} catch (NullFieldException | PastDateException e) {
			assertEquals(e.getClass(), PastDateException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * Asserts a valid setDescription call on an Appointment object returns true.
	 */
	@Test
	void setterDescriptionValid() {
		boolean valid = true;
		try {
			this.appointment.setDescription(VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setDescription call on an Appointment object with the description
	 * set to null value throws a NullFieldException.
	 */
	@Test
	void setterDescriptionNull() {
		boolean nullFails = false;
		try {
			this.appointment.setDescription(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setDescription call on an Appointment object with the description
	 * set to an invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterDescriptionMinNotMet() {
		boolean minFails = false;
		try {
			this.appointment.setDescription(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setDescription call on an Appointment object with the description
	 * set to an invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterDescriptionMaxExceeded() {
		boolean maxFails = false;
		try {
			this.appointment.setDescription(INVALID_MAX_51);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Getter Tests
	/**
	 * Asserts the return of a getAppointmentId call to an Appointment object
	 * containing an appointmentId equal to "AppointID" is in fact equal to
	 * "AppointID".
	 */
	@Test
	void getterAppointmentId() {
		assertEquals(VALID_APPOINTMENT_ID, this.appointment.getAppointmentId());
	}

	/**
	 * Asserts the return of a getAppointmentDate call to an Appointment object containing a
	 * Date equal to "2-5-2024" is in fact equal to "2-5-2024".
	 */
	@Test
	void getterAppointmentDate() {
		assertEquals(this.futureDate, this.appointment.getAppointmentDate());
	}

	/**
	 * Asserts the return of a getDescription call to an Appointment object
	 * containing a description equal to "Description" is in fact equal to
	 * "Description".
	 */
	@Test
	void getterDescription() {
		assertEquals(VALID_DESCRIPTION, this.appointment.getDescription());
	}

}
