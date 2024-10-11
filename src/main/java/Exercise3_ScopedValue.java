import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class Exercise3_ScopedValue {
    private static final ScopedValue<Integer> RANDOM_NUMBER = ScopedValue.newInstance();

    public static void main() throws InterruptedException {
        // TASK 1 : Create for every item a thread, call `useScopedValue` and start the thread.
        IntStream.range(0, 10);

        // TASk 2 : Use a StructuredTaskScope to use virtual threads instead of platform threads
        // Hint: use scope.fork and scope.join

        // TASK 3: Replace the boring ScopedValue<Integer> with a ScopedValue<User>
        // Hint: create a User record
    }

    private static void useScopedValue() {
        final var randomNumber = RandomGenerator.getDefault().nextInt(1, 101);

        ScopedValue.where(RANDOM_NUMBER, randomNumber)
                .run(() -> System.out.printf("Thread-%s: Random number: %d\n", Thread.currentThread().threadId(), RANDOM_NUMBER.get()));
    }
}

