package me.fusiondev.fusionpixelmon.config;

import com.google.common.reflect.TypeToken;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import me.fusiondev.fusionpixelmon.modules.arcplates.config.ArcPlatesConfig;
import me.fusiondev.fusionpixelmon.modules.pokedesigner.config.PokeDesignerConfig;
import me.fusiondev.fusionpixelmon.voc.*;

import java.util.HashMap;

@ConfigSerializable
public class Config extends AbstractConfig {
    @SuppressWarnings("UnstableApiUsage")
    public final static TypeToken<Config> type = TypeToken.of(Config.class);

    @Setting("anti-fall-damage")
    private boolean antiFallDamage;
    @Setting("craft-masterballs")
    private boolean craftMasterBalls;
    @Setting("modifiers")
    private boolean modifiers;
    @Setting("pokeshrine")
    private HashMap<String, String> shrinePickup;
    @Setting("arcplates")
    private ArcPlatesConfig arcPlates;
    @Setting("pokedesigner")
    private PokeDesignerConfig pokeDesigner = new PokeDesignerConfig();

    @Override
    public boolean isAntiFallDamageEnabled() {
        return antiFallDamage;
    }

    @Override
    public boolean isMasterballCraftingEnabled() {
        return craftMasterBalls;
    }

    @Override
    public boolean hasModifiers() {
        return modifiers;
    }

    @Override
    public HashMap<String, String> getPickableShrines() {
        return shrinePickup;
    }

    @Override
    public ArcPlatesConfig getArcPlates() {
        return arcPlates;
    }

    @Override
    public PokeDesignerConfig getPokeDesignerConfig() {
        return pokeDesigner;
    }

    /**
     * Added by Voc-夜芷冰, for translation
     */

    @Setting("Translation")
    private TranslateConfig translationConfig = new TranslateConfig();
    @Setting("Ability")
    private AbilityConfig abilityConfig = new AbilityConfig();
    @Setting("ArcPlates")
    private ArcPlateConfig arcPlatesConfig = new ArcPlateConfig();
    @Setting("Evolution")
    private EvolutionConfig evolutionConfig = new EvolutionConfig();
    @Setting("Form")
    private FormConfig formConfig = new FormConfig();
    @Setting("Gender")
    private GenderConfig genderConfig = new GenderConfig();
    @Setting("Growth")
    private GrowthConfig growthConfig = new GrowthConfig();
    @Setting("IVEV")
    private IVEVConfig ivevConfig = new IVEVConfig();
    @Setting("Level")
    private LevelConfig levelConfig = new LevelConfig();
    @Setting("Move")
    private MoveConfig moveConfig = new MoveConfig();
    @Setting("Nature")
    private NatureConfig natureConfig = new NatureConfig();
    @Setting("Nick")
    private NickConfig nickConfig = new NickConfig();
    @Setting("PokeBall")
    private PokeBallConfig pokeBallConfig = new PokeBallConfig();
    @Setting("Shiny")
    private ShinyConfig shinyConfig = new ShinyConfig();
    @Setting("Shop")
    private ShopConfig shopConfig = new ShopConfig();
    @Setting("Zen")
    private ZenConfig zenConfig = new ZenConfig();

    @Override	public 	TranslateConfig	 getTranslationConfig(){ return translationConfig;}
    @Override	public 	AbilityConfig	 getAbilityConfig(){ return abilityConfig;}
    @Override   public  ArcPlateConfig getArcPlateConfig() { return arcPlatesConfig; }
    @Override	public 	EvolutionConfig	 getEvolutionConfig(){ return evolutionConfig;}
    @Override	public 	FormConfig	 getFormConfig(){ return formConfig;}
    @Override	public 	GenderConfig	 getGenderConfig(){ return genderConfig;}
    @Override	public 	GrowthConfig	 getGrowthConfig(){ return growthConfig;}
    @Override	public 	IVEVConfig	 getIVEVConfig(){ return ivevConfig;}
    @Override	public 	LevelConfig	 getLevelConfig(){ return levelConfig;}
    @Override	public 	MoveConfig	 getMoveConfig(){ return moveConfig;}
    @Override	public 	NatureConfig	 getNatureConfig(){ return natureConfig;}
    @Override	public 	NickConfig	 getNickConfig(){ return nickConfig;}
    @Override	public 	PokeBallConfig	 getPokeBallConfig(){ return pokeBallConfig;}
    @Override	public 	ShinyConfig	 getShinyConfig(){ return shinyConfig;}
    @Override	public 	ShopConfig	 getShopConfig(){ return shopConfig;}
    @Override	public 	ZenConfig	 getZenConfig(){ return zenConfig;}

}
