package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
class BookingTests {
    /**
     * Tests f�r die Erzeugung von Buchungen.
     */
    @Test
    void testInitialization() {
        int expectedDate = 20231024;
        long expectedAmount = 10000;

        Booking booking = new Booking(expectedDate, expectedAmount);

        assertEquals(expectedDate, booking.getDate());
        assertEquals(expectedAmount, booking.getAmount());
    }

    /**
     * Experimente mit print().
     */
    @Test
    void testPrint() {
        int date = 20231024;
        long amount = 10000;
        long balance = 50000;

        Booking booking = new Booking(date, amount);

        booking.print(balance);
    }
}
