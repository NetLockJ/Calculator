import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class NumberListener extends Operations implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("1234567890".indexOf(e.getActionCommand()) != -1 && Screen.shown.length() < 11) {
            // Make sure we don't get zeros before our number
            if (!e.getActionCommand().equals("0") || Screen.shown.length() > 0) {
                Screen.shown += e.getActionCommand();
                Operations.addOperation(Operation.NUMBER);
            }

            

        } else if (e.getActionCommand().equals(".") && Screen.shown.indexOf(".") == -1) {
            Screen.shown += ".";
        }

        Screen.updateDisplay();
    }
}
