import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {
    private static List<Producte> compraLista=new ArrayList<>();
    private static Map<String,Integer> carretLista=new HashMap<>();


    public static void inserirProducte(Producte producte){
        int qtAntigua;
        compraLista.add(producte);
        //todo aqui tengo que de alguna manera mirar que si hay repetidos sea por el codigo de barras y no por el nombre
        // hay que implementar una funcion que busque el nombre del producto por codigo de barras, quiza
        // usar esa para que en funciojn del codigo de barras añada el nombre al hasmap


        if (!(carretLista.containsKey(producte.getNom()))) {
            carretLista.put(producte.getNom(), 1);
        }else {
            qtAntigua= carretLista.get(producte.getNom());
            carretLista.replace(producte.getNom(), qtAntigua+1);
        }


    }

    public static void mostrarCarret(){
        for (String item : carretLista.keySet()) {
            System.out.printf("%s -> %d\n",item,carretLista.get(item));
        }
    }
}
