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


    public static String obtenirNom(String codiBarres){
        String nombre;
        nombre = lista.stream().filter(e -> e.getCodi().equals(codiBarres))
                .map(Producte::getNom).findFirst().orElse("");
        return nombre;
    }
    public static Float obtenirPreu(String codiBarres){
        Float preu;
        preu = lista.stream().filter(e -> e.getCodi().equals(codiBarres))
                .map(Producte::getPreu).findFirst().orElse(0F);
        return preu;
    }
    public static void vaciarCompra(){
        lista.clear();
    }

    public static void eliminarTextils(){
        lista.removeIf(prod -> prod instanceof Textil);
    }

}
