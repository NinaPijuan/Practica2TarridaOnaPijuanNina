package prog2.model;


import prog2.model.InAllotjament;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;
    private boolean operatiu;
    private String iluminacio;


    /**
     * Constructor amb paràmetres
     */
    public Allotjament(String nom, String id, long tempsMinAlta, long tempsMinBaixa, boolean operatiu, String iluminacio) {
        this.nom = nom;
        this.id = id;
        setEstadaMinima(tempsMinAlta, tempsMinBaixa);
        this.iluminacio = iluminacio;
        this.operatiu = operatiu;
    }


    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    public String getNom() {return nom;}

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    public String getId() { return id; }

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id l'identificador a assignar.
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    public long getEstadaMinima(InAllotjament.Temp temp){
        switch (temp){
            case ALTA: return this.estadaMinimaALTA_;
            case BAIXA: return this.estadaMinimaBAIXA_;
            default: return 0; // Per si de cas
        }
    }



    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
    }

    /**
     * Comprova si l'allotjament funciona correctament.
     * La implementació dependrà dels criteris específics de cada tipus d'allotjament.
     * @return true si l'allotjament funciona correctament, false altrament.
     */
    public abstract boolean correcteFuncionament();

    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA_ + ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }

}
