import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.LlistaTasquesManteniment;
import prog2.model.Parcela;
import prog2.model.TascaManteniment;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaTasquesMantenimentTest {

    private LlistaTasquesManteniment llistaTasques;
    private Parcela parcela;

    @BeforeEach
    void setUp() {
        llistaTasques = new LlistaTasquesManteniment();
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64.0f, true);
    }

    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);

        // L'allotjament s'ha de tancar
        assertFalse(parcela.isOperatiu());
    }

    @Test
    void testAfegirTascaMantenimentTipusInvalid() {
        try {
            llistaTasques.afegirTascaManteniment(1, "TipusInvalid", parcela, "2024-03-25", 4);

            fail("Havia de llançar ExcepcioCamping perquè el tipus és invàlid");

        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("tipus de tasca no existeix"));
        }
    }

    @Test
    void testAfegirTascaDuplicadaAllotjament() throws ExcepcioCamping {
        // Primer afegim una tasca correctament
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);

        // Intentem afegir una segona tasca al mateix allotjament
        try {
            llistaTasques.afegirTascaManteniment(2, "Neteja", parcela, "2024-03-26", 2);

            fail("Havia de llançar ExcepcioCamping perquè l'allotjament ja té una tasca");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("ja té una tasca pendent"));
        }
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping {
        llistaTasques.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        TascaManteniment tasca = llistaTasques.getTascaManteniment(1);
        llistaTasques.completarTascaManteniment(tasca);
        assertTrue(parcela.isOperatiu());
    }
}