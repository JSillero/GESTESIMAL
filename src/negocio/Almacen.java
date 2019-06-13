package negocio;

import java.util.ArrayList;

import presentacion.ValorInvalidoException;

public class Almacen {
  private ArrayList<Articulo> almacen = new ArrayList<>();

  public void altaArticulo(double precc, double precv, int stock ,String desc) throws ValorInvalidoException  {
    try {
      almacen.add(new Articulo(precc, precv, stock, desc));
    } catch (StockInvalidoException e) {
      System.err.println("Añada un stock valido usando la opcion INSERTAR NUMERO DE OPCION para modificar los valores.");
    }
  }
  public String toString() {
    String cadena="";
    
    for(int i=0;i<=almacen.size()-1;i++)
      cadena+=("Codigo: "+almacen.get(i).getCodigo()+" Precio compra: "+almacen.get(i).getPCompra()+" Precio venta: "+almacen.get(i).getPVenta()+
          " Stock:"+almacen.get(i).getStock()+" Descripcion: "+ almacen.get(i).getDesc() +" IVA: "+ almacen.get(i).getIVA()+"\n");
    return cadena;
  }
  
  public int getIndex(int codigo) throws CodigoNoExiste {
    boolean existe=false;
    int i=0;
     while(i<almacen.size() && !existe) {
       
      if(almacen.get(i).getCodigo()==codigo) {
        existe=true;
        System.out.println("El indice es"+i );
        }else
          i++;
      
      }
     if(!existe) 
      throw new CodigoNoExiste();
     
     return i;
    
    
  }
  public boolean estaVacio () {
    return almacen.isEmpty();
  }
  
  public void eliminarArticulo(int codigo) {
    int i=0;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    almacen.remove(i);
    
  }

  public String mostrarArticulo(int codigo) {
    int i=0;
    try {
      i = getIndex(codigo);
    } catch (CodigoNoExiste e) {
      System.err.println("El ccodigo introducido no existe");
    }
    return ("Codigo: "+almacen.get(i).getCodigo()+" Precio compra: "+almacen.get(i).getPCompra()+" Precio venta: "+almacen.get(i).getPVenta()+" Stock:"+almacen.get(i).getStock()+" IVA:"+ almacen.get(i).getIVA()+" Descipcion:"+almacen.get(i).getDesc());
  }
  
  public void borrarArticulo(int codigo) {
    try {
      almacen.remove(getIndex(codigo));
    } catch (CodigoNoExiste e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void modificarStock(int index, int cantidad) throws ValorInvalidoException, StockInvalidoException {
   
     if(cantidad>0) 
       almacen.get(index).agregaStock(cantidad);
     else
       almacen.get(index).substraeStock(cantidad);
    
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
  /**
   * Metodo que te devuelve el indice de un articulo de almacen cuando le pasas el codigo
   * @param codigo
   * @return
   */
  
}
