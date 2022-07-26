/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaccompadrao.entidade;

/**
 *
 * @author rian.cardoso
 */
public class Caminhao extends Veiculo {
    //4%
    private int qtdEixo;

    public Caminhao() {
    }

    public Caminhao(Integer id, int qtdEixo, String modelo, String fabricante, String placa, double valor, double ipva) {
        super(id, "Caminhao", modelo, fabricante, placa, valor, ipva);
        this.qtdEixo = qtdEixo;
    }

    public int getQtdEixo() {
        return qtdEixo;
    }

    public void setQtdEixo(int qtdEixo) {
        this.qtdEixo = qtdEixo;
    }
}
