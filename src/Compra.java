import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los productos que se introducen, con todos sus atributos
 */
public class Compra {
    /**
     * Lista de todos los productos con sus atributos particulares
     */
    public static List<Producte> lista=new ArrayList<>();

    /**
     * Funcion que se encarga de introducir un producto en la lista de la compra
     * @param producte producto a insertar
     */
    public static void inserirProducte(Producte producte){
        lista.add(producte);
    }

    /**
     * get lista para acceder a ella desde la clase carrito
     * @return retorna la lista
     */
    public static List<Producte> getLista() {
        return lista;
    }

    /**
     * funcion que se encarga de obtener el nombre de un producto
     * @param codiBarres codigo de barras que se buscara
     * @return retorna el nombre
     */

    public static String obtenirNom(String codiBarres){
        String nombre;
        nombre = lista.stream().filter(e -> e.getCodi().equals(codiBarres))
                .map(Producte::getNom).findFirst().orElse("");
        return nombre;
    }

    /**
     * funcion para obtener el precio de un producto a partir de un codigo
     * @param codiBarres codigo de busqueda
     * @return retorna el precio o 0 si no se encontro el producto
     */
    public static Float obtenirPreu(String codiBarres){
        Float preu;
        // filtra los productos por el codigo que tienen y crea una nueva lista con el producto que pasa el filtro
        // y obtiene su precio
        preu = lista.stream().filter(e -> e.getCodi().equals(codiBarres))
                .map(Producte::getPreu).findFirst().orElse(0F);
        return preu;
    }

    /**
     * Funcion que limpia la compra
     */
    public static void vaciarCompra(){
        lista.clear();
    }

    /**
     * Funcion que elimina los productos textiles
     */
    public static void eliminarTextils(){
        lista.removeIf(prod -> prod instanceof Textil);
    }

}
