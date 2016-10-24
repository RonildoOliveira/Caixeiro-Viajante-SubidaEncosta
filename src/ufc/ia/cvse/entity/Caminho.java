package ufc.ia.cvse.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import ufc.ia.cvse.util.TipoOperacao;

public class Caminho {
	
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();
	
	public Caminho(ArrayList<Cidade> cidades, TipoOperacao tipoOperacao) {
		if(tipoOperacao == TipoOperacao.EI2){
			this.cidades.addAll(cidades);
			Collections.shuffle(cidades);
		}else{
			this.cidades.addAll(cidades);
		}
	}
	
	public Caminho(Caminho caminho){
		caminho.cidades.stream().forEach(x -> cidades.add(x));
	}
	
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public double getDistanciaTotal(){
		int qtdCidades = this.cidades.size();

		return this.cidades.stream().mapToDouble(x -> {
			int indiceCidade = this.cidades.indexOf(x);
			
			double valor = 0;
			
			if(indiceCidade < qtdCidades - 1)
				valor = x.getDistancia(this.cidades.get(indiceCidade + 1));
			
			return valor;
			}).sum() + this.cidades.get(qtdCidades - 1).getDistancia(this.cidades.get(0));
	}
		
	public String toString(){
		return Arrays.toString(cidades.toArray());
	}
}
