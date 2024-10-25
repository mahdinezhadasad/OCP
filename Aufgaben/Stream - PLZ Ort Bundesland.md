Unter Dateien in Teams finden Sie die Datei „plz_ort.csv“, die alle deutschen Orte mit Postleitzahl,
Bundesland und OSM-ID (eindeutige ID für jeden Ort) enthält.

Für beide Miniprojekte binden Sie diese Datei in Ihre Anwendung ein und erzeugen Sie eine
String-Stream zur weiteren Verarbeitung.

Miniprojekt 1:

Sie haben die Aufgabe, statistische Auswertungen für die Orte, Bundesländer und Postleitzahlen
in Deutschland durchzuführen.

1. Geben Sie alle Einträge der Datei untereinander auf der Konsole aus.
2. Geben Sie den Eintrag für Ihre Postleitzahl auf der Konsole aus.
3. Geben Sie den Eintrag für Ihre Postleitzahl auf der Konsole ohne die OSM-ID aus
4. Geben Sie für den Eintrag für Ihre Postleitzahl nur den Ort aus.

Die Einträge sollen zur komfortablen Verarbeitung in einer Liste mit Ort-Objekten
zwischengespeichert werden. Dazu bauen Sie die Klasse Ort mit den Variablen Ort, Postleitzahl
und Bundesland und erzeugen Sie aus dem Stream eine List. Benutzen Sie im Folgenden einen
Stream der List, um die folgenden Auswertungen durchzuführen.

1. Geben Sie alle Ort-Objekte sortiert nach Postleitzahl aus.
2. Geben Sie das Ort-Objekt mit der größten Postleitzahl aus.
3. Geben Sie eine Komma-separierte Liste mit allen Bundesländern (ohne Duplikate) aus.
4. Ermitteln Sie, welcher Ort die meisten Postleitzahlen (also Ort-Objekte) in Deutschland hat.
5. Erzeugen Sie eine Gruppierung nach Bundesländern mit der Anzahl der Ort-Objekte pro Bundesland

Miniprojekt 2:

Ihre Aufgabe ist es eine Anwendung zu programmieren, die bei Eingabe einer fünfstelligen
Postleitzahl den Ort anzeigt.

Eine Erweiterung der Anwendung wäre, dass man bei Eingabe des Orts alle verfügbaren
Postleitzahlen anzeigt (erhöhte Schwierigkeit).

Es soll sich um eine Konsolenanwendung handeln, die Eingabe wird mit einem Scanner realisiert.

Wählen Sie einen geeigneten Datentyp für die Postleitzahl und fangen sie alle möglichen
Exceptions ab.

Als Erweiterung können Sie eine GUI-Anwendung bauen, die die Anforderung abbildet (erhöhte
Schwierigkeit).