package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    private AddressService addressService;
    private AddressDAO addressDAO;

    @BeforeEach
    public void setUp() {
        addressDAO = Mockito.mock(AddressDAO.class);
        addressService = new AddressService(addressDAO);
    }

    @Test
    public void testGetAllAddresses() {
        Address address1 = new Address(1, "John", "Doe", new Date());
        Address address2 = new Address(2, "Jane", "Smith", new Date());
        when(addressDAO.readAll()).thenReturn(Arrays.asList(address1, address2));

        List<Address> addresses = addressService.getAllAddresses();
        assertNotNull(addresses);
        assertEquals(2, addresses.size());
    }

    @Test
    public void testRegisterAddress() {
        Address address = new Address(0, "John", "Doe");
        addressService.registerAddress(address);

        verify(addressDAO, times(1)).create(any(Address.class));
    }
}
