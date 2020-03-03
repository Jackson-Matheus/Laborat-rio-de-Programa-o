/*Verifica se um bit foi alterado

Ler dois números inteiros (a e b) de 8 bits (do tipo short) e um valor de bit (entre 0 e 7,
 que pode ser do tipo byte) e verifique se o valor desse bit foi alterado de a para b. Se sim,
  imprima "SIM" e "NAO" caso contrário (sem as aspas). Repetir o processo acima até que as entradas dos valores de a e b sejam, respectivamente, 0 e 255.

PS. A razão do tipo de dados das variáveis a e b serem short e não byte é
 que os tipos em Java são todos com sinal, o que implica que o tipo byte só compreende os valores de -128 a 127.*/

 import java.util.Scanner;
public class main{	
	public static String ate(int i) {
 		 return Integer.toBinaryString(i);
	}
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a, b, c, n, val, val_2;	
		a = ler.nextInt();
		b = ler.nextInt();
		while(a != 0 || b != 255){
			n = ler.nextInt();
			//System.out.println(ate(a));
			//System.out.println(ate(b));
			val = 1 & a >> n;
			//System.out.println("Val "+ ate(val));
			val_2 = 1 &  b >> n;
			//System.out.println("Val_2 "+ ate(val_2));
			if(val != val_2){
				System.out.println("SIM");
			}else{
				System.out.println("NAO");
			}
				a = ler.nextInt();
				b = ler.nextInt();
	}
		
	}
}
/*Alternância de bit

Ler uma quantidade indeterminada de um valor inteiro de 16 bits e, em seguida, ler um número de bit (entre 0 e 15) e 
alterne somente esse bit, ou seja, se esse bit for 1, troque para 0; se o bit for 0, troque para 1.
 Imprima esse novo inteiro com o bit trocado. O último valor, que não deverá produzir saída, tem o valor de 65535.

 

PS. Apesar do tipo short conter 16 bits este não deve ser usado porque, 
em Java, todos os tipos numérios são todos com sinal, o que implica que o tipo short compreende os valores de 
-32.768 e 32.767 (15 bits + sinal), o que não será possível executar os casos de teste. Neste caso, sugiro usar o tipo int.
 Já para a leitura do número do bit sugiro que seja usado o tipo byte.*/
 import java.util.Scanner;
public class main{	
	public static String ate(int i) {
 		 return Integer.toBinaryString(i);
	}
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
	   int a, b;	
		a = ler.nextInt();
		while(a != 65535){
				//System.out.println(ate(a));			

				b = ler.nextInt();
				int aux = a >> b;
				//System.out.println(ate(aux));
				int val = aux & 1;
				//System.out.println(ate(val));
				if(val ==  0){
					int zero  = 0;
					zero = zero | 1;
					zero  = zero << b;
					a = a | zero;
				}else{
					int um = 1;
					um = um<<b;
					a = a^um;					
				}
				//System.out.println(ate(a));			

				System.out.println(a);			

				a = ler.nextInt();
		}
	}
}
/*Trocar bits para um padrão predeterminado

Ler uma quantidade indeterminada de um valor inteiro de 8 bits e, em seguida, trocar os 
TRÊS bits menos significativos para um outro valor lido. 
Obviamente que esse outro valor tem que estar no intervalo 0 a 7. Use a estratégia de duas máscaras. O último
 valor, que não deverá produzir saída, tem o valor de 255.

PS. Sugiro fortemente que o tipo de dado para o valor inteiro de 8 bits seja short (16 bits) e 
não byte (8 bits). A razão é que todos os tipos numéricos em Java são todos com sinal, o que implica que o tipo só
 byte compreende os valores de -128 a 127, o que não será possível executar os casos de teste.*/
 import java.util.Scanner;
public class main{		
	public static String ate(int i) {
 		 return Integer.toBinaryString(i);
	}
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a, b, val;
		a = ler.nextInt();
			while( a != 255){
				b = ler.nextInt();
		
				a = a>>3;
				a= a<<3;
				a= a|b;
				System.out.println(a);
				a = ler.nextInt();
				//}
			}
	}
}
/*Deslocamento CIRCULAR de bits para a ESQUERDA

Ler uma quantidade indeterminada de um valor inteiro positivo de 16 bits 
(short) e, em seguida, ler uma quantidade de deslocamentos (número entre 0 e 15) de bits para a
 ESQUERDA. Imprima esse novo inteiro após ter feito o deslocamento. Entretanto, o deslocamento dever 
 ser circular, ou seja, o deslocamento é feito mas os bits mais significativos não devem ser perdidos, 
 mas esses mesmos bits (mais significativos) devem ser os novos bits menos significativos. O último valor, 
 que não deverá produzir saída, tem o valor de 65535.

PS. Se tiver dificuldade em usar o tipo short é também possível usar o tipo int (32 bits), mas tem-se que ter um cuidado adicional de só considerar os 16 bits*/
import java.util.Scanner;
public class main{		
	public static String ate(int i) {
 		 return Integer.toBinaryString(i);
	}
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a, b, val;
		int maior = 65535;
		a = ler.nextInt();
			while( a != 65535){
				b = ler.nextInt();			
				val = a>>(16-b);
				//System.out.println(ate(val));
				
				a = a<<b;
				a= a & maior;
				//System.out.println(ate(a));
				a= a | val;
				System.out.println(a);
				a = ler.nextInt();
				
			}
	}
}
/*Deslocamento CIRCULAR de bits para a DIREITA

Ler uma quantidade indeterminada de um valor inteiro de 16 bits 
(short) e, em seguida, ler uma quantidade de deslocamentos (número entre 0 e 15) de 
bits para a DIREITA. Imprima esse novo inteiro após ter feito o deslocamento. Entretanto,
 o deslocamento dever ser circular, ou seja, o deslocamento é feito, mas os bits menos significativos 
 não são perdidos, isto é, esses mesmos bits (menos significativos) devem ser os novos bits mais significativos. 
 O último valor, que não deverá produzir saída, tem o valor de 65535.

PS. Se tiver dificuldade em usar o tipo short é também possível usar o tipo int (32 bits), mas tem-se que ter um
 cuidado adicional de só considerar os 16 bits.*/
 import java.util.Scanner;
public class main{		
	public static String ate(int i) {
 		 return Integer.toBinaryString(i);
	}
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int a, b, val;
		int maior = 65535;
		a = ler.nextInt();
			while( a != 65535){
				b = ler.nextInt();			
				val = a<<(16-b);
				val = val & maior;
				//System.out.println(ate(val));
				
				a = a>>b;
				
				//System.out.println(ate(a));
				a= a | val;
				System.out.println(a);
				a = ler.nextInt();
				
			}
	}
}
