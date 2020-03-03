/*Fazer um programa que leia uma quantidade indeterminada de três números inteiros e, para cada grupo de três, imprima a soma destes. 
Os últimos três valores, que não deverão gerar saída, que é o critério de parada, devem ser todos iguais a 0 (zero).
*/
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);

		boolean cond;
		cond  = true;


		int a, b, c;
		int soma;

			a = ler.nextInt();
			b = ler.nextInt();
			c = ler.nextInt();
		//while( cond == true){
		while((a != 0) && ( b != 0) && ( c != 0 )){

			//if ((a == 0) && ( b == 0) && ( c == 0 )){
		//			cond = false;
			//}
			soma = a + b + c;
			System.out.println(soma);
			a = ler.nextInt();
			b = ler.nextInt();
			c = ler.nextInt();
		}




	}



}
/*
Fazer um programa que leia uma quantidade indeterminada de raios de um círculo. Para cada raio lido, calcular sua área e perímetro.
 Considere PI = 3.14, e as saídas devem ser sempre arredondas para duas casas decimais. 
 Considere que o raio é positivo e maior que zero. O último valor do raio, que não deverá gerar saída porque é o critério de parada, deve ser igual a -1 (um negativo).
*/
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		double area, perimetro, raio;

		raio = ler.nextDouble();
		while( raio != -1){
			
			area = 3.14*raio*raio;
			perimetro = 2*3.14*raio;
				
			System.out.printf("%.2f", area);
			System.out.printf(" %.2f\n", perimetro);
			
			raio = ler.nextDouble();
		}




	}



}

/*Fazer um programa que leia uma quantidade indeterminada de retângulos de lados L1 e L2 (ponto flutuante). Calcular a área e o perímetro desse retângulo. 
As saídas devem ser sempre arredondadas para 2 casas decimais. Os últimos dois lados do último retângulo, que não deverão gerar saída porque é o critério de parada, devem ser todos iguais a 0 (zero).*/

import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		double area, perimetro, l1, l2;

		l1 = ler.nextDouble();
		l2 = ler.nextDouble();
		while((l1 != 0 ) && (l2 != 0) ){
			
			area = l1*l2;
			perimetro = 2*l1 + 2*l2;
				
			System.out.printf("%.2f", area);
			System.out.printf(" %.2f\n", perimetro);
			
			l1 = ler.nextDouble();
		l2 = ler.nextDouble();
		}




	}



}

/*Fazer um programa que receba uma quantidade indeterminada de dois catetos (maiores que zero) de um triângulo retângulo (ponto flutuante). 
Para cada par de catetos, calcule e imprima a hipotenusa. Considere que a saída deve ser sempre arredondada para 2 casas decimais. 
Os últimos dois catetos do último triângulo, que não deverão gerar saída porque é o critério de parada, devem ser todos iguais a 0 (zero).*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		double l1, l2, hip;
		
			l1= ler.nextDouble();
			l2 = ler.nextDouble();

		while((l1 != 0 ) && (l2 != 0) ){
		


			hip = Math.pow((l1*l1 + l2*l2), 0.5);

			System.out.printf("%.2f\n", hip);
			
			l1= ler.nextDouble();
			l2 = ler.nextDouble();
		}
		
		
		
	}
	
	
}

/*Fazer um programa que leia uma quantidade indeterminada de CINCO valores inteiros e imprima o MAIOR deles.
 Os últimos valores, que não deverão gerar saída (que é o critério de parada), devem ser entrados todos os cinco valores iguais a 0 (zero).*/

 import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , b , c, d ,e ,  maior = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		e = ler.nextInt();
		
		
		while(( a != 0 )&& (b != 0) && ( c != 0) && (d != 0) && (e != 0)){
		
		if((a  > b) && ( a > c) && (a > d) &&( a > e)){
			maior = a;
		}
		else	if(( b > a) && ( b > c) && (b > d) && (b > e)){
			maior = b;
		}
		else	if((c  > a) && ( c > b) && ( c > d) &&( c > e)) {
			maior = c;
		}
		else if ((d  > a) && ( d > b) && (d > c) && ( d > e)){
			maior = d;
		}
		else{
				maior = e;
		}
		System.out.println(maior);
			
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		e = ler.nextInt();

		}

			
		
		
	}
	
	
}

