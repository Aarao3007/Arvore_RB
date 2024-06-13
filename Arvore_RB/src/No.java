public class No {
    Integer valor;
    String cor;
    No esquerdo;
    No direito;
    No pai;

    public No(Integer valor, String cor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
        this.cor = cor;
        this.pai = null;
    }

    No getFilhoE(){
        return this.esquerdo;
      }
    No getFilhoD(){
        return this.direito;
      }
    int getValor(){
        return this.valor;
      }
}
