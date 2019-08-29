package Lista.classes;

public interface Lista<T> extends Iterable<T>{
    public abstract void adicionar(T elemento);
    public abstract void adicionarNoInicio(T elemento);
    public abstract void adicionarNoFim(T elemento);
    public abstract void adicionar(T elemento, int posicao);
    
    public abstract T remover(int posicao);
    public abstract T removerNoInicio();
    public abstract T removerNoFim();
    
    public abstract T buscar(int posicao);
    public abstract int existe(T elemento);
    
    public abstract void limpar();
    
    public abstract int tamanho();
    
}
