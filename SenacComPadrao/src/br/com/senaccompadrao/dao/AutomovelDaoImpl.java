/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Automovel;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rian.cardoso
 */
public class AutomovelDaoImpl extends VeiculoDaoImpl implements AutomovelDao, Serializable{    
    private ResultSet rs;
    Automovel aut;
    @Override
    public void salvar(Object ob) throws SQLException {
        Automovel automovel = (Automovel) ob;
        super.salvar(automovel);
        String sql = "INSERT INTO AUTOMOVEL(IDVEICULO, NUMEROPORTAS) VALUES(?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, automovel.getId());
            ps.setInt(2, automovel.getNumeroPorta());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao salvar automovel " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps);
        }
    }

    @Override
    public void alterar(Object ob) throws SQLException {
        Automovel automovel = (Automovel) ob;
        super.alterar(automovel);
        String sql = "UPDATE AUTOMOVEL SET IDVEICULO = ?, NUMEROPORTAS = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, automovel.getId());
            ps.setInt(2, automovel.getNumeroPorta());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro ao alterar automovel " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps);
        }
    }

    @Override
    public void excluir(int id) throws SQLException {
        super.excluir(id);
    }

    @Override
    public Object pesqiosarPorID(int id) throws SQLException {
        String sql = "SELECT *FROM AUTOMOVEL A INNER JOIN VEICULO B ON A.IDVEICULO = B.IDVEICULO WHERE A.IDVEICULO = ?";
        
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            aut = new Automovel();
            rs.next();
            aut.setId(id);
            aut.setTipo(rs.getString("tipo"));
            aut.setModelo(rs.getString("modelo"));
            aut.setFabricante(rs.getString("fabricante"));
            aut.setPlaca(rs.getString("placa"));
            aut.setValor(rs.getDouble("valor"));
            aut.setIpva(rs.getDouble("ipva"));
            aut.setNumeroPorta(rs.getInt("numeroPortas"));
            
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps, rs);
        }
        return aut;
    }

    @Override
    public List buscarPorModelo(String modelo) throws SQLException {
        String sql = "SELECT *FROM AUTOMOVEL A INNER JOIN VEICULO B ON A.IDVEICULO = B.IDVEICULO WHERE MODELO LIKE ?";
        List<Automovel> automoveis = new LinkedList();
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+modelo+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                aut = new Automovel();
                aut.setId(rs.getInt("A.IDVEICULO"));
                aut.setTipo(rs.getString("tipo"));
                aut.setModelo(rs.getString("modelo"));
                aut.setPlaca(rs.getString("placa"));
                aut.setFabricante(rs.getString("fabricante"));
                aut.setValor(rs.getDouble("valor"));
                aut.setIpva(rs.getDouble("ipva"));
                aut.setNumeroPorta(rs.getInt("numeroPortas"));
                
                automoveis.add(aut);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por nome " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps, rs);
        }
        return automoveis;
    }
    
}
