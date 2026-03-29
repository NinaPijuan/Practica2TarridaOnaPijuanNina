package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {

    private ArrayList<Acces> llistaAccessos;


    /**
     * Constructor
     */
    public LlistaAccessos() {
        this.llistaAccessos = new ArrayList<Acces>();
    }

    public void setLlistaAccessos(ArrayList<Acces> llistaAccessos) {
        this.llistaAccessos = llistaAccessos;
    }

    public ArrayList<Acces> getLlistaAccessos() {
        return llistaAccessos;
    }

    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     *
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

        // Comprovem k acc sigui nou:
        for(int i = 0; i < llistaAccessos.size(); i++){
            if (llistaAccessos.get(i).getNom().equals(acc.getNom())){
                throw new ExcepcioCamping(acc.getNom() + " ja existeix"); }
            }

        // Si no existeix, l'afegim
        llistaAccessos.add(acc);

    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() { llistaAccessos.clear(); }


    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     *
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {

        // Llancem excepció si la llista  és buida
        if(llistaAccessos.isEmpty()){ throw new ExcepcioCamping("No hi ha accessos"); }

        String resultat = "";
        // Fem un recorregut per concatenar la informació dels accessos k son amb l'estat k volem
        for (int i = 0; i < llistaAccessos.size(); i++) {
            if (llistaAccessos.get(i).getEstat() == estat) {
                resultat += llistaAccessos.get(i).toString();
                resultat += "\n";
            }
        }

        if (resultat.equals("")){ throw new ExcepcioCamping("No hi ha cap acces " + ((estat) ? "obert" : "tancat")); }

        return resultat;
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     *
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

        // Recorrem la llista d'accessos
        for(int i = 0; i < llistaAccessos.size(); i++){
            Acces actual = llistaAccessos.get(i);

            // A cada accés li agafem la llista d'allotjaments k connecta
            LlistaAllotjaments llistaAllotjaments = actual.getAAllotjaments();

            // Amb el mètode cointainsAllo...() de LlistaAllotjaments mirem si connecta algun allot-
            // jament operatiu, si no -> el tankuem amb el mètode de d'Accés k fa akuesta feina o l'obrim
            if (!llistaAllotjaments.containsAllotjamentOperatiu()){ actual.tancarAcces(); }
            else{ actual.obrirAcces(); }

        }

    }

    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     *
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {

        // Recorre la llista buscant els camins
        int noAccessibles = 0;
        for(int i = 0; i < llistaAccessos.size(); i++){
            Acces acces = llistaAccessos.get(i);
            if (!acces.isAccessibilitat()) {
                noAccessibles++;
            }
        }

        // Llancem excepció si no hi ha accessos no accessibles
        if(noAccessibles == 0){ throw new ExcepcioCamping("Tots els accessos són accessibles"); }

        return noAccessibles;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     *
     * @return float amb els metres totals.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {

        // Recorre la llista buscant els AccesTerra i va sumant les longituds
        float metresTerra = 0;
        for(int i = 0; i < llistaAccessos.size(); i++){
            Acces acces = llistaAccessos.get(i);
            if (acces instanceof AccesTerra){
                metresTerra += ((AccesTerra) acces).getLongitud();
            }
        }

        // Llancem excepció si no hi ha accessos de terra
        if(metresTerra == 0){ throw new ExcepcioCamping("No hi ha accessos de terra"); }

        return metresTerra;
    }
}
