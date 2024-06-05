package org.farmacia.repositories;


import org.farmacia.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

// Repositório de Remédios: Armazena remédios em memória em uma ArrayList_____________________________________
public class RemedioRepository {

    private static ArrayList<Remedio> remedios = new ArrayList<>();

// ADICIONA remedio em um lista
    public static void save(Remedio remedio) {
        remedios.add(remedio);
    }
//____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o nome digitado ____________________________________________________
    public static ArrayList<Remedio> encontrarPorNome(String nome) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.nome_remedio.toLowerCase(), nome.toLowerCase())) {
                remediosPesquisados.add(remedio);
            }
        }
        System.out.println(remediosPesquisados);
        return remediosPesquisados;
    }
//______________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o a data de vencimento digitada ______________________________________
    public static ArrayList<Remedio> encontrarPorValidade(LocalDate validade) {
        ArrayList<Remedio> remediosPesquisados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (Objects.equals(remedio.data_vencimento, validade)) {
                remediosPesquisados.add(remedio);
            }
        }
        return remediosPesquisados;
    }
//____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o a substancia digitada ___________________________________________
    public static ArrayList<Remedio> encontrarPorSubstancia(String substancia) {
        ArrayList<Remedio> remediosEncontrados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (remedio.getSubstancia().getNome_substancia().equalsIgnoreCase(substancia)) {
            remediosEncontrados.add(remedio);
            }
        }
        System.out.println(remediosEncontrados);
        return remediosEncontrados;
    }
//____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o tipo de substancia digitado ______________________________________
    public static ArrayList<Remedio> encontrarPorRemedioPorTipoSubstancia(Tipo tipo) {
        ArrayList<Remedio> remediosEncontrados = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (remedio.getSubstancia().getMeuTipo().equals(tipo)) {
                remediosEncontrados.add(remedio);
            }
        }
        return remediosEncontrados;
    }
//___________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o tipo de remedio digitado _____________________________________

    public static ArrayList<Remedio> encontrarPorRemedioPorTipoRemedio(Class tipo) {
        ArrayList<Remedio> remediosTipo = new ArrayList<>();
        for (Remedio remedio : remedios) {
            if (tipo.isInstance(remedio)) {
                remediosTipo.add(remedio);
            } else {
                System.out.println("Tipo de remedio não encontrado");
            }
        }
        return remediosTipo;
    }
//___________________________________________________________________________________________________________


//LISTAGEM -> Listar todos os remedios cadastrados ___________________________________________________________
    public static ArrayList<Remedio> encontrarTodosRemedios() {
        return remedios;
    }
//____________________________________________________________________________________________________________



    //atualizarRemedio(String nome, String farmaceutica, String novoNome, Date dataVencimento, int quantidade,float concentracao, Farmaceutica novaFarmaceutica): void -> Atualiza remédio x de farmaceutica y com os dados passados.
    public static void atualizarRemedio(String nome, String novoNome, Float preco, LocalDate dataVencimento, int quantidade,
                                        float concentracao, Substancia substancia) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        for (Remedio remedio : remediosPesquisados) {
            if (Objects.equals(remedio.getNome_remedio().toLowerCase(), substancia.getNome_substancia().toLowerCase())) {
                remedio.setNome_remedio(novoNome);
                remedio.setData_vencimento(dataVencimento);
                remedio.setPreco(preco);
                remedio.setQuantidade_estoque(quantidade);
                remedio.setConcentracao(concentracao);
            } else {
                System.out.println("Remédio não encontrado.");
            }
        }
    }

    //Apagar Remedio através de seu nome
    public static void removerRemedio(String nome) {
        ArrayList<Remedio> remediosPesquisados = encontrarPorNome(nome);
        for (Remedio remedio : remediosPesquisados) {
            if (Objects.equals(remedio.getNome_remedio().toLowerCase(), nome.toLowerCase())) {
                remedios.remove(remedio);
            } else {
                System.out.println("Remédio não encontrado.");
            }
        }
    }




}