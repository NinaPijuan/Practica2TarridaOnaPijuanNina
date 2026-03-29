import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Parcela;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelaTest {

    private Parcela parcela;

    @BeforeEach
    void setUp() {
        // Crear un allotjament
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64.0f, true);
    }
    @Test
    void comprovarConstructor() {
        assertEquals("Parcel·la Nord", parcela.getNom());
        assertEquals("ALL1", parcela.getId());
        assertEquals(64.0f, parcela.getMida());
        assertTrue(parcela.getConnexioElectrica());
        assertTrue(parcela.isConnexioElectrica());
    }


    @Test
    void testSetters() {
        parcela.setMida(80.0f);
        assertEquals(80.0f, parcela.getMida());
        parcela.setConnexioElectrica(false);
        assertFalse(parcela.getConnexioElectrica());
    }
}