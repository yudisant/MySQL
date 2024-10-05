package data;

public enum ListFilter {
    ALL,
    FILTER;

    public static ListFilter of(String input) {
        for (ListFilter listFilter : ListFilter.values()) {
            if (listFilter.name().equals(input)) {
                return listFilter;
            }
        }
        return null;
    }
}
