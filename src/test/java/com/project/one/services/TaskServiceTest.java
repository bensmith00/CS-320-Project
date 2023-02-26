package com.project.one.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;

/**
 * This class tests the functionality of the TaskService class.
 *
 * @see TaskService
 * @see Task
 * @author Ben
 */
public class TaskServiceTest {

	private static String INVALID_MIN = "";
	private static String INVALID_MAX_21 = "012345678901234567890";
	private static String INVALID_MAX_51 = "012345678901234567890123456789012345678901234567890";
	private static String VALID_INPUT = "TEST";
	private static String VALID_TASK_ID = "TaskID";
	private static String VALID_NAME = "Name";
	private static String VALID_DESCRIPTION = "Description";

	private TaskService taskService;
	private Task task;

	/**
	 * Retrieves the TaskService singleton before every test. Creates a valid
	 * Task object before every test.
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
		this.taskService = TaskService.getInstance();
		this.task = new Task(VALID_TASK_ID, VALID_NAME, VALID_DESCRIPTION);
	}

	/**
	 * Removes the Task object from the TaskService instance after every test.
	 */
	@AfterEach
	void tearDown() {
		this.taskService.deleteTask(VALID_TASK_ID);
	}

	// Testing addTask(final Task task)
	/**
	 * Asserts an addTask call to the TaskService returns true when the
	 * Task is unique.
	 */
	@Test
	void addUniqueTaskTest() {
		assertTrue(this.taskService.addTask(this.task));
	}

	/**
	 * Asserts an addTask call to the TaskService returns false when the
	 * Task is not unique.
	 */
	@Test
	void addDuplicateTaskTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.addTask(this.task));
	}

	// Testing deleteTask(final String taskId)
	/**
	 * Asserts a deleteTask call to the TaskService returns false when the
	 * Task is unique.
	 */
	@Test
	void deleteUniqueTaskTest() {
		assertFalse(this.taskService.deleteTask(VALID_TASK_ID));
	}

	/**
	 * Asserts a deleteTask call to the TaskService returns true when the
	 * Task is not unique.
	 */
	@Test
	void deleteDuplicateTaskTest() {
		this.taskService.addTask(this.task);
		assertTrue(this.taskService.deleteTask(VALID_TASK_ID));
	}

	// Testing updateTaskName(final String taskId, final String
	// updateName)
	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is unique and the name is valid.
	 */
	@Test
	void updateUniqueTaskNameValidInputTest() {
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is unique and the name is null.
	 */
	@Test
	void updateUniqueTaskNameNullInputTest() {
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, null));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is unique and the name is an invalid minimum.
	 */
	@Test
	void updateUniqueTaskNameInvalidMinInputTest() {
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is unique and the name is an invalid maximum.
	 */
	@Test
	void updateUniqueTaskNameInvalidMaxInputTest() {
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, INVALID_MAX_21));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns true
	 * when the task is not unique and the name is valid.
	 */
	@Test
	void updateDuplicateTaskNameValidInputTest() {
		this.taskService.addTask(this.task);
		assertTrue(this.taskService.updateTaskName(VALID_TASK_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is not unique and the name is null.
	 */
	@Test
	void updateDuplicateTaskNameNullInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, null));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is not unique and the name is an invalid minimum.
	 */
	@Test
	void updateDuplicateTaskNameInvalidMinInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateTaskName call to the TaskService returns false
	 * when the task is not unique and the name is an invalid maximum.
	 */
	@Test
	void updateDuplicateTaskNameInvalidMaxInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskName(VALID_TASK_ID, INVALID_MAX_21));
	}

	// Testing updateTaskDescription(final String taskId, final String
	// updateDescription)
	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is unique and the description is valid.
	 */
	@Test
	void updateUniqueTaskDescriptionValidInputTest() {
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is unique and the description is null.
	 */
	@Test
	void updateUniqueTaskDescriptionNullInputTest() {
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, null));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is unique and the description is an invalid minimum.
	 */
	@Test
	void updateUniqueTaskDescriptionInvalidMinInputTest() {
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is unique and the description is an invalid maximum.
	 */
	@Test
	void updateUniqueTaskDescriptionInvalidMaxInputTest() {
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, INVALID_MAX_51));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns true when
	 * the task is not unique and the description is valid.
	 */
	@Test
	void updateDuplicateTaskDescriptionValidInputTest() {
		this.taskService.addTask(this.task);
		assertTrue(this.taskService.updateTaskDescription(VALID_TASK_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is not unique and the description is null.
	 */
	@Test
	void updateDuplicateTaskDescriptionNullInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, null));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is not unique and the description is an invalid minimum.
	 */
	@Test
	void updateDuplicateTaskDescriptionInvalidMinInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateTaskDescription call to the TaskService returns false
	 * when the task is not unique and the description is an invalid maximum.
	 */
	@Test
	void updateDuplicateTaskDescriptionInvalidMaxInputTest() {
		this.taskService.addTask(this.task);
		assertFalse(this.taskService.updateTaskDescription(VALID_TASK_ID, INVALID_MAX_51));
	}
}
