import java.util.ArrayList;
import java.util.List;

public class Compra {
    public static List<Producte> lista=new ArrayList<>();

    public static void inserirProducte(Producte producte){
        lista.add(producte);
    }

    public static List<Producte> getLista() {
        return lista;
    }

//    todo problema gigante porque no me guarda el codigo de barras la lista
    public static String obtenirNom(int codiBarres){
        String nombre;
        nombre = lista.stream().filter(e -> e.getCodi()==codiBarres)
                .map(Producte::getNom).findFirst().orElse("");
        return nombre;
    }
    public static void vaciarCompra(){
        lista.clear();
        Carrito.limpiarCarrito();
    }

}
