package tables;

import db.DBConnect;
import db.MySQLConnect;

import java.util.List;

public abstract class AbsTable implements ITable {
    protected DBConnect dbConnect = null;
    protected String tableName = "";

    public AbsTable(String tableName) {
        dbConnect = new MySQLConnect();
        this.tableName = tableName;
    }

    @Override
    public void created (List<String>columns) {
        delete();
        dbConnect.execute(String.format("CREATE TABLE %s (%s);", tableName, String.join(",", columns)));
    }

    @Override
    public void delete() {
        dbConnect.execute(String.format("drop table if exists %s;", tableName));
    }
}
