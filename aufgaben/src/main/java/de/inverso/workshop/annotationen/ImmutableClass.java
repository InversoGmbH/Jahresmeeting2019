package de.inverso.workshop.annotationen;

import javax.annotation.concurrent.Immutable;

/**
 * Diese Klasse ist als Immutable markiert. Spotbugs
 */
@Immutable
public class ImmutableClass {

    private final String someField = "test";

    public String getSomeField() {
        return someField;
    }
}
