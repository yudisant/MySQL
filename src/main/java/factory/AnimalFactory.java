package factory;
import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;

import java.util.Arrays;
import java.util.List;

public class AnimalFactory extends Animals {

    public AnimalFactory(int id, String color, String name, int weight, String type, int age) {
        super(id, color, name, weight, type, age);
    }

    public static Animals createAnimals(String color, String name, int weight, String type, int age) {
        return switch (type) {
            case "CAT" -> new Cat(color, name, weight, type, age);
            case "DOG" -> new Dog(color, name, weight, type, age);
            case "DUCK" -> new Duck(color, name, weight, type, age);
            default -> null;
        };
    }
    public static List <String> animalTypes = Arrays.asList("'CAT'", "'DOG'", "'DUCK'");
}