/*Fazer um programa que leia uma quantidade indeterminada de CINCO valores inteiros e imprima o MENOR deles. 
Os últimos valores, que não deverão gerar saída (que é o critério de parada), devem ser entrados todos os cinco valores iguais a 0 (zero).*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , b , c , d , e,  menor = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		e = ler.nextInt();
		
		
		while(( a != 0 ) || (b != 0) || ( c != 0) || (d != 0) || (e != 0)){
		
		if((a  < b) && ( a < c) && (a < d) &&( a < e)){
			menor = a;
		}
		else	if(( b < a) && ( b < c) && (b < d) && (b < e)){
			menor = b;
		}
		else	if((c  < a) && ( c < b) && ( c < d) &&( c < e)) {
			menor = c;
		}
		else if ((d  < a) && ( d < b) && (d < c) && ( d < e)){
			menor = d;
		}
		else{
			menor = e;
		}
		System.out.println(menor);
			
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		e = ler.nextInt();

		}

			
		
		
	}
	
	
}
/*
Fazer um programa que leia uma quantidade indeterminada de números inteiros N (todos maiores ou iguais a 1) e, para cada número, 
calcule e imprima a soma de todos os números naturais de 1 até N. 
O último valor, que não deverá  gerar saída porque é o critério de parada, deve ser igual a 0 (zero).*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , soma;
		
		a = ler.nextInt();
		int i;	
		while(a >= 1){
			soma = 0;
			i = 1;
			while( i <= a){
				soma += i;
				i++;
			}
		
		
		System.out.println(soma);
			
		a = ler.nextInt();
		
		}

			
		
		
	}
	
	
}

/*Fazer um programa que leia uma quantidade indeterminada de números inteiros N (todos maiores ou iguais a 1) e,
 para cada número, calcule e imprima a soma de todos os números PARES de 1 até N. 
O último valor, que não deverão gerar saída porque é o critério de parada, deve ser igual a 0 (zero).
*/
import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , soma;
		
		a = ler.nextInt();
		

		int i;	
		while((a >= 1) && (a != 0)){
			soma = 0;
				
			for (i = 1; i <= a ;i++ ) {
	
				if ((i%2 == 0) && ( i != 1) ){
					soma += i;
				}
			
			}
		
		
		System.out.println(soma);
			
		a = ler.nextInt();
		
		}

			
		
		
	}
	
	
}
/*
Fazer um programa que leia uma quantidade indeterminada de números inteiros N (todos maiores ou iguais a 1) e, para cada número, 
calcule e imprima a soma de todos os números ÍMPARES de 1 até N. O último valor, que não deverá gerar 
saída, porque é o critério de parada, deve ser igual a 0 (zero).*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , soma;
		
		a = ler.nextInt();
		

		int i;	
		while((a >= 1) && (a != 0)){
			soma = 0;
				
			for (i = 1; i <= a ;i++ ) {
	
				if ((i%2 != 0)){
					soma += i;
				}
			
			}
		
		
		System.out.println(soma);
			
		a = ler.nextInt();
		
		}

			
		
		
	}
	
	
}

/*Fazer um programa que leia uma quantidade indeterminada de valores inteiros N. Para 
cada valor, calcule e imprima a soma dos N primeiros termos da série:
4 - (4/3) + (4/5) - (4/7) + (4/9) - (4/11) + . . . 
O último valor de N, que não deverá gerar saída (que é o critério de parada), 
deve ser igual a 0 (zero). Considere que a saída deve ter sempre 3 casas decimais.repe*/

import java.util.Scanner;
import java.lang.Math;


public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		int n ;
		float temp = 0;
		double soma, frac;

		n = ler.nextInt();
		float x;
		while(n != 0  ){
			soma = 0;
			x = 1;
			//i = 1;

			for (int i = 1; i <= n ; i++ ) {
				if (i%2 == 0){	
					temp = -4.0f;
				}else{
					temp =  4.0f;
				}
				frac = temp/x;
				x = x + 2;
				soma = frac + soma;
			}

		System.out.printf(" %.3f\n", soma);
		n = ler.nextInt();


		}




	}



}