package me.fusiondev.fusionpixelmon.voc;

import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

/**
 * Added by Voc-夜芷冰, for translation
 */

@ConfigSerializable
public class TranslateConfig {

    @Setting("Translation")
    private boolean Translation;

    //--------------------------------------//

    public boolean Translation() { return Translation; }


}
