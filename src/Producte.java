import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Producte {
    protected float preu;
    protected String nom;
    protected String codi;

    public Producte(float preu, String nom, String codi) {
        this.preu = preu;
        this.nom = nom;
        this.codi = codi;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public static boolean comprovarNom(String nom){
        return nom.length() <= 15;
    }

    public static String introducirNom(Scanner scan){
        String nom;
        do {
            try {
                System.out.print("Nom producte: ");
                nom = scan.nextLine();
                if (!Producte.comprovarNom(nom)) {
                    throw new IllegalArgumentException("El nombre no puede tener mas de 15 caracteres");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                Menu.guardarExcepcio(e.toString());
                nom="";
            }
        }while (nom.isEmpty());

        return nom;
    }

    public static Float introducirPreu(Scanner scan){
        float preu;
        do {
            try {
                System.out.print("Preu: ");
                preu = scan.nextFloat();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Preu no valid");
                Menu.guardarExcepcio(e.toString()+": "+"Preu no valid");
                preu=0f;
                scan.nextLine();

            }
        } while (preu==0);
        return preu;
    }

}
