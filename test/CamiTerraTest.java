import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.CamiTerra;

import static org.junit.jupiter.api.Assertions.*;

public class CamiTerraTest {

    private CamiTerra camiTerra;

    @BeforeEach
    void setUp() {
        // Crear un acces
        camiTerra = new CamiTerra("A3", true, 100.0f);
    }

    @Test
    void comprovarConstructor(){
        assertEquals("A3", camiTerra.getNom());
        assertTrue(camiTerra.getEstat());
        assertFalse(camiTerra.isAccessibilitat());
        assertEquals(100.0f, camiTerra.getLongitud());
    }

    @Test
    void testToString() {
        String result = camiTerra.toString();
        assertTrue(result.contains("A3"));
        assertTrue(result.contains("Camí de terra"));
        assertTrue(result.contains("100.0"));
    }
}