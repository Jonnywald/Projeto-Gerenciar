/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author delri
 */
public class Rapadura extends Item{
    private double peso;
    private Date data_fabricacao;
    private Date data_embalagem;

    public Rapadura(double peso, Date data_fabricacao, Date data_embalagem, double preco_uni, int qtd) {
        super(preco_uni, qtd);
        this.peso = peso;
        this.data_fabricacao = data_fabricacao;
        this.data_embalagem = data_embalagem;
    }

    public Rapadura() {
    }

    public double getPeso() {
        return peso;
    }

    public Date getData_fabricacao() {
        return data_fabricacao;
    }

    public Date getData_embalagem() {
        return data_embalagem;
    }
    
}
