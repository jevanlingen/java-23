package solution;

import model.Animal;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

import static model.Animal.*;

// Example from: https://softwaremill.com/stream-gatherers-in-practice-part-2/
public class Exercise7_StreamGatherersOwn_S {
    public static void main(String[] args) {
        final var validSequence = List.of(SHEEP, SHEEP_DOG, WOLF, WOLF);
        System.out.print("Valid animal sequence result: ");
        validSequence.stream()
                .gather(Exercise7_StreamGatherersOwn_S.isValidSequence())
                .forEach(System.out::println);

        final var invalidSequence = List.of(SHEEP_DOG, SHEEP, WOLF, WOLF);
        System.out.print("\nValid animal sequence result: ");
        invalidSequence.stream()
                .gather(Exercise7_StreamGatherersOwn_S.isValidSequence())
                .forEach(System.out::println);
    }

    private static Gatherer<Animal, ?, Boolean> isValidSequence() {
        final var slidePerThree = Gatherers.<Animal>windowSliding(3);
        final var convertToGroup = Gatherers.<List<Animal>, Group>fold(
                () -> null, (_, group) -> Group.of(group));
        final var checkValid = Gatherers.<Group, Boolean>fold(
                () -> true, (result, group) -> result && group.isValid());

        return slidePerThree
                .andThen(convertToGroup)
                .andThen(checkValid);
    }

    record Group(Animal one, Animal two, Animal three) {
        public static Group of(List<Animal> group) {
            return group.size() == 3 ? new Group(group.get(0), group.get(1), group.get(2)) : null;
        }

        public boolean isValid() {
            final var group = List.of(one, two, three);
            return !group.contains(SHEEP) || !group.contains(WOLF) || group.contains(SHEEP_DOG);
        }
    }
}
