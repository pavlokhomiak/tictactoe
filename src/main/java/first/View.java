package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
    private final String X = "X";
    private final String O = "O";
    private final String EMPTY_CELL = " ";

    Logic logic = new Logic();
    //private List<String> cells = logic.getCELLS();
    private final ArrayList<String> cells = new ArrayList<>(
            Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
    );
    private String[] cellsValue = {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL,
    EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL};

    /*
    private String[] cellsValue = new String[cells.size()];
    private String[] initializeArray() {
        Arrays.setAll(cellsValue, i -> EMPTY_CELL);
        return cellsValue;
    }
    */

    void field() {
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < logic.getAI().size(); j++) {
                if (cells.get(i).equals(logic.getAI().get(j))) {
                    //cells.set(i, X);
                    cellsValue[i] = X;
                }
            }
            for (int j = 0; j < logic.getPlayer().size(); j++) {
                if (cells.get(i).equals(logic.getPlayer().get(j))) {
                    cellsValue[i] = O;
                }
            }
        }

        System.out.println("    1   2   3");
        System.out.printf("A   %s   %s   %s%n", cellsValue[0], cellsValue[1], cellsValue[2]);
        System.out.printf("B   %s   %s   %s%n", cellsValue[3], cellsValue[4], cellsValue[5]);
        System.out.printf("B   %s   %s   %s%n", cellsValue[6], cellsValue[7], cellsValue[8]);

    }

    void box() {

    }
}
