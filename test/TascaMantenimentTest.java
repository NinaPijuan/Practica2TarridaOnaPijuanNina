import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Parcela;
import prog2.model.TascaManteniment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TascaMantenimentTest {
    private TascaManteniment tasca;
    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Suposant que Allotjament té un constructor bàsic
        allotjament = new Parcela("Allotjament Test", "ID001", true,  "100%", 50,  true);
        tasca = new TascaManteniment(1, TascaManteniment.TipusTascaManteniment.Reparacio, allotjament, "2024-03-25", 4);
    }

    @Test
    void testConstructor() {
        assertEquals(1, tasca.getNum());
        assertEquals(TascaManteniment.TipusTascaManteniment.Reparacio, tasca.getTipus());
        assertEquals(allotjament, tasca.getAllotjament());
        assertEquals("2024-03-25", tasca.getData());
        assertEquals(4, tasca.getDies());
    }
}
