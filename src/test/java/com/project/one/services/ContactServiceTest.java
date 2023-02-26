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
 * This class tests the functionality of the ContactService class.
 *
 * @see ContactService
 * @see Contact
 * @author Ben
 */
public class ContactServiceTest {

	private static String INVALID_MIN = "";
	private static String INVALID_MAX_11 = "12345678910";
	private static String INVALID_MAX_31 = "1234567891123456789112345678910";
	private static String VALID_INPUT = "TEST";
	private static String VALID_CONTACT_ID = "ContactID";
	private static String VALID_FIRST_NAME = "FirstName";
	private static String VALID_LAST_NAME = "LastName";
	private static String VALID_PHONE = "Phone";
	private static String VALID_ADDRESS = "Address";

	private ContactService contactService;
	private Contact contact;

	/**
	 * Retrieves the ContactService singleton before every test. Creates a valid
	 * Contact object before every test.
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
		this.contactService = ContactService.getInstance();
		this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
	}

	/**
	 * Removes the Contact object from the ContactService instance after every test.
	 */
	@AfterEach
	void tearDown() {
		this.contactService.deleteContact(VALID_CONTACT_ID);
	}

	// Testing addContact(final Contact contact)
	/**
	 * Asserts an addContact call to the ContactService returns true when the
	 * contact is unique.
	 */
	@Test
	void addUniqueContactTest() {
		assertTrue(this.contactService.addContact(this.contact));
	}

