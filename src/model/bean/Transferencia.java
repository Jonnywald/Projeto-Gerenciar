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
public class Transferencia {
    int ID;
    double valor;
    Date dataTransf;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataTransf() {
        return dataTransf;
    }

    public void setDataTransf(Date dataTransf) {
        this.dataTransf = dataTransf;
    }
    
    
}
