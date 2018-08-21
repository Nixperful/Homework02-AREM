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
        get("/media", (req, res) -> ("<!DOCTYPE html>"+
                                    "<html>"+
                                    "<body>"+
                                    "<form action='/action_page.php'>"+
                                    "First name: <input type='text' name='FirstName' value='Mickey'><br>"+
                                    "Last name: <input type='text' name='LastName' value='Mouse'><br>"+
                                    "<input type='submit' value='Submit'>" +
                                    "</form>"+
                                    "<p>Click the 'Submit' button and the form-data will be sent to a page on the server called '/action_page.php'.</p>"+
                                    "</body>"+
                                    "</html>"));

    }

    static int getPort() {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
        }    
}