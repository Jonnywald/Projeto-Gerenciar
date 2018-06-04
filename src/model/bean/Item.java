/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author delri
 */
public class Item {
    private double preco_uni;
    private int qtd;
    private String Tipo;

    public Item(double preco_uni, int qtd) {
        this.preco_uni = preco_uni;
        this.qtd = qtd;
    }

    public Item() {
    }

    public String getTipo_ovo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    

    public double getPreco_uni() {
        return preco_uni;
    }

    public int getQtd() {
        return qtd;
    }
    public double calcPrecoTotal(){
        return (preco_uni*qtd);
    }
}
