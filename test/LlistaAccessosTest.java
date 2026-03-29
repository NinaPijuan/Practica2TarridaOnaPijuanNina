import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.CamiAsfaltat;
import prog2.model.CarreteraAsfaltada;
import prog2.model.LlistaAccessos;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llistaAccessos;
    private CamiAsfaltat camiAsfaltat;
    private CarreteraAsfaltada carreteraAsfaltada;

    @BeforeEach
    void setUp() {
        llistaAccessos = new LlistaAccessos();
        camiAsfaltat = new CamiAsfaltat("A1", true, 200.0f);
        carreteraAsfaltada = new CarreteraAsfaltada("A2", true, 800.0f, 10000.0f);
    }

    @Test
    void testAfegirAcces() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(camiAsfaltat);
        assertEquals(1, llistaAccessos.getLlistaAccessos().size());
    }

    @Test
    void testAfegirAccesDuplicatLlançaExcepcio() {
        try {
            llistaAccessos.afegirAcces(camiAsfaltat);
            llistaAccessos.afegirAcces(camiAsfaltat);

            // Si arriba aquí, el test falla
            fail("Havia de llançar ExcepcioCamping");
        } catch (ExcepcioCamping e) {
            // OK, l'excepció s'ha llançat
            assertTrue(e.getMessage().contains("ja existeix"));
        }
    }
    @Test
    void testBuidar() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(camiAsfaltat);
        llistaAccessos.buidar();
        assertEquals(0, llistaAccessos.getLlistaAccessos().size());
    }

    @Test
    void testLlistarAccessos() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(camiAsfaltat);
        String result = llistaAccessos.llistarAccessos(true);
        assertTrue(result.contains("A1"));
    }

    @Test
    void testCalculaAccessosNoAccessibles() throws ExcepcioCamping {
        llistaAccessos.afegirAcces(camiAsfaltat); // isAccessibilitat = false
        llistaAccessos.afegirAcces(carreteraAsfaltada); // isAccessibilitat = true
        assertEquals(1, llistaAccessos.calculaAccessosNoAccessibles());
    }
}