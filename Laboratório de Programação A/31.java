/*Implemente um programa que utilize a estrutura de dados PILHA de números inteiros e implementada via alocação dinâmica (ponteiros). Torne disponível as seguintes operações:

E n (empilha o inteiro n);
D (desempilha o topo da pilha e imprime o seu valor);
L (limpa toda a pilha, mas não mostra os valores);
M (mostra todos os valores empilhados, mas não desempilha nenhum valor);
S (sai do programa).

É muito importante desalocar a memória ocupada pela pilha ao sair do programa.*/
import java.util.Scanner;
 class main{
	public static void main(String args[]){
		Scanner ler = new Scanner(System.in);
		Pilha p = new Pilha();
		char a;
		int n;
		a = ler.next().charAt(0);		
		while(a != 'S'){		
			if(a == 'E'){
				n = ler.nextInt();
				p.push(n);
			}else if(a == 'D'){
				int elemento = p.pop();
				System.out.println(elemento);				
			}else if(a == 'M'){
				p.mostra();			
			}else if(a == 'L'){
				p.limpa();
			}
			a = ler.next().charAt(0);		
		}
		if(a == 'S'){
			p.limpa();
		}
	}
}
class No{
	private int valor;
	private No proximo;
	
	public int getValor(){
		return this.valor;
	}
	public void setValor(int n){
		this.valor = n;
	}
	public No getProximo(){
		return this.proximo;
	}	
	public void setProximo(No seguinte){
		this.proximo = seguinte;
	}
}
class Pilha{
	private No top;
	Pilha(){
		top = null;
	}
	public void push(int e){
		No novo = new No();
		novo.setValor(e);
		if(this.isEmpty()){
			novo.setProximo(null);
			top = novo;
		}else{
				novo.setProximo(top);
				top  = novo;			
		}
		
	}	
	public int pop(){
		if(isEmpty()){
			return -1;
		}
		int valor =  top.getValor();
		this.top = top.getProximo();
		return valor;		
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void mostra(){
		No aux = new No();
		aux = top;
		while(aux != null){
			int val =  aux.getValor();
			System.out.println(val);
			aux = aux.getProximo();
		}
	}
	public void limpa(){	
		if(!isEmpty()){
			No aux = top;
			No tem = aux.getProximo();
			aux = null;
			top = tem;
			while(top != null){
				aux = top;
				tem = aux.getProximo();
				aux = null;
				top = tem;
		}	
	}
		
	}	
}
