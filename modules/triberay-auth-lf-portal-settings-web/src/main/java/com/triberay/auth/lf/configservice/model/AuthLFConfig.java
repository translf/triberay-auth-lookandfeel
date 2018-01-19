package com.triberay.auth.lf.configservice.model;

public class AuthLFConfig {

    private String width;
    private String align;
    private String buttonStyle;
    private boolean showSignOut;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getButtonStyle() {
        return buttonStyle;
    }

    public void setButtonStyle(String buttonStyle) {
        this.buttonStyle = buttonStyle;
    }

    public boolean isShowSignOut() {
        return showSignOut;
    }

    public void setShowSignOut(boolean showSignOut) {
        this.showSignOut = showSignOut;
    }
}
