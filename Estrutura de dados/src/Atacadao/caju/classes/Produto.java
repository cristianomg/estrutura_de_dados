/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atacadao.caju.classes;

import ListaEncadeada.classes.ListaEncadeada;

/**
 *
 * @author cristiano pc
 */
public class Produto {
    private final int codigoProduto;
    private final String nomeProduto;
    private int qtdEstoque;
    private float custoUnitario;
    private ListaEncadeada<Compra> compras = new ListaEncadeada();
    private ListaEncadeada<Venda> vendas = new ListaEncadeada();
    
    
    public String getNome(){
        return this.nomeProduto;
    }
    
    public int getEstoque(){
        return qtdEstoque;
    }
    
    public Produto(int codigoProduto, String nomeProduto){
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.qtdEstoque = 0;
        this.custoUnitario = 0;
    }
    
    public void registrarCompra(String dataCompra, int qtdComprada, float valorCompra){
        Compra compra = new Compra(dataCompra, qtdComprada, valorCompra);
        this.custoUnitario = valorCompra/qtdComprada;
        this.compras.adicionar(compra);
        this.qtdEstoque += qtdComprada;
        System.out.println("Compra registrada!!!");
    }
    public void registrarVenda(String dataVenda, int qtdVendida, float valorVenda){
        if (qtdEstoque >= qtdVendida){
            Venda venda = new Venda(dataVenda, qtdVendida, valorVenda);
            this.vendas.adicionar(venda);
            this.qtdEstoque -= qtdVendida;
            System.out.println("Venda registrada!!!");
        }
        else{
            System.out.println("Quantidade indisponivel no estoque!!!");
        }

    }
    
    public ListaEncadeada<Compra> getCompras(){
        return compras;
    }
    
    public ListaEncadeada<Venda> getVendas(){
        return vendas;
    }
    
    @Override
    public String toString(){
        return "\n" + "Codigo do produto: " + codigoProduto + "\nNome do produto: " + nomeProduto + "\nQuantidade no estoque: " + qtdEstoque + "\nCusto unitario: " + custoUnitario + "\n";
    }
}
