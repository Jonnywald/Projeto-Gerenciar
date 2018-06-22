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
import model.bean.Transferencia;

/**
 *
 * @author delri
 */
public class TransferenciaDAO {
    public void Create(Transferencia t) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Transferencia VALUES(?,?,?,?)");
            stmt.setInt(1,t.getID());
            stmt.setInt(2, t.getCodCliente());
            stmt.setString(4, t.getDataTransf());
            stmt.setDouble(3,t.getValor());
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
            stmt = con.prepareStatement("DELETE FROM Transferencia WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Transferencia> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Transferencia> transf = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Transferencia");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Transferencia t = new Transferencia();
                t.setID(rs.getInt("ID"));
                t.setCodCliente(rs.getInt("cliente_cod"));
                t.setValor(rs.getDouble("valor"));
                t.setDataTransf(rs.getString("data_transf"));
                transf.add(t);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return transf;
    }
    public void Update(Transferencia t) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Transferencia SET cliente_cod = ?, valor = ?, data_transf = ? WHERE ID = ?");
            stmt.setInt(1, t.getCodCliente());
            stmt.setDouble(2, t.getValor());
            stmt.setString(3, t.getDataTransf());
            stmt.setInt(4, t.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
