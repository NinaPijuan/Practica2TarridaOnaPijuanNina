import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import prog2.model.Camping;
import static org.junit.jupiter.api.Assertions.*;

public class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        camping = new Camping("Camping Green");
        camping.inicialitzaDadesCamping();
    }

    @Test
    void comprovarConstructor() {
        assertEquals("Camping Green", camping.getNomCamping());
    }

    @Test
    void testLlistarAllotjaments() throws ExcepcioCamping {
        // Llistar allotjaments operatius (tots ho són a l'inici)
        String result = camping.llistarAllotjaments("operatiu");
        assertTrue(result.contains("ALL1"));
        assertTrue(result.contains("ALL2"));
        assertTrue(result.contains("ALL3"));
        assertTrue(result.contains("ALL4"));
        assertTrue(result.contains("ALL5"));
        assertTrue(result.contains("ALL6"));
    }

    @Test
    void testLlistarAllotjamentsNoOperatius() throws ExcepcioCamping {
        // Al principi no n'hi ha cap de no operatiu
        try {
            camping.llistarAllotjaments("no operatiu");

            fail("No hauria d'haver-hi cap no operatiu");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("no operatiu"));
        }
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String result = camping.llistarAccessos("obert");
        assertTrue(result.contains("A1"));
        assertTrue(result.contains("A2"));
        assertTrue(result.contains("A3"));
    }

    @Test
    void testLlistarAccessosTancats() throws ExcepcioCamping {
        // Al principi tots estan oberts
        try {
            camping.llistarAccessos("tancat");

            fail("No hauria d'haver-hi cap tancat");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("tancat"));
        }
    }

    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping {
        camping.afegirTascaManteniment(100, "Reparacio", "ALL1", "2024-03-25", 4);

        // Comprovar que la tasca s'ha afegit
        String tasques = camping.llistarTasquesManteniment();
        assertTrue(tasques.contains("100"));
        assertTrue(tasques.contains("ALL1"));
    }

    @Test
    void testAfegirTascaMantenimentAllotjamentNoExisteix() {
        try {
            camping.afegirTascaManteniment(100, "Reparacio", "NO_EXISTEIX", "2024-03-25", 4);

            fail("No existeix el id");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("No hi ha cap Allotjament amb ID"));
        }
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping {
        camping.afegirTascaManteniment(100, "Reparacio", "ALL1", "2024-03-25", 4);
        camping.completarTascaManteniment(100);

        // La tasca ja no hauria d'existir
        try {
            camping.llistarTasquesManteniment();

            fail("No hauria d'existir la tasca");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("No hi ha cap tasca de manteniment"));
        }
    }

    @Test
    void testCompletarTascaMantenimentNoExisteix() {
        try {
            camping.completarTascaManteniment(999);

            fail("No existeix la tasca");
        } catch (ExcepcioCamping e) {
            // OK: l'excepció s'ha llançat correctament
            assertTrue(e.getMessage().contains("No existeix cap tasca"));
        }
    }

    @Test
    void testCalculaAccessosNoAccessibles() throws ExcepcioCamping {
        // A la taula 2: A1, A3, A5, A7, A9, A11 NO tenen accessibilitat (6 accessos)
        int noAccessibles = camping.calculaAccessosNoAccessibles();
        assertEquals(6, noAccessibles);
    }

    @Test
    void testCalculaMetresTerra() throws ExcepcioCamping {
        // Suma de longituds dels accessos de terra (A3, A4, A9, A10, A11, A12)
        // A3:100, A4:200, A9:50, A10:400, A11:80, A12:800 = 1630 metres
        float metresTerra = camping.calculaMetresTerra();
        assertEquals(1630.0f, metresTerra, 0.01);
    }

    @Test
    void testTancarAccesQuanAllotjamentTeTasca() throws ExcepcioCamping {
        // Inicialment A3 i A4 estan oberts
        String accessosOberts = camping.llistarAccessos("obert");
        assertTrue(accessosOberts.contains("A3"));
        assertTrue(accessosOberts.contains("A4"));

        // A2 també està obert (porta a ALL1 i ALL2)
        assertTrue(accessosOberts.contains("A2"));

        // Afegir tasca a ALL3 (que només és accessible per A3 i A4)
        camping.afegirTascaManteniment(100, "Reparacio", "ALL3", "2024-03-25", 4);

        // Comprovar que A3 i A4 s'han tancat
        String accessosObertsDespres = camping.llistarAccessos("obert");
        assertFalse(accessosObertsDespres.contains("A3"));
        assertFalse(accessosObertsDespres.contains("A4"));

        // Comprovar que A2 segueix obert (perquè ALL1 i ALL2 segueixen operatius)
        assertTrue(accessosObertsDespres.contains("A2"));
    }
}