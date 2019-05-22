package presentacion;

@SuppressWarnings("serial")
public class ValorInvalidoException extends Exception {

  public ValorInvalidoException() {
    System.err.println("Valor invalido.");
    System.out.println("");
  }
  
}
