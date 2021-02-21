package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class NatureConfig {

    @Setting("NatureATK")
    private String NatureATK;
    @Setting("NatureCHANGE")
    private String NatureCHANGE;
    @Setting("NatureDEF")
    private String NatureDEF;
    @Setting("NatureDecreased")
    private String NatureDecreased;
    @Setting("NatureHP")
    private String NatureHP;
    @Setting("NatureIncreased")
    private String NatureIncreased;
    @Setting("NatureInfoString1")
    private String NatureInfoString1;
    @Setting("NatureInfoString2")
    private String NatureInfoString2;
    @Setting("NatureInfoTitle")
    private String NatureInfoTitle;
    @Setting("NaturePriceSummary")
    private String NaturePriceSummary;
    @Setting("NatureSATK")
    private String NatureSATK;
    @Setting("NatureSDEF")
    private String NatureSDEF;
    @Setting("NatureSPD")
    private String NatureSPD;
    @Setting("NatureSelectedTitle")
    private String NatureSelectedTitle;
    @Setting("NatureTitle")
    private String NatureTitle;

    //--------------------------------------//

    public String NatureATK() { return NatureATK; }
    public String NatureCHANGE() { return NatureCHANGE; }
    public String NatureDEF() { return NatureDEF; }
    public String NatureIncreased() { return NatureIncreased; }
    public String NatureDecreased() { return NatureDecreased; }
    public String NatureHP() { return NatureHP; }
    public String NatureInfoString1() { return NatureInfoString1; }
    public String NatureInfoString2() { return NatureInfoString2; }
    public String NatureInfoTitle() { return NatureInfoTitle; }
    public String NaturePriceSummary() { return NaturePriceSummary; }
    public String NatureSATK() { return NatureSATK; }
    public String NatureSDEF() { return NatureSDEF; }
    public String NatureSPD() { return NatureSPD; }
    public String NatureSelectedTitle() { return NatureSelectedTitle; }
    public String NatureTitle() { return NatureTitle; }

}
