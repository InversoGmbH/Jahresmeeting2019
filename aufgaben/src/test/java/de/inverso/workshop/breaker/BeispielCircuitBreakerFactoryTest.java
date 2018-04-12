package de.inverso.workshop.breaker;

public class BeispielCircuitBreakerFactoryTest extends CircuitBreakerFactoryTest {

    @Override
    protected CircuitBreakerFactory createFactory() {
        return new BeispielCircuitBreakerFactory();
    }
}
