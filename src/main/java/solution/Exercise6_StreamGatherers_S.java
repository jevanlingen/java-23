package solution;

import java.util.List;

import static java.util.stream.Gatherers.fold;
import static java.util.stream.Gatherers.windowFixed;

public class Exercise6_StreamGatherers_S {
    public static void main(String[] args){
        final var words = List.of("Dog", "Snake", "Horse", "Table", "Chair", "Stool", "Sea", "Land");

        final var groupedByType = words.stream()
                .gather(windowFixed(3))
                .toList();

        final var amountOfAnimals = words.stream()
                .gather(fold(() -> 0, (a, b) -> isAnimal(b) ? a + 1 : a))
                .findFirst()
                .orElseThrow();

        System.out.println(groupedByType);
        System.out.println(amountOfAnimals);
    }

    private static boolean isAnimal(final String b) {
        return b.equals("Dog") || b.equals("Snake") || b.equals("Horse");
    }
}
