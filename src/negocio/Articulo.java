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
  private IVA IVA;
  private static int cuentacodigo=1; //variable estatica que hace que cada codigo sea unico
  
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
   * @throws ValorInvalidoException 
   */
  public Articulo (double precc,double precv, int stock, String desc) throws StockInvalidoException, ValorInvalidoException {
    this.codigo=cuentacodigo;
    this.setDesc(desc);
    this.setPCompra(precc);
    this.setPVenta(precv);
    this.agregaStock(stock);
    this.setIVA();
    cuentacodigo++; //el nuemro de cada articulo cambia
    
  }
  public void setIVA() {
    String[] opciones= {"Normal","Reducido","Super Reducido"};
    Menu menuIVA = new Menu("IVA",opciones );      
    switch(menuIVA.mostrar_pedir()) {
    case(1):
      this.IVA=IVA.Normal;
    break;
    case(2):
      this.IVA=IVA.Reducido;
    break;
    case(3):
      this.IVA=IVA.Super_Reducido;
    break;
    default:
      break;
    }
  }
  public  IVA getIVA() {
    return this.IVA;
  }
  /**
   * 
   * Añade una cantidad indicada por parametro al stock de un articulo
   * 
   * @param stock2
   * @throws StockInvalidoException
   */
  public void agregaStock (int stock) throws ValorInvalidoException {
    if(stock<0)
      throw new ValorInvalidoException();
    
    this.stock+=stock;
    
  }
  
  /**
   * 
   * Se pasa por parametro un nuemero negativo que sera substraido del stock.
   * 
   * @param stock2
   * @throws StockInvalidoException
   * @throws ValorInvalidoException 
   */
  public void substraeStock(int stock) throws StockInvalidoException, ValorInvalidoException {
    if(stock>0)
      throw new ValorInvalidoException();
    if(this.stock+stock<0)
      throw new StockInvalidoException();
    
    this.stock+=stock;
    
  }
  /**
   * Añade un valor (o substrae si es negativo) para alterar el stock, implementa el metodo setStock
   * @param valor
   * @throws StockInvalidoException
   */

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

  public int getCodigo() {
    return this.codigo;
  }
  
  

}
