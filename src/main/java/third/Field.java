package third;

import java.util.Arrays;

/**
 *  input number
 *  -> validate (0 < 8) && fieldValues[index].isEmpty()
 *  -> checkWinner(this.field)
 *  -> generateAIStep() {Random -> 0<8}
 *  -> checkWinner(this.field)
 */

public class Field {
    private String[] cells;

    public Field(int length) {
        cells = new String[length];
        for (int i = 0; i < length; i++) {
            cells[i] = String.valueOf(i);
        }
    }

    public String[] getCells() {
        return cells;
    }

    public String getCell(int index) {
        return cells[index];
    }

    public void setCell(String cell, int index) {
        cells[index] = cell;
    }



    void viewField() {
        System.out.println(" ___________");
        System.out.println("|           |");
        System.out.printf("| %s   %s   %s |%n", cells[0], cells[1], cells[2]);
        System.out.printf("| %s   %s   %s |%n", cells[3], cells[4], cells[5]);
        System.out.printf("| %s   %s   %s |%n", cells[6], cells[7], cells[8]);
        System.out.println("|___________|");
    }

    public void noWinners() {
        System.out.println("Game over! No winners!");
    }

    public void playersTurn() {
        System.out.println("Your turn!");
    }

    public void incorrect() {
        System.out.println("Incorrect input");
    }

    public void playerWins() {
        System.out.println("=== PLAYER WINS!!! ===");
    }

    public void AIWins() {
        System.out.println("=== AI WINS!!! ===");
    }
}
