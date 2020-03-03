/*Ler uma quantidade indeterminada de números inteiros positivos. 
Para cada número, verifique se tem exatamente quatro dígitos e é par.
 Nesse caso, a saída deve ser 22. 
Caso a entrada tenha quatro dígitos e seja ímpar, a saída deve ser 11.
 Caso não tenha quatro dígitos, a saída deve ser 99. A repetição termina quando o valor -1 é digitado.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int a = 0;
			String b = "0";			
		a = ler.nextInt();
		while( a != -1){		
		b = String.valueOf(a);			
			if( b.length() == 4){
				if(a %2 == 0){
					System.out.println("22");
				}else{
					System.out.println("11");

				}
			}else{
				System.out.println("99");
			}			
		a = ler.nextInt();
		}
	}
}
/*
Ler uma quantidade indeterminada de números inteiros de 1 a 7, 
representando o dia da semana, e retorna qual o dia seguinte. 
O último valor, que não deverão gerar saída (que é o critério de parada), deve ser igual a 0 (zero).*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int a;
			int dia = 0;
				
		a = ler.nextInt();
		while( a != 0){
			if (a == 7){
				dia = 1;
			}
			else{
				dia = a + 1;
			}
			System.out.println(dia);
			
			
			
			a = ler.nextInt();
		}
		
		
		
	}
	
	
}

/*Na apuração das notas de um desfile de escolas de samba utiliza-se um sistema em que 
são desprezadas a nota mais baixa e a mais alta, para evitar perseguições ou favorecimentos.
 Ler uma quantidade indeterminada de TRÊS notas e obter a nota que NÃO foi desprezada.
As notas são números inteiros que variam de 1 a 10.
 Os últimos valores, que não deverão gerar saída (que é o critério de parada), 
 deve ter pelo menos uma nota igual a 0 (zero).*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int a = 0, b = 0, c = 0;
			int nota = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();

		while ((a != 0 ) && (b != 0) && (c != 0)){
			if((a > b) && (a < c) || ( a < b) &&(a > c )){
				nota = a;
			}else if((b > a) && ( b < c) || (b < a) && (b > a )){
				nota = b;
			}else{
				nota = c;
			} 
			System.out.println(nota);
	
			a = ler.nextInt();
			b = ler.nextInt();
			c = ler.nextInt();
		}
		
	}
	
	
}

/*Um torneio de pedra, papel, tesoura é disputado em N rodadas. 
Utilize a seguinte convenção: 0 = Pedra; 1 = Papel; 2 = Tesoura. 
Fazer um programa Java que leia, inicialmente, o valor de N e, em seguida, leia as N jogadas,
 considerando que primeiro é a jogada do jogador1 e em seguida a do jogador2. 
Na saída, diga qual foi o jogador vencedor (1 ou 2). Caso haja empate, a saída deve ser 0 (zero).
 Considere que todas as entradas são válidas.*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int jog_1 = 0, jog_2 = 0, win_1 = 0, win_2 = 0;
			int n = 0, winner = 0;

		n = ler.nextInt();
		
		for(int i = 0; i < n; i++){
			jog_1 = ler.nextInt();
			jog_2 = ler.nextInt();
			
			if ((jog_1 == 0) && (jog_2 ==2)){
				win_1++;
			}else if((jog_1 == 2) && (jog_2 ==0)){
				win_2++;			
			}else if((jog_1 == 0) && (jog_2 ==1)){
				win_2++;
			}else if((jog_1 == 1) && (jog_2 == 0)){
				win_2 ++;
			}else if((jog_1 == 1) && (jog_2 ==2)){
				win_2 ++;

			}else{
				if(jog_1 != jog_2 ){
					win_1 ++;}

			}			
		}
			if(win_1 > win_2){ winner = 1;
			}else if(win_1 < win_2){ winner = 2;						
		   }else{winner = 0;}
			System.out.println(winner);
		
		
	}
	
	
}

/*Joaozinho quer calcular e mostrar a quantidade de litros de combustível gastos em uma viagem, ao utilizar um automóvel que faz 12 KM/L. 
Para isso, ele gostaria que você o auxiliasse através de um simples programa.
 Para efetuar o cálculo, deve-se fornecer o tempo gasto na viagem (em horas) e a velocidade média durante a mesma (em km/h). 
Assim, pode-se obter distância percorrida e, em seguida, calcular quantos litros seriam necessários.
 Mostre o valor com 3 casas decimais após o ponto. (URI Online Judge | 1017)*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int temp = 0, vel = 0;
			float litros = 0.0f, dis = 0.0f;

			temp = ler.nextInt();
			vel = ler.nextInt();
		
			dis = vel*temp;
			litros = dis/12;
		
		System.out.printf("%.3f\n", litros);
	}
}

/*Maria quer montar um painel de LEDS contendo diversos números. 
Ela não possui muitos LEDs, e não tem certeza se conseguirá montar o número desejado. 
Fazer um programa que leia uma quantidade indeterminada de valores inteiros de até 30 
dígitos e escreva a quantidade de leds necessário para montar o valor. 
O último valor, que não deverá gerar saída (que é o critério de parada), deve ser igual a -1 (um negativo). 
Considere cada LED um segmento de um DISPLAY DE 7-SEGMENTOS de acordo com a Figura abaixo.
*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int num = 0, led = 0, soma = 0;
		
		String b ;
		b = ler.next();
		while(!(b.equals("-1"))){
			soma = 0;
			for(int i = 0; i < b.length(); i++){
				num = 0;
			num =  Character.getNumericValue(b.charAt(i));

			if(num == 0){led = 6;}
			else if(num == 1){led = 2;}
			else if(num == 2){led = 5;}
			else if(num == 3){led = 5;}
			else if(num == 4){led = 4;}
			else if(num == 5){led = 5;}
			else if(num == 6){led = 6;}
			else if(num == 7){led = 3;}
			else if(num == 8){led = 7;}
			else{led = 6;}

			soma += led;
			}
				System.out.println(soma);
				b = ler.next();

		}
	
//fim	
	}
}

/*Crescimento Populacional
Mariazinha quer resolver um problema interessante. 
Dadas as informações de população e a taxa de crescimento de duas cidades quaisquer (A e B), ela gostaria de saber quantos anos levará para que a cidade menor (sempre é a cidade A)
ultrapasse a cidade B em população. 
Claro que ela quer saber apenas para as cidades cuja taxa de crescimento da cidade A é maior do que a taxa de crescimento da cidade B, portanto, 
previamente já separou para você apenas os casos de teste que tem a taxa de crescimento maior para a cidade A. 
Sua tarefa é construir um programa que apresente o tempo em anos para cada caso de teste.
A primeira entrada é um inteiro que indica o número de casos de teste. Cada caso de teste contém 4 números:
dois inteiros PA e PB indicando respectivamente a população de A e B, e dois valores G1 e G2 (G1 sempre maior que G2) com um digito após o ponto decimal cada, 
indicando respectivamente o crescimento populacional de A e B (em percentual).
Atenção: A população é sempre um valor inteiro, portanto, um crescimento de 2.5 % sobre uma população de 100 pessoas resultará em 102 pessoas, e não 102.5 pessoas,
 enquanto um crescimento de 2.5% sobre uma população de 1000 pessoas resultará em 1025 pessoas.
Imprima, para cada caso de teste, quantos anos levará para que a cidade A ultrapasse a cidade B em número de habitantes.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		
		Scanner ler = new Scanner(System.in);
		
		int pA = 0, pB = 0, casos = 0, temp = 0, i = 0;
		double g1 = 0.0f, g2 = 0.0  ;
		
		casos  = ler.nextInt();
		for(i = 0; i < casos ;  i++){
			pA  = ler.nextInt();
			pB  = ler.nextInt();
			g1  = ler.nextDouble();
			g2  = ler.nextDouble();
		temp = 0;
			
			while(pA <= pB)
			{
				pA = (int)(pA + ((g1*pA)/100));
				pB = (int)(pB + ((g2*pB)/100));
				temp++;
			}	
			System.out.println(temp);

		}
	
		
	}
	
	
}

/*Série de Fibonacci

A série de Fibonacci é 1, 1, 2, 3, 5, 8, …. 
Fazer um programa que leia o valor de N e imprima a SOMA dos N primeiros elementos da série de Fibonacci. 
Leia um ÚNICO valor de N, que é um inteiro no intervalo [1,40].*/

