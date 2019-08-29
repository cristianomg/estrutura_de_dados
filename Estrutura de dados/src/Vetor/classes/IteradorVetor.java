package Vetor.classes;

import java.util.Iterator;

public class IteradorVetor<T> implements Iterator<T> {
	private int atual;
    private T[] vetor;
	
	public IteradorVetor(T[] vetor) {
		this.vetor = vetor;
		this.atual = 0;
	}

	@Override
	public boolean hasNext() {
		return vetor[atual] != null;
	}

	@Override
	public T next() {
		T retorno = vetor[atual];
		atual ++;
		return retorno;
	}
	

	
			
}
