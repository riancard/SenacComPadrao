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
public class Moto extends Veiculo{
    
    private String potencia;

    public Moto() {
        tipo = "Moto";
    }

    public Moto(Integer id, String potencia, String modelo, String fabricante, String placa, double valor, double ipva) {
        super(id, "Moto", modelo, fabricante, placa, valor, ipva);
        this.potencia = potencia;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}
