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
public class Cachaca_Envasada extends Cachaca{
    private String embalagem;
    private Date data_envase;
    private String Registro;

    public Cachaca_Envasada(String embalagem, Date data_envase, String Registro, String tipo, double volume, String reservatorio, Date data_fabricação, double preco_uni, int qtd) {
        super(tipo, volume, reservatorio, data_fabricação, preco_uni, qtd);
        this.embalagem = embalagem;
        this.data_envase = data_envase;
        this.Registro = Registro;
    }

    public Cachaca_Envasada() {
    }

    public String getRegistro() {
        return Registro;
    }

    public void setRegistro(String Registro) {
        this.Registro = Registro;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public Date getData_envase() {
        return data_envase;
    }

    public void setData_envase(Date data_envase) {
        this.data_envase = data_envase;
    }
    
    
}
