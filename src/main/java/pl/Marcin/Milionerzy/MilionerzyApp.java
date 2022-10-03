package pl.Marcin.Milionerzy;

import pl.Marcin.Milionerzy.game.Menu;

import java.util.Scanner;

public class MilionerzyApp {

    public static void main(String[] args) {
        new MilionerzyApp().start();
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
