/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rian.cardoso
 */
public interface AutomovelDao extends BaseDao{
    List buscarPorModelo(String modelo)throws SQLException;
}
