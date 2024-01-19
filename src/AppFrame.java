import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    private Theme currentTheme = ThemeManager.getLightTheme();
    private final ButtonConstructor buttonConstructor;
    private PanelConstructor panelConstructor;
    private JPanel contentPanel, buttonPanel;

    private final AbstractButton home, about, theme;

    public AppFrame() {
        setTitle("Theme Switcher");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);

        buttonConstructor = new ButtonConstructor(currentTheme);
        panelConstructor = new PanelConstructor(currentTheme);

        contentPanel = panelConstructor.addPanel("contentPanel", 600, 400, true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(contentPanel, gbc);

        buttonPanel = panelConstructor.addPanel("buttonPanel", 600, 50, false);
//        buttonPanel.setBackground(null);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttonPanel, gbc);

        home = buttonConstructor.addButton("home", "HOME", 80, 30, "JButton");
        buttonPanel.add(home);

        about = buttonConstructor.addButton("about", "ABOUT", 80, 30, "JButton");
        buttonPanel.add(about);

        theme = buttonConstructor.addButton("theme", "THEME", 80, 30, "JButton");
        buttonPanel.add(theme);

        theme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle between dark and light themes
                currentTheme = (currentTheme == ThemeManager.getDarkTheme()) ? ThemeManager.getLightTheme() : ThemeManager.getDarkTheme();
                updateUI();
            }
        });

        updateUI(); // Initial UI setup

        setVisible(true);
    }

    private void updateUI() {
        getContentPane().setBackground(currentTheme.getContentBackground());
        buttonConstructor.updateButtonUI(home, currentTheme);
        buttonConstructor.updateButtonUI(about, currentTheme);
        buttonConstructor.updateButtonUI(theme, currentTheme);
        panelConstructor.updatePanelUI(contentPanel, currentTheme);
        panelConstructor.updatePanelUI(buttonPanel, currentTheme);
    }
    public void showFrame() {
        setVisible(true);
    }
}
