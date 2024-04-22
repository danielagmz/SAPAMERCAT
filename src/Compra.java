import java.util.ArrayList;
import java.util.List;

public class Compra {
    public static List<Producte> lista=new ArrayList<>();

    public static void inserirProducte(Producte producte){
        lista.add(producte);
    }

    public static String obtenirNom(int codiBarres){
        //todo que me obtenga el nombre con lamda expressions
        return "";
    }
}
