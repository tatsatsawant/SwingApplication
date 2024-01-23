import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private final ButtonConstructor buttonConstructor;
    private final PanelConstructor panelConstructor;
    private final JPanel homePanel, aboutPanel, buttonPanel;
    private final JLabel homeLabel, aboutLabel;
    private final AbstractButton home, about, theme;
    private Theme currentTheme = ThemeManager.getLightTheme();

    public AppFrame() {
        setTitle("Java Swing Application");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 5, 0);

        buttonConstructor = new ButtonConstructor(currentTheme);
        panelConstructor = new PanelConstructor(currentTheme);

        homePanel = panelConstructor.addPanel("contentPanel", 600, 400, true);
        homePanel.setVisible(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(homePanel, gbc);

        homeLabel = new JLabel("Welcome To Home!");
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        homeLabel.setFont(new Font("Raleway", Font.ITALIC, 40));
        homePanel.add(homeLabel, BorderLayout.CENTER);

        aboutPanel = panelConstructor.addPanel("aboutPanel", 600, 400, true);
        setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(aboutPanel, gbc);

        aboutLabel = new JLabel("About....");
        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutLabel.setFont(new Font("Raleway", Font.ITALIC, 40));
        aboutPanel.add(aboutLabel, BorderLayout.CENTER);

        buttonPanel = panelConstructor.addPanel("buttonPanel", 600, 50, false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttonPanel, gbc);

        home = buttonConstructor.addButton("home", "HOME", 80, 30, "JButton");
        buttonPanel.add(home);
        home.addActionListener(_ -> handleButtonClick("home"));

        about = buttonConstructor.addButton("about", "ABOUT", 80, 30, "JButton");
        buttonPanel.add(about);
        about.addActionListener(_ -> handleButtonClick("about"));

        theme = buttonConstructor.addButton("theme", "THEME", 80, 30, "JButton");
        buttonPanel.add(theme);
        theme.addActionListener(_ -> handleButtonClick("theme"));

        updateUI(); // Initial UI setup

        setVisible(true);
    }

    private void handleButtonClick(String buttonName) {
        switch (buttonName) {
            case "home":
                homePanel.setVisible(true);
                aboutPanel.setVisible(false);
                break;
            case "about":
                aboutPanel.setVisible(true);
                homePanel.setVisible(false);
                break;
            case "theme":
                currentTheme = (currentTheme == ThemeManager.getDarkTheme()) ? ThemeManager.getLightTheme() : ThemeManager.getDarkTheme();
                updateUI();
                break;
            // Add more cases if needed for additional buttons
        }
    }

    private void updateUI() {
        getContentPane().setBackground(currentTheme.getContentBackground());
        buttonConstructor.updateButtonUI(home, currentTheme);
        buttonConstructor.updateButtonUI(about, currentTheme);
        buttonConstructor.updateButtonUI(theme, currentTheme);
        panelConstructor.updatePanelUI(homePanel, currentTheme);
        panelConstructor.updatePanelUI(buttonPanel, currentTheme);
        panelConstructor.updatePanelUI(aboutPanel, currentTheme);
        aboutLabel.setForeground(currentTheme.getBorderBackground());
        homeLabel.setForeground(currentTheme.getBorderBackground());
    }

    public void showFrame() {
        setVisible(true);
    }
}
