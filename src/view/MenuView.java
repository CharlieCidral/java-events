package view;

import java.util.Scanner;

import controller.MenuController;
import controller.AnunController;
import controller.UserController;

public class MenuView {
    private Scanner scanner;
    private UserController userController;
    private AnunController anunController;
    private MenuController menuController;

    public MenuView() {
        this.scanner = new Scanner(System.in);
        this.userController = new UserController();
        this.anunController = new AnunController();
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public int exibirMenuInicial() {
        int opcao;
        System.out.println("Bem-vindo ao Sistema de Eventos!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastrar como Usuário");
        System.out.println("2. Cadastrar como Anunciante");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                cadastrarAnunciante();
                break;
            case 0:
                System.out.println("Até mais!");
                System.exit(0);
        }
        return opcao;
    }

    public void cadastrarUsuario() {
        System.out.println("Cadastro de Novo Usuário");
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.println("Usuário cadastrado com sucesso!");
        userController.cadastrarUsuario(nome, endereco, telefone, email);
        menuController.carregarUserView();
    }

    public void cadastrarAnunciante() {
        System.out.println("Cadastro de Novo Anunciante");
        System.out.print("Nome do anunciante: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.println("Anunciante cadastrado com sucesso!");
        anunController.cadastrarAnunciante(nome, endereco, telefone, email);
        menuController.carregarAnunView();
    }
}
