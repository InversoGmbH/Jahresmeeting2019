package de.inverso.ducksimulator.bad.model;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author fabian
 * on 08.05.19.
 */
public abstract class Duck {
    // The name of this Logger will be "org.apache.logging.Parent"
    protected static final Logger LOG = LogManager.getLogger();

    public void quack() {
        LOG.info("quack quak");
    }

    public void swim() {
        LOG.info("Swim around");
    }

    public void fly() {
        LOG.info("Fly around");
    }

    public abstract void display();
}
