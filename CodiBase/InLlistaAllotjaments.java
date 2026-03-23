
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques d'una llista d'allotjaments.
 */
public interface InLlistaAllotjaments {
    
    /**
     * Afegeix un allotjament rebut per paràmetre a la llista d'allotjaments.
     * @param allotjament Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping;
    
    /**
     * Buida la llista d'allotjaments.
     */
    public void buidar();
    
    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     * @param estat
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    public String llistarAllotjaments(String estat) throws ExcepcioCamping;
    
    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     * @return boolean
     */
    public boolean containsAllotjamentOperatiu();
    
    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     * @param allotjament
     * @return boolean
     */
    
    public boolean contains(Allotjament allotjament);
    
    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     * @param id String amb el id de l'allotjament
     * @return  Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public Allotjament getAllotjament(String id) throws ExcepcioCamping;
    
 
}
