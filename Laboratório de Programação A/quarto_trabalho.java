/*Professor ligado!
Um certo professor, que sempre passa uma lista de presença para ser assinada pelos alunos, resolveu conferir as assinaturas e notou que alguns alunos assinavam diferente em algumas aulas e desconfiou que alguém poderia estar assinando por eles. Como o professor possui muitos alunos e pouco tempo, ele pediu sua ajuda para validar as assinaturas. Uma assinatura é considerada falsa se houver mais de uma diferença entre a original e a que estiver sendo checada. Considere diferença uma troca de maiúscula para minúscula ou o contrário.

Vamos considerar que a entrada possui diversos casos de testes. 
A primeira linha de cada caso inicia com um inteiros N representando a quantidade de alunos de sua turma. As próximas N linhas serão da seguinte forma:
<Nome do aluno> <Assinatura original>
A seguir haverá um inteiro M representando a quantidade de alunos que compareceram
 a uma aula. M linhas seguem, no seguinte formato:
<Nome do aluno> <Assinatura na aula>
Todos os alunos possuem apenas o primeiro nome na lista, 
nenhum nome se repete e todos os nomes contêm no máximo 20 letras (a-z A-Z). 
A entrada termina com N = 0, a qual NÃO deve ser processada.
Para cada caso, exiba uma única linha, a quantidade 
de assinaturas falsas encontradas.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
	Scanner ler = new Scanner(System.in);
		
	String ass_original = "", nome = "";
	String ass_aula = "", nome_aula = "";
	int m = 0, n = 1, total = 0, soma = 0;
	int aux = 0;
	n = ler.nextInt();	
	while(n != 0){
		total = 0;
		soma = 0;
		aux = 0;




		String mat[][] = new String[n][2];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 2; j++){
				mat[i][j] = ler.next();
			}
		}

		m = ler.nextInt();
		String mat1[][] = new String[m][2];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < 2; j++){
				mat1[i][j] = ler.next();
			}
		}


		int j = 0;

		for(int i = 0; i < m; i++){
				j = 0;
				soma = 0;
				while(!(mat1[i][0].equals(mat[j][0] ))) {


					j++;

				}
				for(int k = 0; k < mat[j][1].length(); k++){

					if(mat[j][1].charAt(k) != mat1[i][1].charAt(k)){
						soma++;
					}	
				}	
				
				if( soma > 1 ){
					total++;
				}					
	
		}


		System.out.println(total);
		n = ler.nextInt();
	}

	
	}
}

Múltiplos de 3 e de 5

/*Faça um programa que leia dois números inteiros positivos, N e M,
 e escreva a soma dos múltiplos de 3 e de 5 no intervalo fechado [N, M]. 
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
					if((i%3 == 0) && (i%5 == 0)){
						soma+=i;
					}
					
				}
		
		System.out.println(soma);
		x = ler.nextInt();
		y = ler.nextInt();
			

		
		}
	
	}
	
}

/*Números impares de Fibonacci

A sequência de Fibonacci é dada por 1, 1, 2, 3, 5, 8, 13, . . .
 Faça um programa que leia dois números inteiros positivos, N e M, e 
 escreva a soma de todos os números IMPARES da sequência de Fibonacci
  que estejam no intervalo fechado [N,M]. Este programa deve ler vários 
  casos de teste. O último valor, que não deverá gerar saída, possui N = M = 0.*/

  import java.util.Scanner;
public class main {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
	 
	int n = 0,  soma      = 0, m = 0;
	int b = 1,  intervalo = 0;
	int a = 0,  auxiliar  = 0;
	int cont = 0;
	  
	n = ler.nextInt();
 	m = ler.nextInt();
	   
	//intervalo = m - n;
	auxiliar = b;
	while((n != 0) ||  (m != 0)){ 
		if( n > 1){
			soma = 0;
		}else{soma = 1;}
		
  		for (int i = 0; i < 30; i++){
  				auxiliar = a + b;
				a = b;
				b = auxiliar;
			
				if ((auxiliar >= n) && (auxiliar <= m)){
						if( auxiliar %2 != 0){
						soma += auxiliar;
							System.out.println(soma);
					}
				}
			
    	}
    System.out.println(soma);	

   n = ler.nextInt();
 	m = ler.nextInt();
	//intervalo = m - n;
	b = 1; a = 0;
	auxiliar = b;
	 

	}
	




  }
}
/*Números pares de Fibonacci

A sequência de Fibonacci é dada por 1, 1, 2, 3, 5, 8, 13, . . .
 Faça um programa que leia dois números inteiros positivos, N e M, 
 e escreva a soma de todos os números PARES da sequência de Fibonacci 
 que estejam no intervalo fechado [N,M]. Este programa deve ler vários casos de teste. 
O último valor, que não deverá gerar saída, possui N = M = 0.*/
import java.util.Scanner;
public class main {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
	 
	int n = 0,  soma      = 0, m = 0;
	int b = 1,  intervalo = 0;
	int a = 0,  auxiliar  = 0;
	int cont = 0;
	  
	n = ler.nextInt();
 	m = ler.nextInt();
	  
	  

