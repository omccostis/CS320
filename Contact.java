// Contact class containing contact information
public class Contact {
    // Unique identifier for the contact (cannot be updated)
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor enforces all validation rules during contact creation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contact ID
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        // Validate first name
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        // Validate last name
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        // Validate phone number (must be 10 digits)
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+"))
            throw new IllegalArgumentException("Invalid phone number");
        // Validate address
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters for all fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters include validation to maintain data integrity
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}