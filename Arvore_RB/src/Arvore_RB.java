public class Arvore_RB {
  No raiz = null;

  void inserir(int valor) {
      No no = new No(valor, "vermelho");

      if (this.raiz == null) {
          this.raiz = no;
          no.direito = this.criaNoFolha(no);
          no.esquerdo = this.criaNoFolha(no);
      } else {
          No noAtual = raiz;

          while (true) {
              if (valor < noAtual.valor) {
                  if (noAtual.esquerdo.valor == null) {
                      noAtual.esquerdo = no;
                      no.pai = noAtual;
                      break;
                  }
                  noAtual = noAtual.esquerdo;
              } else {
                  if (noAtual.direito.valor == null) {
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
      }
  }

  No criaNoFolha(No pai) {
      No no = new No(null, "preto");
      no.pai = pai;
      return no;
  }

  void verificaArvore(No no) {
      while (no != raiz && no.pai != null && no.pai.cor.equals("vermelho")) {
          if (no.pai.pai == null) break;

          if (no.pai == no.pai.pai.esquerdo) {
              No tio = no.pai.pai.direito;
              if (tio != null && tio.cor.equals("vermelho")) {
                  no.pai.cor = "preto";
                  tio.cor = "preto";
                  no.pai.pai.cor = "vermelho";
                  no = no.pai.pai;
              } else {
                  if (no == no.pai.direito) {
                      no = no.pai;
                      this.rotacionaE(no);
                  }
                  no.pai.cor = "preto";
                  no.pai.pai.cor = "vermelho";
                  this.rotacionaD(no.pai.pai);
              }
          } else {
              No tio = no.pai.pai.esquerdo;
              if (tio != null && tio.cor.equals("vermelho")) {
                  no.pai.cor = "preto";
                  tio.cor = "preto";
                  no.pai.pai.cor = "vermelho";
                  no = no.pai.pai;
              } else {
                  if (no == no.pai.esquerdo) {
                      no = no.pai;
                      this.rotacionaD(no);
                  }
                  no.pai.cor = "preto";
                  no.pai.pai.cor = "vermelho";
                  this.rotacionaE(no.pai.pai);
              }
          }
      }
      this.raiz.cor = "preto";
  }

  No busca(int valor, No no) {
      if (no != null) {
          if (no.getValor() == valor) {
              return no;
          }
          if (valor > no.getValor()) {
              return this.busca(valor, no.direito);
          } else {
              return this.busca(valor, no.esquerdo);
          }
      } else {
          return null;
      }
  }

  void rotacionaD(No no) {
      No esquerdo = no.esquerdo;
      no.esquerdo = esquerdo.direito;
      if (esquerdo.direito != null) {
          esquerdo.direito.pai = no;
      }
      esquerdo.pai = no.pai;
      if (no.pai == null) {
          this.raiz = esquerdo;
      } else if (no == no.pai.direito) {
          no.pai.direito = esquerdo;
      } else {
          no.pai.esquerdo = esquerdo;
      }
      esquerdo.direito = no;
      no.pai = esquerdo;
  }

  void rotacionaE(No no) {
      No direito = no.direito;
      no.direito = direito.esquerdo;
      if (direito.esquerdo != null) {
          direito.esquerdo.pai = no;
      }
      direito.pai = no.pai;
      if (no.pai == null) {
          this.raiz = direito;
      } else if (no == no.pai.esquerdo) {
          no.pai.esquerdo = direito;
      } else {
          no.pai.direito = direito;
      }
      direito.esquerdo = no;
      no.pai = direito;
  }

  No getRaiz() {
      return this.raiz;
  }

  // Classe No
  class No {
      Integer valor;
      String cor;
      No pai;
      No esquerdo;
      No direito;

      No(Integer valor, String cor) {
          this.valor = valor;
          this.cor = cor;
          this.pai = null;
          this.esquerdo = null;
          this.direito = null;
      }

      Integer getValor() {
          return this.valor;
      }

      No getFilhoE() {
          return this.esquerdo;
      }

      No getFilhoD() {
          return this.direito;
      }
  }
}

