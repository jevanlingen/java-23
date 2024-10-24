package solution;

import model.Animal;

import java.util.List;

import static java.util.stream.Gatherers.fold;
import static java.util.stream.Gatherers.windowFixed;

public class Exercise6_StreamGatherers_S {
    public static void main(){
        final var words = List.of("Sheep", "Sheep Dog", "Wolf", "Table", "Chair", "Stool", "Sea", "Land");

        final var chunkedByThree = words.stream()
                .gather(windowFixed(3))
                .toList();

        final var amountOfAnimals = words.stream()
                .gather(fold(() -> 0, (accumulator, element) -> Animal.match(element) ? accumulator + 1 : accumulator))
                .findFirst()
                .orElseThrow();

        System.out.println(chunkedByThree);
        System.out.println(amountOfAnimals);
    }
}
