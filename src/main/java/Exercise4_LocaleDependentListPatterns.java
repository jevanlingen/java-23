import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

// TASK 1: Remove the `formatList` method and use the `java.text.ListFormat`
// hint: what about the `getInstance` method?

// TASK 2: Change your locale to German
public class Exercise4_LocaleDependentListPatterns {
    public static void main(String[] args) {
        final var list = List.of("Earth", "Wind", "Fire");
        System.out.println(formatList(list));
    }

    private static String formatList(List<String> list) {
        return list.stream()
                .collect(collectingAndThen(
                        toList(),
                        it -> it.size() == 1
                                ? it.getFirst()
                                : String.join(", ", it.subList(0, it.size() - 1)) + " and " + it.getLast()));
    }
}
