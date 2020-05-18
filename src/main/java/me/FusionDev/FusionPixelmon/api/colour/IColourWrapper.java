package me.FusionDev.FusionPixelmon.api.colour;

public interface IColourWrapper {
    boolean hasColour();
    void setColour(Colour colour);
    boolean hasStyle();
    void setStyle(Colour style);
    String getFullCode();
}
