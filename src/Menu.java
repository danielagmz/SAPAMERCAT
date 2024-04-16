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
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            //todo
            switch (opcio){
                case 1:
                    submenu();
                break;

                case 0:
                    System.out.println("Hasta pronto!");
                break;
            }

        } while (opcio!=0);

    }

    static void submenu(){
        Producte product;
        int opcio;
        int input;
        String nom;
        String dataCaducitat;
        float preu;
        int codiB;

        do {
            System.out.println("--------------");
            System.out.println("-- PRODUCTE --");
            System.out.println("--------------");
            System.out.println("1) Alimentacio");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electronica");
            System.out.println("0) Tornar");

            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            switch (opcio){
                //todo comprobaciones
                case 1:
                    System.out.println("Afergir aliment");
                    System.out.print("Nom producte: ");
                    nom=scan.next().trim();

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

                    //region mostrar lista para ver si funciona
                    for (Integer item : Carrito.lista.keySet()) {
                        System.out.println(item+"="+Carrito.lista.get(item));
                    }
                    //endregion
                    break;
                case 0:
                    menuPrincipal();
                    break;
            }
        } while (opcio!=0);


    }
//
























}
