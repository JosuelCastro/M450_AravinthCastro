package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
class BankTests {

    private final Bank bank = new Bank();

    /**
     * Tests to create new Accounts
     */
    @Test
    void testCreate() {
        String accountId = bank.createSavingsAccount();
        assertNotNull(accountId);
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    void testDeposit() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 2023, 100);
        assertEquals(100, bank.getBalance(accountId));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    void testWithdraw() {
        String accountId = bank.createSavingsAccount();
        bank.withdraw(accountId, 2023, 100);
        assertEquals(0, bank.getBalance(accountId));
    }

    /**
     * Experimente mit print().
     */
    @Test
    void testPrint() {
        Bank bank = new Bank();
        String savingsAccountId = bank.createSavingsAccount();
        bank.print(savingsAccountId);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    void testMonthlyPrint() {
        Bank bank = new Bank();
        String savingsAccountId = bank.createSavingsAccount();
        bank.print(savingsAccountId, 2023, 10);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    void testBalance() {
        Bank bank = new Bank();
        String savingsAccountId = bank.createSavingsAccount();
        assertEquals(0, bank.getBalance());
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    void testTop5() {
        Bank bank = new Bank();
        for (int i = 0; i < 10; i++) {
            bank.createSavingsAccount();
        }
        bank.printTop5();
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    void testBottom5() {
        Bank bank = new Bank();
        for (int i = 0; i < 10; i++) {
            bank.createSavingsAccount();
        }
        bank.printBottom5();
    }

}
