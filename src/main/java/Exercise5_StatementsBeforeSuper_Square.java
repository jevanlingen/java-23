import model.Rectangle;

// TASK 1: replace the bloated code with one constructor
// hint: first do the validation, then call super

// N.B. This class is supposed to be called `Square`, but to keep inline with the other exercises, it has the
// `Exercise5_StatementsBeforeSuper_` prefix.
public class Exercise5_StatementsBeforeSuper_Square extends Rectangle {
    public Exercise5_StatementsBeforeSuper_Square(int area) {
        this(Math.sqrt(validateArea(area)));
    }

    private static double validateArea(int area) {
        if (area < 0) throw new IllegalArgumentException();
        return area;
    }

    private Exercise5_StatementsBeforeSuper_Square(double sideLength) {
        super(sideLength, sideLength);
    }
}
