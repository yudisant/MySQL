package factory;
import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;

public class AnimalFactory {

    public static Animals createAnimals(String color, String name, int weight, String type, int age) {
        return switch (type) {
            case "CAT" -> new Cat(color, name, weight, type, age);
            case "DOG" -> new Dog(color, name, weight, type, age);
            case "DUCK" -> new Duck(color, name, weight, type, age);
            default -> null;
        };
    }
}
