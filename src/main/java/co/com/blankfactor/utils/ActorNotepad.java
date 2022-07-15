package co.com.blankfactor.utils;

public enum ActorNotepad {
    AUTHOR("Author"),
    DATE("Date"),
    TITLE("Title"),
    ROLE("Role"),
    LINK("Link"),
    NUMBER_PAGE_FINAL("Number Page Final");


    private final String key;

    ActorNotepad(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
