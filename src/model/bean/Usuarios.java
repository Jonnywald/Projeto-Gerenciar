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
public class Usuarios {
    private String login;
    private String nome_completo;
    private String senha;
    private int hierarquia;
    private String funcao;

    public Usuarios(String login, String senha, int hierarquia) {
        this.login = login;
        this.senha = senha;
        this.hierarquia = hierarquia;
    }

    public Usuarios() {
        
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public int getHierarquia() {
        return hierarquia;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHierarquia(int hierarquia) {
        this.hierarquia = hierarquia;
    }
    
}
