package negocio;

public class StockInvalidoException extends Exception {
    public StockInvalidoException () {
      System.err.println("Valor invalido");
    }
}