public class Arvore {
    public static void main(String[] args) {
        Arvore_RB arvore = new Arvore_RB();

        int[] valores = {10, 20, 30, 15, 25};

        for (int valor : valores) {
            arvore.inserir(valor);
        }

        // Buscar um valor na árvore e verificar se ele existe
        int valorParaBuscar = 15;
        Arvore_RB.No noEncontrado = arvore.busca(valorParaBuscar, arvore.getRaiz());

        if (noEncontrado != null) {
            System.out.println("Valor " + valorParaBuscar + " encontrado com cor: " + noEncontrado.cor);
        } else {
            System.out.println("Valor " + valorParaBuscar + " não encontrado.");
        }
    }
}
