package co.com.blankfactor.utils;

public enum PlatformUrl {
    BLANK_FACTOR("https://blankfactor.com/");

    private final String url;

    PlatformUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
