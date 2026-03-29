import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.AccesAsfalt;

import static org.junit.jupiter.api.Assertions.*;

public class AccesAsfaltTest {

    private AccesAsfalt accesAsfalt;

    @BeforeEach
    void setUp() {
        // Crear un acces
        accesAsfalt = new AccesAsfalt("Acces 1", true, 500.0f) {
            @Override
            public boolean isAccessibilitat() {
                return true;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals("Acces 1", accesAsfalt.getNom());
        assertTrue(accesAsfalt.getEstat());
        assertTrue(accesAsfalt.isAccessibilitat());
        assertEquals(500.0f, accesAsfalt.getM2Asfalt());
    }
}