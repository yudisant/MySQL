package tables;

import animals.Animals;
import db.MySQLConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalsTable extends AbsTable{
    private static  final String NAME = "animals";

    public AnimalsTable() {
        super(NAME);
    }

    public void write(Animals animals) {
        dbConnect.execute(String.format(
                "INSERT INTO %s (id,color,name,weight,type,age)" +
                "VALUES('%s','%s','%s','%s','%s','%s')",
                NAME,
                animals.getId(),
                animals.getColor(),
                animals.getName(),
                animals.getWeight(),
                animals.getType(),
                animals.getAge()
        ));
    }

    public ArrayList<Animals> readFilter(String filter) throws SQLException {
        ArrayList<Animals> animals = new ArrayList<>();
        ResultSet resultSet;

        String predicate = "";
        if(!filter.equals("all")) {
            predicate = "where type = '" + filter;
        }

        dbConnect = new MySQLConnect();
        resultSet = dbConnect.executeQuery(String.format("SELECT * FROM %s %s';", NAME, predicate).trim());
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String color = resultSet.getString("color");
            String name = resultSet.getString("name");
            int weight = resultSet.getInt("weight");
            String type = resultSet.getString("type");
            int age = resultSet.getInt("age");

            Animals animalsReadFilter = new Animals(id, color, name, weight, type, age);
            animals.add(animalsReadFilter);
        }
        return animals;
    }

    public ArrayList<Animals> read() throws SQLException {
        ArrayList<Animals> animal = new ArrayList<>();
        ResultSet resultSet;

        dbConnect = new MySQLConnect();
        resultSet = dbConnect.executeQuery(String.format("SELECT * FROM %s;", NAME));
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            String color = resultSet.getString("color");
            int age = resultSet.getInt("age");
            int weight = resultSet.getInt("weight");

            Animals animalsRead = new Animals(id, color, name, weight, type, age);
            animal.add(animalsRead);
        }
        return animal;
    }

    public void update(Animals animals) {
        dbConnect.execute(String.format(
                "UPDATE %s SET type='%s', name='%s', color='%s', age=%d, weight=%d WHERE id=%d",
                NAME,
                animals.getType(),
                animals.getName(),
                animals.getColor(),
                animals.getAge(),
                animals.getWeight(),
                animals.getId()
        ));
    }
}
