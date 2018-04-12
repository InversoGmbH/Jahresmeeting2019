package de.inverso.ducksimulator.bad.model;

/**
 * @author fabian
 * on 08.05.19.
 */
public class RubberDuck extends Duck {

    @Override
    public void quack() {
        LOG.info("quietsch");
    }

    @Override
    public void display() {
        LOG.info("I am a Rubber Duck");
    }
}
