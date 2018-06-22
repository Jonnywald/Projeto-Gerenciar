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
public class Ovos_Caipira {
    private int Qtd;
    private int Lote;
    private Ovos_Tipo tipo_ovo;
    private String data_embalagem;

    public Ovos_Caipira(int ID,Ovos_Tipo tipo, String data_embalagem) {
        this.Qtd = ID;
        this.tipo_ovo = tipo;
        this.data_embalagem = data_embalagem;
    }

    public Ovos_Caipira() {
    }

    public Ovos_Tipo getTipo_ovo() {
        return tipo_ovo;
    }

    public String getData_embalagem() {
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

    public void setData_embalagem(String data_embalagem) {
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
