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

    private static final Color DARK_CONTENT_BACKGROUND = new Color(18, 18, 18);
    private static final Color LIGHT_CONTENT_BACKGROUND = new Color(255, 255, 255);
    private static final Color DARK_NAVBAR_BACKGROUND = new Color(43, 43, 43);
    private static final Color LIGHT_NAVBAR_BACKGROUND = new Color(240, 245, 255);
    private static final Color DARK_BUTTONS_BACKGROUND = new Color(102, 68, 158);
    private static final Color LIGHT_BUTTONS_BACKGROUND = new Color(78, 175, 255);
    private static final Color DARK_BUTTONS_BACKGROUND_HOVER = new Color(135, 90, 209);
    private static final Color LIGHT_BUTTONS_BACKGROUND_HOVER = new Color(67, 160, 218);
    private static final Color COMMON_FOREGROUND = new Color(247, 247, 247);

    public Theme(boolean isDark) {
        this.isDark = isDark;
        this.contentBackground = isDark ? DARK_CONTENT_BACKGROUND : LIGHT_CONTENT_BACKGROUND;
        this.navBarBackground = isDark ? DARK_NAVBAR_BACKGROUND : LIGHT_NAVBAR_BACKGROUND;
        this.buttonsBackground = isDark ? DARK_BUTTONS_BACKGROUND : LIGHT_BUTTONS_BACKGROUND;
        this.buttonsBackgroundHover = isDark ? DARK_BUTTONS_BACKGROUND_HOVER : LIGHT_BUTTONS_BACKGROUND_HOVER;
        this.contentForeground = COMMON_FOREGROUND;
        this.navBarForeground = COMMON_FOREGROUND;
        this.buttonsForeground = COMMON_FOREGROUND;
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
}
