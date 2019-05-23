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
  
  public int getIndex(int codigo) {
    int i=0;
    while(almacen.get(i).getCodigo()!=codigo)
      i++;
    return i;
  }
  
  public void eliminarArticulo(int codigo) {
    int i= getIndex(codigo);
    
    almacen.remove(i);
    
  }
  
  public void reducirStock(int codigo, int cantidad) throws StockInvalidoException {
    int i= getIndex(codigo);
    almacen.get(i).alteraStock(-cantidad);
    
  }
  
  public void aumentarStock(int codigo, int cantidad) throws StockInvalidoException {
    int i= getIndex(codigo);
    almacen.get(i).alteraStock(cantidad);
  }
  
  public String mostrarArticulo(int codigo) {
    int i= getIndex(codigo);
    return ("Codigo: "+almacen.get(i).getCodigo()+" Precio compra: "+almacen.get(i).getPCompra()+" Precio venta: "+almacen.get(i).getPVenta()+
        " Stock:"+almacen.get(i).getStock());
  }
  
}
