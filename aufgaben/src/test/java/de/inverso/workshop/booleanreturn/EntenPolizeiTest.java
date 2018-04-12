package de.inverso.workshop.booleanreturn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.Random.class)
public class EntenPolizeiTest {

    private final EntenPolizei polizei = new EntenPolizei();
    private final Ente ente = new Ente();

    @Test
    public void istEnte_liefert_false_wenn_der_Name_nicht_gesetzt_wurde() throws Exception {
        ente.setAnzahlQuacks(10);
        ente.setName(null);
        assertThat(polizei.istEnte(ente)).isFalse();
        ente.setName(" ");
        assertThat(polizei.istEnte(ente)).isFalse();
        ente.setName("Dagobert");
        assertThat(polizei.istEnte(ente)).isTrue();
    }

    @Test
    public void istEnte_liefert_false_wenn_nich_gequackt_wurde() throws Exception {
        ente.setName("Donald");
        ente.setAnzahlQuacks(0);
        assertThat(polizei.istEnte(ente)).isFalse();
        ente.setAnzahlQuacks(-1);
        assertThat(polizei.istEnte(ente)).isFalse();
        ente.setAnzahlQuacks(1);
        assertThat(polizei.istEnte(ente)).isTrue();
    }

    @Test
    public void istReicheEnte() throws Exception {
        ente.setName(null);
        ente.setAnzahlQuacks(1);
        assertThat(polizei.istReicheEnte(ente)).isFalse();
        ente.setName("Donald");
        assertThat(polizei.istReicheEnte(ente)).isFalse();
        ente.setName("Dagobert");
        assertThat(polizei.istReicheEnte(ente)).isTrue();
        ente.setAnzahlQuacks(0);
        assertThat(polizei.istReicheEnte(ente)).isFalse();
    }

    @Test
    void macheNurDonaldWuetend_Nur_Enten_werden_verändert() throws Exception {
        ente.setName(null);
        ente.setAnzahlQuacks(0);
        ente.setWuetend();
        assertThat(ente.isWuetend()).isTrue();
        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isTrue();

        ente.setAnzahlQuacks(1);
        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isFalse();
    }

    @Test
    void macheNurDonaldWuetend_Nur_Donald_wird_wütend() throws Exception {
        ente.setName("Donald");
        ente.setAnzahlQuacks(1);
        assertThat(ente.isWuetend()).isFalse();

        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isTrue();

        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isTrue();

        ente.setName(null);
        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isFalse();

        ente.setName("Dagobert");
        polizei.macheNurDonaldWuetend(ente);
        assertThat(ente.isWuetend()).isFalse();
    }
}