	//intervalo = m - n;
	auxiliar = b;
	while((n != 0) ||  (m != 0)){ 
		soma = 0;
  		for (int i = 0; i < 30; i++){
  				auxiliar = a + b;
				a = b;
				b = auxiliar;
			
				if ((auxiliar >= n) && (auxiliar <= m)){
						if( auxiliar %2 == 0){
						soma += auxiliar;
					}
				}
			
    	}
    System.out.println(soma);	

   n = ler.nextInt();
 	m = ler.nextInt();
	//intervalo = m - n;
	b = 1; a = 0;
	auxiliar = b;
	 

	}
	




  }
}
/*Números de Fibonacci

A sequência de Fibonacci é dada por 1, 1, 2, 3, 5, 8, 13, . . .
 Faça um programa que leia dois números inteiros positivos, N e M,
  e escreva a soma de todos os números da sequência de Fibonacci 
  que estejam no intervalo fechado [N,M]. Considere que M e N
   estão no intervalo fechado [1,100000]. Este programa deve ler
    vários casos de teste. 
O último valor, que não deverá gerar saída, possui N = M = 0.*/

import java.util.Scanner;
public class main {
  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
	 
	int n = 0,  soma      = 0, m = 0;
	int b = 1;
	int a = 0,  auxiliar  = 0;
	int cont = 0;
	  
	n = ler.nextInt();
 	m = ler.nextInt();
 

	auxiliar = b;
	while((n != 0) ||  (m != 0)){ 
		if( n > 1){
			soma = 0;
		}else{
			soma = 1;
		}
		  for (int i = 0; i < 30 ; i++){
				auxiliar = a + b;
				a = b;
				b = auxiliar;
			
				if ((auxiliar >= n) && (auxiliar <= m)){
						soma += auxiliar;
				}
			}
		
   System.out.println(soma);	
   n = ler.nextInt();
 	m = ler.nextInt();
	b = 1; a = 0;
	auxiliar = b;
	 

	}
	




  }
}
/*Primo ou não primo

Ler uma quantidade indeterminada de números 
inteiros n e imprimir PRIMO se N for primo, ou NAO,
 caso contrário. O último valor, que não deverá entrar
  no cálculo, deve ter valor igual a zero. 
Considere que 0 < n < 1000.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int contprimo = 0;
		int num = ler.nextInt();
		String primo = "0";
		while(num != 0){
			if( num == 1){primo = "NAO";}
			else if(num == 2 || num == 3){primo = "PRIMO";}
			else {
				contprimo = 0;
				for(int i = 2; i < num; i ++){
					if (num%i == 0){
						contprimo ++;
					}
				}
					if (contprimo == 0){
							primo = "PRIMO";
					}else{primo = "NAO";}
				
			 }
	
			System.out.println(primo);	

			num = ler.nextInt();
			
		}
		
		
		
		
		
	}
	
	
	
}
/*Primos gêmeos

Uma das questões pesquisadas sobre os números primos é de como eles se 
distribuem nos naturais, com que frequência isso ocorre e qual a distância
 que existem entre eles. Por exemplo, existem vários pares de números primos
  que se diferem em duas unidades: (3, 5), (5, 7), (11, 13), (17, 19), (29,31),
   (41, 43), (59, 61), (71, 73), (101, 103), (107, 109), etc. Pares de números
    primos com essa propriedades são denominados de primos gêmeos. Não se sabe
     ainda se existe infinitos pares de números primos gêmeos.
Fazer um programa que leia dois números inteiros, X e Y, com 0 < X < Y <= 1000, 
e escreva todos os pares de primos gêmeos  no intervalo [X, Y].*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0, y = 0, i = 0;
			int primo = 0, cont = 0	;
		
		x = ler.nextInt();
		y = ler.nextInt();
	
		for(i = x; i < y - 1 ; i++){
			if((primo(i) == true) && (i < y)){
				if((primo(i + 2) == true) && ( (i + 2) - i == 2) ) {
					System.out.print("("+i+","+(i+2)+")");
				}
			}
			
			
		}
		System.out.println("");
	}	
		

	static boolean primo( int num){
			boolean cond = true;
			int i = 2;
			if( (num == 2) || (num == 3)){
				cond = true;
			}else if( (num == 0) || (num == 1) ){cond = false;}
			else{
				while( (cond == true) && (i <= num - 1)){
					if(num%i == 0){
						cond = false;
					}
					i++;

				}
			}
			
			return cond;
			
		}

}

/*Números Múltiplos

Quando um número é divisível por outro, isto é, a divisão entre 
eles possui resto igual a zero, dizemos que os números são múltiplos. 
Por exemplo, 28 é múltiplo de 14, pois 28 : 14 = 2 e resto 0. 
Ler um número ilimitado de pares de números inteiros X e Y, com X < Y, 
e imprima SIM se X e Y forem múltiplos, ou NAO, caso contrário. Os últimos valores, 
que não deverão gerar saída, possuem ambos os valores iguais a 0 (zero).*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0, y = 0;
			String m = "0";
				
		
		x = ler.nextInt();
		y = ler.nextInt();
		while(( x != 0) && ( y != 0)){
					if(x%y != 0){
						m = "NAO";
					}
					else{
						m = "SIM";
					}
					
		
	
		System.out.println(m);
		x = ler.nextInt();
		y = ler.nextInt();
			

		
		}
	
	}
	
}
/*Escreva um programa que imprima uma figura semelhante 
à representada abaixo, a partir da leitura do número de
 asteriscos presentes na base. Por exemplo, para uma entrada igual a 8,
 o resultado produzido será igual ao da figura abaixo.*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		int a = ler.nextInt();
		
		for(int i = 0; i < a; i++){
			for(int j = 0; j < a - i; j++){
				System.out.print("*");
			}
		System.out.println("");

		
		}
		for(int i = 0; i < a; i++){
			for(int j = 0; j < i +1; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
		
		
		
	}
	
	
	
}