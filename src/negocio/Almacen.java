package negocio;

import java.util.ArrayList;

public class Almacen {
  private ArrayList<Articulo> almacen = new ArrayList<>();

  public void altaArticulo(int cod, double precc, double precv, int stock ,String desc)  {
    try {
      almacen.add(new Articulo(cod, precc, precv, stock, desc));
    } catch (StockInvalidoException e) {
      System.err.println("Añada un stock valido usando la opcion INSERTAR NUMERO DE OPCION para modificar los valores.");
    }
  }
  public String toString() {
    String cadena="";
    
    for(int i=0;i<=almacen.size()-1;i++)
      cadena+=("Codigo: "+almacen.get(i).getCodigo()+" Precio compra: "+almacen.get(i).getPCompra()+" Precio venta: "+almacen.get(i).getPVenta()+
          " Stock:"+almacen.get(i).getStock()+"\n");
    return cadena;
  }
  
  public int getIndex(int codigo) throws CodigoNoExiste {
    
      for(int i=0; i<almacen.size()-1;i++) {
      if(almacen.get(i).getCodigo()==codigo) {
        return i;
        }
      }
      System.out.println("El codigo no coincide con ninguno");
      throw new CodigoNoExiste();
   
    
    
  }
  
  public void eliminarArticulo(int codigo) {
    int i;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    almacen.remove(i);
    
  }
  
  public void reducirStock(int codigo, int cantidad) throws StockInvalidoException {
    int i;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    almacen.get(i).alteraStock(-cantidad);
    
  }
  
  public void aumentarStock(int codigo, int cantidad) throws StockInvalidoException {
    int i;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    almacen.get(i).alteraStock(cantidad);
  }
  
  public String mostrarArticulo(int codigo) {
    int i;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return ("Codigo: "+almacen.get(i).getCodigo()+" Precio compra: "+almacen.get(i).getPCompra()+" Precio venta: "+almacen.get(i).getPVenta()+
        " Stock:"+almacen.get(i).getStock());
  }
  
  public void borrarArticulo(int codigo) {
    try {
      almacen.remove(getIndex(codigo));
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void modificarCodigo(int index, int cod) {
    almacen.get(index).setCodigo(cod);
  }
  
  public void modificarStock(int index, int cantidad) {
    try {
      almacen.get(index).alteraStock(cantidad);
    } catch (StockInvalidoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void modificarPreCompra(int index, double precc) {
    almacen.get(index).setPCompra(precc);
  }
  public void modificarPreVenta(int index, double precv) {
    almacen.get(index).setPVenta(precv);
  }
  
  public void moidficarDescripcion(int index, String nuevadesc) {
    almacen.get(index).setDesc(nuevadesc);
  }
  
  public void modificarIVA(int index) {
    almacen.get(index).setIVA();
  }
  
}
