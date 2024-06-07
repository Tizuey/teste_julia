package org.farmacia.interface_menu;

import org.farmacia.repositories.RemedioRepository;
import org.farmacia.services.RemedioService;
import org.farmacia.entities.*;
import org.farmacia.services.SubstanciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

// MENU INICIAL  --------------------------------------------------------------------------------------
    public static void menuInicial()  {
        int respostaMenuInicial;
        Scanner sc1 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Olá, Você é um   C L I E N T E   ou  nosso  A D M I N I S T R A D O R  ? ");
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
                menuCliente();
                break;
            case 2:
                senha();
                break;
            case 3:
                System.out.println(" ");
                System.out.println("Volte Sempre");
                sc1.close();
                break;
        }
    }
//---------------------------------------------------------------------------------------------------

// Senha para acessar o perfil de administrador -----------------------------------------------------
    public static void senha()  {
        int respostaAdmSenha;
        Scanner sc8 = new Scanner(System.in);
        do {
            System.out.print("Digite a senha : ");
            respostaAdmSenha = sc8.nextInt();
            if(respostaAdmSenha != 1234){
                System.out.println("senha incorreta");
                System.out.print(" Digite a senha  --> : ");
            }
        } while(respostaAdmSenha != 1234);
        menuAdm();
    }
//---------------------------------------------------------------------------------------------------

// MENU DE ADMINISTRADOR --------------------------------------------------------------
    public static void menuAdm()  {
        int respostaTipoRemedio;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Bem Vindo, A D M I N I S T R A D O R ");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("[1] - Cadastro");
        System.out.println("[2] - Barra de Pesquisa");
        System.out.println("[3] - Vender Remédio");
        System.out.println("[4] - Comprar Remédio");
        System.out.println("[5] - Estoque");
        System.out.println("[6] - Sair");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaTipoRemedio = sc3.nextInt();
        Scanner cadastro = new Scanner(System.in);
        switch (respostaTipoRemedio) {
            case 1:
                cadastro();
                break;
            case 2:
                barraDePesquisa();
                break;
            case 3:
                venderRemedio();
                break;
            case 4:
                RemedioService.comprarRemedio();
                menuSairadm();
                break;
            case 5:
                RemedioService.estoque();
                menuSairadm();
                break;
            case 6:
                System.out.println(" ");
                System.out.println("Volte Sempre");
                sc3.close();
                break;
        }
    }
//---------------------------------------------------------------------------------------------------



// CADASTRO -----------------------------------------------------------------------------------------

    public static void cadastro()  {
        int respostaTipoRemedio;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" MENU CADASTRO ");
        System.out.println(" ----------------------");
        System.out.println(" ");
        System.out.println("Escolha pelo o que quer procurar o remedio ");
        System.out.println("[1] - Cadastrar Remédio");
        System.out.println("[2] - Cadastar Substância");
        System.out.println("[3] - ALterar Remédio");
        System.out.println("[4] - Alterar Substância");
        System.out.println("[5] - Remover Remédio");
        System.out.println("[6] - Remover Substância");
        System.out.println(" -------------------------");
        System.out.print("  --> : ");
        respostaTipoRemedio = sc3.nextInt();
        Scanner cadastro = new Scanner(System.in);
        switch (respostaTipoRemedio) {
            case 1:
                RemedioService.cadastrarRemedio(cadastro);
                menuSairadm();
                break;
            case 2:
                SubstanciaService.cadastrarSubstancia(cadastro);
                menuSairadm();
                break;
            case 3:
                RemedioService.atualizarRemedio(cadastro);
                menuSairadm();
                break;
            case 4:
                SubstanciaService.atualizarSubstancia(cadastro);
                menuSairadm();
                break;
            case 5:
                RemedioService.removerRemedio();
                menuSairadm();
                break;
            case 6:
                SubstanciaService.removerSubstancia();
                menuSairadm();
                break;
        }
    }


//---------------------------------------------------------------------------------------------------

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
        System.out.println(" ----------------------");
        System.out.println("ou se quer trazer Todos os : ");
        System.out.println("[6] - Remédios");
        System.out.println("[7] - Substâncias");
        System.out.println(" ----------------------");
        System.out.print("  --> : ");
        respostaBarraDePesquisa = sc3.nextInt();
        Scanner pesquisa = new Scanner(System.in);
        switch (respostaBarraDePesquisa) {
            case 1:
                RemedioService.buscarRemedioPorNome(pesquisa);
                menuSairadm();
                break;
            case 2:
                RemedioService.buscarRemedioPorSubstancia(pesquisa);
                menuSairadm();
                break;
            case 3:
                tipoSubstancia();
                break;
            case 4:
                tipoRemedio();
                break;
            case 5:
                RemedioService.buscarRemedioPorValidade(pesquisa);
                menuSairadm();
                break;
            case 6:
                RemedioService.listarRemedios();;
                menuSairadm();
                break;
            case 7:
                SubstanciaService.listarSubstancias();
                menuSairadm();
                break;

        }
    }

// BARRA DE PESQUISA - Tipo de Substância--------------------------------------------------------------
    public static void tipoSubstancia()  {
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
                menuSairadm();
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antidrepressivo);
                menuSairadm();
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antipsicotico);
                menuSairadm();
                break;
            case 4:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Parkinson);
                menuSairadm();
                break;
            case 5:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Antinflamatorio_DorDeCabeca);
                menuSairadm();
                break;

            case 6:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Vitamina);
                menuSairadm();
                break;

            case 7:
                RemedioService.buscarRemedioPorTipoSubstancia(Tipo.Outros);
                menuSairadm();
                break;

            case 8:
                menuAdm();
                break;
        }
    }

