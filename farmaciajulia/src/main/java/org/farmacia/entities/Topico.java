package org.farmacia.entities;

import java.time.LocalDate;

public class Topico extends Remedio{
    public String modo_de_uso ;
    public String dosagem ;

    public Topico(String nome_remedio, LocalDate data_vencimento, Float preco, int quantidade_estoque, Float concentracao, Substancia substancia, String modo_de_uso, String dosagem) {
        super(nome_remedio, data_vencimento, preco, quantidade_estoque, concentracao, substancia);
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
        return "Topico{" +
                "dosagem='" + dosagem + '\'' +
                ", nome_remedio='" + nome_remedio + '\'' +
                ", data_vencimento=" + data_vencimento +
                ", preco=" + preco +
                ", quantidade_estoque=" + quantidade_estoque +
                ", concentracao=" + concentracao +
                ", substancia=" + substancia +
                ", modo_de_uso='" + modo_de_uso + '\'' +
                '}';
    }
}
