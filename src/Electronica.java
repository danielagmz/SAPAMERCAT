public class Electronica extends Producte{
    private float diesGarantia;

    public Electronica(float preu, String nom, int codi, float diesGarantia) {
        super(preu, nom, codi);
        this.diesGarantia = diesGarantia;
    }

    public  float getPreu(){
        return (float) (preu + preu*(diesGarantia/365)*0.1);
    }

    public float getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    @Override
    public String toString() {
        return String.format("Nom: %s,Preu: %.2f€,Dies de garantia: %s",nom,getPreu(),diesGarantia);
    }

    @Override
    public int compareTo(Producte p) {
        Electronica prod=(Electronica) p;

        if (this.getCodi() > prod.getCodi()){
            return 1;
        }else if (this.getCodi() < prod.getCodi()){
            return -1;
        }
        return 0;
    }
}

