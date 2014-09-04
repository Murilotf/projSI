import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo {
	public Nodo nodoRaiz;
	public static Integer somatorioCaminho = 0;
	public ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	public int[][] matrizAdjacente;
	public ArrayList<String> impressao = new ArrayList<>();
	int tamanhoMatriz;

	public void setNodoRaiz(Nodo n) {
		this.nodoRaiz = n;
	}

	public Nodo getNodoRaiz() {
		return this.nodoRaiz;
	}

	public void adicionaNodo(Nodo n) {
		nodos.add(n);
	}

	public void conectaNodo(Nodo inicio, Nodo fim, int custo) {
		if (matrizAdjacente == null) {
			tamanhoMatriz = nodos.size();
			matrizAdjacente = new int[tamanhoMatriz][tamanhoMatriz];
		}

		int inicioIndex = nodos.indexOf(inicio);
		int fimIndex = nodos.indexOf(fim);
		matrizAdjacente[inicioIndex][fimIndex] = custo;
		matrizAdjacente[fimIndex][inicioIndex] = custo;
	}

	private Nodo getFilhosNaoVisitados(Nodo n) {

		int index = nodos.indexOf(n);
		int j = 0;
		while (j < tamanhoMatriz) {
			if (matrizAdjacente[index][j] >= 1
					&& ((Nodo) nodos.get(j)).visitado == false) {
				return (Nodo) nodos.get(j);
			}
			j++;
		}
		return null;
	}

	public void buscaProfunda() {

		Stack<Nodo> s = new Stack<Nodo>();
		s.push(this.nodoRaiz);
		nodoRaiz.visitado = true;
		imprimeNodo(nodoRaiz);
		while (!s.isEmpty()) {
			Nodo n = (Nodo) s.peek();
			Nodo filho = getFilhosNaoVisitados(n);
			if (filho != null) {
				filho.visitado = true;
				impressao.add(filho.nome);
				somatorioCaminho += matrizAdjacente[nodos.indexOf(n)][nodos
						.indexOf(filho)];
				s.push(filho);
				if (filho.destinoFinal == true) {
					imprimeCidades(impressao);
					return;
				}
			} else {
				somatorioCaminho -= matrizAdjacente[nodos.indexOf(n)][nodos
						.indexOf(filho)];
				Nodo n2 = (Nodo) s.pop();
				impressao.remove(n2.nome);

			}
		}

		clearNodes();
	}
	
	public void bfs()
	{
		
		//BFS uses Queue data structure
		Queue<Nodo> fila=new LinkedList<Nodo>();
		fila.add(this.nodoRaiz);
		imprimeNodo(this.nodoRaiz);
		nodoRaiz.visitado=true;
		while(!fila.isEmpty())
		{
			Nodo n=(Nodo)fila.remove();
			Nodo filho=null;
			while((filho=getFilhosNaoVisitados(n))!=null)
			{
				filho.visitado=true;
				impressao.add(filho.nome);
				fila.add(filho);
			
				if (filho.destinoFinal == true) {
					imprimeCidades(impressao);
					return;
			}
		}
		}
		clearNodes();
		
	}


	

	private void imprimeCidades(ArrayList<String> impressao2) {
		for (String cidade : impressao2) {
			System.out.print(cidade + " ");
		}
	}

	public void imprimeMatriz() {
		int count = 0;
		int coun2 = 0;
		for (int i = 0; i < matrizAdjacente.length; i++) {
			System.out.print(nodos.get(i).nome);
			for (int j = 0; j < matrizAdjacente[i].length; j++) {
				if (count == 0) {
					for (int j2 = 0; j2 < matrizAdjacente[i].length; j2++) {
						System.out.print(String.format("%1$" + 15 + "s",
								nodos.get(j2).nome));
					}
					if (count == 0) {
						System.out.println("");
						count++;
					}
				}
				if (coun2 == 0) {
					System.out.println("");
					coun2++;
				}
				System.out.print(String.format("%1$" + 15 + "s",
						matrizAdjacente[i][j]) + " | ");
			}
			System.out.println("");

		}
	}

	public void imprimeMatriz2() {
		System.out.print("                    ");
		for (int i = 0; i < nodos.size(); i++) {
			System.out
					.print(String.format("%1$" + 17 + "s", nodos.get(i).nome));
		}
		System.out.println("");
		for (int j = 0; j < nodos.size(); j++) {
			System.out
					.print(String.format("%1$" + 17 + "s", nodos.get(j).nome));
			for (int i = 0; i < matrizAdjacente[j].length; i++) {
				System.out
				.print(String.format("%1$" + 17 + "d", matrizAdjacente[j][i]));
			}
			System.out.println("");
		}
	}

	private void clearNodes() {
		int i = 0;
		while (i < tamanhoMatriz) {
			Nodo n = (Nodo) nodos.get(i);
			n.visitado = false;
			i++;
		}
	}

	private void imprimeNodo(Nodo n) {
		System.out.print(n.nome + " ");
	}

}
