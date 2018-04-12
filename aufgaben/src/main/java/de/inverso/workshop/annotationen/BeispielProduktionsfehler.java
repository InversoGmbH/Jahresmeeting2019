package de.inverso.workshop.annotationen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Falsche Verwendung von {@link SimpleDateFormat}.
 * <p>
 * Hat vor ein paar Wochen zu einem Major Incident geführt!
 */
public class BeispielProduktionsfehler {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("ddd.mmm.yyyy HH:mm:ss.SSS Z");

    public static String getDate(Date date) {
        return formatter.format(date);
    }

    public static void main(String[] args) {
        var threads = IntStream.range(0, 100) //
                .mapToObj(i -> new Thread(() -> run())) //
                .collect(Collectors.toUnmodifiableList());
        threads.forEach(Thread::start);
        threads.forEach(BeispielProduktionsfehler::join);
    }

    private static void run() {
        final var date = new Date();
        final var expected = getDate(date);
        IntStream.range(0, 1_000).forEach(i -> checkEqual(expected, getDate(date)));
    }

    private static void checkEqual(String a, String b) {
        if (!a.equals(b)) {
            System.err.println(String.format("Fehler: %s != %s", a, b));
        }

    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
