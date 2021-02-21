package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class GenderConfig {

    @Setting("GenderCHANGE")
    private String GenderCHANGE;
    @Setting("GenderInfoString1")
    private String GenderInfoString1;
    @Setting("GenderInfoString2")
    private String GenderInfoString2;
    @Setting("GenderInfoTitle")
    private String GenderInfoTitle;
    @Setting("GenderInvFemale")
    private String GenderInvFemale;
    @Setting("GenderInvMale")
    private String GenderInvMale;
    @Setting("GenderNoSex")
    private String GenderNoSex;
    @Setting("GenderPriceSummary")
    private String GenderPriceSummary;
    @Setting("GenderSelectedFemale")
    private String GenderSelectedFemale;
    @Setting("GenderSelectedMale")
    private String GenderSelectedMale;
    @Setting("GenderSelectedTitle")
    private String GenderSelectedTitle;
    @Setting("GenderSetFemale")
    private String GenderSetFemale;
    @Setting("GenderSetMale")
    private String GenderSetMale;
    @Setting("GenderTitle")
    private String GenderTitle;

    //--------------------------------------//

    public String GenderCHANGE() { return GenderCHANGE; }
    public String GenderInfoString1() { return GenderInfoString1; }
    public String GenderInfoString2() { return GenderInfoString2; }
    public String GenderInfoTitle() { return GenderInfoTitle; }
    public String GenderInvFemale() { return GenderInvFemale; }
    public String GenderInvMale() { return GenderInvMale; }
    public String GenderNoSex() { return GenderNoSex; }
    public String GenderPriceSummary() { return GenderPriceSummary; }
    public String GenderSelectedFemale() { return GenderSelectedFemale; }
    public String GenderSelectedMale() { return GenderSelectedMale; }
    public String GenderSelectedTitle() { return GenderSelectedTitle; }
    public String GenderSetFemale() { return GenderSetFemale; }
    public String GenderSetMale() { return GenderSetMale; }
    public String GenderTitle() { return GenderTitle; }

}
