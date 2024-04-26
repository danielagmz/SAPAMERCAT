import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Carrito {

    private static Map<String,Integer> carretLista=new HashMap<>();

    public static void mostrarCarret(){
        quantificarProductes();

//        for (String item : carretLista.keySet()) {
//            System.out.printf("%s -> %d\n",Compra.obtenirNom(item),carretLista.get(item));
//        }
        carretLista.forEach((key,item) -> System.out.printf("%s -> %d\n",Compra.obtenirNom(key),carretLista.get(key)));
    }
    private static void quantificarProductes(){

        carretLista= Compra.getLista().stream()
                .collect(Collectors.groupingBy(Producte::getCodi,Collectors.summingInt(p -> 1)));
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
    }

    public static void limpiarCarrito(){
        carretLista.clear();
        Compra.vaciarCompra();
    }

    public static void generarTicket(){
        LocalDate data= LocalDate.now();
        float total=0;

        quantificarProductes();
        System.out.println("-------------------------------");
        System.out.println("          SAPAMERCAT           ");
        System.out.println("-------------------------------");
        System.out.println("Data: "+data);
        System.out.println("-------------------------------");

        carretLista.forEach(
            (key,item) -> System.out.printf("%-15s %-3d %3.2f€ %3.2f€\n",
                    Compra.obtenirNom(key),
                    carretLista.get(key),
                    Compra.obtenirPreu(key),
                    carretLista.get(key)*Compra.obtenirPreu(key)
            )
        );

        System.out.println("-------------------------------");
        for (String key : carretLista.keySet()) {
            total+=carretLista.get(key)*Compra.obtenirPreu(key);
        }
        System.out.printf("Total: %.2f€",total);
    }

}
