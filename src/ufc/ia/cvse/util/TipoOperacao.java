package ufc.ia.cvse.util;

/**
 OP1 Trocar duas cidades quaisquer de lugar
 OP2 Inverter trechos das permuta��es
 
 EI1 Estado Inicial 1 - Gere uma permuta��o aleat�ria das cidades fornecidas.
 EI2 Estado Inicial 2 - Utilize a sequ�ncia em que as cidades s�o fornecidas no arquivo de entrada
 
 RVI Randmoza��o da vizinhanca
 NVI Sem randmoza��o da vizinhanca
 
 DN Rodar algoritmo em 2^n
 ND Rodar algoritmo em n^2
 
 **/
public enum TipoOperacao {
	OP1, OP2, EI2, EI1, RVI, NVI, DN, ND
}
