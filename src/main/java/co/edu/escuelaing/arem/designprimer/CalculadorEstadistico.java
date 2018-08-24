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

        get("/input", (req, res) -> ("<!DOCTYPE html>"+
                                    "<html>"+
                                    "<body>"+
                                    "<p>Bandeja de entrada de los números:</p>"+
                                    "<form action='/output/'>"+
                                    "<input type='text' name='data'><br>"+
                                    "<input type='submit' value='Continue'>" +
                                    "</form>"+
                                    "</body>"+
                                    "</html>"));
       
        get("/output/", (request, response) -> {
            
            DataRecollector a = new DataRecollector();

            MyLinkedList data= a.readWebInfo((String)request.queryParams("data"));
            
            DataOperator op = new DataOperator(data);
           
            float mean=op.meanCalculator();
            return 
                    ("<!DOCTYPE html>"+
                        "<html>"+
                        "<body>"+
                        "<h2>Media Estadística: </h2>"+
                        mean+
                        "<h2>Desviación Estándard: </h2>"+
                        op.standartDeviationCalculator(mean)+
                        "</body>"+
                        "</html>");
        });
        

    }

    static int getPort() {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
        }    
}