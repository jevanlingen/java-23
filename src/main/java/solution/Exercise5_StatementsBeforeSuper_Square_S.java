package solution;

import model.Rectangle;

public class Exercise5_StatementsBeforeSuper_Square_S extends Rectangle {
    public Exercise5_StatementsBeforeSuper_Square_S(int area) {
        if (area < 0) throw new IllegalArgumentException();

        final var sideLength = Math.sqrt(area);
        super(sideLength, sideLength);
    }
}
