package de.inverso.ducksimulator.bad.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author fabian
 * on 08.05.19.
 */
public class DuckTest {
    protected static final Logger LOG = LogManager.getLogger();

    @Test
    void duckTester() {
        var duckList = List.of(new MallardDuck(), new RedheadDuck(), new RubberDuck());
        duckList.forEach( duck -> {
            duck.display();
            duck.swim();
            duck.fly();
            duck.quack();
            LOG.info("-------------------------------");
        } );
    }

}
