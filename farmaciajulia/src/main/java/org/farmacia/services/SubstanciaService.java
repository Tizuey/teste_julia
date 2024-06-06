package org.farmacia.services;

import org.farmacia.entities.Substancia;
import org.farmacia.entities.Tipo;
import org.farmacia.repositories.SubstanciaRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubstanciaService {

    /*
    Alzheimer_Demencia,
    Antidrepressivo,
    Antipsicotico,
    Parkinson,
    Antinflamatorio_DorDeCabeca,
    Outros,
    Vitamina
     */


// Adicionar na lista de substâncias-------------------------------------------
    public static void save(Substancia sub) {
        SubstanciaRepository.save(sub);
    }
//-----------------------------------------------------------------------------------

//CADASTRO -> Cadastrar Remedio ____________________________________________________
    public static void cadastrarSubstancia(Scanner sc) {
        System.out.println("--- CADASTRO DE SUBSTANCIA ---");
        System.out.print("Digite o nome da substancia: ");
        String nome = sc.nextLine();
        Substancia substancia = new Substancia(getTipo(sc), nome);
        SubstanciaRepository.save(substancia);
        System.out.println("Substancia cadastrada com sucesso!");
    }
//-----------------------------------------------------------------------------------

//CADASTRO -> Remover Substancia ____________________________________________________

    public static void removerSubstancia() {
        Scanner scanner = new Scanner(System.in);
        try {
            SubstanciaService.listarSubstancias();
            System.out.print("Digite o nome da substância a ser removida :  ");
            String nome = scanner.nextLine();
            ArrayList<Substancia> substanciasPesquisadas = SubstanciaRepository.encontrarPorNome(nome);
            System.out.println("Substância encontrada: " + substanciasPesquisadas.get(0));
            if (!substanciasPesquisadas.isEmpty()) {
                System.out.println("Você realmente deseja remover a substância? digite 1 para sim, 2 para não.");
                System.out.print("[1] - Sim   |   [2] - Não  : ");
                int confirmacao = scanner.nextInt();
                switch (confirmacao) {
                    case 1:
                        System.out.println("Por favor, insira a senha de administrador para continuar:");
                        String senha = scanner.next();
                        if (senha.equals("senhaDoAdministrador")) {
                            SubstanciaRepository.removerSubstancia(nome);
                            System.out.println("Substância removida com sucesso!");
                        } else {
                            System.out.println("Senha incorreta. Ação cancelada.");
                        }
                        break;
                    case 2:
                        System.out.println("Ação cancelada pelo usuário.");
                        break;
                    default:
                        System.out.println("Entrada inválida. Ação cancelada.");
                        break;
                }
            } else {
                System.out.println("Substância não encontrada.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Ação cancelada.");
        }
    }

//-----------------------------------------------------------------------------------
//CADASTRO -> Atualizar Substancia ____________________________________________________

    public static void atualizarSubstancia(Scanner sc) {
        System.out.println("-- ATUALIZAR SUBSTÂNCIA --");
        System.out.print("Insira o nome antigo da substância: ");
        String oldNome = sc.nextLine();
        if (!SubstanciaRepository.encontrarPorNome(oldNome).isEmpty()) {
            System.out.println("Agora insira as informações atualizadas.");
            System.out.print("Digite o nome da substância: ");
            String nome = sc.nextLine();
            System.out.print("Qual é o tipo? ");
            Tipo meuTipo = Tipo.valueOf(sc.nextLine());
            Substancia substancia = new Substancia(meuTipo, nome);
            SubstanciaRepository.atualizarSubstancia(oldNome, substancia);
            System.out.println("Substância atualizada!");
        } else {
            System.out.println("Substância não encontrada.");
        }
    }
//-----------------------------------------------------------------------------------

    public static void encontrarPorNome(Scanner sc) {
        System.out.print("Pesquisar pelo nome: ");
        String nome = sc.nextLine();
        ArrayList<Substancia> subs = SubstanciaRepository.encontrarPorNome(nome);
        if (!subs.isEmpty()) {
            System.out.printf("%-12s | %-12s%n", "Nome", "Tipo");
            for (Substancia sub : subs) {
                System.out.printf("%-12s | %-12s%n", sub.getNome_substancia(), sub.getMeuTipo());
            }
        } else {
            System.out.println("Nenhuma substancia com este nome foi encontrada.");
        }
    }

    public static void encontrarPorTipo(Scanner sc) {
        System.out.println("Pesquisar pelo tipo: ");
        ArrayList<Substancia> substancias = SubstanciaRepository.encontrarPorTipo(getTipo(sc));
        if (!substancias.isEmpty()) {
            System.out.printf("%-12s | %-12s%n", "Nome", "Tipo");
            for (Substancia substancia : substancias) {
                System.out.printf("%-12s | %-12s%n", substancia.getNome_substancia(), substancia.getMeuTipo());
            }
        } else {
            System.out.println("Nenhuma substancia com este tipo foi encontrada.");
        }
    }

    private static Tipo getTipo(Scanner sc) {
        Tipo tipo;
        byte tipoEscolha = 0;
        System.out.println("""
                Escolha o tipo da substância:
                [1] Alzheimer ou Demencia
                [2] Antidrepressivo
                [3] Antipsicotico
                [4] Parkinson
                [5] Antinflamatorio ou Dor de Cabeça
                [6] Vitamina
                [7] Outros""");
        System.out.print("-> ");
        try {
            tipoEscolha = Byte.parseByte(sc.nextLine());
        } catch (NumberFormatException ignored) {
        }
        tipo = switch (tipoEscolha) {
            case 1 -> Tipo.Alzheimer_Demencia;
            case 2 -> Tipo.Antidrepressivo;
            case 3 -> Tipo.Antipsicotico;
            case 4 -> Tipo.Parkinson;
            case 5 -> Tipo.Antinflamatorio_DorDeCabeca;
            case 6 -> Tipo.Vitamina;
            default -> Tipo.Outros;
        };
        return tipo;
    }

    public static void listarSubstancias() {
        ArrayList<Substancia> substancias = SubstanciaRepository.encontrarTodasSubstancias();
        if (!substancias.isEmpty()) {
            System.out.print("SUBSTÂNCIAS CADASTRADAS ");
            System.out.println("_".repeat(10));
            for (Substancia substancia : substancias) {
                System.out.printf("%-12s %n", substancia.getNome_substancia());
            }
            System.out.println("_".repeat(40));
        } else {
            System.out.println("Substâncias não encontradas.");
        }
    }

}

