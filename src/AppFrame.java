import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    private Theme currentTheme = ThemeManager.getLightTheme();
    private final ButtonConstructor buttonConstructor;
    private PanelConstructor panelConstructor;
    private JPanel contentPanel;

    private final AbstractButton home, about, theme;

    public AppFrame() {
        setTitle("Theme Switcher");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonConstructor = new ButtonConstructor(currentTheme);
        panelConstructor = new PanelConstructor(currentTheme);

        contentPanel = panelConstructor.addPanel("contentPanel", 300, 200);
        add(contentPanel);
        home = buttonConstructor.addButton("home", "HOME", 80, 30, "JButton");
        about = buttonConstructor.addButton("about", "ABOUT", 80, 30, "JButton");
        theme = buttonConstructor.addButton("theme", "THEME", 80, 30, "JButton");

        theme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle between dark and light themes
                currentTheme = (currentTheme == ThemeManager.getDarkTheme()) ? ThemeManager.getLightTheme() : ThemeManager.getDarkTheme();
                updateUI();
            }
        });


        add(home);
        add(about);
        add(theme);
        setVisible(true);
    }

    private void updateUI() {
        getContentPane().setBackground(currentTheme.getContentBackground());
        buttonConstructor.updateButtonUI(home, currentTheme);
        buttonConstructor.updateButtonUI(about, currentTheme);
        buttonConstructor.updateButtonUI(theme, currentTheme);
        panelConstructor.updatePanelUI(contentPanel, currentTheme);
    }

    public void showFrame() {
        setVisible(true);
    }
}
