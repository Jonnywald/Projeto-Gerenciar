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
public class Cachaca_Granel extends Cachaca{
    private Date data_coleta;

    public Cachaca_Granel(Date data_coleta, String tipo, double volume, String reservatorio, Date data_fabricação, double preco_uni, int qtd) {
        super(tipo, volume, reservatorio, data_fabricação, preco_uni, qtd);
        this.data_coleta = data_coleta;
    }

    public Cachaca_Granel() {
    }
    

    public Date getData_coleta() {
        return data_coleta;
    }

    public void setData_coleta(Date data_coleta) {
        this.data_coleta = data_coleta;
    }
    
}
