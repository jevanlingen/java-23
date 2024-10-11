// TASK 1: Convert into implicitly declared class

import java.util.stream.IntStream;

public class Exercise1_ImplicitDeclaredClass {
    public static String HELLO_WORLD = "Hello World";

    public static void main(String[] args) {
        // TASK 2: Try to use a method reference
        IntStream.range(0, 10).forEach(i -> printHelloWorld(i));
    }

    private static void printHelloWorld(int i) {
        System.out.println(HELLO_WORLD + ": " + i);
    }
}
