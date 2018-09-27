package calculadorapolaca;
import java.util.StringTokenizer;

public class RealizarOperacion {
 /**
   Al ingresar a separar se recive la cadena de caracteres completa.
     * @param texto
     * @return resutadoenteros
 **/   
    
  public Double separar(String texto){
    Historial historial = new Historial(); // Instanciamos un historial.
	Pila lista = new Pila(); // Instanciamos una pila para poder ingresar los datos de tipo texto.
    Pila pila = new Pila(); // Instanciamos una pila nuevamente para poder ingresar los datos de tipo token.
    lista.agregar(texto, 0);
 
    double numero = 0;
    int countNumeros = 0;
    int countOperadores = 0;

   
    StringTokenizer st = new StringTokenizer(texto.toUpperCase()); // StringTokenizer va a separarnos el texto por tokens asi mismo to.UpperCasse
    //se encargara de que el texto ingresado sea mayusculas aunque el usuario las ingrese como minusculas.
    try{ // captura de exceptions para idenficar si el token es un operando o un numero.
    while (st.hasMoreElements()) { //While que recorre el texto completo para obtener todos los datos del usuario y separarlos un a uno.

      String token = st.nextElement().toString(); //Convertiremos los tokens a string.
       try { // captura de exceptions para idenficar si el token es un operando o un numero.
         
         numero = Double.parseDouble(token); //el string pasa a ser un double para poder realizar la operacion con numeros
         String numero1 = String.valueOf(numero);// luego lo convierte en string de nuevo para poder apilar el dato.
         pila.agregar(numero1, numero);
         
         countNumeros = countNumeros+1; // contamos los numeros para tener un control sobre ellos.
    } catch (NumberFormatException e){
          
        if (countNumeros != 0) { //Con esto nos aseguramos que el siguiente numero lo obtengamos sin tener que recorrer la lista nuevamente.
        numero = Double.parseDouble(pila.getDato());
          }
        pila.pop(); //extraemos el numero u operando de la pila y procedemos a realizar la operacion.
        double numeroaux = Double.parseDouble(pila.getDato());
        String resultado; 
         //Indentificamos el tipo de operador entrante y procedemos a realizar su debida operacion.
             switch (token){
                case "PLUS":    
                 resultado = String.valueOf(numero + numeroaux); 
                 pila.pop(); // eliminamos el dato que actuamelte tenemos en la pila y agregamos el nuevo dato.
                 pila.agregar(resultado, (numero + numeroaux));
                 numero = Double.parseDouble(resultado);
                 countOperadores++; //contamos los operadores para tener un control de ellos.
                break;
                case "LESS": 
                 resultado = String.valueOf(numeroaux - numero);
                 pila.pop(); // eliminamos el dato que actuamelte tenemos en la pila y agregamos el nuevo dato.
                 pila.agregar(resultado, (numeroaux - numero));
                 numero = Double.parseDouble(pila.getDato());
                 countOperadores++;
                break;
                case "DIVIDE":
                 resultado = String.valueOf(numeroaux / numero);
                 pila.pop(); // eliminamos el dato que actuamelte tenemos en la pila y agregamos el nuevo dato.
                 pila.agregar(resultado, (numeroaux / numero));
                 countOperadores++;
                break;
                case "TIMES": 
                 resultado = String.valueOf(numeroaux * numero);
                 pila.pop(); /* eliminamos el dato que actuamelte tenemos en la pila y agregamos el nuevo dato.
                              */
                 pila.agregar(resultado, (numeroaux * numero));
                 countOperadores++;
                break;
                default: System.out.println("Operador " + token + " no encontrado en el registro." ); // mensaje de error para idenficar el dato inexistente.
                break;
         	} 
       
     	}
 
   } 
    if (countNumeros == countOperadores + 1){ //nos aseguramos que haya mas numeros que operadores para realizar la operacion.
    System.out.println("El Resultado de la operacion es"); //Cuando el resultado se optiene, lo vamos a apilar.
      
      	historial.Historial(pila.getDato(), pila.getValor()); // Utilizamos historial para guardar el nuevo dato ingresado en la pila.
      
       lista.agregar(pila.getDato(), pila.getValor()); 
      
		pila.listar(); //Desplegamos la pila.
      
      } else {System.out.println("Hay demasiados numeros para operar");}
      
      } catch (NullPointerException e){
      System.out.println("Usted ha ingresado demasiados Operadores");
    
  } catch (NumberFormatException e){
      System.out.println("Usted ha ingresado un operador invalido");
    }
    double resutadoenteros = Double.parseDouble(pila.getDato()); // pasamos el dato de la pila como un entero para devolverlo y poder ordernarlo.
    
  return resutadoenteros;
}
 
}
