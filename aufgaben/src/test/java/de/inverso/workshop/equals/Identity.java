package de.inverso.workshop.equals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class Identity {

    @Test
    @SuppressFBWarnings({ "DM_STRING_CTOR", "ES_COMPARING_STRINGS_WITH_EQ" })
    void identity_vs_equals() throws Exception {
        String some = "some string";
        String other = some;
        assertTrue(some == other);

        some = new String("some string");
        other = new String("some string");
        assertFalse(some == other);

        assertTrue(some.equals(other));
        assertTrue(some.hashCode() == other.hashCode());
    }
}
