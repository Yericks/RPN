package calculadorapolaca;

public class Historial{
  /*La clase Historial es la encargada de guardar los datos para luego ingresarlos al texto correspondiente.
   *
   */
  	Pila historial = new Pila();

    public void Historial(String dato, double valor){

 		 historial.agregar(dato, valor); //Agregar datos a la pila.

    }
  public int getTamanio(){ /*<p> obtener el tamanio de la pila que se crea cuando el usuario ingresa los datos.</p>
                            *
                            */
    return historial.getTamanio();
  }

  public String getDato(){ /* obtener datos del historial.
                            */
    return historial.getDato();
  }

  public void  historial(){ /* Listar historial.
                            */
    historial.listar();

  }

  public String getNext(){ /* Con esto obtendremos los datos del nodo asi mismo cambiaremos al siguiente nodo.
                            */
    Nodo auxiliar = historial.getCima();
    return auxiliar.link.dato;
  }

   public Nodo getCima(){ /*accesso al nodo de la pila.
                           */
  	return historial.getCima();
  }

  public Pila getHistorial(){ //accesso al nodo de la pila.
  	return historial.getPila();
  }
}
