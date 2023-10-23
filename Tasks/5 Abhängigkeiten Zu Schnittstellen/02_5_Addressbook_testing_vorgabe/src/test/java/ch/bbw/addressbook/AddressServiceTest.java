package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    private AddressService addressService;
    private AddressDAO addressDAO;

    @BeforeEach
    public void setUp() {
        addressDAO = mock(AddressDAO.class);
        addressService = new AddressService(addressDAO);
    }

    @Test
    public void testGetAllAddresses() {
        Address address1 = new Address(1, "John", "Doe", "1234567890");
        Address address2 = new Address(2, "Jane", "Smith", "0987654321");
        List<Address> addresses = Arrays.asList(address1, address2);

        when(addressDAO.readAll()).thenReturn(addresses);

        List<Address> result = addressService.getAllAddresses();

        assertEquals(2, result.size());
        assertEquals(address1, result.get(0));
        assertEquals(address2, result.get(1));
    }

    @Test
    public void testRegisterAddress() {
        Address address = new Address(1, "John", "Doe", "1234567890");

        addressService.registerAddress(address);

        verify(addressDAO, times(1)).create(address);
    }

    @Test
    public void testQuery() {
        when(addressDAO.isAvailable()).thenReturn(true);

        boolean result = addressService.query("some query");

        assertEquals(true, result);
    }
}
