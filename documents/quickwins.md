# Quickwins

## Utility Klassen

* Nutzt Utility Klassen!
* Beinhalten Konstanten und Methoden die allgemein nützlich sind
* Alle Methoden sind **static**
* Die Klasse ist final und besitzt einen **private** Konstructor
* es wird keine Instanz der Klasse benötigt
* vermeidet dadurch doppelten code
* Beispiel im JDK: Klasse `Math`, `Objects`, `Collectors`, `Collections`, `Arrays`, `Files`, `Paths`
* sobald ein State oder Vererbung erforderlich ist sollte man auf Objekte umsteigen

### Antipattern: SenselessUtility

* suggeriert einen mehrwert, kann stattdessen jedoch zu Raise Conditions und Performance  Verschlechterungen führen
* Beispiel: `TypecastUtility`
* suggeriert gesicherten cast von einen Datentyp auf einen anderen

#### normaler cast in Java: 
```java
double a = 0.0;
int b = (int) a;
```
Der Compiler wertet diesen Ausdruck aus und kann Warnungen produzieren, falls erkennbar.
Die Runtime wirft eine ClassCastExeption bei Problemen.

#### TypeCastUtility
```java
double a = 0.0;
TypeCastUtility.cast(a,int.class);
```
Nur die Runtime kann diesen Ausruck auswerten, Optimierungen des Compilers entfallen.

Der Normale Cast erreicht sein Ziel in einer Zeile, das TypeCastUtility benötigt dafür ca. 2000

# Benutzt ein Versionskontrollsystem

* es gibt immernoch abteilungen, die ausschließlich mit Netzlaufwerken und händischer Versionspflege arbeiten
* haltet die commits so klein wie möglich, erleichtert das entfernen eines einzelnen commits falls erforderlich
* keine binarys im VCS, es gibt ausnahmen, ihr solltet aber wissen, warum ihr eine seit
* benutzt einen review Prozess, hilft beim wissenstransfer und deckt Fehler auf
