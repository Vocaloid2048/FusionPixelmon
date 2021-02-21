package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.enums.EnumNature;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemTypes;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.impl.GrammarUtils;
import me.fusiondev.fusionpixelmon.voc.NatureConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class NatureShop extends BaseShop {
    public NatureShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.NATURE;
    }


    NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();
    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.NatureTitle(), "pokeeditor-nature", 5)
                .setInfoItemData(config.NatureInfoTitle(),
                        config.NatureInfoString1(),
                        config.NatureInfoString2())
                .setSelectedItemName(config.NatureSelectedTitle())
                .setSelectedOption(getOption());
        InvPage page = builder.build();
        AbstractItemTypes reg = FusionPixelmon.getRegistry().getItemTypesRegistry();

        for (NatureOptions option : NatureOptions.values()) {
            AbstractItemStack itemStack = reg.STAINED_HARDENED_CLAY().to();
            itemStack.setColour(option.dyeColor);
            //itemStack.offer(Keys.DYE_COLOR, option.dyeColor);

            String optS = GrammarUtils.cap(option.name());
            String optX = GrammarUtils.cap(option.name());
            if (Tconfig.Translation() == true){
            if (optS.equals("Adamant")){optS ="固執";}
            if (optS.equals("Bashful")){optS ="害羞";}
            if (optS.equals("Bold")){optS ="大膽";}
            if (optS.equals("Brave")){optS ="勇敢";}
            if (optS.equals("Calm")){optS ="溫和";}
            if (optS.equals("Careful")){optS ="慎重";}
            if (optS.equals("Docile")){optS ="坦率";}
            if (optS.equals("Gentle")){optS ="溫順";}
            if (optS.equals("Hardy")){optS ="勤奮";}
            if (optS.equals("Hasty")){optS ="急躁";}
            if (optS.equals("Impish")){optS ="淘氣";}
            if (optS.equals("Jolly")){optS ="爽朗";}
            if (optS.equals("Lax")){optS ="樂天";}
            if (optS.equals("Lonely")){optS ="怕寂寞";}
            if (optS.equals("Mild")){optS ="慢吞吞";}
            if (optS.equals("Modest")){optS ="內斂";}
            if (optS.equals("Naive")){optS ="天真";}
            if (optS.equals("Naughty")){optS ="頑皮";}
            if (optS.equals("Quiet")){optS ="冷靜";}
            if (optS.equals("Quirky")){optS ="浮躁";}
            if (optS.equals("Rash")){optS ="馬虎";}
            if (optS.equals("Relaxed")){optS ="悠閒";}
            if (optS.equals("Sassy")){optS ="自大";}
            if (optS.equals("Serious")){optS ="認真";}
            if (optS.equals("Timid")){optS ="膽小";}}

            InvItem item = new InvItem(itemStack, "§3§l" + optS);
            item.setLore("  "+config.NatureIncreased()+" §b" + option.boosted, "  "+config.NatureDecreased()+" §c" + option.lowered);
            String finalOptS = optS;
            page.setItem(option.slot, item, event -> {
                if (!shops.pokemon.getNature().name().equalsIgnoreCase(optX))
                    shops.getSelectedOptions().put(getOption(), optX);
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item.getItemStack());
            });
        }

        return page;
    }

    @Override
    public int prices(Object value) {
        return getPriceOf(ConfigKeyConstants.CHANGE, 3000);
    }

    @Override
    protected void priceSummaries() {
        NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
        addPriceSummary(config.NaturePriceSummary(), getPriceOf(ConfigKeyConstants.CHANGE, 3000));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setNature(EnumNature.natureFromString(value.toString()));
    }

    private static class ConfigKeyConstants {
        private static final String CHANGE = "修改";
    }

    public enum NatureOptions {
        HARDY(2, ATK(), ATK(), DyeColor.RED),
        LONELY(11, ATK(), DEF(), DyeColor.RED),
        ADAMANT(20, ATK(), SA(), DyeColor.RED),
        NAUGHTY(29, ATK(), SD(), DyeColor.RED),
        BRAVE(38, ATK(), SPD(), DyeColor.RED),

        BOLD(3, DEF(), ATK(), DyeColor.ORANGE),
        DOCILE(12, DEF(), DEF(), DyeColor.ORANGE),
        IMPISH(21, DEF(), SA(), DyeColor.ORANGE),
        LAX(30, DEF(), SD(), DyeColor.ORANGE),
        RELAXED(39, DEF(), SPD(), DyeColor.ORANGE),

        MODEST(4, SA(), ATK(), DyeColor.PURPLE),
        MILD(13, SA(), DEF(), DyeColor.PURPLE),
        BASHFUL(22, SA(), SA(), DyeColor.PURPLE),
        RASH(31, SA(), SD(), DyeColor.PURPLE),
        QUIET(40, SA(), SPD(), DyeColor.PURPLE),

        CALM(5, SD(), ATK(), DyeColor.YELLOW),
        GENTLE(14, SD(), DEF(), DyeColor.YELLOW),
        CAREFUL(23, SD(), SA(), DyeColor.YELLOW),
        QUIRKY(32, SD(), SD(), DyeColor.YELLOW),
        SASSY(41, SD(), SPD(), DyeColor.YELLOW),

        TIMID(6, SPD(), ATK(), DyeColor.LIGHT_BLUE),
        HASTY(15, SPD(), DEF(), DyeColor.LIGHT_BLUE),
        JOLLY(24, SPD(), SA(), DyeColor.LIGHT_BLUE),
        NAIVE(33, SPD(), SD(), DyeColor.LIGHT_BLUE),
        SERIOUS(42, SPD(), SPD(), DyeColor.LIGHT_BLUE);

        int slot;
        String boosted;
        String lowered;
        DyeColor dyeColor;

        public static String ATK(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureATK();
        }
        public static String DEF(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureDEF();
        }
        public static String HP(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureHP();
        }
        public static String SPD(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureSPD();
        }
        public static String SA(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureSATK();
        }
        public static String SD(){
            NatureConfig config = FusionPixelmon.getInstance().getConfiguration().getNatureConfig();
            return config.NatureSDEF();
        }

        NatureOptions(int slot, String boosted, String lowered, DyeColor dyeColor) {
            this.slot = slot;
            this.boosted = boosted;
            this.lowered = lowered;
            this.dyeColor = dyeColor;
        }
    }
}
