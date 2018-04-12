package de.inverso.workshop.booleanreturn;

import javax.annotation.Nullable;

public class Ente {

    private String name;
    private int anzahlQuacks = 0;
    private boolean wuetend = false;

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String value) {
        this.name = value;
    }

    public int getAnzahlQuacks() {
        return anzahlQuacks;
    }

    public void setAnzahlQuacks(int anzahlQuacks) {
        this.anzahlQuacks = anzahlQuacks;
    }

    public boolean isWuetend() {
        return wuetend;
    }

    public void setWuetend() {
        this.wuetend = true;
    }

    public void setNormal() {
        this.wuetend = false;
    }
}
