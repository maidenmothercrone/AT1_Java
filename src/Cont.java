import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public abstract class Cont {
    private Persoana titular;
    private Date dataDeschidere;
    private Moneda moneda;
    private double valoare;
    private String sucursala;
    private double sold;

    public Cont() {
    }

    public Cont(Persoana titular, Date dataDeschidere, Moneda moneda, double valoare, String sucursala) {
        this.titular = titular;
        this.dataDeschidere = dataDeschidere;
        this.moneda = moneda;
        this.valoare = valoare;
        this.sucursala = sucursala;

    }

    public Cont(double sold) {
        this.sold = sold;
    }


    public void depunereNumerar(double suma){
        if(suma>0){
            this.sold+=suma;
        } else {
            System.out.println("Suma depusa trebuie sa fie o valoare mai mare de 0.");
        }
    }

    public double getSold() {
        return sold;
    }

    public Persoana getTitular() {
        return titular;
    }

    public void setTitular(Persoana titular) {
        this.titular = titular;
    }

    public Date getDataDeschidere() {
        return dataDeschidere;
    }

    public void setDataDeschidere(Date dataDeschidere) {
        this.dataDeschidere = dataDeschidere;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public String getSucursala() {
        return sucursala;
    }

    public void setSucursala(String sucursala) {
        this.sucursala = sucursala;
    }

    @Override
    public String toString() {
        return "Cont{" +
                "titular=" + titular +
                ", dataDeschidere=" + dataDeschidere +
                ", moneda=" + moneda +
                ", valoare=" + valoare +
                ", sucursala='" + sucursala + '\'' +
                '}';
    }

    public int compareTo(Date anotherDate) {
        return dataDeschidere.compareTo(anotherDate);
    }
}
