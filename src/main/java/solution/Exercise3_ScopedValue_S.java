package solution;

import java.util.concurrent.StructuredTaskScope;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class Exercise3_ScopedValue_S {
    private static final ScopedValue<Integer> RANDOM_NUMBER = ScopedValue.newInstance();
    private static final ScopedValue<User> USER = ScopedValue.newInstance();

    public static void main() throws InterruptedException {
        // TASK 1
        IntStream.range(0, 10).forEach(_ -> new Thread(Exercise3_ScopedValue_S::useScopedValue).start());

        // TASK 2
        try (final var scope = new StructuredTaskScope()) {
            IntStream.range(0, 10).forEach(_ ->
                scope.fork(() -> {
                    useScopedValue();
                    return null;
                })
            );
            scope.join();
        }

        // TASK 3
        try (final var scope = new StructuredTaskScope()) {
            IntStream.range(0, 10).forEach(_ ->
                    scope.fork(() -> {
                        useScopedValueWithUser();
                        return null;
                    })
            );
            scope.join();
        }
    }

    private static void useScopedValue() {
        final var randomNumber = RandomGenerator.getDefault().nextInt(1, 101);

        ScopedValue.where(RANDOM_NUMBER, randomNumber)
                .run(() -> System.out.printf("Thread-%s: Random number: %d\n", Thread.currentThread().threadId(), RANDOM_NUMBER.get()));
    }

    private static void useScopedValueWithUser() {
        final var randomNumber = RandomGenerator.getDefault().nextInt(1, 101);
        final var user = new User("Username: " + randomNumber, "Password: " + randomNumber);

        ScopedValue.where(USER, user)
                .run(() -> System.out.printf("Random user: %s\n", USER.get()));
    }

    record User(String username, String password) {}
}

