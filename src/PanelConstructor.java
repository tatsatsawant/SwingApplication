import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelConstructor {
    private Theme theme;

    public PanelConstructor(Theme theme) {
        this.theme = theme;
    }

    public JPanel addPanel(String panelName, int width, int height) {
        JPanel panel = new JPanel();
        configurePanel(panel, panelName, width, height);
        return panel;
    }

    private void configurePanel(JPanel panel, String panelName, int width, int height) {
        panel.setLayout(new BorderLayout());
        panel.setName(panelName);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(theme.getContentBackground());
        panel.setForeground(theme.getContentForeground());
        panel.addMouseListener(createMouseAdapter(panel));
        panel.setVisible(true);
    }

    private MouseAdapter createMouseAdapter(JPanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(theme.getContentBackground().darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(theme.getContentBackground());
            }
        };
    }

    public void updatePanelUI(JPanel panel, Theme currentTheme) {
        this.theme = currentTheme;
        panel.setBackground(currentTheme.getContentBackground());
        panel.setForeground(currentTheme.getContentForeground());
    }
}
