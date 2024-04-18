import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Alimentacio extends Producte {
    private String dataCaducitat;

    public Alimentacio(float preu, String nom, int codi, String dataCaducitat) {
        super(preu, nom, codi);
        this.dataCaducitat = dataCaducitat;
    }
    /*ToDo probar si da bien el precio
    */
    public float getPreu() {
        LocalDate dataActual=LocalDate.now();
        String[] fecha =dataCaducitat.split("[/-]");
        int dia= Integer.parseInt(fecha[0]);
        int mes= Integer.parseInt(fecha[1]);
        int anio= Integer.parseInt(fecha[2]);

        LocalDate caduc = LocalDate.of(anio, mes, dia);
        long difDias= ChronoUnit.DAYS.between(caduc,dataActual);
        return  preu - (float)(preu*(1/(difDias+1)) + (preu * 0.1));
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
