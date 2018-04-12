package de.inverso.workshop.annotationen;

import java.util.Objects;

public class PersonWithWrongEquals {

    private final String firstName;
    private final String lastName;

    public PersonWithWrongEquals(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean equals(PersonWithWrongEquals person) {
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }
}
