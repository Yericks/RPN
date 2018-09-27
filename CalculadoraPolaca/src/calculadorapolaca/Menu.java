/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorapolaca;

/**
 *
 * @author Asus
 */
/**
  Importe de librerias
 **/   
    
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Erick Garcia
 */
 class Menu {
public void menu(){
 /**
 * Aca vamos a c la clase Historial para poder dejar un historial en un documento de texto externo y la clase
 * RealizarOperacion que nos ayudara con la operacion matematica.
 */ 
	 Historial historial = new Historial(); 
  	 RealizarOperacion split = new RealizarOperacion();
  	 Ordenamiento ordenar = new Ordenamiento();
     /**
 	* La variable salir la dejaremos como falsa ya que nos servira para salir del bucle en el que nos encontramos trabajando.
 	* 
 	*/ 
		boolean salir = false;
    	 /**
		* Nustro menu se va a depender del "do" el cual finalizara siempre y cuando "Salir" sea verdadero.
		 * 
 		*/ 
      do{
        /**
 		* Nustro menu se va a depender del "do" el cual finalizara siempre y cuando "Salir" sea verdadero.
 		* 
        * Vamos a iniciar con 3 variables simples.
 		*/ 
        int opcion; //Esta sera la variable que vamos a utilizar para nuestro switch.
        String datos = null; //Esta sera la variable que vamos a utilizar para nuestro cadena de caracteres ingresada por el usuario.
        double resultado = 0;//Esta sera la variable que vamos a utilizar como string para cuando guardemos el resultado en nuestra pila e historial.
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("**********Bienvenidos**********");
        System.out.println("Por favor seleccione la opcion que deasea realizar:");
        System.out.println();
        System.out.println("1 - Ingresar Operacion");
        System.out.println("2 - Consular Historial en forma Ascendente");
        System.out.println("3 - Consular Historial en forma descendente");
        System.out.println("4 - Salir");
        try { opcion = reader.nextInt(); //Aca intentaremos leer la opcion que el cliente ha ingresado. Si es invalido
             //sustituimos el error InputMismatchException por un texto para hacerle saber al usuario sobre su error.
        reader.nextLine();

        switch(opcion){ //Aca inicializamos el switch con las opciones disponibles,
          case 1: 
            //Caso 1 El usuario ingresa la cadena que enviaremos a elvaluar a las clase RealizarOperacion.
            System.out.println("Ingrese su operacion");
            datos = reader.nextLine();
            //Aca enviamos la cadena de caracteres ingresada por el usuario a la clase RealizarOperacion y nos devuelve un string.
            resultado = split.separar(datos);
            //Con esto vamos a enviar la informacion a la clase Historial para que mantenga los datos que se envian.
            historial.Historial(datos + " Resultado ", resultado);
            break;
          case 2:
            //Case 2 vamos a imprimir el historial que tenemos hasta ahora.
            historial.historial();
            System.out.println("Historial en forma Ascendente");
            ordenar.ordenAscedente(historial.getHistorial());
          case 3:  
            System.out.println("Historial en forma Descentende");
            ordenar.ordenDescendete(historial.getHistorial());
            break;
           case 4: salir = true; // Lo unico que hacemos aca es cambiar el valor de 'Salir' ya que lo hacemos verdadero para terminar el programa.
            break;
          default: System.out.println("El numero ingresado es invalido, intente nuevamente");// Default por si el usuario ingresa un numero erroneo.
            break;
        }
       try {
      Thread.sleep(1000);//Con esto el sistema tiene un descanso en milisegundos por lo que espera un poco antes de volver a empezar.
			} catch (InterruptedException e) 
       {System.out.println("Tiempo de espera finalizado");}
		} catch ( InputMismatchException e){ System.out.println("Ustead ha ingresado un caracter invalido, intente nuevamente");}
       } while ( salir == false); //Fin del ciclo "do".
       
    } 
   }

