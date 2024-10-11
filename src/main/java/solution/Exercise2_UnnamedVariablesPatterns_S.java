package solution;

import java.util.List;

public class Exercise2_UnnamedVariablesPatterns_S {
    public static void main(){
        final var house = new House(List.of(new Chamber.LivingRoom(true, false), new Chamber.Kitchen( false, false), new Chamber.Bathroom( true, true)));

        final var whatIsChamberOne = switch (house.chambers.getFirst()) {
            case Chamber.LivingRoom(_, boolean _) -> "It's a living room";
            case Chamber.Kitchen _ -> "It's the kitchen";
            case Chamber.Bathroom(boolean _, boolean _) -> "It's a bathroom";
        };

        System.out.println(whatIsChamberOne);

        try {
            int number = Integer.parseInt("string");
        } catch (final NumberFormatException _) {
            System.err.println("Not a number");
        }
    }

    record House(List<Chamber> chambers) {}

    sealed interface Chamber {
        record LivingRoom(boolean furnitured, boolean tv) implements Chamber {}
        record Kitchen(boolean furnitured, boolean diningTable) implements Chamber {}
        record Bathroom(boolean bathtub, boolean shower) implements Chamber {}
    }
}
