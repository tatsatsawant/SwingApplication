import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private Theme currentTheme;

    public Main() {
        setTitle("Theme Switcher");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton toggleThemeButton = new JButton("Toggle Theme");
        currentTheme = ThemeManager.getLightTheme();
        updateUI();

        toggleThemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle between dark and light themes
                currentTheme = (currentTheme == ThemeManager.getDarkTheme()) ?
                        ThemeManager.getLightTheme() : ThemeManager.getDarkTheme();
                updateUI();
            }
        });

        setLayout(new FlowLayout());
        add(toggleThemeButton);
        setVisible(true);
    }

    private void updateUI() {
        // Implement your logic to update UI components with the current theme
        getContentPane().setBackground(currentTheme.getContentBackground());
        // Update other UI components with colors from the current theme
        // ...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
