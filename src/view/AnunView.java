package view;

import model.Evento;
import controller.AnunController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class AnunView {
    private Scanner scanner;

    public AnunView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuAnunciante(AnunController anunController) {
        int opcao;
        do {
            System.out.println("1. Cadastrar Eventos");
            System.out.println("2. Ver meus eventos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarNovoEvento(anunController);
                    break;
                case 2:
                    exibirEventosPorAnunciante(anunController);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public void cadastrarNovoEvento(AnunController anunController) {
        System.out.println("Cadastro de Novo Evento");
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Data e hora (YYYY-MM-DD HH:MM): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime horario = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        anunController.cadastrarEvento(nome, endereco, categoria, horario, descricao, telefone, email);
        System.out.println("Evento cadastrado com sucesso!");
    }

    public void exibirEventosPorAnunciante(AnunController anunController) {
        System.out.println("Eventos Cadastrados:");
        List<Evento> eventos = anunController.consultarEventosCriados();
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
        // Exibir o submenu
        System.out.println("1. Excluir evento");
        System.out.println("2. Exibir Inscritos nos meus Eventos");
        System.out.println("0. Voltar");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do evento que você deseja excluir:");
                String nomeEvento = scanner.next();
                anunController.excluirEvento(nomeEvento);
                break;
            case 2:
                anunController.exibirInscritosEventos();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }
}
