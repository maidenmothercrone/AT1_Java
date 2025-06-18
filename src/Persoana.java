import java.io.Serializable;
import java.util.Objects;

public class Persoana implements Serializable {
    private String nume;
    private long cnp;
    private Adresa adresa;

    public Persoana() {
    }

    public Persoana(String nume, long cnp, Adresa adresa) {
        this.nume = nume;
        this.cnp = cnp;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", cnp=" + cnp +
                ", adresa=" + adresa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return cnp == persoana.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnp);
    }

    public int compareTo(Persoana o) {
        return nume.compareTo(o.nume);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Persoana clona =(Persoana) super.clone();
        clona.setAdresa((Adresa) adresa.clone());
        return clona;
    }
}
