package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {

    private ArrayList<Allotjament> llistaAllotjaments;

    /**
     * Constructor
     */
    public LlistaAllotjaments() {
        this.llistaAllotjaments = new ArrayList<Allotjament>();
    }

    /**
     * Getter de llistaAllotjaments
     * @return
     */
    public ArrayList<Allotjament> getLlistaAllotjaments(){ return llistaAllotjaments; }


    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     *
     * @param allotjament Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        // Accés i Camping tenen LlistaAllotjaments. Entenc k akuesta excepció només
        // salta kuan la gestiona Accés (k vol afegir allotjaments connectats). Si no, canviem la frase de
        // l'excepció i la fem més genèrica
        if(contains(allotjament)){ throw new ExcepcioCamping("Aquest allotjament ja està connectat"); }
        else{ llistaAllotjaments.add(allotjament); }

    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() { llistaAllotjaments.clear(); }


    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat
     * @return String
     * @throws ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {

        if (llistaAllotjaments.isEmpty()){ throw new ExcepcioCamping("La llista és buida"); }

        String resultat = "";

        // Passem l'string estat a booleà
        boolean estatBoolean = estat.equals("operatiu") || estat.equals("Operatiu");

        // Recorrem la llista i concatenem la informació només dels k tenen per estat el k volem
        for(int i = 0; i < llistaAllotjaments.size(); i++){
            if(llistaAllotjaments.get(i).isOperatiu() == estatBoolean){
                resultat += llistaAllotjaments.get(i).toString();
                resultat += " ";
            }
        }

        if (resultat.equals("")){ throw new ExcepcioCamping("No hi ha cap allotjament " + estat); }

        return resultat;
    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     *
     * @return boolean
     */
    @Override
    public boolean containsAllotjamentOperatiu() {

        boolean trobat = false;
        for(int i = 0; i < llistaAllotjaments.size() && !trobat; i++) {
            if (llistaAllotjaments.get(i).isOperatiu()) {
                trobat = true;
            }
        }

        return trobat;
    }

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     *
     * @param allotjament
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {

        String id = allotjament.getId();
        boolean trobat = false;
        for(int i = 0; i < llistaAllotjaments.size() && !trobat; i++){
            if(llistaAllotjaments.get(i).getId().equals(id)){ trobat = true; }
        }
        return trobat;
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     *
     * @param id String amb el id de l'allotjament
     * @return Objecte de tipus Allotjament
     * @throws ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {

        Allotjament allotjament = null;
        boolean trobat = false;
        for(int i = 0; i < llistaAllotjaments.size() && !trobat; i++) {
            if (llistaAllotjaments.get(i).getId().equals(id)) {
                trobat = true;
                allotjament = llistaAllotjaments.get(i);
            }
        }

        if (!trobat){ throw new ExcepcioCamping("No hi ha cap Allotjament amb ID: " + id); }
        return allotjament;
    }
}
