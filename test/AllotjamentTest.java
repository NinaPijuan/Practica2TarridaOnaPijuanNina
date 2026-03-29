import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.InAllotjament;
import prog2.model.Parcela;
import prog2.model.TascaManteniment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AllotjamentTest {

    private Allotjament allotjament;
    private TascaManteniment tascaReparacio;
    private TascaManteniment tascaNeteja;
    private TascaManteniment tascaDesinfeccio;
    private TascaManteniment tascaRevisio;

    @BeforeEach
    void setUp() {
        // Creem una instància anònima d'Allotjament per a tests

        allotjament = new Parcela("Allotjament Test", "ID001", true, "100%", 64.0f, true);

        // Creem diferents tipus de tasques per als tests
        tascaReparacio = new TascaManteniment(1,
                TascaManteniment.TipusTascaManteniment.Reparacio, allotjament, "2024-03-25", 4);
        tascaNeteja = new TascaManteniment(2,
                TascaManteniment.TipusTascaManteniment.Neteja, allotjament, "2024-03-26", 2);
        tascaDesinfeccio = new TascaManteniment(3,
                TascaManteniment.TipusTascaManteniment.Desinfeccio, allotjament, "2024-03-27", 3);
        tascaRevisio = new TascaManteniment(4,
                TascaManteniment.TipusTascaManteniment.RevisioTecnica, allotjament, "2024-03-28", 1);
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

    // Tests addicionals

    @Test
    void testGetNom() {
        assertEquals("Allotjament Test", allotjament.getNom());
    }

    @Test
    void testSetNom() {
        allotjament.setNom("Nou Nom");
        assertEquals("Nou Nom", allotjament.getNom());
    }

    @Test
    void testGetId() {
        assertEquals("ID001", allotjament.getId());
    }

    @Test
    void testSetId() {
        allotjament.setId("ID002");
        assertEquals("ID002", allotjament.getId());
    }

    @Test
    void testGetEstadaMinimaAlta() {
        assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
    }

    @Test
    void testGetEstadaMinimaBaixa() {
        assertEquals(2, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    @Test
    void testSetEstadaMinima() {
        allotjament.setEstadaMinima(10, 5);
        assertEquals(10, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(5, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    @Test
    void testIsOperatiu() {
        assertTrue(allotjament.isOperatiu());
    }

    @Test
    void testSetOperatiu() {
        allotjament.setOperatiu(false);
        assertFalse(allotjament.isOperatiu());

        allotjament.setOperatiu(true);
        assertTrue(allotjament.isOperatiu());
    }

    @Test
    void testGetIluminacio() {
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testSetIluminacio() {
        allotjament.setIluminacio("50%");
        assertEquals("50%", allotjament.getIluminacio());

        allotjament.setIluminacio("0%");
        assertEquals("0%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentAmbReparacio() {
        allotjament.tancarAllotjament(tascaReparacio);
        assertFalse(allotjament.isOperatiu());
        assertEquals("50%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentAmbNeteja() {
        allotjament.tancarAllotjament(tascaNeteja);
        assertFalse(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentAmbDesinfeccio() {
        allotjament.tancarAllotjament(tascaDesinfeccio);
        assertFalse(allotjament.isOperatiu());
        assertEquals("0%", allotjament.getIluminacio());
    }

    @Test
    void testTancarAllotjamentAmbRevisioTecnica() {
        allotjament.tancarAllotjament(tascaRevisio);
        assertFalse(allotjament.isOperatiu());
        assertEquals("50%", allotjament.getIluminacio());
    }

    @Test
    void testObrirAllotjament() {
        // Primer tanquem l'allotjament
        allotjament.tancarAllotjament(tascaReparacio);
        assertFalse(allotjament.isOperatiu());
        assertEquals("50%", allotjament.getIluminacio());

        // Després l'obrim
        allotjament.obrirAllotjament();
        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testToString() {
        String result = allotjament.toString();
        assertTrue(result.contains("Allotjament Test"));
        assertTrue(result.contains("ID001"));
        assertTrue(result.contains("4")); // estada mínima ALTA
        assertTrue(result.contains("2")); // estada mínima BAIXA
    }

    @Test
    void testTancarIObrirMultipleVegades() {
        // Tanquem
        allotjament.tancarAllotjament(tascaReparacio);
        assertFalse(allotjament.isOperatiu());

        // Obrim
        allotjament.obrirAllotjament();
        assertTrue(allotjament.isOperatiu());

        // Tanquem altre cop
        allotjament.tancarAllotjament(tascaDesinfeccio);
        assertFalse(allotjament.isOperatiu());
        assertEquals("0%", allotjament.getIluminacio());

        // Obrim altre cop
        allotjament.obrirAllotjament();
        assertTrue(allotjament.isOperatiu());
        assertEquals("100%", allotjament.getIluminacio());
    }

    @Test
    void testTotsElsTipusTanca() {
        // Reparacio
        allotjament.tancarAllotjament(tascaReparacio);
        assertFalse(allotjament.isOperatiu());

        // Obrim per al següent test
        allotjament.obrirAllotjament();

        // Neteja
        allotjament.tancarAllotjament(tascaNeteja);
        assertFalse(allotjament.isOperatiu());

        // Obrim
        allotjament.obrirAllotjament();

        // Desinfeccio
        allotjament.tancarAllotjament(tascaDesinfeccio);
        assertFalse(allotjament.isOperatiu());
    }
}



