package org.farmacia.services;

import org.farmacia.entities.*;
import org.farmacia.repositories.RemedioRepository;
import org.farmacia.repositories.SubstanciaRepository;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class
RemedioService {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");



//CADASTRO -> Cadastrar Remedio ____________________________________________________
public static void cadastrarRemedio(Scanner sc) {
    int quantidade = -1;
    float concentracao = -1;
    float preco = -1;
    System.out.println("-- CADASTRAR NOVO REMÉDIO --");
    ArrayList<Substancia> sub = new ArrayList<>();
    while (true) {
        try {
            SubstanciaService.listarSubstancias();
            System.out.print("Digite o nome da substância do remédio: ");
            String subName = sc.nextLine();
            ArrayList<Substancia> substancia = SubstanciaRepository.encontrarPorNome(subName);
            if (substancia != null) {
                sub.add(substancia.get(0));
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
    LocalDate date = null;
    while (date == null) {
        try {
            System.out.println("Digite a data de validade do remédio (formato YYYY-MM-DD):");
            date = LocalDate.parse(sc.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("Por favor, insira uma data válida.");
        }
    }
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
    while (preco < 0) {
        try {
            System.out.print("Digite o preço do remédio: ");
            preco = sc.nextFloat();
            if (preco < 0) {
                System.out.println("Por favor, insira um preço válido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um preço válido.");
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
    System.out.print("Digite o modo de uso do remédio: ");
    String modo_de_uso = sc.nextLine();
    while (modo_de_uso.trim().isEmpty()) {
        System.out.println("O modo de uso não pode estar vazio. Por favor, tente novamente.");
        System.out.print("Digite o modo de uso do remédio: ");
        modo_de_uso = sc.nextLine();
    }

    System.out.print("Qual é a dosagem recomendada dele? ");
    String dosagem = sc.nextLine();
    while (dosagem.trim().isEmpty()) {
        System.out.println("A dosagem não pode estar vazia. Por favor, tente novamente.");
        System.out.print("Qual é a dosagem recomendada dele? ");
        dosagem = sc.nextLine();
    }

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
    Remedio remedio = null;
    if (res == 1) {
        remedio = new Oral(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
    } else if (res == 2) {
        remedio = new Topico(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
    } else if (res == 3) {
        remedio = new Injetavel(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
    }
    RemedioRepository.save(remedio);
    System.out.println("Remédio cadastrado!");
}

//_____________________________________________________________________________________________________________

//CADASTRO -> Alterar Remedio _________________________________________________________________________________
public static void atualizarRemedio(Scanner sc) {
    int quantidade = -1;
    float concentracao = -1;
    float preco = -1;

    System.out.println("-- ATUALIZAR REMÉDIO --");
    System.out.print("Insira o nome do remédio a ser atualizado: ");
    String oldNome = sc.nextLine();

    if (!RemedioRepository.encontrarPorNome(oldNome).isEmpty()) {
        RemedioService.buscarRemedioPorNome2(oldNome);
        System.out.println("Você realmente quer atualizar o remédio " + oldNome + "? (S/N)");
        String confirmacao = sc.nextLine();
        if(!confirmacao.equalsIgnoreCase("s")){
            return;
        }

        ArrayList<Substancia> sub = new ArrayList<>();
        while (true) {
            try {
                SubstanciaService.listarSubstancias();
                System.out.print("Digite o nome da substância do remédio: ");
                String subName = sc.nextLine();
                ArrayList<Substancia> substancia = SubstanciaRepository.encontrarPorNome(subName);
                if (substancia != null) {
                    sub.add(substancia.get(0));
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

        System.out.println("Agora insira as informações atualizadas se desejar mudá-las.");
        System.out.print("Digite o nome do remédio ou pressione Enter para manter o mesmo: ");
        String nome = sc.nextLine();
        if (nome.isEmpty()) {
            nome = oldNome;
        }

        System.out.println("Digite a data de validade do remédio (formato YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(sc.nextLine());

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

        while (preco < 0) {
            try {
                System.out.print("Digite o preço do remédio: ");
                preco = sc.nextFloat();
                if (preco < 0) {
                    System.out.println("Por favor, insira um preço válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um preço válido.");
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

        System.out.print("Digite o modo de uso do remédio: ");
        String modo_de_uso = sc.nextLine();
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

        Remedio remedio = null;
        if (res == 1) {
            remedio = new Oral(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
        } else if (res == 2) {
            remedio = new Topico(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
        } else if (res == 3) {
            remedio = new Injetavel(nome, date, preco, quantidade, concentracao, sub.get(0), modo_de_uso, dosagem);
        }

        RemedioRepository.atualizarRemedio(oldNome, remedio);
        System.out.println("Remédio atualizado!");
    } else {
        System.out.println("Remédio não encontrado.");
    }
}


//_____________________________________________________________________________________________________________

//CADASTRO -> Remover Remedio _________________________________________________________________________________
    public static void removerRemedio() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o nome do remédio a ser removido :  ");
            String nome = scanner.nextLine();
            ArrayList<Remedio> remediosPesquisados = RemedioRepository.encontrarPorNome(nome);
            System.out.println("Remédio encontrado: " + remediosPesquisados.get(0));
            if (!remediosPesquisados.isEmpty()) {
                System.out.println("Você realmente deseja remover o remédio? digite 1 para sim, 2 para não.");
                System.out.print("[1] - Sim   |   [2] - Não  : ");
                int confirmacao = scanner.nextInt();
                switch (confirmacao) {
                    case 1:
                        System.out.println("Por favor, insira a senha de administrador para continuar:");
                        String senha = scanner.next();
                        if (senha.equals("senhaDoAdministrador")) {
                            RemedioRepository.removerRemedio(nome);
                            System.out.println("Remédio removido com sucesso!");
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
                System.out.println("Remédio não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Ação cancelada.");
        }
    }

//_____________________________________________________________________________________________________________

//BARRA DE PESQUISA -> Achar o remedio com o nome digitado ____________________________________________________
public static void buscarRemedioPorNome(Scanner sc) {
    System.out.print("Procurar pelo nome: ");
    String nome = sc.nextLine();
    ArrayList<Remedio> remedios = RemedioRepository.encontrarPorNome(nome);
    if (!remedios.isEmpty()) {
        System.out.println("Remédios com o nome " + nome + " ");
        System.out.println("_".repeat(72));
        System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
        System.out.println("_".repeat(72));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(72));
    } else {
        System.out.println("Remédio(s) não encontrado(s).");
    }
}
    public static void buscarRemedioPorNome2(String sc) {
        String nome = sc;
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorNome(nome);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com o nome " + nome + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
            System.out.println("_".repeat(72));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédio(s) não encontrado(s).");
        }
    }

    public static void notafiscal(String med) {
        String nome = med;
        ArrayList<Remedio> remedios = RemedioRepository.encontrarPorNome(nome);
        if (!remedios.isEmpty()) {
            System.out.println("Remédios com o nome " + nome + " ");
            System.out.println("_".repeat(72));
            System.out.printf("%-20s | %-10s | ", "Nome", "Preço");
            System.out.println("_".repeat(72));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s |", remedio.getNome_remedio(),  remedio.getPreco());
            }
            System.out.println("_".repeat(72));
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
        System.out.println("_".repeat(72));
        System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
        System.out.println("_".repeat(72));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(72));
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
        System.out.println("_".repeat(72));
        System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
        System.out.println("_".repeat(72));
        for (Remedio remedio : remedios) {
            System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
        }
        System.out.println("_".repeat(72));
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
            System.out.println("_".repeat(72));
            System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
            System.out.println("_".repeat(72));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
            }
            System.out.println("_".repeat(72));
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
            System.out.println("_".repeat(72));
            System.out.printf("%-20s | %-10s | %-10s | %-10s | %-10s%n", "Nome", "Substância", "Vencimento", "Preço", "Em Estoque");
            System.out.println("_".repeat(72));
            for (Remedio remedio : remedios) {
                System.out.printf("%-20s | %-10s | %-10s | %-10.2f | %-10d%n", remedio.getNome_remedio(), remedio.getSubstancia().getNome_substancia(), remedio.getData_vencimento().format(formatter), remedio.getPreco(), remedio.getQuantidade_estoque());
            }
            System.out.println("_".repeat(72));
        } else {
            System.out.println("Remédio(s) não encontrado(s).");
        }
    }
//_____________________________________________________________________________________________________________
public static int estoque() {
    List<Remedio> remedios = RemedioRepository.encontrarTodosRemedios();
    int total = 0;
    for (Remedio remedio : remedios) {
        total += remedio.getQuantidade_estoque();
        System.out.println( "Nome do remedio: " + remedio.getNome_remedio() );
        System.out.println(" Quantidade em estoque: " + remedio.getQuantidade_estoque() );
        System.out.println(" ----------------------");
        System.out.println(" ");
    }
    System.out.println("No estoque tem: " + total);
    return total;
}

}
