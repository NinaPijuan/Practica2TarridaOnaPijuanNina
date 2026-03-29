import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.Parcela;
import prog2.model.TascaManteniment;

import static org.junit.jupiter.api.Assertions.*;

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

    // Tests addicionals
    @Test
    void testGetIluminacioAllotjament() {
        // Reparacio 50%
        assertEquals("50%", tasca.getIluminacioAllotjament());

        // Neteja 100%
        TascaManteniment tascaNeteja = new TascaManteniment(2,
                TascaManteniment.TipusTascaManteniment.Neteja, allotjament, "2024-03-26", 2);
        assertEquals("100%", tascaNeteja.getIluminacioAllotjament());

        // Desinfeccio 0%
        TascaManteniment tascaDesinfeccio = new TascaManteniment(3,
                TascaManteniment.TipusTascaManteniment.Desinfeccio, allotjament, "2024-03-27", 3);
        assertEquals("0%", tascaDesinfeccio.getIluminacioAllotjament());

        // RevisioTecnica 50%
        TascaManteniment tascaRevisio = new TascaManteniment(4,
                TascaManteniment.TipusTascaManteniment.RevisioTecnica, allotjament, "2024-03-28", 1);
        assertEquals("50%", tascaRevisio.getIluminacioAllotjament());
    }

    @Test
    void testSetters() {
        Allotjament altreAllotjament = new Parcela("Altre", "ID002", true, "100%", 50.0f, false);

        tasca.setNum(10);
        assertEquals(10, tasca.getNum());

        tasca.setTipus(TascaManteniment.TipusTascaManteniment.Neteja);
        assertEquals(TascaManteniment.TipusTascaManteniment.Neteja, tasca.getTipus());

        tasca.setAllotjament(altreAllotjament);
        assertEquals(altreAllotjament, tasca.getAllotjament());

        tasca.setData("2024-12-31");
        assertEquals("2024-12-31", tasca.getData());

        tasca.setDies(7);
        assertEquals(7, tasca.getDies());
    }

    @Test
    void testToString() {
        String result = tasca.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("Reparacio"));
        assertTrue(result.contains("ID001"));
        assertTrue(result.contains("2024-03-25"));
        assertTrue(result.contains("4"));
    }

    @Test
    void testTipusTascaEnum() {
        // Comprovar que tots els tipus existeixen
        TascaManteniment.TipusTascaManteniment[] tipus =
                TascaManteniment.TipusTascaManteniment.values();

        assertEquals(4, tipus.length);
        assertTrue(containsTipus(tipus, "Reparacio"));
        assertTrue(containsTipus(tipus, "Neteja"));
        assertTrue(containsTipus(tipus, "RevisioTecnica"));
        assertTrue(containsTipus(tipus, "Desinfeccio"));
    }

    private boolean containsTipus(TascaManteniment.TipusTascaManteniment[] tipus, String nom) {
        for (TascaManteniment.TipusTascaManteniment t : tipus) {
            if (t.name().equals(nom)) return true;
        }
        return false;
    }

    @Test
    void testTotesLesTasquesCanvienIluminacio() {
        // Reparacio
        TascaManteniment t1 = new TascaManteniment(1,
                TascaManteniment.TipusTascaManteniment.Reparacio, allotjament, "2024-03-25", 4);
        assertEquals("50%", t1.getIluminacioAllotjament());

        // Neteja
        TascaManteniment t2 = new TascaManteniment(2,
                TascaManteniment.TipusTascaManteniment.Neteja, allotjament, "2024-03-25", 4);
        assertEquals("100%", t2.getIluminacioAllotjament());

        // RevisioTecnica
        TascaManteniment t3 = new TascaManteniment(3,
                TascaManteniment.TipusTascaManteniment.RevisioTecnica, allotjament, "2024-03-25", 4);
        assertEquals("50%", t3.getIluminacioAllotjament());

        // Desinfeccio
        TascaManteniment t4 = new TascaManteniment(4,
                TascaManteniment.TipusTascaManteniment.Desinfeccio, allotjament, "2024-03-25", 4);
        assertEquals("0%", t4.getIluminacioAllotjament());
    }
}
