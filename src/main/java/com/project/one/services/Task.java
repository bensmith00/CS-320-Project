package com.project.one.services;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.utils.ProjectUtils;

/**
 * This class is a container for task related information.
 *
 * @author Ben
 */
public class Task {

	/**
	 * The minimum length that is acceptable for a field.
	 */
	public static int MIN_CHAR_LENGTH = 1;
	/**
	 * The maximum length that is acceptable for the taskId field.
	 */
	public static int TASK_ID_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the name field.
	 */
	public static int NAME_MAX_CHAR_LENGTH = 20;
	/**
	 * The maximum length that is acceptable for the description field.
	 */
	public static int DESCRIPTION_MAX_CHAR_LENGTH = 50;

	private String taskId;
	private String name;
	private String description;

	/**
	 * Constructor.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param taskId      Unique Identifier of the task.
	 * @param name        The name of the task.
	 * @param description The description of the task.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public Task(final String taskId, final String name, final String description)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("task ID", taskId, MIN_CHAR_LENGTH, TASK_ID_MAX_CHAR_LENGTH)) {
			this.taskId = taskId;
		}
		setName(name);
		setDescription(description);
	}

	/**
	 * Gets the name field.
	 *
	 * @return Returns the name field.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name field.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param name The name to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setName(final String name)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("name", name, MIN_CHAR_LENGTH, NAME_MAX_CHAR_LENGTH)) {
			this.name = name;
		}
	}

	/**
	 * Gets the description field.
	 *
	 * @return Returns the description field.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description field.
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
	 * Gets the taskId field.
	 *
	 * @return Returns the taskId field.
	 */
	public String getTaskId() {
		return this.taskId;
	}

}
