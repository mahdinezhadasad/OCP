###### Achtung! Unterrichtsfreie Tage: 31.10, 01.11, 20.11

## Wissensvermittlung
- 08:45 - 09:30 Uhr
- 09:45 - 11:15 Uhr
- 11:30 - 13:00 Uhr

## Selbstlernen/Sprechstunden
- 13:30 - 15:00 Uhr
- 15:15 - 16:45 Uhr

> Bitte immer wieder eigene Fehlzeiten überprüfen

## Aufgaben

#### 08.10

- Interface Set
- Klasse HashSet
- Diagramme/HashSet.pdf

- Klasse TreeSet (noch keine speziellen Methoden auswendig lernen)

- Aufgaben/Set - TextStatistics.md
- Optional: Aufgaben/Set - TreeSet - Integer.md


#### 07.10
- Project 'Collections'
- Wdh. List-API

- List/subList
- Arrays/asList
- Warum ist für contains/remove/indexOf wichtig, dass die Klasse der List-Elemente die equals überschreibt?

- Aufgaben/List - Iterable.md

#### 04.10
- Projekt 'Functional'
- Optional-API

- Projekt 'Generics'
- Aufgaben/Generics - Garage.md

- Project 'Collections'
- Wdh. Iterable, Collection, List
- Wdh. List-API
- Diagramme/ArrayList vs LinkedList.pdf

- Alternativ die Umlet-Diagramme betrachten/erstellen:
    - Stand-alone-Umlet: https://umlet.com/changes.htm 
    - Online-Version: https://www.umletino.com/


#### 02.10
- Projekt 'Functional'
- Comparator-API

- Über die Klasse 'Optional' lesen: https://www.oracle.com/technical-resources/articles/java/java8-optional.html

- Optionale Aufgabe: Klasse Auto hat Attribute hersteller, modell und baujahr. Erzeugen Sie ein Array mit Autos und sortieren Sie das Array unterschiedlich. Verwenden Sie für die Vergleiche beim Sortieren unterschiedliche Comparatoren.


#### 01.10
- Projekt 'Functional'
- Methodenreferenzen (4 Varianten)

- Aufgaben/BiFunction - MethodReference.md

#### 30.09
- Projekt 'Functional'
- Predicate, Supplier, Consumer, Function
- Bi-Interfaces
- UnaryOperator/BinaryOperator

- Aufgaben/Consumer - PutIntegers.md
- Aufgaben/Lambdas - erweitert.md

#### 27.09
- Projekt 'InnerClasses'
- anonyme Klassen mit Lambdas vergleichen

- Projekt 'Functional'
- Package 'func'
- Funktionale Interfaces
- Lambdas

- Optional/Nested - Comparator.md

#### 26.09
- Projekt 'InnerClasses'

- lokale Klassen

- kann eine lokale Klasse in ihren Methoden auf die lokalen Variablen der umschliessenden Methode zugreifen?

- anonyme Klassen

- Aufgaben/Nested - Predicate - Personen.md

- wdh. statische/nichtstatische innere Klassen

#### 25.09
- Projekt 'Exceptions'
- Package 'errors'
- Assertions

- Projekt 'InnerClasses'
- statische und nichtstatische innere Klassen

- Aufgaben/Nested - Auto.md
- Optional. Aufgaben/Nested - Gebäude.md


#### 24.09
- Projekt 'Exceptions'

- Package 'exceptions'
- rethrow
- try-with-resources

- Package 'errors'
- StackOverflowError erkennen
- ExceptionInInitializerError erkennen

- Optional: Aufgaben/Exceptions - ArrayListPositive.md

#### 23.09

- Eclipse-Plugin 'Umlet' installieren:
    - Help/Eclipse Marketplace...
    
- Alternativ die Umlet-Diagramme betrachten/erstellen:
    - Stand-alone-Umlet: https://umlet.com/changes.htm 
    - Online-Version: https://www.umletino.com/

- Projekt 'Exceptions'

- Wdh. try/catch/finally
- Multicatch (Regeln merken!)

- Wdh. Checked Exceptions (auch beim Überschreiben)
- Wdh. Klassendiagramm zu Throwable/Exception/Error

#### 19.09
- Projekt 'ClassDesign'
- Packages 'wdh.*'

- Wdh. StringPool
- Wdh. Wrapper-Klassen
    - Autoboxing/Autounboxing
    - Konstantenpools für Byte, Short, Integer und Long

- Wdh. Varargs-Methoden
- Wdh. Überladen. Richtige überladene Methode finden.

- Wdh. Interfaces 'Comparable' und 'Comparator'.

- Aufgaben/Interfaces - Comparable - Comparator - OS.md

#### 18.09
- Singleton (Realisierungen kennen!)
- Fabrikmethoden (Aufrufe nachvollziehn können)
- Builder (verkettete Methoden-Aufrufe nachvollziehn können)
- Immutable Objects (Wissen, dass String, Wrapper-Klassen und Date&Time-Klassen immutable sind)

- Optional: OCA-Themen nachschlagen: https://bitbucket.org/ccjavad/oca_412631/src/main/

- Optional: Entwurfsmuster
    - https://refactoring.guru/design-patterns/java
    - http://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries
    - https://github.com/iluwatar/java-design-patterns

- Wdh. Diagramme/String-Pool.pdf


#### 17.09

- Eclipse herunterladen und einrichten

- Howto/Eclipse.md
- Howto/Git.md

- Themenliste im Comcave-Portal kennenlernen
- OCP-Buch kennenlernen

## Allgemein

- Kurs-Repo: https://bitbucket.org/ccjavad/ocp_412641/src/main/
- Kurs-Repo-Url zum Klonen: https://bitbucket.org/ccjavad/ocp_412641.git

###### Buch 1: Insel-Buch 
> Im Comcave-Portal oder https://openbook.rheinwerk-verlag.de/javainsel/

###### Buch 2: OCP-Buch
> Kommt per Post. Pdf-Datei unter Teams/Dateien.
> Beachten Sie Hinweise im Appendix, um den Zugang zu hub.totalsem.com/mheclaim mit dem Fragenkatalog zu bekommen

###### Eigenes Projekt 
> Das Projekt ist optional. 
> Empfehlenswert ist es parallel zu dem Kurs zu machen.

Mögliche Techniken dabei:

    - mit Umit-Tests
    - UML
    - Project Builder (Maven, Gradle)
    - Git
	- ...

###### Comcave-Klausur: 02.12.2024
> Hilfsmittel: alle, Dauer: 2 Stunden, Multiple-Choice

###### Oracle-Prüfung: 19.12.2024 (ein möglicher Termin)
> Beachten Sie die Datei 'Prüfungsnameldung.pdf' unter Teams/Dateien


