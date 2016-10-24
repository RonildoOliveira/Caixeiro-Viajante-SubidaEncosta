package ufc.ia.cvse.util;

/**
 OP1 Trocar duas cidades quaisquer de lugar
 OP2 Inverter trechos das permutações
 
 EI1 Estado Inicial 1 - Gere uma permutação aleatória das cidades fornecidas.
 EI2 Estado Inicial 2 - Utilize a sequência em que as cidades são fornecidas no arquivo de entrada
 
 RVI Randmozação da vizinhanca
 NVI Sem randmozação da vizinhanca
 
 DN Rodar algoritmo em 2^n
 ND Rodar algoritmo em n^2
 
 **/
public enum TipoOperacao {
	OP1, OP2, EI2, EI1, RVI, NVI, DN, ND
}
