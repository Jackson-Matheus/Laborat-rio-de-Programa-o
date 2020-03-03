/*Busca em vetor não ordenado usando for 
Estamos interessados em saber se um dado elemento x e um dos elementos de um vetor V de dimensão n e, caso seja, também queremos saber a posição onde este elemento se encontra.
Implemente um algoritmo que faça uma busca exaustiva em todo o vetor usando o “for” como estrutura de repetição, ou seja, sempre acha o elemento x em V,
 se ele estiver presente, pois ele varre todo o vetor comparando cada elemento com x. Caso x esteja presente duas vezes ou mais, ele retorna a posição da ultima ocorrência. 
Neste caso, o algoritmo sempre faz n comparações, por causa do comando for. Por isto diz-se que o número de comparações que o algoritmo realiza 
é proporcional ao tamanho do vetor.
O programa deve ler a dimensão do vetor (1 ≤ n ≤ 500) e, depois ler os n valores (-1000 ≤ V[i] ≤ 1000) e armazenar no vetor V. Em seguida, ler
 um valor indeterminado de valores (-1001 ≤ x ≤ 1000) e procurar no vetor V. Caso o valor de x for encontrando no vetor V deve ser impresso o 
 valor SIM e a posição no vetor, NAO caso contrário. O último valor, que não deverá entrar no cálculo, deve ter o valor -1001. Considere que o
  primeiro índice do vetor começa em um.*/
import java.util.Scanner;
public class main{
	public static void main(String [] args){
		Scanner ler = new Scanner(System.in);
		int n = ler.nextInt();
		int[] vet = new int[n];
		
		for(int i = 0; i < n; i++){
			vet[i] = ler.nextInt();
		}
		
		int k = ler.nextInt();
		while(k != -1001){
		int lugar = 0;
		for(int i = 0; i < n; i++){
			if(vet[i] == k){
				lugar = i;
			}
		}
		if (lugar > 0 ){
			System.out.println("SIM " + (lugar+1));
		}else{
			System.out.println("NAO");			
		}
		k = ler.nextInt();
		}
		
		
		
	}
	
}
/*
Busca em vetor não ordenado usando while

Este exercício é parecido com a “busca em vetor não ordenado usando for”, só que, desta vez, caso encontre
 o valor, ele retorna a posição da primeira ocorrência e não da última. Neste caso, ao invés de usar o 
 “for” deve ser usado o “while”. É claro que, na média, o desempenho deste algoritmo é melhor que o a
 nterior mas que, no pior caso, ambos devem procurar em todo o vetor.

O programa deve ler a dimensão do vetor (1 ≤ n ≤ 500) e, depois ler os n valores (-1000 ≤ V[i] ≤ 1000) e
 armazenar no vetor V. Em seguida, ler um valor indeterminado de valores (-1001 ≤ x ≤ 1000) e procurar no vetor V.
  Caso o valor de x for encontrando no vetor V deve ser impresso o valor SIM e a posição no vetor, NAO caso contrário.
 O último valor, que não deverá entrar no cálculo, deve ter o valor -1001. Considere que o primeiro índice do vetor começa em um.*/

import java.util.Scanner;
public class main{
	public static void main(String [] args){
		Scanner ler = new Scanner(System.in);
		int n = ler.nextInt();
		int[] vet = new int[n];
		
		for(int i = 0; i < n; i++){
			vet[i] = ler.nextInt();
		}
		
		ordena(vet, n);
		int k = ler.nextInt();
		while(k != -1001){
		int lugar = 0, i = 0;
			boolean cond = true;
		while(cond == true && i < n){
			if(vet[i] == k){
				cond = false;
				lugar = i + 1;
			}
			i++;
		}
			
		if (lugar > 0 ){
			System.out.println("SIM " + lugar);
		}else{
			System.out.println("NAO");			
		}
		k = ler.nextInt();
		}
		
		
		
	}
	
