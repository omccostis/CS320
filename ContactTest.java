import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the Contact class
public class ContactTest {

    @Test
    public void testValidContactCreation() {
        // Test creating a contact with valid data
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    public void testInvalidContactIdTooLong() {
        // Test creating a contact with an ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Test an invalid phone number (too short)
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("123", "John", "Doe", "12345", "123 Main St"));
    }

    @Test
    public void testSettersWithInvalidData() {
        // Validate that setters enforce constraints
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ThisNameIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("notdigits"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    public void testAllGetters() {
        // ADDED: Test for each getter
        Contact c = new Contact("C001", "Jane", "Smith", "1234567890", "456 Elm St");
        assertEquals("C001", c.getContactId());
        assertEquals("Jane", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("456 Elm St", c.getAddress());
    }

    @Test
    public void testValidSetters() {
        // ADDED: Test for each setter
        Contact c = new Contact("C002", "John", "Doe", "1234567890", "789 Oak St");
        c.setFirstName("Alice");
        c.setLastName("Walker");
        c.setPhone("0987654321");
        c.setAddress("321 Birch Blvd");
        assertEquals("Alice", c.getFirstName());
        assertEquals("Walker", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("321 Birch Blvd", c.getAddress());
    }
}