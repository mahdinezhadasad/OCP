# Projekt 'Words'

Das ist ein Hilfsprojekt mit Daten für weitere Tests/Aufgaben.

## Einbinden

### Das Projekt 'Words' in einem anderen Projekt einbinden

- wenn noch nicht gemacht: das Projekt 'Words' unter Eclipse importieren
- Rechtsklick auf das eigene Projekt -> Properties -> Java Build Path -> Tab 'Projects' -> Schatfläche 'Add..' -> Das Projekt 'Words' auswählen


### jar-Datei in einem anderen Projekt einbinden

- jar-Datei aus den Dateien des Projektes 'Words' erzeugen: Rechtsklick auf das Projekt 'Words' -> Export -> Java/JarFile -> Next -> Daten aus 'src' auswählen -> Finish

###### Variante 1
- jar-Datei im anderen Projekt einbinden (mit dem absolutem Pfad): Rechtsklick auf das eigene Projekt -> Properties -> Java Build Path -> Tab 'Libraries' -> 'Add external Jars...' -> die Jar-Datei auf dem Festplatte finden und auswählen

###### Variante 2
- jar-Datei im anderen Projekt einbinden (mit dem relativen Pfad): im eigenen Projekt Unterverzeichnis 'lib' erzeugen und die jar-Datei dort kopieren -> Rechtsklick auf das eigene Projekt -> Properties -> Java Build Path -> Tab 'Libraries' -> 'Add Jars...' -> die Jar-Datei aus dem Unterverzeichnis 'lib' auswählen

