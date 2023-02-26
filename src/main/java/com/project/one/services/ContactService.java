package com.project.one.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;

/**
 * This class is a singleton service handling CRUD operations to the Contact
 * database. NOTE: The current implementation uses an in-memory solution. This
 * should be replaced with a permanent persistence option.
 *
 * @see Contact
 * @author Ben
 */
public class ContactService {

	// TODO This should be replaced with a permanent persistence option.
	private final Map<String, Contact> contactMap;
	private static ContactService instance = new ContactService();

	/**
	 * Private Constructor.
	 */
	private ContactService() {
		this.contactMap = new ConcurrentHashMap<>();
	}

	/**
	 * Gets the only instance of ContactService.
	 *
	 * @return Returns the only instance of ContactService.
	 */
	public static ContactService getInstance() {
		return instance;
	}

	/**
	 * Adds a Contact object.
	 *
	 * @param contact The Contact object that will be added.
	 * @return Returns true if the add was successful.
	 */
	public boolean addContact(final Contact contact) {
		if (!contactExists(contact.getContactId())) {
			this.contactMap.put(contact.getContactId(), contact);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Deletes a Contact object based on a contactId.
	 *
	 * @param contactId The contactId that indicates the Contact object that should
	 *                  be deleted.
	 * @return Returns true if the delete was successful.
	 */
	public boolean deleteContact(final String contactId) {
		if (contactExists(contactId)) {
			this.contactMap.remove(contactId);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Updates the first name of a Contact object based on a contactId.
	 *
	 * @param contactId       The contactId that indicates the Contact object that
	 *                        should be updated.
	 * @param updateFirstName The updated first name of the Contact object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateContactFirstName(final String contactId, final String updateFirstName) {
		if (!contactExists(contactId)) {
			return false;
		} else {
			final Contact contact = this.contactMap.get(contactId);
			try {
				contact.setFirstName(updateFirstName);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}

	}

	/**
	 * Updates the last name of a Contact object based on a contactId.
	 *
	 * @param contactId      The contactId that indicates the Contact object that
	 *                       should be updated.
	 * @param updateLastName The updated last name of the Contact object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateContactLastName(final String contactId, final String updateLastName) {
		if (!contactExists(contactId)) {
			return false;
		} else {
			final Contact contact = this.contactMap.get(contactId);
			try {
				contact.setLastName(updateLastName);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}
	}

	/**
	 * Updates the phone number of a Contact object based on a contactId.
	 *
	 * @param contactId         The contactId that indicates the Contact object that
	 *                          should be updated.
	 * @param updatePhoneNumber The updated phone number of the Contact object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateContactPhoneNumber(final String contactId, final String updatePhoneNumber) {
		if (!contactExists(contactId)) {
			return false;
		} else {
			final Contact contact = this.contactMap.get(contactId);
			try {
				contact.setPhoneNumber(updatePhoneNumber);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}
		}
	}

	/**
	 * Updates the address of a Contact object based on a contactId.
	 *
	 * @param contactId     The contactId that indicates the Contact object that
	 *                      should be updated.
	 * @param updateAddress The updated address of the Contact object.
	 * @return Returns true if the update was successful.
	 */
	public boolean updateContactAddress(final String contactId, final String updateAddress) {
		if (!contactExists(contactId)) {
			return false;
		} else {
			final Contact contact = this.contactMap.get(contactId);
			try {
				contact.setAddress(updateAddress);
				return true;
			} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
				return false;
			}

		}
	}

	/**
	 * Searches for an existing Contact object based on a contactId.
	 *
	 * @param contactId The contactId being searched for.
	 * @return Returns true if the contact exists.
	 */
	private boolean contactExists(final String contactId) {
		if (this.contactMap.containsKey(contactId)) {
			return true;
		} else {
			return false;
		}
	}

}
