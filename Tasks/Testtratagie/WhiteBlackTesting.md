# Testfälle für das M450 Testing Module

## Black-Box Testfälle

### Testfall 1: Geld einzahlen
**Beschreibung:** Als Benutzer möchte ich Geld auf mein Konto einzahlen können.

**Schritte:**
1. Starte die Anwendung.
2. Wähle ein bestehendes Konto aus.
3. Wähle die Option "Einzahlen".
4. Gib den Betrag ein, den du einzahlen möchtest.
5. Überprüfe, ob der Kontostand aktualisiert wurde und der eingezahlte Betrag hinzugefügt wurde.

**Erwartetes Ergebnis:** Der Kontostand sollte um den eingezahlten Betrag erhöht sein.

### Testfall 2: Geld abheben
**Beschreibung:** Als Benutzer möchte ich Geld von meinem Konto abheben können.

**Schritte:**
1. Starte die Anwendung.
2. Wähle ein bestehendes Konto aus.
3. Wähle die Option "Abheben".
4. Gib den Betrag ein, den du abheben möchtest.
5. Überprüfe, ob der Kontostand aktualisiert wurde und der abgehobene Betrag abgezogen wurde.

**Erwartetes Ergebnis:** Der Kontostand sollte um den abgehobenen Betrag reduziert sein.

### Testfall 3: Kontostand abfragen
**Beschreibung:** Als Benutzer möchte ich den aktuellen Kontostand meines Kontos abfragen können.

**Schritte:**
1. Starte die Anwendung.
2. Wähle ein bestehendes Konto aus.
3. Wähle die Option "Kontostand abfragen".

**Erwartetes Ergebnis:** Die Anwendung sollte den aktuellen Kontostand anzeigen.

### Testfall 4: Konto erstellen
**Beschreibung:** Als Benutzer möchte ich ein neues Konto erstellen können.

**Schritte:**
1. Starte die Anwendung.
2. Wähle die Option "Konto erstellen".
3. Gib deinen Nachnamen ein.
4. Wähle eine Währung (z.B., CHF, EUR, USD).
5. Überprüfe, ob das Konto erfolgreich erstellt wurde.

**Erwartetes Ergebnis:** Ein neues Konto sollte erstellt und der Kontostand auf 0.0 in der ausgewählten Währung gesetzt werden.

### Testfall 5: Konto löschen
**Beschreibung:** Als Benutzer möchte ich ein Konto löschen können.

**Schritte:**
1. Starte die Anwendung.
2. Wähle ein bestehendes Konto aus.
3. Wähle die Option "Konto löschen".
4. Bestätige die Löschung, wenn dazu aufgefordert.

**Erwartetes Ergebnis:** Das ausgewählte Konto sollte erfolgreich gelöscht werden.

## White-Box Testfälle

### Testfall 6: Test der `deposit`-Methode
**Beschreibung:** Testen Sie die `deposit`-Methode der `Account`-Klasse, um sicherzustellen, dass sie den eingezahlten Betrag korrekt zum Kontostand hinzufügt.

**Schritte:**
1. Erstellen Sie ein neues Konto mit einem anfänglichen Guthaben.
2. Verwenden Sie die `deposit`-Methode, um einen Betrag einzuzahlen.
3. Überprüfen Sie, ob der Kontostand korrekt aktualisiert wurde.

**Erwartetes Ergebnis:** Der Kontostand sollte um den eingezahlten Betrag erhöht sein.

### Testfall 7: Test der `withdraw`-Methode
**Beschreibung:** Testen Sie die `withdraw`-Methode der `Account`-Klasse, um sicherzustellen, dass sie den abgehobenen Betrag korrekt vom Kontostand abzieht.

**Schritte:**
1. Erstellen Sie ein neues Konto mit ausreichendem Guthaben.
2. Verwenden Sie die `withdraw`-Methode, um einen Betrag abzuheben.
3. Überprüfen Sie, ob der Kontostand korrekt aktualisiert wurde.

**Erwartetes Ergebnis:** Der Kontostand sollte um den abgehobenen Betrag reduziert sein.

### Testfall 8: Test der `createAccount`-Methode
**Beschreibung:** Testen Sie die `createAccount`-Methode der `Bank`-Klasse, um sicherzustellen, dass sie ein neues Konto erstellt.

**Schritte:**
1. Erstellen Sie ein neues Konto mit zufälligen Daten.
2. Überprüfen Sie, ob das Konto erfolgreich erstellt wurde.

**Erwartetes Ergebnis:** Ein neues Konto sollte erfolgreich erstellt und der Kontostand auf 0.0 in der ausgewählten Währung gesetzt werden.

### Testfall 9: Test der `deleteAccount`-Methode
**Beschreibung:** Testen Sie die `deleteAccount`-Methode der `Bank`-Klasse, um sicherzustellen, dass sie ein Konto erfolgreich löscht.

**Schritte:**
1. Erstellen Sie ein neues Konto.
2. Verwenden Sie die `deleteAccount`-Methode, um das Konto zu löschen.
3. Überprüfen Sie, ob das Konto erfolgreich gelöscht wurde.

**Erwartetes Ergebnis:** Das ausgewählte Konto sollte erfolgreich gelöscht werden.

## Verbesserungsvorschläge und Best Practices

1. **Kommentierung:** Fügen Sie Kommentare hinzu, um den Code besser zu dokumentieren und zu erklären.

2. **Try-Catch-Blöcke optimieren:** Verbessern Sie die Verwendung von Try-Catch-Blöcken, um spezifische Ausnahmen zu behandeln und aussagekräftige Fehlermeldungen anzuzeigen.

3. **Exception-Klassen:** Erstellen Sie benutzerdefinierte Exception-Klassen, um spezifische Fehlerfälle besser zu behandeln und Fehlermeldungen zu vereinfachen.

4. **Tests schreiben:** Implementieren Sie Unit-Tests für die Methoden, um sicherzustellen, dass sie wie erwartet funktionieren.

5. **Validierung und Input-Überprüfung:** Fügen Sie zusätzliche Validierungen und Überprüfungen für Benutzereingaben hinzu, um Fehler und ungültige Eingaben zu verhindern.

6. **Verwendung von Enums:** Erwägen Sie die Verwendung von Enums für Währungen und andere Konstanten, um den Code wartbarer zu machen.

7. **Refactoring:** Prüfen Sie den Code auf Möglichkeiten zur Verbesserung der Lesbarkeit und Effizienz, z.B. durch Aufteilen

 langer Methoden in kleinere Funktionen.

8. **Logging:** Implementieren Sie Logging, um Fehler und Aktionen im Programmverlauf zu protokollieren.

9. **Dokumentation:** Fügen Sie eine detaillierte Dokumentation hinzu, die beschreibt, wie das Programm funktioniert und wie es verwendet werden kann.

Diese Verbesserungen und Best Practices können dazu beitragen, den Code robuster und wartbarer zu gestalten und die Qualität des Testing-Moduls zu erhöhen.