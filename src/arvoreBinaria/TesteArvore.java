package arvoreBinaria;

public class TesteArvore {

	public static void main(String[] args) {
		Arvore arv = new Arvore(8);
		arv.inserir(3);
		arv.inserir(10);
		arv.inserir(1);
		arv.inserir(6);
		arv.inserir(0);
		arv.inserir(2);
		arv.inserir(4);
		arv.inserir(7);
		arv.inserir(9);
		arv.inserir(14);
		arv.inserir(13);
		arv.inserir(15);

		arv.emOrdem();
		System.out.println("\n-------------------------------------------------------------------");
		arv.removerArv(3);
		System.out.println("Arvore apos remoção");
		arv.emOrdem();

	}

}
