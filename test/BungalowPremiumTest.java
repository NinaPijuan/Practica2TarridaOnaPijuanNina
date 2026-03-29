import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.BungalowPremium;

import static org.junit.jupiter.api.Assertions.*;

public class BungalowPremiumTest {

    private BungalowPremium bungalowPremium;

    @BeforeEach
    void setUp() {
        // Crear un allotjament
        bungalowPremium = new BungalowPremium("Bungalow Sud", "ALL4", true, "100%", 27.0f,
                2, 6, 1, true, true, true, true, "CampingDelMarBP1");
    }
    @Test
    void comprovarConstructor() {
        assertEquals("Bungalow Sud", bungalowPremium.getNom());
        assertEquals("ALL4", bungalowPremium.getId());
        assertEquals(27.0f, bungalowPremium.getMida());
        assertEquals(2, bungalowPremium.getNumHab());
        assertEquals(6, bungalowPremium.getCapacitat());
        assertTrue(bungalowPremium.getServeisExtra());
        assertEquals("CampingDelMarBP1", bungalowPremium.getWifi());
    }

    @Test
    void testCorrecteFuncionament() {
        // aire true i wifi entre 8-16 caràcters
        assertTrue(bungalowPremium.correcteFuncionament());

        bungalowPremium.setAire(false);
        assertFalse(bungalowPremium.correcteFuncionament());

        bungalowPremium.setAire(true);
        bungalowPremium.setWifi("curta");
        assertFalse(bungalowPremium.correcteFuncionament());
    }

    @Test
    void testSetters() {
        bungalowPremium.setServeisExtra(false);
        assertFalse(bungalowPremium.getServeisExtra());
        bungalowPremium.setWifi("nouCodiWifi");
        assertEquals("nouCodiWifi", bungalowPremium.getWifi());
    }
}