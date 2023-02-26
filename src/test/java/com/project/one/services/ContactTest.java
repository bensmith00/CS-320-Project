package com.project.one.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.one.exceptions.MaximumLengthExceededException;
import com.project.one.exceptions.MinimumLengthNotMetException;
import com.project.one.exceptions.NullFieldException;

/**
 * This class tests the functionality of the Contact class.
 *
 * @see Contact
 * @author Ben
 */
public class ContactTest {

	private static String INVALID_MIN = "";
	private static String INVALID_MAX_11 = "12345678910";
	private static String INVALID_MAX_31 = "1234567891123456789112345678910";
	private static String VALID_CONTACT_ID = "ContactID";
	private static String VALID_FIRST_NAME = "FirstName";
	private static String VALID_LAST_NAME = "LastName";
	private static String VALID_PHONE = "Phone";
	private static String VALID_ADDRESS = "Address";
	private Contact contact;

	/**
	 * Creates a valid Contact object before every test.
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
		this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
	}

	// Constructor Tests
	/**
	 * Asserts a valid Contact object construction returns true.
	 */
	@Test
	void constructorValid() {
		boolean valid = true;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid Contact object construction with the contactId set to null throws
	 * a NullFieldException.
	 */
	@Test
	void constructorContactIdNull() {
		boolean nullFails = false;
		try {
			this.contact = new Contact(null, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Contact object construction with the contactId set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorContactIdMinNotMet() {
		boolean minFails = false;
		try {
			this.contact = new Contact(INVALID_MIN, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Contact object construction with the contactId set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorContactIdMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact = new Contact(INVALID_MAX_11, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Contact object construction with the firstName set to null throws
	 * a NullFieldException.
	 */
	@Test
	void constructorFirstNameNull() {
		boolean nullFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, null, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Contact object construction with the firstName set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorFirstNameMinNotMet() {
		boolean minFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, INVALID_MIN, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Contact object construction with the firstName set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorFirstNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, INVALID_MAX_11, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Contact object construction with the lastName set to null throws a
	 * NullFieldException.
	 */
	@Test
	void constructorLastNameNull() {
		boolean nullFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, null, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Contact object construction with the lastName set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorLastNameMinNotMet() {
		boolean minFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, INVALID_MIN, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Contact object construction with the lastName set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorLastNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, INVALID_MAX_11, VALID_PHONE, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Contact object construction with the phoneNumber set to null
	 * throws a NullFieldException.
	 */
	@Test
	void constructorPhoneNumberNull() {
		boolean nullFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, null, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Contact object construction with the phoneNumber set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorPhoneNumberMinNotMet() {
		boolean minFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, INVALID_MIN, VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Contact object construction with the phoneNumber set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorPhoneNumberMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, INVALID_MAX_11,
					VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * An invalid Contact object construction with the address set to null throws a
	 * NullFieldException.
	 */
	@Test
	void constructorAddressNull() {
		boolean nullFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid Contact object construction with the address set to an invalid
	 * minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void constructorAddressMinNotMet() {
		boolean minFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid Contact object construction with the address set to an invalid
	 * maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void constructorAddressMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact = new Contact(VALID_CONTACT_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE,
					INVALID_MAX_31);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Setter Tests
	/**
	 * Asserts a valid setFirstName call on a Contact object returns true.
	 */
	@Test
	void setterFirstNameValid() {
		boolean valid = true;
		try {
			this.contact.setFirstName(VALID_FIRST_NAME);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setFirstName call on a Contact object with the firstName set to
	 * null value throws a NullFieldException.
	 */
	@Test
	void setterFirstNameNull() {
		boolean nullFails = false;
		try {
			this.contact.setFirstName(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setFirstName call on a Contact object with the firstName set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterFirstNameMinNotMet() {
		boolean minFails = false;
		try {
			this.contact.setFirstName(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setFirstName call on a Contact object with the firstName set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterFirstNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact.setFirstName(INVALID_MAX_11);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * Asserts a valid setLastName call on a Contact object returns true.
	 */
	@Test
	void setterLastNameValid() {
		boolean valid = true;
		try {
			this.contact.setLastName(VALID_LAST_NAME);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setLastName call on a Contact object with the lastName set to null
	 * value throws a NullFieldException.
	 */
	@Test
	void setterLastNameNull() {
		boolean nullFails = false;
		try {
			this.contact.setLastName(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setLastName call on a Contact object with the lastName set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterLastNameMinNotMet() {
		boolean minFails = false;
		try {
			this.contact.setLastName(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setLastName call on a Contact object with the lastName set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterLastNameMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact.setLastName(INVALID_MAX_11);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * Asserts a valid setPhoneNumber call on a Contact object returns true.
	 */
	@Test
	void setterPhoneNumberValid() {
		boolean valid = true;
		try {
			this.contact.setPhoneNumber(VALID_PHONE);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setPhoneNumber call on a Contact object with the phoneNumber set
	 * to null value throws a NullFieldException.
	 */
	@Test
	void setterPhoneNumberNull() {
		boolean nullFails = false;
		try {
			this.contact.setPhoneNumber(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setPhoneNumber call on a Contact object with the phoneNumber set
	 * to an invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterPhoneNumberMinNotMet() {
		boolean minFails = false;
		try {
			this.contact.setPhoneNumber(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setPhoneNumber call on a Contact object with the phoneNumber set
	 * to an invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterPhoneNumberMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact.setPhoneNumber(INVALID_MAX_11);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	/**
	 * Asserts a valid setAddress call on a Contact object returns true.
	 */
	@Test
	void setterAddressValid() {
		boolean valid = true;
		try {
			this.contact.setAddress(VALID_ADDRESS);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			valid = false;
		}
		assertTrue(valid);
	}

	/**
	 * An invalid setAddress call on a Contact object with the address set to null
	 * value throws a NullFieldException.
	 */
	@Test
	void setterAddressNull() {
		boolean nullFails = false;
		try {
			this.contact.setAddress(null);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), NullFieldException.class);
			nullFails = true;
		}
		assertTrue(nullFails);
	}

	/**
	 * An invalid setAddress call on a Contact object with the address set to an
	 * invalid minimum value throws a MinimumLengthNotMetException.
	 */
	@Test
	void setterAddressMinNotMet() {
		boolean minFails = false;
		try {
			this.contact.setAddress(INVALID_MIN);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MinimumLengthNotMetException.class);
			minFails = true;
		}
		assertTrue(minFails);
	}

	/**
	 * An invalid setAddress call on a Contact object with the address set to an
	 * invalid maximum value throws a MaximumLengthExceededException.
	 */
	@Test
	void setterAddressMaxExceeded() {
		boolean maxFails = false;
		try {
			this.contact.setAddress(INVALID_MAX_31);
		} catch (NullFieldException | MinimumLengthNotMetException | MaximumLengthExceededException e) {
			assertEquals(e.getClass(), MaximumLengthExceededException.class);
			maxFails = true;
		}
		assertTrue(maxFails);
	}

	// Getter Tests
	/**
	 * Asserts the return of a getContactId call to a Contact object containing a
	 * contactId equal to "ContactID" is in fact equal to "ContactID".
	 */
	@Test
	void getterContactId() {
		assertEquals(VALID_CONTACT_ID, this.contact.getContactId());
	}

	/**
	 * Asserts the return of a getFirstName call to a Contact object containing a
	 * firstName equal to "FirstName" is in fact equal to "FirstName".
	 */
	@Test
	void getterFirstName() {
		assertEquals(VALID_FIRST_NAME, this.contact.getFirstName());
	}

	/**
	 * Asserts the return of a getLastName call to a Contact object containing a
	 * lastName equal to "LastName" is in fact equal to "LastName".
	 */
	@Test
	void getterLastName() {
		assertEquals(VALID_LAST_NAME, this.contact.getLastName());
	}

	/**
	 * Asserts the return of a getPhoneNumber call to a Contact object containing a
	 * phoneNumber equal to "Phone" is in fact equal to "Phone".
	 */
	@Test
	void getterPhoneNumber() {
		assertEquals(VALID_PHONE, this.contact.getPhoneNumber());
	}

	/**
	 * Asserts the return of a getAddress call to a Contact object containing a
	 * address equal to "Address" is in fact equal to "Address".
	 */
	@Test
	void getterAddress() {
		assertEquals(VALID_ADDRESS, this.contact.getAddress());
	}

}
