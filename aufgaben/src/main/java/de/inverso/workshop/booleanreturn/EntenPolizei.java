package de.inverso.workshop.booleanreturn;

import javax.annotation.Nonnull;

class EntenPolizei {

    public Boolean istEnte(@Nonnull Ente ente) {
        if (ente.getAnzahlQuacks() < 1 || ente.getName() == null || ente.getName().trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean istReicheEnte(@Nonnull Ente ente) {
        if (ente.getName() != null && ente.getName().equals("Dagobert") && ente.getAnzahlQuacks() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void macheNurDonaldWuetend(@Nonnull Ente ente) {
        if (ente.getAnzahlQuacks() < 1) {
            return;
        } else if (ente.getName() != null && ente.getName().equals("Donald")) {
            if (!ente.isWuetend()) {
                ente.setWuetend();
            } else {
                ente.setWuetend();
            }
        } else {
            ente.setNormal();
        }
    }

    public void macheAufgeregteEnteWuetend(@Nonnull Ente ente) {
        if (ente.getAnzahlQuacks() > 10 && ente.getAnzahlQuacks() < 20) {
            ente.setWuetend();
        } else {
            ente.setNormal();
        }
    }
}