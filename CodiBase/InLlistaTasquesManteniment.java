
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 *
 * @author lauraigual
 */
public interface InLlistaTasquesManteniment {
    
    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     * @param num Número d'identificació de la tasca.
     * @param tipus Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data Data quan genera la tasca
     * @param dies Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping;
    /**
    * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
    * @param tasca Objecte de tipus TascaManteniment
    * @throws ExcepcioCamping
     */
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping;
    
    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
    public String llistarTasquesManteniment() throws ExcepcioCamping;
    
    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping;
}
