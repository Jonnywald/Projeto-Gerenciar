/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Ovos_Caipira;
import model.bean.Ovos_Tipo;

/**
 *
 * @author delri
 */
public class Ovos_CaipiraDAO {
    public void Create(Ovos_Caipira o) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Ovos VALUES(?,?,?,?)");
            stmt.setInt(1, o.getLote());
            stmt.setInt(2, o.getTipo_ovo().getID());
            stmt.setDate(3, (Date) o.getData_embalagem());
            stmt.setInt(4,o.getQtd());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public boolean Check(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean chk = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM Ovos WHERE ID = ?");
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
    public void Update(Ovos_Caipira o) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE ovos SET Tipo_id = ?, data_embalagem = ?, qtd = ? WHERE ID = ?");
            stmt.setInt(1, o.getTipo_ovo().getID());
            stmt.setDate(2, (Date) o.getData_embalagem());
            stmt.setInt(3, o.getQtd());
            stmt.setInt(4, o.getLote());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Ovos_Caipira> Read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ovos_Caipira> ovos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Ovos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ovos_Caipira o = new Ovos_Caipira();
                Ovos_Tipo to = new Ovos_Tipo();
                Ovos_TipoDAO tdao = new Ovos_TipoDAO();
                to = tdao.getTipo(rs.getInt("tipo_id"));
                o.setTipo_ovo(to);
                o.setLote(rs.getInt("ID"));
                o.setQtd(rs.getInt("qtd"));
                o.setData_embalagem(rs.getDate("data_embalagem"));
                ovos.add(o);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ovos;
    }
}
