/*Retorno de Investimento

Um investidor construiu uma embarcação a um custo de R$ INV para transportar
 até P passageiros entre Manaus e Parintins.

Considere que uma viagem tem custo fixo de R$ CF, cobrindo todas as despesas
 (combustível, salário da tripulação, alimentação, e taxas da capitania dos portos).

As possibilidades de saída da embarcação são: (i) 2 viagens por semana; e (ii)
 4 viagens por semana.

As passagens custam R$ PN (normal) e R$ PD (diferenciado), que são dois modelos 
de venda de passagens.
 Estima-se que viajando duas vezes por semana e usando o modelo normal 100% das 
 passagens serão vendidas, mas com o modelo diferenciado seriam vendidas apenas 90% das passagens. Estima-se que viajando quatro vezes por semana com o modelo normal as vendas chegariam a 85% das passagens, enquanto que o modelo diferenciado alcançaria 70% das passagens.

Assumindo que cada viagem pode ser ou normal ou diferenciada, calcule em quantas
 semanas o investidor terá o seu investimento retornado, na seguinte ordem: Normal
  (2 viagens), Normal (4 viagens), Diferenciada (2 viagens) e Diferenciada (4 viagens).
  Na resposta das quantidades de semanas, considere sempre o valor inteiro maior ou 
  igual ao valor calculado. Por exemplo, se o valor calculado for 20.1, a resposta
   deve ser 21.

A entrada será os valores de INV, P, CF, PN e PD. A saída deve ser a quantidade de
 semanas para o retorno do investimento para cada um dos modelos e preços.*/

 import java.util.Scanner;

public class main{
	public static void main(String[] args){
				Scanner ler = new Scanner(System.in);

		int inv, p, cf, pn, pd;

		inv = ler.nextInt();
		p = ler.nextInt();
		cf = ler.nextInt();
		pn = ler.nextInt();
		pd = ler.nextInt();
		
 /*passagem 2x normal 100%*/
		float sem = 0.0f;
		float valor_total = 0;
		float total = 0;
		total = (pn*p - cf);

		while(valor_total < inv){
			valor_total += total;
			sem++;
		}
		//System.out.print( convertido (sem_1/4.0f)  +" ");
		//System.out.print( parOuImpar (sem/4.0f)  +" ");
		System.out.print( trunca (sem/4.0f)  +" ");

/*passagem 4x normal 85%%*/
		
		valor_total = 0; total = 0;
		sem = 0; 
	
		total = ((pn*p*0.85f) - cf);
		while(valor_total < inv){
			valor_total += total;
			sem++;
		}
		//System.out.print(convertido((sem_2)/8.0f) + " ");
		//System.out.print( convertido(sem/8.0f)  +" ");
		System.out.print( trunca(sem/8.0f)  +" ");




/*passagem 2x diferenciada 90%%*/

		valor_total= 0; total= 0;
		sem = 0; 

		total = (pd*(p*0.90f) - cf)	;
		while(valor_total < inv){
			valor_total += total;
			sem++;
		}
		//System.out.print(convertido(sem/4.0f) + " ");
		System.out.print(trunca(sem/4.0f) + " ");



/*passagem 4x diferenciada 70%%*/

		valor_total = 0; total=0;
		sem = 0; 
	
		total = ((pd*p*0.70f) - cf);
		while(valor_total < inv){
			valor_total += total;
			sem++;
		}
		//System.out.println(parOuImpar((sem)/8.0f));
//		System.out.println(convertido ((sem)/8.0f));
		System.out.println(trunca ((sem)/8.0f));
	}

	static int convertido(float a){
			
			String temp;
			float  sem = 0;
			int aux = 0;
			
			temp = String.valueOf(sem);

			for(int k = 0; k < temp.length() - 1 ; k++){
				if(temp.charAt(k) == '.'){
					if(temp.charAt(k  + 1) != ' '){
						aux = (int)(a);
						aux++;
					}
			}else{
			}
		
			}

			return aux;
	}
	static int parOuImpar(float num){
			int a;
			if ((num%2 == 0) || (((num - 1) %2) == 0)){
				a = (int)num;
			}
			else{
				a = (int)num + 1;
			}
			return a;
	}
	static int trunca(float x){
		int a ;
		a = (int)x;
		if(x > (float)a ){a++;}
		return (int)a;
	}
}
/*Pontos e Distância entre Pontos 

PARTE 1:

Implementar uma classe de objetos chamada Ponto que represente um ponto (x,y) no R2,
 onde x é a abscissa e y é a ordenada, ambos valores INTEIROS, e adicione os seguintes
 métodos:
(i) Ponto: construtor da classe sem parâmetros;
(ii) Ponto: construtor da classe através dos parâmetros x e y;
(iii) getX: devolve a abscissa do ponto;
(iv) getY: devolve a ordenada do ponto;
(v) setX: atribui novo valor para a abscissa; e 
(vi) setY: atribui novo valor para a ordenada. 

PARTE 2:

Implementar outra classe de objetos chamada DistanciaPontos,
 que tenha dois objetos da classe Ponto e os seguintes métodos: 
(i) DistanciaPontos: construtor da classe que recebe os dois objetos
 da classe Ponto;
(ii) distância: retorna a distância entre os dois pontos.

PARTE 3:

Implementar outra classe de objetos que tenha um método que leia uma
 quantidade indeterminada de quatro inteiros. Para cada conjunto de (quatro)
  valores lidos: (a) crie dois objetos da classe Ponto; (b) crie um objeto da
   classe DistanciaPontos usando os dois objetos da classe Ponto; (c) chame o 
   método distancia para calcular e imprimir a distância entre os dois pontos.
    Considere que a distância é ARREDONDADA para duas casas decimais. O último valor, 
que não deverá entrar nos cálculos, deve ter valor igual a -1 (um negativo).*/

