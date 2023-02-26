package com.project.one.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;

/**
 * This class tests the functionality of the Task class.
 *
 * @see Task
 * @author Ben
 */
public class TaskTest {

	private static String INVALID_MIN = "";
	private static String INVALID_MAX_11 = "01234567890";
	private static String INVALID_MAX_21 = "012345678901234567890";
	private static String INVALID_MAX_51 = "012345678901234567890123456789012345678901234567890";
	private static String VALID_TASK_ID = "TaskID";
	private static String VALID_NAME = "Name";
	private static String VALID_DESCRIPTION = "Description";
	private Task task;

	/**
	 * Creates a valid Task object before every test.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	@BeforeEach
	void init() throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		this.task = new Task(VALID_TASK_ID, VALID_NAME, VALID_DESCRIPTION);
	}

	// Constructor Tests
	/**
	 * Asserts a valid Task object construction returns true.
	 */
	@Test
	void constructorValid() {
		boolean valid = true;
		try {
			this.task = new Task(VALID_TASK_ID, VALID_NAME, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid Task object construction with the taskId set to null throws
	 * a NullFieldException.
	 */
	@Test
	void constructorTaskIdNull() {
		boolean nullFails = false;
		try {
			this.task = new Task(null, VALID_NAME, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Task object construction with the taskId set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorTaskIdMinNotMet() {
		boolean minFails = false;
		try {
			this.task = new Task(INVALID_MIN, VALID_NAME, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Task object construction with the taskId set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorTaskIdMaxExceeded() {
		boolean maxFails = false;
		try {
			this.task = new Task(INVALID_MAX_11, VALID_NAME, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Task object construction with the name set to null throws
	 * a NullFieldException.
	 */
	@Test
	void constructorNameNull() {
		boolean nullFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, null, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Task object construction with the name set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorNameMinNotMet() {
		boolean minFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, INVALID_MIN, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Task object construction with the name set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, INVALID_MAX_21, VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Task object construction with the description set to null throws a
	 * NullFieldException.
	 */
	@Test
	void constructorDescriptionNull() {
		boolean nullFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, VALID_NAME, null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Task object construction with the description set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorDescriptionMinNotMet() {
		boolean minFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, VALID_NAME, INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Task object construction with the description set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorDescriptionMaxExceeded() {
		boolean maxFails = false;
		try {
			this.task = new Task(VALID_TASK_ID, VALID_NAME, INVALID_MAX_51);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Setter Tests
	/**
	 * Asserts a valid setName call on a Task object returns true.
	 */
	@Test
	void setterNameValid() {
		boolean valid = true;
		try {
			this.task.setName(VALID_NAME);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setName call on a Task object with the name set to
	 * null value throws a NullFieldException.
	 */
	@Test
	void setterNameNull() {
		boolean nullFails = false;
		try {
			this.task.setName(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setName call on a Task object with the name set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterNameMinNotMet() {
		boolean minFails = false;
		try {
			this.task.setName(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setName call on a Task object with the name set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.task.setName(INVALID_MAX_21);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * Asserts a valid setDescription call on a Task object returns true.
	 */
	@Test
	void setterDescriptionValid() {
		boolean valid = true;
		try {
			this.task.setDescription(VALID_DESCRIPTION);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setDescription call on a Task object with the description set to null
	 * value throws a NullFieldException.
	 */
	@Test
	void setterDescriptionNull() {
		boolean nullFails = false;
		try {
			this.task.setDescription(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setDescription call on a Task object with the description set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterDescriptionMinNotMet() {
		boolean minFails = false;
		try {
			this.task.setDescription(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setDescription call on a Task object with the description set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterDescriptionMaxExceeded() {
		boolean maxFails = false;
		try {
			this.task.setDescription(INVALID_MAX_51);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Getter Tests
	/**
	 * Asserts the return of a getTaskId call to a Task object containing a
	 * taskId equal to "TaskID" is in fact equal to "TaskID".
	 */
	@Test
	void getterTaskId() {
		assertEquals(VALID_TASK_ID, this.task.getTaskId());
	}

	/**
	 * Asserts the return of a getName call to a Task object containing a
	 * name equal to "Name" is in fact equal to "Name".
	 */
	@Test
	void getterName() {
		assertEquals(VALID_NAME, this.task.getName());
	}

	/**
	 * Asserts the return of a getDescription call to a Task object containing a
	 * description equal to "Description" is in fact equal to "Description".
	 */
	@Test
	void getterDescription() {
		assertEquals(VALID_DESCRIPTION, this.task.getDescription());
	}

}
