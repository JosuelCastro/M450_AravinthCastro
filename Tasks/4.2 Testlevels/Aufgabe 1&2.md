## Aufgabe 1

### `Calculator.java` (im main package)
```java
package main;

public class Calculator {

    public double add(double summand1, double summand2) {
        return summand1 + summand2;
    }

    public double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public double multiply(double factor1, double factor2) {
        return factor1 * factor2;
    }

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return dividend / divisor;
    }
}
```

### `CalculatorTest.java` (im test package)
```java
package test;

import main.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        Assertions.assertEquals(1, calculator.subtract(4, 3));
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        Assertions.assertEquals(4, calculator.divide(8, 2));
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}
```

**Maven-Befehl**
```bash
mvn test
```

---

## Aufgabe 2 - JUnit Zusammenfassung

### JUnit Features

#### Annotations:
- **@Test**: Markiert eine Methode als Testmethode.
- **@BeforeEach**: Wird vor jedem Test ausgeführt.
- **@AfterEach**: Wird nach jedem Test ausgeführt.
- **@BeforeAll**: Wird einmal vor allen Tests ausgeführt.
- **@AfterAll**: Wird einmal nach allen Tests ausgeführt.
- **@Disabled**: Überspringt den Test.

#### Assertions:
- **assertEquals()**: Prüft, ob zwei Werte gleich sind.
- **assertTrue() / assertFalse()**: Prüft, ob ein Wert true bzw. false ist.

## Aufgabe 3  Dokumentation: Bank-Software

## 1. Hauptkomponenten

### 1.1. Bank
- Funktionen:
  - `Bank()`: Konstruktor
  - `createAccount()`: Konto erstellen
  - `deposit()`: Geld einzahlen
  - `getBalance()`: Kontostand abrufen
  - `print()`: Drucken
  - `withdraw()`: Geld abheben

- Beziehungen:
  - Importiert und instanziiert `Account`
  - Hält einen Schlüssel (`key`) für `Account`
  - Kann 0 bis viele `Account`-Objekte enthalten

### 1.2. Account
- Attribute:
  - `balance`: Kontostand (long)
  - `id`: Konto-ID (String)

- Funktionen:
  - `canTransact()`: Überprüft, ob Transaktion möglich ist
  - `deposit()`: Geld einzahlen
  - `print()`: Drucken
  - `withdraw()`: Geld abheben

- Beziehungen:
  - Kann 0 bis viele `Booking`-Objekte enthalten

### 1.3. Booking
- Attribute:
  - `amount`: Betrag (long)
  - `date`: Buchungsdatum

- Funktionen:
  - `Booking()`: Konstruktor

### 1.4. BankUtils
- Attribute:
  - `AMOUNT_FORMAT`: Format für Beträge (DecimalFormat)
  - `TWO_DIGIT_FORMAT`: Zwei-Stellen-Format (DecimalFormat)

- Funktionen:
  - `formatAmount()`: Betrag formatieren
  - `formatBankDate()`: Bankdatum formatieren

## 2. Spezielle Kontotypen

### 2.1. SavingsAccount
- Erbt von `Account`
- Funktionen:
  - `SavingsAccount()`: Konstruktor
  - `withdraw()`: Geld abheben

### 2.2. SalaryAccount
- Erbt von `Account`
- Funktionen:
  - `SalaryAccount()`: Konstruktor
  - `print()`: Drucken
  - `withdraw()`: Geld abheben

### 2.3. PromoYouthSavingsAccount
- Erbt von `SavingsAccount`
- Funktionen:
  - `PromoYouthSavingsAccount()`: Konstruktor
  - `deposit()`: Geld einzahlen

## 3. Zusammenhänge
- Die Klasse `Bank` dient als zentrale Anlaufstelle und verwaltet verschiedene Konten.
- Es gibt unterschiedliche Kontotypen, die von der Hauptklasse `Account` erben und spezifische Funktionen implementieren.
- Jede Konto-Transaktion erzeugt ein `Booking`-Objekt, das den Betrag und das Datum der Transaktion speichert.
- Die `BankUtils`-Klasse bietet Hilfsfunktionen für das Formatieren von Beträgen und Daten.