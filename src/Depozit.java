import java.util.Date;
import java.util.Objects;

public class Depozit extends Cont implements OperatiuniDepozite{
    private TipDepozit tipDepozit;
    private int codContract;
    private Persoana imputernicit;

    public Depozit() {
    }

    public Depozit(TipDepozit tipDepozit, int codContract, Persoana imputernicit) {
        this.tipDepozit = tipDepozit;
        this.codContract = codContract;
        this.imputernicit = imputernicit;
    }

    public Depozit(Persoana titular, Date dataDeschidere, Moneda moneda, double valoare, String sucursala, TipDepozit tipDepozit, int codContract, Persoana imputernicit) {
        super(titular, dataDeschidere, moneda, valoare, sucursala);
        this.tipDepozit = tipDepozit;
        this.codContract = codContract;
        this.imputernicit = imputernicit;
    }

    public TipDepozit getTipDepozit() {
        return tipDepozit;
    }

    public void setTipDepozit(TipDepozit tipDepozit) {
        this.tipDepozit = tipDepozit;
    }

    public int getCodContract() {
        return codContract;
    }

    public void setCodContract(int codContract) {
        this.codContract = codContract;
    }

    public Persoana getImputernicit() {
        return imputernicit;
    }

    public void setImputernicit(Persoana imputernicit) {
        this.imputernicit = imputernicit;
    }

    @Override
    public String toString() {
        return "Depozit{" +
                "tipDepozit=" + tipDepozit +
                ", codContract=" + codContract +
                ", imputernicit=" + imputernicit +
                '}' +super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depozit depozit = (Depozit) o;
        return codContract == depozit.codContract;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codContract);
    }

    public double calculDobanda(){
        double dobandaLunara = ((tipDepozit.getRataDobanzii()*super.getSold())*100)/12;
        return dobandaLunara;
    }
}
