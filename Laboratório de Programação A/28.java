/*Bucket Sort

Assuma que queremos ordenar um grupo de K de chaves inteiras. Assuma também que as chaves que serão ordenadas estão distribuídas em um intervalo conhecido (por exemplo, de 1 a N). Defina até M compartimentos (buckets) onde cada compartimento é responsável por guardar um intervalo das chaves a serem ordenadas. Do ponto de vista implementacional, os compartimentos formam um vetor de dimensão M onde cada elemento desse vetor é uma lista de inteiros (que armazenará as chaves). Para saber qual o índice do vetor deve ser colocado cada chave, utilize a seguinte fórmula: índice = (chave * M) / (N + 1). Considere que índice pega somente a parte inteira do cálculo (observe que não é arredondar, mas simplesmente pegar a parte inteira). Por exemplo, se chave = 130; M = 30 e N = 999, o cálculo daria 3,9, mas o índice será igual a 3 (pega somente a parte inteira). Se outro valor coincidir no mesmo índice, deve-se incluir na lista encadeada mas de forma ordenada (utilize qualquer método de ordenação que você desejar). Após o último elemento da lista de K chaves a ser ordenada tiver sido incluído na lista de compartimentos (buckets), você deverá concatenar todas as listas associadas aos compartimentos para obter a ordenação final. Leia os valores de M, K, N, e os K valores (entre 1 e N). Como saída, deve ser impresso as listas de cada compartimento, NULL caso não exista, e a lista final ordenada.

 

Para mais informações sobre o bucket sort veja uma animação em: https://www.cs.usfca.edu/~galles/visualization/BucketSort.html
*/
import java.util.*;
import java.util.Scanner;
class Caixinha{
	private int elemento;
	private Caixinha proxima;

	public int getElemento(){
		return this.elemento;
	}

	public void setElemento(int e){
		this.elemento = e;	
	}

	public Caixinha getProximo(){
		return this.proxima;
	}

	public void setProximo(Caixinha prx){
		this.proxima = prx;
	}
}
class Lista{
	private Caixinha inicio;

	Lista(){
		this.inicio = null;
		
	}
	public void inserir(int e){
		Caixinha nova = new Caixinha();
		nova.setElemento(e);
		nova.setProximo(null);
	
		if(inicio == null){
			inicio = nova;	
		}else{
			Caixinha aux;
			aux = inicio;
			while(aux.getProximo() != null){
				aux = aux.getProximo();
			}
			aux.setProximo(nova);
			
		}
	}

	public int retirar(){
		if(inicio != null){
			int e;
			e = inicio.getElemento();
			inicio = inicio.getProximo();
			return e;
		}
		return 0;
		
	}

	public void  listar(){
		Caixinha aux = inicio;
		while( aux != null){
			System.out.print(" "+aux.getElemento());
			aux = aux.getProximo();	
		}
	
	}
	
	public boolean isEmpty(){
		return this.inicio == null;
	}
	public void sort(){
		Caixinha aux = inicio;
		int cont = 0;
		while(aux != null){
			cont++;
			aux = aux.getProximo();
		}
		int vet[]= new int[cont];
		int i;
		aux = inicio;
		for(i = 0; i < cont; i++){
			vet[i] = aux.getElemento();
			aux = aux.getProximo();
		}
			
		int key,j, ind = 0;
		for(i=1; i < cont; i++){
			key = vet[i];
			j = i-1;
			while(j >=0 && vet[j] > key){
				vet[j+1] = vet[j];
				j--;
			}
			vet[j+1] = key;			
		}
		aux = inicio;
		for(i = 0; i < cont; i++){
			aux.setElemento(vet[i]);
			aux = aux.getProximo();	
		}
	}
}
class main{
	public static void main(String ars[]){
		Scanner ler  = new Scanner(System.in);
		int max, k, n;
		max = ler.nextInt();
		k = ler.nextInt();
		n = ler.nextInt();

		Lista lista[] = new Lista[max];
		int[] vet = new int[k];
		for(int i = 0; i < k; i++){
			vet[i] = ler.nextInt();
		}
		for(int i = 0; i < max; i++){
			lista[i] = new Lista();
		}

		for(int i = 0; i < k; i++){
			int val = max*vet[i]/(n+1);
			lista[val].inserir(vet[i]); 
		}
		int aux = 0;
		for(int i = 0; i < max; i++){
			if(lista[i].isEmpty()){
				System.out.println(i  + " NULL");
			}else{
				System.out.print(i  + " ");
				lista[i].sort();
				lista[i].listar();
				System.out.println();
			
			}
		}
		int idx = 0;
		int ii;
		for(ii = 0; ii < max; ii++){
			while(!lista[ii].isEmpty()){
				vet[idx] = lista[ii].retirar();
				idx++;
			}				
								
		}
		for(int i = 0; i < k-1; i++){
			System.out.print(vet[i] +" ");
		}
		System.out.println(vet[k-1]);
		
	}
}
