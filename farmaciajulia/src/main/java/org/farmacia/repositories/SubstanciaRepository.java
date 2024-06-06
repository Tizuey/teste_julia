package org.farmacia.repositories;

import org.farmacia.entities.Substancia;
import org.farmacia.entities.Tipo;

import java.util.ArrayList;
import java.util.Objects;

// Repositório de Substancia: Armazena substancias em memória em uma ArrayList
public class SubstanciaRepository {
    static ArrayList<Substancia> substancias = new ArrayList<>();
    //save(Substancia):void -> Adiciona substancia ao banco de dados
    public static void save(Substancia substancia) {
        substancias.add(substancia);
    }

    //encontrarPorNome(String nome): ArrayList<Substancia> -> Pesquisa por um nome e retorna substancias com este nome
    public static ArrayList<Substancia> encontrarPorNome(java.lang.String nome) {
        ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
        for (Substancia substancia : substancias) {
            if (Objects.equals(substancia.nome_substancia.toLowerCase(), nome.toLowerCase())) {
                substanciasPesquisados.add(substancia);
            }
        }
        return substanciasPesquisados;
    }

    //encontrarPorTipo(Tipo meuTipo): ArrayList<Substancia> -> Pesquisa por um Tipo e retorna tipo da substancia com este nome
    public static ArrayList<Substancia> encontrarPorTipo(Tipo tipo) {
        ArrayList<Substancia> substanciasPesquisados = new ArrayList<>();
        for (Substancia substancia : substancias) {
            if (Objects.equals(substancia.getMeuTipo(),tipo)) {
                substanciasPesquisados.add(substancia);
            }
        }
        return substanciasPesquisados;
    }

    // encontrarTodosSubstancias(): ArrayList<Substancia> -> Retorna todos Substancias cadastrados,
    public static ArrayList<Substancia> encontrarTodasSubstancias() {
        return substancias;
    }

    // Apagar Substancia através de seu nome
    public static void removerSubstancia(String nome) {
        ArrayList<Substancia> substanciasPesquisadas = encontrarPorNome(nome);
        for (Substancia substancia : substanciasPesquisadas) {
            if (Objects.equals(substancia.getNome_substancia().toLowerCase(), nome.toLowerCase())) {
                substancias.remove(substancia);
            } else {
                System.out.println("Substância não encontrada.");
            }
        }
    }
    //CADASTRO - Atualizar substância -------------------------------------------------------------------------------
    public static void atualizarSubstancia(String oldNome, Substancia novaSubstancia) {
        ArrayList<Substancia> substanciasPesquisadas = encontrarPorNome(oldNome);
        for (Substancia substancia : substanciasPesquisadas) {
            if (Objects.equals(substancia.getNome_substancia().toLowerCase(), oldNome.toLowerCase())) {
                substancia.setMeuTipo(novaSubstancia.getMeuTipo());
                substancia.setNome_substancia(novaSubstancia.getNome_substancia());
            } else {
                System.out.println("Substância não encontrada.");
            }
        }
    }


}
