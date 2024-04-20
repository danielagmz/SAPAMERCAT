public class Textil extends Producte implements Comparable<Textil> {
    private String composicio;

    public Textil(float preu, String nom, int codi, String composicio) {
        super(preu, nom, codi);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    @Override
    public String toString() {
        return String.format("Nom: %s,Preu: %.2f€,Composicio: %s",nom,preu,composicio);
    }

    public int compareTo(Textil prod) {
        return this.composicio.compareTo(prod.composicio);
    }
}
