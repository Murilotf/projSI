import java.util.ArrayList;
import java.util.Stack;


public class Grafo 
{
	public Nodo nodoRaiz;
	public static Integer somatorioCaminho = 0;
	public ArrayList<Nodo> nodos=new ArrayList<Nodo>();
	public int[][] matrizAdjacente;
	int tamanhoMatriz;
	public void setNodoRaiz(Nodo n)
	{
		this.nodoRaiz=n;
	}
	
	public Nodo getNodoRaiz()
	{
		return this.nodoRaiz;
	}
	
	public void adicionaNodo(Nodo n)
	{
		nodos.add(n);
	}
	

	public void conectaNodo(Nodo inicio,Nodo fim, int custo)
	{
		if(matrizAdjacente==null)
		{
			tamanhoMatriz=nodos.size();
			matrizAdjacente=new int[tamanhoMatriz][tamanhoMatriz];
		}

		int inicioIndex=nodos.indexOf(inicio);
		int fimIndex=nodos.indexOf(fim);
		matrizAdjacente[inicioIndex][fimIndex]=custo;
		matrizAdjacente[fimIndex][inicioIndex]=custo;
	}
	
	private Nodo getFilhosNaoVisitados(Nodo n)
	{
		
		int index=nodos.indexOf(n);
		int j=0;
		while(j<tamanhoMatriz)
		{
			if(matrizAdjacente[index][j]>=1 && ((Nodo)nodos.get(j)).visitado==false)
			{
				return (Nodo)nodos.get(j);
			}
			j++;
		}
		return null;
	}
	
	
	

	public void buscaProfunda()
	{

		Stack<Nodo> s=new Stack<Nodo>();
		s.push(this.nodoRaiz);
		nodoRaiz.visitado=true;
		imprimeNodo(nodoRaiz);
		while(!s.isEmpty())
		{
			Nodo n=(Nodo)s.peek();
			Nodo filho=getFilhosNaoVisitados(n);
			if(filho!=null)
			{
				filho.visitado=true;
				imprimeNodo(filho);
				somatorioCaminho +=matrizAdjacente[nodos.indexOf(n)][nodos.indexOf(filho)];
				s.push(filho);
				if(filho.destinoFinal == true){
					return;
				}
			}
			else
			{
				s.pop();
			}
		}

		clearNodes();
	}
	
	

	private void clearNodes()
	{
		int i=0;
		while(i<tamanhoMatriz)
		{
			Nodo n=(Nodo)nodos.get(i);
			n.visitado=false;
			i++;
		}
	}
	

	private void imprimeNodo(Nodo n)
	{
		System.out.print(n.nome+" ");
	}

	
	
	

}
