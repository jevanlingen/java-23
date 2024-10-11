import java.util.List;

// TASk 1: Replace with unnamed pattern
// TASk 2 (Bonus): Improve `.get(0)` call
public class Exercise2_UnnamedVariablesPatterns {
    public static void main(){
        final var house = new House(List.of(new Chamber.LivingRoom(true, false), new Chamber.Kitchen( false, false), new Chamber.Bathroom( true, true)));

        final var whatIsChamberOne = switch (house.chambers.get(0)) {
            case Chamber.LivingRoom(boolean furnitured, boolean tv) -> "It's a living room";
            case Chamber.Kitchen kitchen -> "It's the kitchen";
            case Chamber.Bathroom(boolean furnitured, boolean diningTable) -> "It's a bathroom";
        };

        System.out.println(whatIsChamberOne);

        try {
            int number = Integer.parseInt("string");
        } catch (final NumberFormatException exception) {
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
