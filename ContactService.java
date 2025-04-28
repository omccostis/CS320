import java.util.HashMap;
import java.util.Map;

// Service class for managing a collection of contacts in memory
public class ContactService {
    // HashMap to store contacts using contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact; throw exception if ID is not unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId()))
            throw new IllegalArgumentException("Contact ID already exists");
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by contact ID; throw exception if ID not found
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact ID not found");
        contacts.remove(contactId);
    }

    // Update the first name for a specific contact
    public void updateFirstName(String contactId, String newFirstName) {
        getContact(contactId).setFirstName(newFirstName);
    }

    // Update the last name for a specific contact
    public void updateLastName(String contactId, String newLastName) {
        getContact(contactId).setLastName(newLastName);
    }

    // Update the phone number for a specific contact
    public void updatePhone(String contactId, String newPhone) {
        getContact(contactId).setPhone(newPhone);
    }

    // Update the address for a specific contact
    public void updateAddress(String contactId, String newAddress) {
        getContact(contactId).setAddress(newAddress);
    }

    // Retrieve a contact by ID; throw exception if not found
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId))
            throw new IllegalArgumentException("Contact ID not found");
        return contacts.get(contactId);
    }
}