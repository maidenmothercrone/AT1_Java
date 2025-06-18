public enum TipDepozit {
    O_LUNA(30,2), DOUA_LUNI(60,4), TREI_LUNI(90,4), UN_AN(365,5);
    private int durata;
    private double rataDobanzii;

    TipDepozit(int durata, double rataDobanzii) {
        this.durata = durata;
        this.rataDobanzii = rataDobanzii;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public double getRataDobanzii() {
        return rataDobanzii;
    }

    public void setRataDobanzii(double rataDobanzii) {
        this.rataDobanzii = rataDobanzii;
    }
}
