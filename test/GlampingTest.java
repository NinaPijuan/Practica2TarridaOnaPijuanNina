import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Glamping;

import static org.junit.jupiter.api.Assertions.*;

public class GlampingTest {

    private Glamping glamping;

    @BeforeEach
    void setUp() {
        // Crear un allotjament
        glamping = new Glamping("Glamping Nord", "ALL5", true, "100%",
                20.0f, 1, 2, "tela", true);
    }
    @Test
    void comprovarConstructor() {
        assertEquals("Glamping Nord", glamping.getNom());
        assertEquals("ALL5", glamping.getId());
        assertEquals(20.0f, glamping.getMida());
        assertEquals(1, glamping.getNumHab());
        assertEquals(2, glamping.getCapacitat());
        assertEquals("tela", glamping.getMaterial());
        assertTrue(glamping.getCasaMascota());
    }

    @Test
    void testCorrecteFuncionament() {
        // té casa mascota
        assertTrue(glamping.correcteFuncionament());
        glamping.setCasaMascota(false);
        assertFalse(glamping.correcteFuncionament());
    }

    @Test
    void testSetMaterial() {
        glamping.setMaterial("fusta");
        assertEquals("fusta", glamping.getMaterial());

        // Material invàlid no hauria de canviar
        glamping.setMaterial("plàstic");
        assertEquals("fusta", glamping.getMaterial());
    }
}