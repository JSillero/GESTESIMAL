package negocio;
/**
 * Crea la clase articulo como se indica en el ejercicio GESTESIMAL 
 * CON EL AÑADIDO DE IVA QUE ES ENUM.
 * 
 * Necesito una clase Articulo que representa a los artículos del 
 * almacén.   
 * 
Su estado será: código, descripción, precio de compra, precio de venta
 y  número de unidades (nunca negativas). 
 
Como comportamiento: Considero que el código va a  generarse de forma
 automática en el constructor, así no puede haber dos  artículos con el
  mismo código. Esto implica que no puede modificarse el  código de un
   artículo.
   
    Sí el resto de las propiedades. Podremos mostrar el  
   artículo, por lo que necesito una representación del artículo en
    forma de  cadena (toString) 
 * @author d18sisaj
 *
 */
public class Articulo {
  private int codigo;
  private String descripcion;
  private double precCompra;
  private double precVenta;
  private int stock=0;
  
  
  /**
   * A la hora de poner nombre a la clase, el  nombre sera igual a su codigo(asi sera hecho en el programa principal)
   * , así se le podra identificar facilmente cuando se le quieran alterar los valores.
   * Ademas se almacena la posicion que tiene en el arraylist que almacena su descripción.
   * 
   * @param cod codigo
   * @param precc precio compra
   * @param precv precio venta
   * @param stock numero de existencias
   * @param desc descripcion
   * @throws StockInvalidoException 
   */
  public Articulo (int cod,int precc,int precv, int stock, String desc) throws StockInvalidoException {
    this.setCodigo(cod);
    this.setDesc(desc);
    this.setPCompra(precc);
    this.setPVenta(precv);
    this.setStock(stock);
    
    
  }
  /**
   * 
   * Define la cantidad de articulos en inventario, lanza una excepcion en caso de que el numero sea
   * negativo.
   * 
   * @param stock2
   * @throws StockInvalidoException
   */
  public void setStock(int stock2) throws StockInvalidoException {
    
    int safe=this.getStock();
      if(stock2<0) {
        this.stock=safe;
        throw new StockInvalidoException() ;
      }
    this.stock=stock2;
  }
  /**
   * Añade un valor (o substrae si es negativo) para alterar el stock, implementa el metodo setStock
   * @param valor
   * @throws StockInvalidoException
   */
  public void alteraStock(int valor) throws StockInvalidoException {
    
    this.setStock((valor+this.getStock()));
  }

  private int getStock() {
    // TODO Auto-generated method stub
    return this.stock;
  }

  private void setPVenta(double precv) {    
    if(precv<0)
      System.out.println("Debe de ser mayor que 0.");
  }

  private void setPCompra(int precc) {
    // TODO Auto-generated method stub
    
  }

  private void setDesc(String desc) {
    // TODO Auto-generated method stub
    
  }

  private void setCodigo(int cod) {
    // TODO Auto-generated method stub
    
  }

}
