package org.farmacia.entities;

import java.time.LocalDate;

public class Oral extends Remedio{
    public String modo_de_uso ;
    public String dosagem ;

    public Oral(String nome_remedio, LocalDate data_vencimento, Float preco, int quantidade_estoque, Float concentracao, String modo_de_uso, String dosagem) {
        super(nome_remedio, data_vencimento, preco, quantidade_estoque, concentracao);
        this.modo_de_uso = modo_de_uso;
        this.dosagem = dosagem;
    }

    public String getModo_de_uso() {
        return modo_de_uso;
    }

    public void setModo_de_uso(String modo_de_uso) {
        this.modo_de_uso = modo_de_uso;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @Override
    public String toString() {
        return "Oral{" +
                "dosagem='" + dosagem + '\'' +
                ", nome_remedio='" + nome_remedio + '\'' +
                ", data_vencimento=" + data_vencimento +
                ", preco=" + preco +
                ", quantidade_estoque=" + quantidade_estoque +
                ", concentracao=" + concentracao +
                ", modo_de_uso='" + modo_de_uso + '\'' +
                '}';
    }
}
