package data;

public enum ListFiltr {
    ALL,
    FILTR;

    public static ListFiltr of(String input) {
        for (ListFiltr listFiltr : ListFiltr.values()) {
            if (listFiltr.name().equals(input)) {
                return listFiltr;
            }
        }
        return null;
    }
}
