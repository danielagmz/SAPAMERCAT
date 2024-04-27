import megaLibreria.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);

    public static void menuPrincipal(){
        int opcio;

        do {
            System.out.println("-----------");
            System.out.println("-- INICI --");
            System.out.println("-----------");
            System.out.println("1) Introduir producte");
            System.out.println("2) Passar per caixa");
            System.out.println("3) Mostrar carret de compra");
            System.out.println("0) acabar");

            System.out.print("> ");
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            //todo
            switch (opcio){
                case 1:
                    submenu();
                break;
                case 2:
                    Carrito.generarTicket();
                    Carrito.limpiarCarrito();
                    System.out.println();
                    System.out.println("\nGracies per la seva compra!");

                break;
                case 3:
                    Carrito.mostrarCarret();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                break;
            }
            System.out.println();
        } while (opcio!=0);

    }

    static void submenu(){
        int opcio;
        int input;

        do {
            System.out.println("--------------");
            System.out.println("-- PRODUCTE --");
            System.out.println("--------------");
            System.out.println("1) Alimentacio");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electronica");
            System.out.println("0) Tornar");

            System.out.print("> ");
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            switch (opcio){
                //todo comprobaciones
                case 1:
                    System.out.println("Afergir aliment");
                    introduirAlimentacio();
                    break;
                case 2:
                    System.out.println("Afegir Textil");
                    introduirTextil();
                    break;
                case 3:
                    System.out.println("Afegir electrònica");
                    introduirElectronica();
                    break;
                case 0:
                    menuPrincipal();
                    break;
            }
        } while (opcio!=0);
    }

    private static void introduirTextil() {
        String nom;
        String comp;
        float preu;
        int codiB;


        System.out.print("Nom producte: ");
        nom=scan.nextLine();

        System.out.print("Preu: ");
        preu=scan.nextFloat();
        scan.nextLine();

        System.out.print("Composicio: ");
        comp=scan.nextLine();

        System.out.print("Codi de barres: ");
        codiB=scan.nextInt();
        scan.nextLine();





        try {
            Compra.inserirProducte(new Textil(preu,nom,"T"+codiB,comp));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void introduirAlimentacio(){
        String nom;
        String dataCaducitat;
        float preu;
        int codiB;


        System.out.print("Nom producte: ");
        nom=scan.nextLine();

        System.out.print("Preu: ");
        preu=scan.nextFloat();
        scan.nextLine();
        System.out.print("Codi de barres: ");
        codiB=scan.nextInt();
        scan.nextLine();

        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        dataCaducitat=scan.nextLine();

        try {
            Compra.inserirProducte(new Alimentacio(preu,nom,"A"+codiB,dataCaducitat));
        }catch (Exception e){
            registrarExcepcio(e.toString());
        }

    }
    private static void introduirElectronica(){
        String nom;
        int garantia;
        float preu;
        int codiB;


    do {
        try {
            System.out.print("Nom producte: ");
            nom = scan.nextLine();
            if (!Producte.comprovarNom(nom)) {
                throw new IllegalArgumentException("El nombre no puede tener mas de 15 caracteres");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registrarExcepcio(e.toString());
            nom="";
        }
    }while (nom.isEmpty());

        do {
            try {
                System.out.print("Preu: ");
                preu = scan.nextFloat();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Preu no valid");
                registrarExcepcio(e.toString());
                preu=0;
                scan.nextLine();

            }
        } while (preu==0);

        garantia = utilities.introducirNumeroEntero(scan,"Garantia no valida","Garantia (dies): ");
        codiB = utilities.introducirNumeroEntero(scan,"Codi no valid","Codi de Barres: ");



        try {
            Compra.inserirProducte(new Electronica(preu, nom, "E" + codiB, garantia));
        } catch (Exception e) {
            registrarExcepcio(e.getMessage());
        }

}
public static void registrarExcepcio(String texto){
    File exceptions=new File("./logs/Exceptions.dat");
    List<String> excepcionesNoRegistradas=new ArrayList<>();
    try {
// todo por alguna razon no se crea el archivo
        if (!exceptions.createNewFile() && !exceptions.exists()){
            throw new IOException("No se ha podido crear el archivo");
        }

        PrintStream writer =new PrintStream(exceptions);
        writer.println(texto);
        writer.close();

    } catch (FileNotFoundException e) {
        System.out.println("El archivo de excepciones no existe");
        excepcionesNoRegistradas.add(texto);

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}






















}
