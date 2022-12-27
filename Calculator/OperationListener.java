import javax.swing.JButton;
import java.awt.event.*;
import java.util.ArrayList;

public class OperationListener extends Operations implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Clear":
                addOperation(Operation.CLEAR);
                lastOperaion = Operation.CLEAR;
                Screen.shown = "";
                break;
            case "+":
                if (lastOperaion == Operation.ADD) {
                    double[] d = convert();
                    Screen.hidden = Double.toString(d[1] + d[0]);
                    Screen.shown = "";
                } else {
                    addOperation(Operation.ADD);
                    Screen.hidden = Screen.shown;
                    Screen.shown = "";
                }
                break;
            case "-":
                if (lastOperaion == Operation.SUBTRACT) {
                    double[] d = convert();
                    Screen.hidden = Double.toString(d[1] - d[0]);
                    Screen.shown = "";
                } else {
                    addOperation(Operation.SUBTRACT);
                    Screen.hidden = Screen.shown;
                    Screen.shown = "";
                }
                break;
            case "*":
                if (lastOperaion == Operation.MULTIPLY) {
                    double[] d = convert();
                    Screen.hidden = Double.toString(d[1] * d[0]);
                    Screen.shown = "";
                } else {
                    addOperation(Operation.MULTIPLY);
                    Screen.hidden = Screen.shown;
                    Screen.shown = "";
                }
                break;
            case "÷":
                if (lastOperaion == Operation.DIVIDE) {
                    double[] d = convert();
                    Screen.hidden = Double.toString(d[1] / d[0]);
                    Screen.shown = "";
                } else {
                    addOperation(Operation.DIVIDE);
                    Screen.hidden = Screen.shown;
                    Screen.shown = "";
                }
                break;
            case "=":
                if (lastOperaion != Operation.EQUALS) {
                    double[] d = convert();
                    if (lastOperaion == Operation.ADD) {
                        Screen.shown = Double.toString(d[1] + d[0]);
                    } else if (lastOperaion == Operation.SUBTRACT) {
                        Screen.shown = Double.toString(d[1] - d[0]);
                    } else if (lastOperaion == Operation.MULTIPLY) {
                        Screen.shown = Double.toString(d[1] * d[0]);
                    } else if (lastOperaion == Operation.DIVIDE) {
                        Screen.shown = Double.toString(d[1] / d[0]);
                    }
                }
                break;
        }

        chop();
        Screen.updateDisplay();

    }

    /**
     * Listed as Shown, Hidden
     */
    private double[] convert() {
        double[] d = { Double.parseDouble(Screen.shown), Double.parseDouble(Screen.hidden) };
        return d;
    }

    /**
     * 
     */
    private void chop() {
        // if number is too big to fit on the screen and has E for *10^x
        if (Screen.shown.indexOf("E") != -1) {
            String beforeE = Screen.shown.indexOf("E") < 6 ? Screen.shown.substring(0, Screen.shown.indexOf("E"))
                    : Screen.shown.substring(0, 6);
            Screen.shown = beforeE + Screen.shown.substring(Screen.shown.indexOf("E"));

            // if number is too big to fit and has a decimal
        } else if (Screen.shown.length() > 11 && Screen.shown.indexOf(".") != -1) {
            Screen.shown = Screen.shown.substring(0, Screen.shown.length() - 7);
            System.out.println("\nState: Number is long with a decimal");

        } else if (Screen.shown.indexOf(".0") != -1 &&
                Screen.shown.indexOf(".0") == Screen.shown.length() - 2) {
            System.out.println("\nState: .0 may be cut off");
            Screen.shown = Screen.shown.substring(0, Screen.shown.length() - 2);
        }

        // cut trailing zeros
        if (Screen.shown.indexOf(".") != -1 && Screen.shown.indexOf("E") == -1) {
            System.out.println("\nState: Cutting off Zeros");
            for (int i = Screen.shown.length() - 1; i > Screen.shown.indexOf(".") - 1; i--) {
                if (Screen.shown.charAt(i) == '0') {
                    Screen.shown = Screen.shown.substring(0, i);
                } else {
                    break;
                }
            }
        }
    }

}
