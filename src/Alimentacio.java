import java.time.LocalDate;

public class Alimentacio extends Producte {
    private String dataCaducitat;

    public Alimentacio(float preu, String nom, int codi, String dataCaducitat) {
        super(preu, nom, codi);
        this.dataCaducitat = dataCaducitat;
    }
    /*ToDo probar si da bien el precio
    */
    public float getPreu() {
        //todo no dan los calculos y no entiendo por que
        int dataActual=LocalDate.now().getDayOfMonth();
        String[] fecha =dataCaducitat.split("[/-]");
        int dia= Integer.parseInt(fecha[0]);

        return (float) (preu - preu*(1/(dia-dataActual+1)) + (preu * 0.1));
    }

    public String getDataCaducitat() {
        return dataCaducitat;
    }
// ToDo verificar que este en el formato adecuado, quiza regular expresion
    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public String toString() {
        return String.format("Nom: %s,Preu: %.2f€,Caducitat: %s",nom,getPreu(),dataCaducitat);
    }
}
