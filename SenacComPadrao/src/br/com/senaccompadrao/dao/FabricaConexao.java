/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rian.cardoso
 */
public class FabricaConexao {
    public static Connection abrirConexao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");        
        return DriverManager.
        getConnection("jdbc:mysql://localhost:3306/detra",
                                                     "root", "");
    }
    
    public static void fecharConexao(Connection conn,
                                             PreparedStatement ps){
        fechar(conn, ps, null);
    }
    
    public static void fecharConexao(Connection conn,
            PreparedStatement ps, ResultSet rs){
        fechar(conn, ps, rs);
    }
    
    private static void fechar(Connection conn, PreparedStatement ps,
                                 ResultSet rs){
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlE) {
            System.out.println("Erro ao fechar conexão " 
                                              + sqlE.getMessage());
        }
    }
}
