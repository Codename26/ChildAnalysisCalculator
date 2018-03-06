package com.codename26.childanalysiscalculator;

/**
 * Created by User on 06.03.2018.
 */

public class ItemMainActivity {

    private String title;
    private String iconURI;

    public ItemMainActivity(String title, String iconURI) {
        this.title = title;
        this.iconURI = iconURI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconURI() {
        return iconURI;
    }

    public void setIconURI(String iconURI) {
        this.iconURI = iconURI;
    }
}
