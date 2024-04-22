import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrito {

    private static Map<String,Integer> carretLista=new HashMap<>();


    private static void quantificarProductes(){
        int qtAntigua;
        //todo esto no comprueba el codigo, solo el nombre
        for (Producte producte : Compra.lista) {

            if (!(carretLista.containsKey(producte.getNom()))) {
                carretLista.put(producte.getNom(), 1);
            }else {
                qtAntigua= carretLista.get(producte.getNom());
                carretLista.replace(producte.getNom(), qtAntigua+1);
            }
            qtAntigua=0;
        }
    }

    public static void mostrarCarret(){
        for (String item : carretLista.keySet()) {
            System.out.printf("%s -> %d\n",item,carretLista.get(item));
        }
    }
}
