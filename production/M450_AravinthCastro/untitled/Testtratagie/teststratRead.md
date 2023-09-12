**Abstrakte Testfälle:**

| Testfall | Beschreibung |
|----------|--------------|
| Testfall 1 | Kaufpreis < 15'000 CHF |
| Testfall 2 | Kaufpreis = 15'000 CHF |
| Testfall 3 | 15'000 CHF < Kaufpreis < 20'000 CHF |
| Testfall 4 | Kaufpreis = 20'000 CHF |
| Testfall 5 | 20'000 CHF < Kaufpreis < 25'000 CHF |
| Testfall 6 | Kaufpreis = 25'000 CHF |
| Testfall 7 | Kaufpreis > 25'000 CHF |

**Konkrete Testfälle:**

| Testfall | Kaufpreis | Erwarteter Rabatt |
|----------|-----------|-------------------|
| Testfall 1 | 10'000 CHF | Kein Rabatt (0%) |
| Testfall 2 | 15'000 CHF | Kein Rabatt (0%) |
| Testfall 3 | 17'500 CHF | 5% Rabatt (875 CHF) |
| Testfall 4 | 20'000 CHF | 5% Rabatt (1'000 CHF) |
| Testfall 5 | 22'500 CHF | 7% Rabatt (1'575 CHF) |
| Testfall 6 | 25'000 CHF | 7% Rabatt (1'750 CHF) |
| Testfall 7 | 30'000 CHF | 8.5% Rabatt (2'550 CHF) |

**Aufgabe 2**

| Testfall | Beschreibung |
|----------|--------------|
| 1        | Anmeldung mit gültigen Anmeldeinformationen |
| 2        | Anmeldung mit ungültigen Anmeldeinformationen |
| 3        | Passwortwiederherstellungsfunktion |
| 4        | Suche nach Fahrzeugen basierend auf Standort und Datum |
| 5        | Auswahl und Buchung eines Fahrzeugs |
| 6        | Preiskalkulation und Gesamtpreisberechnung |
| 7        | Erfolgreiche Zahlungstransaktion |
| 8        | Zahlungsfehler aufgrund ungültiger Informationen |
| 9        | Buchungsverwaltung: Stornierung und Änderung |
| 10       | Kundenserviceanfrage und Antwortzeit |
