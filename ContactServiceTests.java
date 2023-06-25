/*
 * Mobile App System - Test package
 * Contact Service JUnit Test Case
 * Created: 5/20/2023
 * Author: Matthew Bandyk
 * Description: JUnit test cases for the Contact Service Class.
 * UPDATED: 5/30/2023 by Matthew Bandyk (Added test to verify multiple contacts loaded)
 */

package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTests {
    private ContactService contactService;

    // Creates new contact service object before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Test to validate the add contact method creates a Class Object
    @Test
    public void testAddContact() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Contact retrievedContact = contactService.getContactById("CS 305");
        Assertions.assertEquals(contact, retrievedContact);
    }
    
    @Test
    public void testAddMultipleContacts() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("CS 306", "Jane", "Fawn", "0987654321", "351 Main St");
        contactService.addContact(contact);
        contactService.addContact(contact2);

        Contact retrievedContact = contactService.getContactById("CS 305");
        Assertions.assertEquals(contact, retrievedContact);
        
        Contact retrievedContact2 = contactService.getContactById("CS 306");
        Assertions.assertEquals(contact2, retrievedContact2);
    }

    // Test to validate exception is thrown if a new contact is added using a contact ID that already exists
    @Test
    public void testAddContactWithDupID() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact2 = new Contact("CS 305", "Id", "is", "already   ", "used");
            contactService.addContact(contact2);
        });
    }
    
    // Test to validate that the delete contact method will delete a contact object
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("CS 305");

        Contact retrievedContact = contactService.getContactById("CS 305");
        Assertions.assertNull(retrievedContact);
    }
    
    // Test to validate that the delete contact method will throw exception if a contact that doesn't exist is asked to be deleted
    @Test
    public void testDeleteContactThatDoesntExist() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contactService.deleteContact("CS 305");
    	});
    }

    // Test to validate method to update an existing contact functions
    @Test
    public void testUpdateContactFields() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("CS 305", "Jane", "Smith", "0987654321", "456 Park Ave");

        Contact updatedContact = contactService.getContactById("CS 305");
        Assertions.assertEquals("Jane", updatedContact.getFirstName());
        Assertions.assertEquals("Smith", updatedContact.getLastName());
        Assertions.assertEquals("0987654321", updatedContact.getNumber());
        Assertions.assertEquals("456 Park Ave", updatedContact.getAddress());
    }
    
    // Test to validate method to update an existing contact throws exception if contact doesn't exist
    @Test
    public void testUpdateContactFieldsOnIdThatDoesntExist() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contactService.updateContact("CS 305", "Jane", "Smith", "0987654321", "456 Park Ave");
    	});
    }
    
    // Test to validate method to update an existing contact throws exception if first name is null
    @Test
    public void testUpdateContactFieldsFirstNameNull() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", null, "Smith", "0987654321", "456 Park Ave");
        });    
    }
    
    // Test to validate method to update an existing contact throws exception if first name is to long (Greater than 10)
    @Test
    public void testUpdateContactFieldsFirstNameLength() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "FirstNameToLong", "Smith", "0987654321", "456 Park Ave");
        });
    }
 
    // Test to validate method to update an existing contact throws exception if last name is null
    @Test
    public void testUpdateContactFieldsLastNameNull() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", null, "0987654321", "456 Park Ave");
        });
    }
    
    // Test to validate method to update an existing contact throws exception if last name is to long (Greater than 10)
    @Test
    public void testUpdateContactFieldsLastNameLength() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "LastNameToL", "0987654321", "456 Park Ave");
        });
    }
    
    // Test to validate method to update an existing contact throws exception if number is null
    @Test
    public void testUpdateContactFieldsNumberNull() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "Smith", null, "456 Park Ave");
        });
    }
    
    // Test to validate method to update an existing contact throws exception if number is not 10 in length (shorter)
    @Test
    public void testUpdateContactFieldsNumberToShort() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "Smith", "123456789", "456 Park Ave");
        });
    }
    
    // Test to validate method to update an existing contact throws exception if number is not 10 in length (longer)
    @Test
    public void testUpdateContactFieldsNumberToLong() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "Smith", "12345678910", "456 Park Ave");
        });
    }
    
    // Test to validate method to update an existing contact throws exception if address is null
    @Test
    public void testUpdateContactFieldsAddressNull() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "Smith", "0987654321", null);
        });
    }
    
    // Test to validate method to update an existing contact throws exception if address is to long (Greater than 30)
    @Test
    public void testUpdateContactFieldsAddressLength() {
        Contact contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.updateContact("CS 305", "Jane", "Smith", "0987654321", "The Address is way to long      ");
        });
    }
}
