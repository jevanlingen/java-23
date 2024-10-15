import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Task 1: Use a module import

public class Exercise9_SimplifiedModuleImports {
    public static void main() throws IOException, URISyntaxException {
        final var grouped = Stream.of("apple", "banana", "cherry")
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
        System.out.println(grouped);
    }
}
