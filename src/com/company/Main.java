package com.company;

public class Main {

    public static void main(String[] args) {

        int counter = 1;
        int player1Score = 0;
        int player2Score = 0;
        String player1;
        String player2 = "Opponent";

        String[] options = {"rock", "paper", "scissor"};
        String gameMode = Methods.gameMode();
        int numberOfRounds = Methods.numberOfRounds();


        if (gameMode.equals("mp")) {
            // Gamemode for pvp
            player1 = Methods.playerName(1);
            player2 = Methods.playerName(2);

            while (counter <= numberOfRounds) {

                String player1Pick = Methods.pickHand(options, player1);
                String player2Pick = Methods.pickHand(options, player2);
                int result = Methods.compare(player1, player2, options, player1Pick, player2Pick);
                // 1 = player 1 win
                // 2 = player 2 win
                // 0 = draw. Loop continues to next loop without incrementing counter if the result is 0.
                if (result == 1) {
                    player1Score += 1;
                    counter += 1;
                    System.out.println("The score is: " + player1Score + "-" + player2Score);
                }
                if (result == 2) {
                    player2Score+= 1;
                    counter += 1;
                    System.out.println("The score is: " + player1Score + "-" + player2Score);
                }
                if (player1Score > player2Score) {
                    // Handles situations where its mathematically impossible for player2 to win the game
                    int deltaScore1 = player1Score - player2Score;
                    int remainingRounds = numberOfRounds - counter;
                    if (deltaScore1 > remainingRounds) {
                        System.out.println(player1 + " wins the game!");
                        System.out.println("With the score: " + player1Score + "-" + player2Score);
                        break;
                    }
                }
                if (player2Score > player1Score) {
                    // Handles situations where its mathematically impossible for player1 to win the game
                    int deltaScore2 = player2Score - player1Score;
                    int remainingRounds = numberOfRounds - counter;
                    if (deltaScore2 > remainingRounds) {
                        System.out.println(player2 + " wins the game!");
                        System.out.println("With the score: " + player1Score + "-" + player2Score);
                        break;
                    }
                }
            }
        } else {
            // Gamemode for singleplayer against the computer
            player1 = Methods.playerName(1);

            while (counter <= numberOfRounds) {

                String player1Pick = Methods.pickHand(options, player1);
                String computerPick = MethodsComputerGenerated.generatePick(options);

                int result = Methods.compare(player1, player2, options, player1Pick, computerPick);

                if (result == 1) {
                    player1Score += 1;
                    counter += 1;
                    System.out.println(player2 + " went with " + computerPick);
                    System.out.println("The score is: " + player1Score + "-" + player2Score);
                }
                if (result == 2) {
                    player2Score+= 1;
                    counter += 1;
                    System.out.println(player2 + " went with " + computerPick);
                    System.out.println("The score is: " + player1Score + "-" + player2Score);
                }
                if (player1Score > player2Score) {
                    // Handles situations where its mathematically impossible for player2 to win the game
                    int deltaScore1 = player1Score - player2Score;
                    int remainingRounds = numberOfRounds - counter;
                    if (deltaScore1 > remainingRounds) {
                        System.out.println(player1 + " wins the game!");
                        System.out.println("With the score: " + player1Score + "-" + player2Score);
                        break;
                    }
                }
                if (player2Score > player1Score) {
                    // Handles situations where its mathematically impossible for player1 to win the game
                    int deltaScore2 = player2Score - player1Score;
                    int remainingRounds = numberOfRounds - counter;
                    if (deltaScore2 > remainingRounds) {
                        System.out.println(player2 + " wins the game!");
                        System.out.println("With the score: " + player1Score + "-" + player2Score);
                        break;
                    }
                }

            }
        }
    }
}
