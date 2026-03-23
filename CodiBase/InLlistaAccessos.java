
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques d'una llista d'accessos.
 */
public interface InLlistaAccessos {
    
    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    public void afegirAcces(Acces acc) throws ExcepcioCamping;
    
    /**
     * Buida la llista d'accessos
     */
     public void buidar();
     
     /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció. 
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     * 
     */
     public String llistarAccessos(boolean estat) throws ExcepcioCamping;
     
     /**
      * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
      */
     public void actualitzaEstatAccessos() throws ExcepcioCamping;
     
     /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos sense accessibilitat.
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
     public int calculaAccessosNoAccessibles() throws ExcepcioCamping;
     
     /**
     * Itera sobre la llista d'accessos, i pels accessos de terra suma el total de metres (longitud) i ho retorna.
     * @return float amb els metres totals.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
     public float calculaMetresTerra() throws ExcepcioCamping;
}
