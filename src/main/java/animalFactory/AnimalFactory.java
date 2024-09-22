package animalFactory;
import animals.Animals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;

public class AnimalFactory {

    private int id;
    private static int age;
    private static int weight;
    static String name;
    static String color;
    static String type;

    public AnimalFactory(String color, String name, int weight, String type, int age) {
        this.id = id;
        this.color =color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public static Animals createAnimals(String color, String name, int weight, String type, int age) {
        return switch (type) {
            case "CAT" -> new Cat(color, name, weight, type, age);
            case "DOG" -> new Dog(color, name, weight, type, age);
            case "DUCK" -> new Duck(color, name, weight, type, age);
            default -> null;
        };
    }
}
