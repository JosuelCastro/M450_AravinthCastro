**Aufgabe 1**
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

| Testfall | Beschreibung | Test-Schritte | Erwartetes Ergebnis |
|----------|--------------|---------------|---------------------|
| 1        | Anmeldung mit gültigen Anmeldeinformationen | 1. Öffnen Sie die Anmeldeseite.<br>2. Geben Sie einen gültigen Benutzernamen und ein gültiges Passwort ein.<br>3. Klicken Sie auf "Anmelden". | Der Benutzer wird erfolgreich angemeldet und zur Startseite weitergeleitet. |
| 2        | Anmeldung mit ungültigen Anmeldeinformationen | 1. Öffnen Sie die Anmeldeseite.<br>2. Geben Sie einen ungültigen Benutzernamen oder ein ungültiges Passwort ein.<br>3. Klicken Sie auf "Anmelden". | Eine Fehlermeldung wird angezeigt, die darauf hinweist, dass die Anmeldeinformationen ungültig sind. |
| 3        | Passwortwiederherstellungsfunktion | 1. Öffnen Sie die Anmeldeseite.<br>2. Klicken Sie auf "Passwort vergessen?".<br>3. Geben Sie eine registrierte E-Mail-Adresse ein.<br>4. Klicken Sie auf "Senden". | Eine Bestätigungsnachricht wird angezeigt und eine E-Mail zur Passwortwiederherstellung wird an die angegebene Adresse gesendet. |
| 4        | Suche nach Fahrzeugen basierend auf Standort und Datum | 1. Öffnen Sie die Suchseite.<br>2. Wählen Sie einen Standort und ein Datum aus.<br>3. Klicken Sie auf "Suchen". | Eine Liste von verfügbaren Fahrzeugen basierend auf dem ausgewählten Standort und Datum wird angezeigt. |
| 5        | Auswahl und Buchung eines Fahrzeugs | 1. Führen Sie Testfall 4 aus.<br>2. Wählen Sie ein Fahrzeug aus der Liste aus.<br>3. Klicken Sie auf "Buchen".<br>4. Füllen Sie die erforderlichen Buchungsdetails aus.<br>5. Klicken Sie auf "Bestätigen". | Eine Buchungsbestätigung wird angezeigt und eine Bestätigungs-E-Mail wird an den Benutzer gesendet. |
| 6        | Preiskalkulation und Gesamtpreisberechnung | 1. Wählen Sie ein Fahrzeug und ein Buchungsdatum aus.<br>2. Überprüfen Sie die Preisdetails auf der Buchungsseite. | Der Gesamtpreis wird korrekt berechnet und angezeigt, einschließlich aller Gebühren und Steuern. |
| 7        | Erfolgreiche Zahlungstransaktion | 1. Führen Sie Testfall 5 aus.<br>2. Geben Sie gültige Zahlungsinformationen ein.<br>3. Klicken Sie auf "Zahlen". | Die Zahlung wird erfolgreich verarbeitet und eine Bestätigungsnachricht wird angezeigt. |
| 8        | Zahlungsfehler aufgrund ungültiger Informationen | 1. Führen Sie Testfall 5 aus.<br>2. Geben Sie ungültige Zahlungsinformationen ein.<br>3. Klicken Sie auf "Zahlen". | Eine Fehlermeldung wird angezeigt, die darauf hinweist, dass die Zahlungsinformationen ungültig sind. |
| 9        | Buchungsverwaltung: Stornierung und Änderung | 1. Navigieren Sie zur Seite "Meine Buchungen".<br>2. Wählen Sie eine bestehende Buchung aus.<br>3. Klicken Sie auf "Stornieren" oder "Ändern".<br>4. Bestätigen Sie die Aktion. | Die Buchung wird erfolgreich storniert oder geändert und eine entsprechende Bestätigungs- oder Stornierungsnachricht wird angezeigt. |
| 10       | Kundenserviceanfrage und Antwortzeit | 1. Navigieren Sie zur Seite "Kundenservice".<br>2. Stellen Sie eine Anfrage.<br>3. Überprüfen Sie die Antwortzeit. | Die Anfrage wird erfolgreich gesendet und eine Antwort wird innerhalb der erwarteten Zeit erhalten. |
