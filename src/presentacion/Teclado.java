/**
 * La clase teclado se encarga de pedir diferentes tipos de valores y asegurar que son 
 * los que queremos, devolver un error(valorNoValidoException).
 *   cuando no sea
 * @author d18sisaj
 *
 */
package presentacion;
import java.util.Scanner;
public class Teclado {
  static Scanner s = new Scanner(System.in);
   
  /**
   * Lee cadenas
   * @return
   * @throws ValorInvalidoException 
   */
  public static String getString() throws ValorInvalidoException {
    String cadena;
    try {
      cadena=s.nextLine();
    } catch (Exception e) {
      throw new ValorInvalidoException();

    }
    return cadena;
   
  }
  /**
   * Muestra un mensaje y lee una cadena
   * @return
   * @throws ValorInvalidoException 
   */
  public static String getString(String mensaje) throws ValorInvalidoException {
    System.out.println(mensaje);
    return getString();
   
  }
  /**
   * Lee enteros.
   * @return
   * @throws ValorInvalidoException 
   */
  public static int getInt() throws ValorInvalidoException {
    int number=0;
    while(true) {
      try {
        return number=Integer.parseInt(getString());
      }catch(Exception e) {
        throw new ValorInvalidoException();
      }
    }
    
  }
  /**
   * Muestra un mensaje y lee enteros
   * @param mensaje
   * @return
   * @throws ValorInvalidoException 
   */
  public static int getInt(String mensaje) throws ValorInvalidoException {
    System.out.println(mensaje);
    return getInt();
    
  }
  /**
   * Lee numeros con decimales.
   * @return
   * @throws ValorInvalidoException 
   */
  public static double getDecimal() throws ValorInvalidoException {
    double number;
    try {
      number=Double.parseDouble(getString());
    }catch(NumberFormatException e) {
      throw new ValorInvalidoException();
    }
    return number;
  }
  /**
   * Muestra un mensaje y lee numeros decimales
   * @param mensaje
   * @return
   * @throws ValorInvalidoException 
   */
  public static double getDecimal(String mensaje) throws ValorInvalidoException {
    System.out.println(mensaje);
    return getDecimal();
  }
  
  public static double getCaracter() throws ValorInvalidoException {
    char cha;
    String cadena;
    cadena=getString();
    if(cadena.length()!=1)
      throw new ValorInvalidoException();
    cha=cadena.charAt(0);
    
    return cha;
  }
  
  public static double getCaracter(String mensaje) throws ValorInvalidoException {
    System.out.println(mensaje);  
    return getCaracter();
  }
  
}
