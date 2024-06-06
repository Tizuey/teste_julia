package org.farmacia.entities;

import java.util.ArrayList;

public class Farmacia {
    public String nome_farmacia;
    public String cnpj;
    public int estoque ;
    public float saldo;

    public Farmacia(String nome_farmacia, String cnpj, float saldo) {
        this.nome_farmacia = nome_farmacia;
        this.cnpj = cnpj;
        this.saldo = saldo;
    }

    public String getNome_farmacia() {
        return nome_farmacia;
    }

    public void setNome_farmacia(String nome_farmacia) {
        this.nome_farmacia = nome_farmacia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Farmacia{" +
                "nome_farmacia='" + nome_farmacia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
