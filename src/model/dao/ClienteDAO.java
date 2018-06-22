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
import model.bean.Cliente;
import model.bean.Transferencia;

/**
 *
 * @author delri
 */
public class ClienteDAO {
    public void Create(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Cliente VALUES(?,?,?,?,?,?)");
            stmt.setInt(1,c.getID());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getSobrenome());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getTelefone());
            stmt.setDouble(6, c.getSaldo());
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
            stmt = con.prepareStatement("DELETE FROM Cliente WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Cliente> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setID(rs.getInt("ID"));
                c.setNome(rs.getString("nome"));
                c.setSobrenome(rs.getString("sobrenome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setSaldo(rs.getDouble("saldo"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
    public boolean Check(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean chk = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE ID = ?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                chk = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return chk;
    }
    public void Update(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Cliente SET nome = ?, sobrenome = ?, email = ?, telefone = ? WHERE ID = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getSobrenome());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getTelefone());
            stmt.setInt(5, c.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
