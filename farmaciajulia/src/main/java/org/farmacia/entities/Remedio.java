package org.farmacia.entities;

import java.time.LocalDate;

public class Remedio {
    public String nome_remedio;
    public LocalDate data_vencimento;
    public Float preco;
    public int quantidade_estoque;
    public Float concentracao;

    public Remedio(String nome_remedio, LocalDate data_vencimento, Float preco, int quantidade_estoque, Float concentracao) {
        this.nome_remedio = nome_remedio;
        this.data_vencimento = data_vencimento;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
        this.concentracao = concentracao;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Float getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(Float concentracao) {
        this.concentracao = concentracao;
    }

    @Override
    public String toString() {
        return "Remedio{" +
                "nome_remedio='" + nome_remedio + '\'' +
                ", data_vencimento=" + data_vencimento +
                ", preco=" + preco +
                ", quantidade_estoque=" + quantidade_estoque +
                ", concentracao=" + concentracao +
                '}';
    }
}
