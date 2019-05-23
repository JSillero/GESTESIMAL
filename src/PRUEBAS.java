import presentacion.*;

public class PRUEBAS {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int respuesta=0;
    
    String[] opciones= {"Listar","Agregar","Eliminar","Modificar"};
    Menu menu = new Menu("GESTESIMAL", opciones );
    respuesta=menu.mostrar_pedir();

  }
}
