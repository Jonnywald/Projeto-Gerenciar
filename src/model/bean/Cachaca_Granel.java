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
public class Cachaca_Granel extends Cachaca{
    private String data_coleta;

    public Cachaca_Granel(String data_coleta, String tipo, double volume, String reservatorio, String data_fabricação, double preco_uni, int qtd) {
        super(tipo, volume, reservatorio, data_fabricação, preco_uni, qtd);
        this.data_coleta = data_coleta;
    }

    public Cachaca_Granel() {
    }
    

    public String getData_coleta() {
        return data_coleta;
    }

    public void setData_coleta(String data_coleta) {
        this.data_coleta = data_coleta;
    }
    
}
