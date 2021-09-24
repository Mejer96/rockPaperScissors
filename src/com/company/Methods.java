package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Methods {

    public static String gameMode() {
        String userInput = null;
        boolean loop = true;
        String singleplayer = "sp";
        String multiplayer = "mp";
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("Do you want to play singleplayer or multiplayer? Enter 'SP' for singleplayer or 'MP' for multiplayer.");
            System.out.print(">");
            userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (userInput.equals(singleplayer) || userInput.equals(multiplayer)) {
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return userInput;
    }

    public static int numberOfRounds() {
        int numberOfRounds = 0;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount of rounds u would like to have in a game. It cannot be a even number nor be more than nine. Also it cannot be higher lower than three");

        while (loop) {
            try {
            System.out.print(">");
            numberOfRounds = scanner.nextInt(); }
            catch (InputMismatchException e) {
                // handles a situation where the user inputs a string to the scanner.
                System.out.println("Please enter a number. Try again.");
                scanner.nextLine();
                continue;
            }
            if (numberOfRounds % 2 == 0) {
                System.out.println("Invalid value. Please enter an uneven number");
                continue;
            }
            if (3 > numberOfRounds || numberOfRounds > 9) {
                System.out.println("Invalid value. Please enter a number between three and nine.");
                continue;
            }
            loop = false;
        }
        System.out.println(numberOfRounds);
        return numberOfRounds;
    }

    public static String playerName(int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + player + " Please enter your name: ");

        return scanner.nextLine();
    }

    public static String pickHand(String[] array, String player) {
        String userInput = null;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Select your choice, " + player +". 'Rock', 'Paper' or 'Scissor'");
            System.out.print(">");
            userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
            for (int i=0; i < array.length; i++) {
                if (userInput.equals(array[i])) {
                    loop = false;
                    break;
                }
                if (i == array.length-1) {
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
        return userInput;
    }

    public static int compare(String player1, String player2, String[] array, String player1Pick, String player2Pick) {
        // This method decides the winner by comparing strings retrieved from player1pick and player2pick
        int result = 0;
        // Options[] elements:
        // array[0] = rock
        // array[1] = paper
        // array[2] = scissor
        if (player1Pick.equals(array[0])) {
            if (player2Pick.equals(array[1])) {
                System.out.println(player2 + " wins!");
                result = 2;
            } else if (player2Pick.equals(array[2])) {
                System.out.println(player1 + " wins!");
                result = 1;
            } else {
                System.out.println("Its a tie! Try again!");
            }
        }
        if (player1Pick.equals(array[1])) {
            if (player2Pick.equals(array[0])) {
                System.out.println(player1 + " wins!");
                result = 1;
            } else if (player2Pick.equals(array[2])) {
                System.out.println(player2 + " wins!");
                result = 2;
            } else {
                System.out.println("Its a tie. Try again!");
            }
        }
        if (player1Pick.equals(array[2])) {
            if (player2Pick.equals(array[0])) {
                System.out.println(player2 + " wins!");
                result = 2;
            } else if (player2Pick.equals(array[1])) {
                System.out.println(player1 + " wins!");
                result = 1;
            } else {
                System.out.println("Its a tie! Try again!");
            }
        }
        return result;
    }

}
