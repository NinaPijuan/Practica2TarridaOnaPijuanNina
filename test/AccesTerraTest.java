import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.AccesTerra;

import static org.junit.jupiter.api.Assertions.*;

public class AccesTerraTest {

    private AccesTerra accesTerra;

    @BeforeEach
    void setUp() {
        // Crear un acces
        accesTerra = new AccesTerra("Acces 1", true, 150.0f) {
            @Override
            public boolean isAccessibilitat() {
                return false;
            }
        };
    }

    @Test
    void comprovarConstructor(){
        assertEquals("Acces 1", accesTerra.getNom());
        assertTrue(accesTerra.getEstat());
        assertFalse(accesTerra.isAccessibilitat());
        assertEquals(150.0f, accesTerra.getLongitud());
    }
}