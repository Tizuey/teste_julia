package org.farmacia.interface_menu;

import org.farmacia.services.RemedioService;
import org.farmacia.entities.*;

import java.util.Scanner;

public class Menu {

    // MENU INICIAL  --------------------------------------------------------------
    public static void menuInicial() {
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
        respostaMenuInicial = sc1.nextInt();
        switch (respostaMenuInicial) {
            case 1:
                System.out.println("Você é Cliente");
                break;
            case 2:
                barraDePesquisa();
                break;
            case 3:
                System.out.println("Você escolheu sair do sistema...");
                sc1.close();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void barraDePesquisa() {
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
        respostaBarraDePesquisa = sc3.nextInt();
        Scanner pesquisa = new Scanner(System.in);
        switch (respostaBarraDePesquisa) {
            case 1:
                RemedioService.buscarRemedioPorNome(pesquisa);
                barraDePesquisa();
                break;
            case 2:
                RemedioService.buscarRemedioPorSubstancia(pesquisa);
                barraDePesquisa();
                break;
            case 3:
                tipoSubstancia();
                barraDePesquisa();
                break;
            case 4:
                tipoRemedio();
                barraDePesquisa();
                break;
            case 5:
                RemedioService.buscarRemedioPorValidade(pesquisa);
                barraDePesquisa();
                break;

            case 6:
                menuInicial();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void tipoSubstancia() {
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
        respostaTipoSubstancia = sc3.nextInt();
        switch (respostaTipoSubstancia) {
            case 1:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Alzheimer_Demencia);
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antidrepressivo);
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antipsicotico);
                break;
            case 4:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Parkinson);
                break;
            case 5:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antinflamatorio_DorDeCabeca);
                break;

            case 6:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Vitamina);
                break;

            case 7:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Outros);
                break;

            case 8:
                menuInicial();
                break;
        }
    }

    // BARRA DE PESQUISA --------------------------------------------------------------
    public static void tipoRemedio() {
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
        respostaTipoRemedio = sc3.nextInt();
        switch (respostaTipoRemedio) {
            case 1:
                RemedioService.buscarRemedioPorTipoRemedio(Oral.class);
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoRemedio(Injetavel.class);
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoRemedio(Topico.class);
                break;
            case 4:
                menuInicial();
                break;
        }
    }



    ////// the end bitch
}
