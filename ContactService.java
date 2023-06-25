/*
 * Mobile App System
 * ContactService Class
 * Created: 5/20/2023
 * Author: Matthew Bandyk
 * Description: This is the service class that will manage the Contact Class objects.
 * UPDATED: 5/30/2023 by Matthew Bandyk (Updated data storage type to Hash Map)
 */

package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts; // Use HashMap to store contacts

    public ContactService() { // Constructor, creates a new HashMap to hold contacts
        contacts = new HashMap<>();
    }

    // Method to add a new contact object and place it in the HashMap. Validation occurs in the Contact Class.
    public void addContact(Contact contact) {
        if (contactWithID(contact.getContactID())) {
            throw new IllegalArgumentException("ID " + contact.getContactID() + " already exists."); // Throws an exception if ID is already being utilized
        }

        contacts.put(contact.getContactID(), contact);
    }

    /* 
     * Method to delete a contact object from the HashMap
     * @param contactID The contact ID to be deleted
     * @throws IllegalArgumentException if the contact does not exist 
     */
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("ID " + contactID + " does not exist."); // Throws an exception if the ID does not exist
        }

        contacts.remove(contactID);
    }

    /* 
     * Method to update a current Contact Object, validates each attribute before updating
     * @param contactID The contact object ID that should be updated
     * @param firstName The value to update the first name with
     * @param lastName The value to update the last name with
     * @param number The value to update the number with
     * @param address The value to update the address with
     * @throws IllegalArgumentException if any value is null or if values are the incorrect length
     */
    public void updateContact(String contactID, String firstName, String lastName, String number, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " does not exist.");
        }

        Contact contact = contacts.get(contactID);
    	
        // Validate first name, if null or greater than 10 in length, throws an exception
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid Input");
        }

        // Validate last name, if null or greater than 10 in length, throws an exception
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Input");
        }

        // Validate number, if null or not exactly 10 in length, throws an exception
        if (number == null || number.length() != 10) {
            throw new IllegalArgumentException("Invalid Input");
        }

        // Validate address, if null or greater than 30 in length, throws an exception
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Input");
        }
        
        // Update the contact info
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setNumber(number);
        contact.setAddress(address);
    }

    /* 
     * Method to confirm if a contact exists with a given contact ID
     * @param contactID The contact ID to search for
     * @return true if found, false if not
     */
    private boolean contactWithID(String contactID) {
        return contacts.containsKey(contactID);
    }

    /*
     * Method to return the current Contacts HashMap
     * @return The HashMap of contacts
     */
    public Map<String, Contact> getContacts() {
        return contacts;
    }

    /* 
     * Method to retrieve a contact object based on contact ID
     * @param contactID The contact ID to search for
     * @return The Contact object if found, null if not
     */
    public Contact getContactById(String contactID) {
        return contacts.get(contactID);
    }
}
