import java.util.Date;
import java.util.Objects;

public class ContCurent extends Cont implements Operatiuni{
    private String codIban;

    public ContCurent(String codIban) {
        this.codIban = codIban;
    }

    public ContCurent(Persoana titular, Date dataDeschidere, Moneda moneda, double valoare, String sucursala, String codIban) {
        super(titular, dataDeschidere, moneda, valoare, sucursala);
        this.codIban = codIban;
    }

    public String getCodIban() {
        return codIban;
    }

    public void setCodIban(String codIban) {
        this.codIban = codIban;
    }

    @Override
    public String toString() {
        return "ContCurent{" +
                "codIban='" + codIban + '\'' +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContCurent that = (ContCurent) o;
        return Objects.equals(codIban, that.codIban);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codIban);
    }
}
