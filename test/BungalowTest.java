import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Bungalow;

import static org.junit.jupiter.api.Assertions.*;

public class BungalowTest {

    private Bungalow bungalow;

    @BeforeEach
    void setUp() {
        // Crear un allotjament
        bungalow = new Bungalow("Bungalow Nord", "ALL3", true, "100%",
                22.0f, 2, 4, 1, true, true, true);
    }
    @Test
    void comprovarConstructor() {
        assertEquals("Bungalow Nord", bungalow.getNom());
        assertEquals("ALL3", bungalow.getId());
        assertEquals(22.0f, bungalow.getMida());
        assertEquals(2, bungalow.getNumHab());
        assertEquals(4, bungalow.getCapacitat());
        assertEquals(1, bungalow.getParquing());
        assertTrue(bungalow.getTerrassa());
        assertTrue(bungalow.getTele());
        assertTrue(bungalow.getAire());
    }

    @Test
    void testCorrecteFuncionament() {
        // té aire fred
        assertTrue(bungalow.correcteFuncionament());
        bungalow.setAire(false);
        assertFalse(bungalow.correcteFuncionament());
    }

    @Test
    void testSetters() {
        bungalow.setParquing(2);
        assertEquals(2, bungalow.getParquing());
        bungalow.setTerrassa(false);
        assertFalse(bungalow.getTerrassa());
        bungalow.setTele(false);
        assertFalse(bungalow.getTele());
        bungalow.setAire(false);
        assertFalse(bungalow.getAire());
    }
}