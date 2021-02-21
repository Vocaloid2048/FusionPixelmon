package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.Registry;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.impl.GrammarUtils;
import me.fusiondev.fusionpixelmon.voc.GenderConfig;
import me.fusiondev.fusionpixelmon.voc.GrowthConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class GrowthShop extends BaseShop {
    public GrowthShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.GROWTH;
    }

    GrowthConfig config = FusionPixelmon.getInstance().getConfiguration().getGrowthConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.GrowthTitle(), "pokeeditor-growth", 5)
                .setInfoItemData(config.GrowthInfoTitle(),
                        config.GrowthInfoString1(),
                        config.GrowthInfoString2())
                .setSelectedItemName(config.GrowthSelectedTitle())
                .setSelectedOption(getOption());
        InvPage page = builder.build();
        Registry reg = FusionPixelmon.getRegistry();

        for (GrowthOptions option : GrowthOptions.values()) {
            AbstractItemStack itemStack = reg.getItemTypesRegistry().STAINED_HARDENED_CLAY().to();
            itemStack.setColour(option.getDyeColor());
            //ItemStack itemStack = ItemStack.builder().itemType(ItemTypes.STAINED_HARDENED_CLAY).build();
            //itemStack.offer(Keys.DYE_COLOR, option.dyeColor);
            String optS = option.name();
            String optX = option.name();
            if (Tconfig.Translation() == true){
            if(optS.equals("Microscopic")){optS =config.GrowthMicroscopic();}
            if(optS.equals("Pygmy")){optS =config.GrowthPygmy();}
            if(optS.equals("Runt")){optS =config.GrowthRunt();}
            if(optS.equals("Small")){optS =config.GrowthSmall();}
            if(optS.equals("Ordinary")){optS =config.GrowthOrdinary();}
            if(optS.equals("Huge")){optS =config.GrowthHuge();}
            if(optS.equals("Giant")){optS =config.GrowthGiant();}
            if(optS.equals("Enormous")){optS =config.GrowthEnormous();}
            if(optS.equals("Ginormous")){optS =config.GrowthGinormous();}}
            InvItem item = new InvItem(itemStack, "§3§l" + optS);
            String finalOptS = optS;
            page.setItem(option.getSlot(), item, event -> {
                if (!shops.pokemon.getGrowth().name().equalsIgnoreCase(optX))
                    shops.getSelectedOptions().put(getOption(), optX);
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item.getItemStack());
            });
        }
        return page;
    }


    @Override
    public int prices(Object value) {
        String growth = (String) value;
        int cost = getPriceOf(ConfigKeyConstants.REGULAR, 600);
        if (growth.equals(EnumGrowth.Microscopic.name()) || growth.equals(EnumGrowth.Ginormous.name()))
            cost = getPriceOf(ConfigKeyConstants.SPECIAL, 2000);
        return cost;
    }

    @Override
    protected void priceSummaries() {
        GrowthConfig config = FusionPixelmon.getInstance().getConfiguration().getGrowthConfig();
        addPriceSummary(config.GrowthGrowth1(), getPriceOf(ConfigKeyConstants.REGULAR, 600));
        addPriceSummary(config.GrowthGrowth2(), getPriceOf(ConfigKeyConstants.SPECIAL, 2000));
        addPriceSummary(config.GrowthGrowth3(), getPriceOf(ConfigKeyConstants.SPECIAL, 2000));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setGrowth(EnumGrowth.growthFromString(value.toString()));
    }

    private static class ConfigKeyConstants {
        private static final String REGULAR = "一般";
        private static final String SPECIAL = "特殊";
    }

    public enum GrowthOptions {
        Microscopic(11, DyeColor.RED),
        Pygmy(20, DyeColor.ORANGE),
        Runt(29, DyeColor.YELLOW),

        Small(13, DyeColor.GREEN),
        Ordinary(22, DyeColor.LIGHT_BLUE),
        Huge(31, DyeColor.PURPLE),

        Giant(15, DyeColor.PINK),
        Enormous(24, DyeColor.GRAY),
        Ginormous(33, DyeColor.BLACK);

        private int slot;
        private DyeColor dyeColor;

        GrowthOptions(int slot, DyeColor dyeColor) {
            this.slot = slot;
            this.dyeColor = dyeColor;
        }

        public int getSlot() {
            return slot;
        }

        public DyeColor getDyeColor() {
            return dyeColor;
        }
    }
}
