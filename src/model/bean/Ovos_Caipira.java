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
public class Ovos_Caipira {
    private int Qtd;
    private int Lote;
    private Ovos_Tipo tipo_ovo;
    private Date data_embalagem;

    public Ovos_Caipira(int ID,Ovos_Tipo tipo, Date data_embalagem) {
        this.Qtd = ID;
        this.tipo_ovo = tipo;
        this.data_embalagem = data_embalagem;
    }

    public Ovos_Caipira() {
    }

    public Ovos_Tipo getTipo_ovo() {
        return tipo_ovo;
    }

    public Date getData_embalagem() {
        return data_embalagem;
    }

    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int Qtd) {
        this.Qtd = Qtd;
    }

    public void setTipo_ovo(Ovos_Tipo tipo_ovo) {
        this.tipo_ovo = tipo_ovo;
    }

    public void setData_embalagem(Date data_embalagem) {
        this.data_embalagem = data_embalagem;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int Lote) {
        this.Lote = Lote;
    }
    
    
    public double calcPrecoTotal(){
        return (getQtd() * this.tipo_ovo.getPreco());
    }
    
}
