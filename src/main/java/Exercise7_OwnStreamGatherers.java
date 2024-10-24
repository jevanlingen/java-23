import java.util.stream.Stream;

// TASK 1: Implement a gatherer to grab everything until an Integer lower than 10 is encountered.

public class Exercise7_OwnStreamGatherers {
    public static void main(String[] args) {
        final var list = Stream.of(22,11,4,9,100)
                //.gather()
                .toList();
        System.out.println(list + "\n");
    }

    // hint: complete
    //static class GrabUntilLowerThanTen_S implements Gatherer
}
