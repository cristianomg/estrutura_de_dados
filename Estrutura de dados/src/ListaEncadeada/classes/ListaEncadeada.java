package ListaEncadeada.classes;

import java.util.Iterator;

import Lista.classes.Lista;

public class ListaEncadeada<T> implements Lista<T>{
    private int tamanho;
    private No<T> inicio;
    private No<T> fim;

    public ListaEncadeada() {
    	this.tamanho= 0;
    	this.inicio = null;
    	this.fim = null;
    }

    @Override
    public void adicionar(T elemento) {
    	No<T> novoNo = new No(elemento);
    	if (inicio == null){
        	inicio = novoNo;
        	fim = inicio;
                tamanho ++;
    	}
    	else {
        	fim.setProximo(novoNo);
        	fim = novoNo;
        	tamanho++;
    	}
    }

    @Override
    public void adicionarNoInicio(T elemento) {
    	No<T> novoNo = new No(elemento);
        novoNo.setProximo(inicio);
        inicio = novoNo;
        tamanho++;
    }

    @Override
    public void adicionarNoFim(T elemento) {
    	No<T> novoNo = new No(elemento);
        if (tamanho ==0){
            inicio = novoNo;
            fim = inicio;
            tamanho ++;
        }
        else{
            fim.setProximo(novoNo);
            fim = novoNo;
            tamanho++;
        }

    }

    @Override
    public void adicionar(T elemento, int posicao) {
    	if (posicao == 0) {
    		this.adicionarNoInicio(elemento);
    	}
    	else if (posicao == tamanho-1) {
    		this.adicionarNoFim(elemento);
    	}
    	else {
    		No<T> atual = inicio; // no atual antes de adicionar
    		No<T> sucessor = atual.getProximo(); // no sucessor ao atual
    		for(int i=0; i< posicao; i++) {
    			atual = atual.getProximo();
    			sucessor = sucessor.getProximo();	
    		}
    		No<T> novoNo = new No(elemento);
    		atual.setProximo(novoNo);
    		novoNo.setProximo(sucessor);
                tamanho++;
    	}
    }

    @Override
    public T remover(int posicao) {
       T result = null;
       if (posicao == 0) {
    	   result = this.removerNoInicio();
           return result;
       }
       else {
           try{
                No<T> anterior = inicio;
                No<T> atual = anterior.getProximo();
                for(int i=0; i< posicao; i++) {
                    anterior = anterior.getProximo();
                    atual = atual.getProximo();	
                }
                result = atual.getElemento();
                anterior.setProximo(atual.getProximo());
                tamanho--;
                return result;
           }
           catch(NullPointerException e){
               System.out.println(e);
           }

       }
       return result;
    }
    
    

    @Override
    public T removerNoInicio() {
    	No<T> result = inicio;
    	inicio = inicio.getProximo();
        tamanho --;
		return result.getElemento();
    }

    @Override
    public T removerNoFim() {
        T result = null;
        No anterior = inicio;
        for (int i = 0; i< tamanho; i++){
            if (anterior.getProximo().equals(fim)){
                result = (T) anterior.getProximo().getElemento();
                anterior.setProximo(null);
                fim = anterior;
                tamanho --;
                break;
            }
            anterior = anterior.getProximo();
        }
        return result;
    }
    

    @Override
    public T buscar(int posicao) {
       T result = null;
       if (posicao==0){
           result = inicio.getElemento();
       }
       else if (posicao == tamanho-1){
           result = fim.getElemento();
       }
       else if (posicao >=tamanho){
           return (T) "posicão invalida!!!";
       }
       else{
            for (int i=0; i<posicao; i++){
                result = inicio.getProximo().getElemento();
                
            }
       }
       return result;
    }

    @Override
    public int existe(T elemento) {
        No var = inicio;
        for(int i=0; i<tamanho; i++){
            if (var.getElemento() == elemento){
                return i;
            }
            var = var.getProximo();
        }
        return -1;
    }

    @Override
    public void limpar() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaEncadeada(this.inicio);
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }
}
