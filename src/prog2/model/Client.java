package prog2.model;

public class Client {
    private String nom;
    private String dni; // De 9 caràcters

    // Constructor
    public Client(String nom, String dni) {
        this.nom = nom;
        setDni(dni);
    }

    /**
     * Getter de nom
     * @return nom
     */
    public String getNom() { return nom; }

    /**
     * Getter de dni
     * @return dni
     */
    public String getDni() { return dni; }

    /**
     * Setter de nom
     * @param nom el nom del client
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Getter de dni
     * @param dni el dni del client
     */
    public void setDni(String dni) {
        if (dni.length() == 9){ this.dni = dni; }
        else { System.out.println("DNI no vàlid."); }
    }

    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    public String toString(){
        return nom + " amb DNI: " + dni + ". ";
    }
}

