/*Uma prova é composta por três questões de múltipla escolha (a, b, c, d, e).
Escreva um programa que leia as respostas dadas por um estudante às três questões. 
Em seguida, leia o gabarito esperado para essas mesmas três questões.
Como saída, indique quantas respostas estão corretas.*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int   soma = 0;
		char num ;
		String b, a ;
		a = ler.next();
		b = ler.next();
				
		for(int i = 0; i < a.length(); i++){
				if( b.charAt(i) == a.charAt(i) ){
				soma++;
				}							
		}
		

			
				System.out.println(soma);
			
	}
}
/*Durante a digitação de um texto no computador, é comum trocarmos as letras 
maiúsculas e minúsculas. Por exemplo, vAMOS PROGRAMAR em vez de Vamos programar.
Escreva um programa que leia uma string contendo caracteres maiúsculos e minúsculos 
do alfabeto. Como saída, imprima uma string em que as letras minúsculas são trocadas 
por maiúsculas e as letras maiúsculas são trocadas por minúsculas.

*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		char num ;
		String b, a ;
		
		b = ler.next();
				
		for(int i = 0; i < b.length(); i++){
				
				if(Character.isLowerCase(b.charAt(i)) ){
						num = Character.toUpperCase(b.charAt(i));
				}else{
						num = Character.toLowerCase(b.charAt(i));
				}
					System.out.print(	num);
							
		}
		

			
				System.out.println();
			
	}
}
/*Com o advento da Internet surgiu uma nova linguagem, chamada de Internetês.
 Nesta linguagem, os usuários costumam escrever muitas palavras de forma reduzida,
  normalmente removendo as vogais das palavras.
Por exemplo, a frase “tudo bem com você?” pode ser representada por “td bm cm vc?”.
Faça um script que leia uma palavra qualquer e a imprima em “internetês”.
 Para “traduzir” uma palavra para internetês, basta remover as vogais.*/
 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		String b, a ;
		a = ler.next();
		
		
		b = a.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
		System.out.println(b);
			
	}
}
/*Revisão de Contrato

Durante anos, todos os contratos da Associação de Contratos da Modernolândia (ACM)
 foram datilografados em uma velha máquina de datilografia.

Recentemente Sr. Miranda, um dos contadores da ACM, 
percebeu que a máquina apresentava falha em um, e apenas um, dos dígitos numéricos.
 Mais especificamente, o dígito falho, quando datilografado, não é impresso na folha,
como se a tecla correspondente não tivesse sido pressionada. Ele percebeu que isso 
 poderia ter alterado os valores numéricos representados nos contratos e, preocupado
  com a contabilidade, quer saber, a partir dos valores originais negociados nos
contratos, que ele mantinha em anotações manuscritas, quais os valores de fato
representados nos contratos. Por exemplo, se a máquina apresenta falha no dígito 5, 
 o valor 1500 seria datilografado no contrato como 100, pois o 5 não seria impresso.
 Note que o Sr. Miranda quer saber o valor numérico representado no contrato, ou seja,
essa mesma máquina, o número 5000 corresponde ao valor numérico 0, e não 000 (como ele 
 e fato aparece impresso).Entrada A entrada consiste de diversos casos 
      de teste, cada um em uma linha. Cada linha contém dois inteiros D e N 
      (1 <= D <= 9, 1 <= N <= 10^17 ), representando, respectivamente, o dígito que
       está apresentando problema na máquina e o número que foi negociado 
       originalmente no contrato (que podem ser grande, pois Modernolândia 
       	tem sido acometida por hiperinflação nas últimas décadas).

O ultimo caso de teste é seguido por uma linha que contém apenas dois zeros
 separados por espaços em branco.

Saída

Para cada caso de teste da entrada o seu programa deve imprimir uma linha 
contendo um único inteiro V, o valor numérico (com erro) representado de 
fato no contrato.*/
import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		String b, a, c = "";
		long temp;
		a = ler.next();
		b = ler.next();
		while(!(a.equals("0")) && !(b.equals("0"))){
			a = String.valueOf(a);
			b = String.valueOf(b);
			temp = 0;
			c = b.replaceAll(a, "");
			
			if(c.equals("")) {
				temp = 0;
			}else temp = Long.parseLong(c);
			System.out.println(temp);
		
			a = String.valueOf(ler.next());
			b = String.valueOf(ler.next());
			
			
		}

	}
}