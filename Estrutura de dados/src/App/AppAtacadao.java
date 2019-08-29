/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Atacadao.caju.classes.Compra;
import Atacadao.caju.classes.Produto;
import Atacadao.caju.classes.Venda;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author cristiano pc
 */
public class AppAtacadao {
     public static void main(String[] args) {
        int app = 1;
        Scanner sc = new Scanner(System.in);
        int idProduto = 1;
        String nomeProduto;
        ArrayList<Produto> produtos = new ArrayList();
         while (app == 1){
             System.out.println("1- Cadastrar produto!");
             System.out.println("2- Registrar comprar!");
             System.out.println("3- Registrar venda!");
             System.out.println("4- Exibir informações de um produto!");
             System.out.println("5- Imprimir compras!");
             System.out.println("6- Imprimir vendas!");
             System.out.println("7- Sair!");
             int opc = sc.nextInt();
             switch(opc){
                 case 1:
                     System.out.println("Nome do produto: ");
                     nomeProduto = sc.next();
                     Produto pCadastro = new Produto(idProduto, nomeProduto);
                     produtos.add(pCadastro);
                     idProduto ++;
                     break;
                 case 2:
                    System.out.println("Nome do produto: ");
                    nomeProduto = sc.next();
                    Produto pRegistroCompra;
                    boolean realizouCompra =false;
                    for(Produto p: produtos){
                        if (p.getNome().equals(nomeProduto)){
                            realizouCompra = true;
                            pRegistroCompra = p;
                            System.out.println("Data compra: ");
                            String dataCompra = sc.next();
                            System.out.println("Quantidade comprada: ");
                            int qtdComprada = sc.nextInt();
                            System.out.println("Valor da compra: ");
                            float valorCompra = sc.nextFloat();
                            pRegistroCompra.registrarCompra(dataCompra, qtdComprada, valorCompra);
                        }
                    }
                    if (!realizouCompra){
                    System.out.println("Produto não encontrado!!!");
                    }
                    break;
                 case 3:
                    System.out.println("Nome do produto: ");
                    nomeProduto = sc.next();
                    Produto pRegistroVenda;
                    boolean realizouVenda =false;
                    for(Produto p: produtos){
                        if (p.getNome().equals(nomeProduto)){
                            realizouVenda = true;
                            pRegistroVenda = p;
                            System.out.println("Data venda: ");
                            String dataVenda = sc.next();
                            System.out.println("Quantidade vendida: ");
                            int qtdVendida = sc.nextInt();
                            System.out.println("Valor da venda: ");
                            float valorVenda = sc.nextFloat();
                            pRegistroVenda.registrarVenda(dataVenda, qtdVendida, valorVenda);

                        }
                    }
                    if (!realizouVenda){
                        System.out.println("Produto não encontrado!!!");
                    }
                    break;
                 case 4:
                    System.out.println("Nome do produto: ");
                    nomeProduto = sc.next();
                    Produto produtoConsulta;
                    boolean realizouConsulta =false;
                    for(Produto p: produtos){
                        if (p.getNome().equals(nomeProduto)){
                            realizouConsulta = true;
                            produtoConsulta = p;
                            System.out.println(produtoConsulta);
                        }
                    }
                    if (!realizouConsulta){
                        System.out.println("Produto não encontrado!!!");
                    }
                     break;
                 case 5:
                    System.out.println("Nome do produto: ");
                    nomeProduto = sc.next();
                    Produto produtoConsultaCompras;
                    boolean realizouConsultaCompras =false;
                    for(Produto p: produtos){
                        if (p.getNome().equals(nomeProduto)){
                            realizouConsultaCompras = true;
                            produtoConsultaCompras = p;
                            for (Compra compra: produtoConsultaCompras.getCompras()){
                                System.out.println(compra);
                            }
                        }
                    }
                    if (!realizouConsultaCompras){
                        System.out.println("Produto não encontrado!!!");
                    }
                     break;
                 case 6:
                    System.out.println("Nome do produto: ");
                    nomeProduto = sc.next();
                    Produto produtoConsultaVendas;
                    boolean realizouConsultaVendas =false;
                    for(Produto p: produtos){
                        if (p.getNome().equals(nomeProduto)){
                            realizouConsultaVendas = true;
                            produtoConsultaVendas = p;
                            for (Venda venda: produtoConsultaVendas.getVendas()){
                                System.out.println(venda);
                            }
                        }
                    }
                    if (!realizouConsultaVendas){
                        System.out.println("Produto não encontrado!!!");
                    }
                     break;
                 case 7:
                     System.out.println("Programa finalizado!!!");
                     app = 0;
                     break;
                 default:
                     System.out.println("Opcao de Menu Invalida!");
             }
         }
         
     }
}
