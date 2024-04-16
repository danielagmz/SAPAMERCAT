import megaLibreria.utilities;

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
                break;
            }

        } while (opcio!=0);

    }

    static void submenu(){
        int opcio;
        int input;




        System.out.println("--------------");
        System.out.println("-- PRODUCTE --");
        System.out.println("--------------");
        System.out.println("1) Alimentacio");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electronica");
        System.out.println("0) Tornar");



        do {
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);
            switch (opcio){
                case 1:
                    System.out.println("Afergir aliment");
                    introduirAlimentacio();
                    break;
                case 0:
                    menuPrincipal();
                    break;
            }
        } while (opcio!=0);


    }
    static Alimentacio introduirAlimentacio(){




        new Alimentacio()

        return
    }
























}
