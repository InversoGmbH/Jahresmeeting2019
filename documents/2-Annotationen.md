# Best Practices für statische Analyse und Dokumentation #

 * FindBugs bzw. Sonar verwenden

## Annotationen ##
 * Annotationen `@Nonnull` oder `@Nullable` für Parameter und Rückgabewerte verwenden
 * Annotationen `@Immutable`, `@Threadsafe` oder `@NonThreadSafe` für Klassen verwenden

## Beispiel Produktionsfehler SimpleDateFormat ##

 * Klasse `SimpleDateFormat` eignet sich eigentlich sehr gut dazu als globale
   Variable zu speichern aber:

    Synchronization
    
    Date formats are not synchronized. It is recommended to create separate
    format instances for each thread. If multiple threads access a format
    concurrently, it must be synchronized externally.
     
