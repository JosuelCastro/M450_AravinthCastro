public class PriceCalculationTest {

    public static void main(String[] args) {
        boolean allTestsPassed = true;

        // Test 1: Kein Rabatt auf Grundpreis, keine Sondermodellaufschlag, keine Zusatzaustattungen
        double result1 = calculatePrice(20000.0, 0.0, 0.0, 0, 0.0);
        if (result1 != 20000.0) {
            System.out.println("Test 1 failed. Expected: 20000.0, Actual: " + result1);
            allTestsPassed = false;
        }

        // Test 2: 5% Händlerrabatt auf Grundpreis, 10% Rabatt auf 3 Zusatzaustattungen
        double result2 = calculatePrice(25000.0, 0.0, 1000.0, 3, 5.0);
        if (result2 != 23875.0) {
            System.out.println("Test 2 failed. Expected: 23875.0, Actual: " + result2);
            allTestsPassed = false;
        }

        // Test 3: 15% Händlerrabatt auf Grundpreis, 15% Rabatt auf 5 Zusatzaustattungen
        double result3 = calculatePrice(30000.0, 500.0, 2000.0, 5, 15.0);
        if (result3 != 29525.0) {
            System.out.println("Test 3 failed. Expected: 29525.0, Actual: " + result3);
            allTestsPassed = false;
        }

        // Test 4: Kein Rabatt auf Grundpreis, 0% Rabatt auf 2 Zusatzaustattungen
        double result4 = calculatePrice(18000.0, 0.0, 500.0, 2, 0.0);
        if (result4 != 18500.0) {
            System.out.println("Test 4 failed. Expected: 18500.0, Actual: " + result4);
            allTestsPassed = false;
        }

        if (allTestsPassed) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }
    }

    static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras >= 5)
            addon_discount = 10;
        else if (extras >= 3)
            addon_discount = 15;
        else
            addon_discount = 0;

        if (discount > addon_discount)
            addon_discount = discount;

        result = baseprice / 100.0 * (100 - discount) + specialprice
                + extraprice / 100.0 * (100 - addon_discount);

        return result;
    }
}
