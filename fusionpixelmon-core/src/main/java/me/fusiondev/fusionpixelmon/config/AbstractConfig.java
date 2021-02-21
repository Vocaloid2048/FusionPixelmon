package me.fusiondev.fusionpixelmon.config;

import me.fusiondev.fusionpixelmon.modules.arcplates.config.ArcPlatesConfig;
import me.fusiondev.fusionpixelmon.modules.pokedesigner.config.PokeDesignerConfig;
import me.fusiondev.fusionpixelmon.voc.*;

import java.util.HashMap;

public abstract class AbstractConfig {
    public abstract boolean isAntiFallDamageEnabled();
    public abstract boolean isMasterballCraftingEnabled();
    public abstract boolean hasModifiers();
    public abstract HashMap<String, String> getPickableShrines();
    public abstract ArcPlatesConfig getArcPlates();
    public abstract PokeDesignerConfig getPokeDesignerConfig();

    public abstract TranslateConfig getTranslationConfig();
    public abstract AbilityConfig getAbilityConfig();
    public abstract ArcPlateConfig getArcPlateConfig();
    public abstract EvolutionConfig getEvolutionConfig();
    public abstract FormConfig getFormConfig();
    public abstract GenderConfig getGenderConfig();
    public abstract GrowthConfig getGrowthConfig();
    public abstract IVEVConfig getIVEVConfig();
    public abstract LevelConfig getLevelConfig();
    public abstract MoveConfig getMoveConfig();
    public abstract NatureConfig getNatureConfig();
    public abstract NickConfig getNickConfig();
    public abstract PokeBallConfig getPokeBallConfig();
    public abstract ShinyConfig getShinyConfig();
    public abstract ShopConfig getShopConfig();
    public abstract ZenConfig getZenConfig();
}