// BARRA DE PESQUISA - Tipo Remedio --------------------------------------------------------------
    public static void tipoRemedio()  {
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
                menuSairadm();
                break;
            case 2:
                RemedioService.buscarRemedioPorTipoRemedio(Injetavel.class);
                menuSairadm();
                break;
            case 3:
                RemedioService.buscarRemedioPorTipoRemedio(Topico.class);
                menuSairadm();
                break;
            case 4:
                menuAdm();
                break;
        }
    }
//--------------------------------------------------------------------------------------------
// MENU DE CLIENTE --------------------------------------------------------------
public static void menuCliente()  {
    int respostaTipoRemedio;
    Scanner sc3 = new Scanner(System.in);
    System.out.println(" ");
    System.out.println("Bem Vindo, C L I E N T E ");
    System.out.println(" ----------------------");
    System.out.println(" ");
    System.out.println("[1] - Barra de Pesquisa");
    System.out.println("[2] - Comprar Remédio");
    System.out.println("[3] - Sair");
    System.out.println(" ----------------------");
    System.out.print("  --> : ");
    respostaTipoRemedio = sc3.nextInt();
    Scanner cadastro = new Scanner(System.in);
    switch (respostaTipoRemedio) {
        case 1:
            barraDePesquisa2();
            break;
        case 2:
            venderRemedio();
            menuSair();
            break;
        case 3:
            System.out.println(" ");
            System.out.println("Volte Sempre");
            sc3.close();
            break;
    }
}
//---------------------------------------------------------------------------------------------------
// BARRA DE PESQUISA --------------------------------------------------------------
public static void barraDePesquisa2() {
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
    System.out.println(" ----------------------");
    System.out.println("ou se quer trazer Todos os : ");
    System.out.println("[6] - Remédios");
    System.out.println("[7] - Substâncias");
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
            tipoSubstancia2();
            break;
        case 4:
            tipoRemedio2();
            break;
        case 5:
            RemedioService.buscarRemedioPorValidade(pesquisa);
            menuSair();
            break;
        case 6:
            RemedioService.listarRemedios();
            menuSair();
            break;
        case 7:
            SubstanciaService.listarSubstancias();
            menuSair();
            break;

    }
}

    // BARRA DE PESQUISA - Tipo de Substância--------------------------------------------------------------
    public static void tipoSubstancia2()  {
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
                menuCliente();
                break;
        }
    }

    // BARRA DE PESQUISA - Tipo Remedio --------------------------------------------------------------
    public static void tipoRemedio2()  {
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
                menuCliente();
                break;
        }
    }
    //--------------------------------------------------------------------------------------------
// VENDER REMEDIO / COMPRAR REMEDIO --------------------------------------------------------------
    public static void venderRemedio() {
        List<String> nomeRemedios = new ArrayList<>();
        String opcao;
        do {
            Scanner sc = new Scanner(System.in);
            RemedioService.listarRemedios();
            System.out.print("Digite o nome do remédio a Comprar: ");
            String nome = sc.nextLine();
            nomeRemedios.add(nome);
            Remedio remedio = RemedioService.buscarRemedioPorNome3(nome);
            if (remedio != null) {
                System.out.println("É esse o remédio que você deseja Comprar?");
                System.out.println("[1] - Sim | [2] - Não");
                System.out.print("  --> : ");
                int resposta = sc.nextInt();
                if(resposta == 1) {
                    System.out.print("Digite a quantidade a comprar: ");
                    Scanner sc5 = new Scanner(System.in);
                    int quantidade = sc5.nextInt();
                    if(remedio.getQuantidade_estoque() >= quantidade) {
                        remedio.setQuantidade_estoque(remedio.getQuantidade_estoque() - quantidade);
                    } else {
                        System.out.println("Quantidade em estoque insuficiente.");
                        System.out.println("Em estoque :" + remedio.getQuantidade_estoque());
                    }
                }
            } else {
                System.out.println("Remédio não encontrado.");
            }
            System.out.println("Deseja comprar mais algum remédio?");
            System.out.println("[1] - Sim | [2] - Não");
            System.out.print("  --> : ");
            Scanner sc3 = new Scanner(System.in);
            opcao = sc3.nextLine();
        } while (opcao.equals("1"));

        System.out.println("Deseja finalizar a compra?");
        System.out.println("[1] - Sim | [2] - Não");
        System.out.print("  --> : ");
        Scanner sc2 = new Scanner(System.in);
        opcao = sc2.nextLine();
        if(opcao.equals("1")) {
            System.out.println("Compra finalizada com sucesso!");
            System.out.println("_________________FARMACIA UNIFACS_________________");
            System.out.println("                 Nota Fiscal                      ");
            RemedioService.notafiscal((ArrayList<String>) nomeRemedios);

        } else {
            System.out.println("A compra foi cancelada.");
        }
    }


    // MENU SECUNDÁRIO OU SAIR - (ADM)--------------------------------------------------------------
    public static void menuSairadm()  {
        int resposta2;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("[1] - Voltar ao Menu   |   [2] - Sair   ");
        System.out.print("  --> : ");
        resposta2 = sc3.nextInt();
        switch (resposta2) {
            case 1:
                menuAdm();
                break;
            case 2:
                System.out.println(" ");
                System.out.println("Volte Sempre");
                sc3.close();
                break;
        }
    }
    // MENU SECUNDÁRIO OU SAIR - (CLIENTE)--------------------------------------------------------------
    public static void menuSair()  {
        int resposta2;
        Scanner sc3 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("[1] - Voltar ao Menu   |   [2] - Sair   ");
        System.out.print("  --> : ");
        resposta2 = sc3.nextInt();
        switch (resposta2) {
            case 1:
                menuCliente();
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
