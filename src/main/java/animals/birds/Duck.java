package animals.birds;

import animals.Animals;

public class Duck extends Animals implements Flying {
    public Duck(String color, String name, int weight, String type, int age) {
        super(color, name, weight, type, age);
    }

    public Duck(int id, String color, String name, int weight, String type, int age) {
        super(id, color, name, weight, type , age);
    }

    @Override
    public void say () {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}
