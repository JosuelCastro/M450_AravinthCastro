package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
class SavingsAccountTests {
    @Test
    void test() {
        String accountId = "S-12345";
        SavingsAccount account = new SavingsAccount(accountId);

        int date = 20231024;
        long depositAmount = 10000;
        long withdrawAmount = 15000;

        account.deposit(date, depositAmount);

        boolean withdrawResult = account.withdraw(date, withdrawAmount);

        assertFalse(withdrawResult);
        assertEquals(depositAmount, account.getBalance());
    }
}

