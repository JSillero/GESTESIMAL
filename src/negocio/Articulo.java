package negocio;
import presentacion.Menu;
import presentacion.Teclado;
import presentacion.ValorInvalidoException;
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
  private String IVA="";
  
  
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
  public Articulo (int cod,double precc,double precv, int stock, String desc) throws StockInvalidoException {
    this.setCodigo(cod);
    this.setDesc(desc);
    this.setPCompra(precc);
    this.setPVenta(precv);
    this.setStock(stock);
    this.setIVA();
    
  }
  public void setIVA() {
    String[] opciones= {"Normal","Reducido","Super Reducido"};
    Menu menuIVA = new Menu("IVA",opciones );      
    this.IVA=opciones[menuIVA.mostrar_pedir()-1];
  }
  public  String getIVA() {
    return this.IVA;
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
        throw new StockInvalidoException() ; //ES NECESARIO CREAR Y LANZAR UNA EXCEPCION PARA LOS STOCKS INVALIDOS?????????
      }
    this.stock=stock2;
  }
  /**
   * Añade un valor (o substrae si es negativo) para alterar el stock, implementa el metodo setStock
   * @param valor
   * @throws StockInvalidoException
   */
  public void alteraStock(int valor) throws StockInvalidoException {
    if (this.getStock()+valor <0)
      throw new StockInvalidoException();
    
    this.setStock((valor+this.getStock()));
  }

  public int getStock() {
    return this.stock;
  }

  public void setPVenta(double precv) {    
    double numero=precv;
    while(numero<0) {
      try {
        numero=Teclado.getDecimal("El precio de venta debe de ser mayor que 0.\nIntroduzca un numero valido:");
      } catch (ValorInvalidoException e) {
        System.out.println("El numero debe de ser un decimal de dos digitos o un entero");
      }
    
    }
    
      this.precVenta=numero;
  }

  public void setPCompra(double precc) {
    double numero=precc;
    while(numero<0) {
      try {
        numero=Teclado.getDecimal("El precio de compra debe de ser mayor que 0.\nIntroduzca un numero valido:");
      } catch (ValorInvalidoException e) {
        System.out.println("El numero debe de ser un decimal de dos digitos o un entero");
      }
    
    }
    
      this.precCompra=numero;
  }
  public double getPVenta() {
    return this.precVenta;
  }
  
  public double getPCompra() {
    return this.precCompra;
  }
  
  
  public void setDesc(String desc) {
    this.descripcion=desc;
  }
  
  public String getDesc() {
    return this.descripcion;
  }

  public void setCodigo(int cod) {
    this.codigo=cod;
    
  }
  public int getCodigo() {
    return this.codigo;
  }
  
  

}
