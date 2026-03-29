package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {

    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    public LlistaTasquesManteniment() {
        this.llistaTasquesManteniment = new ArrayList<TascaManteniment>();
    }

    /**
     * Aquest mètode crea una tasca de manteniment amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït, la data, i els dies esperats per completar-la) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una tasca, si ja té una tasca s'ha de llançar una excepció.
     * Una vegada creada la tasca s'ha de tancar (no operatiu) l'allotjament corresponent.
     *
     * @param num         Número d'identificació de la tasca.
     * @param tipus       Aquest String permet crear el enum TipusTascaManteniment
     * @param allotjament Allotjament on s'afegeix la tasca
     * @param data        Data quan genera la tasca
     * @param dies        Número de dies esperats per completar la tasca
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una tasca o si el tipus de tasca que es vol afegir no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        // Comprovar que el tipus de tasca existeix
        TascaManteniment.TipusTascaManteniment enumTasca;
        try {
            enumTasca = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("El tipus de tasca no existeix: " + tipus);
        }

        // Comprovar que l'allotjament no té ja una tasca
        for (int i = 0; i < llistaTasquesManteniment.size(); i++) {
            if(llistaTasquesManteniment.get(i).getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament ja té una tasca pendent");
            }
        }

        // Comprovar que el número de tasca no existeixi
        for (int i = 0; i < llistaTasquesManteniment.size(); i++) {
            if (llistaTasquesManteniment.get(i).getNum() == num) {
                throw new ExcepcioCamping("Ja existeix una tasca amb el número: " + num);
            }
        }

        // Crear la tasca
        TascaManteniment tasca = new TascaManteniment(num, enumTasca, allotjament, data, dies);
        llistaTasquesManteniment.add(tasca);

        // Actualitzar l'estat de l'allotjament
        allotjament.setOperatiu(false);

        // Actualitzar il·luminació
        switch(enumTasca) {
            case Reparacio, RevisioTecnica:
                allotjament.setIluminacio("50%");
                break;
            case Neteja:
                allotjament.setIluminacio("100%");
                break;
            case Desinfeccio:
                allotjament.setIluminacio("0%");
                break;
        }

        /*
        if (allotjament.isOperatiu()){
            TascaManteniment tasca =  new TascaManteniment(num, enumTasca, allotjament, data, dies);
            llistaTasquesManteniment.add(tasca);
            allotjament.setOperatiu(false); }

        else{ throw new ExcepcioCamping("L'allotjament ja té una tasca pendent"); }
        */



    }

    /**
     * Aquest mètode completa una tasca de manteniment de la llista (l'elimina) i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     *
     * @param tasca Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping
     */
    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

        // Creem un iterador
        Iterator<TascaManteniment> itrTasca = llistaTasquesManteniment.iterator();

        boolean trobada = false;
        while(!trobada && itrTasca.hasNext()){

            // actual serà la tasca on apunta itrTasca i l'iterador es mou una posició
            TascaManteniment actual = itrTasca.next();
            if (actual == tasca) {
                trobada = true;

                // La borrem de la llista
                llistaTasquesManteniment.remove(actual);

                // Posem l'allotjament operatiu
                Allotjament allotjament = tasca.getAllotjament();
                allotjament.setOperatiu(true);
            }
        }

        if(!trobada){ throw new ExcepcioCamping("La tasca no existeix"); }


    }

    /**
     * Itera sobre la llista de tasques i retorna un String amb la informació de totes les tasques de manteniment.
     * En cas que no hi hagi cap tasca llança una excepció.
     *
     * @return String
     * @throws ExcepcioCamping
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {

        String resultat = "";
        if (llistaTasquesManteniment.size() == 0){ throw new ExcepcioCamping("No hi ha cap tasca de manteniment"); }

        else{
            Iterator<TascaManteniment> itrTasca = llistaTasquesManteniment.iterator();
            while(itrTasca.hasNext()){

                TascaManteniment actual = itrTasca.next();
                resultat += actual.toString();
                resultat += "\n";
            }
        }
        return resultat;
    }



    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     *
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */
    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for(int i = 0; i < llistaTasquesManteniment.size(); i++) {
            if(llistaTasquesManteniment.get(i).getNum() == num)
                return llistaTasquesManteniment.get(i);
        };
        throw new ExcepcioCamping("No existeix cap tasca amb el número: " + num);
    }
}
