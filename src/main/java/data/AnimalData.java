package data;

public enum AnimalData {
    CAT("кошка"),
    DOG("собака"),
    DUCK("утка");

    private String name;
    AnimalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
