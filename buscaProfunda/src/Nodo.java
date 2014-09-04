
public class Nodo 
{
	public String nome;
	public boolean visitado=false;
	public boolean destinoFinal;
	public Nodo pai;
	public Nodo(String l, boolean destinoFinal)
	{
		this.nome=l;
		this.destinoFinal = destinoFinal;
	}
}
