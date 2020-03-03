/*Conversão de Mensagens de Letras para Binário

Já pensou em enviar uma mensagem codificada em 
binário para alguém, talvez pensando em uma comunicação 
secreta? O objetivo deste trabalho é você escrever um 
programa que receba uma mensagem e a codifique em binário. 
 Use a Tabela ASCII, onde cada caractere ocupa 8 bits. Assuma
  que as mensagens são de até 200 caracteres, incluindo somente
   letras maiúsculas, minúsculas e espaço em branco. Isto é, neste 
   momento não considere os diversos símbolos (pontuação, aritméticos, etc)
    e letras acentuadas.
 Note que a saída é uma sequencia de bytes separados por um espaço em branco.*/
 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		
		String a = ler.nextLine();
		//String b = ler.next();		
		
		for(int i = 0; i < a.length(); i++){
					
				if (i == a.length()){
						
							System.out.println("0" + Integer.toBinaryString( (int)a.charAt(i)) );
				}else{
					if( a.charAt(i) == (' ') ){
							System.out.print("00" + Integer.toBinaryString( (int)a.charAt(i)) +" ");

					}else{
							System.out.print("0" + Integer.toBinaryString( (int)a.charAt(i)) +" ");
					}
				}
		}				
	}
}
/*Conversão de Mensagens de Binário para Letras

Agora, faça o processo inverso, ou seja, dado uma codificação binária, 
converta para as letras correspondentes. Use a Tabela ASCII, onde cada
 caractere ocupa 8 bits. Verifique que a entrada NÃO contém espaços em branco.
 Assuma que a entrada é sempre menor que mil dígitos binários.*/

 import java.util.Scanner;
public class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		
		
		String a =  ler.next();
		String num = "";
		String aux = "";
		
		for(int i = 1; i <= a.length(); i++){
				if(i%8 == 0){
					aux = a.substring( i - 8, i);
					num +=(char)(Integer.parseInt(aux, 2));
				}
				
		}
		System.out.println(num);
		
			
	}
	
	
	

}