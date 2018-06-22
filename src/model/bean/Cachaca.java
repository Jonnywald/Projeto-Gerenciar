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
public class Cachaca extends Item{
    private String tipo;
    private double volume;
    private String reservatorio;
    private String data_fabricação;

    public Cachaca(String tipo, double volume, String reservatorio, String data_fabricação, double preco_uni, int qtd) {
        super(preco_uni, qtd);
        this.tipo = tipo;
        this.volume = volume;
        this.reservatorio = reservatorio;
        this.data_fabricação = data_fabricação;
    }

    public Cachaca() {
    }
    

    public String getTipo_ovo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getReservatorio() {
        return reservatorio;
    }

    public void setReservatorio(String reservatorio) {
        this.reservatorio = reservatorio;
    }

    public String getData_fabricação() {
        return data_fabricação;
    }

    public void setData_fabricação(String data_fabricação) {
        this.data_fabricação = data_fabricação;
    }
    
    
}
