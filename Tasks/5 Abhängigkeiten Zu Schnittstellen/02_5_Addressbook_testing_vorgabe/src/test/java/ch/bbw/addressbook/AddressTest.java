package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address(1, "John", "Doe", "123456789", new Date());
    }

    @Test
    public void testGettersAndSetters() {
        Date date = new Date();

        address.setId(1);
        address.setFirstname("John");
        address.setLastname("Doe");
        address.setPhonenumber("123456789");
        address.setRegistrationDate(date);

        assertEquals(1, address.getId());
        assertEquals("John", address.getFirstname());
        assertEquals("Doe", address.getLastname());
        assertEquals("123456789", address.getPhonenumber());
        assertEquals(date, address.getRegistrationDate());
    }
}
