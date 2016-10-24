/**
 * UNVERSIDADE FEDERAL DO CEARÁ - UFC CAMPUS QUIXADÁ
 * CIÊNCIA DA COMPUTAÇÃO - INTELIGÊNCIA ARTIFICIAL
 * 
 * PROF. SAMY SÁ
 *  
 * RONILDO OLIVEIRA DA SILVA #366763
 * 
 */

package ufc.ia.cvse.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ufc.ia.cvse.algorithm.SubidaEncosta;
import ufc.ia.cvse.entity.Caminho;
import ufc.ia.cvse.entity.Cidade;
import ufc.ia.cvse.util.ManipuladorArquivos;
import ufc.ia.cvse.util.Operacao;
import ufc.ia.cvse.util.TipoOperacao;

public class Main {
	
	public static ManipuladorArquivos mArq = new ManipuladorArquivos();
	public static ArrayList<Cidade> listaCidades;
	
	//Sera computado com complexidade n^2 (TipoOperacao.DN) para 2^n
	public static TipoOperacao complexidade = TipoOperacao.DN;
	
	public static void main(String[] args) {
		
		mArq.gerarPontos(10);
		
		listaCidades = mArq.carregar();
		System.out.println("\n1. Estado Inicial 1 com Operador 1 sem randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI1, TipoOperacao.OP1,
		2, 9, TipoOperacao.NVI, complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n2. Estado Inicial 1 com Operador 1 com randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI1, TipoOperacao.OP1,
		2, 7, TipoOperacao.RVI, complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n3. Estado Inicial 1 com Operador 2 sem randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI1, TipoOperacao.OP2,
		3, 8, TipoOperacao.NVI,complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n4. Estado Inicial 1 com Operador 2 com randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI1, TipoOperacao.OP2,
		1, 5, TipoOperacao.RVI,complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n5. Estado Inicial 2 com Operador 1 sem randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI2, TipoOperacao.OP1,
		2, 8, TipoOperacao.NVI,complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n6. Estado Inicial 2 com Operador 1 com randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI2, TipoOperacao.OP1,
		2, 3, TipoOperacao.RVI, complexidade);
		
		listaCidades = mArq.carregar();
		System.out.println("\n7. Estado Inicial 2 com Operador 2 sem randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI2, TipoOperacao.OP2,
		1, 8, TipoOperacao.NVI, complexidade);
	
		listaCidades = mArq.carregar();
		System.out.println("\n8. Estado Inicial 2 com Operador 2 com randomização da vizinhança.".toUpperCase());
		variacoesImplementacoes(listaCidades, TipoOperacao.EI2, TipoOperacao.OP2,
		1, 4, TipoOperacao.RVI, complexidade);

	}
	
	public static String cidadesToJS (Caminho caminho){

		String nodesHTML = "";
		
		for (int i = 0; i < caminho.getCidades().size(); i++) {
			nodesHTML += "{name: '"+caminho.getCidades().get(i).getNome()+"', row: "+caminho.getCidades().get(i).getX()+" , column: "+caminho.getCidades().get(i).getY()+", connectsTo: '"+caminho.getCidades().get(i+1).getNome()+"'},";

			if(i == caminho.getCidades().size()-2){
				nodesHTML += "{name: '"+caminho.getCidades().get(i+1).getNome()+"', row: "+caminho.getCidades().get(i+1).getX()+" , column: "+caminho.getCidades().get(i+1).getY()+", connectsTo: '"+caminho.getCidades().get(0).getNome()+"'}";
				break;
			}
		}
		
		return nodesHTML;
	}
	
	public static void variacoesImplementacoes(ArrayList<Cidade> listaCidades,
		TipoOperacao estInicial, TipoOperacao operador,
		int iniRange, int fimRange,
		TipoOperacao tipoRand, TipoOperacao complexidade){
		
		Caminho caminho = new Caminho(listaCidades, estInicial);
			System.out.println("Lista de Cidades:\t"+caminho.getCidades());
			System.out.println("Distancia do percurso:\t"+caminho.getDistanciaTotal());
			System.out.println();
		
			System.out.print("");
			
			Calendar cal1 = Calendar.getInstance();
	        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss.SSS");
	        String t1 = sdf1.format(cal1.getTime()).toString();
	        		
		Caminho caminhoOtimizado = new SubidaEncosta().encontraMenorCaminho(caminho, tipoRand, complexidade);
			caminhoOtimizado.getCidades().get(0).setNome("INI"); //Ponto de Partida
					 
			Calendar cal2 = Calendar.getInstance();
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss.SSS");
			String t2 = sdf2.format(cal2.getTime()).toString();
	        
	        System.out.println("Inicio:\t\t\t" + t1 );
	        System.out.println("Fim:\t\t\t" + t2 );
			System.out.println("Lista de Cidades:\t"+caminhoOtimizado.getCidades());
			System.out.println("Distancia do percurso:\t"+caminhoOtimizado.getDistanciaTotal());
			System.out.println();
			
			Operacao op = new Operacao(iniRange, fimRange, operador);
			System.out.println("Lista de Cidades"+operador+"\t"+op.operacaoShufle(caminhoOtimizado));
			System.out.println("Distancia otimizada:\t"+caminhoOtimizado.getDistanciaTotal());
		
			//Escreve o grafo resultante numa página HTML
			ManipuladorArquivos manipArq = new ManipuladorArquivos();
			manipArq.escreverResultado(cidadesToJS(caminhoOtimizado));
	}	
}
