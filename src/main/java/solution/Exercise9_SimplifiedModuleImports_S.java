package solution;

import module java.base;

public class Exercise9_SimplifiedModuleImports_S {
    public static void main() throws IOException, URISyntaxException {
        final var grouped = Stream.of("apple", "banana", "cherry")
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
        System.out.println(grouped);
    }
}
