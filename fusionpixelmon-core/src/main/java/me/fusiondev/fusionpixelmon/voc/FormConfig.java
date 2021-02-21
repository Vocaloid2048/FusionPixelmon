package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class FormConfig {

    @Setting("FormCHANGE")
    private String FormCHANGE;
    @Setting("FormInfoNote1")
    private String FormInfoNote1;
    @Setting("FormInfoString1")
    private String FormInfoString1;
    @Setting("FormInfoString2")
    private String FormInfoString2;
    @Setting("FormInfoTitle")
    private String FormInfoTitle;
    @Setting("FormPriceSummery")
    private String FormPriceSummery;
    @Setting("FormSelectedTitle")
    private String FormSelectedTitle;
    @Setting("FormShiny")
    private String FormShiny;
    @Setting("FormTitle")
    private String FormTitle;

    //--------------------------------------//

    public String FormCHANGE() { return FormCHANGE; }
    public String FormInfoNote1() { return FormInfoNote1; }
    public String FormInfoString1() { return FormInfoString1; }
    public String FormInfoString2() { return FormInfoString2; }
    public String FormInfoTitle() { return FormInfoTitle; }
    public String FormPriceSummery() { return FormPriceSummery; }
    public String FormSelectedTitle() { return FormSelectedTitle; }
    public String FormShiny() { return FormShiny; }
    public String FormTitle() { return FormTitle; }

}
