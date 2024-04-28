/**
 * Subclase Electronica
 */
public class Electronica extends Producte{
    /**
     * atributo para calcular el precio
     */
    private float diesGarantia;

    public Electronica(float preu, String nom, String codi, float diesGarantia) {
        super(preu, nom, codi);
        this.diesGarantia = diesGarantia;
    }

    /**
     * +
     * sobreescritura del getter de preu en la clase Producte
     * @return retorna el precio calculado a partir de una formula
     */
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

}

