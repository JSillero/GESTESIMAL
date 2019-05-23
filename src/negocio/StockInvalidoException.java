package negocio;

public class StockInvalidoException extends Exception {
    public StockInvalidoException () {
      System.err.println("Stock invalido, no puede ser menor que 0");
    }
}