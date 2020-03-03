/*Matrizes Esparsas

Uma matriz é dita esparsa quando possui uma grande quantidade de elementos que valem zero.
 A matriz esparsa é implementada através de um conjunto de listas ligadas que apontam para 
 elementos diferentes de zero, de tal forma que os elementos que possuem valor zero não são armazenados.

O uso da matriz tradicional tem como vantagem o fato de preservar-se o acesso direto a cada 
elemento da matriz, tornando o algoritmos bastante simples. Entretanto, esta estratégia tem como desvantagem muito espaço para armazenar zeros, o que certamente é um desperdício.

A solução é o uso de uma estrutura de lista encadeada contendo somente os elementos não nulos.
 Apesar dessa solução ser pior, em termos de tempo de execução, uma vez que as operações são mais 
 lentas porque o acesso não mais é direto.

Assumindo que este tempo adicional vale a pena, para este trabalho, vamos adotar a estratégia de
 “listas cruzadas”, ou seja, para representar a matriz esparsa, vamos utilizar dois vetores, um com
  N ponteiros para as linhas e outro com M ponteiros para as colunas. Neste caso, cada elemento não 
  nulo é mantido simultaneamente em duas listas, uma para sua linha, e outra para sua coluna. Veja na figura abaixo.

*/
  import java.util.Scanner;
class Lista{
	private int i;
	private int j;
	private int valor;
	Lista(int a, int b, int valor){
		this.setValor(valor);
		this.setX(a);		
		this.setY(b);
	}	
	public void setValor(int valor){
		this.valor = valor;
	}
	public void setY(int indice_y){
		this.j = indice_y;
	}
	public void setX(int indice_x){
		this.i = indice_x;
	}
	public int getValor(){
		return this.valor;
	}
	public int getY(){
		return this.j;
	}
	public int getX(){
		return this.i;
	}     
}
class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int numL, numC,i,j,num,casos,cont;
		numL =  ler.nextInt();
		numC = ler.nextInt();
		Lista[][] mat = new Lista[numL][numC];
		for(i = 0; i < numL; i++){
			for(j = 0; j < numC; j++){
				num = ler.nextInt();
				mat[i][j] = new Lista(i,j,num);
			}
		}
		cont = 0;	
		casos = ler.nextInt();
		while(cont < casos){
			i = ler.nextInt();
			j = ler.nextInt();
			System.out.println(mat[i-1][j-1].getValor());
		cont++;
		}
	}
}