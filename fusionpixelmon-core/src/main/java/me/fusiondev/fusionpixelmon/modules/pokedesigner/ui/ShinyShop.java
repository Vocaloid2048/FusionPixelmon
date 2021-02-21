package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.voc.ShinyConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class ShinyShop extends BaseShop {
    public ShinyShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.SHINY;
    }

    ShinyConfig config = FusionPixelmon.getInstance().getConfiguration().getShinyConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.ShinyTitle(), "pokeeditor-shiny", 5)
                .setInfoItemData(config.ShinyInfoTitle(),
                        config.ShinyInfoString1(),
                        config.ShinyInfoString2())
                .setSelectedItemName(config.ShinySelectedTitle())
                .setSelectedOption(getOption());
        InvPage page = builder.build();

        ShinyConfig config = FusionPixelmon.getInstance().getConfiguration().getShinyConfig();
        InvItem item1 = new InvItem(REG.getPixelmonUtils().getPixelmonItemStack("light_ball"), "§6§l"+config.ShinyTRUE());
        item1.setLore(config.ShinyTrueChoose());
        page.setItem(21, item1, event -> {
            if (!shops.pokemon.isShiny()) shops.getSelectedOptions().put(getOption(), true);
            else shops.getSelectedOptions().remove(getOption());
            builder.setSelectedItem(item1.getItemStack());
        });

        InvItem item2 = new InvItem(REG.getPixelmonUtils().getPixelmonItemStack("iron_ball"), "§8§l"+config.ShinyFALSE());
        item2.setLore(config.ShinyFalseChoose());
        page.setItem(23, item2, event -> {
            if (shops.pokemon.isShiny()) shops.getSelectedOptions().put(getOption(), false);
            else shops.getSelectedOptions().remove(getOption());
            builder.setSelectedItem(item2.getItemStack());
        });
        return page;
    }

    @Override
    public int prices(Object value) {
        return ((boolean) value) ? getPriceOf(ConfigKeyConstants.ADD, 4000) : getPriceOf(ConfigKeyConstants.REMOVE, 125);

    }

    @Override
    protected void priceSummaries() {
        ShinyConfig config = FusionPixelmon.getInstance().getConfiguration().getShinyConfig();
        addPriceSummary(config.ShinyCPriceSummary(), getPriceOf(ConfigKeyConstants.ADD, 4000));
        addPriceSummary(config.ShinyDPriceSummary(), getPriceOf(ConfigKeyConstants.REMOVE, 125));
    }

    @Override
    public void purchaseAction(Object value) {
        if (value instanceof Boolean) {
            boolean set = (boolean) value;
            boolean isShiny = shops.pokemon.isShiny();
            if (set != isShiny) {
                shops.pokemon.setShiny(set);
            }
        }
    }

    private static class ConfigKeyConstants {
        private static final String ADD = "選擇";
        private static final String REMOVE = "移除";
    }
}
