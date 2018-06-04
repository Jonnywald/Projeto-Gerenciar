/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuarios;

/**
 *
 * @author delri
 */
public class UsuariosDAO {

    public void Create(Usuarios u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getHierarquia());
            stmt.setString(4, u.getNome_completo());
            stmt.setInt(5, readFuncName(u.getFuncao()));

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Update(Usuarios u,String chave) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE user SET login = ?,senha = ?, hierarquia = ?, nome_completo = ?, funcaoID = ? WHERE login = ?");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getHierarquia());
            stmt.setString(4, u.getNome_completo());
            stmt.setInt(5, readFuncName(u.getFuncao()));
            stmt.setString(6, chave);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Delete(Usuarios u) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM user WHERE login = ?");
            stmt.setString(1, u.getLogin());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Usuarios> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuarios> users = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM user");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setLogin(rs.getString("login"));
                u.setNome_completo(rs.getString("nome_completo"));
                u.setFuncao(readFuncID(rs.getInt("funcaoID")));
                u.setHierarquia(rs.getInt("hierarquia"));
                u.setSenha(rs.getString("senha"));
                users.add(u);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return users;
    }
    public String readFuncID(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String funcao = "";
        try {
            stmt = con.prepareStatement("SELECT funcao FROM funcao WHERE ID = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                funcao = rs.getString("funcao");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler tabela de funções: " + ex);
        }
        return funcao;
    }
    public int readFuncName(String s){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int funcao = 0;
        try {
            stmt = con.prepareStatement("SELECT ID FROM funcao WHERE funcao = ?");
            stmt.setString(1, s);
            rs = stmt.executeQuery();
            while(rs.next()){
                funcao = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler tabela de funções: " + ex);
        }
        return funcao;
    }
    public List<String> fillFunc(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> funcoes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT funcao FROM funcao");
            rs = stmt.executeQuery();
            while(rs.next()){
                String funcao = rs.getString("funcao");
                funcoes.add(funcao);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler tabela de funções: " + ex);
        }
        return funcoes;
    }

    public boolean Check(String login, String senha) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM user WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {

                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler usuarios!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public boolean CheckAdm(String login) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM user WHERE login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("hierarquia") == 1) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler usuarios!: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
