import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.CarreteraAsfaltada;

import static org.junit.jupiter.api.Assertions.*;

public class CarreteraAsfaltadaTest {

    private CarreteraAsfaltada carreteraAsfaltada;

    @BeforeEach
    void setUp() {
        // Crear un acces
        carreteraAsfaltada = new CarreteraAsfaltada("A2", true, 800.0f, 10000.0f);
    }

    @Test
    void comprovarConstructor(){
        assertEquals("A2", carreteraAsfaltada.getNom());
        assertTrue(carreteraAsfaltada.getEstat());
        assertEquals(800.0f, carreteraAsfaltada.getM2Asfalt());
        assertEquals(10000.0f, carreteraAsfaltada.getPesMax());
        assertTrue(carreteraAsfaltada.isAccessibilitat());
    }

    @Test
    void testSetPesMax() {
        carreteraAsfaltada.setPesMax(12000.0f);
        assertEquals(12000.0f, carreteraAsfaltada.getPesMax());
    }

    @Test
    void testToString() {
        String result = carreteraAsfaltada.toString();
        assertTrue(result.contains("A2"));
        assertTrue(result.contains("Carretera asfaltada"));
        assertTrue(result.contains("800.0"));
        assertTrue(result.contains("10000.0"));
    }
}