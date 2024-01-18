import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Theme theme = new Theme(false);
        JFrame main = new JFrame();
        main.setSize(new Dimension(400, 300));
        main.setLayout(new GridBagLayout());

        Button button = new Button(theme);
        AbstractButton one = Button.addButton("Theme", "Theme", 70, 40, "JButton");
        AbstractButton two = Button.addButton("Theme", "Theme", 70, 40, "JButton");
        main.add(one);
        main.add(two);

        main.setVisible(true);
    }
}
