package view;

import controller.UserController;
import controller.EventoController;
import model.Evento;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner scanner;

    public UserView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuUsuario(UserController userController, EventoController eventoController) {
        int opcao;
        do {
            System.out.println("1. Ver próximos eventos");
            System.out.println("2. Exibir eventos Inscritos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    exibirMenuEventos(userController, eventoController);
                    break;
                case 2:
                    exibirEventosInscritos(userController, eventoController);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public void exibirMenuEventos(UserController userController, EventoController eventoController) {
        Scanner scanner = new Scanner(System.in);
        // Exibir a lista de eventos
        List<Evento> eventos = eventoController.getEventos();
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
        // Exibir o submenu
        System.out.println("1. Participar de um evento");
        System.out.println("2. Voltar");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do evento que você deseja participar:");
                String nomeEvento = scanner.next();
                userController.participarEvento(nomeEvento);
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

    public void exibirEventosInscritos(UserController userController, EventoController eventoController) {
        Scanner scanner = new Scanner(System.in);
        // Exibir a lista de eventos inscritos
        List<Evento> eventosInscritos = userController.getEventosInscritos();
        for (Evento evento : eventosInscritos) {
            System.out.println(evento);
        }
        // Exibir o submenu
        System.out.println("1. Cancelar inscrição em um evento");
        System.out.println("2. Voltar");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do evento do qual você deseja cancelar a inscrição:");
                String nomeEvento = scanner.next();
                userController.cancelarParticipacao(nomeEvento);
                break;
            case 2:
                return;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }
}
