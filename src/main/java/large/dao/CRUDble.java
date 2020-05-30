package large.dao;

import large.model.Cell;

public interface CRUDble {
    Cell add(Cell cell);

    Cell getCell(Cell cell);

    Cell update(Cell cell);

    //void deleteAll();
}
