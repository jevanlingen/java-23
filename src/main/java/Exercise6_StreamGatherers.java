import model.Animal;

import java.util.ArrayList;
import java.util.List;

// TASK 1: Remove the `splitIntoFixedWindows` function and use `Gatherers.windowFixed`

// TASK 2: Remove the `countAnimals` function and use `Gatherers.fold`
// hint: consider `fold` as a `reduce` on steroids
// hint: your new code will not be much cleaner, but it's just for comprehension

public class Exercise6_StreamGatherers {
    public static void main(){
        final var words = List.of("Sheep", "Sheep Dog", "Wolf", "Table", "Chair", "Stool", "Sea", "Land");

        final var groupedByType = splitIntoFixedWindows(words, 3);

        final var amountOfAnimals = countAnimals(words);

        System.out.println(groupedByType);
        System.out.println(amountOfAnimals);
    }

    public static List<List<String>> splitIntoFixedWindows(List<String> list, int windowSize) {
        List<List<String>> windows = new ArrayList<>();
        for (int i = 0; i < list.size(); i += windowSize) {
            windows.add(list.subList(i, Math.min(i + windowSize, list.size())));
        }
        return windows;
    }

    public static long countAnimals(List<String> items) {
        return items.stream()
                .filter(Animal::match)
                .count();
    }
}
