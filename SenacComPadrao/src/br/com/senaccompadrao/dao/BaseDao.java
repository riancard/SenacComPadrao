
package br.com.senaccompadrao.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao {
    void salvar(Object ob) throws SQLException;
    
    void alterar(Object ob) throws SQLException;
    
    void excluir(int id) throws SQLException;
    
    Object pesqiosarPorID(int id) throws SQLException;
}
