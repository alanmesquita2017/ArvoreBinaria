package arvoreBinaria;

public class Arvore {

	private No raiz;

	public Arvore(float valor) {
		this.raiz = new No();
		this.raiz.setValor(valor);
	}

	public void inserir(float valor) {
		inserir(this.raiz, valor);
	}

	public void inserir(No no, float valor) {
		if (valor < no.getValor()) {
			if (no.getEsquerdo() != null) {
				inserir(no.getEsquerdo(), valor);
			} else {
				No novo = new No();
				novo.setValor(valor);
				no.setEsquerdo(novo);
			}
		} else {
			if (no.getDireito() != null) {
				inserir(no.getDireito(), valor);
			} else {
				No novo = new No();
				novo.setValor(valor);
				no.setDireito(novo);
			}
		}

	}

	public void preOrdem() {
		preOrdem(this.raiz);
	}

	public void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.getValor() + ", ");
			preOrdem(no.getEsquerdo());
			preOrdem(no.getDireito());
		}
	}

	public void emOrdem() {
		emOrdem(this.raiz);
	}

	public void emOrdem(No no) {
		if (no != null) {
			emOrdem(no.getEsquerdo());
			System.out.print(no.getValor() + ", ");
			emOrdem(no.getDireito());
		}
	}

	public void posOrdem() {
		posOrdem(this.raiz);
	}

	public void posOrdem(No no) {
		if (no != null) {
			posOrdem(no.getEsquerdo());
			posOrdem(no.getDireito());
			System.out.print(no.getValor() + ", ");
		}
	}

	public void removerArv(float valor) {
		removerArv(this.raiz, valor);
	}

	public No removerArv(No no, float valor) {
		No noV = new No();
		noV.setValor(valor);
		boolean t = true;

		if (no == null) {
			System.out.println("Arvore vazia");

			t = false;
			if (t == false) {
				System.out.println("Valor " + valor + " não exite na Arvore");
			}

		}

		if (t == true) {
			if (valor < no.getValor()) {//menor esquerda 
				no.setEsquerdo(removerArv(no.getEsquerdo(), valor));

			} else if (valor > no.getValor()) {//maior direita 
				no.setDireito(removerArv(no.getDireito(), valor));

			} else if (no.getEsquerdo() != null && no.getDireito() != null) // 2 filhos
			{
				no.setValor(encontraMinimo(no.getDireito()).getValor());//encontra valor
				no.setDireito(removeMinimo(no.getDireito()));//remove
			} else {
				no = (no.getEsquerdo() == null) ? no.getEsquerdo() : no.getDireito();//otimização do if/else

			}

		}

		return no;

	}

	public No removeMinimo(No no) {//remover valor
		if (no == null) {
			System.out.println("Arvore Vázia");
		} else if (no.getEsquerdo() != null) {
			no.setEsquerdo(removeMinimo(no.getEsquerdo()));
			return no;
		} else {
			return no.getDireito();
		}
		return null;
	}

	public No encontraMinimo(No no) {//encontrar valor
		if (no != null) {
			while (no.getEsquerdo() != null) {
				no = no.getEsquerdo();
			}
		}
		return no;
	}
}
