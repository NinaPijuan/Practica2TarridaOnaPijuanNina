package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * completar tasca manteniment
 */
public class Camping implements InCamping {

    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
    }

    /**
     * Retorna el nom del càmping.
     *
     * @return String
     */
    @Override
    public String getNomCamping() {
        return nom;
    }

    /**
     * Llista els allotjaments segons el seu estat.
     *
     * @param estat Estat dels allotjaments a llistar. (Operatiu, No Operatiu)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {

        // Cridem al mètode de la classe LlistaAllotjaments k fa akuesta feina
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista els accessos segons l'estat indicat.
     *
     * @param infoEstat Estat dels accessos a llistar. (Obert, Tancat)
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {

        // Passem l'string a booleà
        boolean estat = infoEstat.equals("obert") || infoEstat.equals("Obert");
        // Cridem el mètode de LlistaAccessos k fa akuesta feina
        return llistaAccessos.llistarAccessos(estat);
    }

    /**
     * Llista les tasques registrades al càmping.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {

        // Cridem al mètode de LlistaTaskuesManteniment k fa akuesta feina
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca al registre del càmping.
     *
     * @param num           Número identificador de la tasca.
     * @param tipus         Tipus de tasca (en format string)
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data          Data en què s'ha registrat la tasca.
     * @param dies          Número esperat de dies per completar la tasca
     * @throws ExcepcioCamping
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

        // Buskuem l'allotjament amb el mètode de LlistaAllotjaments k fa akuesta feina
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);

        // Afegim la tasca amb el mètode de LlistaAllotjaments k fa akuesta feina
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);

        // Actualitzem accessos amb el mètode de LlistaAccesssos k fa akuesta feina
        llistaAccessos.actualitzaEstatAccessos();

    }

    /**
     * Completa una tasca de manteniment existent identificada pel seu número.
     *
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {

    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        return 0;
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() {
        return 0;
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     */
    @Override
    public void inicialitzaDadesCamping() {

    }

