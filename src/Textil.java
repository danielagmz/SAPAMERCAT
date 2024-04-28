import megaLibreria.utilities;

import java.util.List;
import java.util.Scanner;

public class Textil extends Producte implements Comparable<Textil> {
    private String composicio;

    public Textil(float preu, String nom, String codi, String composicio) {
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

    public int compareTo(Textil p) {
        return this.composicio.compareTo(p.composicio);
    }

    private static boolean comprobarCodi(int codi){
        return Compra.lista.stream()
                .filter(e -> e instanceof  Textil)
                .anyMatch(p->p.getCodi().equals("T"+codi));
    }

    public static int introducirCodi(Scanner scan){
        int codi;

        do {
            try {
                codi= utilities.introducirNumeroEntero(scan,"Codi no valid","Codi de Barres: ");

                if (comprobarCodi(codi)){
                    throw new IllegalArgumentException("Ya hay un producto Textil con este codigo");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                Menu.guardarExcepcio(e.toString());
                codi=-1;
            }
        } while (codi==-1);

        return codi;
    }
}
