/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.dao;

import br.com.senaccompadrao.controle.CalcularIpva;
import br.com.senaccompadrao.entidade.Moto;
import br.com.senaccompadrao.entidade.Veiculo;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rian.cardoso
 */
public class MotoDaoImplTest implements CalcularIpva{
    
    private Moto moto;
    private MotoDao dao;
    
    public MotoDaoImplTest() {
        dao = new MotoDaoImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        moto = new Moto(null, "21654165165146", "Flash Branco", "Mae Flash Branco", "Pai Flash Branco", 2020202, 0);
        calcularIpva();
        dao.salvar(moto);
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        moto = new Moto(5, "1010", "SuperMan", "Krypton", "Sol Vermelho", 2020, 0);
        calcularIpva();
        dao.alterar(moto);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 5;
        dao.excluir(id);
    }

//    @Test
    public void testPesqiosarPorID() throws Exception {
        System.out.println("pesqiosarPorID");
        int id = 4;
        moto = (Moto) dao.pesqiosarPorID(id);
        System.out.println(moto.getId());
        System.out.println(moto.getTipo());
        System.out.println(moto.getModelo());
        System.out.println(moto.getFabricante());
        System.out.println(moto.getPlaca());
        System.out.println(moto.getValor());
        System.out.println(moto.getIpva());
        System.out.println(moto.getPotencia());
    }

    @Test
    public void testPesquisarModelo() throws Exception {
        System.out.println("pesquisarModelo");
        String modelo = "flash";
        
        List<Moto> moto = dao.buscarPorModelo(modelo);
        for (Moto a : moto) {
            System.out.println(a.getId());
            System.out.println(a.getTipo());
            System.out.println(a.getModelo());
            System.out.println(a.getFabricante());
            System.out.println(a.getPlaca());
            System.out.println(a.getValor());
            System.out.println(a.getIpva());
            System.out.println(a.getPotencia());
            System.out.println("");
        }
    }

    @Override
    public void calcularIpva() {
        moto.setIpva(moto.getValor() * 0.02);
    }
    
}
