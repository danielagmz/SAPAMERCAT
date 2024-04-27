import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que gestiona el carrito
 */
public class Carrito {
    /**
     * Hashmap para cuantificar las unidades de cada uno de los productos
     */
    private static Map<String,Integer> carretLista=new HashMap<>();

    /**
     * Funcion encargada de mostrar el hashmap con los productos y la cantidad
     */
    public static void mostrarCarret(){
        // contar cuantos productos de cada uno tiene el arraylist de la compra y llenar el hashmap
        quantificarProductes();

        // codigo sin usar expresiones lambda para mostrar los productos y la cantidad que hay en la compra
//        for (String item : carretLista.keySet()) {
//            System.out.printf("%s -> %d\n",Compra.obtenirNom(item),carretLista.get(item));
//        }

        // codigo refactorizado para usar una exrpesion lambda
        carretLista.forEach((key,item) -> System.out.printf("%s -> %d\n",Compra.obtenirNom(key),carretLista.get(key)));
    }

    /**
     * Funcion encargada de actualizar los precios de Textil y llenar el hashmap con los productos y sus cantidades
     */
    private static void quantificarProductes(){
        // crear leer el archivo y almacenar los datos para usarlos posteriormente
        File update=new File("./updates/UpdateTextilPrices.dat");
        List<String[]> lineas=new ArrayList<>();
        String s;
        try {
            Scanner reader=new Scanner(update);
            while (reader.hasNext()){
                s=reader.nextLine().trim();
                lineas.add(s.split(";"));
            }
            reader.close();

        }catch (FileNotFoundException e){
            // eliminamos los productos textiles para que el programa siga funcionando
            // en caso de que no se puedan comprovar los precios
            Compra.eliminarTextils();
            System.out.println("No s'ha pogut comprovar el preu dels productes textils\n Si us plau consultar al personal");
        }
            // filtro las instancias de textil y compruebo si este producto especifico hay que actulizarlo o no
        Compra.getLista().stream().filter(p -> p instanceof Textil)
                .forEach(textil -> {
                        for (String[] linea : lineas) {
                            if (textil.getCodi().equals(linea[0])) {
                                textil.setPreu(Float.parseFloat(linea[1]));
                            }
                        }
                    }
                );
        // una vez actualizados los precios correspondientes, cuantifico y relleno el hashmap agrupando por codigo de barras

    // codigo inicial sin expresiones lambda
//        int qtAntigua;
//        for (Producte producte : Compra.lista) {
//
//            if (!(carretLista.containsKey(producte.getCodi()))) {
//                carretLista.put(producte.getCodi(), 1);
//            }else {
//                qtAntigua= carretLista.get(producte.getCodi());
//                carretLista.replace(producte.getCodi(), qtAntigua+1);
//            }
//            qtAntigua=0;
//        }
        // codigo refactorizado con expresiones lambda
        carretLista= Compra.getLista().stream()
                .collect(Collectors.groupingBy(Producte::getCodi,Collectors.summingInt(p -> 1)));

    }

    /**
     * Funcion encargada de vaciar tando la lista de la compra como el carrito con sus unidades
     */
    public static void limpiarCarrito(){
        carretLista.clear();
        Compra.vaciarCompra();
    }

    /**
     * Funcion encargada de gestionar el ticket y los calculos de precios finales que se mostraran
     */
    public static void generarTicket(){
        LocalDate data= LocalDate.now();
        float total=0;

        // noa aseguramos de que el carrito este lleno y los productos debidamente cuantificados
        quantificarProductes();

        System.out.println("----------------------------------");
        System.out.println("            SAPAMERCAT            ");
        System.out.println("----------------------------------");
        System.out.println("Data: "+data);
        System.out.println("----------------------------------");

        // Por cada uno de los productos que se encuentren en el hashmap
        // calcular el total en funcion del precio unitario y la cantidad
        carretLista.forEach(
            (key,item) -> System.out.printf("%-15s %-3d %4.2f€ %4.2f€\n",
                    Compra.obtenirNom(key),
                    carretLista.get(key),
                    Compra.obtenirPreu(key),
                    carretLista.get(key)*Compra.obtenirPreu(key)
            )
        );

        System.out.println("----------------------------------");
        // sumar el total del ticket
        for (String key : carretLista.keySet()) {
            total+=carretLista.get(key)*Compra.obtenirPreu(key);
        }
        System.out.printf("Total: %.2f€",total);
    }

}