	/**
	 * Asserts an addContact call to the ContactService returns false when the
	 * contact is not unique.
	 */
	@Test
	void addDuplicateContactTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.addContact(this.contact));
	}

	// Testing deleteContact(final String contactId)
	/**
	 * Asserts a deleteContact call to the ContactService returns false when the
	 * contact is unique.
	 */
	@Test
	void deleteUniqueContactTest() {
		assertFalse(this.contactService.deleteContact(VALID_CONTACT_ID));
	}

	/**
	 * Asserts a deleteContact call to the ContactService returns true when the
	 * contact is not unique.
	 */
	@Test
	void deleteDuplicateContactTest() {
		this.contactService.addContact(this.contact);
		assertTrue(this.contactService.deleteContact(VALID_CONTACT_ID));
	}

	// Testing updateContactFirstName(final String contactId, final String
	// updateFirstName)
	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is unique and the firstName is valid.
	 */
	@Test
	void updateUniqueContactFirstNameValidInputTest() {
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is unique and the firstName is null.
	 */
	@Test
	void updateUniqueContactFirstNameNullInputTest() {
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is unique and the firstName is an invalid minimum.
	 */
	@Test
	void updateUniqueContactFirstNameInvalidMinInputTest() {
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is unique and the firstName is an invalid maximum.
	 */
	@Test
	void updateUniqueContactFirstNameInvalidMaxInputTest() {
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns true
	 * when the contact is not unique and the firstName is valid.
	 */
	@Test
	void updateDuplicateContactFirstNameValidInputTest() {
		this.contactService.addContact(this.contact);
		assertTrue(this.contactService.updateContactFirstName(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is not unique and the firstName is null.
	 */
	@Test
	void updateDuplicateContactFirstNameNullInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is not unique and the firstName is an invalid minimum.
	 */
	@Test
	void updateDuplicateContactFirstNameInvalidMinInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactFirstName call to the ContactService returns false
	 * when the contact is not unique and the firstName is an invalid maximum.
	 */
	@Test
	void updateDuplicateContactFirstNameInvalidMaxInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactFirstName(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	// Testing updateContactLastName(final String contactId, final String
	// updateLastName)
	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is unique and the lastName is valid.
	 */
	@Test
	void updateUniqueContactLastNameValidInputTest() {
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is unique and the lastName is null.
	 */
	@Test
	void updateUniqueContactLastNameNullInputTest() {
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is unique and the lastName is an invalid minimum.
	 */
	@Test
	void updateUniqueContactLastNameInvalidMinInputTest() {
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is unique and the lastName is an invalid maximum.
	 */
	@Test
	void updateUniqueContactLastNameInvalidMaxInputTest() {
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns true when
	 * the contact is not unique and the lastName is valid.
	 */
	@Test
	void updateDuplicateContactLastNameValidInputTest() {
		this.contactService.addContact(this.contact);
		assertTrue(this.contactService.updateContactLastName(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is not unique and the lastName is null.
	 */
	@Test
	void updateDuplicateContactLastNameNullInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is not unique and the lastName is an invalid minimum.
	 */
	@Test
	void updateDuplicateContactLastNameInvalidMinInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactLastName call to the ContactService returns false
	 * when the contact is not unique and the lastName is an invalid maximum.
	 */
	@Test
	void updateDuplicateContactLastNameInvalidMaxInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactLastName(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	// Testing updateContactPhoneNumber(final String contactId, final String
	// updatePhoneNumber)
	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is unique and the phoneNumber is valid.
	 */
	@Test
	void updateUniqueContactPhoneNumberValidInputTest() {
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is unique and the phoneNumber is null.
	 */
	@Test
	void updateUniqueContactPhoneNumberNullInputTest() {
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is unique and the phoneNumber is an invalid minimum.
	 */
	@Test
	void updateUniqueContactPhoneNumberInvalidMinInputTest() {
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is unique and the phoneNumber is an invalid maximum.
	 */
	@Test
	void updateUniqueContactPhoneNumberInvalidMaxInputTest() {
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns true
	 * when the contact is not unique and the phoneNumber is valid.
	 */
	@Test
	void updateDuplicateContactPhoneNumberValidInputTest() {
		this.contactService.addContact(this.contact);
		assertTrue(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is not unique and the phoneNumber is null.
	 */
	@Test
	void updateDuplicateContactPhoneNumberNullInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is not unique and the phoneNumber is an invalid minimum.
	 */
	@Test
	void updateDuplicateContactPhoneNumberInvalidMinInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactPhoneNumber call to the ContactService returns false
	 * when the contact is not unique and the phoneNumber is an invalid maximum.
	 */
	@Test
	void updateDuplicateContactPhoneNumberInvalidMaxInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactPhoneNumber(VALID_CONTACT_ID, INVALID_MAX_11));
	}

	// Testing updateContactAddress(final String contactId, final String
	// updateAddress)
	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is unique and the address is valid.
	 */
	@Test
	void updateUniqueContactAddressValidInputTest() {
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is unique and the address is null.
	 */
	@Test
	void updateUniqueContactAddressNullInputTest() {
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is unique and the address is an invalid minimum.
	 */
	@Test
	void updateUniqueContactAddressInvalidMinInputTest() {
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is unique and the address is an invalid maximum.
	 */
	@Test
	void updateUniqueContactAddressInvalidMaxInputTest() {
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, INVALID_MAX_31));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns true when
	 * the contact is not unique and the address is valid.
	 */
	@Test
	void updateDuplicateContactAddressValidInputTest() {
		this.contactService.addContact(this.contact);
		assertTrue(this.contactService.updateContactAddress(VALID_CONTACT_ID, VALID_INPUT));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is not unique and the address is null.
	 */
	@Test
	void updateDuplicateContactAddressNullInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, null));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is not unique and the address is an invalid minimum.
	 */
	@Test
	void updateDuplicateContactAddressInvalidMinInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, INVALID_MIN));
	}

	/**
	 * Asserts an updateContactAddress call to the ContactService returns false when
	 * the contact is not unique and the address is an invalid maximum.
	 */
	@Test
	void updateDuplicateContactAddressInvalidMaxInputTest() {
		this.contactService.addContact(this.contact);
		assertFalse(this.contactService.updateContactAddress(VALID_CONTACT_ID, INVALID_MAX_31));
	}

}
