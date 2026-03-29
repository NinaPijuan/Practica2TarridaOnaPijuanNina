import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.MobilHome;

import static org.junit.jupiter.api.Assertions.*;

public class MobilHomeTest {

    private MobilHome mobilHome;

    @BeforeEach
    void setUp() {
        // Crear un allotjament
        mobilHome = new MobilHome("Mobil-Home Sud", "ALL6", true, "100%",
                20.0f, 2, 4, true);
    }
    @Test
    void comprovarConstructor() {
        assertEquals("Mobil-Home Sud", mobilHome.getNom());
        assertEquals("ALL6", mobilHome.getId());
        assertEquals(20.0f, mobilHome.getMida());
        assertEquals(2, mobilHome.getNumHab());
        assertEquals(4, mobilHome.getCapacitat());
        assertTrue(mobilHome.getTerrassa());
    }

    @Test
    void testCorrecteFuncionament() {
        // té terrassa
        assertTrue(mobilHome.correcteFuncionament());
        mobilHome.setTerrassa(false);
        assertFalse(mobilHome.correcteFuncionament());
    }

    @Test
    void testSetTerrassa() {
        mobilHome.setTerrassa(false);
        assertFalse(mobilHome.getTerrassa());
    }
}