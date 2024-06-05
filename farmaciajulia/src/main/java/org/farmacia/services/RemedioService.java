package org.farmacia.services;

import org.farmacia.entities.*;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class
RemedioService {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");



//BARRA DE PESQUISA -> Achar o remedio com o nome digitado ____________________________________________________
//_____________________________________________________________________________________________________________


//BARRA DE PESQUISA -> Achar o remedio com o nome digitado ____________________________________________________
public static void buscarRemedioPorNome(Scanner sc) {
    System.out.print("Procurar pelo nome: ");
    String nome = sc.nextLine();
    ArrayList<Remedio> remedios = RemedioRepository.encontrarPorNome(nome);
    if (!remedios.isEmpty()) {
        System.out.println("Remédios com o nome " + nome + " ");
        System.out.println("_".repeat(61));
        System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Vencimento", "Quantidade", "Concentração");
        System.out.println("_".repeat(61));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %s%n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getSubstancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(61));
    } else {
        System.out.println("Remédio(s) não encontrado(s).");
    }
}
//_____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o a substancia digitada ___________________________________________
public static void buscarRemedioPorSubstancia(Scanner sc) {
    System.out.print("Procurar pela substância: ");
    String substancia = sc.nextLine();
    ArrayList<Remedio> remedios = RemedioRepository.encontrarPorSubstancia(substancia);
    if (!remedios.isEmpty()) {
        System.out.println("Remédios com a substância " + substancia + " ");
        System.out.println("_".repeat(61));
        System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Vencimento", "Quantidade", "Concentração");
        System.out.println("_".repeat(61));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %s%n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getSubstancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(61));
    } else {
        System.out.println("Remédio(s) não encontrado(s).");
    }
}

//____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o tipo de substancia digitado _____________________________________
public static void buscarRemedioPorTipoSubstancia(Tipo tipo) {
    System.out.print("Procurar pelo tipo de substância: ");
   // String tipo = sc.nextLine();
    ArrayList<Remedio> remedios = RemedioRepository.encontrarPorRemedioPorTipoSubstancia(tipo);
    if (!remedios.isEmpty()) {
        System.out.println("Remédios com o tipo de substância " + tipo + " ");
        System.out.println("_".repeat(61));
        System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Vencimento", "Quantidade", "Concentração");
        System.out.println("_".repeat(61));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %s%n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getSubstancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(61));
    } else {
        System.out.println("Remédio(s) não encontrado(s) para este tipo de substância.");
    }
}

//_____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o tipo de remedio digitado _____________________________________

    public static void buscarRemedioPorTipoRemedio(Class tipo) {
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorRemedioPorTipoRemedio(tipo);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios do tipo " + tipo.getSimpleName() + ":");
            System.out.println("_".repeat(61));
            System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Quantidade");
            System.out.println("_".repeat(61));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getSubstancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
            }
            System.out.println("_".repeat(61));
        } else {
            System.out.println("Remédio(s) do tipo " + tipo.getSimpleName() + " não encontrado(s).");
        }
    }

//_____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o a data de vencimento digitada ______________________________________

    public static void buscarRemedioPorValidade(Scanner sc) {
        System.out.print("Procurar por validade (formato YYYY-MM-DD): ");
        String data = sc.nextLine();
        LocalDate validade = LocalDate.parse(data);
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorValidade(validade);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com a data de vencimento " + validade + " ");
            System.out.println("_".repeat(61));
            System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Nome", "Vencimento", "Quantidade", "Concentração");
            System.out.println("_".repeat(61));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10s%nUso: %-12s %s%n%nDescrição:%n%s%n", remedio.getNome_remedio(), remedio.getSubstancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
            }
            System.out.println("_".repeat(61));
        } else {
            System.out.println("Remédio(s) não encontrado(s).");
        }
    }
