/*Números ímpares

Faça um programa que leia dois números inteiros positivos, N e M,
 e escreva a soma de todos os números IMPARES que estejam no intervalo fechado [N,M].
 Este programa deve ler vários casos de teste. 
 O último valor, que não deverá gerar saída, possui N = M = 0.*/
 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0, y = 0, soma = 0;
				
		
		x = ler.nextInt();
		y = ler.nextInt();
		while(( x != 0) && ( y != 0)){
			soma = 0;
				for (int i = x; i <= y; i ++){
					if((i%2 != 0)){
						soma+=i;
					}
					
				}
		
		System.out.println(soma);
		x = ler.nextInt();
		y = ler.nextInt();
			

		
		}
	
	}
	
}

/*Números pares

Faça um programa que leia dois números inteiros positivos, N e M,
 e escreva a soma de todos os números PARES que estejam no intervalo fechado [N,M]. 
Este programa deve ler vários casos de teste. O último valor, que não deverá gerar saída, possui N = M = 0.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0, y = 0, soma = 0;
				
		
		x = ler.nextInt();
		y = ler.nextInt();
		while(( x != 0) && ( y != 0)){
			soma = 0;
				for (int i = x; i <= y; i ++){
					if((i%2 == 0)){
						soma+=i;
					}
					
				}
		
		System.out.println(soma);
		x = ler.nextInt();
		y = ler.nextInt();
			

		
		}
	
	}
	
}

/*Transformação de binário para decimal

Faça uma programa que leia vários números naturais na
 base binária e escreva o mesmo número na base decimal. 
 O último valor, que não deverá gerar saída, deve ter valor igual a “0000”. 
 Sugiro que as entradas sejam do tipo String.*/

 import java.util.*;
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int pot = 0, soma = 0 ;
		
		String num = ler.next();
		
		
		while(!(num.equals("0000"))){
			soma = 0;
			pot = 0;
			for(int i = num.length() - 1; i >= 0; i--){
				soma += Math.pow(2, pot) * Character.getNumericValue(num.charAt(i));
				pot++;
			}
			System.out.println(soma);
			num = ler.next();
		}
		
		
		
		
		
	
	}
	
}

/*Transformação de decimal para binário

 

NÃO USE O MÉTODO Integer.toBinaryString

Faça uma programa que leia vários números naturais na base decimal e escreva o mesmo número na base binária.
 O último valor, que não deverá gerar saída, deve ter valor igual a -1 (um negativo). 
 Como os números em binário podem ter vários dígitos, considere que a saída possa ser do tipo string.*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int num = 0, x = 0;
		int temp = 0;
		String binario = "";
		
		num =ler.nextInt();
		while( num != - 1){
			x = num;
			binario="";
			while( x != 0){
					temp = x%2;
					binario = binario + temp;
					x = x/2;
			}
			System.out.println(inverso(binario));

		num =ler.nextInt();
		}
	}
		
		public static String inverso(String string) {
			int i = 0;
			String inverso = "";
			char vet[] = string.toCharArray();
			
			for (i = vet.length - 1; i >= 0; i--) {
				inverso += String.valueOf(vet[i]);
			}
			return inverso;
	}
	
}

/*Caixa Eletrônico

Um caixa eletrônico dispõe apenas de cédulas de R$50, R$ 20 e R$2 para saques.
Considere que a quantidade de cédulas é INFINITA. 
Elabore um programa que calcule quantas cédulas de cada tipo devem ser fornecidas para satisfazer um valor de saque informado.
É importante notar que há situações em que não é possível fornecer o saque com as cédulas disponíveis. 
Por exemplo, saques nos valores de R$5 ou de R$53 não são possíveis. Nesse caso, a saída também deve ser NAO.
Leia um número ilimitado de valores inteiros e diga a quantidade de cada cédula de R$50, R$ 20 e R$2 (nesta ordem), ou NAO se o saque não puder ser feito. 
O último valor, que não deverá gerar saída, tem o valor igual a 0 (zero).*/

