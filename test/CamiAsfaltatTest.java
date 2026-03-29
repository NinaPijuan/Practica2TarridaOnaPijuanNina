import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.CamiAsfaltat;

import static org.junit.jupiter.api.Assertions.*;

public class CamiAsfaltatTest {

    private CamiAsfaltat camiAsfaltat;

    @BeforeEach
    void setUp() {
        // Crear un acces
        camiAsfaltat = new CamiAsfaltat("A1", true, 200.0f);
    }

    @Test
    void comprovarConstructor(){
        assertEquals("A1", camiAsfaltat.getNom());
        assertTrue(camiAsfaltat.getEstat());
        assertFalse(camiAsfaltat.isAccessibilitat());
        assertEquals(200.0f, camiAsfaltat.getM2Asfalt());
    }

    @Test
    void testToString() {
        String result = camiAsfaltat.toString();
        assertTrue(result.contains("A1"));
        assertTrue(result.contains("Camí asfaltat"));
        assertTrue(result.contains("200.0"));
    }
}