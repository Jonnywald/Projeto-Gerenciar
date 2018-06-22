/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.List;

/**
 *
 * @author delri
 */
public class Cliente {

    int ID;
    String nome;
    String sobrenome;
    String email;
    String telefone;
    List<Transferencia> transf;
    double saldo;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Transferencia> getTransf() {
        return transf;
    }

    public void setTransf(List<Transferencia> transf) {
        this.transf = transf;
        calcSaldo();
    }

    public double getSaldo() {
        calcSaldo();
        return saldo;
    }

    public void addTransf(Transferencia t) {
        this.transf.add(t);
        calcSaldo();
    }

    public void removeTransf(Transferencia t) {
        for (Transferencia tr : this.transf) {
            if (t.getID() == tr.getID()) {
                this.transf.remove(tr);
                break;
            }
        }
        calcSaldo();
    }

    public void calcSaldo() {
        double sd = 0;
        for (Transferencia t : this.transf) {
            sd += t.valor;
        }
        this.saldo = sd;
    }

}
