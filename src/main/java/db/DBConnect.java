package db;

import java.sql.ResultSet;

public interface DBConnect {
    void execute(String sqlRequest);
    ResultSet executeQuery(String sqlRequest);
}
