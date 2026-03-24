package prog2.model;

import com.sun.source.doctree.SerialDataTree;

import java.io.Serializable;

public class TascaManteniment implements InTascaManteniment, Serializable {
    private int num_, dies_;
    private Allotjament allotjament_;
    private String data_;
    public static enum TipusTascaManteniment { Reparacio, Neteja, RevisioTecnica, Desinfeccio };
    private TipusTascaManteniment tipus_;

    public TascaManteniment(int num_, TipusTascaManteniment tipus_, Allotjament allotjament_, String data_, int dies_) {
        this.num_ = num_;
        this.tipus_ = tipus_;
        this.allotjament_ = allotjament_;
        this.data_ = data_;
        this.dies_ = dies_;
    }


    @Override
    public String toString(){

        String id = allotjament_.getId();

        // Passem l'enum a string així:
        String tipus = tipus_.name();

        return "Número: " + num_ + ", Tipus: " + tipus + ", ID Allotjament: " + id +
                ", Data: " + data_ + ", Dies: " + dies_;

    }
    /**
     * Retorna el número identificador de la tasca.
     *
     * @return int
     */
    @Override
    public int getNum() {
        return num_;
    }

    /**
     * Retorna el tipus de tasca de manteniment.
     *
     * @return TipusTascaManteniment
     */
    @Override
    public TipusTascaManteniment getTipus() {
        return tipus_;
    }

    /**
     * Retorna l'allotjament associat a la tasca.
     *
     * @return Allotjament
     */
    @Override
    public Allotjament getAllotjament() {
        return allotjament_;
    }

    /**
     * Retorna la data de registre de la tasca.
     *
     * @return String
     */
    @Override
    public String getData() {
        return data_;
    }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     *
     * @return int
     */
    @Override
    public int getDies() {
        return dies_;
    }

    /**
     * Assigna un nou número identificador a la tasca.
     *
     * @param num_ Número identificador de la tasca.
     */
    @Override
    public void setNum(int num_) {
        this.num_ = num_;
    }

    /**
     * Assigna el tipus de tasca de manteniment.
     *
     * @param tipus_ Tipus de tasca.
     */
    @Override
    public void setTipus(TipusTascaManteniment tipus_) {
        this.tipus_ = tipus_;
    }

    /**
     * Assigna l'allotjament associat a la tasca.
     *
     * @param allotjament_ Allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this.allotjament_ = allotjament_;
    }

    /**
     * Assigna la data de registre de la tasca.
     *
     * @param data_ Data de la tasca.
     */
    @Override
    public void setData(String data_) {
        this.data_ = data_;
    }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     *
     * @param dies_ Nombre de dies.
     */
    @Override
    public void setDies(int dies_) {
        this.dies_ = dies_;
    }

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     *
     * @return String amb el percentatge d'il·luminació.
     */
    @Override
    public String getIluminacioAllotjament() {
        switch (tipus_) {
            case Reparacio, RevisioTecnica:
                return "50%";
            case Neteja:
                return "100%";
            case Desinfeccio:
                return "0%";
            default:
                throw new IllegalStateException("ERROR: " + tipus_);
        }
    }
}
