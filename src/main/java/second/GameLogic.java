package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    boolean playersTurn = true;
    private final ArrayList<String> cellsVariant = new ArrayList<>(
            Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
    );
    private ArrayList<String> player = new ArrayList<>();
    private ArrayList<String> AI = new ArrayList<>();

    Field field = new Field();

    public void startGame() {
        while (true) {
            updateFieldState();
            field.viewField();
            if (checkTie()) {
                field.noWinners();
                break;
            }
            if (playersTurn) {
                field.playersTurn();
                while (!addPlayer(input())) {
                    field.incorrect();
                }
                playersTurn = false;
            } else {
                addAI();
                playersTurn = true;
            }
            if (checkWin()) {
                if (isPlayerWinner()) {
                    field.playerWins();
                } else {
                    field.AIWins();
                }
                break;
            }
        }
    }

    private boolean checkWin() {
        return ((player.contains("A1")
                && player.contains("A2")
                && player.contains("A3"))
                || (player.contains("A1")
                && player.contains("B1")
                && player.contains("C1"))
                || (player.contains("A1")
                && player.contains("B2")
                && player.contains("C3"))
                || (player.contains("B1")
                && player.contains("B2")
                && player.contains("B3"))
                || (player.contains("C1")
                && player.contains("C2")
                && player.contains("C3"))
                || (player.contains("C1")
                && player.contains("B2")
                && player.contains("A3"))
                || (player.contains("A2")
                && player.contains("B2")
                && player.contains("C2"))
                || (player.contains("A3")
                && player.contains("B3")
                && player.contains("C3")))
                ||
                ((AI.contains("A1")
                && AI.contains("A2")
                && AI.contains("A3"))
                || (AI.contains("A1")
                && AI.contains("B1")
                && AI.contains("C1"))
                || (AI.contains("A1")
                && AI.contains("B2")
                && AI.contains("C3"))
                || (AI.contains("B1")
                && AI.contains("B2")
                && AI.contains("B3"))
                || (AI.contains("C1")
                && AI.contains("C2")
                && AI.contains("C3"))
                || (AI.contains("C1")
                && AI.contains("B2")
                && AI.contains("A3"))
                || (AI.contains("A2")
                && AI.contains("B2")
                && AI.contains("C2"))
                || (AI.contains("A3")
                && AI.contains("B3")
                && AI.contains("C3")));
    }

    private boolean isPlayerWinner() {
        return ((player.contains("A1")
                && player.contains("A2")
                && player.contains("A3"))
                || (player.contains("A1")
                && player.contains("B1")
                && player.contains("C1"))
                || (player.contains("A1")
                && player.contains("B2")
                && player.contains("C3"))
                || (player.contains("B1")
                && player.contains("B2")
                && player.contains("B3"))
                || (player.contains("C1")
                && player.contains("C2")
                && player.contains("C3"))
                || (player.contains("C1")
                && player.contains("B2")
                && player.contains("A3"))
                || (player.contains("A2")
                && player.contains("B2")
                && player.contains("C2"))
                || (player.contains("A3")
                && player.contains("B3")
                && player.contains("C3")));
    }

    private boolean addPlayer(String input){
        if (!cellsVariant.contains(input)) {
            return false;
        }
        cellsVariant.remove(input);
        cellsVariant.trimToSize();
        player.add(input);
        return true;
    }

    void addAI() {
        int randomCell = (int) (Math.random() * (cellsVariant.size()));
        AI.add(cellsVariant.get(randomCell));
        cellsVariant.remove(randomCell);
        cellsVariant.trimToSize();
    }

    private void updateFieldState() {
        for (int i = 0; i < field.getCELLS().size(); i++) {
            for (int j = 0; j < AI.size(); j++) {
                if (field.getCELLS().get(i).equals(AI.get(j))) {
                    field.getCellsValue()[i] = field.getX();
                }
            }
            for (int j = 0; j < player.size(); j++) {
                if (field.getCELLS().get(i).equals(player.get(j))) {
                    field.getCellsValue()[i] = field.getO();
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

    private boolean checkTie() {
        return cellsVariant.isEmpty();
    }

}
