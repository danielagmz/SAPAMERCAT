import megaLibreria.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * clase que gestiona las diferentes pantallas que ve el usuario
 */
public class Menu {
    /**
     * instanciacion del scanner para leer inputs
     */
    static Scanner scan = new Scanner(System.in);
    /**
     * lista para guardar todas las excepciones producidas
     */
   static List<String> excepciones=new ArrayList<>();

    /**
     * Funcion que se encarga de gestionar las acciones principales del programa
     */
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
            // funcion que se encarga de preguntar el numero enterio hasta que este en un rango valido
            opcio= utilities.introducirNumeroEntero(scan, 3, 0, false);

            switch (opcio){
                case 1:
                    submenu();
                break;
                case 2:
                    Carrito.generarTicket();
                    Carrito.limpiarCarrito();
                    System.out.println();
                    System.out.println("\nGracies per la seva compra!");
                    // registrar excepciones durante la ejecucion en el archivo correspondiente
                    registrarExcepcions();
                break;
                case 3:
                    Carrito.mostrarCarret();
                    break;
                case 0:
                    System.exit(1);
                    System.out.println("Fins aviat!");
                break;
            }
            System.out.println();
        } while (true);


    }

    /**
     * funcion que gestiona la introduccion de productos en el programa
     */
    public static void submenu(){
        int opcio;

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


        nom=Producte.introducirNom(scan);
        preu=Producte.introducirPreu(scan);
        System.out.print("Composicio: ");
        comp=scan.nextLine();
        codiB=Textil.introducirCodi(scan);

        try {
            Compra.inserirProducte(new Textil(preu,nom,"T"+codiB,comp));
        }catch (Exception e){
            guardarExcepcio(e.toString());
        }

    }

    private static void introduirAlimentacio(){
        String nom;
        String dataCaducitat;
        float preu;
        int codiB;


        nom=Producte.introducirNom(scan);
        preu=Producte.introducirPreu(scan);
        codiB=utilities.introducirNumeroEntero(scan,"Codi no valid","Codi de Barres: ");
        dataCaducitat=Alimentacio.introducirDataCaducitat(scan);

        try {
            Compra.inserirProducte(new Alimentacio(preu,nom,"A"+codiB,dataCaducitat));
        }catch (Exception e){
            guardarExcepcio(e.toString());
        }

    }
    private static void introduirElectronica(){
        String nom;
        int garantia;
        float preu;
        int codiB;

        nom=Producte.introducirNom(scan);
        preu=Producte.introducirPreu(scan);
        garantia = utilities.introducirNumeroEntero(scan,"Garantia no valida","Garantia (dies): ");
        codiB = utilities.introducirNumeroEntero(scan,"Codi no valid","Codi de Barres: ");

        try {
            Compra.inserirProducte(new Electronica(preu, nom, "E" + codiB, garantia));
        } catch (Exception e) {
            guardarExcepcio(e.toString());
        }

}

    /**
     * Funcion que guarda todas las excepciones en un array que luego sera usado
     * para printarlas todas en el archivo Excepciones.dat
     * @param texto indica el texto de la excepcion
     */
    public static void guardarExcepcio(String texto){
        excepciones.add(texto);
    }

    /**
     * Funcion que se encarga de crear el archivo de excepciones
     * y recorrer el array pintando cada entrada en una linea diferente
     */
    public static void registrarExcepcions(){
    File exceptions=new File("./logs/Exceptions.dat");
    try {
        if (!exceptions.getParentFile().mkdirs() && !exceptions.getParentFile().exists()){
            throw new IOException("No se ha podido crear el directorio logs");
        }
        if (!exceptions.createNewFile() && !exceptions.exists()){
            throw new IOException("No se ha podido crear el archivo");
        }
        PrintStream writer =new PrintStream(exceptions);
        excepciones.forEach(writer::println);
        writer.close();
//  si por lo que sea el archivo no se puede encontrar o crear,
//  se imprime por pantalla un error pero las excepciones siguen guardadas internamente
//  hasta que se pueda solucionar el problema

    } catch (FileNotFoundException e) {
        System.out.println("El archivo de excepciones no existe");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    excepciones.clear();
}





















}
