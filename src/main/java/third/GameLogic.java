package third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameLogic {
    boolean playersTurn = true;

    Field field = new Field(9);

    public void startGame() {
        while (true) {
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
            if (checkWin(CellsValues.X.toString()).equals("player")) {
                field.playerWins();
                break;
            } else if (checkWin(CellsValues.O.toString()).equals("AI")) {
                field.AIWins();
                break;
            }
        }
    }

    private String checkWin(String cell) {
        if ((field.getCell(0).contains(cell)
                && field.getCell(1).contains(cell)
                && field.getCell(2).contains(cell))
                || (field.getCell(0).contains(cell)
                && field.getCell(3).contains(cell)
                && field.getCell(6).contains(cell))
                || (field.getCell(0).contains(cell)
                && field.getCell(4).contains(cell)
                && field.getCell(8).contains(cell))
                || (field.getCell(3).contains(cell)
                && field.getCell(4).contains(cell)
                && field.getCell(5).contains(cell))
                || (field.getCell(6).contains(cell)
                && field.getCell(7).contains(cell)
                && field.getCell(8).contains(cell))
                || (field.getCell(6).contains(cell)
                && field.getCell(4).contains(cell)
                && field.getCell(2).contains(cell))
                || (field.getCell(1).contains(cell)
                && field.getCell(4).contains(cell)
                && field.getCell(7).contains(cell))
                || (field.getCell(2).contains(cell)
                && field.getCell(5).contains(cell)
                && field.getCell(8).contains(cell))) {
            return (cell.equals(CellsValues.X.toString())) ? "player" : "AI";
        }
        return "";
    }

    private boolean addPlayer(String input){
        if (Arrays.asList(field.getCells()).contains(input)
                && input.matches("[0-8]")) {
            field.setCell(CellsValues.X.toString(), Integer.parseInt(input));
            return true;
        }
        return false;
    }

    private void addAI() {
        int randomCell = -1;
        while (!Arrays.asList(field.getCells()).contains(String.valueOf(randomCell))) {
            randomCell = (int) (Math.random() * (field.getCells().length));
        }
        field.setCell(CellsValues.O.toString(), randomCell);
    }

    /*
    private void updateFieldState() {
        for (int i = 0; i < field.getCells().length; i++) {
            for (int j = 0; j < AI.size(); j++) {
                if (field.getCells().get(i).equals(AI.get(j))) {
                    field.getCellsValue()[i] = field.getX();
                }
            }
            for (int j = 0; j < player.size(); j++) {
                if (field.getCells().get(i).equals(player.get(j))) {
                    field.getCellsValue()[i] = field.getO();
                }
            }
        }
    }

     */



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
        return !Arrays.asList(field.getCells()).stream()
                .anyMatch(x -> x.matches("[0-8]"));
    }

}
