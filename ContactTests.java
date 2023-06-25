/*
 * Mobile App System - Test package
 * Contact JUnit Test Case
 * Created: 5/20/2023
 * Author: Matthew Bandyk
 * Description: JUnit test cases for the Contact Class.
 */

package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTests {
    private Contact contact;

    // Creates new contact object with inputs before each test
    @BeforeEach
    public void setUp() throws Exception {
        contact = new Contact("CS 305", "John", "Doe", "1234567890", "123 Main St");
    }

    // Validates that Contact Object can be created
    @Test
    public void testContactInitialization() {
        Assertions.assertEquals("CS 305", contact.getContactID());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getNumber());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    // Test to validate if creating a contact throws exception if contact id is null 
    @Test
    public void testContactIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if contact id is to long (Greater than 10)
    @Test
    public void testContactIdLengthExceeded() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ContactIDTooLong", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test to validate if creating a contact throws exception if first name is null
    @Test
    public void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", null, "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if first name is to long (Greater than 10)
    @Test
    public void testFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "FirstNameToLong", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if last name is null
    @Test
    public void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", null, "1234567890", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if last name is to long (Greater than 10)
    @Test
    public void testLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "LastNameToLong", "1234567890", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if number is null
    @Test
    public void testNumberNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "Doe", null, "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if number is not 10 in length (Shorter)
    @Test
    public void testNumberLengthToShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "Doe", "123", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if number is not 10 in length (Longer)
    @Test
    public void testNumberLengthToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "Doe", "9876543210123456789", "123 Main St");
        });
    }
    
    // Test to validate if creating a contact throws exception if address is null
    @Test
    public void testAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "Doe", "1234567890", null);
        });
    }
    
    // Test to validate if creating a contact throws exception if address is to long (Greater than 30)
    @Test
    public void testAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CS 305", "John", "Doe", "12345678909", "The address field is to long to fit in this system");
        });
    }
    
 // Test to validate if setter throws exception if first name is null
    @Test
    public void testSetFirstName() {
        contact.setFirstName("Mike");
        
        Assertions.assertEquals("Mike", contact.getFirstName());
    }
    
    // Test to validate if setter throws exception if first name is null
    @Test
    public void testSetFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
    
    // Test to validate if setter throws exception if first name is to long (Greater than 10)
    @Test
    public void testSetFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setFirstName("FirstNameToLong");
        });
    }
    
 // Test to validate if setter throws exception if last name is null
    @Test
    public void testSetLastName() {
    	contact.setLastName("Downey");
        
        Assertions.assertEquals("Downey", contact.getLastName());
    }
    
    // Test to validate if setter throws exception if last name is null
    @Test
    public void testSetLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setLastName(null);
        });
    }
    
    // Test to validate if setter throws exception if last name is to long (Greater than 10)
    @Test
    public void testSetLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setLastName("LastNameToLong");
        });
    }
    
 // Test to validate if setter throws exception if number is null
    @Test
    public void testSetNumber() {
    	contact.setNumber("9182736450");
        
        Assertions.assertEquals("9182736450", contact.getNumber());
    }
    
    // Test to validate if setter throws exception if number is null
    @Test
    public void testSetNumberNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setNumber(null);
        });
    }
    
    // Test to validate if setter throws exception if number is not 10 in length (Shorter)
    @Test
    public void testSetNumberLengthToShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setNumber("123");
        });
    }
    
    // Test to validate if setter throws exception if number is not 10 in length (Longer)
    @Test
    public void testSetNumberLengthToLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setNumber("12345678910");
        });
    }
    
 // Test to validate if setter for address will set the address
    @Test
    public void testSetAddress() {
    	contact.setAddress("Updated Address");
        
        Assertions.assertEquals("Updated Address", contact.getAddress());
    }
    
    // Test to validate if setter throws exception if address is null
    @Test
    public void testSetAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setAddress(null);
        });
    }
    
    // Test to validate if setter throws exception if address is to long (Greater than 30)
    @Test
    public void testSetAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contact.setAddress("The address field is to long to fit in this system");
        });
    }
}
