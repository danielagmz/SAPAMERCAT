import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Carrito {

    private static Map<Integer,Integer> carretLista=new HashMap<>();

    public static void mostrarCarret(){
        quantificarProductes();

//        for (String item : carretLista.keySet()) {
//            System.out.printf("%s -> %d\n",item,carretLista.get(item));
//        }
        carretLista.forEach((key,item) -> System.out.printf("%s -> %d\n",Compra.obtenirNom(key),carretLista.get(key)));
    }
    private static void quantificarProductes(){

        carretLista= Compra.getLista().stream()
                .collect(Collectors.groupingBy(Producte::getCodi,Collectors.summingInt(p -> 1)));
//        int qtAntigua;
//        for (Producte producte : Compra.lista) {
//
//            if (!(carretLista.containsKey(producte.getNom()))) {
//                carretLista.put(producte.getNom(), 1);
//            }else {
//                qtAntigua= carretLista.get(producte.getNom());
//                carretLista.replace(producte.getNom(), qtAntigua+1);
//            }
//            qtAntigua=0;
//        }
    }

    public static void limpiarCarrito(){
        carretLista.clear();
    }

}
