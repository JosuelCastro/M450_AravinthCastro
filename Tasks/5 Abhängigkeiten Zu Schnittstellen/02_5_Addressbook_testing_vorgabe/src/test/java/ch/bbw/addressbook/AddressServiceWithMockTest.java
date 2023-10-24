package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressServiceWithMockTest {

    private AddressService addressService;
    private AddressDAO addressDAO;

    @BeforeEach
    public void setUp() {
        addressDAO = new AddressDAOMock();
        addressService = new AddressService(addressDAO);
    }

    @Test
    public void testGetAllAddressesWithMock() {
        Address address1 = new Address(1, "John", "Doe", "123456789", new Date());
        Address address2 = new Address(2, "Jane", "Smith", "987654321", new Date());
        addressDAO.create(address1);
        addressDAO.create(address2);

        List<Address> addresses = addressService.getAllAddresses();
        assertNotNull(addresses);
        assertEquals(2, addresses.size());
    }

    @Test
    public void testRegisterAddressWithMock() {
        Address address = new Address(0, "John", "Doe", "123456789");
        addressService.registerAddress(address);

        Address retrievedAddress = addressDAO.read(1);
        assertNotNull(retrievedAddress);
        assertEquals("John", retrievedAddress.getFirstname());
    }
}
