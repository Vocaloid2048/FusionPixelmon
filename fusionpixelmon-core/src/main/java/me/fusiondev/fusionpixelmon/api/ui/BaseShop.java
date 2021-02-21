package me.fusiondev.fusionpixelmon.api.ui;

import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.Registry;
import me.fusiondev.fusionpixelmon.api.colour.Color;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemType;
import me.fusiondev.fusionpixelmon.api.ui.events.Event;
import me.fusiondev.fusionpixelmon.voc.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The superclass base for the shop implementations.
 */
public abstract class BaseShop {
    protected Shops shops;
    /**
     * Whether the shop/option has a custom purchase summary
     * defined using {@link #purchaseSummary(Shops.Options, Object)}.
     */
    private boolean hasPurchaseSummary;

    public boolean hasPurchaseSummary() {
        return hasPurchaseSummary;
    }

    protected BaseShop(Shops shops) {
        this(shops, false);
    }

    protected BaseShop(Shops shops, boolean hasPurchaseSummary) {
        this.shops = shops;
        this.hasPurchaseSummary = hasPurchaseSummary;
        priceSummaries();
    }

    /**
     * Method variable for getting the option of that Shop.
     *
     * @return the option of the shop.
     */
    public abstract Shops.Options getOption();

    /**
     * Builds the shop page.
     *
     * @return the shop page object.
     */
    public abstract InvPage buildPage();

    /**
     * Gets the price of the specified key from the shop config, or the specified default price if cannot.
     *
     * @param key          the config key.
     * @param defaultPrice the default price.
     * @return the price of the key from the shop config; or the defaultPrice if cant.
     */
    public int getPriceOf(String key, int defaultPrice) {
        return shops.getPriceOf(getOption(), key, defaultPrice);
    }

    /**
     * Lists and returns the amount/price the specified value costs.
     *
     * @param value the value the player has selected.
     * @return the price of the value.
     */
    public abstract int prices(Object value);

    /**
     * Generates the price summaries and adds them to the shop's item lore.
     * The {@link #addPriceSummary(String, int)} method is used to define
     * the summaries of the prices in this method.
     * This is called once in the shop's superclass constructor.
     */
    protected abstract void priceSummaries();

    /**
     * The item lore containing the price summaries of the shop.
     */
    private List<String> priceLore = new ArrayList<>();

    /**
     * Gets the price summaries lore of the shop.
     *
     * @return the price summaries lore of the shop.
     */
    public List<String> getPricesSummary() {
        return priceLore;
    }

    /**
     * Adds the specified item and its price in a pretty-formatted
     * summary to the shop's item lore.
     *
     * @param item  the selected item.
     * @param price the price of the item.
     */
    protected void addPriceSummary(String item, int price) {
        priceLore.add("  §7" + item + "§7: §a" + shops.bank.getCurrencySymbol() + price);
    }

    /**
     * Adds the specified item and its price in a pretty-formatted
     * summary to the shop's item lore.
     *
     * @param item  the selected item.
     * @param price the price of the item.
     */
    protected void addPriceSummary(String item, String price) {
        priceLore.add("  §7" + item + "§7: §a" + shops.bank.getCurrencySymbol() + price);
    }

    /**
     * This method is executed upon a successful purchase for each shop.
     *
     * @param value the value of the shop/option the player has purchased.
     */
    public abstract void purchaseAction(Object value);

    /**
     * Allows the overriding of the default purchase summary item
     * lore for this shop/option, with a custom purchase summary.
     *
     * @param key   the option the player is purchasing.
     * @param value the value the player is purchasing.
     * @return the overriding purchase summary for the shop option.
     */
    public List<String> purchaseSummary(Shops.Options key, Object value) {
        return null;
    }

    protected static final Registry REG = FusionPixelmon.getRegistry();

    /**
     * The default item to show when displaying what the player is purchasing.
     */
    public static AbstractItemType DEFAULT_SELECTED_ITEM_TYPE = REG.getItemTypesRegistry().BARRIER();
    /**
     * The item that represents an empty slot.
     */
    public static InvItem EMPTY_ITEM = new InvItem(REG.getItemTypesRegistry().STAINED_GLASS_PANE().to().setColour(DyeColor.BLACK), "");

    public static AbstractItemStack backItemStack = REG.getPixelmonUtils().getPixelmonItemStack("eject_button");
    public static AbstractItemStack resetItemStack = REG.getPixelmonUtils().getPixelmonItemStack("trash_can");
    public static AbstractItemStack infoItemStack = REG.getItemTypesRegistry().PAPER().to();

