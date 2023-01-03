import java.util.ArrayList;

public class Operations {

    public static enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUALS, DECIMAL, CLEAR, NONE, NUMBER, NEGATIVE
    }

    /**Keeps Track of Non-Number Operations */
    static Operation lastOperaion = Operation.NONE;
    /**Keeps the last 5 operations performed for refrence*/
    static ArrayList<Operation> previousOperations = new ArrayList<Operation>();

    public static void addOperation(Operation o) {
        if(o != Operation.NUMBER && o != Operation.DECIMAL) {
            lastOperaion = o;
        }
        previousOperations.add(0, o);
        if(previousOperations.size() > 5) {
            previousOperations.remove(5);
        }
        System.out.println(previousOperations);
    }
}