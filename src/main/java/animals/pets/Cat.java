package animals.pets;

import animals.Animals;

public class Cat extends Animals {
    public Cat (String color, String name, int weight, String type, int age) {
        super (color, name, weight, type, age);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