import java.lang.*;
import java.util.Scanner;
  class Main{
	public static void    main(String[] args) {
		int a = 0, b = 0, c = 0, d = 0;
		Scanner ler = new Scanner(System.in);
			a = ler.nextInt();
			//b = ler.nextInt();
		//	c = ler.nextInt();
		//	d = ler.nextInt();
			Ponto p1, p2;
		while((a != -1)){// && (b != -1) && (c != -1) && (d != -1)){
						b = ler.nextInt();
						c = ler.nextInt();
						d = ler.nextInt();



			p1 = new Ponto(a, b);
			p2 = new Ponto(c, d);
			
			DistanciaPontos dis;
			dis = new DistanciaPontos(p1, p2);
			System.out.printf("%.2f \n", dis.distanciaDoisPontos(p1, p2));
			a = ler.nextInt();
			//b = ler.nextInt();
			//c = ler.nextInt();
			//d = ler.nextInt();
		}
	}
	
	
}
 class Ponto{
	private int x;
	private int y;
	
	Ponto(){
		this.setX(this.getX());
		this.setY(this.getY());
	}

	Ponto(int x, int y){
		this.setX(x);
		this.setY(y);
	}
		
	public void setX(int novo_x){
		this.x = novo_x;
	}
	public int getX(){
		return x;
	}
	//////////////////////////////////
	public void setY(int novo_y){
		this.y = novo_y;
	}
	public int getY(){
		return y;
	}	
}
 class DistanciaPontos{
	private Ponto ponto1;
	private Ponto ponto2;
	DistanciaPontos(Ponto p, Ponto q){
		this.setPonto1(p);
		this.setPonto2(q);

	}
    public void setPonto1(Ponto ab){
        this.ponto1 = ab;
    }
 
    public Ponto getP1(){
        return this.ponto1;
    }
 
    public void setPonto2(Ponto cd){
        this.ponto1 = cd;
    }
 
    public Ponto get2(){
        return this.ponto2;
    }
	 public double distanciaDoisPontos(Ponto p1, Ponto p2){
		double a = p1.getX();
		double b = p1.getY();
		double c = p2.getX();
		double d = p2.getY();
	return Math.pow( Math.pow( ( a - c), 2)  + Math.pow((b - d) , 2), 0.5);
	}
}
/*

Erro de Circuito Lógico

Joãozinho fez um somador de 8 bits como exame no laboratório de circuitos 
lógicos. Só que ele acabou cometendo um erro. Ele estava fazendo soma de bits,
 mas seu carregador de bit (carry, ou “vai um”) sempre levava o valor zero. Portanto, 

  4 = 00000100
+6 = 00000110
----------------------------------------
  2  = 00000010

Ou seja, ao invés de dar o valor 1010 (que equivale ao valor 10),
 deu o valor 0010 (que equivale ao valor 2).

Escreva um programa que leia um número indeterminado de PARES de
 valores inteiros de 8 bits, sem sinal, como entrada, e produza um
  outro número de 8 bits sem sinal como saída, como a soma dos dois 
  valores, só que tal soma deve ser feita do mesmo modo como o circuito 
  (com erro) faria. Os últimos valores, que não deverão entrar nos cálculos,
 que é o critério de parada, são dois valores iguais a zero.*/
 import java.util.*;
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		
		Scanner ler = new Scanner(System.in);
			int valor ,  valor_2 ;

			valor   = ler.nextInt();
			valor_2 = ler.nextInt();


			while(valor != 0 && valor_2 != 0){
			String bin = Integer.toString(valor, 2);
			String bin_2 = Integer.toString(valor_2, 2);
			String paraString  = "";
			int soma = 0;
			int num1 = 0, num2 = 0;
			if(bin.length() < 8){
				int tam = 8 - bin.length();
				for (int i = bin.length();i < 8  ;i++ ) {
					bin = "0" + bin ;
					
				}
			}
			if(bin_2.length() < 8){
				for (int i = bin_2.length();i < 8 ;i++ ) {
				bin_2 =  "0" + bin_2;
					
				}

			}
			for(int i  = bin.length() - 1 ; i >= 0 ; i--){
				soma = 0;				
				num1 =  Character.getNumericValue(bin.charAt(i));
				num2 =  Character.getNumericValue(bin_2.charAt(i));

				if((num1 == num2) || ( (num2 == 0 && num1 == 0)) ){
					soma = 0;
				}
				else{
					soma = num1 + num2;
				}
				paraString =   String.valueOf(soma)  + paraString ;
			}

			int numero = Integer.parseInt(paraString, 2);
			System.out.println( numero);
			valor   = ler.nextInt();
			valor_2 = ler.nextInt();


		}




		}

}
/*Serie de FETUCCINE

A serie de FETUCCINE é gerada da seguinte forma:
 os dois primeiros termos são fornecidos pelo usuário; 
 a partir dai, os termos são gerados através da soma ou 
 subtração dos dois termos anteriores, ou seja:

Ai = Ai-1 + Ai-2, para i ímpar
Ai = Ai-1 - Ai-2, para i par

Escreva um programa que leia os valores de N1, N2 e N e imprima os 
N primeiros termos da serie de FETUCCINE, onde N > 2.*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		int a, b, n, termo = 0;
		
		a = ler.nextInt();
		b = ler.nextInt();
		
		n = ler.nextInt();

		System.out.println(a);
		System.out.println(b);

		for(int i = 3;  i <= n; i++){
			if(i%2 == 0){
				termo = b - a; 	
			}else {
				termo = b + a; 
			}
			a = b; 
			b = termo;
		System.out.println(termo);
		}
	}
	
}