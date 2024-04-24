public abstract class Producte implements Comparable<Producte> {
    protected float preu;
    protected String nom;
    protected int codi;

    public Producte(float preu, String nom, int codi) {
        this.preu = preu;
        this.nom = nom;
        this.codi = codi;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }
}
