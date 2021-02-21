package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class MoveConfig {

    @Setting("MoveCHANGE")
    private String MoveCHANGE;
    @Setting("MoveEach")
    private String MoveEach;
    @Setting("MoveInfoString1")
    private String MoveInfoString1;
    @Setting("MoveInfoString2")
    private String MoveInfoString2;
    @Setting("MoveInfoString3")
    private String MoveInfoString3;
    @Setting("MoveInfoTitle")
    private String MoveInfoTitle;
    @Setting("MoveLetStudy")
    private String MoveLetStudy;
    @Setting("MoveMoveS")
    private String MoveMoveS;
    @Setting("MoveNextPage")
    private String MoveNextPage;
    @Setting("MovePreviousPage")
    private String MovePreviousPage;
    @Setting("MovePriceSummary")
    private String MovePriceSummary;
    @Setting("MoveSelectedTitle")
    private String MoveSelectedTitle;
    @Setting("MoveTitle")
    private String MoveTitle;
    @Setting("MoveReplace")
    private String MoveReplace;
    @Setting("MoveLearning")
    private String MoveLearning;
    @Setting("MoveCancel")
    private String MoveCancel;

    //--------------------------------------//

    public String MoveCHANGE() { return MoveCHANGE; }
    public String MoveEach() { return MoveEach; }
    public String MoveInfoString1() { return MoveInfoString1; }
    public String MoveInfoString2() { return MoveInfoString2; }
    public String MoveInfoString3() { return MoveInfoString3; }
    public String MoveInfoTitle() { return MoveInfoTitle; }
    public String MoveLetStudy() { return MoveLetStudy; }
    public String MoveMoveS() { return MoveMoveS; }
    public String MoveNextPage() { return MoveNextPage; }
    public String MovePreviousPage() { return MovePreviousPage; }
    public String MovePriceSummary() { return MovePriceSummary; }
    public String MoveSelectedTitle() { return MoveSelectedTitle; }
    public String MoveReplace() { return MoveReplace; }
    public String MoveLearning() { return MoveLearning; }
    public String MoveCancel() { return MoveCancel; }
    public String MoveTitle() { return MoveTitle; }

}
