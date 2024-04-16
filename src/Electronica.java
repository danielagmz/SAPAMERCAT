public class Electronica extends Producte{
    private float diesGarantia;

    public Electronica(int preu, String nom, String codi, float diesGarantia) {
        super(preu, nom, codi);
        this.diesGarantia = diesGarantia;
    }

    public float getDiesGarantia() {

        return (float) (preu + preu*(diesGarantia/365)*0.1);
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }
}
