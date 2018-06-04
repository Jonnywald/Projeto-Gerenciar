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
import model.bean.Ovos_Tipo;

/**
 *
 * @author delri
 */
public class Ovos_TipoDAO {
    public void Create(Ovos_Tipo o) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Tipo_Ovos VALUES(?,?,?)");
            stmt.setInt(1, o.getID());
            stmt.setString(2, o.getTipo());
            stmt.setDouble(3, o.getPreco());
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
            stmt = con.prepareStatement("DELETE FROM Tipo_Ovos WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Ovos_Tipo> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ovos_Tipo> ovos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Tipo_Ovos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ovos_Tipo o = new Ovos_Tipo();
                o.setTipo(rs.getString("tipo"));
                o.setID(rs.getInt("ID"));
                o.setPreco(rs.getDouble("preco"));
                ovos.add(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ovos;
    }
    public boolean Check(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean chk = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM Tipo_Ovos WHERE ID = ?");
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
    public void Update(Ovos_Tipo o) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE Tipo_ovos SET Tipo = ?, preco = ? WHERE ID = ?");
            stmt.setString(1, o.getTipo());
            stmt.setDouble(2, o.getPreco());
            stmt.setInt(3, o.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Ovos_Tipo> Fill(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ovos_Tipo> tipos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Tipo_Ovos");
            rs = stmt.executeQuery();
            while(rs.next()){
                Ovos_Tipo o = new Ovos_Tipo();
                o.setTipo(rs.getString("tipo"));
                o.setID(rs.getInt("ID"));
                o.setPreco(rs.getDouble("preco"));
                tipos.add(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler tabela de tipos de ovos: " + ex);
        }
        finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return tipos;
    }
    public Ovos_Tipo getTipo(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ovos_Tipo o = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Tipo_Ovos WHERE ID = ?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                o.setTipo(rs.getString("tipo"));
                o.setID(id);
                o.setPreco(rs.getDouble("preco"));
            }else{
                JOptionPane.showMessageDialog(null, "Código não encontrado!");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler tabela de tipos de ovos: " + ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return o;
    }
}
