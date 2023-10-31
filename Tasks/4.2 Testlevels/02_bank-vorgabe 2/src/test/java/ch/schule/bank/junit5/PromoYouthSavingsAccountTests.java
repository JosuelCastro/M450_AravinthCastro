package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
class PromoYouthSavingsAccountTests {
    /**
     * Der Test.
     */
    @Test
    void test() {
        String accountId = "Y-12345";
        PromoYouthSavingsAccount account = new PromoYouthSavingsAccount(accountId);

        int date = 20231024;
        long initialAmount = 10000;
        long expectedBonus = initialAmount / 100;

        boolean depositResult = account.deposit(date, initialAmount);

        assertTrue(depositResult);
        assertEquals(initialAmount + expectedBonus, account.getBalance());
    }
}
