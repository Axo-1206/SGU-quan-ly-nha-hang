package controllers;

import contracts.ManagerHandler;
import utils.*;

public class TableManager implements ManagerHandler {
    private static TableManager self;
    private Displayer displayer = Displayer.getDisplayer();
    //private UserInputHandler inputHandler = UserInputHandler.getUserInputHandler();

    @Override
    public void showGeneralInfo() {
        String[] message = {
            "Day la trinh quan ly ban an sieu nhanh, con khach an co nhanh ko thi deo biet",
            "Trinh quan ly gom cac tinh nang nhu:",
            "1. Kiem tra xem ban nao trong, ban nao da duoc dat",
            "2. add/remove nhom khach hang vao tung ban",
            "Va dat biet la Menu cua chung ta duoc lam boi sieu dau bep ratatouille va And Cong Nhan(ACN)"
        };
        displayer.displayMessage(message);
    }

    @Override
    public void createReport() {
        System.out.println("Ban 1, 2, 3 con trong, Ban 4 thi bi con nho chubby an me roi");
    }
    
        // Private constructor to enforce singleton
    private TableManager() {

    }

    // Public method to get the single self
    public static TableManager getManager() {
        if (self == null) {
            self = new TableManager();
        }
        return self;
    }
}
