package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
class SalaryAccountTests {
    /**
     * Der Test.
     */
    @Test
    void test() {
        String accountId = "P-12345";
        long creditLimit = -5000;
        SalaryAccount account = new SalaryAccount(accountId, creditLimit);

        int date = 20231024;
        long depositAmount = 10000;
        long withdrawAmount = 5500;

        account.deposit(date, depositAmount);

        boolean withdrawResult = account.withdraw(date, withdrawAmount);

        assertTrue(withdrawResult);
        assertEquals(depositAmount - withdrawAmount, account.getBalance());
    }
}
