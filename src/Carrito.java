import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Carrito {
    Scanner scan = new Scanner(System.in);
    private static Map<String,Integer> carretLista=new HashMap<>();

    public static void mostrarCarret(){
        quantificarProductes();

//        for (String item : carretLista.keySet()) {
//            System.out.printf("%s -> %d\n",Compra.obtenirNom(item),carretLista.get(item));
//        }
        carretLista.forEach((key,item) -> System.out.printf("%s -> %d\n",Compra.obtenirNom(key),carretLista.get(key)));
    }
    private static void quantificarProductes(){
        File update=new File("./updates/UpdateTextilPrices.dat");
        List<String[]> lineas=new ArrayList<>();
        String s;
        try {
            Scanner reader=new Scanner(update);
            while (reader.hasNext()){
                s=reader.nextLine().trim();
                lineas.add(s.split(";"));
            }
            reader.close();

        }catch (FileNotFoundException e){
            Compra.eliminarTextils();
            System.out.println("No s'ha pogut comprovar el preu dels productes textils\n Si us plau consultar al personal");
        }

        Compra.getLista().stream().filter(p -> p instanceof Textil)
                .forEach(textil -> {
                        for (String[] linea : lineas) {
                            if (textil.getCodi().equals(linea[0])) {
                                textil.setPreu(Float.parseFloat(linea[1]));
                            }
                        }
                    }
                );

        carretLista= Compra.getLista().stream()
                .collect(Collectors.groupingBy(Producte::getCodi,Collectors.summingInt(p -> 1)));

//        int qtAntigua;
//        for (Producte producte : Compra.lista) {
//
//            if (!(carretLista.containsKey(producte.getCodi()))) {
//                carretLista.put(producte.getCodi(), 1);
//            }else {
//                qtAntigua= carretLista.get(producte.getCodi());
//                carretLista.replace(producte.getCodi(), qtAntigua+1);
//            }
//            qtAntigua=0;
//        }
    }

    public static void limpiarCarrito(){
        carretLista.clear();
        Compra.vaciarCompra();
    }

    public static void generarTicket(){
        LocalDate data= LocalDate.now();
        float total=0;

        quantificarProductes();

        System.out.println("----------------------------------");
        System.out.println("            SAPAMERCAT            ");
        System.out.println("----------------------------------");
        System.out.println("Data: "+data);
        System.out.println("----------------------------------");

        carretLista.forEach(
            (key,item) -> System.out.printf("%-15s %-3d %4.2f€ %4.2f€\n",
                    Compra.obtenirNom(key),
                    carretLista.get(key),
                    Compra.obtenirPreu(key),
                    carretLista.get(key)*Compra.obtenirPreu(key)
            )
        );

        System.out.println("----------------------------------");
        for (String key : carretLista.keySet()) {
            total+=carretLista.get(key)*Compra.obtenirPreu(key);
        }
        System.out.printf("Total: %.2f€",total);
    }

}
