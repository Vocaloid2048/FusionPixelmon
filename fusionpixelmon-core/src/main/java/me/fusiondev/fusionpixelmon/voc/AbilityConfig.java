package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class AbilityConfig {

    @Setting("AbilityInfoString1")
    private String AbilityInfoString1;
    @Setting("AbilityInfoString2")
    private String AbilityInfoString2;
    @Setting("AbilityInfoTitle")
    private String AbilityInfoTitle;
    @Setting("AbilityNormalSummary")
    private String AbilityNormalSummary;
    @Setting("AbilityREGULAR")
    private String AbilityREGULAR;
    @Setting("AbilitySPECIAL")
    private String AbilitySPECIAL;
    @Setting("AbilitySelectedTitle")
    private String AbilitySelectedTitle;
    @Setting("AbilitySpecialSummary")
    private String AbilitySpecialSummary;
    @Setting("AbilityTitle")
    private String AbilityTitle;

    //--------------------------------------//

    public String AbilityInfoString1() { return AbilityInfoString1; }
    public String AbilityInfoString2() { return AbilityInfoString2; }
    public String AbilityInfoTitle() { return AbilityInfoTitle; }
    public String AbilityNormalSummary() { return AbilityNormalSummary; }
    public String AbilityREGULAR() { return AbilityREGULAR; }
    public String AbilitySPECIAL() { return AbilitySPECIAL; }
    public String AbilitySelectedTitle() { return AbilitySelectedTitle; }
    public String AbilitySpecialSummary() { return AbilitySpecialSummary; }
    public String AbilityTitle() { return AbilityTitle; }


}
