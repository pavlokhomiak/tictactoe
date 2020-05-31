package second;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {
    private final String X = "X";
    private final String O = "O";
    private final String EMPTY_CELL = " ";
    private final ArrayList<String> CELLS = new ArrayList<>(
            Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
    );
    private String[] cellsValue = {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL,
            EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL};


    public ArrayList<String> getCELLS() {
        return CELLS;
    }

    public String[] getCellsValue() {
        return cellsValue;
    }

    public String getX() {
        return X;
    }

    public String getO() {
        return O;
    }

    void viewField() {
        System.out.println("    1   2   3");
        System.out.printf("A   %s   %s   %s%n", cellsValue[0], cellsValue[1], cellsValue[2]);
        System.out.printf("B   %s   %s   %s%n", cellsValue[3], cellsValue[4], cellsValue[5]);
        System.out.printf("C   %s   %s   %s%n", cellsValue[6], cellsValue[7], cellsValue[8]);
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
