package org.farmacia.interface_menu;

import org.farmacia.services.RemedioService;
import org.farmacia.entities.*;

import java.util.Scanner;

public class Menu {

    // MENU INICIAL  --------------------------------------------------------------
    public static void menuInicial() throws InterruptedException {
        int respostaMenuInicial;
        Scanner sc1 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Olá, Você é um   C L I E N T E   ou  nosso  A D M N I S T R A D O R  ? ");
        System.out.println(" ----------------------------------------------------------------------");
        System.out.println(" ( Digite o número correspondente a opção desejado desejada )");
        System.out.println(" ");
        System.out.println("Escolha dentre as opções");
        System.out.println("[1] - Cliente");
        System.out.println("[2] - Administrador");
        System.out.println("[3] - Sair");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaMenuInicial = sc1.nextInt();
        switch (respostaMenuInicial) {
            case 1:
                System.out.println("Você é Cliente");
                break;
            case 2:
                menuAdm();
                break;
            case 3:
                System.out.println(" ");
                System.out.println("Volte Sempre");
                sc1.close();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void menuAdm() throws InterruptedException {
        int respostaTipoRemedio;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Bem Vindo, A D M N I S T R A D O R ");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("Escolha pelo o que quer procurar o remedio ");
        System.out.println("[1] - Cadastro");
        System.out.println("[2] - Barra de Pesquisa");
        System.out.println("[3] - Vender Remédio");
        System.out.println("[4] - Comprar Remédio");
        System.out.println("[5] - Estoque");
        System.out.println("[6] - Extratp");
        System.out.println("[7] - Voltar ao Menu Inicial");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaTipoRemedio = sc3.nextInt();
        Scanner cadastro = new Scanner(System.in);
        switch (respostaTipoRemedio) {
            case 1:
                RemedioService.cadastrarRemedio(cadastro);
                menuSair();
                break;
            case 2:
                barraDePesquisa();
                menuSair();
                break;
            case 3:
                menuSair();
                break;
            case 4:
                menuInicial();
                break;
        }
    }



// BARRA DE PESQUISA --------------------------------------------------------------
    public static void barraDePesquisa() throws InterruptedException {
        int respostaBarraDePesquisa;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" B A R R A    D E    P E S Q U I S A");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("Escolha pelo o que quer procurar o remedio ");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Substância");
        System.out.println("[3] - Tipo de Substância");
        System.out.println("[4] - Tipo de Remedio");
        System.out.println("[5] - Data de Vencimento");
        System.out.println("[6] - Voltar ao Menu Inicial");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaBarraDePesquisa = sc3.nextInt();
        Scanner pesquisa = new Scanner(System.in);
        switch (respostaBarraDePesquisa) {
            case 1:
                RemedioService.buscarRemedioPorNome(pesquisa);
                menuSair();
                break;
            case 2:
                RemedioService.buscarRemedioPorSubstancia(pesquisa);
                menuSair();
                break;
            case 3:
                tipoSubstancia();
                break;
            case 4:
                tipoRemedio();
                break;
            case 5:
                RemedioService.buscarRemedioPorValidade(pesquisa);
                menuSair();
                break;

            case 6:
                menuInicial();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void tipoSubstancia() throws InterruptedException {
        int respostaTipoSubstancia;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Qual tipo ? ");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("Escolha pelo o que quer procurar o remedio ");
        System.out.println("[1] - Alzheimer_Demencia");
        System.out.println("[2] - Antidrepressivo");
        System.out.println("[3] - Antipsicotico");
        System.out.println("[4] - Parkinson");
        System.out.println("[5] - Antinflamatorio_DorDeCabeca");
        System.out.println("[6] - Vitamina");
        System.out.println("[7] - Outros");
        System.out.println("[8] - Voltar ao Menu Inicial");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaTipoSubstancia = sc3.nextInt();
        switch (respostaTipoSubstancia) {
            case 1:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Alzheimer_Demencia);
                menuSair();
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antidrepressivo);
                menuSair();
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antipsicotico);
                menuSair();
                break;
            case 4:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Parkinson);
                menuSair();
                break;
            case 5:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antinflamatorio_DorDeCabeca);
                menuSair();
                break;

            case 6:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Vitamina);
                menuSair();
                break;

            case 7:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Outros);
                menuSair();
                break;

            case 8:
                menuInicial();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void tipoRemedio() throws InterruptedException {
        int respostaTipoRemedio;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Qual tipo ? ");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("Escolha pelo o que quer procurar o remedio ");
        System.out.println("[1] - Oral");
        System.out.println("[2] - Injetável");
        System.out.println("[3] - Tópico");
        System.out.println("[4] - Voltar ao Menu Inicial");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaTipoRemedio = sc3.nextInt();
        switch (respostaTipoRemedio) {
            case 1:
                RemedioService.buscarRemedioPorTipoRemedio(Oral.class);
                menuSair();
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoRemedio(Injetavel.class);
                menuSair();
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoRemedio(Topico.class);
                menuSair();
                break;
            case 4:
                menuInicial();
                break;
        }
    }

// MENU SECUNDÁRIO OU SAIR --------------------------------------------------------------
    public static void menuSair() throws InterruptedException {
        int resposta2;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("[1] - Voltar ao Menu   |   [2] - Sair   ");
        System.out.print("  --> : ");
        resposta2 = sc3.nextInt();
        switch (resposta2) {
            case 1:
                System.out.println("menu secundário");
                break;
            case 2:
                System.out.println(" ");
                System.out.println("Volte Sempre");
                sc3.close();
                break;
        }
    }


    ////// the end bitch
}
