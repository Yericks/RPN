package calculadorapolaca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ordenamiento {
/**
 *
     * @param historial
 */
    public void ordenAscedente(Pila historial) {
        int size = historial.getTamanio();

        Nodo aux = historial.getCima();

        for (int i = 0; i < size; i++) {
            double resultadoActual = aux.resultado;
            Nodo auxMatch = aux.link;
            Nodo nodeMax = aux;
            for (int j = i+1; j < size; j++) {
                if (auxMatch == null) {
                    break;
                }
                double resultMatch = auxMatch.resultado;
                if (resultadoActual > resultMatch) {
                    resultadoActual = resultMatch;
                }
                auxMatch = auxMatch.link;
            }
            Nodo temporal = aux;
            temporal.resultado = aux.resultado;
            aux.resultado = nodeMax.resultado;
            nodeMax.resultado = temporal.resultado;

            aux = aux.link;
        }

        print(historial);
    }

    public void ordenDescendete(Pila historial) {
       double temp;
        int n = historial.getTamanio();

        Nodo aux = historial.getCima();
        for (int i = 0; i <= n-1; i++) {
            temp = aux.resultado;
            Nodo siguiente = aux.link;
            Nodo mayor = aux;
            for (int j = 1; j < n ; j++) {
                if (siguiente == null) {
                  break;
                }
                double verificador = siguiente.resultado;
                if (temp > verificador) {
                    mayor = siguiente;
                }
                 siguiente = siguiente.link;
            }
            Nodo temp2 = aux;
            aux.resultado = mayor.resultado;
            mayor.resultado = temp2.resultado;

            aux = aux.link;
        }
             print(historial);       
    }

    public void print(Pila historial) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("HistorialDeOperaciones.txt"); //inicion del documento de texto si no existe, lo crearemos y si existe
         	 //solo vamos a sobre-escribirlo.
            pw = new PrintWriter(fichero);
            Nodo temp = historial.getCima();
            System.out.println("");
            for (int i = 0; temp != null; i++) {
            System.out.println(temp.dato+ " = " + temp.resultado);
            pw.println(temp.dato+ " = " + temp.resultado); // Esta parte escribira en el documento dependiendo cual sea el ordenamiento.
            temp = temp.link;
            }
        System.out.println("");
        System.out.println("");

        } catch (IOException e) {
        } finally {
        	try {
    			// Nuevamente aprovechamos el finally para 
        		// asegurarnos que se cierra el fichero.
        		if (null != fichero)
        			fichero.close();
        	} catch (IOException e2) {
        	}
        }
    
    }
}
