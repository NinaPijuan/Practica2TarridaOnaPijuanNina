package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques per gestionar un càmping.
 */
public interface InCamping {

    /**
     * Retorna el nom del càmping.
     * @return String
     */
    String getNomCamping();

    /**
     * Llista els allotjaments segons el seu estat.
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return String
     * @throws ExcepcioCamping
     */
    String llistarAllotjaments(String estat) throws ExcepcioCamping;

    /**
     * Llista els accessos segons l'estat indicat.
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping
     */
    String llistarAccessos(String infoEstat) throws ExcepcioCamping;

    /**
     * Llista les tasques registrades al càmping.
     * @return String
     * @throws ExcepcioCamping
     */
    String llistarTasquesManteniment() throws ExcepcioCamping;

    /**
     * Afegeix una nova tasca al registre del càmping.
     * @param num Número identificador de la tasca.
     * @param tipus Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data Data en què s'ha registrat la tasca.
     * @param dies Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping;

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    void completarTascaManteniment(int num) throws ExcepcioCamping;

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     * @return El nombre d'accessos accessibles. (int)
     */
    int calculaAccessosNoAccessibles();

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     * @return La quantitat de metres. (float)
     */
    float calculaMetresTerra();

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    void save(String camiDesti) throws ExcepcioCamping;

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     * @param camiOrigen Ruta del fitxer d'origen.
     * @return Una instància de la classe Camping carregada des del fitxer.
     * @throws ExcepcioCamping
     */
    static Camping load(String camiOrigen) throws ExcepcioCamping {
        throw new UnsupportedOperationException("Aquest mètode està implementat a la classe Camping");
    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    void inicialitzaDadesCamping();
}
