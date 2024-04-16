import java.util.HashMap;

public class Carrito {

    public static HashMap<Integer,Producte> lista=new HashMap<>();

    public static void inserirProducte(Producte producte){
        // hasmap para facilitar la busqueda y manipulacion de los productos
        lista.put(producte.codi,producte);
    }
}
