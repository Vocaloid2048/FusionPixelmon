package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class ShinyConfig {

    @Setting("ShinyInfoString1")
    private String ShinyInfoString1;
    @Setting("ShinyInfoString2")
    private String ShinyInfoString2;
    @Setting("ShinyInfoTitle")
    private String ShinyInfoTitle;
    @Setting("ShinyDPriceSummary")
    private String ShinyDPriceSummary;
    @Setting("ShinyChoose")
    private String ShinyChoose;
    @Setting("ShinyDelete")
    private String ShinyDelete;
    @Setting("ShinySelectedTitle")
    private String ShinySelectedTitle;
    @Setting("ShinyCPriceSummary")
    private String ShinyCPriceSummary;
    @Setting("ShinyFalse")
    private String ShinyFalse;
    @Setting("ShinyFalseChoose")
    private String ShinyFalseChoose;
    @Setting("ShinyTrue")
    private String ShinyTrue;
    @Setting("ShinyTrueChoose")
    private String ShinyTrueChoose;
    @Setting("ShinyTitle")
    private String ShinyTitle;


    //--------------------------------------//

    public String ShinyInfoString1() { return ShinyInfoString1;}
    public String ShinyInfoString2() { return ShinyInfoString2;}
    public String ShinyInfoTitle() { return ShinyInfoTitle;}
    public String ShinyDPriceSummary() { return ShinyDPriceSummary;}
    public String ShinyChoose() { return ShinyChoose;}
    public String ShinyDelete() { return ShinyDelete;}
    public String ShinySelectedTitle() { return ShinySelectedTitle;}
    public String ShinyCPriceSummary() { return ShinyCPriceSummary;}
    public String ShinyFALSE() { return ShinyFalse;}
    public String ShinyFalseChoose() { return ShinyFalseChoose;}
    public String ShinyTRUE() { return ShinyTrue;}
    public String ShinyTrueChoose() { return ShinyTrueChoose;}
    public String ShinyTitle() { return ShinyTitle;}



}
