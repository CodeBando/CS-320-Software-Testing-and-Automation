/*
 * Mobile App System
 * Contact Class
 * Created: 5/20/2023
 * Author: Matthew Bandyk
 * Description: Contact class to create Contact objects. Includes getters and setters for the contact object attributes.
 */

package Contact;

public class Contact {
    // Private attributes to hold objects data
	private String contactID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;

    /*
     * Constructor method to create Contact object. Validates inputs prior to creating object.
     * @param contactID The contact object ID
     * @param firstName The value for first name
     * @param lastName The value for last name
     * @param number The value for number
     * @param address The value for address
     * @throws IllegalArgumentException if any value is null or if values are the incorrect length
     */
    public Contact(String contactID, String firstName, String lastName, String number, String address) {
    	
    	// Validates Contact ID, if null or greater than 10 in length, throws exception
    	if (contactID == null || contactID.length() > 10) {
    		throw new IllegalArgumentException("Invalid ID");
        }
    	
    	// Validates first name, if null or greater than 10 in length, throws exception
    	if (firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid First Name");
        }

    	// Validates last name, if null or greater than 10 in length, throws exception
        if (lastName == null || lastName.length() > 10) {
        	throw new IllegalArgumentException("Invalid Last Name");
        }

        // Validates number, if null or not exactly 10 in length, throws exception
        if (number == null || number.length() != 10) {
        	throw new IllegalArgumentException("Invalid Phone Number");
        }

        // Validates address, if null or greater than 30 in length, throws exception
        if (address == null || address.length() > 30) {
        	throw new IllegalArgumentException("Invalid Address");
        }
    	
        // Assign attributes using parameters passed
    	this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    // getter method for contactID
    public String getContactID() {
        return contactID;
    }

    // getter method for first name
    public String getFirstName() {
        return firstName;
    }

    /* 
     * setter method for first name
     * @param firstName The value that should be assigned to first name
     * @throws IllegalArgumentException if value is null or to long
     */
    public void setFirstName(String firstName) {
    	if (firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid First Name");
        }
    	
    	this.firstName = firstName;
    }

    // getter method for last name
    public String getLastName() {
        return lastName;
    }

    /* 
     * setter method for last name
     * @param lastName The value that should be assigned to last name
     * @throws IllegalArgumentException if value is null or to long
     */
    public void setLastName(String lastName) {
    	if (lastName == null || lastName.length() > 10) {
        	throw new IllegalArgumentException("Invalid Last Name");
        }
    	
    	this.lastName = lastName;
    }

    // getter for number
    public String getNumber() {
        return number;
    }

    /* 
     * setter for number
     * @param number The value that should be assigned to number
     * @throws IllegalArgumentException if value is null or to long or short
     */
    public void setNumber(String number) {
    	if (number == null || number.length() != 10) {
        	throw new IllegalArgumentException("Invalid Phone Number");
        }
    	
    	this.number = number;
    }

    // getter for address
    public String getAddress() {
        return address;
    }

    /* 
     * setter for address
     * @param address The value that should be assigned to address
     * @throws IllegalArgumentException if value is null or to long
     */
    public void setAddress(String address) {
    	if (address == null || address.length() > 30) {
        	throw new IllegalArgumentException("Invalid Address");
        }
    	
    	this.address = address;
    }
}