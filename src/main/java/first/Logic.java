package first;

import java.util.ArrayList;
import java.util.Arrays;

class Logic {
    private final ArrayList<String> CELLS = new ArrayList<>(
            Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3")
    );
    private ArrayList<String> player = new ArrayList<>();
    private ArrayList<String> AI = new ArrayList<>();

    public ArrayList<String> getCELLS() {
        return CELLS;
    }

    public ArrayList<String> getAI() {
        return AI;
    }

    public ArrayList<String> getPlayer() {
        return player;
    }

    private boolean checkWin(ArrayList arr) {
        return ((arr.contains("A1")
                && arr.contains("A2")
                && arr.contains("A3"))
                || (arr.contains("A1")
                && arr.contains("B1")
                && arr.contains("C1"))
                || (arr.contains("A1")
                && arr.contains("B2")
                && arr.contains("C3"))
                || (arr.contains("B1")
                && arr.contains("B2")
                && arr.contains("B3"))
                || (arr.contains("C1")
                && arr.contains("C2")
                && arr.contains("C3"))
                || (arr.contains("C1")
                && arr.contains("B2")
                && arr.contains("A3"))
                || (arr.contains("A2")
                && arr.contains("B2")
                && arr.contains("C2"))
                || (arr.contains("A3")
                && arr.contains("B3")
                && arr.contains("C3")));
    }

    boolean checkTie() {
        return CELLS.isEmpty();
    }

    boolean checkWinAI() {
        return checkWin(AI);
    }

    boolean checkWinPlayer() {
        return checkWin(player);
    }

    void addAI() {
        int randomCell = (int) (Math.random() * (CELLS.size()));
        AI.add(CELLS.get(randomCell));
        CELLS.remove(randomCell);
        CELLS.trimToSize();
        System.out.println("AI cells " + AI);
    }

    boolean addPlayer(String input){
        if (!CELLS.contains(input)) {
            return false;
        }
        CELLS.remove(input);
        CELLS.trimToSize();
        player.add(input);
        System.out.println("Player cells " + player);
        return true;
    }
}
