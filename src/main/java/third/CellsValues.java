package third;

public enum CellsValues {
    X("X"),
    O("O");

    private final String text;

    CellsValues(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
