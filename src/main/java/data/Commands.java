package data;

public enum Commands {
    ADD,
    LIST,
    EXIT,
    UNKNOW;

    public static Commands of(String input) {
        for (Commands commands : Commands.values()) {
            if (commands.name().equals(input)) {
                return commands;
            }
        }
        return UNKNOW;
    }
}
