import presentacion.*;

public class PRUEBAS {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int entero=0;
    
      try {
        entero=Teclado.getInt();
        
      } catch (ValorInvalidoException e) {
        System.out.println("Intentelo de nuevo, el valor asignado por ahora es 0");
      
      }
    
    System.out.println("El entero es: "+ entero);
  }

}
