/**
 * Una clase que crea menus y los muestra, ademas de pedir opciones para aquellos menus.
 * 
 * @author d18sisaj
 *
 */
package presentacion;

public class Menu {
  private String titulo;
  private String[] opciones;
  private String menu;
  /**
   * Consctructor
   *
   * @param titulo título del menú
   * @param opciones array de opciones
   */
  public Menu(String tit, String[]opc) {
    this.titulo=tit;
    this.opciones=opc;
    this.menu=this.crearMenu();
  }
  
  /**
   * Construir el menú y mostrarlo por pantalla, añadiendo siempre una ultima opcion llamada 
   * Salir, que sera destinada en la implementacion a salir del menú.
   */
 private String crearMenu() {
    String menu="";
    menu+=this.titulo;
    menu+="\n ----------------------------";
    
    for(int i=1;i<this.opciones.length+1; i++)
      menu+=("\n"+i+".- "+this.opciones[i-1]);
    
    menu+="\n"+(this.opciones.length+1)+".- Salir";
    
    return menu;
  }
  
  
  /**
   * Pedir por teclado una opción entre las posibles
   *
   * @return opción válida
   * @throws ValorInvalidoException 
   */
  public int opciones() {
    int respuesta=0;
    do{
      try {
        respuesta=-1;
        respuesta=Teclado.getInt("Seleccione una opcion del 1 al "+ (this.opciones.length+1) +"." );
      }catch (ValorInvalidoException e) {
        System.err.println("El valor debe de ser un entero entre 1 y "+ (this.opciones.length+1));
      }
    }while(respuesta<=0 ||respuesta>(this.opciones.length+1));
    return respuesta;
  }
  
  /**
   * Indica si la opción es válida
   *
   * @param opcion número a comparar
   * @return true si es válida false en otro caso
   */
  /**
   * la he considerado innecesaria pues a la hora de pedir la opcion obligo que se elija un
   * valor valido, aunque sea el de salida.
   */
  
  /**
   * Mostrar el menú y pedir una opción por teclado
   *
   * @return opción introducida por teclado
   * @throws ValorInvalidoException 
   */
  public int mostrar_pedir() {
    System.out.println(this.menu);
    return this.opciones();
  }
  
}
