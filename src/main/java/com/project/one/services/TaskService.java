package com.project.one.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;

/**
 * This class is a singleton service handling CRUD operations to the Task
 * database. NOTE: The current implementation uses an in-memory solution. This
 * should be replaced with a permanent persistence option.
 *
 * @see Task
 * @author Ben
 */
public class TaskService {

	// TODO This should be replaced with a permanent persistence option.
	private final Map<String, Task> taskMap;
	private static TaskService instance = new TaskService();

	/**
	 * Private Constructor.
	 */
	private TaskService() {
		this.taskMap = new ConcurrentHashMap<>();
	}

	/**
	 * Gets the only instance of TaskService.
	 *
	 * @return Returns the only instance of TaskService.
	 */
	public static TaskService getInstance() {
		return instance;
	}

	/**
	 * Adds a Task object.
	 *
	 * @param task The Task object that will be added.
	 * @return Returns true if the add was successful.
	 */
	public boolean addTask(final Task task) {
		if (!taskExists(task.getTaskId())) {
			this.taskMap.put(task.getTaskId(), task);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes a Task object based on a taskId.
	 *
	 * @param taskId The taskId that indicates the Task object that should be
	 *               deleted.
	 * @return Returns true if the delete was successful.
	 */
	public boolean deleteTask(final String taskId) {
		if (taskExists(taskId)) {
			this.taskMap.remove(taskId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Updates the name of a Task object based on a taskId.
	 *
	 * @param taskId     The taskId that indicates the Task object that should be
	 *                   updated.
	 * @param updateName The updated name of the Task object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateTaskName(final String taskId, final String updateName) {
		if (!taskExists(taskId)) {
			return false;
		} else {
			final Task task = this.taskMap.get(taskId);
			try {
				task.setName(updateName);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}

	}

	/**
	 * Updates the description of a Task object based on a taskId.
	 *
	 * @param taskId            The taskId that indicates the Task object that
	 *                          should be updated.
	 * @param updateDescription The updated description of the Task object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateTaskDescription(final String taskId, final String updateDescription) {
		if (!taskExists(taskId)) {
			return false;
		} else {
			final Task task = this.taskMap.get(taskId);
			try {
				task.setDescription(updateDescription);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}
	}

	/**
	 * Searches for an existing Task object based on a taskId.
	 *
	 * @param taskId The taskId being searched for.
	 * @return Returns true if the contact exists.
	 */
	private boolean taskExists(final String taskId) {
		if (this.taskMap.containsKey(taskId)) {
			return true;
		} else {
			return false;
		}
	}

}
