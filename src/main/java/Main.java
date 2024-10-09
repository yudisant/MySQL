import factory.AnimalFactory;
import animals.Animals;
import data.AnimalData;
import data.Commands;
import data.ListFilter;
import tables.AnimalsTable;
import utils.ValidateNumber;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ValidateNumber validateNumber = new ValidateNumber();

    public static void main(String[] args) throws SQLException {
        AnimalsTable animalsTable = new AnimalsTable();
        scanner = new Scanner(System.in);
        validateNumber = new ValidateNumber();
        Animals animals;

        List<String> columnsAnimalsTable = new ArrayList<>();
        columnsAnimalsTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalsTable.add("color VARCHAR(20)");
        columnsAnimalsTable.add("name VARCHAR(20)");
        columnsAnimalsTable.add("weight INT");
        columnsAnimalsTable.add("type VARCHAR(20)");
        columnsAnimalsTable.add("age INT");
        animalsTable.created(columnsAnimalsTable);

        while(true) {

            System.out.print("Введите команду: ");
            System.out.println(Arrays.toString(Commands.values()));
            String input = scanner.next().toUpperCase(Locale.ROOT).trim();
            Commands comm = Commands.of(input);

            if(comm == null) {
                System.out.println("Неверно введена команда.");
                continue;
            }

            switch(comm) {
                case ADD:
                    animals = createAnimalWithData();
                    animalsTable.write(animals);
                    animals.say();
                    break;

                case LIST:
                        System.out.print("Выберите тип вывода списка: ");
                        System.out.println(Arrays.toString(ListFilter.values()));
                        input = scanner.next().toUpperCase(Locale.ROOT).trim();
                        ListFilter listFilter = ListFilter.of(input);

                        if(listFilter == null) {
                            System.out.println("Неверная введена команда.");
                            continue;
                        }

                        switch(listFilter) {
                            case ALL:
                                ArrayList<Animals> animalList = animalsTable.read();
                                animalList.forEach(System.out::println);
                                continue;

                            case FILTER:
                                System.out.print("Введите тип животного: ");
                                System.out.println(Arrays.toString(AnimalData.values()));
                                String types = scanner.next().toUpperCase(Locale.ROOT).trim();

                                ArrayList<Animals> animalsArrayList = animalsTable.readFilter(types);
                                if (animalsArrayList.isEmpty()) {
                                    System.out.println("Животные заданного типа не найдены");
                                } else {
                                    animalsArrayList.forEach(System.out::println);
                                }
                                continue;
                        }

                case EXIT:
                    System.out.println("Выход");
                    System.exit(0);

                case UPDATE:
                    System.out.println("Введите id животного: ");
                    int id = scanner.nextInt();

                    Animals animal = createAnimalWithData();
                    animal.setId(id);

                    animalsTable.update(animal);
                    break;
            }
        }
    }

    private static int enterNumberData(String errorMessage, int attempt) {
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

    private static Animals createAnimalWithData() {
        while(true) {
            System.out.print("Введите тип животного: ");
            System.out.println(Arrays.toString(AnimalData.values()));
            String animalType = scanner.next().toUpperCase().trim();

            boolean isAnimalsValid = false;
            for(AnimalData animalData : AnimalData.values()) {
                if(animalData.name().equals(animalType)) {
                    isAnimalsValid = true;
                    break;
                }
            }

            if(!isAnimalsValid) {
                System.out.println("Недопустимый тип животного!");
                continue;
            }

            System.out.println("Введите цвет животного: ");
            String animalColor = scanner.next();

            System.out.println("Введите имя животного: ");
            String animalName = scanner.next();

            System.out.println("Введите вес животного: ");
            int animalWeight = enterNumberData("Неверно введён вес! \nПовторите ввод: ", 5);
            if(animalWeight == -1) {
                System.out.println("Вы потратили все попытки ввода!");
                continue;
            }

            System.out.println("Введите возраст животного: ");
            int animalAge = enterNumberData("Неверно введён возраст! \nПовторите ввод: ", 5);
            if(animalAge == -1) {
                System.out.println("Вы потратили все попытки ввода!");
            }
            return AnimalFactory.createAnimals(animalColor, animalName, animalWeight, animalType, animalAge);
        }
    }
}
