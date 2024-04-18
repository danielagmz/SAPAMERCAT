import java.util.HashMap;

public class Carrito {

    public static HashMap<Integer,Producte> lista=new HashMap<>();

    public static void inserirProducte(Producte producte){

        // hasmap para facilitar la busqueda y manipulacion de los productos
        lista.put(producte.codi,producte);
        if (lista.containsKey(producte.codi)){
            //todo comprobar si el producto es una instancia de E,T,A y concatenar el codi
        }
    }

    public static void mostrarCarret(){
        for (Integer items : lista.keySet()) {
            System.out.println();
        }
    }
}
