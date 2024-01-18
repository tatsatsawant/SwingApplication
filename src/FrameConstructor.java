import java.awt.*;

public class FrameConstructor {

    private Color contentBackground;
    private Color contentForeground;
    private Color navBarBackground;
    private Color navBarForeground;
    private Color buttonsBackground;
    private Color buttonsBackgroundHover;
    private Color buttonsForeground;
    private boolean isDark;

    public FrameConstructor(boolean isDark) {
        this.isDark = isDark;
        updateColorPalateLight();
    }

    public void updateColorPalateLight() {

        if (isDark) {
            this.contentBackground = new Color(18, 18, 18);
            this.contentForeground = new Color(247, 247, 247);
            this.navBarBackground = new Color(43, 43, 43);
            this.navBarForeground = new Color(247, 247, 247);
            this.buttonsBackground = new Color(102, 68, 158);
            this.buttonsForeground = new Color(247, 247, 247);
            this.buttonsBackgroundHover = new Color(135, 90, 209);
        } else {
            this.contentBackground = new Color(255, 255, 255);
            this.contentForeground = new Color(35, 44, 61);
            this.navBarBackground = new Color(240, 245, 255);
            this.navBarForeground = new Color(35, 44, 61);
            this.buttonsBackground = new Color(78, 175, 255);
            this.buttonsForeground = new Color(247, 247, 247);
            this.buttonsBackgroundHover = new Color(67, 160, 218);
        }
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

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
