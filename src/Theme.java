import java.awt.Color;

public class Theme {
    private final Color contentBackground;
    private final Color contentForeground;
    private final Color navBarBackground;
    private final Color navBarForeground;
    private final Color buttonsBackground;
    private final Color buttonsBackgroundHover;
    private final Color buttonsForeground;
    private final boolean isDark;

    public Theme(boolean isDark) {
        this.isDark = isDark;
        if (isDark) {
            // Initialize dark mode colors
            this.contentBackground = new Color(18, 18, 18);
            this.navBarBackground = new Color(43, 43, 43);
            this.buttonsBackground = new Color(102, 68, 158);
            this.buttonsBackgroundHover = new Color(135, 90, 209);
        } else {
            // Initialize light mode colors
            this.contentBackground = new Color(255, 255, 255);
            this.navBarBackground = new Color(240, 245, 255);
            this.buttonsBackground = new Color(78, 175, 255);
            this.buttonsBackgroundHover = new Color(67, 160, 218);
        }
        // Initialize common colors
        this.contentForeground = new Color(247, 247, 247);
        this.navBarForeground = new Color(247, 247, 247);
        this.buttonsForeground = new Color(247, 247, 247);
    }

    public Color getContentBackground() {
        return contentBackground;
    }

    public Color getContentForeground() {
        return contentForeground;
    }

    public Color getNavBarBackground() {
        return navBarBackground;
    }

    public Color getNavBarForeground() {
        return navBarForeground;
    }

    public Color getButtonsBackground() {
        return buttonsBackground;
    }

    public Color getButtonsBackgroundHover() {
        return buttonsBackgroundHover;
    }

    public Color getButtonsForeground() {
        return buttonsForeground;
    }

    public boolean isDark() {
        return isDark;
    }
}

