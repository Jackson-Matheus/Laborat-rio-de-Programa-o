/*Sudoku é um jogo divertido (e viciante!), que é uma febre no mundo inteiro. Nada mais é do que um 
quebra-cabeça baseado na colocação lógica de números. O objetivo do jogo é completar os espaços vazios
 com números de 1 a 9, tanto na linha, coluna quanto no bloco. O desafio é o número não pode ser repetido
  na mesma linha, coluna ou bloco. A atração do jogo é que as regras são simples, contudo, a linha de raciocínio
   requerida para alcançar a solução pode ser complexa. Há diversos sites e aplicativos para smartphones onde é 
   possível jogar online. Neste trabalho, os sudoku serão “muito simples” e “simples”. A entrada será uma matriz 
   parcialmente preenchida. Assuma que o valor 0 significa “espaço em branco”.
Técnica do número sozinho 

A técnica consiste em anotar em TODOS os espaços em branco quais valores (de 1 a 9)
 são possíveis serem colocados na respectiva célula. Após a anotação de todos os valores
  possíveis em cada célula, a próxima tarefa é procurar em quais células resta somente um valor possível. 
  Neste caso, este valor deve ser colocado na respectiva célula e um procedimento de ajustes deve ser feito 
  para re-anotar os novos valores possíveis em cada célula. Neste caso em particular, uma otimização pode ser 
  feita no sentido de que deve ser ajustado somente a linha, coluna e setor onde foi incluindo o valor. O programa 
  deve parar quando a matriz estiver completamente preenchida. É GARANTIDO QUE OS SUDOKUS DE TESTE SERÃO RESPONDIDOS COMPLETAMENTE USANDO ESTA TÉCNICA.

O site abaixo tem opção de executar o sudoku e ver as marcações:
https://www.geniol.com.br/logica/sudoku/*/

import java.util.Scanner;
public class main{
	private int[][] mat;
	main( int numL, int numC){
		this.mat = new int[numL][numC];	
	}
	public void ler(int numL, int numC){
		Scanner ler = new Scanner(System.in);
		for( int i = 0;i < numL; i++){
			for( int j = 0; j < numC; j++){
				this.mat[i][j] = ler.nextInt(); /*mat[i][j];*/
			}
		}
	}
	public  boolean verificaLInha(int proc, int lin){
		for(int j = 0 ; j < 9;j++ ){
			if(mat[lin][j] == proc)
				return true;
		}
		return false;				
	}
	public  boolean verificaColuna(int proc, int col){
		for(int i = 0; i < 9;i++){
				if(mat[i][col] == proc)
					return true;
		}
		return false;		
	}
	public  boolean is3x3(int proc, int col, int lin){
		int a = lin - lin%3;
		int b = col - col%3;
		for(int i = a; i < a+3 && a+3 < 9; i++){
			for( int j = b; j < b+3 && b+3 < 9; j++){
				if(mat[i][j] == proc)
					return true;		
			}
		}
		return false;		
	}
	public  boolean isOK(int num, int j, int i){
		return ( !is3x3(num, j, i) &&!verificaColuna(num, j) && !verificaLInha(num, i) );
			
	}
	
	
	public void display(int numL, int numC){
		for( int i = 0;i < numL; i++){
			for( int j = 0; j < numC; j++){
				System.out.print(this.mat[i][j]+" ");
			}	
	   	System.out.println(); 
		}	
		

	}	
	public boolean solve(){
		for(int i = 0;i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(mat[i][j] == 0){
					for(int num = 1; num <= 9; num++){
						if(isOK(num,j,i)){
							mat[i][j] = num;
							if(solve())	return true;
							else mat[i][j] = 0;							
						}
						
					}
					return false;						
				}
			}	
		}
		return true;
	}
	public static void main(String [] args){
		main sudoku = new main(9,9);
		sudoku.ler(9,9);
	   	System.out.println(); 
	   	
		sudoku.solve();
		sudoku.display(9,9);
		
	}
}