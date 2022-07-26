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
public class Automovel extends Veiculo{
    
    private int numeroPorta;
    
    public Automovel() {
        tipo = "Automovel";
    }

    public Automovel(Integer id, int numeroPorta, String modelo, String fabricante, String placa, double valor, double ipva) {
        super(id, "Automovel", modelo, fabricante, placa, valor, ipva);
        this.numeroPorta = numeroPorta;
    }

    public int getNumeroPorta() {
        return numeroPorta;
    }

    public void setNumeroPorta(int numeroPorta) {
        this.numeroPorta = numeroPorta;
    }
}
