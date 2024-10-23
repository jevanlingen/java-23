package solution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

import static java.util.concurrent.StructuredTaskScope.Subtask.State.SUCCESS;

/**
 * This class is intended for extra explanation of the `StructuredTaskScope | Strategies` slide
 */
public class ExamleOfStrucuredTaskScopes {
    public static void main(String[] args){
        try (var scope = new StructuredTaskScope()) {
            final var task1 = scope.fork(() -> "BOEM");
            final var task2 = scope.fork(() -> 2);

            try {
                scope.join(); // Wait for ALL subtasks started in task scope to finish

                System.out.println(task1.state());
                System.out.println(task2.state());
            } catch (InterruptedException | IllegalStateException e) {
                System.out.println(e);
            }
        }

        System.out.println("-------");

        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            try (var scope = new StructuredTaskScope.ShutdownOnSuccess()) {
                final var task1 = scope.fork(() -> "BOEM");
                final var task2 = scope.fork(() -> 2);

                try {
                    scope.join(); // Wait for at least ANY subtask in this scope to finish

                    if (task1.state() != SUCCESS || task2.state() != SUCCESS) {
                        System.out.println(task1.state());
                        System.out.println(task2.state());
                        break;
                    }
                } catch (InterruptedException | IllegalStateException e) {
                    System.out.println(e);
                }
            }
        }

        System.out.println("-------");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            final var task1 = scope.fork(() -> {throw new RuntimeException("BOEM"); });
            final var task2 = scope.fork(() -> 2);

            try {
                scope.join(); // Wait for ALL subtasks started in this scope to finish
                scope.throwIfFailed(); // only available for ShutdownOnFailure

                System.out.println(task1.get()); // tries to retrieve data, but task1 is bork...
                System.out.println(task2.get());
            } catch (InterruptedException | IllegalStateException | ExecutionException e) {
                System.out.println(e);
            }
        }
    }
}
