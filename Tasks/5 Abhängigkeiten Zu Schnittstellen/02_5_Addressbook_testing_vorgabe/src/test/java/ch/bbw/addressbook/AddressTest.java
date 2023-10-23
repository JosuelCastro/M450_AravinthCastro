package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address(1, "John", "Doe", "1234567890");
    }

    @Test
    public void testConstructorWithFourParameters() {
        assertEquals(1, address.getId());
        assertEquals("John", address.getFirstname());
        assertEquals("Doe", address.getLastname());
        assertEquals("1234567890", address.getPhonenumber());
    }

    @Test
    public void testConstructorWithFiveParameters() {
        Date date = new Date();
        Address addressWithDate = new Address(1, "John", "Doe", "1234567890", date);

        assertEquals(1, addressWithDate.getId());
        assertEquals("John", addressWithDate.getFirstname());
        assertEquals("Doe", addressWithDate.getLastname());
        assertEquals("1234567890", addressWithDate.getPhonenumber());
        assertEquals(date, addressWithDate.getRegistrationDate());
    }

    @Test
    public void testSettersAndGetters() {
        address.setId(2);
        address.setFirstname("Jane");
        address.setLastname("Smith");
        address.setPhonenumber("0987654321");
        Date newDate = new Date();
        address.setRegistrationDate(newDate);

        assertEquals(2, address.getId());
        assertEquals("Jane", address.getFirstname());
        assertEquals("Smith", address.getLastname());
        assertEquals("0987654321", address.getPhonenumber());
        assertEquals(newDate, address.getRegistrationDate());
    }
}
