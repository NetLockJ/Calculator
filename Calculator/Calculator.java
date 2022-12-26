import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        // Makes the calculator
        JFrame calcFrame = new JFrame("Calculator!");
        // Split Pane to create a divide between the screen and buttons
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        Screen s = new Screen();
        Buttons b = new Buttons();
        splitPane.setDividerLocation(100);
        splitPane.add(s);
        splitPane.add(b);
        calcFrame.add(splitPane);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);
        calcFrame.setResizable(false);
        calcFrame.setSize(new Dimension(310, 450));
    }
}
