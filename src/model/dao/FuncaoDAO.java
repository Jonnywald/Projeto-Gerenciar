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
import model.bean.Funcao;

/**
 *
 * @author delri
 */
public class FuncaoDAO {

    public void Create(String s) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO funcao (funcao) VALUES(?)");
            stmt.setString(1, s);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void Delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM funcao WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Funcao> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcao> func = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcao");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcao f = new Funcao();
                f.setFunc(rs.getString("funcao"));
                f.setID(rs.getInt("ID"));
                func.add(f);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return func;
    }
    
}
