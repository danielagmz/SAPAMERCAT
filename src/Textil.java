public class Textil extends Producte {
    private String composicio;

    public Textil(int preu, String nom, String codi, String composicio) {
        super(preu, nom, codi);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }
}