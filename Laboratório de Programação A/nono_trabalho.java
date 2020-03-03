/*Menor

Considere uma versão extremamente primitiva da linguagem JAVA,
 em que os únicos métodos numéricos existentes são “zero”, que retorna 
 true se o argumento tem valor zero, e false, caso contrário. Além desse, 
 há também dois outros métodos “incr” e “decr”, que incrementa e decrementa
  o seu argumento em uma unidade. Isto implica que as operações >, <, = e similares,
   além dos operadores relacionais (E, OU, NÃO) não podem ser utilizados. 

Implemente uma classe nesta linguagem que contenha os métodos zero, incr,
 decr e, também, um método “menor”, que recebe dois número inteiros positivos e 
 retorna true se o primeiro argumento é numericamente inferior ao segundo e, false, 
 caso contrário. 

Implemente outra classe, que tenha somente um método main, que leia uma quantidade
 indeterminada de dois valores inteiros positivos e imprima SIM se o primeiro valor
  for menor que o segundo, ou NAO caso contrário. Os últimos valores, que não devem 
  	entrar nos cálculos, devem ser iguais a zero.

OBS: É obrigatório que a implementação do método menor seja de forma RECURSIVA.*/
import java.util.Scanner;
public class main {

  public static String igual(int x, int y) {
    
		 return (x < y) ? "SIM": "NAO";
 	 
}
 
  public static void main(String[] args) {
    int a = 0 , b =0 ;
	  
	  Scanner ler = new Scanner(System.in);
	  
	  	  a = ler.nextInt();
	    b = ler.nextInt();
		  
	  while( a != 0 && b != 0 ){
  		  System.out.println(igual(a, b));

		  a = ler.nextInt();
		  b = ler.nextInt();

	  }

  }
}
/*Igual

Com as mesmas considerações da questão anterior,
 agora implemente uma classe nesta linguagem que contenha
  os métodos zero, incr, decr e, também, um método “igual”,
   que recebe dois número inteiros positivos e retorna true 
   se o primeiro argumento é igual ao segundo e, false, caso contrário. 

Implemente outra classe, que tenha somente um método main, que
 leia uma quantidade indeterminada de dois valores inteiros positivos
  e imprima SIM se o primeiro valor for igual ao segundo, ou NAO caso 
  contrário. Os últimos valores, que não devem entrar nos cálculos, devem
   ser iguais a zero.

OBS: É obrigatório que a implementação do método igual seja de forma RECURSIVA.*/
import java.util.Scanner;
public class main {

  public static String igual(int x, int y) {
    
		 return (x == y) ? "SIM": "NAO";
 	 
}
 
  public static void main(String[] args) {
    int a = 0 , b =0 ;
	  
	  Scanner ler = new Scanner(System.in);
	  
	  	  a = ler.nextInt();
	    b = ler.nextInt();
		  
	  while( a != 0 && b != 0 ){
  		  System.out.println(igual(a, b));

		  a = ler.nextInt();
		  b = ler.nextInt();

	  }

  }
}
/*Simétrico

Até agora, essa linguagem apenas trabalha com números inteiros positivos. 
Agora, considere que os métodos incr e decr também funcionam com números negativos.

Com estas considerações, implemente uma classe nesta linguagem que contenha 
os métodos zero, incr, decr e, também, um método “simetrico”, que recebe um 
argumento inteiro positivo e retorna o seu valor simétrico. Por exemplo, 
simetrico (3) retorna -3. 

Implemente outra classe, que tenha somente um método main, que leia uma 
quantidade indeterminada de valores inteiros positivos e imprima o respectivo 
simétrico desse valor. O último valor, que não deve entrar nos cálculos, deve 
ser igual a zero.

OBS: É obrigatório que a implementação do método simetrico seja de forma RECURSIVA.*/
import java.util.Scanner;
public class main {

  public static int soma(int x) {
    
		 return x*(-1);
 	 
}
 
  public static void main(String[] args) {
    int a = 0;
	  
	  Scanner ler = new Scanner(System.in);
	  
	  	  a = ler.nextInt();
		  
	  while( a != 0){
  		  System.out.println(soma(a));

		  a = ler.nextInt();

	  }

  }
}
/*Soma

Com as mesmas considerações da questão anterior, 
agora implemente uma classe nesta linguagem que contenha 
os métodos zero, incr, decr e, também, um método “soma”, 
que recebe dois número inteiros positivos e retorne o valor
 da soma dos dois valores. 

Implemente outra classe, que tenha somente um método main,
 que leia uma quantidade indeterminada de dois valores inteiros 
 positivos e imprima o valor da soma dos dois valores.
  Os últimos valores, que não devem entrar nos cálculos, devem ser iguais a zero.

OBS: É obrigatório que a implementação do método soma seja de forma RECURSIVA.*/
import java.util.Scanner;
public class main {

  public static int soma(int x,  int y ) {
    
		 return x +  y;
 	 
}
 
  public static void main(String[] args) {
    int a = 0, b = 0,  soma  = 0;
	  
	  Scanner ler = new Scanner(System.in);
	  
	  	  a = ler.nextInt();
		  b = ler.nextInt();
	  while( a != 0  && b != 0){
  		  System.out.println(soma(a, b));

		  a = ler.nextInt();
		  b = ler.nextInt();

	  }

  }
}
/*Multiplicação

Com as mesmas considerações da questão anterior, 
agora implemente uma classe nesta linguagem que contenha 
os métodos zero, incr, decr, soma e, também, um método “multiplica”, 
que recebe dois número inteiros positivos e retorne o valor da multiplicação 
dos dois valores através de somas sucessivas (Ex.: 6 * 4 = 4 + 4 + 4 + 4 + 4 + 4).

Implemente outra classe, que tenha somente um método main,
 que leia uma quantidade indeterminada de dois valores inteiros 
 positivos e imprima o valor da multiplicação dos dois valores. Os últimos valores, que não devem entrar nos cálculos, devem ser iguais a zero.

OBS: É obrigatório que a implementação do método soma seja de forma RECURSIVA.*/
import java.util.Scanner;
public class main {

  public static int mult(int x,  int y ) {
    if (y <= 1){
		return x; 
	 } 
    else{
		 return x +  mult(x, y - 1);
 	 }
}
 
  public static void main(String[] args) {
    int a = 0, b = 0,  soma  = 0;
	  
	  Scanner ler = new Scanner(System.in);
	  
	  	  a = ler.nextInt();
		  b = ler.nextInt();
	  while( a != 0  && b != 0){
  		  System.out.println(mult(a, b));

		  a = ler.nextInt();
		  b = ler.nextInt();

	  }

  }
}