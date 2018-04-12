# Ausnahmebehandlung

* wichtiger Bestandteil der Softwarearchitektur
* der Begriff ausnahme ist schwammig
* Protokollierung, Monitoring bis Kathastropenalarm ist alles möglich
* Beispiel: InterruptException kommt häufig vor und ist gewünscht
* auch hier gibt es Antipatterns

## Antipattern: Nur einen Exceptiontyp verwenden

* alles ist eine Exception
* führt dazu, dass Meldungen sehr ähnlich aussehen und nur durch
* Informationen können nur über die Meldungen im Stacktrace gefunden werden

## Antipattern: Exceptions zur flussteuerung verwenden

* damit lassen sich ähnliche Schweinerein wie mit goto anstellen
* kann den gesamten Programmablauf in nicht nachvollziehbaren zustand versetzen

## Antipattern: catch Throwable

* `Throwable` ist das Interface von dem alle Fehlerobjekte ableiten
* damit erwischt man allerdings auch `Error`
* Sind vom System generiert und erfordern meist eingriff durch den Betrieb von außen
* das umleiten der meldung in andere logdaten oder verwerfen der Meldung ist daher Kontraproduktiv

## Wie macht man es jetzt Richtig(er)?

* Exceptions so früh wie möglich fangen
* Fehlerbehandlungsstrategie:
    1. Protokollieren und weitermachen -> Fehler nicht so schlimm
    1. Ressourcen freigeben und Protokollieren -> relevant für Wartungsentwickler
    2. Anwarten und später neu versuchen -> z.B. Verbindungsabbrüchen 
    3. Schadenbegrenzung durchführen und Protokollieren
* Eigene Exception Klasse schreiben
    * Aufwand gering
    * das bloße Auftreten der Exception soll aussagekräftige Hinweise darauf bieten, was vorgefallen ist
    * beispiel: `IllegalArgumentException`, `ArrayIndexOutOfBoundException`