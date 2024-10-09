package animals;

public abstract class Animals {
    private int id;
    private int age, weight;
    private String name, color, type;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Animals(int id, String color, String name, int weight, String type, int age) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public Animals(String color, String name, int weight, String type, int age) {
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    void go() {
        System.out.println("Я иду");
    }

    void eat() {
        System.out.println("Я ем");
    }

    void drink() {
        System.out.println("Я пью");
    }

    @Override
    public String toString() {
        return "Привет! Я " + type + " Меня зовут " + name + ", мне " + age + " " + years() +
                ", я вешу - " + weight + " кг, мой цвет - " + color + " мой id - " + id;
    }

    private String years() {
        int ostatok = age % 10;

        if (age >= 11 || ostatok == 0 || ostatok >= 5) {
            return "лет";
        }

        if (ostatok >=2) {
            return "года";
        }
        return "год";
    }
}