import java.util.Scanner;
public class main {

  public static int fibo(int n) {
    if (n <= 1){
		return n; 
	 } 
    else{
		 return fibo(n-1) + fibo(n-2);
 	 }
}
 
  public static void main(String[] args) {
    int n = 0,  soma  = 0;
	  Scanner ler = new Scanner(System.in);
	  n = ler.nextInt();
    for (int i = 0; i <= n; i++){
		 soma += fibo(n-i);
 	 }   
	  System.out.println(soma);

  }
}

/*Páginas de Livros

Você decidiu que ler livros era uma boa opção de entretenimento. 
No início, você contava a quantidade de livros lidos, mas logo percebeu que essa contagem não era efetiva, uma vez que há livros de diferentes quantidades de páginas. 
Foi então que você, ao invés de contar a quantidade de livros, passou a contar a quantidade de páginas lidas a cada dia.
 Com o passar dos tempos, você percebeu que conseguia ler mais páginas do que anteriormente. 
 No caso, agora você lê P páginas por dia e termina D dias antes do que se estivesse lendo Q páginas por dia. 
 Com esses dados, quantas páginas tem o livro?
A entrada será uma quantidade indeterminada de três inteiros P, D e Q. A última entrada, que não deverá gerar saída, corresponde a um único valor 0 (zero).
 Para cada conjunto de entrada, a saída é a quantidade de páginas do livro.*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int a = 1, b = 1, t=1 ;
		    int total =0;
		
	
		while( (a != 0) &&( b != 0 )&&( t != 0)){
		a = ler.nextInt();
			if((a == 0)){
				break;
			}
			t = ler.nextInt();

			if(b== 0){
				break;
			}

			b = ler.nextInt();
			if(t == 0){
				break;
			}
			if((a != 0) &&( b != 0 )&&( t != 0)){
						      total =0;

				total = (-t*a*b)/(b-a);
		System.out.println(total);	
			}
			
		}
		
		
		
		
		
	}
	
	


/*Múltiplos de 13

Escrever um programa que leia um número indeterminado de dois valores inteiros 
positivos X e Y calcule a soma dos números que não são múltiplos de 13 entre X e Y, incluindo ambos. 
Considere que Y > X. Os últimos valores, que não devem gerar saída, tem valores X e Y iguais a zero.*/

import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int x = 0, y = 0, soma = 0;
				
		
		x = ler.nextInt();
		y = ler.nextInt();
		while(( x != 0) && ( y != 0)){
			soma = 0;
				for (int i = x + 1   ; i < y ; i ++){
					if(i%13 != 0){
						soma+=i;
					}
					
				}
			soma = soma +x  +y;
		
		System.out.println(soma);
		x = ler.nextInt();
		y = ler.nextInt();
			

		
		}
	
	}
	
}