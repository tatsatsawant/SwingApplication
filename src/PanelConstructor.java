import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelConstructor {
    private Theme theme;

    public PanelConstructor(Theme theme) {
        this.theme = theme;
    }

    public JPanel addPanel(String panelName, int width, int height, boolean enableHover) {
        JPanel panel = new JPanel();
        configurePanel(panel, panelName, width, height, enableHover);
        return panel;
    }

    private void configurePanel(JPanel panel, String panelName, int width, int height, boolean enableHover) {
        panel.setLayout(new BorderLayout());
        panel.setName(panelName);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(theme.getNavBarBackground());
        panel.setForeground(theme.getNavBarForeground());
        panel.setBorder(createDefaultBorder());
        if (enableHover) {
            panel.addMouseListener(createMouseAdapter(panel));
        }
    }

    private Border createDefaultBorder() {
        return BorderFactory.createLineBorder(theme.getBorderBackground()); // You can customize the border further if needed
    }

    private MouseAdapter createMouseAdapter(JPanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(theme.getNavBarBackground().darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(theme.getNavBarBackground());
            }
        };
    }

    public void updatePanelUI(JPanel panel, Theme currentTheme) {
        this.theme = currentTheme;
        panel.setBackground(currentTheme.getNavBarBackground());
        panel.setForeground(currentTheme.getNavBarForeground());
        panel.setBorder(createDefaultBorder());
    }
}