//_____________________________________________________________________________________________________________
/*
    public static void cadastrarRemedio(Scanner sc) {
        int quantidade = -1;
        float concentracao = -1;
        System.out.println("-- CADASTRAR NOVO REMÉDIO --");
        ArrayList<Substancia> sub = new ArrayList<>();
        while (true) {
            try {
                SubstanciaService.listarSubstancias();
                System.out.print("Digite o nome da substância do remédio: ");
                String subName = sc.nextLine();
                Substancia substancia = SubstanciaRepository.encontrarPorNome(subName);
                if (substancia != null) {
                    sub.add(substancia);
                } else {
                    System.out.println("Substância não encontrada");
                }
                System.out.println("Você deseja adicionar outra substância? (S/N) ");
                String opcao = sc.nextLine();
                if (!opcao.equalsIgnoreCase("s")) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("  ");
                System.out.println("!!! Substância não encontrada !!!");
                System.out.println("  ");
                System.out.println("Veja se digitou corretamente");
                System.out.println("  ou  ");
                System.out.println("Saia e Cadastre Substância");
                System.out.println("Digite 1 para sair ");
                Scanner aux = new Scanner(System.in);
                int a = aux.nextInt();
                if (a == 1) {
                    return;
                }
            }
        }
        System.out.print("Digite o nome do remédio: ");
        String nome = sc.nextLine();
        LocalDate date = getDate(sc);
        while (quantidade < 0) {
            try {
                System.out.print("Digite a quantidade de remédios em estoque: ");
                quantidade = sc.nextInt();
                if (quantidade < 0) {
                    System.out.println("Por favor, insira uma quantidade válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma quantidade válida.");
                sc.nextLine();
            }
        }
        while (concentracao < 0) {
            try {
                System.out.print("Digite a concentração do remédio: ");
                concentracao = sc.nextFloat();
                if (concentracao < 0) {
                    System.out.println("Por favor, insira uma concentração válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma concentração válida.");
                sc.nextLine();
            }
        }
        System.out.print("Qual é dosagem recomendada dele? ");
        String dosagem = sc.nextLine();
        System.out.printf("O remédio é:%n[1] Uso Oral,%n[2] Uso Tópico,%n[3] Injetável.%n>>> ");
        byte res = 0;
        while (res < 1 || res > 3) {
            try {
                res = Byte.parseByte(sc.nextLine());
                if (res < 1 || res > 3) {
                    System.out.println("Por favor, digite uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite uma opção válida.");
            }
        }
        Remedio remedio = switch (res) {
            case 1 -> new RemedioOral(sub, nome, date, quantidade, concentracao, Uso.Oral, "3 ao dia", "Muito bala");
            case 2 -> new RemedioTopico(sub, nome, date, quantidade, concentracao, Uso.Topico, "3 ao dia", "Muito bala");
            case 3 -> new RemedioInjetavel(sub, nome, date, quantidade, concentracao, Uso.Injetavel, "3 ao dia", "Muito bala");
            default -> null;
        };
        RemedioRepository.save(remedio);
        System.out.println("Remédio cadastrado!");
    }

    public static void listarRemedios() {
        ArrayList<Remedio> remedios = RemedioRepository.encontrarTodosRemedios();
        if (!remedios.isEmpty()) {
            System.out.print("REMÉDIOS CADASTRADOS ");
            System.out.println("_".repeat(25));
            System.out.printf("%-20s | %-10s | %-10s %n", "Nome", "Uso", "Vencimento");
            System.out.println("_".repeat(46));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s %n", remedio.getNome_remedio(), remedio.getUso(), remedio.getData_vencimento().format(formatter));
            }
            System.out.println("_".repeat(46));
        } else {
            System.out.println("Remédios não encontrados.");
        }
    }



    public static void atualizarRemedio(Scanner sc) {
        System.out.println("-- ATUALIZAR REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String oldNome = sc.nextLine();
        if (!RemedioRepository.encontrarPorNome(oldNome).isEmpty()) {
            int quantidade = -1;
            float concentracao = -1;
            String farmaceuticaNome;
            System.out.println("Agora insira as informações atualizadas.");
            System.out.print("Digite o nome do remédio: ");
            String nome = sc.nextLine();
            LocalDate date = getDate(sc);
            while (quantidade < 0) {
                try {
                    System.out.print("Digite a quantidade de remédios em estoque: ");
                    quantidade = sc.nextInt();
                    if (quantidade < 0) {
                        System.out.println("Por favor, insira uma quantidade válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira uma quantidade válida.");
                    sc.nextLine();
                }
            }
            while (concentracao < 0) {
                try {
                    System.out.print("Digite a concentração do remédio: ");
                    concentracao = sc.nextFloat();
                    if (concentracao < 0) {
                        System.out.println("Por favor, insira uma concentração válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira uma concentração válida.");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            RemedioRepository.atualizarRemedio(oldNome, nome, date, quantidade, concentracao);
            System.out.println("Remédio atualizado!");
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }

    public static void removerRemedio(Scanner sc) {
        System.out.println("-- REMOVER REMÉDIO --");
        System.out.print("Insira o nome do remédio: ");
        String nome = sc.nextLine();
        if (!RemedioRepository.encontrarPorNome(nome).isEmpty()) {
            RemedioRepository.removerRemedio(nome);
            System.out.println("Remédio removido com sucesso!");
        } else {
            System.out.println("Remédio não encontrado.");
        }
    }

    public static void save(Remedio remedio) {
        RemedioRepository.save(remedio);
    }

    private static LocalDate getDate(Scanner sc) {
        int ano = -1;
        int mes = -1;
        int dia = -1;
        while (ano < Year.now().getValue()) {
            try {
                System.out.print("Digite o ano de vencimento: ");
                ano = sc.nextInt();
                if (ano < Year.now().getValue()) {
                    System.out.println("Por favor, insira um ano válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um ano válido.");
                sc.nextLine();
            }
        }
        while (mes < 1 || mes > 12) {
            try {
                System.out.print("Digite o mês de vencimento (1-12): ");
                mes = sc.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Por favor, insira um mês válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um mês válido.");
                sc.nextLine();
            }
        }
        while (dia < 0 || dia > 31) {
            try {
                System.out.print("Digite o dia de vencimento: ");
                dia = sc.nextInt();
                if (dia < 0 || dia > 31) {
                    System.out.println("Por favor, insira um dia válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um dia válido.");
                sc.nextLine();
            }
        }
        return LocalDate.of(ano, mes, dia);
    }

 */
}
