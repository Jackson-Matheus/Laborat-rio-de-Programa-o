/*A matriz esparsa pode ter valores sendo inserido a posteriori. 
A entrada será os valores da dimensão da matriz esparsa, no caso N (quantidade de linhas) e M 
(quantidade de colunas), e a matriz esparsa em si. Considere que o tipo da matriz é de inteiros.
 A matriz já deve ser armazenada no formato de listas cruzadas. Em seguida será lido W triplas 
 (linha, coluna, valor) que deve ser incluído na matriz esparsa. Por último, será fornecido K índices 
 (linha e coluna) e deve ser impresso o valor da matriz correspondente aos respectivos índices.*/

 import java.util.Scanner;
class Lista{
	private int i;
	private int j;
	private int valor;
	Lista(int a, int b, int valor){
		this.setValor(valor);
		this.setX(a);		
		this.setY(b);
	}	
	public void setValor(int valor){
		this.valor = valor;
	}
	public void setY(int indice_y){
		this.j = indice_y;
	}
	public void setX(int indice_x){
		this.i = indice_x;
	}
	public int getValor(){
		return this.valor;
	}
	public int getY(){
		return this.j;
	}
	public int getX(){
		return this.i;
	}     
}
class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int numL, numC,i,j,num,casos,cont;
		numL =  ler.nextInt();
		numC = ler.nextInt();
		Lista[][] mat = new Lista[numL][numC];
		for(i = 0; i < numL; i++){
			for(j = 0; j < numC; j++){
				num = ler.nextInt();
				mat[i][j] = new Lista(i,j,num);
			}
		}
		casos = ler.nextInt();
		cont = 0;
		while(cont < casos){
			i = ler.nextInt()-1;
			j = ler.nextInt()-1;
			num = ler.nextInt();
			mat[i][j] = new Lista(i,j,num);
		cont++;
		}
		cont = 0;
		casos = ler.nextInt();
		while(cont < casos){
			i = ler.nextInt();
			j = ler.nextInt();
			System.out.println(mat[i-1][j-1].getValor());
		cont++;
		}
	}
}
/*A matriz esparsa pode ter alguns valores sendo tornados zero. No caso, se o valor no índice já for zero, nada deve ser feito.
 Se o valor do índice for diferente de zero, este valor simplesmente deve ser retirado da lista cruzada. A entrada será os
  valores da dimensão da matriz esparsa, no caso N (quantidade de linhas) e M (quantidade de colunas), e a matriz esparsa em si. 
  Considere que o tipo da matriz é de inteiros. A matriz já deve ser armazenada no formato de listas cruzadas. Em seguida será lido
   W duplas (linha, coluna) que deve ser excluído da matriz esparsa. 
Por último, será fornecido K índices (linha e coluna) e deve ser impresso o valor da matriz correspondente aos respectivos índices.*/
import java.util.Scanner;
class Lista{
	private int i;
	private int j;
	private int valor;
	Lista(int a, int b, int valor){
		this.setValor(valor);
		this.setX(a);		
		this.setY(b);
	}	
	public void setValor(int valor){
		this.valor = valor;
	}
	public void setY(int indice_y){
		this.j = indice_y;
	}
	public void setX(int indice_x){
		this.i = indice_x;
	}
	public int getValor(){
		return this.valor;
	}
	public int getY(){
		return this.j;
	}
	public int getX(){
		return this.i;
	}     
}
class main{
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		int numL, numC,i,j,num,casos,cont;
		numL =  ler.nextInt();
		numC = ler.nextInt();
		Lista[][] mat = new Lista[numL][numC];
		for(i = 0; i < numL; i++){
			for(j = 0; j < numC; j++){
				num = ler.nextInt();
				mat[i][j] = new Lista(i,j,num);
			}
		}
		casos = ler.nextInt();
		cont = 0;
		while(cont < casos){
			i = ler.nextInt()-1;
			j = ler.nextInt()-1;
			mat[i][j] = new Lista(i,j,0);
		cont++;
		}
		cont = 0;
		casos = ler.nextInt();
		while(cont < casos){
			i = ler.nextInt();
			j = ler.nextInt();
			System.out.println(mat[i-1][j-1].getValor());
		cont++;
		}
	}
}