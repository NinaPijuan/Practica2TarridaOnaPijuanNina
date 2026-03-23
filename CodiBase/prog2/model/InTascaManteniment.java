package prog2.model;

public interface InTascaManteniment {

    /**
     * Retorna el número identificador de la tasca.
     * @return int
     */
    int getNum();

    /**
     * Retorna el tipus de tasca de manteniment.
     * @return TipusTascaManteniment
     */
    TascaManteniment.TipusTascaManteniment getTipus();

    /**
     * Retorna l'allotjament associat a la tasca.
     * @return Allotjament
     */
    Allotjament getAllotjament();

    /**
     * Retorna la data de registre de la tasca.
     * @return String
     */
    String getData();

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     * @return int
     */
    int getDies();

    /**
     * Assigna un nou número identificador a la tasca.
     * @param num_ Número identificador de la tasca.
     */
    void setNum(int num_);

    /**
     * Assigna el tipus de tasca de manteniment.
     * @param tipus_ Tipus de tasca.
     */
    void setTipus(TascaManteniment.TipusTascaManteniment tipus_);

    /**
     * Assigna l'allotjament associat a la tasca.
     * @param allotjament_ Allotjament afectat.
     */
    void setAllotjament(Allotjament allotjament_);

    /**
     * Assigna la data de registre de la tasca.
     * @param data_ Data de la tasca.
     */
    void setData(String data_);

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     * @param dies_ Nombre de dies.
     */
    void setDies(int dies_);

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     * @return String amb el percentatge d'il·luminació.
     */
    String getIluminacioAllotjament();

}
