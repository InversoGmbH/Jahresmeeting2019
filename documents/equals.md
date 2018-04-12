# Gleichheit von Objekten #

* Fundamentaler Aspekt einer Java-Klasse
    * wird von der `equals`-Methode bestimmt
* `equals()` und `hashCode` müssen immer zusammen implementiert werden (später mehr zu `hashCode`)
    
## Anforderungen an Equals ##

Eine Equals-Implementierung muss folgende Eigenschaften erfüllen:
* _Reflexiv_, bedeutet, dass die Methode `true` zurückgeben muss, wenn überprüft
  wird, ob eine Instanz zu sich selbst identisch ist.
* _Symmetrie_, bedeutet, dass wenn `x` gleich `y` ist, auch `y` gleich `x` ist.
* _Transitiv_ bedeutet, dass wenn `x` gleich `y` und `y` gleich `z` ist, dass
  auch `x` und `z` gleich sein müssen.
* Außerdem muss das Ergebnis konsistent sein, also mehrere Aufrufe müssen immer
  dasselbe Ergebnis zurückgeben, solange nicht eines der beiden Objekte in der
  Zwischenzeit modifiziert wurde.
* Ein Vergleich mit null muss immer `false` zurückgeben.

## Signatur ##
    boolean equals(Object o)

## HashCode ##

Auch `hashCode` fordert, dass mehrere Aufrufe der Methode immer dasselbe
Ergebnis zurückgeben, solange die Instanz in der Zwischenzeit nicht geändert
wurde. Zudem muss das Ergebnis von Aufrufen auf gleichen Objekten identisch
sein. Für unterschiedliche Objekte gibt es keine Vorgabe.
