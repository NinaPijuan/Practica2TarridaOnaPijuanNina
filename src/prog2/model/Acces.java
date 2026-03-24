package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;

// EL CHAT DIU K this.accessibilitat = isAccessibilitat() NO ESTÀ BÉ PK AKUEST MÈTODE ES CRIDA ABANS DE SER IMPLEMENTAT
// LA VERITAT ÉS K TÉ SENTIT EL K DIU PERÒ HO HEM COPIAT DE LA PISSARRA AIXÍ K NO SÉ

// afegirAllotjament() POT DONAR EXCEPCIÓ I NO ESTAVA CONTEMPLAT A InAcces. HO HE AFEGIT ALLÀ I AKUÍ (no sé si es podia fer)

// ELS toStrings() DE CADA ACCÉS HAN KUEDAT RARÍSSIMS.. NO SÉ SI ESTAN BÉ
public abstract class Acces implements InAcces, Serializable {

    private String nom;
    private final boolean accessibilitat;
    private boolean estat; // obert o tancat
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.accessibilitat = isAccessibilitat();
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    @Override
    public String toString(){
        return "Nom: " + nom;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping{

        // Cridem al mètode de LlistaAllotjaments kue fa akuesta feina
        // (a dins ja es comprova si l'allotjament ja està a la llista)
        llistaAllotjaments.afegirAllotjament(allotjament);
    }


    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() { this.estat = false; }


    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() { this.estat = true; }


    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() { return nom; }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */
    @Override
    public boolean getEstat() { return estat; }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() { return llistaAllotjaments; }
}
