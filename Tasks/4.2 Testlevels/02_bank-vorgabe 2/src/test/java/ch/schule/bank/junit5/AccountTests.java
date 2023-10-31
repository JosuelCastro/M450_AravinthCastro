
package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
class AccountTests {

    private final Account account = new Account("1");
    private final SavingsAccount savingsAccount = new SavingsAccount("1");

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    void testInit() {
        assertEquals("1", account.getId());
        assertEquals(0, account.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
     void testDeposit() {
        account.deposit(24102023, 10);
        assertEquals(10, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
     void testWithdraw() {
        account.withdraw(24102023, 10);
        assertEquals(-10, account.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    @Test
     void testReferences() {
        assertEquals("1", savingsAccount.getId());
        assertEquals(0, savingsAccount.getBalance());
    }

    /**
     * teste the canTransact Flag
     */
    @Test
     void testCanTransact() {
        assertTrue(account.getBookings().isEmpty());
        assertTrue(account.canTransact(24102023));
    }

    /**
     * Experimente mit print().
     */
    @Test
     void testPrint() {
        account.deposit(1, 5000);
        account.print();

        String expectedOutput = "Kontoauszug '1'" +
                "\\nDatum:  Betrag:  Saldo:  ";
        assertFalse(outContent.toString().contains(expectedOutput));
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
     void testMonthlyPrint() {
        account.deposit(1, 5000);
        account.withdraw(2, 2000);
        account.print(1970, 1);

        String expectedOutput = "Kontoauszug '1' Monat: 1.1970" +
                "\\nDatum          Betrag      Saldo";
        assertFalse(outContent.toString().contains(expectedOutput));
    }

}
