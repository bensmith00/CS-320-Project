package com.project.one.services;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;
import com.project.one.utils.ProjectUtils;

/**
 * This class is a container for contact related information.
 *
 * @author Ben
 */
public class Contact {

	/**
	 * The minimum length that is acceptable for a field.
	 */
	public static int MIN_CHAR_LENGTH = 1;
	/**
	 * The maximum length that is acceptable for the contactId field.
	 */
	public static int CONTACT_ID_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the firstName field.
	 */
	public static int FIRST_NAME_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the lastName field.
	 */
	public static int LAST_NAME_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the phoneNumber field.
	 */
	public static int PHONE_MAX_CHAR_LENGTH = 10;
	/**
	 * The maximum length that is acceptable for the address field.
	 */
	public static int ADDRESS_MAX_CHAR_LENGTH = 30;

	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	/**
	 * Constructor.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param contactId   Unique Identifier of the contact.
	 * @param firstName   The first name of the contact.
	 * @param lastName    The last name of the contact.
	 * @param phoneNumber The phone number of the contact.
	 * @param address     The address of the contact.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public Contact(final String contactId, final String firstName, final String lastName, final String phoneNumber,
			final String address)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("contact ID", contactId, MIN_CHAR_LENGTH, CONTACT_ID_MAX_CHAR_LENGTH)) {
			this.contactId = contactId;
		}
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}

	/**
	 * Gets the firstName field.
	 *
	 * @return Returns the firstName field.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets the firstName field.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param firstName The firstName to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setFirstName(final String firstName)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("first name", firstName, MIN_CHAR_LENGTH, FIRST_NAME_MAX_CHAR_LENGTH)) {
			this.firstName = firstName;
		}
	}

	/**
	 * Gets the lastName field.
	 *
	 * @return Returns the lastName field.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets the lastName field.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param lastName The lastName to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setLastName(final String lastName)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("last name", lastName, MIN_CHAR_LENGTH, LAST_NAME_MAX_CHAR_LENGTH)) {
			this.lastName = lastName;
		}
	}

	/**
	 * Gets the phoneNumber field.
	 *
	 * @return Returns the phoneNumber field.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Sets the phoneNumber field.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param phoneNumber The phoneNumber to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setPhoneNumber(final String phoneNumber)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("phone number", phoneNumber, MIN_CHAR_LENGTH, PHONE_MAX_CHAR_LENGTH)) {
			this.phoneNumber = phoneNumber;
		}
	}

	/**
	 * Gets the address field.
	 *
	 * @return Returns the address field.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the address field.
	 *
	 * @see NullFieldException
	 * @see MinimumLengthNotMetException
	 * @see MaximumLengthExceededException
	 * @param address The address to set.
	 * @throws NullFieldException             Exception indicating a field is null.
	 * @throws MinimumLengthNotMetException   Exception indicating a field does not
	 *                                        meet the minimum length.
	 * @throws MaximumLengthExceededException Exception indicating a field does not
	 *                                        meet the maximum length.
	 */
	public void setAddress(final String address)
			throws NullFieldException, MinimumLengthNotMetException, MaximumLengthExceededException {
		if (ProjectUtils.validStringField("address", address, MIN_CHAR_LENGTH, ADDRESS_MAX_CHAR_LENGTH)) {
			this.address = address;
		}
	}

	/**
	 * Gets the contactId field.
	 *
	 * @return Returns the contactId field.
	 */
	public String getContactId() {
		return this.contactId;
	}

}
