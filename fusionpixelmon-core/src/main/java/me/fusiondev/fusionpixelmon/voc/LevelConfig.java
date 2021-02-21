package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class LevelConfig {

    @Setting("LevelDecreaseLvl")
    private String LevelDecreaseLvl;
    @Setting("LevelEach")
    private String LevelEach;
    @Setting("LevelIncreaseLvl")
    private String LevelIncreaseLvl;
    @Setting("LevelInfoString1")
    private String LevelInfoString1;
    @Setting("LevelInfoString2")
    private String LevelInfoString2;
    @Setting("LevelInfoTitle")
    private String LevelInfoTitle;
    @Setting("LevelLeftClick")
    private String LevelLeftClick;
    @Setting("LevelLeftClickShift")
    private String LevelLeftClickShift;
    @Setting("LevelNotes")
    private String LevelNotes;
    @Setting("LevelPressDecrease")
    private String LevelPressDecrease;
    @Setting("LevelPressIncrease")
    private String LevelPressIncrease;
    @Setting("LevelSelectedTitle")
    private String LevelSelectedTitle;
    @Setting("LevelTitle")
    private String LevelTitle;
    @Setting("LevelZName")
    private String LevelZName;

    //--------------------------------------//

    public String LevelDecreaseLvl() { return LevelDecreaseLvl; }
    public String LevelEach() { return LevelEach; }
    public String LevelIncreaseLvl() { return LevelIncreaseLvl; }
    public String LevelInfoString1() { return LevelInfoString1; }
    public String LevelInfoString2() { return LevelInfoString2; }
    public String LevelInfoTitle() { return LevelInfoTitle; }
    public String LevelLeftClick() { return LevelLeftClick; }
    public String LevelLeftClickShift() { return LevelLeftClickShift; }
    public String LevelNotes() { return LevelNotes; }
    public String LevelPressDecrease() { return LevelPressDecrease; }
    public String LevelPressIncrease() { return LevelPressIncrease; }
    public String LevelSelectedTitle() { return LevelSelectedTitle; }
    public String LevelTitle() { return LevelTitle; }
    public String LevelZName() { return LevelZName; }

}
