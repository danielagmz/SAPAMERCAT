/**
 * Clase principal del proyecto que inicializa el programa
 */
public class Main {
    public static void main(final String[] args) {
        // Dar la bienvenida solo cuando se inicia el programa
        System.out.println("BENVINGUT AL SAPAMERCAT");
        // registro de excepciones que puedan surgir y no esten tratadas dentro de la aplicacion
        try {
            Menu.menuPrincipal();
        } catch (Exception e) {
            Menu.guardarExcepcio(e.toString());
        }
    }
}
