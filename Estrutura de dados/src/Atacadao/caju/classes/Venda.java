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
public class Venda {
    private final String dataVenda;
    private final int qtdVendida;
    private final float valorVenda;
    private final float custoUtd;
    
    public String getDataVenda(){
        return dataVenda;
    }

    public int getQtdVendida(){
        return qtdVendida;
    }
    
    public float getValorVenda(){
        return valorVenda;
    }
    
    public float getCustoUtd(){
        return custoUtd;
    }
    
    public Venda(String dataVenda, int qtdVendida, float valorVenda){
        this.dataVenda = dataVenda;
        this.qtdVendida = qtdVendida;
        this.valorVenda = valorVenda;
        this.custoUtd = valorVenda/qtdVendida;
    }
    
    @Override
    public String toString(){
        return "Data da venda" + dataVenda + "\nQuantidade vendida: " + qtdVendida + "\nValor da venda: " + valorVenda;
    }
}
