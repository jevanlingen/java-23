package solution;

import java.text.ListFormat;
import java.util.List;
import java.util.Locale;

import static java.text.ListFormat.Style.FULL;
import static java.text.ListFormat.Type.STANDARD;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Exercise4_LocaleDependentListPatterns_S {
    public static void main(String[] args) {
        List<String> list = List.of("Earth", "Wind", "Fire");

        // TASK 1
        System.out.println(ListFormat.getInstance().format(list));

        // TASK 2
        System.out.println(ListFormat.getInstance(Locale.GERMAN, STANDARD, FULL).format(list));
    }
}
