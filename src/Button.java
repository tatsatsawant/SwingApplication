import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends Theme{

    private static Theme theme = new Theme();

    public static MouseAdapter commonMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component source = (Component) e.getSource();
            source.setBackground(theme.getButtonsBackgroundHover());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component source = (Component) e.getSource();
            source.setBackground(theme.getButtonsBackground());
        }
    };

    public Button(Theme theme) {
        super();
        Button.theme = theme;
    }

    public static AbstractButton addButton(String buttonName, String buttonText, int width, int height, String buttonType) {
        AbstractButton button;
        if ("JButton".equalsIgnoreCase(buttonType)) {
            button = new JButton();
        } else if ("JRadioButton".equalsIgnoreCase(buttonType)) {
            button = new JRadioButton();
        } else {
            throw new IllegalArgumentException("Invalid button type. Supported types are JButton and JRadioButton.");
        }

        button.setLayout(new BorderLayout());
        button.setName(buttonName);
        button.setText(buttonText);
        button.setPreferredSize(new Dimension(width, height));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setFocusable(false);
        button.setForeground(theme.getButtonsForeground());
        button.setBackground(theme.getButtonsBackground());
        button.setBorderPainted(false);
        button.addMouseListener(commonMouseAdapter);

        return button;
    }
}
