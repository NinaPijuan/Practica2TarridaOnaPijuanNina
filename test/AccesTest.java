import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Acces;
import prog2.model.Allotjament;
import prog2.model.LlistaAllotjaments;
import prog2.model.Parcela;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesTest {

    private Acces acces1;
    private Acces acces2;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Dos accessos inicials i un allotjament
        acces1 = new Acces("Acces 1", true){
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
        acces2 = new Acces("Acces 2", false){
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };

        allotjament = new Parcela("Parcel·la Test", "TEST1", true, "100%", 64.0f, true);
    }

    @Test
    void comprovarConstructor(){
        assertEquals("Acces 1", acces1.getNom());
        assertEquals("Acces 2", acces2.getNom());
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
        assertTrue(acces1.getAAllotjaments() instanceof LlistaAllotjaments);
    }

    // Tests addicionals

    @Test
    void testAfegirAllotjament() throws ExcepcioCamping {
        acces1.afegirAllotjament(allotjament);
        LlistaAllotjaments llista = acces1.getAAllotjaments();
        assertTrue(llista.contains(allotjament));
    }

    @Test
    void testAfegirAllotjamentDuplicatLlançaExcepcio() throws ExcepcioCamping {
        acces1.afegirAllotjament(allotjament);

        try {
            acces1.afegirAllotjament(allotjament);

            fail("L'allotjament ja s'ha connectat a l'acces");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("ja està connectat"));
        }
    }

    @Test
    void testTancarAcces() {
        acces1.tancarAcces();
        assertFalse(acces1.getEstat());
    }

    @Test
    void testObrirAcces() {
        acces2.obrirAcces();
        assertTrue(acces2.getEstat());
    }

    @Test
    void testGetNom() {
        assertEquals("Acces 1", acces1.getNom());
        assertEquals("Acces 2", acces2.getNom());
    }

    @Test
    void testGetEstat() {
        assertTrue(acces1.getEstat());
        assertFalse(acces2.getEstat());
    }

    @Test
    void testGetAAllotjaments() {
        LlistaAllotjaments llista = acces1.getAAllotjaments();
        assertNotNull(llista);
        assertTrue(llista instanceof LlistaAllotjaments);
    }

    @Test
    void testIsAccessibilitat() {
        assertTrue(acces1.isAccessibilitat());
        assertFalse(acces2.isAccessibilitat());
    }

    @Test
    void testToString() {
        String result = acces1.toString();
        assertTrue(result.contains("Acces 1"));
    }

    @Test
    void testAfegirMultiplesAllotjaments() throws ExcepcioCamping {
        Allotjament allotjament2 = new Parcela("Parcel·la Test 2", "TEST2", true, "100%", 50.0f, true);

        acces1.afegirAllotjament(allotjament);
        acces1.afegirAllotjament(allotjament2);

        LlistaAllotjaments llista = acces1.getAAllotjaments();
        assertTrue(llista.contains(allotjament));
        assertTrue(llista.contains(allotjament2));
    }
}
