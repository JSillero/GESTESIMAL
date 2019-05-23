

import negocio.Almacen;
import negocio.CodigoNoExiste;
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
     
      break; 
      
      case(3):
        
        int codigo=-1;
      while(codigo==-1) {
        try {
          codigo=Teclado.getInt("Introduce el codigo del articulo a BORRAR(NO ES REVERSIBLE): ");
        } catch (ValorInvalidoException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
      almacen.borrarArticulo(codigo);
      break;
      
      case(4):
        int codigo2=-1;
      while (codigo2==-1) {
         try {
          codigo2=Teclado.getInt("Introduzca el codigo del articulo a modificar: ");
        } catch (ValorInvalidoException e) {

        }
      }
        int indice=-1;
        while (indice<0) {
          try {
            indice = almacen.getIndex(codigo2);
          } catch (CodigoNoExiste e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
        int respuesta3=0;
        String[] opciones3= {"Codigo","Agregar Stock","Sacar Stock","Precio Compra","Precio Venta","Descripcion","IVA"};
        Menu menu3 = new Menu("Valor a modificar", opciones3 );
        respuesta3=menu3.mostrar_pedir();
        
        switch(respuesta3) {
          case(1):
              int nuevocodigo=-1;
            while (nuevocodigo<0) {
              try {
                nuevocodigo=Teclado.getInt("Introduzca el nuevo codigo: ");
              } catch (ValorInvalidoException e) {

              }
            }
            almacen.modificarCodigo(indice,nuevocodigo);
          break;
          case(2):
            int cantidad=-1;
          while (cantidad<0) {
            try {
              cantidad=Teclado.getInt("Introduzca la cantidad de stock a agregar: ");
            } catch (ValorInvalidoException e) {

            }
          }
          almacen.modificarStock(indice, cantidad);
          break;
          
          case(3):
            int cantidad2=-1;
          while (cantidad2<0) {
            try {
              cantidad2=Teclado.getInt("Introduzca la cantidad de stock a retirar: ");
            } catch (ValorInvalidoException e) {

            }
          }
          almacen.modificarStock(indice, -cantidad2);

          break;
          
          case(4):
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
          
          case(5):
            double preciov=-1;
          while(preciov<0) {
            try {
              precioc=Teclado.getDecimal("Introduce el nuevo precio de venta");
            }catch (ValorInvalidoException e) {
            }
            if(preciov<0)
              System.out.println("El precio de venta no puede ser negativo");
          }
          almacen.modificarPreCompra(indice, preciov);
            
          break;
        
          case(6):
            String nuevadesc="";
            try {
            nuevadesc=Teclado.getString("Introduzca la nueva descripcion");
          } catch (ValorInvalidoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          
            almacen.moidficarDescripcion(indice, nuevadesc);
            
          break;
          
          case(7):
            almacen.modificarIVA(indice);
            
          break;
          
          default:
            
            break;
          
        }
        
        
        
      break;
        
      
      
      }
    }
  }

}
