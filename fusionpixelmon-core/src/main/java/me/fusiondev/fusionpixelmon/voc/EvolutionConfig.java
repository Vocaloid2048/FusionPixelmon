package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class EvolutionConfig {

    @Setting("EvolutionCHANGE")
    private String EvolutionCHANGE;
    @Setting("EvolutionInfoNote1")
    private String EvolutionInfoNote1;
    @Setting("EvolutionInfoNote2")
    private String EvolutionInfoNote2;
    @Setting("EvolutionInfoString1")
    private String EvolutionInfoString1;
    @Setting("EvolutionInfoString2")
    private String EvolutionInfoString2;
    @Setting("EvolutionInfoTitle")
    private String EvolutionInfoTitle;
    @Setting("EvolutionNameS")
    private String EvolutionNameS;
    @Setting("EvolutionPriceSummary")
    private String EvolutionPriceSummary;
    @Setting("EvolutionSelectedTitle")
    private String EvolutionSelectedTitle;
    @Setting("EvolutionTitle")
    private String EvolutionTitle;

    //--------------------------------------//

    public String EvolutionCHANGE() { return EvolutionCHANGE; }
    public String EvolutionInfoNote1() { return EvolutionInfoNote1; }
    public String EvolutionInfoNote2() { return EvolutionInfoNote2; }
    public String EvolutionInfoString1() { return EvolutionInfoString1; }
    public String EvolutionInfoString2() { return EvolutionInfoString2; }
    public String EvolutionInfoTitle() { return EvolutionInfoTitle; }
    public String EvolutionNameS() { return EvolutionNameS; }
    public String EvolutionPriceSummary() { return EvolutionPriceSummary; }
    public String EvolutionSelectedTitle() { return EvolutionSelectedTitle; }
    public String EvolutionTitle() { return EvolutionTitle; }


}
