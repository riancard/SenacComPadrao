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
public class Onibus extends Veiculo{
    //5%
    int qtdAcento;

    public Onibus() {
        this.tipo = "qtdAcento";
    }

    public Onibus(Integer id, int qtdAcento, String modelo, String fabricante, String placa, double valor, double ipva) {
        super(id, "qtdAcento", modelo, fabricante, placa, valor, ipva);
        this.qtdAcento = qtdAcento;
    }

    public int getQtdAcento() {
        return qtdAcento;
    }

    public void setQtdAcento(int qtdAcento) {
        this.qtdAcento = qtdAcento;
    }
}
