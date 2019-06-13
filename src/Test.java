

import negocio.Almacen;
import negocio.CodigoNoExiste;
import negocio.StockInvalidoException;
import presentacion.Menu;
import presentacion.Teclado;
import presentacion.ValorInvalidoException;

public class Test {
  static Almacen almacen = new Almacen();
  public static void main(String[] args)  {
    int respuesta=0;
    
    while(respuesta!=5) {
      String[] opciones= {"Listar","Agregar","Eliminar","Modificar"};
      Menu menu = new Menu("GESTESIMAL", opciones );
      respuesta=menu.mostrar_pedir();
    
      switch(respuesta) {
      
        case(1):
          listar();
          
        
        break;
        case(2):
          try {
            agregar();
          } catch (ValorInvalidoException e2) {
            System.err.println("Uno de los valores introducidos no es valido, intentelo de nuevo");
          }
      break; 
      
      case(3):
        eliminar();
      break;
      
      case(4):
        modificar();
      break;
      
      default:
      
      break;
      
      }  
    }
  }
  private static void modificar() {
    if(almacen.estaVacio()) {
      System.out.println("El almacen esta vacio no hay nada que modificar");
      return;
    }
    boolean valido=false;
    int codigo2=-1;
    int indice=-1;
    
    do {
      codigo2=-1;
      indice=-1;
      while (codigo2==-1) {
        try {
          codigo2=Teclado.getInt("Introduzca el codigo del articulo a modificar: ");
        } catch (ValorInvalidoException e) {
          System.err.println("Codigo no valido.");
        }
      }
      try {
        indice = almacen.getIndex(codigo2);
        valido=true;
      } catch (CodigoNoExiste e1) {
       System.err.println("El codigo introducido no existe");
      }
    }while(!valido);
      
    
    int respuesta3=0;
    String[] opciones3= {"Modificar Stock","Precio Compra","Precio Venta","Descripcion","IVA"};
    Menu menu3 = new Menu("Valor a modificar", opciones3 );
    respuesta3=menu3.mostrar_pedir();
    
    switch(respuesta3) {
      case(1)://STOCK
        int cantidad=-1;
        while (cantidad<0) {
          try {
            cantidad=Teclado.getInt("Introduzca la cantidad de stock a agregar: ");
          } catch (ValorInvalidoException e) {
            System.err.println("Valor introducido erroneo");
          }
        }
      try {
        System.out.println("El indice es: "+ indice);
        almacen.modificarStock(indice, cantidad);
      } catch (ValorInvalidoException e1) {
        System.err.println("El valor introducido no es valido");
      } catch (StockInvalidoException e1) {
        System.err.println("El stock no puede entrar en numeros rojos");
      }
      break;
      
      
      case(2)://PRECIO COMPRA
        double precioc=-1;
      while(precioc<0) {
        try {
          precioc=Teclado.getDecimal("Introduce el nuevo precio de compra");
        }catch (ValorInvalidoException e) {
        }
        if(precioc<0)
          System.out.println("El precio de compra no puede ser negativo");
      }
      almacen.modificarPreCompra(indice, precioc);
        
      break;
      
      case(3): //PRECIO VENTA
        double preciov=-1;
      while(preciov<0) {
        try {
          precioc=Teclado.getDecimal("Introduce el nuevo precio de venta");
        }catch (ValorInvalidoException e) {
          System.err.println("El valor introducido no es valido");
        }
        if(preciov<0)
          System.out.println("El precio de venta no puede ser negativo");
      }
      almacen.modificarPreCompra(indice, preciov);
        
      break;
    
      case(4): //DESCRIPCION
        String nuevadesc="";
        try {
        nuevadesc=Teclado.getString("Introduzca la nueva descripcion");
      } catch (ValorInvalidoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
        almacen.moidficarDescripcion(indice, nuevadesc);
        
      break;
      
      case(5): //IVA              HAY QUE HACER E IMPLEMENTAR EL IVA
        almacen.modificarIVA(indice);
        
      break;
      
      default:
        
      break;
    }
    
    
  }
  private static void eliminar() {
    if(almacen.estaVacio()) {
      System.out.println("El almacen esta vacio no hay nada que eliminar");
      return;
    }
    
    int codigo=-1;
    while(codigo==-1) {
      try {
        codigo=Teclado.getInt("Introduce el codigo del articulo a BORRAR(NO ES REVERSIBLE): ");
      } catch (ValorInvalidoException e1) {
        System.err.println("Valor no valido");
        return;
      }
    }
    almacen.borrarArticulo(codigo);   
  }
  private static void listar() {
    if(almacen.estaVacio()) {
      System.out.println("El almacen esta vacio no hay nada que listar");
      return;
    }
    
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
              System.err.println("Introduzca un codigo existente.");
            }
          }
          System.out.println(almacen.mostrarArticulo(codigo));
        break;
      }
  }
  private static void agregar() throws ValorInvalidoException {
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
    almacen.altaArticulo( precc, precv, stock, desc);
  }
}
