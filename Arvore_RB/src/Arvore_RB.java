public class Arvore_RB {
    No raiz;

    void Norutor() 
    {
        this.raiz = null;
    }

    void inserir(int valor) {
        No no = new No(valor, "vermelho");
       
        if (this.raiz == null) {
          this.raiz = no;
          no.direito = this.criaNoFolha(no);
          no.esquerdo = this.criaNoFolha(no);
 
        } else {
          No noAtual  = this.raiz;
         
          while (true) {
           
            if (valor < noAtual.valor) {
              if (noAtual.esquerdo.valor.equals(null)) {               
                noAtual.esquerdo = no;
                no.pai = noAtual;
                break;
              }
              noAtual = noAtual.esquerdo;
            } else {

            if (noAtual.direito.valor.equals(null)) {
                noAtual.direito = no;
                no.pai = noAtual;
                break;
              }
              noAtual = noAtual.direito;
            }
          }
          no.direito = this.criaNoFolha(no);
          no.esquerdo = this.criaNoFolha(no);
          this.verificaArvore(no);
          this.CalculatePosition(this.getraiz());
        }
      }
    No criaNoFolha(No pai) {
        No no = new No(null, null);
        no.valor = null;
        no.cor = "preto";
        no.pai = pai;
        return no;
    }
    void verificaArvore(No no) {
        while (
          no.pai != this.raiz &&
          no != this.raiz &&
          no.cor == "vermelho" &&
          no.pai.cor == "vermelho"
        ) {

          if (no.pai == no.pai.pai.esquerdo) {
            No tio = no.pai.pai.direito;
            if (tio && tio.cor.compareToIgnoreCase("vermelho")) {
              no.pai.cor = "black";
              tio.cor = "black";
              no.pai.pai.cor = "vermelho";
              no = no.pai.pai;
            } else {
              if (no == no.pai.direito) {
                typeText(`O nó é filho direito`);
                no = no.pai;
                typeText(`Rotacionando para a esquerda`);
                this.rotateesquerdo(no);
              }
              typeText(`O nó é um filho esquerdo`);
              typeText(`Alterando cor de ${no.pai.value} para Preto`);
              typeText(
                `Alterando cor de ${no.pai.pai.value} para Vermelho`
              );
              no.pai.cor = "black";
              no.pai.pai.cor = "vermelho";
              typeText(`Rotacionando para a direita`);
              this.rotatedireito(no.pai.pai);
            }
          } else if (no.pai != this.raiz) {
            typeText(`O pai de ${no.value} é um filho direito`);
            No tio = no.pai.pai.esquerdo;
            if (tio && tio.cor === "vermelho") {
              typeText(`O nó possui tio vermelho`);
              typeText(
                `Alterando cores de ${no.pai.value} e ${tio.value} para Preto`
              );
              typeText(
                `Alterando cor de ${no.pai.pai.value} para Vermelho`
              );
              no.pai.cor = "black";
              tio.cor = "black";
              no.pai.pai.cor = "vermelho";
              no = no.pai.pai;
            } else {
              typeText("O nó não possui tio vermelho");
              if (no === no.pai.esquerdo) {
                typeText("O nó é filho esquerdo");
                no = no.pai;
                typeText(`Rotacionando para a direita`);
                this.rotatedireito(no);
              }
              typeText("O nó é filho direito");
              typeText(
                `Alterando cores de ${no.pai.value} para preto e ${no.pai.pai.value} para vermelho`
              );
              no.pai.cor = "black";
              no.pai.pai.cor = "vermelho";
              typeText("Rotacionando para a esquerda");
              this.rotateesquerdo(no.pai.pai);
            }
          }
        }
        // define cor de raiz como preto SEMPRE, como tava vermelho naquele dia? magia negra produnda e profana
        this.raiz.cor = "black";
        typeText("Fim da verificação...");
      }

}
