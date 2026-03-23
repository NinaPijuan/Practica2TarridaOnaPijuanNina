package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;


    /**
     * Constructor amb paràmetres
     * @param allotjament
     * @param client
     * @param dataEntrada
     * @param dataSortida
     * @throws ExcepcioCamping
     */
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioCamping {
        if (dataEntrada == null || dataSortida == null)
            throw new ExcepcioCamping("Les dates de la reserva no poden ser null");

        if (!dataSortida.isAfter(dataEntrada))
            throw new ExcepcioCamping("La data de sortida no pot ser abans de la data d'entrada");

        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    /**
     * Getters d'allotjament reservat, client que reserva, i dates d'entrada i sortida
     */
    public Allotjament getAllotjament_() {return allotjament; }
    public Client getClient() {
        return client;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public LocalDate getDataSortida() {
        return dataSortida;
    }



    /**
     * Setters d'allotjament reservat, client que reserva, i dates d'entrada i sortida
     */
    public void setAllotjament_(Allotjament allotjament) { this.allotjament = allotjament; }
    public void setClient(Client client) { this.client = client; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }
    public void setDataSortida(LocalDate dataSortida) { this.dataSortida = dataSortida; }

}