    ShopConfig config = FusionPixelmon.getInstance().getConfiguration().getShopConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    public class Builder {
        private String title;
        private String id;
        private int rows;

        private int backSlot = -1;

        private int resetSlot = -1;
//        InvItem resetItem = new InvItem(SpongeAdapter.adapt(PixelmonAPI.getPixelmonItemStack("trash_can")), "§4§lReset options");

        private int infoSlot = -1;
        //private ItemType infoItemStack = ItemTypes.PAPER;
        private InvItem infoItem;

        private int selectedSlot = -1;
        //private ItemStack selectedItemStack;
        private AbstractItemStack selectedItemStack;
        private String selectedItemName = "Selected Option";

        public Builder(String title, String id, int rows) {
            this.title = title;
            this.id = id;
            this.rows = rows;
        }

        public Builder setBackSlot(int slot) {
            this.backSlot = slot;
            return this;
        }

        private Runnable runnable;

        public Builder onReset(Runnable runnable) {
            this.runnable = runnable;
            return this;
        }

        public Builder setResetSlot(int slot) {
            this.resetSlot = slot;
            return this;
        }

        public Builder setInfoSlot(int slot) {
            this.infoSlot = slot;
            return this;
        }

        public Builder setInfoItemData(String name, String... lore) {
            infoItem = new InvItem(infoItemStack.copy(), "§3§l" + name);
            infoItem.setLore(lore);
            return this;
        }

        public Builder setSelectedSlot(int slot) {
            this.selectedSlot = slot;
            return this;
        }

        public Builder setSelectedItem(InvPage page, AbstractItemType itemType, String name, String... lore) {
            InvItem item = new InvItem(itemType, name);
            item.setLore(lore);
            page.setItem(selectedSlot, item);
            return this;
        }

        public Builder setSelectedItem(AbstractItemType itemType) {
            this.selectedItemStack = itemType.to();
            return this;
        }

        public Builder setSelectedItem(AbstractItemStack itemStack) {
            this.selectedItemStack = itemStack;
            return this;
        }

        public Builder setSelectedItemName(String name) {
            this.selectedItemName = name;
            return this;
        }

        private Shops.Options options;

        public Builder setSelectedOption(Shops.Options options) {
            this.options = options;
            return this;
        }

        private boolean hasSelected = true;

        public Builder setSelected(boolean hasSelected) {
            this.hasSelected = hasSelected;
            return this;
        }

        private boolean border;

        public Builder border(boolean border) {
            this.border = border;
            return this;
        }

        public InvPage build() {
            // todo check that rows is minimum of 2 due to right side options
            InvPage page = new InvPage("§8" + title, id, rows);
            page.getEventHandler().add(Event.CLOSE_INVENTORY, (event, player) -> {
                Shops.resetSelectedOptions(player, false);
            });


            if (border) {
                page.setItemRange(0, 8, EMPTY_ITEM);
                if (rows > 1) page.setItemRange((rows - 1) * 9, ((rows - 1) * 9) + 8, EMPTY_ITEM);
                if (rows > 2) page.setItemRange((rows - 2) * 9, ((rows - 2) * 9) + 8, EMPTY_ITEM);
            } else {
                page.setItemRange(0, 8, EMPTY_ITEM);
                if (rows > 1) page.setItemRange((rows - 1) * 9, ((rows - 1) * 9) + 8, EMPTY_ITEM);

                // Empty bars
                for (int row = 1; row <= rows - 2; row++) {
                    page.setItem((row * 9) + 1, EMPTY_ITEM);
                    page.setItem((row * 9) + 7, EMPTY_ITEM);
                }
            }


            if (backSlot == -1) {
                int row = 1;
                backSlot = ((row + 1) * 9) - 1;
            }

            InvItem backItem = new InvItem(backItemStack, "§4§l"+config.ShopBackToMenu());

            page.setItem(backSlot, backItem, event -> {
                shops.inv.openPage(shops.player, shops.SHOP_ID);//need to have changes persisted unless closed
            });

            if (resetSlot == -1) {
                int row = rows - 2;
                resetSlot = ((row + 1) * 9) - 1;
            }
            InvItem resetItem = new InvItem(resetItemStack, "§4§l"+config.ShopReset());
            page.setItem(resetSlot, resetItem, event -> {
                if (runnable != null) runnable.run();
                shops.getSelectedOptions().remove(options);
                selectedItemStack = null;
            });

            // Info Item
            if (infoSlot == -1) {
                int row = rows - 2;
                infoSlot = row * 9;
            }
            if (infoItem == null) {
                infoItem = new InvItem(infoItemStack, "§3§l"+config.ShopInfo());
            }
            page.setItem(infoSlot, infoItem);

            // Selected Item
            if (selectedSlot == -1) {
                int row = 1;
                selectedSlot = row * 9;
            }

            if (FusionPixelmon.getModule().equals("forge")) {
                InvItem selectedItem = new InvItem(DEFAULT_SELECTED_ITEM_TYPE, "§3§l" + selectedItemName);
                selectedItem.setLore(Color.DARK_GRAY + config.ShopPressRefresh());
                page.setItem(selectedSlot, selectedItem);
            }

            page.setRunnable(() -> {
                InvItem selectedItem = (selectedItemStack != null) ? new InvItem(selectedItemStack, "§3§l" + selectedItemName) : new InvItem(DEFAULT_SELECTED_ITEM_TYPE, "§3§l" + selectedItemName);
                Object value = shops.getSelectedOptions().getOrDefault(options, "N/A");
                if (value instanceof Integer) {
                    if ((int) value < 0) value = "§c" + value;
                    else value = "§a+" + value;
                }
                PokeBallConfig configPB = FusionPixelmon.getInstance().getConfiguration().getPokeBallConfig();
                GrowthConfig config = FusionPixelmon.getInstance().getConfiguration().getGrowthConfig();
                ShopConfig configR = FusionPixelmon.getInstance().getConfiguration().getShopConfig();
                if (Tconfig.Translation() == true){
                    if(value.equals("Microscopic")){value =config.GrowthMicroscopic();}
                    if(value.equals("Pygmy")){value =config.GrowthPygmy();}
                    if(value.equals("Runt")){value =config.GrowthRunt();}
                    if(value.equals("Small")){value =config.GrowthSmall();}
                    if(value.equals("Ordinary")){value =config.GrowthOrdinary();}
                    if(value.equals("Huge")){value =config.GrowthHuge();}
                    if(value.equals("Giant")){value =config.GrowthGiant();}
                    if(value.equals("Enormous")){value =config.GrowthEnormous();}
                    if(value.equals("Ginormous")){value =config.GrowthGinormous();}
                    if (value.equals("Adamant")){value ="固執";}
                    if (value.equals("Bashful")){value ="害羞";}
                    if (value.equals("Bold")){value ="大膽";}
                    if (value.equals("Brave")){value ="勇敢";}
                    if (value.equals("Calm")){value ="溫和";}
                    if (value.equals("Careful")){value ="慎重";}
                    if (value.equals("Docile")){value ="坦率";}
                    if (value.equals("Gentle")){value ="溫順";}
                    if (value.equals("Hardy")){value ="勤奮";}
                    if (value.equals("Hasty")){value ="急躁";}
                    if (value.equals("Impish")){value ="淘氣";}
                    if (value.equals("Jolly")){value ="爽朗";}
                    if (value.equals("Lax")){value ="樂天";}
                    if (value.equals("Lonely")){value ="怕寂寞";}
                    if (value.equals("Mild")){value ="慢吞吞";}
                    if (value.equals("Modest")){value ="內斂";}
                    if (value.equals("Naive")){value ="天真";}
                    if (value.equals("Naughty")){value ="頑皮";}
                    if (value.equals("Quiet")){value ="冷靜";}
                    if (value.equals("Quirky")){value ="浮躁";}
                    if (value.equals("Rash")){value ="馬虎";}
                    if (value.equals("Relaxed")){value ="悠閒";}
                    if (value.equals("Sassy")){value ="自大";}
                    if (value.equals("Serious")){value ="認真";}
                    if (value.equals("Timid")){value ="膽小";}
                    if(value.equals("PokeBall")){value =configPB.PokeBallPokeBall();}
                    if(value.equals("DreamBall")){value =configPB.PokeBallDreamBall();}
                    if(value.equals("GreatBall")){value =configPB.PokeBallGreatBall();}
                    if(value.equals("UltraBall")){value =configPB.PokeBallUltraBall();}
                    if(value.equals("MasterBall")){value =configPB.PokeBallMasterBall();}
                    if(value.equals("LevelBall")){value =configPB.PokeBallLevelBall();}
                    if(value.equals("MoonBall")){value =configPB.PokeBallMoonBall();}
                    if(value.equals("FriendBall")){value =configPB.PokeBallFriendBall();}
                    if(value.equals("LoveBall")){value =configPB.PokeBallLoveBall();}
                    if(value.equals("SafariBall")){value =configPB.PokeBallSafariBall();}
                    if(value.equals("HeavyBall")){value =configPB.PokeBallHeavyBall();}
                    if(value.equals("FastBall")){value =configPB.PokeBallFastBall();}
                    if(value.equals("RepeatBall")){value =configPB.PokeBallRepeatBall();}
                    if(value.equals("TimerBall")){value =configPB.PokeBallTimerBall();}
                    if(value.equals("NestBall")){value =configPB.PokeBallNestBall();}
                    if(value.equals("NetBall")){value =configPB.PokeBallNetBall();}
                    if(value.equals("DiveBall")){value =configPB.PokeBallDiveBall();}
                    if(value.equals("LuxuryBall")){value =configPB.PokeBallLuxuryBall();}
                    if(value.equals("HealBall")){value =configPB.PokeBallHealBall();}
                    if(value.equals("DuskBall")){value =configPB.PokeBallDuskBall();}
                    if(value.equals("ParkBall")){value =configPB.PokeBallParkBall();}
                    if(value.equals("QuickBall")){value =configPB.PokeBallQuickBall();}
                    if(value.equals("LureBall")){value =configPB.PokeBallLureBall();}
                    if(value.equals("SportBall")){value =configPB.PokeBallSportBall();}
                    if(value.equals("CherishBall")){value =configPB.PokeBallCherishBall();}
                    if(value.equals("PremierBall")){value =configPB.PokeBallPremierBall();}
                    if(value.equals("GSBall")){value =configPB.PokeBallGSBall();}
                    if(value.equals("BeastBall")){value =configPB.PokeBallBeastBall();}

                if (value.equals("Adaptvalue")){value = "適應力";}
                if (value.equals("Aerilate")){value = "飛行皮膚";}
                if (value.equals("Aftermath")){value = "引爆";}
                if (value.equals("AirLock")){value = "氣閘";}
                if (value.equals("Analytic")){value = "分析";}
                if (value.equals("AngerPoint")){value = "憤怒穴位";}
                if (value.equals("Anticipation")){value = "危險預知";}
                if (value.equals("ArenaTrap")){value = "沙穴";}
                if (value.equals("AromaVeil")){value = "芳香幕";}
                if (value.equals("AuraBreak")){value = "氣場破壞";}
                if (value.equals("BadDreams")){value = "夢魘";}
                if (value.equals("BallFetch")){value = "撿球";}
                if (value.equals("Battery")){value = "蓄電池";}
                if (value.equals("BattleArmor")){value = "戰鬥盔甲";}
                if (value.equals("BattleBond")){value = "牽絆變身";}
                if (value.equals("BeastBoost")){value = "異獸提升";}
                if (value.equals("Berserk")){value = "怒火沖天";}
                if (value.equals("BigPecks")){value = "健壯胸肌";}
                if (value.equals("Blaze")){value = "猛火";}
                if (value.equals("Bulletproof")){value = "防彈";}
                if (value.equals("CheekPouch")){value = "頰囊";}
                if (value.equals("Chlorophyll")){value = "葉綠素";}
                if (value.equals("ClearBody")){value = "恆淨之軀";}
                if (value.equals("CloudNine")){value = "無關天氣";}
                if (value.equals("ColorChange")){value = "變色";}
                if (value.equals("Comatose")){value = "絕對睡眠";}
                if (value.equals("Competitive")){value = "好勝";}
                if (value.equals("CompoundEyes")){value = "複眼";}
                if (value.equals("Contrary")){value = "唱反調";}
                if (value.equals("Corrosion")){value = "腐蝕";}
                if (value.equals("CottonDown")){value = "棉絮";}
                if (value.equals("CursedBody")){value = "詛咒之軀";}
                if (value.equals("CuteCharm")){value = "迷人之軀";}
                if (value.equals("Damp")){value = "濕氣";}
                if (value.equals("Dancer")){value = "舞者";}
                if (value.equals("DarkAura")){value = "暗黑氣場";}
                if (value.equals("DauntlessShield")){value = "不屈之盾";}
                if (value.equals("Dazzling")){value = "鮮艷之軀";}
                if (value.equals("Defeatist")){value = "軟弱";}
                if (value.equals("Defiant")){value = "不服輸";}
                if (value.equals("Disguise")){value = "畫皮";}
                if (value.equals("Download")){value = "下載";}
                if (value.equals("DragonsMaw")){value = "龍顎";}
                if (value.equals("Drizzle")){value = "降雨";}
                if (value.equals("Drought")){value = "日照";}
                if (value.equals("DrySkin")){value = "乾燥皮膚";}
                if (value.equals("EarlyBird")){value = "早起";}
                if (value.equals("EffectSpore")){value = "孢子";}
                if (value.equals("ElectricSurge")){value = "電氣製造者";}
                if (value.equals("EmergencyExit")){value = "危險迴避";}
                if (value.equals("§k?§rError§k?§r")){value = "§k?§r錯誤§k?§r";}
                if (value.equals("FairyAura")){value = "妖精氣場";}
                if (value.equals("Filter")){value = "過濾";}
                if (value.equals("FlameBody")){value = "火焰之軀";}
                if (value.equals("FlareBoost")){value = "受熱激升";}
                if (value.equals("FlashFire")){value = "引火";}
                if (value.equals("FlowerGift")){value = "花之禮";}
                if (value.equals("FlowerVeil")){value = "花幕";}
                if (value.equals("Fluffy")){value = "毛茸茸";}
                if (value.equals("Forecast")){value = "陰晴不定";}
                if (value.equals("Forewarn")){value = "預知夢";}
                if (value.equals("FriendGuard")){value = "友情防守";}
                if (value.equals("Frisk")){value = "察覺";}
                if (value.equals("FullMetalBody")){value = "金屬防護";}
                if (value.equals("FurCoat")){value = "毛皮大衣";}
                if (value.equals("GaleWings")){value = "疾風之翼";}
                if (value.equals("Galvanize")){value = "電氣皮膚";}
                if (value.equals("Gluttony")){value = "貪吃鬼";}
                if (value.equals("Gooey")){value = "黏滑";}
                if (value.equals("GorillaTactics")){value = "一猩一意";}
                if (value.equals("GrassPelt")){value = "草之毛皮";}
                if (value.equals("GrassySurge")){value = "青草製造者";}
                if (value.equals("GulpMissile")){value = "一口飛彈";}
                if (value.equals("Guts")){value = "毅力";}
                if (value.equals("Harvest")){value = "收穫";}
                if (value.equals("Healer")){value = "治癒之心";}
                if (value.equals("Heatproof")){value = "耐熱";}
                if (value.equals("HeavyMetal")){value = "重金屬";}
                if (value.equals("HoneyGather")){value = "採蜜";}
                if (value.equals("HugePower")){value = "大力士";}
                if (value.equals("HungerSwitch")){value = "飽了又餓";}
                if (value.equals("Hustle")){value = "活力";}
                if (value.equals("Hydration")){value = "濕潤之軀";}
                if (value.equals("HyperCutter")){value = "怪力鉗";}
                if (value.equals("IceBody")){value = "冰凍之軀";}
                if (value.equals("IceFace")){value = "結凍頭";}
                if (value.equals("IceScales")){value = "冰鱗粉";}
                if (value.equals("Illuminate")){value = "發光";}
                if (value.equals("Illusion")){value = "幻覺";}
                if (value.equals("Immunity")){value = "免疫";}
                if (value.equals("Imposter")){value = "變身者";}
                if (value.equals("Infiltrator")){value = "穿透";}
                if (value.equals("InnardsOut")){value = "飛出的內在物";}
                if (value.equals("InnerFocus")){value = "精神力";}
                if (value.equals("Insomnia")){value = "不眠";}
                if (value.equals("Intimidate")){value = "威嚇";}
                if (value.equals("IntrepidSword")){value = "不撓之劍";}
                if (value.equals("IronBarbs")){value = "鐵刺";}
                if (value.equals("IronFist")){value = "鐵拳";}
                if (value.equals("Justified")){value = "正義之心";}
                if (value.equals("KeenEye")){value = "銳利目光";}
                if (value.equals("Klutz")){value = "笨拙";}
                if (value.equals("LeafGuard")){value = "葉子防守";}
                if (value.equals("Levitate")){value = "飄浮";}
                if (value.equals("Libero")){value = "自由者";}
                if (value.equals("LightMetal")){value = "輕金屬";}
                if (value.equals("LightningRod")){value = "避雷針";}
                if (value.equals("Limber")){value = "柔軟";}
                if (value.equals("LiquidOoze")){value = "污泥漿";}
                if (value.equals("LiquidVoice")){value = "濕潤之聲";}
                if (value.equals("LongReach")){value = "遠隔";}
                if (value.equals("MagicBounce")){value = "魔法鏡";}
                if (value.equals("MagicGuard")){value = "魔法防守";}
                if (value.equals("Magician")){value = "魔術師";}
                if (value.equals("MagmaArmor")){value = "熔岩鎧甲";}
                if (value.equals("MagnetPull")){value = "磁力";}
                if (value.equals("MarvelScale")){value = "神奇鱗片";}
                if (value.equals("MegaLauncher")){value = "超級發射器";}
                if (value.equals("Merciless")){value = "不仁不義";}
                if (value.equals("Mimicry")){value = "擬態";}
                if (value.equals("Minus")){value = "負電";}
                if (value.equals("MirrorArmor")){value = "鏡甲";}
                if (value.equals("MistySurge")){value = "薄霧製造者";}
                if (value.equals("MoldBreaker")){value = "破格";}
                if (value.equals("Moody")){value = "心情不定";}
                if (value.equals("MotorDrive")){value = "電氣引擎";}
                if (value.equals("Moxie")){value = "自信過度";}
                if (value.equals("Multiscale")){value = "多重鱗片";}
                if (value.equals("Multitype")){value = "多元系";}
                if (value.equals("Mummy")){value = "木乃伊";}
                if (value.equals("NaturalCure")){value = "自然回復";}
                if (value.equals("NoGuard")){value = "無防守";}
                if (value.equals("Normalize")){value = "一般皮膚";}
                if (value.equals("Neuroforce")){value = "腦核之力";}
                if (value.equals("NeutralizingGas")){value = "化學變化氣體";}
                if (value.equals("Oblivious")){value = "遲鈍";}
                if (value.equals("Overcoat")){value = "防塵";}
                if (value.equals("Overgrow")){value = "茂盛";}
                if (value.equals("OwnTempo")){value = "我行我素";}
                if (value.equals("ParentalBond")){value = "親子愛";}
                if (value.equals("PastelVeil")){value = "粉彩護幕";}
                if (value.equals("PerishBody")){value = "滅亡之軀";}
                if (value.equals("Pickpocket")){value = "順手牽羊";}
                if (value.equals("Pickup")){value = "撿拾";}
                if (value.equals("Pixilate")){value = "妖精皮膚";}
                if (value.equals("Plus")){value = "正電";}
                if (value.equals("PoisonHeal")){value = "毒療";}
                if (value.equals("PoisonPoint")){value = "毒刺";}
                if (value.equals("PoisonTouch")){value = "毒手";}
                if (value.equals("PowerConstruct")){value = "群聚變形";}
                if (value.equals("PowerofAlchemy")){value = "化學之力";}
                if (value.equals("PowerSpot")){value = "能量點";}
                if (value.equals("Prankster")){value = "惡作劇之心";}
                if (value.equals("Pressure")){value = "壓迫感";}
                if (value.equals("PrismArmor")){value = "稜鏡裝甲";}
                if (value.equals("PropellerTail")){value = "螺旋尾鰭";}
                if (value.equals("Protean")){value = "變幻自如";}
                if (value.equals("PsychicSurge")){value = "精神製造者";}
                if (value.equals("PunkRock")){value = "龐克搖滾";}
                if (value.equals("PurePower")){value = "瑜珈神力";}
                if (value.equals("QueenlyMajesty")){value = "女王的威嚴";}
                if (value.equals("QuickFeet")){value = "飛毛腿";}
                if (value.equals("RainDish")){value = "速擊";}
                if (value.equals("Rattled")){value = "雨盤";}
                if (value.equals("Receiver")){value = "膽怯";}
                if (value.equals("Reckless")){value = "接球手";}
                if (value.equals("Refrigerate")){value = "捨身";}
                if (value.equals("Regenerator")){value = "冰凍皮膚";}
                if (value.equals("Ripen")){value = "再生力";}
                if (value.equals("Rivalry")){value = "熟成";}
                if (value.equals("RKSSystem")){value = "鬥爭心";}
                if (value.equals("RockHead")){value = "ＡＲ系統";}
                if (value.equals("RoughSkin")){value = "堅硬腦袋";}
                if (value.equals("RunAway")){value = "粗糙皮膚";}
                if (value.equals("SandForce")){value = "逃跑";}
                if (value.equals("SandRush")){value = "沙之力";}
                if (value.equals("SandSpit")){value = "撥沙";}
                if (value.equals("SandStream")){value = "吐沙";}
                if (value.equals("SandVeil")){value = "揚沙";}
                if (value.equals("SapSipper")){value = "沙隱";}
                if (value.equals("Schooling")){value = "食草";}
                if (value.equals("Scrappy")){value = "魚群";}
                if (value.equals("ScreenCleaner")){value = "膽量";}
                if (value.equals("SereneGrace")){value = "除障";}
                if (value.equals("ShadowShield")){value = "天恩";}
                if (value.equals("ShadowTag")){value = "幻影防守";}
                if (value.equals("ShedSkin")){value = "踩影";}
                if (value.equals("SheerForce")){value = "蛻皮";}
                if (value.equals("ShellArmor")){value = "強行";}
                if (value.equals("ShieldDust")){value = "硬殼盔甲";}
                if (value.equals("ShieldsDown")){value = "鱗粉";}
                if (value.equals("Simple")){value = "界限盾殼";}
                if (value.equals("SkillLink")){value = "單純";}
                if (value.equals("SlowStart")){value = "連續攻擊";}
                if (value.equals("SlushRush")){value = "慢啟動";}
                if (value.equals("Sniper")){value = "撥雪";}
                if (value.equals("SnowCloak")){value = "狙擊手";}
                if (value.equals("SnowWarning")){value = "雪隱";}
                if (value.equals("SolarPower")){value = "降雪";}
                if (value.equals("SolidRock")){value = "太陽之力";}
                if (value.equals("Soul-Heart")){value = "堅硬岩石";}
                if (value.equals("Soundproof")){value = "魂心";}
                if (value.equals("SpeedBoost")){value = "隔音";}
                if (value.equals("Stakeout")){value = "加速";}
                if (value.equals("Stall")){value = "監視";}
                if (value.equals("Stalwart")){value = "慢出";}
                if (value.equals("Stamina")){value = "堅毅";}
                if (value.equals("StanceChange")){value = "持久力";}
                if (value.equals("Static")){value = "戰鬥切換";}
                if (value.equals("Steadfast")){value = "靜電";}
                if (value.equals("SteamEngine")){value = "不屈之心";}
                if (value.equals("Steelworker")){value = "蒸汽機";}
                if (value.equals("SteelySpirit")){value = "鋼能力者";}
                if (value.equals("Stench")){value = "鋼之意志";}
                if (value.equals("StickyHold")){value = "惡臭";}
                if (value.equals("StormDrain")){value = "黏著";}
                if (value.equals("StrongJaw")){value = "引水";}
                if (value.equals("Sturdy")){value = "強壯之顎";}
                if (value.equals("SuctionCups")){value = "結實";}
                if (value.equals("SuperLuck")){value = "吸盤";}
                if (value.equals("SurgeSurfer")){value = "超幸運";}
                if (value.equals("Swarm")){value = "衝浪之尾";}
                if (value.equals("SweetVeil")){value = "蟲之預感";}
                if (value.equals("SwiftSwim")){value = "甜幕";}
                if (value.equals("Symbiosis")){value = "悠游自如";}
                if (value.equals("Synchronize")){value = "共生";}
                if (value.equals("TangledFeet")){value = "同步";}
                if (value.equals("TanglingHair")){value = "蹣跚";}
                if (value.equals("Technician")){value = "捲髮";}
                if (value.equals("Telepathy")){value = "技術高手";}
                if (value.equals("Teravolt")){value = "心靈感應";}
                if (value.equals("ThickFat")){value = "兆級電壓";}
                if (value.equals("TintedLens")){value = "厚脂肪";}
                if (value.equals("Torrent")){value = "有色眼鏡";}
                if (value.equals("ToughClaws")){value = "激流";}
                if (value.equals("ToxicBoost")){value = "硬爪";}
                if (value.equals("Trace")){value = "中毒激升";}
                if (value.equals("Transistor")){value = "複製";}
                if (value.equals("Triage")){value = "先行治療";}
                if (value.equals("Truant")){value = "懶惰";}
                if (value.equals("Turboblaze")){value = "渦輪火焰";}
                if (value.equals("Unaware")){value = "純樸";}
                if (value.equals("Unburden")){value = "輕裝";}
                if (value.equals("Unnerve")){value = "緊張感";}
                if (value.equals("UnseenFist")){value = "無形拳";}
                if (value.equals("VictoryStar")){value = "勝利之星";}
                if (value.equals("VitalSpirit")){value = "幹勁";}
                if (value.equals("VoltAbsorb")){value = "蓄電";}
                if (value.equals("WanderingSpirit")){value = "遊魂";}
                if (value.equals("WaterAbsorb")){value = "儲水";}
                if (value.equals("WaterBubble")){value = "水泡";}
                if (value.equals("WaterCompaction")){value = "遇水凝固";}
                if (value.equals("WaterVeil")){value = "水幕";}
                if (value.equals("WeakArmor")){value = "碎裂鎧甲";}
                if (value.equals("WhiteSmoke")){value = "白色煙霧";}
                if (value.equals("WimpOut")){value = "躍躍欲逃";}
                if (value.equals("WonderGuard")){value = "神奇守護";}
                if (value.equals("WonderSkin")){value = "奇蹟皮膚";}
                if (value.equals("ZenMode")){value = "達摩模式";}
                if (value.equals("DeltaStream")){value = "德爾塔氣流";}
                if (value.equals("DesolateLand")){value = "終結之地";}
                if (value.equals("PrimordialSea")){value = "始源之海";}
                if (value.equals("ComingSoon")){value = "敬請期待！";}
                if(value.equals("Abomasnow")){value ="暴雪王";}
                if(value.equals("Abra")){value ="凱西";}
                if(value.equals("Absol")){value ="阿勃梭魯";}
                if(value.equals("Accelgor")){value ="敏捷蟲";}
                if(value.equals("Aegislash")){value ="堅盾劍怪";}
                if(value.equals("Aerodactyl")){value ="化石翼龍";}
                if(value.equals("Aggron")){value ="波士可多拉";}
                if(value.equals("Aipom")){value ="長尾怪手";}
                if(value.equals("Alakazam")){value ="胡地";}
                if(value.equals("Alcremie")){value ="霜奶仙";}
                if(value.equals("Alomomola")){value ="保母曼波";}
                if(value.equals("Altaria")){value ="七夕青鳥";}
                if(value.equals("Amaura")){value ="冰雪龍";}
                if(value.equals("Ambipom")){value ="雙尾怪手";}
                if(value.equals("Amoonguss")){value ="敗露球菇";}
                if(value.equals("Ampharos")){value ="電龍";}
                if(value.equals("Anorith")){value ="太古羽蟲";}
                if(value.equals("Appletun")){value ="豐蜜龍";}
                if(value.equals("Applin")){value ="啃果蟲";}
                if(value.equals("Araquanid")){value ="滴蛛霸";}
                if(value.equals("Arbok")){value ="阿柏怪";}
                if(value.equals("Arcanine")){value ="風速狗";}
                if(value.equals("Arceus")){value ="阿爾宙斯";}
                if(value.equals("Archen")){value ="始祖小鳥";}
                if(value.equals("Archeops")){value ="始祖大鳥";}
                if(value.equals("Arctovish")){value ="鰓魚海獸";}
                if(value.equals("Arctozolt")){value ="雷鳥海獸";}
                if(value.equals("Ariados")){value ="阿利多斯";}
                if(value.equals("Armaldo")){value ="太古盔甲";}
                if(value.equals("Aromatisse")){value ="芳香精";}
                if(value.equals("Aron")){value ="可可多拉";}
                if(value.equals("Arrokuda")){value ="刺梭魚";}
                if(value.equals("Articuno")){value ="急凍鳥";}
                if(value.equals("Audino")){value ="差不多娃娃";}
                if(value.equals("Aurorus")){value ="冰雪巨龍";}
                if(value.equals("Avalugg")){value ="冰岩怪";}
                if(value.equals("Axew")){value ="牙牙";}
                if(value.equals("Azelf")){value ="亞克諾姆";}
                if(value.equals("Azumarill")){value ="瑪力露麗";}
                if(value.equals("Azurill")){value ="露力麗";}
                if(value.equals("Bagon")){value ="寶貝龍";}
                if(value.equals("Baltoy")){value ="天秤偶";}
                if(value.equals("Banette")){value ="詛咒娃娃";}
                if(value.equals("Barbaracle")){value ="龜足巨鎧";}
                if(value.equals("Barboach")){value ="泥泥鰍";}
                if(value.equals("Barraskewda")){value ="戽斗尖梭";}
                if(value.equals("Basculin")){value ="野蠻鱸魚";}
                if(value.equals("Bastiodon")){value ="護城龍";}
                if(value.equals("Bayleef")){value ="月桂葉";}
                if(value.equals("Beartic")){value ="凍原熊";}
                if(value.equals("Beautifly")){value ="狩獵鳳蝶";}
                if(value.equals("Beedrill")){value ="大針蜂";}
                if(value.equals("Beheeyem")){value ="大宇怪";}
                if(value.equals("Beldum")){value ="鐵啞鈴";}
                if(value.equals("Bellossom")){value ="美麗花";}
                if(value.equals("Bellsprout")){value ="喇叭芽";}
                if(value.equals("Bergmite")){value ="冰寶";}
                if(value.equals("Bewear")){value ="穿著熊";}
                if(value.equals("Bibarel")){value ="大尾狸";}
                if(value.equals("Bidoof")){value ="大牙狸";}
                if(value.equals("Binacle")){value ="龜腳腳";}
                if(value.equals("Bisharp")){value ="劈斬司令";}
                if(value.equals("Blacephalon")){value ="砰頭小丑";}
                if(value.equals("Blastoise")){value ="水箭龜";}
                if(value.equals("Blaziken")){value ="火焰雞";}
                if(value.equals("Blipbug")){value ="索偵蟲";}
                if(value.equals("Blissey")){value ="幸福蛋";}
                if(value.equals("Blitzle")){value ="斑斑馬";}
                if(value.equals("Boldore")){value ="地幔岩";}
                if(value.equals("Boltund")){value ="逐電犬";}
                if(value.equals("Bonsly")){value ="盆才怪";}
                if(value.equals("Bouffalant")){value ="爆炸頭水牛";}
                if(value.equals("Bounsweet")){value ="甜竹竹";}
                if(value.equals("Braixen")){value ="長尾火狐";}
                if(value.equals("Braviary")){value ="勇士雄鷹";}
                if(value.equals("Breloom")){value ="斗笠菇";}
                if(value.equals("Brionne")){value ="花漾海獅";}
                if(value.equals("Bronzong")){value ="青銅鐘";}
                if(value.equals("Bronzor")){value ="銅鏡怪";}
                if(value.equals("Bruxish")){value ="磨牙彩皮魚";}
                if(value.equals("Budew")){value ="含羞苞";}
                if(value.equals("Buizel")){value ="泳圈鼬";}
                if(value.equals("Bulbasaur")){value ="妙蛙種子";}
                if(value.equals("Buneary")){value ="捲捲耳";}
                if(value.equals("Bunnelby")){value ="掘掘兔";}
                if(value.equals("Burmy")){value ="結草兒";}
                if(value.equals("Butterfree")){value ="巴大蝶";}
                if(value.equals("Buzzwole")){value ="爆肌蚊";}
                if(value.equals("Cacnea")){value ="刺球仙人掌";}
                if(value.equals("Cacturne")){value ="夢歌仙人掌";}
                if(value.equals("Camerupt")){value ="噴火駝";}
                if(value.equals("Carbink")){value ="小碎鑽";}
                if(value.equals("Carkol")){value ="大炭車";}
                if(value.equals("Carnivine")){value ="尖牙籠";}
                if(value.equals("Carracosta")){value ="肋骨海龜";}
                if(value.equals("Carvanha")){value ="利牙魚";}
                if(value.equals("Cascoon")){value ="盾甲繭";}
                if(value.equals("Castform")){value ="飄浮泡泡";}
                if(value.equals("Caterpie")){value ="綠毛蟲";}
                if(value.equals("Celebi")){value ="時拉比";}
                if(value.equals("Celesteela")){value ="鐵火輝夜";}
                if(value.equals("Centiskorch")){value ="焚焰蚣";}
                if(value.equals("Chandelure")){value ="水晶燈火靈";}
                if(value.equals("Chansey")){value ="吉利蛋";}
                if(value.equals("Charizard")){value ="噴火龍";}
                if(value.equals("Charjabug")){value ="蟲電寶";}
                if(value.equals("Charmander")){value ="小火龍";}
                if(value.equals("Charmeleon")){value ="火恐龍";}
                if(value.equals("Chatot")){value ="聒噪鳥";}
                if(value.equals("Cherrim")){value ="櫻花兒";}
                if(value.equals("Cherubi")){value ="櫻花寶";}
                if(value.equals("Chesnaught")){value ="布里卡隆";}
                if(value.equals("Chespin")){value ="哈力栗";}
                if(value.equals("Chewtle")){value ="咬咬龜";}
                if(value.equals("Chikorita")){value ="菊草葉";}
                if(value.equals("Chimchar")){value ="小火焰猴";}
                if(value.equals("Chimecho")){value ="風鈴鈴";}
                if(value.equals("Chinchou")){value ="燈籠魚";}
                if(value.equals("Chingling")){value ="鈴鐺響";}
                if(value.equals("Cinccino")){value ="奇諾栗鼠";}
                if(value.equals("Cinderace")){value ="閃焰王牌";}
                if(value.equals("Clamperl")){value ="珍珠貝";}
                if(value.equals("Clauncher")){value ="鐵臂槍蝦";}
                if(value.equals("Clawitzer")){value ="鋼炮臂蝦";}
                if(value.equals("Claydol")){value ="念力土偶";}
                if(value.equals("Clefable")){value ="皮可西";}
                if(value.equals("Clefairy")){value ="皮皮";}
                if(value.equals("Cleffa")){value ="皮寶寶";}
                if(value.equals("Clobbopus")){value ="拳拳蛸";}
                if(value.equals("Cloyster")){value ="刺甲貝";}
                if(value.equals("Coalossal")){value ="巨炭山";}
                if(value.equals("Cobalion")){value ="勾帕路翁";}
                if(value.equals("Cofagrigus")){value ="死神棺";}
                if(value.equals("Combee")){value ="三蜜蜂";}
                if(value.equals("Combusken")){value ="力壯雞";}
                if(value.equals("Comfey")){value ="花療環環";}
                if(value.equals("Conkeldurr")){value ="修建老匠";}
                if(value.equals("Copperajah")){value ="大王銅象";}
                if(value.equals("Corphish")){value ="龍蝦小兵";}
                if(value.equals("Corsola")){value ="太陽珊瑚";}
                if(value.equals("Corviknight")){value ="鋼鎧鴉";}
                if(value.equals("Corvisquire")){value ="藍鴉";}
                if(value.equals("Cosmoem")){value ="科斯莫姆";}
                if(value.equals("Cosmog")){value ="科斯莫古";}
                if(value.equals("Cottonee")){value ="木棉球";}
                if(value.equals("Crabominable")){value ="好勝毛蟹";}
                if(value.equals("Crabrawler")){value ="好勝蟹";}
                if(value.equals("Cradily")){value ="搖籃百合";}
                if(value.equals("Cramorant")){value ="古月鳥";}
                if(value.equals("Cranidos")){value ="頭蓋龍";}
                if(value.equals("Crawdaunt")){value ="鐵螯龍蝦";}
                if(value.equals("Cresselia")){value ="克雷色利亞";}
                if(value.equals("Croagunk")){value ="不良蛙";}
                if(value.equals("Crobat")){value ="叉字蝠";}
                if(value.equals("Croconaw")){value ="藍鱷";}
                if(value.equals("Crustle")){value ="岩殿居蟹";}
                if(value.equals("Cryogonal")){value ="幾何雪花";}
                if(value.equals("Cubchoo")){value ="噴嚏熊";}
                if(value.equals("Cubone")){value ="卡拉卡拉";}
                if(value.equals("Cufant")){value ="銅象";}
                if(value.equals("Cursola")){value ="魔靈珊瑚";}
                if(value.equals("Cutiefly")){value ="萌虻";}
                if(value.equals("Cyndaquil")){value ="火球鼠";}
                if(value.equals("Darkrai")){value ="達克萊伊";}
                if(value.equals("Darmanitan")){value ="達摩狒狒";}
                if(value.equals("Dartrix")){value ="投羽梟";}
                if(value.equals("Darumaka")){value ="火紅不倒翁";}
                if(value.equals("Decidueye")){value ="狙射樹梟";}
                if(value.equals("Dedenne")){value ="咚咚鼠";}
                if(value.equals("Deerling")){value ="四季鹿";}
                if(value.equals("Deino")){value ="單首龍";}
                if(value.equals("Delcatty")){value ="優雅貓";}
                if(value.equals("Delibird")){value ="信使鳥";}
                if(value.equals("Delphox")){value ="妖火紅狐";}
                if(value.equals("Deoxys")){value ="代歐奇希斯";}
                if(value.equals("Dewgong")){value ="白海獅";}
                if(value.equals("Dewott")){value ="雙刃丸";}
                if(value.equals("Dewpider")){value ="滴蛛";}
                if(value.equals("Dhelmise")){value ="破破舵輪";}
                if(value.equals("Dialga")){value ="帝牙盧卡";}
                if(value.equals("Diancie")){value ="蒂安希";}
                if(value.equals("Diggersby")){value ="掘地兔";}
                if(value.equals("Diglett")){value ="地鼠";}
                if(value.equals("Ditto")){value ="百變怪";}
                if(value.equals("Dodrio")){value ="嘟嘟利";}
                if(value.equals("Doduo")){value ="嘟嘟";}
                if(value.equals("Donphan")){value ="頓甲";}
                if(value.equals("Dottler")){value ="天罩蟲";}
                if(value.equals("Doublade")){value ="雙劍鞘";}
                if(value.equals("Dracovish")){value ="鰓魚龍";}
                if(value.equals("Dracozolt")){value ="雷鳥龍";}
                if(value.equals("Dragalge")){value ="毒藻龍";}
                if(value.equals("Dragapult")){value ="多龍巴魯托";}
                if(value.equals("Dragonair")){value ="哈克龍";}
                if(value.equals("Dragonite")){value ="快龍";}
                if(value.equals("Bajan's Dragonite")){value ="Bajan的快龍";}
                if(value.equals("Drakloak")){value ="多龍奇";}
                if(value.equals("Drampa")){value ="老翁龍";}
                if(value.equals("Drapion")){value ="龍王蠍";}
                if(value.equals("Dratini")){value ="迷你龍";}
                if(value.equals("Drednaw")){value ="暴噬龜";}
                if(value.equals("Dreepy")){value ="多龍梅西亞";}
                if(value.equals("Drifblim")){value ="隨風球";}
                if(value.equals("Drifloon")){value ="飄飄球";}
                if(value.equals("Drilbur")){value ="螺釘地鼠";}
                if(value.equals("Drizzile")){value ="變澀蜥";}
                if(value.equals("Drowzee")){value ="催眠貘";}
                if(value.equals("Druddigon")){value ="赤面龍";}
                if(value.equals("Dubwool")){value ="毛毛角羊";}
                if(value.equals("Ducklett")){value ="鴨寶寶";}
                if(value.equals("Dugtrio")){value ="三地鼠";}
                if(value.equals("Dunsparce")){value ="土龍弟弟";}
                if(value.equals("Duosion")){value ="雙卵細胞球";}
                if(value.equals("Duraludon")){value ="鋁鋼龍";}
                if(value.equals("Durant")){value ="鐵蟻";}
                if(value.equals("Dusclops")){value ="彷徨夜靈";}
                if(value.equals("Dusknoir")){value ="黑夜魔靈";}
                if(value.equals("Duskull")){value ="夜巡靈";}
                if(value.equals("Dustox")){value ="毒粉蛾";}
                if(value.equals("Dwebble")){value ="石居蟹";}
                if(value.equals("Eelektrik")){value ="麻麻鰻";}
                if(value.equals("Eelektross")){value ="麻麻鰻魚王";}
                if(value.equals("Eevee")){value ="伊布";}
                if(value.equals("Ghostwolf's Eevee")){value ="Ghostwolf的伊布";}
                if(value.equals("Eiscue")){value ="冰砌鵝";}
                if(value.equals("Ekans")){value ="阿柏蛇";}
                if(value.equals("Eldegoss")){value ="白蓬蓬";}
                if(value.equals("Electabuzz")){value ="電擊獸";}
                if(value.equals("Electivire")){value ="電擊魔獸";}
                if(value.equals("Electrike")){value ="落雷獸";}
                if(value.equals("Electrode")){value ="頑皮雷彈";}
                if(value.equals("Elekid")){value ="電擊怪";}
                if(value.equals("Elgyem")){value ="小灰怪";}
                if(value.equals("Emboar")){value ="炎武王";}
                if(value.equals("Emolga")){value ="電飛鼠";}
                if(value.equals("Empoleon")){value ="帝王拿波";}
                if(value.equals("Entei")){value ="炎帝";}
                if(value.equals("Escavalier")){value ="騎士蝸牛";}
                if(value.equals("Espeon")){value ="太陽伊布";}
                if(value.equals("Espurr")){value ="妙喵";}
                if(value.equals("Eternatus")){value ="無極汰那";}
                if(value.equals("Excadrill")){value ="龍頭地鼠";}
                if(value.equals("Exeggcute")){value ="蛋蛋";}
                if(value.equals("Exeggutor")){value ="椰蛋樹";}
                if(value.equals("Exploud")){value ="爆音怪";}
                if(value.equals("Falinks")){value ="列陣兵";}
                if(value.equals("Farfetch'd")){value ="大蔥鴨";}
                if(value.equals("Fearow")){value ="大嘴雀";}
                if(value.equals("Feebas")){value ="醜醜魚";}
                if(value.equals("Fennekin")){value ="火狐狸";}
                if(value.equals("Feraligatr")){value ="大力鱷";}
                if(value.equals("Ferroseed")){value ="種子鐵球";}
                if(value.equals("Ferrothorn")){value ="堅果啞鈴";}
                if(value.equals("Finneon")){value ="螢光魚";}
                if(value.equals("Flaaffy")){value ="茸茸羊";}
                if(value.equals("Flabébé")){value ="花蓓蓓";}
                if(value.equals("Flapple")){value ="蘋裹龍";}
                if(value.equals("Flareon")){value ="火伊布";}
                if(value.equals("Fletchinder")){value ="火箭雀";}
                if(value.equals("Fletchling")){value ="小箭雀";}
                if(value.equals("Floatzel")){value ="浮潛鼬";}
                if(value.equals("Floette")){value ="花葉蒂";}
                if(value.equals("Florges")){value ="花潔夫人";}
                if(value.equals("Flygon")){value ="沙漠蜻蜓";}
                if(value.equals("Fomantis")){value ="偽螳草";}
                if(value.equals("Foongus")){value ="哎呀球菇";}
                if(value.equals("Forretress")){value ="佛烈托斯";}
                if(value.equals("Fraxure")){value ="斧牙龍";}
                if(value.equals("Frillish")){value ="輕飄飄";}
                if(value.equals("Froakie")){value ="呱呱泡蛙";}
                if(value.equals("Frogadier")){value ="呱頭蛙";}
                if(value.equals("Froslass")){value ="雪妖女";}
                if(value.equals("Frosmoth")){value ="雪絨蛾";}
                if(value.equals("Furfrou")){value ="多麗米亞";}
                if(value.equals("Furret")){value ="大尾立";}
                if(value.equals("Gabite")){value ="尖牙陸鯊";}
                if(value.equals("Gallade")){value ="艾路雷朵";}
                if(value.equals("Galvantula")){value ="電蜘蛛";}
                if(value.equals("Garbodor")){value ="灰塵山";}
                if(value.equals("Garchomp")){value ="烈咬陸鯊";}
                if(value.equals("Gardevoir")){value ="沙奈朵";}
                if(value.equals("Gastly")){value ="鬼斯";}
                if(value.equals("Gastrodon")){value ="海兔獸";}
                if(value.equals("Genesect")){value ="蓋諾賽克特";}
                if(value.equals("Gengar")){value ="耿鬼";}
                if(value.equals("Geodude")){value ="小拳石";}
                if(value.equals("Gible")){value ="圓陸鯊";}
                if(value.equals("Gigalith")){value ="龐岩怪";}
                if(value.equals("Girafarig")){value ="麒麟奇";}
                if(value.equals("Giratina")){value ="騎拉帝納";}
                if(value.equals("Glaceon")){value ="冰伊布";}
                if(value.equals("Glalie")){value ="冰鬼護";}
                if(value.equals("Glameow")){value ="魅力喵";}
                if(value.equals("Gligar")){value ="天蠍";}
                if(value.equals("Gliscor")){value ="天蠍王";}
                if(value.equals("Gloom")){value ="臭臭花";}
                if(value.equals("Gogoat")){value ="坐騎山羊";}
                if(value.equals("Golbat")){value ="大嘴蝠";}
                if(value.equals("Goldeen")){value ="角金魚";}
                if(value.equals("Golduck")){value ="哥達鴨";}
                if(value.equals("Golem")){value ="隆隆岩";}
                if(value.equals("Golett")){value ="泥偶小人";}
                if(value.equals("Golisopod")){value ="具甲武者";}
                if(value.equals("Golurk")){value ="泥偶巨人";}
                if(value.equals("Goodra")){value ="黏美龍";}
                if(value.equals("Goomy")){value ="黏黏寶";}
                if(value.equals("Gorebyss")){value ="櫻花魚";}
                if(value.equals("Gossifleur")){value ="幼棉棉";}
                if(value.equals("Gothita")){value ="哥德寶寶";}
                if(value.equals("Gothitelle")){value ="哥德小姐";}
                if(value.equals("Gothorita")){value ="哥德小童";}
                if(value.equals("Gourgeist")){value ="南瓜怪人";}
                if(value.equals("Granbull")){value ="布魯皇";}
                if(value.equals("Grapploct")){value ="八爪武師";}
                if(value.equals("Graveler")){value ="隆隆石";}
                if(value.equals("Greedent")){value ="藏飽栗鼠";}
                if(value.equals("Greninja")){value ="甲賀忍蛙";}
                if(value.equals("Grimer")){value ="臭泥";}
                if(value.equals("Grimmsnarl")){value ="長毛巨魔";}
                if(value.equals("Grookey")){value ="敲音猴";}
                if(value.equals("Grotle")){value ="樹林龜";}
                if(value.equals("Groudon")){value ="固拉多";}
                if(value.equals("Grovyle")){value ="森林蜥蜴";}
                if(value.equals("Growlithe")){value ="卡蒂狗";}
                if(value.equals("Grubbin")){value ="強顎雞母蟲";}
                if(value.equals("Grumpig")){value ="噗噗豬";}
                if(value.equals("Gulpin")){value ="溶食獸";}
                if(value.equals("Gumshoos")){value ="貓鼬探長";}
                if(value.equals("Gurdurr")){value ="鐵骨土人";}
                if(value.equals("Guzzlord")){value ="惡食大王";}
                if(value.equals("Gyarados")){value ="暴鯉龍";}
                if(value.equals("Hakamo-o")){value ="鱗甲龍";}
                if(value.equals("Happiny")){value ="小福蛋";}
                if(value.equals("Hariyama")){value ="鐵掌力士";}
                if(value.equals("Hatenna")){value ="迷布莉姆";}
                if(value.equals("Hatterene")){value ="布莉姆溫";}
                if(value.equals("Hattrem")){value ="提布莉姆";}
                if(value.equals("Haunter")){value ="鬼斯通";}
                if(value.equals("Hawlucha")){value ="摔角鷹人";}
                if(value.equals("Haxorus")){value ="雙斧戰龍";}
                if(value.equals("Heatmor")){value ="熔蟻獸";}
                if(value.equals("Heatran")){value ="席多藍恩";}
                if(value.equals("Heliolisk")){value ="光電傘蜥";}
                if(value.equals("Helioptile")){value ="傘電蜥";}
                if(value.equals("Heracross")){value ="赫拉克羅斯";}
                if(value.equals("Herdier")){value ="哈約克";}
                if(value.equals("Hippopotas")){value ="沙河馬";}
                if(value.equals("Hippowdon")){value ="河馬獸";}
                if(value.equals("Hitmonchan")){value ="快拳郎";}
                if(value.equals("Hitmonlee")){value ="飛腿郎";}
                if(value.equals("Hitmontop")){value ="戰舞郎";}
                if(value.equals("Ho-Oh")){value ="鳳王";}
                if(value.equals("Honchkrow")){value ="烏鴉頭頭";}
                if(value.equals("Honedge")){value ="獨劍鞘";}
                if(value.equals("Hoopa")){value ="胡帕";}
                if(value.equals("Hoothoot")){value ="咕咕";}
                if(value.equals("Hoppip")){value ="毽子草";}
                if(value.equals("Horsea")){value ="墨海馬";}
                if(value.equals("Houndoom")){value ="黑魯加";}
                if(value.equals("Houndour")){value ="戴魯比";}
                if(value.equals("Huntail")){value ="獵斑魚";}
                if(value.equals("Hydreigon")){value ="三首惡龍";}
                if(value.equals("Hypno")){value ="引夢貘人";}
                if(value.equals("Igglybuff")){value ="寶寶丁";}
                if(value.equals("Illumise")){value ="甜甜螢";}
                if(value.equals("Impidimp")){value ="搗蛋小妖";}
                if(value.equals("Incineroar")){value ="熾焰咆哮虎";}
                if(value.equals("Indeedee")){value ="愛管侍";}
                if(value.equals("Infernape")){value ="烈焰猴";}
                if(value.equals("Inkay")){value ="好啦魷";}
                if(value.equals("Inteleon")){value ="千面避役";}
                if(value.equals("Ivysaur")){value ="妙蛙草";}
                if(value.equals("Jangmo-o")){value ="心鱗寶";}
                if(value.equals("Jellicent")){value ="胖嘟嘟";}
                if(value.equals("Jigglypuff")){value ="胖丁";}
                if(value.equals("Jirachi")){value ="基拉祈";}
                if(value.equals("Jolteon")){value ="雷伊布";}
                if(value.equals("Joltik")){value ="電電蟲";}
                if(value.equals("Jumpluff")){value ="毽子棉";}
                if(value.equals("Jynx")){value ="迷唇姐";}
                if(value.equals("Kabuto")){value ="化石盔";}
                if(value.equals("Kabutops")){value ="鐮刀盔";}
                if(value.equals("Kadabra")){value ="勇基拉";}
                if(value.equals("Kakuna")){value ="鐵殼蛹";}
                if(value.equals("Kangaskhan")){value ="袋獸";}
                if(value.equals("Karrablast")){value ="蓋蓋蟲";}
                if(value.equals("Kartana")){value ="紙御劍";}
                if(value.equals("Kecleon")){value ="變隱龍";}
                if(value.equals("Keldeo")){value ="凱路迪歐";}
                if(value.equals("Kingdra")){value ="刺龍王";}
                if(value.equals("Kingler")){value ="巨鉗蟹";}
                if(value.equals("Kirlia")){value ="奇魯莉安";}
                if(value.equals("Klang")){value ="齒輪組";}
                if(value.equals("Klefki")){value ="鑰圈兒";}
                if(value.equals("Klink")){value ="齒輪兒";}
                if(value.equals("Klinklang")){value ="齒輪怪";}
                if(value.equals("Koffing")){value ="瓦斯彈";}
                if(value.equals("Komala")){value ="樹枕尾熊";}
                if(value.equals("Kommo-o")){value ="杖尾鱗甲龍";}
                if(value.equals("Krabby")){value ="大鉗蟹";}
                if(value.equals("Kricketot")){value ="圓法師";}
                if(value.equals("Kricketune")){value ="音箱蟀";}
                if(value.equals("Krokorok")){value ="混混鱷";}
                if(value.equals("Krookodile")){value ="流氓鱷";}
                if(value.equals("Kyogre")){value ="蓋歐卡";}
                if(value.equals("Kyurem")){value ="酋雷姆";}
                if(value.equals("Lairon")){value ="可多拉";}
                if(value.equals("Lampent")){value ="燈火幽靈";}
                if(value.equals("Landorus")){value ="土地雲";}
                if(value.equals("Lanturn")){value ="電燈怪";}
                if(value.equals("Lapras")){value ="拉普拉斯";}
                if(value.equals("Larvesta")){value ="燃燒蟲";}
                if(value.equals("Larvitar")){value ="幼基拉斯";}
                if(value.equals("Latias")){value ="拉帝亞斯";}
                if(value.equals("Latios")){value ="拉帝歐斯";}
                if(value.equals("Leafeon")){value ="葉伊布";}
                if(value.equals("Leavanny")){value ="保母蟲";}
                if(value.equals("Ledian")){value ="安瓢蟲";}
                if(value.equals("Ledyba")){value ="芭瓢蟲";}
                if(value.equals("Lickilicky")){value ="大舌舔";}
                if(value.equals("Lickitung")){value ="大舌頭";}
                if(value.equals("Liepard")){value ="酷豹";}
                if(value.equals("Lileep")){value ="觸手百合";}
                if(value.equals("Lilligant")){value ="裙兒小姐";}
                if(value.equals("Lillipup")){value ="小約克";}
                if(value.equals("Linoone")){value ="直衝熊";}
                if(value.equals("Litleo")){value ="小獅獅";}
                if(value.equals("Litten")){value ="火斑喵";}
                if(value.equals("Litwick")){value ="燭光靈";}
                if(value.equals("Lombre")){value ="蓮帽小童";}
                if(value.equals("Lopunny")){value ="長耳兔";}
                if(value.equals("Lotad")){value ="蓮葉童子";}
                if(value.equals("Loudred")){value ="吼爆彈";}
                if(value.equals("Lucario")){value ="路卡利歐";}
                if(value.equals("Ludicolo")){value ="樂天河童";}
                if(value.equals("Lugia")){value ="洛奇亞";}
                if(value.equals("Lumineon")){value ="霓虹魚";}
                if(value.equals("Lunala")){value ="露奈雅拉";}
                if(value.equals("Lunatone")){value ="月石";}
                if(value.equals("Lurantis")){value ="蘭螳花";}
                if(value.equals("Luvdisc")){value ="愛心魚";}
                if(value.equals("Luxio")){value ="勒克貓";}
                if(value.equals("Luxray")){value ="倫琴貓";}
                if(value.equals("Lycanroc")){value ="鬃岩狼人";}
                if(value.equals("Machamp")){value ="怪力";}
                if(value.equals("Machoke")){value ="豪力";}
                if(value.equals("Machop")){value ="腕力";}
                if(value.equals("Magby")){value ="鴨嘴寶寶";}
                if(value.equals("Magcargo")){value ="熔岩蝸牛";}
                if(value.equals("Magearna")){value ="瑪機雅娜";}
                if(value.equals("Magikarp")){value ="鯉魚王";}
                if(value.equals("Magmar")){value ="鴨嘴火獸";}
                if(value.equals("Magmortar")){value ="鴨嘴炎獸";}
                if(value.equals("Magnemite")){value ="小磁怪";}
                if(value.equals("Magneton")){value ="三合一磁怪";}
                if(value.equals("Magnezone")){value ="自爆磁怪";}
                if(value.equals("Makuhita")){value ="幕下力士";}
                if(value.equals("Malamar")){value ="烏賊王";}
                if(value.equals("Mamoswine")){value ="象牙豬";}
                if(value.equals("Manaphy")){value ="瑪納霏";}
                if(value.equals("Mandibuzz")){value ="禿鷹娜";}
                if(value.equals("Manectric")){value ="雷電獸";}
                if(value.equals("Mankey")){value ="猴怪";}
                if(value.equals("Mantine")){value ="巨翅飛魚";}
                if(value.equals("Mantyke")){value ="小球飛魚";}
                if(value.equals("Maractus")){value ="沙鈴仙人掌";}
                if(value.equals("Mareanie")){value ="好壞星";}
                if(value.equals("Mareep")){value ="咩利羊";}
                if(value.equals("Marill")){value ="瑪力露";}
                if(value.equals("Marowak")){value ="嘎啦嘎啦";}
                if(value.equals("Marshadow")){value ="瑪夏多";}
                if(value.equals("Marshtomp")){value ="沼躍魚";}
                if(value.equals("Masquerain")){value ="雨翅蛾";}
                if(value.equals("Mawile")){value ="大嘴娃";}
                if(value.equals("Medicham")){value ="恰雷姆";}
                if(value.equals("Meditite")){value ="瑪沙那";}
                if(value.equals("Meganium")){value ="大竺葵";}
                if(value.equals("Melmetal")){value ="美錄梅塔";}
                if(value.equals("Meloetta")){value ="美洛耶塔";}
                if(value.equals("Meltan")){value ="美錄坦";}
                if(value.equals("Meowstic")){value ="超能妙喵";}
                if(value.equals("Meowth")){value ="喵喵";}
                if(value.equals("Mesprit")){value ="艾姆利多";}
                if(value.equals("Metagross")){value ="巨金怪";}
                if(value.equals("Metang")){value ="金屬怪";}
                if(value.equals("Metapod")){value ="鐵甲蛹";}
                if(value.equals("Mew")){value ="夢幻";}
                if(value.equals("Mewtwo")){value ="超夢";}
                if(value.equals("Slyfox's Mewtwo")){value ="Slyfox的超夢";}
                if(value.equals("Mienfoo")){value ="功夫鼬";}
                if(value.equals("Mienshao")){value ="師父鼬";}
                if(value.equals("Mightyena")){value ="大狼犬";}
                if(value.equals("Milcery")){value ="小仙奶";}
                if(value.equals("Milotic")){value ="美納斯";}
                if(value.equals("Miltank")){value ="大奶罐";}
                if(value.equals("Mime Jr.")){value ="魔尼尼";}
                if(value.equals("Mimikyu")){value ="謎擬Ｑ";}
                if(value.equals("Minccino")){value ="泡沫栗鼠";}
                if(value.equals("Minior")){value ="小隕星";}
                if(value.equals("Minun")){value ="負電拍拍";}
                if(value.equals("Misdreavus")){value ="夢妖";}
                if(value.equals("Mismagius")){value ="夢妖魔";}
                if(value.equals("MissingNo")){value ="缺少";}
                if(value.equals("Moltres")){value ="火焰鳥";}
                if(value.equals("Monferno")){value ="猛火猴";}
                if(value.equals("Morelull")){value ="睡睡菇";}
                if(value.equals("Morgrem")){value ="詐唬魔";}
                if(value.equals("Morpeko")){value ="莫魯貝可";}
                if(value.equals("Mothim")){value ="紳士蛾";}
                if(value.equals("Mr. Mime")){value ="魔牆人偶";}
                if(value.equals("Mr. Rime")){value ="踏冰人偶";}
                if(value.equals("Mudbray")){value ="泥驢仔";}
                if(value.equals("Mudkip")){value ="水躍魚";}
                if(value.equals("Mudsdale")){value ="重泥挽馬";}
                if(value.equals("Muk")){value ="臭臭泥";}
                if(value.equals("Munchlax")){value ="小卡比獸";}
                if(value.equals("Munna")){value ="食夢夢";}
                if(value.equals("Murkrow")){value ="黑暗鴉";}
                if(value.equals("Musharna")){value ="夢夢蝕";}
                if(value.equals("Naganadel")){value ="四顎針龍";}
                if(value.equals("Natu")){value ="天然雀";}
                if(value.equals("Necrozma")){value ="奈克洛茲瑪";}
                if(value.equals("Nickit")){value ="偷兒狐";}
                if(value.equals("Nidoking")){value ="尼多王";}
                if(value.equals("Nidoqueen")){value ="尼多后";}
                if(value.equals("Nidoran♀")){value ="尼多蘭";}
                if(value.equals("Nidoran♂")){value ="尼多朗";}
                if(value.equals("Nidorina")){value ="尼多娜";}
                if(value.equals("Nidorino")){value ="尼多力諾";}
                if(value.equals("Nihilego")){value ="虛吾伊德";}
                if(value.equals("Nincada")){value ="土居忍士";}
                if(value.equals("Ninetales")){value ="九尾";}
                if(value.equals("Ninjask")){value ="鐵面忍者";}
                if(value.equals("Noctowl")){value ="貓頭夜鷹";}
                if(value.equals("Noibat")){value ="嗡蝠";}
                if(value.equals("Noivern")){value ="音波龍";}
                if(value.equals("Nosepass")){value ="朝北鼻";}
                if(value.equals("Numel")){value ="呆火駝";}
                if(value.equals("Nuzleaf")){value ="長鼻葉";}
                if(value.equals("Obstagoon")){value ="堵攔熊";}
                if(value.equals("Octillery")){value ="章魚桶";}
                if(value.equals("Oddish")){value ="走路草";}
                if(value.equals("Omanyte")){value ="菊石獸";}
                if(value.equals("Omastar")){value ="多刺菊石獸";}
                if(value.equals("Onix")){value ="大岩蛇";}
                if(value.equals("Oranguru")){value ="智揮猩";}
                if(value.equals("Orbeetle")){value ="以歐路普";}
                if(value.equals("Oricorio")){value ="花舞鳥";}
                if(value.equals("Oshawott")){value ="水水獺";}
                if(value.equals("Pachirisu")){value ="帕奇利茲";}
                if(value.equals("Palkia")){value ="帕路奇亞";}
                if(value.equals("Palossand")){value ="噬沙堡爺";}
                if(value.equals("Palpitoad")){value ="藍蟾蜍";}
                if(value.equals("Pancham")){value ="頑皮熊貓";}
                if(value.equals("Pangoro")){value ="流氓熊貓";}
                if(value.equals("Panpour")){value ="冷水猴";}
                if(value.equals("Pansage")){value ="花椰猴";}
                if(value.equals("Pansear")){value ="爆香猴";}
                if(value.equals("Paras")){value ="派拉斯";}
                if(value.equals("Parasect")){value ="派拉斯特";}
                if(value.equals("Passimian")){value ="投擲猴";}
                if(value.equals("Patrat")){value ="探探鼠";}
                if(value.equals("Pawniard")){value ="駒刀小兵";}
                if(value.equals("Pelipper")){value ="大嘴鷗";}
                if(value.equals("Perrserker")){value ="喵頭目";}
                if(value.equals("Persian")){value ="貓老大";}
                if(value.equals("Petilil")){value ="百合根娃娃";}
                if(value.equals("Phanpy")){value ="小小象";}
                if(value.equals("Phantump")){value ="小木靈";}
                if(value.equals("Pheromosa")){value ="費洛美螂";}
                if(value.equals("Phione")){value ="霏歐納";}
                if(value.equals("Pichu")){value ="皮丘";}
                if(value.equals("Pidgeot")){value ="大比鳥";}
                if(value.equals("Pidgeotto")){value ="比比鳥";}
                if(value.equals("Pidgey")){value ="波波";}
                if(value.equals("Pidove")){value ="豆豆鴿";}
                if(value.equals("Pignite")){value ="炒炒豬     ";}
                if(value.equals("Pikachu")){value ="皮卡丘";}
                if(value.equals("Pikipek")){value ="小篤兒";}
                if(value.equals("Piloswine")){value ="長毛豬";}
                if(value.equals("Pincurchin")){value ="啪嚓海膽";}
                if(value.equals("Pineco")){value ="榛果球";}
                if(value.equals("Pinsir")){value ="凱羅斯";}
                if(value.equals("Piplup")){value ="波加曼";}
                if(value.equals("Plusle")){value ="正電拍拍";}
                if(value.equals("Poipole")){value ="毒貝比";}
                if(value.equals("Politoed")){value ="蚊香蛙皇";}
                if(value.equals("Poliwag")){value ="蚊香蝌蚪";}
                if(value.equals("Poliwhirl")){value ="蚊香君";}
                if(value.equals("Poliwrath")){value ="蚊香泳士";}
                if(value.equals("Polteageist")){value ="怖思壺";}
                if(value.equals("Ponyta")){value ="小火馬";}
                if(value.equals("Poochyena")){value ="土狼犬";}
                if(value.equals("Popplio")){value ="球球海獅";}
                if(value.equals("Porygon-Z")){value ="多邊獸Z";}
                if(value.equals("Jerome's Porygon")){value ="Jerome的多邊獸";}
                if(value.equals("Porygon")){value ="多邊獸";}
                if(value.equals("Porygon2")){value ="多邊獸II";}
                if(value.equals("Primarina")){value ="西獅海壬";}
                if(value.equals("Primeape")){value ="火爆猴";}
                if(value.equals("Prinplup")){value ="波皇子";}
                if(value.equals("Probopass")){value ="大朝北鼻";}
                if(value.equals("Psyduck")){value ="可達鴨";}
                if(value.equals("Pumpkaboo")){value ="南瓜精";}
                if(value.equals("Pupitar")){value ="沙基拉斯";}
                if(value.equals("Purrloin")){value ="扒手貓";}
                if(value.equals("Purugly")){value ="東施喵";}
                if(value.equals("Pyroar")){value ="火炎獅";}
                if(value.equals("Pyukumuku")){value ="拳海參";}
                if(value.equals("Quagsire")){value ="沼王";}
                if(value.equals("Quilava")){value ="火岩鼠";}
                if(value.equals("Quilladin")){value ="胖胖哈力";}
                if(value.equals("Qwilfish")){value ="千針魚";}
                if(value.equals("Raboot")){value ="騰蹴小將";}
                if(value.equals("Raichu")){value ="雷丘";}
                if(value.equals("Raikou")){value ="雷公";}
                if(value.equals("Ralts")){value ="拉魯拉絲";}
                if(value.equals("Rampardos")){value ="戰槌龍";}
                if(value.equals("Rapidash")){value ="烈焰馬";}
                if(value.equals("Raticate")){value ="拉達";}
                if(value.equals("Rattata")){value ="小拉達";}
                if(value.equals("Rayquaza")){value ="烈空坐";}
                if(value.equals("Regice")){value ="雷吉艾斯";}
                if(value.equals("Regigigas")){value ="雷吉奇卡斯";}
                if(value.equals("Regirock")){value ="雷吉洛克";}
                if(value.equals("Registeel")){value ="雷吉斯奇魯";}
                if(value.equals("Relicanth")){value ="古空棘魚";}
                if(value.equals("Remoraid")){value ="鐵炮魚";}
                if(value.equals("Reshiram")){value ="萊希拉姆";}
                if(value.equals("Reuniclus")){value ="人造細胞卵";}
                if(value.equals("Regidrago")){value ="雷吉鐸拉戈";}
                if(value.equals("Regieleki")){value ="鑽角犀獸";}
                if(value.equals("Rhydon")){value ="獨角犀牛";}
                if(value.equals("Rhyhorn")){value ="超甲狂犀";}
                if(value.equals("Rhyperior")){value ="蝶結萌虻";}
                if(value.equals("Ribombee")){value ="轟擂金剛猩";}
                if(value.equals("Rillaboom")){value ="利歐路";}
                if(value.equals("Riolu")){value ="岩狗狗";}
                if(value.equals("Rockruff")){value ="石丸子";}
                if(value.equals("Roggenrola")){value ="小炭仔";}
                if(value.equals("Rolycoly")){value ="稚山雀";}
                if(value.equals("Rookidee")){value ="毒薔薇";}
                if(value.equals("Roselia")){value ="羅絲雷朵";}
                if(value.equals("Roserade")){value ="洛托姆";}
                if(value.equals("Rotom")){value ="木木梟";}
                if(value.equals("Rowlet")){value ="毛頭小鷹";}
                if(value.equals("Rufflet")){value ="死神板";}
                if(value.equals("Runerigus")){value ="勾魂眼";}
                if(value.equals("Sableye")){value ="暴飛龍";}
                if(value.equals("Salamence")){value ="夜盜火蜥";}
                if(value.equals("Salandit")){value ="焰后蜥";}
                if(value.equals("Salazzle")){value ="大劍鬼";}
                if(value.equals("Samurott")){value ="沙螺蟒";}
                if(value.equals("Sandaconda")){value ="黑眼鱷";}
                if(value.equals("Sandile")){value ="穿山鼠";}
                if(value.equals("Sandshrew")){value ="穿山王";}
                if(value.equals("Sandslash")){value ="沙丘娃";}
                if(value.equals("Sandygast")){value ="打擊鬼";}
                if(value.equals("Sawk")){value ="萌芽鹿";}
                if(value.equals("Sawsbuck")){value ="粉蝶蟲";}
                if(value.equals("Scatterbug")){value ="蜥蜴王";}
                if(value.equals("Sceptile")){value ="巨鉗螳螂";}
                if(value.equals("Scizor")){value ="蜈蚣王";}
                if(value.equals("Scolipede")){value ="炎兔兒";}
                if(value.equals("Scorbunny")){value ="頭巾混混";}
                if(value.equals("Scrafty")){value ="滑滑小子";}
                if(value.equals("Scraggy")){value ="飛天螳螂";}
                if(value.equals("Scyther")){value ="海刺龍";}
                if(value.equals("Seadra")){value ="金魚王";}
                if(value.equals("Seaking")){value ="海魔獅";}
                if(value.equals("Sealeo")){value ="橡實果";}
                if(value.equals("Seedot")){value ="小海獅";}
                if(value.equals("Seel")){value ="蟾蜍王";}
                if(value.equals("Seismitoad")){value ="尾立";}
                if(value.equals("Sentret")){value ="Pixeldip的尾立";}
                if(value.equals("Pixeldip's Sentret")){value ="君主蛇";}
                if(value.equals("Serperior")){value ="青藤蛇";}
                if(value.equals("Servine")){value ="飯匙蛇";}
                if(value.equals("Seviper")){value ="蟲寶包";}
                if(value.equals("Sewaddle")){value ="巨牙鯊";}
                if(value.equals("Sharpedo")){value ="謝米";}
                if(value.equals("Shaymin")){value ="脫殼忍者";}
                if(value.equals("Shedinja")){value ="甲殼龍";}
                if(value.equals("Shelgon")){value ="大舌貝";}
                if(value.equals("Shellder")){value ="無殼海兔";}
                if(value.equals("Shellos")){value ="小嘴蝸";}
                if(value.equals("Shelmet")){value ="盾甲龍";}
                if(value.equals("Shieldon")){value ="狡猾天狗";}
                if(value.equals("Shiftry")){value ="燈罩夜菇";}
                if(value.equals("Shiinotic")){value ="小貓怪";}
                if(value.equals("Shinx")){value ="蘑蘑菇";}
                if(value.equals("Shroomish")){value ="壺壺";}
                if(value.equals("Shuckle")){value ="怨影娃娃";}
                if(value.equals("Shuppet")){value ="象徵鳥";}
                if(value.equals("Sigilyph")){value ="甲殼繭";}
                if(value.equals("Silcoon")){value ="沙包蛇";}
                if(value.equals("Silicobra")){value ="銀伴戰獸";}
                if(value.equals("Silvally")){value ="冷水猿";}
                if(value.equals("Simipour")){value ="花椰猿";}
                if(value.equals("Simisage")){value ="爆香猿";}
                if(value.equals("Simisear")){value ="來悲茶";}
                if(value.equals("Sinistea")){value ="蔥遊兵";}
                if(value.equals("Sirfetch'd")){value ="燒火蚣";}
                if(value.equals("Sizzlipede")){value ="盔甲鳥";}
                if(value.equals("Skarmory")){value ="坐騎小羊";}
                if(value.equals("Skiddo")){value ="毽子花";}
                if(value.equals("Skiploom")){value ="向尾喵";}
                if(value.equals("Skitty")){value ="鉗尾蠍";}
                if(value.equals("Skorupi")){value ="垃垃藻";}
                if(value.equals("Skrelp")){value ="坦克臭鼬";}
                if(value.equals("Skuntank")){value ="貪心栗鼠";}
                if(value.equals("Skwovet")){value ="請假王";}
                if(value.equals("Slaking")){value ="懶人獺";}
                if(value.equals("Slakoth")){value ="黏美兒";}
                if(value.equals("Sliggoo")){value ="呆殼獸";}
                if(value.equals("Slowbro")){value ="呆呆王";}
                if(value.equals("Slowking")){value ="呆呆獸";}
                if(value.equals("Slowpoke")){value ="熔岩蟲";}
                if(value.equals("Slugma")){value ="胖甜妮";}
                if(value.equals("Slurpuff")){value ="圖圖犬";}
                if(value.equals("Smeargle")){value ="迷唇娃";}
                if(value.equals("Smoochum")){value ="狃拉";}
                if(value.equals("Sneasel")){value ="藤藤蛇";}
                if(value.equals("Snivy")){value ="雪吞蟲";}
                if(value.equals("Snom")){value ="卡比獸";}
                if(value.equals("Snorlax")){value ="雪童子";}
                if(value.equals("Snorunt")){value ="雪笠怪";}
                if(value.equals("Snover")){value ="布魯";}
                if(value.equals("Snubbull")){value ="淚眼蜥";}
                if(value.equals("Sobble")){value ="索爾迦雷歐";}
                if(value.equals("Solgaleo")){value ="單卵細胞球";}
                if(value.equals("Solosis")){value ="太陽岩";}
                if(value.equals("Solrock")){value ="烈雀";}
                if(value.equals("Spearow")){value ="粉蝶蛹";}
                if(value.equals("Spewpa")){value ="海豹球";}
                if(value.equals("Spheal")){value ="圓絲蛛";}
                if(value.equals("Spinarak")){value ="晃晃斑";}
                if(value.equals("Spinda")){value ="花岩怪";}
                if(value.equals("Spiritomb")){value ="跳跳豬";}
                if(value.equals("Spoink")){value ="粉香香";}
                if(value.equals("Spritzee")){value ="傑尼龜";}
                if(value.equals("Squirtle")){value ="壘磊石";}
                if(value.equals("Stakataka")){value ="驚角鹿";}
                if(value.equals("Stantler")){value ="姆克鷹";}
                if(value.equals("Staraptor")){value ="姆克鳥";}
                if(value.equals("Staravia")){value ="姆克兒";}
                if(value.equals("Starly")){value ="寶石海星";}
                if(value.equals("Starmie")){value ="海星星";}
                if(value.equals("Staryu")){value ="大鋼蛇";}
                if(value.equals("Steelix")){value ="甜舞妮";}
                if(value.equals("Steenee")){value ="巨石丁";}
                if(value.equals("Stonjourner")){value ="長毛狗";}
                if(value.equals("Stoutland")){value ="童偶熊";}
                if(value.equals("Stufful")){value ="泥巴魚";}
                if(value.equals("Stunfisk")){value ="臭鼬噗";}
                if(value.equals("Stunky")){value ="樹才怪";}
                if(value.equals("Sudowoodo")){value ="水君";}
                if(value.equals("Suicune")){value ="向日花怪";}
                if(value.equals("Sunflora")){value ="向日種子";}
                if(value.equals("Sunkern")){value ="溜溜糖球";}
                if(value.equals("Surskit")){value ="青綿鳥";}
                if(value.equals("Swablu")){value ="寶包繭";}
                if(value.equals("Swadloon")){value ="吞食獸";}
                if(value.equals("Swalot")){value ="巨沼怪";}
                if(value.equals("Swampert")){value ="舞天鵝";}
                if(value.equals("Swanna")){value ="大王燕";}
                if(value.equals("Swellow")){value ="小山豬";}
                if(value.equals("Swinub")){value ="綿綿泡芙";}
                if(value.equals("Swirlix")){value ="心蝙蝠";}
                if(value.equals("Swoobat")){value ="仙子伊布";}
                if(value.equals("Sylveon")){value ="傲骨燕";}
                if(value.equals("Taillow")){value ="烈箭鷹";}
                if(value.equals("Talonflame")){value ="蔓藤怪";}
                if(value.equals("Tangela")){value ="巨蔓藤";}
                if(value.equals("Tangrowth")){value ="卡璞・哞哞";}
                if(value.equals("Tapu Bulu")){value ="卡璞・鰭鰭";}
                if(value.equals("Tapu Fini")){value ="卡璞・鳴鳴";}
                if(value.equals("Tapu Koko")){value ="卡璞・蝶蝶";}
                if(value.equals("Tapu Lele")){value ="肯泰羅";}
                if(value.equals("Tauros")){value ="熊寶寶";}
                if(value.equals("Teddiursa")){value ="瑪瑙水母";}
                if(value.equals("Tentacool")){value ="毒刺水母";}
                if(value.equals("Tentacruel")){value ="暖暖豬";}
                if(value.equals("Tepig")){value ="代拉基翁";}
                if(value.equals("Terrakion")){value ="狐大盜";}
                if(value.equals("Thievul")){value ="投摔鬼";}
                if(value.equals("Throh")){value ="雷電雲";}
                if(value.equals("Thundurus")){value ="啪咚猴";}
                if(value.equals("Thwackey")){value ="搬運小匠";}
                if(value.equals("Timburr")){value ="原蓋海龜";}
                if(value.equals("Tirtouga")){value ="托戈德瑪爾";}
                if(value.equals("Togedemaru")){value ="波克基斯";}
                if(value.equals("Togekiss")){value ="波克比";}
                if(value.equals("Togepi")){value ="波克基古";}
                if(value.equals("Togetic")){value ="火稚雞";}
                if(value.equals("Torchic")){value ="煤炭龜";}
                if(value.equals("Torkoal")){value ="龍捲雲";}
                if(value.equals("Tornadus")){value ="炎熱喵";}
                if(value.equals("Torracat")){value ="土台龜";}
                if(value.equals("Torterra")){value ="小鋸鱷";}
                if(value.equals("Totodile")){value ="銃嘴大鳥";}
                if(value.equals("Toucannon")){value ="超壞星";}
                if(value.equals("Toxapex")){value ="毒電嬰";}
                if(value.equals("Toxel")){value ="毒骷蛙";}
                if(value.equals("Toxicroak")){value ="顫弦蠑螈";}
                if(value.equals("Toxtricity")){value ="咕咕鴿";}
                if(value.equals("Tranquill")){value ="大顎蟻";}
                if(value.equals("Trapinch")){value ="木守宮";}
                if(value.equals("Treecko")){value ="朽木妖";}
                if(value.equals("Trevenant")){value ="熱帶龍";}
                if(value.equals("Tropius")){value ="破破袋";}
                if(value.equals("Trubbish")){value ="喇叭啄鳥";}
                if(value.equals("Trumbeak")){value ="甜冷美后";}
                if(value.equals("Tsareena")){value ="爆焰龜獸";}
                if(value.equals("Turtonator")){value ="草苗龜";}
                if(value.equals("Turtwig")){value ="圓蝌蚪";}
                if(value.equals("Tympole")){value ="麻麻小魚";}
                if(value.equals("Tynamo")){value ="屬性：空";}
                if(value.equals("Typhlosion")){value ="火爆獸";}
                if(value.equals("Tyranitar")){value ="班基拉斯";}
                if(value.equals("Tyrantrum")){value ="怪顎龍";}
                if(value.equals("Tyrogue")){value ="無畏小子";}
                if(value.equals("Tyrunt")){value ="寶寶暴龍";}
                if(value.equals("Umbreon")){value ="月亮伊布";}
                if(value.equals("Unfezant")){value ="高傲雉雞";}
                if(value.equals("Unown")){value ="未知圖騰";}
                if(value.equals("Ursaring")){value ="圈圈熊";}
                if(value.equals("Uxie")){value ="由克希";}
                if(value.equals("Vanillish")){value ="多多冰";}
                if(value.equals("Vanillite")){value ="迷你冰";}
                if(value.equals("Vanilluxe")){value ="雙倍多多冰";}
                if(value.equals("Vaporeon")){value ="水伊布";}
                if(value.equals("Venipede")){value ="百足蜈蚣";}
                if(value.equals("Venomoth")){value ="摩魯蛾";}
                if(value.equals("Venonat")){value ="毛球";}
                if(value.equals("Venusaur")){value ="妙蛙花";}
                if(value.equals("Vespiquen")){value ="蜂女王";}
                if(value.equals("Vibrava")){value ="超音波幼蟲";}
                if(value.equals("Victini")){value ="比克提尼";}
                if(value.equals("Victreebel")){value ="大食花";}
                if(value.equals("Vigoroth")){value ="過動猿";}
                if(value.equals("Vikavolt")){value ="鍬農炮蟲";}
                if(value.equals("Vileplume")){value ="霸王花";}
                if(value.equals("Virizion")){value ="畢力吉翁";}
                if(value.equals("Vivillon")){value ="彩粉蝶";}
                if(value.equals("Volbeat")){value ="電螢蟲";}
                if(value.equals("Volcanion")){value ="波爾凱尼恩";}
                if(value.equals("Volcarona")){value ="火神蛾";}
                if(value.equals("Voltorb")){value ="霹靂電球";}
                if(value.equals("Vullaby")){value ="禿鷹丫頭";}
                if(value.equals("Vulpix")){value ="六尾";}
                if(value.equals("Wailmer")){value ="吼吼鯨";}
                if(value.equals("Wailord")){value ="吼鯨王";}
                if(value.equals("Walrein")){value ="帝牙海獅";}
                if(value.equals("Wartortle")){value ="卡咪龜";}
                if(value.equals("Watchog")){value ="步哨鼠";}
                if(value.equals("Weavile")){value ="瑪狃拉";}
                if(value.equals("Weedle")){value ="獨角蟲";}
                if(value.equals("Weepinbell")){value ="口呆花";}
                if(value.equals("Weezing")){value ="雙彈瓦斯";}
                if(value.equals("Whimsicott")){value ="風妖精";}
                if(value.equals("Whirlipede")){value ="車輪毬";}
                if(value.equals("Whiscash")){value ="鯰魚王";}
                if(value.equals("Whismur")){value ="咕妞妞";}
                if(value.equals("Wigglytuff")){value ="胖可丁";}
                if(value.equals("Wimpod")){value ="膽小蟲";}
                if(value.equals("Wingull")){value ="長翅鷗";}
                if(value.equals("Wishiwashi")){value ="弱丁魚";}
                if(value.equals("Wobbuffet")){value ="果然翁";}
                if(value.equals("Woobat")){value ="滾滾蝙蝠";}
                if(value.equals("Wooloo")){value ="毛辮羊";}
                if(value.equals("Wooper")){value ="烏波";}
                if(value.equals("Wormadam")){value ="結草貴婦";}
                if(value.equals("Wurmple")){value ="刺尾蟲";}
                if(value.equals("Wynaut")){value ="小果然";}
                if(value.equals("Xatu")){value ="天然鳥";}
                if(value.equals("Xerneas")){value ="哲爾尼亞斯";}
                if(value.equals("Moose's Xerneas")){value ="Moose的哲爾尼亞斯";}
                if(value.equals("Xurkitree")){value ="電束木";}
                if(value.equals("Yamask")){value ="哭哭面具";}
                if(value.equals("Yamper")){value ="來電汪";}
                if(value.equals("Yanma")){value ="蜻蜻蜓";}
                if(value.equals("Yanmega")){value ="遠古巨蜓";}
                if(value.equals("Yungoos")){value ="貓鼬少";}
                if(value.equals("Yveltal")){value ="伊裴爾塔爾";}
                if(value.equals("Zacian")){value ="蒼響";}
                if(value.equals("Zamazenta")){value ="藏瑪然特";}
                if(value.equals("Zangoose")){value ="貓鼬斬";}
                if(value.equals("Zapdos")){value ="閃電鳥";}
                if(value.equals("Zebstrika")){value ="雷電斑馬";}
                if(value.equals("Zekrom")){value ="捷克羅姆";}
                if(value.equals("Zeraora")){value ="捷拉奧拉";}
                if(value.equals("Zigzagoon")){value ="蛇紋熊";}
                if(value.equals("Zoroark")){value ="索羅亞克";}
                if(value.equals("Zorua")){value ="索羅亞";}
                if(value.equals("Zubat")){value ="超音蝠";}
                if(value.equals("Zweilous")){value ="雙首暴龍";}
                if(value.equals("Zygarde")){value ="基格爾德";}}

                if (FusionPixelmon.getModule().equals("forge")){
                    selectedItem.setLore(configR.ShopCurrentChoose() + value, Color.DARK_GRAY + configR.ShopPressRefresh());}
                else{
                    selectedItem.setLore(configR.ShopCurrentChoose() + value);
                page.setDynamicItem(selectedSlot, selectedItem);}
            });

            //pagePokeEditor.setBackground(emptyItem);
            return page;
        }
    }
}
