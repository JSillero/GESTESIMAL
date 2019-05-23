import java.util.ArrayList;

import negocio.Almacen;
import negocio.Articulo;
import presentacion.Menu;
import presentacion.Teclado;
import presentacion.ValorInvalidoException;

public class Test {

  public static void main(String[] args) {
    int respuesta=0;
    Almacen almacen = new Almacen();
    
    while(respuesta!=5) {
      String[] opciones= {"Listar","Agregar","Eliminar","Modificar"};
      Menu menu = new Menu("GESTESIMAL", opciones );
      respuesta=menu.mostrar_pedir();
    
      switch(respuesta) {
      
      case(1):
      int respuesta2=0;
      String[] opciones2= {"Listar la lista entera","Listar un articulo"};
      Menu menu2 = new Menu("Listar", opciones2 );
      respuesta2=menu2.mostrar_pedir();
        switch(respuesta2) {
        case(1):
          System.out.println(almacen);
        break;
        case(2):
          
          int codigo=-1;
          while(codigo==-1) {
            try {
              codigo=Teclado.getInt("Introduce el codigo del articulo a listar: ");
            } catch (ValorInvalidoException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          }
          System.out.println(almacen.mostrarArticulo(codigo));
        
        break;
        default:
        break;
        
        }
        
      break;
      case(2):
        int cod=-1;
      
        while(cod==-1) {
         
          
          try {
          
            cod = Teclado.getInt("Introduzca el codigo de producto");
          } catch (ValorInvalidoException e) {
           
        }
        }
        
        double precc=-1;
        while(precc==-1) {
        try {
          while (precc==-1)
          precc = Teclado.getDecimal("Introduzca el precio de compra");
        } catch (ValorInvalidoException e) {
         
        }
        }
        
        double precv=-1;
        while(precv==-1) {
        try {
          while (precv==-1)
          precv = Teclado.getDecimal("Introduzca el precio de venta");
        } catch (ValorInvalidoException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        }
        
        int stock=-1;
        while (stock<1) {
        try {
          
          stock = Teclado.getInt("Introduzca el stock del producto");
        } catch (ValorInvalidoException e) {
          
        }
        }
        String desc="";
        try {
          desc = Teclado.getString("Introduzca la descripcion del producto");
        } catch (ValorInvalidoException e) {
         System.err.println("Descripcion invalida, introduzca una nueva usando la opcion 4.Modificar");
        }
        almacen.altaArticulo(cod, precc, precv, stock, desc);
        almacen.mostrarArticulo(cod);
      break;  
        
      
      
      }
    }
  }

}
