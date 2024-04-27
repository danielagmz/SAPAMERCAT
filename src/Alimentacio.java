import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * subclase alimentacio
 */
public class Alimentacio extends Producte{
    /**
     * atributo privado que se usa para calcular el precio
     */
    private String dataCaducitat;

    public Alimentacio(float preu, String nom, String codi, String dataCaducitat) {
        super(preu, nom, codi);
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * sobreescritura del precio de la clase Producto
     * @return retorna el precio a partir de una formula
     */
    public float getPreu() {
        LocalDate dataActual=LocalDate.now();
        String[] fecha =dataCaducitat.split("[/-]");
        int dia= Integer.parseInt(fecha[0]);
        int mes= Integer.parseInt(fecha[1]);
        int anio= Integer.parseInt(fecha[2]);

        LocalDate caduc = LocalDate.of(anio, mes, dia);
        long difDias= ChronoUnit.DAYS.between(caduc,dataActual);
        return  preu - (float)(preu*(1/(difDias+1)) + (preu * 0.1));
    }

    public String getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public String toString() {
        return String.format("Codi: %s,Nom: %s,Preu: %.2f€,Caducitat: %s",getCodi(),nom,getPreu(),dataCaducitat);
    }

    /**
     * Funcion encargada de gestionar las posibles excepciones al introducir una fecha de caducidad
     * @param scan scanner para leer el input
     * @return retorna la fecha comprovada para pasar al constructor
     */
    public static String introducirDataCaducitat(Scanner scan){
        String dataCaducitat;
        String[] fecha;
        int dia;
        int mes;
        int anio;

        do {

            try {
                System.out.print("Data de caducitat (dd/mm/aaaa): ");
                dataCaducitat=scan.nextLine();
                // expresion regular para comprobar que se introduzca un formato correcto
                if (!(dataCaducitat.matches("\\b[0-9]{1,2}[-/][0-9]{1,2}[/-]([0-9]{4}|[0-9]{2})\\b"))) {
                    throw new InputMismatchException("La data ha d'estar en format MM/DD/AAAA");
                }
                // comprobaciones de coherencia a nivel de mes, año y dia
                fecha=dataCaducitat.split("[/-]");

                if (fecha[0].length()==1){
                    fecha[0]="0"+fecha[0];
                }

                if (fecha[1].length()==1){
                    fecha[1]="0"+fecha[1];
                }
                if (fecha[2].length()==2){
                    fecha[2]="20"+fecha[2];
                }

                dia= Integer.parseInt(fecha[0]);
                mes= Integer.parseInt(fecha[1]);
                anio= Integer.parseInt(fecha[2]);


                if (mes > 12 || mes < 1){
                    throw new InputMismatchException("El mes no es correcto");
                }

                if (dia > diesMes(mes,anio) ){
                    throw new InputMismatchException("El dia no es correcto");
                }
                // asignamos un string format por si el usuario introduce una variacion de d/m/aa
                // que internamente salga en formato dd/mm/aaaa y evitar errores
                dataCaducitat= String.format("%s/%s/%s",fecha[0],fecha[1],fecha[2]);

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                Menu.guardarExcepcio(e.toString());
                dataCaducitat="";

            }catch (DateTimeParseException e2){
                System.out.println("la data no es valida");
                Menu.guardarExcepcio(e2.toString());
                dataCaducitat="";
            }

        }while (dataCaducitat.isEmpty());

        return dataCaducitat;
    }

    /**
     * Funcion que retorna los dias de un mes
     * @param mes mes a comprobar
     * @param any año para comprobar los años bisiestos
     * @return retorna los dias o -1 si el mes no es valido
     */
    private static int diesMes(int mes, int any) {
        if (mes >= 1 && mes <= 12) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
                return 31;
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
                return 30;
            else {
                if (any % 400 == 0 || (any % 4 == 0 && any % 100 != 0))
                    return 29;
                else
                    return 28;
            }
        } else {
            return -1;
        }
    }

}
