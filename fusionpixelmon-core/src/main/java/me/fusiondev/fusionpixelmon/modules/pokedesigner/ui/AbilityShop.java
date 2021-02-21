package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.Registry;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.modules.pokedesigner.config.PokeDesignerConfig;
import me.fusiondev.fusionpixelmon.voc.AbilityConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;

public class AbilityShop extends BaseShop {
    public AbilityShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.ABILITY;
    }
    AbilityConfig config = FusionPixelmon.getInstance().getConfiguration().getAbilityConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();
    private int abilitySlot = 0;

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder(config.AbilityTitle(), "pokeeditor-ability", 5)
        //Builder builder = new Builder("§0特性修改", "pokeeditor-ability", 5)
                .setInfoItemData(config.AbilityInfoTitle(),
                        config.AbilityInfoString1(),
                        config.AbilityInfoString2())
                .setSelectedItemName(config.AbilitySelectedTitle())
                .setSelectedOption(getOption());
        InvPage page = builder.build();
        Registry reg = FusionPixelmon.getRegistry();


        int[] slots = new int[]{20, 22, 24};
        DyeColor[] colors = new DyeColor[]{DyeColor.GREEN, DyeColor.YELLOW, DyeColor.RED};
        String[] allAbilities = shops.pokemon.getBaseStats().abilities;
        for (int i = 0; i < allAbilities.length; i++) {
            if (allAbilities[i] == null || (i == 1 && allAbilities[1].equals(allAbilities[0]))) {
                InvItem item = new InvItem(reg.getItemTypesRegistry().BARRIER(), "§c§lN/A");
                page.setItem(slots[i], item);
            } else {
                String ability = allAbilities[i];
                String abilityEN = allAbilities[i];

                if (Tconfig.Translation() == true){

                    if (ability.equals("Adaptability")){ability = "適應力";}
                    if (ability.equals("Aerilate")){ability = "飛行皮膚";}
                    if (ability.equals("Aftermath")){ability = "引爆";}
                    if (ability.equals("AirLock")){ability = "氣閘";}
                    if (ability.equals("Analytic")){ability = "分析";}
                    if (ability.equals("AngerPoint")){ability = "憤怒穴位";}
                    if (ability.equals("Anticipation")){ability = "危險預知";}
                    if (ability.equals("ArenaTrap")){ability = "沙穴";}
                    if (ability.equals("AromaVeil")){ability = "芳香幕";}
                    if (ability.equals("AuraBreak")){ability = "氣場破壞";}
                    if (ability.equals("BadDreams")){ability = "夢魘";}
                    if (ability.equals("BallFetch")){ability = "撿球";}
                    if (ability.equals("Battery")){ability = "蓄電池";}
                    if (ability.equals("BattleArmor")){ability = "戰鬥盔甲";}
                    if (ability.equals("BattleBond")){ability = "牽絆變身";}
                    if (ability.equals("BeastBoost")){ability = "異獸提升";}
                    if (ability.equals("Berserk")){ability = "怒火沖天";}
                    if (ability.equals("BigPecks")){ability = "健壯胸肌";}
                    if (ability.equals("Blaze")){ability = "猛火";}
                    if (ability.equals("Bulletproof")){ability = "防彈";}
                    if (ability.equals("CheekPouch")){ability = "頰囊";}
                    if (ability.equals("Chlorophyll")){ability = "葉綠素";}
                    if (ability.equals("ClearBody")){ability = "恆淨之軀";}
                    if (ability.equals("CloudNine")){ability = "無關天氣";}
                    if (ability.equals("ColorChange")){ability = "變色";}
                    if (ability.equals("Comatose")){ability = "絕對睡眠";}
                    if (ability.equals("Competitive")){ability = "好勝";}
                    if (ability.equals("CompoundEyes")){ability = "複眼";}
                    if (ability.equals("Contrary")){ability = "唱反調";}
                    if (ability.equals("Corrosion")){ability = "腐蝕";}
                    if (ability.equals("CottonDown")){ability = "棉絮";}
                    if (ability.equals("CursedBody")){ability = "詛咒之軀";}
                    if (ability.equals("CuteCharm")){ability = "迷人之軀";}
                    if (ability.equals("Damp")){ability = "濕氣";}
                    if (ability.equals("Dancer")){ability = "舞者";}
                    if (ability.equals("DarkAura")){ability = "暗黑氣場";}
                    if (ability.equals("DauntlessShield")){ability = "不屈之盾";}
                    if (ability.equals("Dazzling")){ability = "鮮艷之軀";}
                    if (ability.equals("Defeatist")){ability = "軟弱";}
                    if (ability.equals("Defiant")){ability = "不服輸";}
                    if (ability.equals("Disguise")){ability = "畫皮";}
                    if (ability.equals("Download")){ability = "下載";}
                    if (ability.equals("DragonsMaw")){ability = "龍顎";}
                    if (ability.equals("Drizzle")){ability = "降雨";}
                    if (ability.equals("Drought")){ability = "日照";}
                    if (ability.equals("DrySkin")){ability = "乾燥皮膚";}
                    if (ability.equals("EarlyBird")){ability = "早起";}
                    if (ability.equals("EffectSpore")){ability = "孢子";}
                    if (ability.equals("ElectricSurge")){ability = "電氣製造者";}
                    if (ability.equals("EmergencyExit")){ability = "危險迴避";}
                    if (ability.equals("§k?§rError§k?§r")){ability = "§k?§r錯誤§k?§r";}
                    if (ability.equals("FairyAura")){ability = "妖精氣場";}
                    if (ability.equals("Filter")){ability = "過濾";}
                    if (ability.equals("FlameBody")){ability = "火焰之軀";}
                    if (ability.equals("FlareBoost")){ability = "受熱激升";}
                    if (ability.equals("FlashFire")){ability = "引火";}
                    if (ability.equals("FlowerGift")){ability = "花之禮";}
                    if (ability.equals("FlowerVeil")){ability = "花幕";}
                    if (ability.equals("Fluffy")){ability = "毛茸茸";}
                    if (ability.equals("Forecast")){ability = "陰晴不定";}
                    if (ability.equals("Forewarn")){ability = "預知夢";}
                    if (ability.equals("FriendGuard")){ability = "友情防守";}
                    if (ability.equals("Frisk")){ability = "察覺";}
                    if (ability.equals("FullMetalBody")){ability = "金屬防護";}
                    if (ability.equals("FurCoat")){ability = "毛皮大衣";}
                    if (ability.equals("GaleWings")){ability = "疾風之翼";}
                    if (ability.equals("Galvanize")){ability = "電氣皮膚";}
                    if (ability.equals("Gluttony")){ability = "貪吃鬼";}
                    if (ability.equals("Gooey")){ability = "黏滑";}
                    if (ability.equals("GorillaTactics")){ability = "一猩一意";}
                    if (ability.equals("GrassPelt")){ability = "草之毛皮";}
                    if (ability.equals("GrassySurge")){ability = "青草製造者";}
                    if (ability.equals("GulpMissile")){ability = "一口飛彈";}
                    if (ability.equals("Guts")){ability = "毅力";}
                    if (ability.equals("Harvest")){ability = "收穫";}
                    if (ability.equals("Healer")){ability = "治癒之心";}
                    if (ability.equals("Heatproof")){ability = "耐熱";}
                    if (ability.equals("HeavyMetal")){ability = "重金屬";}
                    if (ability.equals("HoneyGather")){ability = "採蜜";}
                    if (ability.equals("HugePower")){ability = "大力士";}
                    if (ability.equals("HungerSwitch")){ability = "飽了又餓";}
                    if (ability.equals("Hustle")){ability = "活力";}
                    if (ability.equals("Hydration")){ability = "濕潤之軀";}
                    if (ability.equals("HyperCutter")){ability = "怪力鉗";}
                    if (ability.equals("IceBody")){ability = "冰凍之軀";}
                    if (ability.equals("IceFace")){ability = "結凍頭";}
                    if (ability.equals("IceScales")){ability = "冰鱗粉";}
                    if (ability.equals("Illuminate")){ability = "發光";}
                    if (ability.equals("Illusion")){ability = "幻覺";}
                    if (ability.equals("Immunity")){ability = "免疫";}
                    if (ability.equals("Imposter")){ability = "變身者";}
                    if (ability.equals("Infiltrator")){ability = "穿透";}
                    if (ability.equals("InnardsOut")){ability = "飛出的內在物";}
                    if (ability.equals("InnerFocus")){ability = "精神力";}
                    if (ability.equals("Insomnia")){ability = "不眠";}
                    if (ability.equals("Intimidate")){ability = "威嚇";}
                    if (ability.equals("IntrepidSword")){ability = "不撓之劍";}
                    if (ability.equals("IronBarbs")){ability = "鐵刺";}
                    if (ability.equals("IronFist")){ability = "鐵拳";}
                    if (ability.equals("Justified")){ability = "正義之心";}
                    if (ability.equals("KeenEye")){ability = "銳利目光";}
                    if (ability.equals("Klutz")){ability = "笨拙";}
                    if (ability.equals("LeafGuard")){ability = "葉子防守";}
                    if (ability.equals("Levitate")){ability = "飄浮";}
                    if (ability.equals("Libero")){ability = "自由者";}
                    if (ability.equals("LightMetal")){ability = "輕金屬";}
                    if (ability.equals("LightningRod")){ability = "避雷針";}
                    if (ability.equals("Limber")){ability = "柔軟";}
                    if (ability.equals("LiquidOoze")){ability = "污泥漿";}
                    if (ability.equals("LiquidVoice")){ability = "濕潤之聲";}
                    if (ability.equals("LongReach")){ability = "遠隔";}
                    if (ability.equals("MagicBounce")){ability = "魔法鏡";}
                    if (ability.equals("MagicGuard")){ability = "魔法防守";}
                    if (ability.equals("Magician")){ability = "魔術師";}
                    if (ability.equals("MagmaArmor")){ability = "熔岩鎧甲";}
                    if (ability.equals("MagnetPull")){ability = "磁力";}
                    if (ability.equals("MarvelScale")){ability = "神奇鱗片";}
                    if (ability.equals("MegaLauncher")){ability = "超級發射器";}
                    if (ability.equals("Merciless")){ability = "不仁不義";}
                    if (ability.equals("Mimicry")){ability = "擬態";}
                    if (ability.equals("Minus")){ability = "負電";}
                    if (ability.equals("MirrorArmor")){ability = "鏡甲";}
                    if (ability.equals("MistySurge")){ability = "薄霧製造者";}
                    if (ability.equals("MoldBreaker")){ability = "破格";}
                    if (ability.equals("Moody")){ability = "心情不定";}
                    if (ability.equals("MotorDrive")){ability = "電氣引擎";}
                    if (ability.equals("Moxie")){ability = "自信過度";}
                    if (ability.equals("Multiscale")){ability = "多重鱗片";}
                    if (ability.equals("Multitype")){ability = "多元系";}
                    if (ability.equals("Mummy")){ability = "木乃伊";}
                    if (ability.equals("NaturalCure")){ability = "自然回復";}
                    if (ability.equals("NoGuard")){ability = "無防守";}
                    if (ability.equals("Normalize")){ability = "一般皮膚";}
                    if (ability.equals("Neuroforce")){ability = "腦核之力";}
                    if (ability.equals("NeutralizingGas")){ability = "化學變化氣體";}
                    if (ability.equals("Oblivious")){ability = "遲鈍";}
                    if (ability.equals("Overcoat")){ability = "防塵";}
                    if (ability.equals("Overgrow")){ability = "茂盛";}
                    if (ability.equals("OwnTempo")){ability = "我行我素";}
                    if (ability.equals("ParentalBond")){ability = "親子愛";}
                    if (ability.equals("PastelVeil")){ability = "粉彩護幕";}
                    if (ability.equals("PerishBody")){ability = "滅亡之軀";}
                    if (ability.equals("Pickpocket")){ability = "順手牽羊";}
                    if (ability.equals("Pickup")){ability = "撿拾";}
                    if (ability.equals("Pixilate")){ability = "妖精皮膚";}
                    if (ability.equals("Plus")){ability = "正電";}
                    if (ability.equals("PoisonHeal")){ability = "毒療";}
                    if (ability.equals("PoisonPoint")){ability = "毒刺";}
                    if (ability.equals("PoisonTouch")){ability = "毒手";}
                    if (ability.equals("PowerConstruct")){ability = "群聚變形";}
                    if (ability.equals("PowerofAlchemy")){ability = "化學之力";}
                    if (ability.equals("PowerSpot")){ability = "能量點";}
                    if (ability.equals("Prankster")){ability = "惡作劇之心";}
                    if (ability.equals("Pressure")){ability = "壓迫感";}
                    if (ability.equals("PrismArmor")){ability = "稜鏡裝甲";}
                    if (ability.equals("PropellerTail")){ability = "螺旋尾鰭";}
                    if (ability.equals("Protean")){ability = "變幻自如";}
                    if (ability.equals("PsychicSurge")){ability = "精神製造者";}
                    if (ability.equals("PunkRock")){ability = "龐克搖滾";}
                    if (ability.equals("PurePower")){ability = "瑜珈神力";}
                    if (ability.equals("QueenlyMajesty")){ability = "女王的威嚴";}
                    if (ability.equals("QuickFeet")){ability = "飛毛腿";}
                    if (ability.equals("RainDish")){ability = "速擊";}
                    if (ability.equals("Rattled")){ability = "雨盤";}
                    if (ability.equals("Receiver")){ability = "膽怯";}
                    if (ability.equals("Reckless")){ability = "接球手";}
                    if (ability.equals("Refrigerate")){ability = "捨身";}
                    if (ability.equals("Regenerator")){ability = "冰凍皮膚";}
                    if (ability.equals("Ripen")){ability = "再生力";}
                    if (ability.equals("Rivalry")){ability = "熟成";}
                    if (ability.equals("RKSSystem")){ability = "鬥爭心";}
                    if (ability.equals("RockHead")){ability = "ＡＲ系統";}
                    if (ability.equals("RoughSkin")){ability = "堅硬腦袋";}
                    if (ability.equals("RunAway")){ability = "粗糙皮膚";}
                    if (ability.equals("SandForce")){ability = "逃跑";}
                    if (ability.equals("SandRush")){ability = "沙之力";}
                    if (ability.equals("SandSpit")){ability = "撥沙";}
                    if (ability.equals("SandStream")){ability = "吐沙";}
                    if (ability.equals("SandVeil")){ability = "揚沙";}
                    if (ability.equals("SapSipper")){ability = "沙隱";}
                    if (ability.equals("Schooling")){ability = "食草";}
                    if (ability.equals("Scrappy")){ability = "魚群";}
                    if (ability.equals("ScreenCleaner")){ability = "膽量";}
                    if (ability.equals("SereneGrace")){ability = "除障";}
                    if (ability.equals("ShadowShield")){ability = "天恩";}
                    if (ability.equals("ShadowTag")){ability = "幻影防守";}
                    if (ability.equals("ShedSkin")){ability = "踩影";}
                    if (ability.equals("SheerForce")){ability = "蛻皮";}
                    if (ability.equals("ShellArmor")){ability = "強行";}
                    if (ability.equals("ShieldDust")){ability = "硬殼盔甲";}
                    if (ability.equals("ShieldsDown")){ability = "鱗粉";}
                    if (ability.equals("Simple")){ability = "界限盾殼";}
                    if (ability.equals("SkillLink")){ability = "單純";}
                    if (ability.equals("SlowStart")){ability = "連續攻擊";}
                    if (ability.equals("SlushRush")){ability = "慢啟動";}
                    if (ability.equals("Sniper")){ability = "撥雪";}
                    if (ability.equals("SnowCloak")){ability = "狙擊手";}
                    if (ability.equals("SnowWarning")){ability = "雪隱";}
                    if (ability.equals("SolarPower")){ability = "降雪";}
                    if (ability.equals("SolidRock")){ability = "太陽之力";}
                    if (ability.equals("Soul-Heart")){ability = "堅硬岩石";}
                    if (ability.equals("Soundproof")){ability = "魂心";}
                    if (ability.equals("SpeedBoost")){ability = "隔音";}
                    if (ability.equals("Stakeout")){ability = "加速";}
                    if (ability.equals("Stall")){ability = "監視";}
                    if (ability.equals("Stalwart")){ability = "慢出";}
                    if (ability.equals("Stamina")){ability = "堅毅";}
                    if (ability.equals("StanceChange")){ability = "持久力";}
                    if (ability.equals("Static")){ability = "戰鬥切換";}
                    if (ability.equals("Steadfast")){ability = "靜電";}
                    if (ability.equals("SteamEngine")){ability = "不屈之心";}
                    if (ability.equals("Steelworker")){ability = "蒸汽機";}
                    if (ability.equals("SteelySpirit")){ability = "鋼能力者";}
                    if (ability.equals("Stench")){ability = "鋼之意志";}
                    if (ability.equals("StickyHold")){ability = "惡臭";}
                    if (ability.equals("StormDrain")){ability = "黏著";}
                    if (ability.equals("StrongJaw")){ability = "引水";}
                    if (ability.equals("Sturdy")){ability = "強壯之顎";}
                    if (ability.equals("SuctionCups")){ability = "結實";}
                    if (ability.equals("SuperLuck")){ability = "吸盤";}
                    if (ability.equals("SurgeSurfer")){ability = "超幸運";}
                    if (ability.equals("Swarm")){ability = "衝浪之尾";}
                    if (ability.equals("SweetVeil")){ability = "蟲之預感";}
                    if (ability.equals("SwiftSwim")){ability = "甜幕";}
                    if (ability.equals("Symbiosis")){ability = "悠游自如";}
                    if (ability.equals("Synchronize")){ability = "共生";}
                    if (ability.equals("TangledFeet")){ability = "同步";}
                    if (ability.equals("TanglingHair")){ability = "蹣跚";}
                    if (ability.equals("Technician")){ability = "捲髮";}
                    if (ability.equals("Telepathy")){ability = "技術高手";}
                    if (ability.equals("Teravolt")){ability = "心靈感應";}
                    if (ability.equals("ThickFat")){ability = "兆級電壓";}
                    if (ability.equals("TintedLens")){ability = "厚脂肪";}
                    if (ability.equals("Torrent")){ability = "有色眼鏡";}
                    if (ability.equals("ToughClaws")){ability = "激流";}
                    if (ability.equals("ToxicBoost")){ability = "硬爪";}
                    if (ability.equals("Trace")){ability = "中毒激升";}
                    if (ability.equals("Transistor")){ability = "複製";}
                    if (ability.equals("Triage")){ability = "先行治療";}
                    if (ability.equals("Truant")){ability = "懶惰";}
                    if (ability.equals("Turboblaze")){ability = "渦輪火焰";}
                    if (ability.equals("Unaware")){ability = "純樸";}
                    if (ability.equals("Unburden")){ability = "輕裝";}
                    if (ability.equals("Unnerve")){ability = "緊張感";}
                    if (ability.equals("UnseenFist")){ability = "無形拳";}
                    if (ability.equals("VictoryStar")){ability = "勝利之星";}
                    if (ability.equals("VitalSpirit")){ability = "幹勁";}
                    if (ability.equals("VoltAbsorb")){ability = "蓄電";}
                    if (ability.equals("WanderingSpirit")){ability = "遊魂";}
                    if (ability.equals("WaterAbsorb")){ability = "儲水";}
                    if (ability.equals("WaterBubble")){ability = "水泡";}
                    if (ability.equals("WaterCompaction")){ability = "遇水凝固";}
                    if (ability.equals("WaterVeil")){ability = "水幕";}
                    if (ability.equals("WeakArmor")){ability = "碎裂鎧甲";}
                    if (ability.equals("WhiteSmoke")){ability = "白色煙霧";}
                    if (ability.equals("WimpOut")){ability = "躍躍欲逃";}
                    if (ability.equals("WonderGuard")){ability = "神奇守護";}
                    if (ability.equals("WonderSkin")){ability = "奇蹟皮膚";}
                    if (ability.equals("ZenMode")){ability = "達摩模式";}
                    if (ability.equals("DeltaStream")){ability = "德爾塔氣流";}
                    if (ability.equals("DesolateLand")){ability = "終結之地";}
                    if (ability.equals("PrimordialSea")){ability = "始源之海";}
                    if (ability.equals("ComingSoon")){ability = "敬請期待！";}
                }

                AbstractItemStack itemStack = reg.getItemTypesRegistry().STAINED_HARDENED_CLAY().to();
                itemStack.setColour(colors[i]);

                //ItemStack abilityStack = ItemStack.builder().itemType(ItemTypes.STAINED_HARDENED_CLAY).build();
                //abilityStack.offer(Keys.DYE_COLOR, colors[i]);
                InvItem item = new InvItem(itemStack, "§3§l" + ability);
                int finalI = i;
                String finalAbility = ability;
                page.setItem(slots[i], item, event -> {
                    if (!shops.pokemon.getAbilityName().equalsIgnoreCase(finalAbility)) {
                        abilitySlot = finalI;
                        shops.getSelectedOptions().put(getOption(), finalAbility);
                    } else {
                        abilitySlot = 0;
                        shops.getSelectedOptions().remove(getOption());
                    }
                    builder.setSelectedItem(item.getItemStack());
                });
            }
        }
        return page;
    }

    @Override
    public int prices(Object value) {
        return (abilitySlot == 2) ? getPriceOf(ConfigKeyConstants.SPECIAL, 8000) : getPriceOf(ConfigKeyConstants.REGULAR, 750);
    }

    @Override
    protected void priceSummaries() {
        AbilityConfig config = FusionPixelmon.getInstance().getConfiguration().getAbilityConfig();
        addPriceSummary(config.AbilityNormalSummary(), getPriceOf(ConfigKeyConstants.REGULAR, 750));
        addPriceSummary(config.AbilitySpecialSummary(), getPriceOf(ConfigKeyConstants.SPECIAL, 8000));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setAbility(value.toString());
    }

    private static class ConfigKeyConstants {
        private static final String REGULAR = "一般";
        private static final String SPECIAL = "特殊";
    }
}
