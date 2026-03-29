import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.model.Parcela;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llistaAllotjaments;
    private Parcela parcela;

    @BeforeEach
    void setUp() {
        llistaAllotjaments = new LlistaAllotjaments();
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64.0f, true);
    }

    @Test
    void testAfegirAllotjament() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(parcela);
        assertEquals(1, llistaAllotjaments.getLlistaAllotjaments().size());
    }

    @Test
    void testContains() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(parcela);
        assertTrue(llistaAllotjaments.contains(parcela));
    }

    @Test
    void testContainsAllotjamentOperatiu() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(parcela);
        assertTrue(llistaAllotjaments.containsAllotjamentOperatiu());
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        llistaAllotjaments.afegirAllotjament(parcela);
        Allotjament trobat = llistaAllotjaments.getAllotjament("ALL1");
        assertEquals(parcela, trobat);
    }

    @Test
    void testGetAllotjamentNotFound() {
        try {
            llistaAllotjaments.getAllotjament("NO_EXISTEIX");

            fail("Havia de llançar ExcepcioCamping perquè l'ID no existeix");

        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("No hi ha cap Allotjament"));
        }
    }
}