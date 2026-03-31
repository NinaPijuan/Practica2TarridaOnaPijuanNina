package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class Camping implements InCamping, Serializable {

    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    /**
     * Constructor
     * @param nom
     */
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

        // Buskuem la tasca segons el num donat amb el mètode de LlistaTaskuesManteniment k ho fa
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);

        // Completem la tasca amb el mètode de LlistaTaskuesManteniment k ho fa
        llistaTasquesManteniment.completarTascaManteniment(tasca);

        // Actualitzem els accessos
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre d'accessos no accessibles al càmping.
     *
     * @return El nombre d'accessos accessibles. (int)
     */
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {

        // Cridem al mètode de LlistaAccessos kue fa akuesta feina
        return llistaAccessos.calculaAccessosNoAccessibles();
    }

    /**
     * Calcula la quantitat total de metres dels accessos de terra.
     *
     * @return La quantitat de metres. (float)
     */
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {

        // Cridem al mètode de LlistaAccessos kue fa akuesta feina
        return llistaAccessos.calculaMetresTerra();
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        // Creem el fitxer
        File fitxer = new File(camiDesti);

        try {

            // Creem el canal i la maleta
            FileOutputStream fos = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Escrivim el Camping (this)
            oos.writeObject(this);

            // Tanquem canals
            fos.close();
            oos.close();

        } catch (IOException e) {
            throw new ExcepcioCamping("No s'ha pogut guardar el càmping");
        }
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     *
     * @param camiOrigen Ruta del fitxer d'origen.
     * @return Una instància de la classe Camping carregada des del fitxer.
     * @throws ExcepcioCamping
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {

        // Inicialitzem les variables per poder veure-les dins del try
        Camping camping = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // Provem de donar-los valors; si no -> llancem excepcions
        try {
            fis = new FileInputStream(camiOrigen);
            ois = new ObjectInputStream(fis);
            camping = (Camping) ois.readObject();

        } catch (FileNotFoundException e) {
            throw new ExcepcioCamping("El fitxer no existeix");
        } catch (ClassNotFoundException e) {
            throw new ExcepcioCamping("No s'han pogut llegir les dades del fitxer");
        } catch (IOException e) {
            throw new ExcepcioCamping("El fitxer no existeix");
        }

        // Provem de tancar els canals
        finally {
            try {
                fis.close();
                ois.close();
            } catch (NullPointerException e) {
                throw new ExcepcioCamping("El fitxer no existeix");
            } catch (IOException e) {
                throw new ExcepcioCamping("No s'ha pogut tancar el fitxer");
            }
        }

        return camping;

    }

    /**
     * Inicialitza les dades del càmping amb valors predeterminats.
     *
     * @throws ExcepcioCamping
     */
    @Override
    public void inicialitzaDadesCamping() throws ExcepcioCamping {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);

    }

}