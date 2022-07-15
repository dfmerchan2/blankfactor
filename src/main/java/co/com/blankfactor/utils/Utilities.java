package co.com.blankfactor.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public static String getDriver() {
        String[] drivers = {"chrome", "edge", "firefox"};
        int i = (int) (Math.random() * drivers.length);
        return drivers[i];
    }

    public static String getValuePage(String value, int position) {
        List<String> result = Arrays.stream(value.replace("(", "").replace(")", "").replace("-"," ").split(" ")).collect(Collectors.toList());
        return result.get(position);
    }

    private Utilities() {
    }
}