import java.util.Scanner;
public class main{
    public static void main(String[] args)  {
 
        Scanner ler = new Scanner(System.in);
        int nota = 0, valor = 0, n50 = 0, n20 = 0, n2 = 0, N = 0;
		 	int contprimo = 0;
		 
        nota = ler.nextInt();

		 
				 
		 while(nota != 0){
			 
			 n50 = nota / 50;
			 nota %= 50;
			 n20 = nota / 20;
			 nota %= 20;
			
			 n2 = nota / 2;
			 nota %= 2;

			 		 
					if (nota > 0){
					System.out.println("NAO");
					}
			 else{
				 			
				 		System.out.println(n50 +" "+n20 +" "+n2);

			 }		 
			 nota = ler.nextInt();

			 
			 
		 }

    }
}

/*Números Capicua

Um número é CAPICUA quando ele não muda se lido da esquerda para a direita ou da direita para a esquerda. 
Por exemplo, o número 2002 é um número capicua. Fazer um programa que leia uma quantidade indeterminada de valores inteiros, sempre de 4 dígitos (entre 1000 e 9999), 
e que imprima SIM ou NAO conforme o número seja capicua ou não. 
O último valor, que não deverá gerar saída (que é o critério de parada), deve ser igual a 0 (zero).*/

import java.util.*;
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		String cond = "0";
		int a = 0, b = 0, c = 0, d = 0;
		String num = ler.next();
		
		
		while(!(num.equals("0"))){
			for(int i = 0 ; i <= num.length(); i++){
			
				
				a =  Character.getNumericValue(num.charAt(0));
				b =  Character.getNumericValue(num.charAt(1));
				c =  Character.getNumericValue(num.charAt(2));
				d =  Character.getNumericValue(num.charAt(3));
				
				if ((a == d) && (b ==c)){				
				cond = "SIM";
				}
				else{
					cond = "NAO";
				}
			}
			System.out.println(cond);
			num = ler.next();
		}
		
		
		
		
		
	
	}
	
}
/*
Sequência

Considere o seguinte algoritmo para gerar uma sequência de números. 
Inicie com um inteiro N. Se N for par, gere o próximo número dividindo por dois. 
Se N for impar, gere o próximo número multiplicando por três e adicionando um. 
Repita este processo com o novo valor de N, terminando quando N for igual a 1.
 Fazer um programa que leia uma quantidade indeterminada de valores inteiros de N e que imprima toda a sequência de N até 1, separados por um espaço em branco. 
O último valor de N, que não deverá gerar saída (que é o critério de parada), deve ser igual a 0 (zero).*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0;
				
		
		x = ler.nextInt();
		while( x != 0){
				System.out.print(x+" ");
	
			while(x != 1){

				if(x%2 == 0){
					x = x/2;
				}
				else{
					x = 3*x + 1;
				}
				
				if(x == 1){
						System.out.println(x);
				}	
				else{
					System.out.print(x+" ");
				}

			}
					
		x = ler.nextInt();
				}
	
	}
	

}
/*Desempenho dos Jogadores 

Na preparação para a Copa do Mundo de Futebol, e para melhor avaliar os atletas, os técnicos identificaram que seria útil analisar a regularidade dos jogadores.
 Especificamente, eles estão interessados em saber quantos jogadores fizeram gols em todas as partidas. 
 Como o volume de dados é muito grande, eles gostariam de ter um programa de computador para realizar essa contagem.
Faça uma programa que leia dois inteiros, N e M, indicando respectivamente o número de jogadores e o número de partidas. 
Assuma que N e M estão no intervalo 1 a 20 (inclusive). Cada uma das N linhas seguintes descreve o desempenho de um jogador: a i-ésima linha contém M inteiros informando o número de gols do i-ésimo jogador em cada partida. 
Nesta primeira etapa, seu programa deve produzir uma única saída contendo o número de jogadores que fizeram gols em todas as partidas.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int jog = 0, part = 0, total = 0, soma = 0;
				
		jog = ler.nextInt();
		part = ler.nextInt();


		int vet[][] = new int[ jog][part];

		for (int i = 0 ; i < jog ; i++ ) {

			for ( int j = 0; j < part ; j ++ ) {
					vet[i][j] = ler.nextInt();
			}
			
		}

		for (int i = 0 ; i < jog ; i++ ) {
			soma = 0;
			for ( int j = 0; j < part ; j ++ ) {
					if(vet[i][j] > 0){
						soma++;
					}
			}
			if  ( soma == part){
				total++;
			}
			
		}
		System.out.println(total);
	
		
		
		
		
	}
	
}