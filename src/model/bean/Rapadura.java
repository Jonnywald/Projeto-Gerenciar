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
public class Rapadura {
    private int lote;
    private int qtd;
    private double preco;
    private double peso;
    private String data_fabricacao;
    private String data_embalagem;

    public Rapadura(double peso, String data_fabricacao, String data_embalagem) {
        this.peso = peso;
        this.data_fabricacao = data_fabricacao;
        this.data_embalagem = data_embalagem;
    }

    public Rapadura() {
    }

    public double getPeso() {
        return peso;
    }

    public String getData_fabricacao() {
        return data_fabricacao;
    }

    public String getData_embalagem() {
        return data_embalagem;
    }
    
}
