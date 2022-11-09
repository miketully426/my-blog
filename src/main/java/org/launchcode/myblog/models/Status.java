package org.launchcode.myblog.models;

public enum Status {

    HAPPY("Happy"),
    SAD("Sad"),
    ANGST("Angst"),
    WORRIED("Worried"),
    SURPRISED("Surprised"),
    CALM("Calm"),
    AGHAST("Aghast"),
    BEFUDDLED("Befuddled");

    private final String display;

    Status(String display){
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
