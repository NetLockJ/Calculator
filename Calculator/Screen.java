import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    /**Number entered before one currently being displayed */
    public static String hidden = "";
    /**Number currently being displayed */
    public static String shown = "";

    static JLabel screen = new JLabel(shown);
    static JLabel prevNumberLabel = new JLabel(hidden);

    public Screen() {
        setUpPanel();
    }

    private void setUpPanel() {
        // Set background color to black
        this.setPreferredSize(new Dimension(300, 100));
        // make a layout so we can right justify the output
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        screen.setForeground(Color.black);
        screen.setFont(new Font("Sans", Font.BOLD, 40));
        screen.setAlignmentX(RIGHT_ALIGNMENT);
        // Add the label to the screen
        this.add(screen);

        // prevNumberLabel.setForeground(Color.black);
        // prevNumberLabel.setFont(new Font("Sans", Font.BOLD, 20));
        // prevNumberLabel.setAlignmentX(RIGHT_ALIGNMENT);
        // prevNumberLabel.setAlignmentY(BOTTOM_ALIGNMENT);
        // this.add(prevNumberLabel);

    }

    public static void updateDisplay() {
        screen.setText(shown);
        prevNumberLabel.setText(hidden);
        System.out.println("Shown: " + shown + "\tHidden: " + hidden);
    }

}