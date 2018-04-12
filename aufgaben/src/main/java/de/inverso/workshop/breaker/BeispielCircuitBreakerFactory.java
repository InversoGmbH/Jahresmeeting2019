package de.inverso.workshop.breaker;

import java.util.function.Supplier;

/** Beispielimplementierung einer {@link CircuitBreakerFactory} */
public class BeispielCircuitBreakerFactory implements CircuitBreakerFactory {

    @Override
    public Supplier<String> createCircuitBreakerFor(Supplier<String> supplier, int maxNumberOfFailures) {
        // TODO implementieren
        throw new UnsupportedOperationException();
    }

}
