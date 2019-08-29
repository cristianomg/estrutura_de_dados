package Vetor.classes;

import java.util.Iterator;

import Lista.classes.Lista;

public class Vetor<T> implements Lista<T>{
    private T[] vetor;
    private int tamanho;
    private final int incremento;
    private int lastAddPos; //posicao que ser adicionado o ultimo item

    public Vetor() {
        this.vetor = (T[]) new Object[10];
        this.tamanho = 10;
        this.incremento = 10;
        this.lastAddPos = 0;
    }

    // incrementa o vetor se a ultima posicao estiver preenchida 
    protected void resize() {
        if (vetor[tamanho-1] != null) {
            tamanho += incremento;
            System.out.println("aa");
            T[] vetorVar = (T[]) new Object[tamanho];
                for(int i=0; i< vetor.length; i++){
                    vetorVar[i] = vetor[i];
                }
            this.vetor = vetorVar;
    }
    }
    
    @Override
    public void adicionar(T elemento) {
        this.resize();
        vetor[lastAddPos] = elemento;
        lastAddPos ++;
         
    }
    
    @Override
    public void adicionarNoInicio(T elemento) {
        this.resize();
        T[] vetorVar = (T[]) new Object[tamanho];
        vetorVar[0] = elemento;
        System.arraycopy(vetor, 0, vetorVar, 1, vetor.length);
        this.vetor = vetorVar;
        lastAddPos ++;
    }

    @Override
    public void adicionarNoFim(T elemento) {
        this.adicionar(elemento);
    }

    @Override
    public void adicionar(T elemento, int posicao) {
        if (posicao < lastAddPos+2) {
            this.resize();
            T[] vetorVar = (T[]) new Object[tamanho];
            vetorVar[posicao] = elemento;
                System.arraycopy(vetor, 0, vetorVar, 0, posicao);
                System.arraycopy(vetor, posicao, vetorVar, posicao + 1, vetor.length - posicao);
            lastAddPos ++;
        }
        else {
            System.out.println("Posicao invalida!!!");
        }
    }

    @Override
    public T remover(int posicao) {
        T[] vetorVar = (T[]) new Object[10];
        T result = null;
        if (posicao == 0) {
        	result = vetor[0];
            this.removerNoInicio();         
        }
        else if (posicao == lastAddPos-1){
        	result = vetor[lastAddPos-1];
            this.removerNoFim();
        }
        else if (posicao > 0 && posicao < lastAddPos-1){
        	result = vetor[posicao];
        	System.arraycopy(vetor, 0, vetorVar, 0, posicao);
            for (int i= posicao; i < lastAddPos; i++) {
                vetorVar[i] = vetor[i+1];
            }
        }
        else {
            System.out.println("Posica	o invalida");
        }
        vetor = vetorVar;
        lastAddPos --;
        return result;
    }
    

    @Override
    public T removerNoInicio() {
    	T result = null;

        if (lastAddPos > 1) {
        	result = vetor[0];
            vetor[0] = null;
            T[] vetorVar = (T[]) new Object[tamanho];
                System.arraycopy(vetor, 1, vetorVar, 1, lastAddPos - 1);
            vetor = vetorVar;
            lastAddPos --;
        }
        else {
        	result = vetor[0];
            vetor[0] = null;
            lastAddPos --;
        }
        return result;
    }

    @Override
    public T removerNoFim() {
    	T result = vetor[lastAddPos-1];
        vetor[lastAddPos-1] = null;
        lastAddPos --;
        return result;
     }
  

    @Override
    public T buscar(int posicao) {
        return this.vetor[posicao];
    }

    @Override
    public int existe(T elemento) {
        for (int i = 0; i < lastAddPos; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void limpar() {
        this.vetor = (T[]) new Object[tamanho];
        this.lastAddPos = 0;
    }

    @Override
    public int tamanho() {
    	return lastAddPos;
    }
    
    public boolean contains(T elemento) {
        for (int i = 0; i < lastAddPos; i++) {
            if (vetor[i] == elemento) {
                return true;
            }
        }
        return false;
    }
    
    public int lastIndexOf(T elemento) {
        int varlastIndexOf = -1;
        for (int i = 0; i < lastAddPos; i++) {
            if (vetor[i] == elemento) {
                varlastIndexOf = i;
            }
        }
        if (varlastIndexOf != -1) {
            return varlastIndexOf;
        }else {
            return -1;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new IteradorVetor<T>(vetor);
    }
    
}