	public static void ordena(int [] vet, int tam){
		int i, j;
		
		for (i = 0; i < tam - 1; i++){
 
       	for (j = 0; j < tam - i - 1; j++){
         	  if (vet[j] > vet[j+1]){
            	   int aux = vet[j + 1];
				  		vet[j + 1] = vet[j];
				  		vet[j] = aux;
			  		}
		 	}
		}
			

	}
	
}
/*Busca em vetor não ordenado usando sentinela 

Observe que no caso da “busca em vetor não ordenado usando while” o laço faz dois testes, no caso do elemento não ser encontrado ele será um pouco mais lento. 
Notem que o duplo teste no laço é necessário pois deve parar ou porque achou o elemento ou porque o vetor terminou. Este segundo teste só vai dar true uma
 única vez, o que é um desperdício.

Se pudesse haver garantia de que sempre o elemento procurado estivesse presente, então poderamos construir um teste simples, o que pode nos economizar
 alguma computação, principalmente se a busca for em vetores muito grandes. Para fornecer tal garantia, o programador deliberadamente vai colocar o elemento 
procurado no vetor exatamente depois da última posição. Neste caso, há a garantia de que o elemento sempre vai estar presente. 
Neste caso, das duas uma: ou o elemento não estava no vetor original, e neste caso a busca pode terminar pois o elemento será encontrado após a última posição; 
ou o elemento estava presente e será encontrado antes daquele que foi adicionado. Um teste final resolve a dúvida. Se for encontrado em posição válida, é porque
 estava presente, senão, não estava.

Apesar da melhoria, este algoritmo sempre faz um número de comparações que pode atingir n no pior caso, isto e, quando o elemento não está presente no vetor. 
Desta forma ele é apenas ligeiramente melhor do que o anterior.

Não esqueça de modificar a definição do tipo para prever este espaço
adicional.

O programa deve ler a dimensão do vetor (1 ≤ n ≤ 500) e, depois ler os n valores (-1000 ≤ V[i] ≤ 1000) e armazenar no vetor V. Em seguida, ler um valor 
indeterminado de valores (-1001 ≤ x ≤ 1000) e procurar no vetor V. Caso o valor de x for encontrando no vetor V deve ser impresso o valor SIM e a posição no vetor,
 NAO caso contrário. O último valor, que não deverá entrar no cálculo, deve ter o valor -1001. Considere que o primeiro índice do vetor começa em um.*/
 import java.util.Scanner;
public class main{
	 public static vo inserctionSort(int vet[], int tam){
		int i, j, piv = 0, k;
		for(i = 1; i < tam; i++){
			piv = vet[i];
			j = i - 1;
			k = 0;
			while(j >= 0 && vet[j] > piv){
				vet[j+1] = vet[j];
				j = j - 1;
				k++;
			}
		vet[j+1] = piv;
			for(int p = 0; i < k; i++)System.out.println(vet[i])
		}
		 //return vet;
	}
	public static void main(String [] args){
		Scanner ler = new Scanner(System.in);
		int n = ler.nextInt();
		int[] vet = new int[n];
		
		for(int i = 0; i < n; i++){
			vet[i] = ler.nextInt();
		}
		
		int k = ler.nextInt();
		while(k != -1001){
		int lugar = 0, i = 0;
			boolean cond = true;
		while(cond == true && i < n){
			if(vet[i] == k){
				cond = false;
				lugar = i + 1;
			}
			i++;
		}
			
		if (lugar > 0 ){
			System.out.println("SIM " + lugar);
		}else{
			System.out.println("NAO");			
		}
		k = ler.nextInt();
		}
		
		
		
	
	

			

	}
	
}
/*Busca em vetor ordenado

Este exercício visa ler diversos n valores,
 colocá-los no vetor já de forma ordenado e buscar diversos valores. 
 Caso o valor for encontrando no vetor deve ser impresso o valor SIM e a posição no vetor, 
 NAO caso contrário. O último valor, que não deverá entrar no cálculo, deve ter o valor -1001.
  Considere que o primeiro índice do vetor começa em um.*/
  import java.util.Scanner;
public class main{
	public static void main(String [] args){
		Scanner ler = new Scanner(System.in);
		int n = ler.nextInt();
		int[] vet = new int[n];
		
		for(int i = 0; i < n; i++){
			vet[i] = ler.nextInt();
		}
		
		ordena(vet, n);
		int k = ler.nextInt();
		while(k != -1001){
		int lugar = 0, i = 0;
			boolean cond = true;
		while(cond == true && i < n){
			if(vet[i] == k){
				cond = false;
				lugar = i + 1;
			}
			i++;
		}
			
		if (lugar > 0 ){
			System.out.println("SIM " + lugar);
		}else{
			System.out.println("NAO");			
		}
		k = ler.nextInt();
		}
		
		
		
	}
	
	public static void ordena(int [] vet, int tam){
		int i, j;
		
		for (i = 0; i < tam - 1; i++){
 
       	for (j = 0; j < tam - i - 1; j++){
         	  if (vet[j] > vet[j+1]){
            	   int aux = vet[j + 1];
				  		vet[j + 1] = vet[j];
				  		vet[j] = aux;
			  		}
		 	}
		}
			

	}
	
}