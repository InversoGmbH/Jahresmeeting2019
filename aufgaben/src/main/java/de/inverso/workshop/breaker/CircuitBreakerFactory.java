package de.inverso.workshop.breaker;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

public interface CircuitBreakerFactory {

    /**
     * Erzeugt einen Circuit-Breaker der nach der angegebenen Anzahl von Fehlern nur
     * noch eine {@link IllegalStateException} wirft und den angegebenen Supplier
     * nicht mehr aufruft.
     * <p>
     * Solange die maximale Anzahl fehler noch nicht erreicht ist wird das ergebnis
     * des übergebenen Suppliers zurückgegeben.
     * <p>
     * Der Supplier wirft bei Fehlern eine {@link RuntimeException}.
     *
     * @param supplier
     *            Supplier für einen String der mit einer {@link RuntimeException}
     *            fehlschlagen kann, niemals null
     * @return Ergebnis des Suppliers, niemals null
     * @throws IllegalStateException
     *             wenn die maximale Anzahl Fehler erreicht wurde
     */
    @Nonnull
    Supplier<String> createCircuitBreakerFor(@Nonnull Supplier<String> supplier, int maxNumberOfFailures);

}
