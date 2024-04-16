import java.util.HashMap;

public class Carrito {
    private float total;
    private HashMap<String,Producte> lista;

    public Carrito(float total, HashMap<String, Producte> lista) {
        this.total = total;
        this.lista = lista;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public HashMap<String, Producte> getLista() {
        return lista;
    }

    public void setLista(HashMap<String, Producte> lista) {
        this.lista = lista;
    }
}
