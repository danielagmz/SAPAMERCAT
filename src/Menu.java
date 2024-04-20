import megaLibreria.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);

    public static void menuPrincipal(){
        int opcio;

        System.out.println("-----------");
        System.out.println("-- INICI --");
        System.out.println("-----------");
        System.out.println("1) Introduir producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) acabar");



        do {
            System.out.print("> ");
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            //todo
            switch (opcio){
                case 1:
                    submenu();
                break;
                case 3:
                    Carrito.mostrarCarret();
                    break;

                case 0:
                    System.out.println("Fins aviat!");
                break;
            }

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
            Carrito.inserirProducte(new Textil(preu,nom,codiB,comp));
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
            Carrito.inserirProducte(new Alimentacio(preu,nom,codiB,dataCaducitat));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    private static void introduirElectronica(){
        String nom;
        int garantia;
        float preu;
        int codiB;


        System.out.print("Nom producte: ");
        nom=scan.nextLine();

        System.out.print("Preu: ");
        preu=scan.nextFloat();
        scan.nextLine();

        System.out.print("Garantia (dies): ");
        garantia=scan.nextInt();
        scan.nextLine();

        System.out.print("Codi de barres: ");
        codiB=scan.nextInt();
        scan.nextLine();


        try {
            Carrito.inserirProducte(new Electronica(preu,nom,codiB,garantia));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }























}
