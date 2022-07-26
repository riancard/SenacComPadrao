/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Veiculo;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rian.cardoso
 */
public abstract class VeiculoDaoImpl {
    
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;
    
    public void salvar(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO VEICULO(TIPO, MODELO, FABRICANTE, PLACA, VALOR, IPVA) VALUES(?,?,?,?,?,?)";
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, veiculo.getTipo());
            ps.setString(2, veiculo.getModelo());
            ps.setString(3, veiculo.getFabricante());
            ps.setString(4, veiculo.getPlaca());
            ps.setDouble(5, veiculo.getValor());
            ps.setDouble(6, veiculo.getIpva());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            veiculo.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao salvar veiculo " + e.getMessage());
        }
    }

    public void alterar(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE VEICULO SET TIPO = ?, FABRICANTE = ?, MODELO = ?,PLACA = ?, VALOR = ?, IPVA = ? WHERE IDVEICULO = ?";
        
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, veiculo.getTipo());
            ps.setString(2, veiculo.getFabricante());
            ps.setString(3, veiculo.getModelo());
            ps.setString(4, veiculo.getPlaca());
            ps.setDouble(5, veiculo.getValor());
            ps.setDouble(6, veiculo.getIpva());
            ps.setInt(7, veiculo.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao alterar Veiculo " + e.getMessage());
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM VEICULO WHERE IDVEICULO =?";
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao excluir Veiculo " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps);
        }
    }
}
