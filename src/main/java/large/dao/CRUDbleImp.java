package large.dao;

import large.db.Storage;
import large.model.Cell;

public class CRUDbleImp implements CRUDble {
    @Override
    public Cell add(Cell cell) {
        if (Storage.CELL_LIST.stream()
                .anyMatch(i -> i.equals(cell))) return null;
        Storage.CELL_LIST.add(cell);
        return cell;
    }

    @Override
    public Cell getCell(Cell cell) {
        return null;
    }

    @Override
    public Cell update(Cell cell) {
        return cell;
    }

}
