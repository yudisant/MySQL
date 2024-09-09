import animals.Animals;
import data.AnimalData;
import data.Commands;
import tables.AnimalsTable;
import utils.ValidateNumber;

import java.util.*;

public class Main {
    private static Scanner scanner;
    private static ValidateNumber validateNumber;

    private static int enterNumberData (String errorMessage, int attempt) {
        if (attempt == 0) {
            return -1;
        }

        String dataStr = scanner.next();

        while (!validateNumber.isNumber(dataStr)) {
            System.out.println(errorMessage);
            dataStr = scanner.next();
        }
        int number = Integer.parseInt(dataStr);
        if (number > 0) {
            return number;
        }
        System.out.println(errorMessage);
        enterNumberData(errorMessage, --attempt);
        return -1;
    }

    public static void main(String[] args) {
        AnimalsTable animalsTable = new AnimalsTable();
        scanner = new Scanner(System.in);
        validateNumber = new ValidateNumber();
        Animals animals = new Animals();

        List<String>columnsAnimalsTable = new ArrayList<>();
        columnsAnimalsTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalsTable.add("color VARCHAR(20)");
        columnsAnimalsTable.add("name VARCHAR(20)");
        columnsAnimalsTable.add("weight INT");
        columnsAnimalsTable.add("type VARCHAR(20)");
        columnsAnimalsTable.add("age INT");
        animalsTable.created(columnsAnimalsTable);

        while (true) {

            System.out.println("Введите команду: ADD, LIST, EXIT");
            String input = scanner.next().toUpperCase(Locale.ROOT).trim();
            Commands comm = Commands.of(input);

            switch (comm) {
                case ADD:
                    while (true) {
                        System.out.print("Введите тип животного: ");
                        System.out.println(Arrays.toString(AnimalData.values()));
                        String animalType = scanner.next().toUpperCase().trim();

                        boolean isAnimalsValid = false;
                        for (AnimalData animalData : AnimalData.values()) {
                            if (animalData.name().equals(animalType)) {
                                isAnimalsValid = true;
                                break;
                            }
                        }

                        if (!isAnimalsValid) {
                            System.out.println("Недопустимый тип животного!");
                            continue;
                        }

                        System.out.println("Введите цвет животного: ");
                        String animalColor = scanner.next();

                        System.out.println("Введите имя животного: ");
                        String animalName = scanner.next();

                        System.out.println("Введите вес животного: ");
                        int animalWeight = enterNumberData("Неверно введён вес! \nПовторите ввод: ", 5);
                        if (animalWeight == -1) {
                            System.out.println("Вы потратили все попытки ввода!");
                            continue;
                        }

                        System.out.println("Введите возраст животного: ");
                        int animaAge = enterNumberData("Неверно введён возраст! \nПовторите ввод: ", 5);
                        if (animaAge == -1) {
                            System.out.println("Вы потратили все попытки ввода!");
                            continue;
                        }
                        animalsTable.write(new Animals(animalColor, animalName, animalWeight, animalType, animaAge));

                        animals.say();

                        break;
                    }
                case LIST:

                    break;

                case EXIT:
                    System.exit(0);
                    System.out.println("EXIT");

                default:
                    System.out.println("Неверная команда!");

            }
        }
    }
}
