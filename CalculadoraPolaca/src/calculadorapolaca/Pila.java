
package calculadorapolaca;

public class Pila {
  private Nodo cima; // variable de tipo Nodo la cual llevara los datos del nodo y su link.
  private int tamanio; //para saber el tamanio de la pila.


  public Pila(){ //Constructor para inicializar una pila.
    cima = null; //datos del nodo inicio como nulo.
    tamanio = 0; //datos del tamanio inicio como 0.
  }

  public void agregar(String texto, double valor){ //agregaremos los datos a la pila.
    Nodo nodo =  new Nodo ();
    nodo.dato = texto;
    nodo.resultado = valor;
    nodo.link = cima;
    cima = nodo;
    tamanio++;
  }


  public Nodo pop(){ //Metodo para eliminar un dato de la pila.
    if(tamanio == 0){
      System.out.println("Numeros deben ser ingresados primero");
      return null;
    } else {
      Nodo nodo = cima;
      cima = cima.link;
      tamanio--;
      return nodo;
    }
    
    
  }

  public void listar(){ //Esta funcion sera utilizada para listar los datos existentes de la pila.
    Nodo auxiliar = cima;
    for(int i = 0; i< tamanio; i++){
      System.out.println(auxiliar.dato + " " + auxiliar.resultado);
      auxiliar = auxiliar.link;
    }
    System.out.println();
  }
  
    public String getDato(){ //accesso a los datos del nodo.
    return cima.dato;
  }
  
  
  public int getTamanio(){ //<p>accesso al tamanio de la pila.</p>
    return tamanio;
  }
  
  public Nodo getCima(){ //accesso al nodo de la pila.
  	return cima;
  }
  
  public double getValor(){ //accesso al nodo de la pila.
  	return cima.resultado;
  }
  
   public Pila getPila(){ //Esta funcion sera utilizada para listar los datos existentes de la pila.
    Pila auxpila = new Pila(); 
    Nodo auxiliar = cima;
    for(int i = 0; i< tamanio; i++){
      auxpila.agregar(auxiliar.dato, auxiliar.resultado);
      auxiliar = auxiliar.link;
    }
    return auxpila;
  }
  
}
