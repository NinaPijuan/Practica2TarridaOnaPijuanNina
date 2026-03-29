import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.CarreteraTerra;

import static org.junit.jupiter.api.Assertions.*;

public class CarreteraTerraTest {

    private CarreteraTerra carreteraTerra;

    @BeforeEach
    void setUp() {
        // Crear un acces
        carreteraTerra = new CarreteraTerra("A4", true, 200.0f, 3.0f);
    }

    @Test
    void comprovarConstructor(){
        assertEquals("A4", carreteraTerra.getNom());
        assertTrue(carreteraTerra.getEstat());
        assertEquals(200.0f, carreteraTerra.getLongitud());
        assertEquals(3.0f, carreteraTerra.getAmplada());
        assertTrue(carreteraTerra.isAccessibilitat());
    }

    @Test
    void testSetPesMax() {
        carreteraTerra.setAmplada(4.0f);
        assertEquals(4.0f, carreteraTerra.getAmplada());
    }

    @Test
    void testToString() {
        String result = carreteraTerra.toString();
        assertTrue(result.contains("A4"));
        assertTrue(result.contains("Carretera de terra"));
        assertTrue(result.contains("200.0"));
        assertTrue(result.contains("3.0"));
    }
}