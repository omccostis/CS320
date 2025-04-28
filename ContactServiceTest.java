import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the ContactService class
public class ContactServiceTest {

    private ContactService service;

    // Initialize the service and add a default contact before each test
    @BeforeEach
    public void setUp() {
        service = new ContactService();
        service.addContact(new Contact("001", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testAddDuplicateContactThrowsException() {
        // Test adding a contact with a duplicate ID
        assertThrows(IllegalArgumentException.class, () -> 
            service.addContact(new Contact("001", "Jane", "Smith", "0987654321", "456 Park Ave")));
    }

    @Test
    public void testDeleteContact() {
        // Test deleting an existing contact, which should remove it from the service
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("001"));
    }

    @Test
    public void testUpdateContactFields() {
        // Test updating various fields for a contact and asserting the changes
        service.updateFirstName("001", "Mike");
        service.updateLastName("001", "Smith");
        service.updatePhone("001", "1112223333");
        service.updateAddress("001", "999 Broadway");

        Contact updated = service.getContact("001");
        assertEquals("Mike", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("1112223333", updated.getPhone());
        assertEquals("999 Broadway", updated.getAddress());
    }

    @Test
    public void testUpdateInvalidContactThrowsException() {
        // Test attempting to update a contact that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("xyz", "John"));
    }

    @Test
    public void testUpdateInvalidPhone() {
        // ADDED: Test for the update phone method
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "abc123"));
    }

    @Test
    public void testUpdateInvalidAddress() {
        // ADDED: Test for the update address method
        String longAddress = "This address is far too long to be accepted by the system!";
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("001", longAddress));
    }
}