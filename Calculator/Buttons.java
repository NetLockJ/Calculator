import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Buttons extends JPanel {

    private String buttonLabels = "789*456-123+0.÷=";
    JButton clear = new JButton("Clear");
    JButton neg = new JButton("~");

    ArrayList<JButton> buttons = new ArrayList<JButton>() {{
        for(int i = 0; i < buttonLabels.length(); i++) {
            add(new JButton(buttonLabels.substring(i, i + 1)));
        }
    }};

    public Buttons() {
        this.setBackground(Color.BLACK);
        setUpButtons();
        setLayout();
    }

    private void setUpButtons() {
        for(JButton b: buttons){
            if("+-*÷=".indexOf(b.getActionCommand()) != -1) {
                b.addActionListener(new OperationListener());
            } else {
                b.addActionListener(new NumberListener());
            }
        }
        clear.addActionListener(new OperationListener());
        neg.addActionListener(new NumberListener());
    }

    /**
     * Sets up the button layout on the calculator
     */
    private void setLayout() {
        this.setPreferredSize(new Dimension(300,450));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // Make the clear button on top
        // For windows c.ipadx = 20;
        c.gridx = 0; c.gridy = 0;
        this.add(clear);
        c.gridx = 3;
        this.add(neg, c);
        // Specify to fill horizontal space
        c.fill = GridBagConstraints.HORIZONTAL;
        int listNum = 0;
        c.ipady = 40;
        // Fill in the buttons based on the created list of pointers
        for(int y = 1; y < 5; y++) {
            for(int x = 0; x < 4; x++) {
                c.gridx = x; c.gridy = y;
                this.add(buttons.get(listNum), c);
                listNum++;
            }
        }
        
    }
}
