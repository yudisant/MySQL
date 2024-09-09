package tables;

import animals.Animals;

public class AnimalsTable extends AbsTable{
    private static  final String NAME = "animals";

    public AnimalsTable() {
        super(NAME);
    }

    public void write (Animals animals) {
        dbConnect.execute(String.format("INSERT INTO %s (id,color,name,weight,type,age)" +
                "VALUES('%s','%s','%s','%s','%s','%s')",
                NAME, animals.getId(), animals.getColor(), animals.getName(), animals.getWeight(), animals.getType(), animals.getAge()));
    }
}
