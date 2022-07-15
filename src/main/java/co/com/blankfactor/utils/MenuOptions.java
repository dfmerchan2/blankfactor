package co.com.blankfactor.utils;

public enum MenuOptions {
    INSIGHTS("Insights"),
    BLOG("Blog")
    ;

    private final String value;

    MenuOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
