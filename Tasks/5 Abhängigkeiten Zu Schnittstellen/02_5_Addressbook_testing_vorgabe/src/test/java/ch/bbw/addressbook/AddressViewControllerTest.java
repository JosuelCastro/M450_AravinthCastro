package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressViewControllerTest {

    private AddressViewController addressViewController;
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        addressService = Mockito.mock(AddressService.class);
        addressViewController = new AddressViewController();
    }

    @Test
    public void testGetAddresses() {
        Address address1 = new Address(1, "John", "Doe", new Date());
        Address address2 = new Address(2, "Jane", "Smith", new Date());
        when(addressService.getAllAddresses()).thenReturn(Arrays.asList(address1, address2));

        addressViewController.getAddresses();
        List<Address> addresses = addressViewController.getAddresses();
        assertNotNull(addresses);
        assertEquals(2, addresses.size());
    }

    @Test
    public void testSaveAddress() {
        addressViewController.setFirstname("John");
        addressViewController.setLastname("Doe");
        addressViewController.saveAddress();

        verify(addressService, times(1)).registerAddress(any(Address.class));
    }
}
