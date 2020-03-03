/*Fazer um programa que leia três números inteiros e imprima a soma destes.*/



import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
			int a = ler.nextInt();
			int b = ler.nextInt();
			int c = ler.nextInt();
		
			int soma;
			soma = a + b + c;
			System.out.println(soma);
		
		
		
	}
	
	
}



/*Dado o raio de um círculo, calcular sua área e perímetro. Considere PI = 3.14, e as saídas devem ser sempre arredondas para duas casas decimais.
*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		double r, p, area;
		
		r = ler.nextFloat();
		
		area = 3.14*r*r;
		p = 2*3.14*r;
		System.out.printf("%.2f\n", area);
		System.out.printf("%.2f\n",p);
	
		
		
		
	}
	
	
}

/*Considere um retângulo de lados L1 e L2. Calcular a área e o perímetro desse retângulo, lidos os lados. As saídas devem ser sempre arredondadas para 2 casas decimais.*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		double l1, l2, p, area;
		
		l1= ler.nextDouble();
		l2 = ler.nextDouble();

		
		area = l1*l2;
		p = 2*l1 + 2*l2;
		System.out.printf("%.2f\n", area);
		System.out.printf("%.2f\n",p);
	
		
		
		
	}
	
	
}

/*Fazer um programa que receba os dois catetos de um triângulo retângulo (ponto flutuante), calcule e imprima a hipotenusa. Considere que a saída deve ser sempre arredondada para 2 casas decimais.*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		double l1, l2, hip;
		
		l1= ler.nextDouble();
		l2 = ler.nextDouble();

		
		hip = Math.pow((l1*l1 + l2*l2), 0.5);

		System.out.printf("%.2f\n", hip);
	
		
		
		
	}
	
	
}

/*Faça um programa que leia QUATRO valores inteiros e imprima o MENOR deles.*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , b , c, d , menor = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		
		if((a  < b) && ( a < c) && (a < d)){
			menor = a;
		}
		else	if(( b < a) && ( b < c) && (b < d)){
			menor = b;
		}
		else	if((c  < a) && ( c < b) && ( c < d)) {
			menor = c;
		}
		else{// if(( d < a) && ( d < b) && ( d < c)){
			menor = d;
			
		}
		System.out.println(menor);

			
		
		
	}
	
	
}
/*
Fazer um programa que leia o salário fixo e o valor das vendas efetuadas 
pelo vendedor de uma empresa (ambas valores em ponto flutuante). 
Sabendo-se que ele recebe uma comissão de 3% sobre o total das vendas até
R$ 1.500,00 mais 5% sobre o que ultrapassar este valor, calcular e escrever o seu salário total
(também valor em ponto flutuante com duas casas decimais).

*/

import java.util.Scanner;

public class main{
	public static void main(String[] args){

		Scanner ler = new Scanner(System.in);
		double sal, vendas;
		

		sal = ler.nextDouble();
		vendas = ler.nextDouble();
		
		double salNovo = 0;
		double x, temp;
		
		

		if (( vendas >= 0) && (vendas <= 1500)){
			salNovo = sal + vendas*(0.03);

		}
		else{

			temp = 0.05*(vendas - 1500);
			salNovo = 45 + sal + temp;
			
			
			
		}
		System.out.printf("%.2f \n", salNovo);

				
	}
	
	
}

/*Faça um programa que leia a nota final (real), o total de presenças de um aluno (inteiro). 
Leia também o percentual de frequência necessária para passar (inteiro), o total de aulas ministradas (inteiro), e a nota mínima para passar (real).
 Verificar, pelas notas e frequências, e imprimir SIM se este aluno foi aprovado ou NAO se foi reprovado.*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		float nota, minima;
		int  presenca, presenca_Min, aulas;


		nota = ler.nextFloat();
		presenca = ler.nextInt();

		presenca_Min = ler.nextInt();

		aulas = ler.nextInt();

		minima = ler.nextFloat();

		if(( nota >= minima) &&( presenca >= presenca_Min)){
				System.out.println("SIM");
		}
		else{
					System.out.println("NAO");
					
			}
	


		
		
		
		
	}
	
	
}
/*
Faça um programa que leia dois números inteiros A e B. Se A for maior que B, então imprima a diferença de A menos B; 
se A for menor que a B, então imprima a diferença de B menos A. Se A e B forem iguais, então imprima o valor 0 (zero).*/

import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , b, x;
		
		a = ler.nextInt();
		b = ler.nextInt();
	x = 0;
			if (a > b){
				x = a - b; 
			}
		else{
				x = b - a; 

		}
		System.out.println(x);

	
		
		
		
	}
	
	
}

/*Faça um programa que leia QUATRO valores inteiros e imprima o MAIOR deles.

*/
import static java.lang.Math.pow;
import java.util.Scanner;

public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a , b , c, d , maior = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		c = ler.nextInt();
		d = ler.nextInt();
		
		if((a  > b) && ( a > c) && (a > d)){
			maior = a;
		}
		else	if(( b > a) && ( b > c) && (b > d)){
			maior = b;
		}
		else	if((c  > a) && ( c > b) && ( c > d)) {
			maior = c;
		}
		else{// if(( d < a) && ( d < b) && ( d < c)){
			maior = d;
			
		}
		System.out.println(maior);

			
		
		
	}
	
	
}

/*Faça um programa para calcular o MDC de dois números inteiros X e Y.*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		
		Scanner ler = new Scanner(System.in);

			int resto = 0;
			int a, b;

			a = ler.nextInt();
			b = ler.nextInt();

		 while( b != 0){
			 resto = a%b;
			 a = b;
			 b = resto;
			 
			 
		 }
		System.out.println(a);
	
	}
	
	
}
