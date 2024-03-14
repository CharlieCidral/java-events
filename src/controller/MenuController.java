package controller;

import view.MenuView;
import view.AnunView;
import view.UserView;
import controller.AnunController;

public class MenuController {
    private AnunView anunView;
    private UserView userView;
    private MenuView menuView;
    private AnunController anunController;
    private UserController userController;
    private EventoController eventoController;

    public MenuController(AnunView anunView, UserView userView, MenuView menuView) {
        this.anunView = anunView;
        this.userView = userView;
        this.menuView = menuView;
        this.anunController = new AnunController();
        this.userController = new UserController();
        this.eventoController = new EventoController();
    }

    public void loadMenuView() {
        menuView.exibirMenuInicial();
    }

    public void carregarUserView() {
        userView.exibirMenuUsuario(userController, eventoController);
    }

    public void carregarAnunView() {
        anunView.exibirMenuAnunciante(anunController);
    }
}
