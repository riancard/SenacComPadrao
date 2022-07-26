/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.entidade.Moto;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rian.cardoso
 */
public class MotoDaoImpl extends VeiculoDaoImpl implements MotoDao, Serializable{
    
    private ResultSet rs;
    private Moto moto;
    
    @Override
    public void salvar(Object ob) throws SQLException {
        moto = (Moto) ob;
        super.salvar(moto);
        String sql = "INSERT INTO MOTO(IDVEICULO, POTENCIA) VALUES(?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, moto.getId());
            ps.setString(2, moto.getPotencia());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salvar moto " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps);
        }
    }

    @Override
    public void alterar(Object ob) throws SQLException {
        moto = (Moto) ob;
        super.alterar(moto);
        String sql = "UPDATE MOTO SET POTENCIA = ? WHERE IDVEICULO = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, moto.getPotencia());
            ps.setInt(2, moto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar moto " + e.getMessage());
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
        String sql = "SELECT *FROM MOTO A INNER JOIN VEICULO B ON A.IDVEICULO = B.IDVEICULO WHERE A.IDVEICULO = ?";
        
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            moto = new Moto();
            rs.next();
            moto.setId(id);
            moto.setTipo(rs.getString("tipo"));
            moto.setModelo(rs.getString("modelo"));
            moto.setFabricante(rs.getString("fabricante"));
            moto.setPlaca(rs.getString("placa"));
            moto.setValor(rs.getDouble("valor"));
            moto.setIpva(rs.getDouble("ipva"));
            moto.setPotencia(rs.getString("Potencia"));
            
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps, rs);
        }
        return moto;
    }

    @Override
    public List buscarPorModelo(String modelo) throws SQLException {
        String sql = "SELECT *FROM MOTO A INNER JOIN VEICULO B ON A.IDVEICULO = B.IDVEICULO WHERE MODELO LIKE ?";
        List<Moto> motos = new LinkedList<>();
        try {
            con = FabricaConexao.abrirConexao();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+modelo+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                moto = new Moto();
                moto.setId(rs.getInt("A.IDVEICULO"));
                moto.setTipo(rs.getString("tipo"));
                moto.setModelo(rs.getString("modelo"));
                moto.setPlaca(rs.getString("placa"));
                moto.setFabricante(rs.getString("fabricante"));
                moto.setValor(rs.getDouble("valor"));
                moto.setIpva(rs.getDouble("ipva"));
                moto.setPotencia(rs.getString("potencia"));
                
                motos.add(moto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por nome " + e.getMessage());
        }finally{
            FabricaConexao.fecharConexao(con, ps, rs);
        }
        return motos;
    }
    
}
