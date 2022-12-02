package pl.Marcin.millionaire;

import pl.Marcin.millionaire.game.Menu;

import java.util.Scanner;

public class MillionaireApp {

    public static void main(String[] args) {
        new MillionaireApp().start();
        Menu menu = new Menu();
        menu.menu();

    }

    private void start() {
        System.out.println("***************");
        System.out.println("WELCOME\n");
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("\n***************");
        System.out.println("Hi " + name + " :)");
    }

}
