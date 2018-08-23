package co.edu.escuelaing.arem.designprimer;
import static spark.Spark.*;

/**
 * Programa implementado con listas encadenadas para obtener datos estadisticos.
 * @author Nicolás Osorio
 * @version 1.0
 */
public class CalculadorEstadistico {

    /** Metodo principal en el cual al final se muestra al usuario la información.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        
        DataRecollector a = new DataRecollector();
        MyLinkedList data= a.readTxt("datos.txt");
        DataOperator op = new DataOperator(data);
        float mean=op.meanCalculator();
        System.out.println("LA MEDIA ES DE:");
        System.out.println(mean);
        System.out.println("LA DESVIACIÓN ESTANDARD ES DE:");
        System.out.println(op.standartDeviationCalculator(mean));
        get("/input", (req, res) -> ("<!DOCTYPE html>"+
                                    "<html>"+
                                    "<body>"+
                                    "<form action='/calculadorEstadistico/'>"+
                                    "<p>Bandeja de entrada de los números:</p>"+
                                    "<input type='text' name='Data' value=''><br>"+
                                    "<input type='submit' value='Procesar'>" +
                                    "</form>"+
                                    "</body>"+
                                    "</html>"));
        
        get("/calculadorEstadistico/:data", (request, response) -> {
            return "SOLUCIÓN:" + request.params(":data");
        });
        

    }

    static int getPort() {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
        }    
}