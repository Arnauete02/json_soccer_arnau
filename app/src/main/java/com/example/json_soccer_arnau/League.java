package com.example.json_soccer_arnau;

public class League {

    private String flag;
    private String textTitle;
    private String textDescription;

    public League(String flag, String textTitle, String textDescription) {
        this.flag = flag;
        this.textTitle = textTitle;
        this.textDescription = textDescription;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }
}
