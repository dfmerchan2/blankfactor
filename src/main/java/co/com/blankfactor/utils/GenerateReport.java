package co.com.blankfactor.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class GenerateReport {

    private static final Logger logger = Logger.getLogger(GenerateReport.class.getName());
    private static final Map<Integer, Integer> sizes = new LinkedHashMap<>();

    public static String ofBlogs(Map<Integer, List<String>> data) {
        List<String> fields = new ArrayList<>();
        List<String> registers = new ArrayList<>();
        getSize(data);
        data.forEach(
                (key, value) -> {
                    IntStream.range(0, value.size())
                            .forEach(
                                    i -> fields.add(addBlanks(sizes.get(i), value.get(i))));
                    registers.add("| " + String.join(" | ", fields) + " | \n");
                    fields.clear();
                }
        );
        String result = String.join("", registers);
        logger.log(Level.INFO, "Blog Registration \n{0}", result);
        return result;
    }

    private static void getSize(Map<Integer, List<String>> data) {
        sizes.put(0, 0);
        sizes.put(1, 0);
        data.forEach(
                (key, value) ->
                        IntStream.range(0, value.size())
                                .forEach(
                                        i -> isGreater(i, value.get(i).length()))
        );
    }

    private static void isGreater(Integer position, Integer size) {
        if (sizes.get(position) < size) {
            sizes.put(position, size);
        }
    }

    private static String addBlanks(int size, String value) {
        return String.format("%-" + size + "s", value);
    }

    private GenerateReport() {
    }
}
