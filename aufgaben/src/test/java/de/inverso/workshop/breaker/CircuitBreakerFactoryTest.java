package de.inverso.workshop.breaker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.Random.class)
public abstract class CircuitBreakerFactoryTest {

    private final CircuitBreakerFactory factory = createFactory();
    @SuppressWarnings("unchecked")
    private final Supplier<String> supplier = mock(Supplier.class);

    @Nonnull
    protected abstract CircuitBreakerFactory createFactory();

    @Nonnull
    public CircuitBreakerFactory factory() {
        return factory;
    }

    @Test
    void breaker_liefert_Ergebnis_des_Suppliers() throws Exception {
        var expected = "Test";
        var breaker = factory().createCircuitBreakerFor(() -> "Test", 1);
        assertThat(breaker.get()).isSameAs(expected);
    }

    @Test
    void breaker_gibt_Exception_weiter() throws Exception {
        final var exception = new RuntimeException();
        var breaker = factory().createCircuitBreakerFor(supply(exception), 10);
        assertThatThrownBy(() -> breaker.get()).isSameAs(exception);
    }

    @Test
    void breaker_ruft_supplier_nach_zuvielen_fehlern_nicht_mehr_auf() throws Exception {
        final var exception = new RuntimeException();
        when(supplier.get()).thenThrow(exception);
        var breaker = factory().createCircuitBreakerFor(supplier, 1);
        assertThatThrownBy(() -> breaker.get()).isSameAs(exception);
        assertThatIllegalStateException().isThrownBy(() -> breaker.get());
        assertThatIllegalStateException().isThrownBy(() -> breaker.get());
        verify(supplier).get();
        verifyNoMoreInteractions(supplier);
    }

    @Test
    void normales_Ergebnis_und_Exceptions() throws Exception {
        final var exception = new RuntimeException();
        when(supplier.get()) //
                .thenReturn("Test") //
                .thenThrow(exception) //
                .thenReturn("Test2") //
                .thenReturn("Test3") //
                .thenThrow(exception);
        var breaker = factory().createCircuitBreakerFor(supplier, 3);
        assertThat(breaker.get()).isEqualTo("Test");
        assertThatThrownBy(() -> breaker.get()).isSameAs(exception);
        assertThat(breaker.get()).isEqualTo("Test2");
        assertThat(breaker.get()).isEqualTo("Test3");
        assertThatThrownBy(() -> breaker.get()).isSameAs(exception);
        assertThatThrownBy(() -> breaker.get()).isSameAs(exception);
        assertThatIllegalStateException().isThrownBy(() -> breaker.get());
        assertThatIllegalStateException().isThrownBy(() -> breaker.get());
    }

    @Nonnull
    Supplier<String> supply(RuntimeException exception) {
        return () -> {
            throw exception;
        };
    }
}
