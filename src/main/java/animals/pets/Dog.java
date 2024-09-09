package animals.pets;

import animals.Animals;

public class Dog extends Animals {
    public Dog (String color, String name, int weight, String type, int age) {
        super (color, name, weight, type, age);
    }

    @Override
    public void say () {
        System.out.println("Гав");
    }
}
