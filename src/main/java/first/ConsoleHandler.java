package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHandler {
    public void startGame() {
        boolean playersTurn = true;
        Logic game = new Logic();
        View view = new View();

        while (true) {
            view.field();
            if (game.checkTie()) {
                System.out.println("Game over! No winners!");
            }
            if (playersTurn) {
                System.out.println(game.getCELLS());
                System.out.println("Your move");
                while (!game.addPlayer(input())) {
                    System.out.println("Incorrect input");
                }
                if (game.checkWinPlayer()) {
                    System.out.println("=== PLAYER WINS!!! ===");
                    break;
                } else {
                    playersTurn = false;
                    continue;
                }
            } else {
                game.addAI();
                if (game.checkWinAI()) {
                    System.out.println("=== AI WINS!!! ===");
                    break;
                } else {
                    playersTurn = true;
                    continue;
                }
            }
        }
    }

    private String input() {
        String input = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
