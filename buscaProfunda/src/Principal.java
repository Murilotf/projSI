
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Nodo nFloripa =new Nodo("Floripa", false);
		Nodo nItajai=new Nodo("Itajai", false);
		Nodo nPalhoca=new Nodo("Palhoca", false);
		Nodo nLaguna=new Nodo("Laguna", false);
		Nodo nNavegantes=new Nodo("Navegantes", false);
		Nodo nArarangua=new Nodo("Ararangua", false);
		Nodo nJoinville=new Nodo("Joinville", false);
		Nodo nLages=new Nodo("Lages", false);
		Nodo nMafra=new Nodo("Mafra", false);
		Nodo nMonteCastelo=new Nodo("MonteCastelo", false);
		Nodo nPonteAlta=new Nodo("PonteAlta", false);
		Nodo nCanoinhas=new Nodo("Canoinhas", false);
		Nodo nCamposNovos=new Nodo("CamposNovos", false);
		Nodo nCapinzal=new Nodo("Capinzal", false);
		Nodo nHervalDoeste=new Nodo("HervalDoeste", false);
		Nodo nPortoUniao=new Nodo("PortoUniao", false);
		Nodo nSaoLourenco=new Nodo("SaoLourenco", false);
		Nodo nCampoEre=new Nodo("CampoEre", false);
		Nodo nDionisioCerqueira=new Nodo("DionisioCerqueira", false);
		Nodo nSaoMiguelDoOeste=new Nodo("SaoMiguelDoOeste", false);
		Nodo nItapiranga=new Nodo("Itapiranga", true);
		Nodo nIrai=new Nodo("Irai", false);
		Nodo nChapeco=new Nodo("Chapeco", false);
		Nodo nXanxere=new Nodo("Xanxere", false);
		Nodo nMaravilha=new Nodo("Maravilha", false);

		Grafo g = new Grafo();
		g.adicionaNodo(nFloripa);
		g.adicionaNodo(nItajai);
		g.adicionaNodo(nNavegantes);
		g.adicionaNodo(nJoinville);
		g.adicionaNodo(nMafra);
		g.adicionaNodo(nMonteCastelo);
		g.adicionaNodo(nCanoinhas);
		g.adicionaNodo(nPortoUniao);
		g.adicionaNodo(nSaoLourenco);
		g.adicionaNodo(nCampoEre);
		g.adicionaNodo(nDionisioCerqueira);
		g.adicionaNodo(nSaoMiguelDoOeste);
		g.adicionaNodo(nItapiranga);
		g.adicionaNodo(nPalhoca);
		g.adicionaNodo(nLaguna);
		g.adicionaNodo(nArarangua);
		g.adicionaNodo(nLages);
		g.adicionaNodo(nPonteAlta);
		g.adicionaNodo(nCamposNovos);
		g.adicionaNodo(nCapinzal);
		g.adicionaNodo(nHervalDoeste);
		g.adicionaNodo(nXanxere);
		g.adicionaNodo(nChapeco);
		g.adicionaNodo(nIrai);
		g.adicionaNodo(nMaravilha);
		g.setNodoRaiz(nFloripa);

		
		g.conectaNodo(nFloripa,nPalhoca, 20);
		g.conectaNodo(nFloripa,nItajai, 70);
		g.conectaNodo(nPalhoca,nItajai, 80);
		g.conectaNodo(nPalhoca,nLaguna, 100);
		g.conectaNodo(nLaguna,nArarangua, 70);
		g.conectaNodo(nNavegantes,nJoinville, 70);
		g.conectaNodo(nArarangua,nLages, 220);
		g.conectaNodo(nLages,nPonteAlta, 40);
		g.conectaNodo(nLages,nCamposNovos, 60);
		g.conectaNodo(nItajai,nNavegantes, 10);
		g.conectaNodo(nJoinville,nMafra, 80);
		g.conectaNodo(nMafra,nPortoUniao, 130);
		g.conectaNodo(nMafra,nCanoinhas, 70);
		g.conectaNodo(nMafra,nMonteCastelo, 85);
		g.conectaNodo(nMonteCastelo,nCanoinhas, 80);
		g.conectaNodo(nCanoinhas,nPortoUniao, 80);
		g.conectaNodo(nMonteCastelo, nPonteAlta, 90);
		g.conectaNodo(nPonteAlta,nCamposNovos, 40);
		g.conectaNodo(nCamposNovos,nHervalDoeste, 30);
		g.conectaNodo(nCamposNovos,nCapinzal, 45);
		g.conectaNodo(nCapinzal,nHervalDoeste, 15);
		g.conectaNodo(nCapinzal,nChapeco, 110);
		g.conectaNodo(nHervalDoeste,nPortoUniao, 135);
		g.conectaNodo(nHervalDoeste,nXanxere, 80);
		g.conectaNodo(nPortoUniao,nSaoLourenco, 140);
		g.conectaNodo(nXanxere,nSaoLourenco, 80);
		g.conectaNodo(nSaoLourenco,nCampoEre, 25);
		g.conectaNodo(nCampoEre,nDionisioCerqueira, 27);
		g.conectaNodo(nCampoEre,nMaravilha, 35);
		g.conectaNodo(nDionisioCerqueira,nSaoMiguelDoOeste, 40);
		g.conectaNodo(nSaoMiguelDoOeste,nMaravilha, 15);
		g.conectaNodo(nSaoMiguelDoOeste,nItapiranga, 35);
		g.conectaNodo(nItapiranga,nIrai, 17);
		g.conectaNodo(nIrai,nMaravilha, 8);
		g.conectaNodo(nIrai,nChapeco, 65);
		g.conectaNodo(nChapeco,nXanxere, 40);
		g.conectaNodo(nChapeco,nMaravilha, 70);

		
		
		g.buscaProfunda();
		System.out.println("\nCusto total: "+Grafo.somatorioCaminho);
		
	
		
		
		
		
	}

}
