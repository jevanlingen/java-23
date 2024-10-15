import model.Animal;

import java.util.List;
import java.util.stream.Gatherer;

import static model.Animal.*;

// TASK 1: Implement the gatherer.

// Hint: the crucial requirement of this task is to avoid any consecutive triple of animals,
// where a wolf and a sheep are present without the protective presence of a sheepdop (the sheep will be eaten),
// thus use the Group record to your advantage.

// Hint2: you don't have to implement your gatherer from scratch, you could opt for a combination of existing gatherers.

public class Exercise7_OwnStreamGatherers {
    public static void main(String[] args) {
        final var validSequence = List.of(SHEEP, SHEEP_DOG, WOLF, WOLF);
        System.out.print("Valid animal sequence result: "); // should be `true`
        validSequence.stream()
                .gather(Exercise7_OwnStreamGatherers.isValidSequence())
                .forEach(System.out::println);

        final var invalidSequence = List.of(SHEEP_DOG, SHEEP, WOLF, WOLF);
        System.out.print("\nValid animal sequence result: "); // should be `false`
        invalidSequence.stream()
                .gather(Exercise7_OwnStreamGatherers.isValidSequence())
                .forEach(System.out::println);
    }

    private static Gatherer<Animal, ?, Boolean> isValidSequence() {
        return null;
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
