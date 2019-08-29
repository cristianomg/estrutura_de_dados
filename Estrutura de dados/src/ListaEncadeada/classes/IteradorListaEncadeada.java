package ListaEncadeada.classes;

import java.util.Iterator;

public class IteradorListaEncadeada<T> implements Iterator<T>{
    private No<T> atual;

    public IteradorListaEncadeada(No<T> inicio) {
        this.atual = inicio;
    }

    @Override
    public boolean hasNext() {
        return atual != null;
    }

    @Override
    public T next() {
        T retorno = this.atual.getElemento();
        this.atual = this.atual.getProximo();
        
        return retorno;
    }
}
