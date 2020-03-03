/*Backtracking 

O objetivo deste trabalho é que você faça um programa que solucione o Sudoku utilizando a técnica “backtracking”. Neste trabalho, os sudoku’s serão “difíceis” ou “muito difíceis”.

A entrada será uma matriz parcialmente preenchida. Assuma que o valor 0 significa “espaço em branco”.


O site a seguir tem opção de executar o sudoku e ver as marcações:
https://www.geniol.com.br/logica/sudoku/

O site a seguir tem a opção de solucionar um sudoku: http://www.sudoku.name/sudoku-solver/pt*/

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