//    /**
//     * Retorna la llista d'allotjaments del camping.
//     * @return llistaAllotjaments
//     **/
//    public ArrayList<Allotjament> getLlistaAllotjaments() {
//        return llistaAllotjaments;
//    }
//
//
//
//    /**
//     * Retorna el número total d'allotjaments del càmping.
//     * @return el número total d'allotjaments.
//     */
//    public int getNumAllotjaments() {
//        return llistaAllotjaments.size();
//    }
//
//
//
//
//
//
//
//    /**
//     * Afegeix una nova parcel·la a la llista d'allotjaments.
//     * @param nom_ el nom de la parcela.
//     * @param idAllotjament_ l'identificador únic de l'allotjament.
//     * @param mida la mida de la parcela.
//     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
//     */
//    public void afegirParcela(String nom_, String idAllotjament_, boolean operatiu, String iluminacio, float mida, boolean connexioElectrica) {
//        Parcela p = new Parcela(nom_, idAllotjament_, operatiu, iluminacio, mida, connexioElectrica);
//        llistaAllotjaments.add(p);
//    }
//
//    /**
//     * Afegeix un nou bungalow a la llista d'allotjaments.
//     * @param nom_ el nom del bungalow.
//     * @param idAllotjament_ l'identificador únic de l'allotjament.
//     * @param mida la mida del bungalow.
//     * @param habitacions el nombre d'habitacions del bungalow.
//     * @param placesPersones el nombre màxim de places per a persones.
//     * @param placesParquing el nombre de places de pàrquing disponibles.
//     * @param terrassa true si disposa de terrassa, false altrament.
//     * @param tv true si disposa de televisió, false altrament.
//     * @param aireFred true si disposa d'aire condicionat, false altrament.
//     */
//    public void afegirBungalow(String nom_, String idAllotjament_, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
//        Bungalow b = new Bungalow(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
//        llistaAllotjaments.add(b);
//    }
//
//    /**
//     * Afegeix un bungalow premium a la llista d'allotjaments.
//     * @param serveisExtra true si ofereix serveis extra.
//     * @param codiWifi el codi de la xarxa Wi-Fi.
//     * (Altres paràmetres igual que `afegirBungalow`)
//     */
//    public void afegirBungalowPremium(String nom_, String idAllotjament_, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
//        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
//        llistaAllotjaments.add(bp);
//    }
//
//    /**
//     * Afegeix una casa glamping a la llista d'allotjaments.
//     * @param material el material del que està fet.
//     * @param casaMascota true si accepta mascotes.
//     * (Altres paràmetres igual que `afegirBungalow`)
//     */
//    public void afegirGlamping(String nom_, String idAllotjament_, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
//        Glamping g = new Glamping(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, material, casaMascota);
//        llistaAllotjaments.add(g);
//    }
//
//    /**
//     *  Afegeix una mobil-home a la llista d'allotjaments.
//     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
//     * (Altres paràmetres igual que `afegirBungalow`)
//     */
//    public void afegirMobilHome(String nom_, String idAllotjament_, boolean operatiu, String iluminacio, float mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
//        MobilHome mh = new MobilHome(nom_, idAllotjament_, operatiu, iluminacio, mida, habitacions, placesPersones, terrassaBarbacoa);
//        llistaAllotjaments.add(mh);
//    }
//
//
//
//    /**
//     * Recorre la llista de serveis comprovant el correcte funcionament de cadascun d'ells per contar el número de serveis que estan operatius.
//     * @return el nombre de serveis operatius.
//     */
//    public int calculAllotjamentsOperatius() {
//        int allotjamentsOperatius = 0;
//
//        for (int i = 0; i < llistaAllotjaments.size(); i++){
//            /*
//            // Per accedir a un ArrayList es fa .get(i) i no [i]
//            if (llistaAllotjaments.get(i).correcteFuncionament()){
//                allotjamentsOperatius += 1;
//            }
//
//             */
//        }
//
//        return allotjamentsOperatius;
//    }
//
//
//    /**
//     * Cerca i retorna l'allotjament amb estada mínima de la temporada alta més curta.
//     * @return l'allotjament amb estada mínima de la temporada baixa més curta.
//     */
//    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
//        long min = Integer.MAX_VALUE, estadaMinima;
//        Allotjament allotjamentMin = null;
//
//        // Creem un iterador de la llistaAllotjaments
//        Iterator<Allotjament> itrAllotjament = llistaAllotjaments.iterator();
//        while (itrAllotjament.hasNext()) {
//
//            // a serà l'Allotjament on apunta itrAllotjament i l'iterador es mou una posició
//            Allotjament a = itrAllotjament.next();
//
//            estadaMinima = a.getEstadaMinima(temp);
//            if (estadaMinima < min) {
//                min = estadaMinima;
//                allotjamentMin = a;
//            }
//        }
//
//        if(allotjamentMin == null)
//            throw new RuntimeException();
//        else return allotjamentMin;
//    }
//
//    /**
//     * Busca l'allotjament en la llista d'allotjaments segons l'id donat
//     * @param id id de l'allotjament
//     * @return Allotjament
//     * @throws ExcepcioCamping si no existeix l'allotjament
//     */
//    public Allotjament buscarAllotjament(String id) throws ExcepcioCamping {
//
//        // Creem un iterador de la llistaAllotjaments
//        Iterator<Allotjament> itrAllotjament = llistaAllotjaments.iterator();
//        while (itrAllotjament.hasNext()) {
//
//            // a serà l'ALlotjament on apunta itrAllotjament i itrAllotjament es mou una posició
//            Allotjament a = itrAllotjament.next();
//            if (a.getId().equals(id))
//                return a;
//        }
//        throw new ExcepcioCamping("L'allotjament amb id " + id + " no existeix");
//    }



    /**
     * Retorna la temporada segons la data donada
     * @param data data donada
     * @return ALTA o BAIXA
     */
    public static InAllotjament.Temp getTemporada(LocalDate data) {

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        // Temporada alta:
        if ((mes > 3 && mes < 9) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20))
            return InAllotjament.Temp.ALTA;
            // Temporada baixa;
        else return InAllotjament.Temp.BAIXA;
    }


}
