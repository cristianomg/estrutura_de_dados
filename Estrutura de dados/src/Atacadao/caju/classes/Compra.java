/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atacadao.caju.classes;

/**
 *
 * @author cristiano pc
 */
public class Compra {
    private final String dataCompra;
    private final int qtdComprada;
    private final float valorCompra;
    
    public String getDataCompra(){
        return dataCompra;
    }
    
    public int getQtdComprada(){
        return qtdComprada;
    }
    
    public float getValorCompra(){
        return valorCompra;
    }
    
    public Compra(String dataCompra, int qtdComprada, float valorCompra){
        this.dataCompra = dataCompra;
        this.qtdComprada = qtdComprada;
        this.valorCompra = valorCompra;
    }
    
    @Override
    public String toString(){
        return "Data da compra: " + dataCompra + "\nQuantidade comprada: " + qtdComprada + "\nValor da compra: " + valorCompra;
    }
    
}
