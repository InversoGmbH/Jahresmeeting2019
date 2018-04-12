package de.inverso.workshop.annotationen;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class EqualsTest {

    @Test
    void testName() throws Exception {
        PersonWithWrongEquals duck1 = new PersonWithWrongEquals("Dagobert", "Duck");
        PersonWithWrongEquals duck2 = new PersonWithWrongEquals("Dagobert", "Duck");
        assertThat(duck1.equals(duck2)).isTrue();

        // Object otherDuck = duck2;
        // assertThat(duck1.equals(otherDuck)).isTrue();
    }
}
