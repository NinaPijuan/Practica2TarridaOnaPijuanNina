package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllotjamentTest {

    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Creem una instància anònima d'Allotjament per a tests

        allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);
    }

    @Test
    void comprovarConstructor() {
        assertEquals("Allotjament Test", allotjament.getNom());
        assertEquals("ID001", allotjament.getId());
        assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(2, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
        assertEquals(true, allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }
}



