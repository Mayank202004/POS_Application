package Dependency;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

//    public Icon toIcon() {
//        java.net.URL imgURL = getClass().getResource("/pos_application/img/" + icon + ".png");
//        if (imgURL != null) {
//            return new ImageIcon(imgURL);
//        } else {
//            return null;
//    }
//    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
