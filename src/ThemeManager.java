public class ThemeManager {
    private static final Theme DARK_THEME = new Theme(true);
    private static final Theme LIGHT_THEME = new Theme(false);

    public static Theme getDarkTheme() {
        return DARK_THEME;
    }

    public static Theme getLightTheme() {
        return LIGHT_THEME;
    }
}
