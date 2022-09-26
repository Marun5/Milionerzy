package pl.Marcin.Milionerzy.game;


import java.util.Scanner;

public class Menu {
    private final Game game = new Game();
    private final Admin admin = new Admin();

    public void menu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n*!* MENU *!*");
            System.out.println("a) PLAY");
            System.out.println("b) ADMIN");
            System.out.println("c) EXIT");
            System.out.println("\nChoose option:");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    game.game();
                    break;

                case 'b':
                    admin.userInput();
                    break;

                case 'c':
                    System.out.println("See you soon!");
                    break;

                default:
                    System.out.println("Choose the correct option");
                    break;
            }
        } while (option != 'c');

    }


}
