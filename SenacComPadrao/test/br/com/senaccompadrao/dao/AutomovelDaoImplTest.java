/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.controle.CalcularIpva;
import br.com.senaccompadrao.entidade.Automovel;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class AutomovelDaoImplTest implements CalcularIpva{
    
    private Automovel automovel;
    private AutomovelDao dao;
    
    public AutomovelDaoImplTest() {
        dao = new AutomovelDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        automovel = new Automovel(null, 4, "homem ferro", "tio ben", "tia may", 2000, 0);
        calcularIpva();
        dao.salvar(automovel);
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        automovel = new Automovel(1, 5, "superman", "krypton", "sol vermelho", 5000, 0);
        calcularIpva();
        dao.alterar(automovel);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 1;
        dao.excluir(id);
    }

//    @Test
    public void testPesqiosarPorID() throws Exception {
        System.out.println("pesqiosarPorID");
        int id = 1;
        automovel = (Automovel) dao.pesqiosarPorID(id);
        System.out.println(automovel.getId());
        System.out.println(automovel.getTipo());
        System.out.println(automovel.getModelo());
        System.out.println(automovel.getFabricante());
        System.out.println(automovel.getPlaca());
        System.out.println(automovel.getValor());
        System.out.println(automovel.getIpva());
        System.out.println(automovel.getNumeroPorta());
    }

    @Test
    public void testPesquisarPorModelo() throws Exception {
        System.out.println("pesquisarPorNome");
        String modelo = "homem";
        
        List<Automovel> automoveis = dao.buscarPorModelo(modelo);
        for (Automovel a : automoveis) {
            System.out.println(a.getId());
            System.out.println(a.getTipo());
            System.out.println(a.getModelo());
            System.out.println(a.getFabricante());
            System.out.println(a.getPlaca());
            System.out.println(a.getValor());
            System.out.println(a.getIpva());
            System.out.println(a.getNumeroPorta());
            System.out.println("");
        }
    }

    @Override
    public void calcularIpva() {
        automovel.setIpva(automovel.getValor() * 0.03);
    }
    
}
