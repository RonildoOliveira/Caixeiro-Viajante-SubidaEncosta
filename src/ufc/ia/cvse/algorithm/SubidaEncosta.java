package ufc.ia.cvse.algorithm;

import ufc.ia.cvse.entity.Caminho;
import ufc.ia.cvse.entity.Cidade;
import ufc.ia.cvse.util.TipoOperacao;

public class SubidaEncosta {

	public Caminho encontraMenorCaminho(Caminho caminhoAtual, TipoOperacao tipoRand, TipoOperacao complexidade){
		
		Caminho caminhoAdjacente;
		int iteracaoCont = 0;
		int MAX_ITERACOES;
		
		//2^n		
		if(complexidade == TipoOperacao.DN){
			MAX_ITERACOES = (int) Math.pow(2, caminhoAtual.getCidades().size());
		}
		//n^2
		else{
			MAX_ITERACOES = (int) Math.pow(caminhoAtual.getCidades().size(), 2);
		}
				
		while (iteracaoCont < MAX_ITERACOES){			
			caminhoAdjacente = getCaminhoAdjacente(new Caminho(caminhoAtual), tipoRand);
			
			if(caminhoAdjacente.getDistanciaTotal() < caminhoAtual.getDistanciaTotal()){
				iteracaoCont = 0;
				caminhoAtual = new Caminho(caminhoAdjacente);
			}else{
				iteracaoCont++;
			}
			
			if(iteracaoCont == MAX_ITERACOES)
				break;
		}
		return caminhoAtual;
	}
	
	private Caminho getCaminhoAdjacente(Caminho caminho, TipoOperacao tipoRand){
		int x1 = 0, x2 = 0;
		if(tipoRand == TipoOperacao.RVI){
			while(x1 == x2){
				x1 = (int) (caminho.getCidades().size() * Math.random());
				x2 = (int) (caminho.getCidades().size() * Math.random());
			}
			
			Cidade cidade1 = caminho.getCidades().get(x1);
			Cidade cidade2 = caminho.getCidades().get(x2);
			
			caminho.getCidades().set(x2, cidade1);
			caminho.getCidades().set(x1, cidade2);
		}else{
			x1 = 0;
			x2 = caminho.getCidades().size()-1;
			Cidade cidade1 = caminho.getCidades().get(x1);
			Cidade cidade2 = caminho.getCidades().get(x2);
			
			caminho.getCidades().set(x2, cidade1);
			caminho.getCidades().set(x1, cidade2);
		}
		return caminho;
	}
}
