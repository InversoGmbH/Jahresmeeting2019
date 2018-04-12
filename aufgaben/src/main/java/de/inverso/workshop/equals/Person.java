package de.inverso.workshop.equals;

import java.util.Objects;

public class Person {
    private final String firstName = "Dagobert";
    private final String lastName = "Duck";

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        // field comparison
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
