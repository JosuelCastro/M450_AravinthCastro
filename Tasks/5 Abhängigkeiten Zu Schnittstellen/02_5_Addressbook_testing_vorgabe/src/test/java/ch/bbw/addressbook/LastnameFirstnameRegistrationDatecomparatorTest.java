package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LastnameFirstnameRegistrationDatecomparatorTest {

    private LastnameFirstnameRegistrationDatecomparator comparator;
    private Address address1;
    private Address address2;

    @BeforeEach
    public void setUp() {
        comparator = new LastnameFirstnameRegistrationDatecomparator();
        address1 = new Address(1, "John", "Doe", "123456789", new Date());
        address2 = new Address(2, "Jane", "Smith", "987654321", new Date(System.currentTimeMillis() + 1000));
    }

    @Test
    public void testCompareByLastname() {
        assertTrue(comparator.compare(address1, address2) < 0);
        assertTrue(comparator.compare(address2, address1) > 0);
    }

    @Test
    public void testCompareByFirstname() {
        address1.setLastname("Smith");
        address2.setLastname("Smith");
        assertTrue(comparator.compare(address1, address2) < 0);
        assertTrue(comparator.compare(address2, address1) > 0);
    }

    @Test
    public void testCompareByRegistrationDate() {
        address1.setLastname("Smith");
        address2.setLastname("Smith");
        address1.setFirstname("Jane");
        address2.setFirstname("Jane");
        assertTrue(comparator.compare(address1, address2) < 0);
        assertTrue(comparator.compare(address2, address1) > 0);
    }
}
