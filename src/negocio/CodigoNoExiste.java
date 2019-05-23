package negocio;

public class CodigoNoExiste extends Exception {
  public CodigoNoExiste () {
    System.err.println("El codigo introducido no existe");
  }
}
