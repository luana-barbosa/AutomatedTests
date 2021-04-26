package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance){
        double valorLance = lance.getValor();
        if (valorLance > maiorLance){
          maiorLance = valorLance;
        } if (valorLance < menorLance){
            menorLance = valorLance;
        }
    }

    public double getMenorLance() {
        return menorLance;
    }
    public double getMaiorLance() {
        return maiorLance;
    }

    public String getDescricao() {
        return descricao;
    }

}
