import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * superclase
 */
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

    /**
     * funcion para comprobar que el nombre sea valido
     * @param nom nombre a comprobar
     * @return retorna true si es valido y false si no
     */
    public static boolean comprovarNom(String nom){
        return nom.length() <= 15;
    }

    /**
     * funcion que se encarga de preguntar el nombre hasta que sea valido
     * @param scan scan para leer l'input
     * @return el nombre correcto para pasarlo al constructor
     */
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

    /**
     * funcion que se encarga de pedir el precio hasta que se valido
     * @param scan scaner para leer el input
     * @return retorna el precio listo para pasarlo al constructor
     */
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
