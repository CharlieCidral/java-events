import controller.MenuController;

import view.AnunView;
import view.UserView;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        AnunView anunView = new AnunView();
        UserView userView = new UserView();
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(anunView, userView, menuView);
        menuView.setMenuController(menuController);
        menuController.loadMenuView();
    }
}
