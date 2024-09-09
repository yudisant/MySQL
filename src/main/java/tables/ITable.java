package tables;

import java.util.List;

public interface ITable {
    void created(List<String>columns);
    void delete();
}
