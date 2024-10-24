package solution;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

// Example from: https://softwaremill.com/stream-gatherers-in-practice-part-2/
public class Exercise7_StreamGatherersOwn_S {
    public static void main(String[] args) {
        final var list = Stream.of(22, 11, 4, 9, 100)
                .gather(new GrabUntilLowerThanTen_S())
                .toList();
        System.out.println(list);
     }

     static class GrabUntilLowerThanTen_S implements Gatherer<Integer, List<Integer>, Integer> {

         @Override
         public Integrator<List<Integer>, Integer, Integer> integrator() {
             return Integrator.of((state, element, downstream) -> {
                 if (element > 10) {
                     return downstream.push(element);
                 }
                 return false; // take next element
             });
         }
     }
}
