# Dokumentation: Bank-Software

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