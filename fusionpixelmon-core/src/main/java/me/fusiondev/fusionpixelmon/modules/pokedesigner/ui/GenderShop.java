package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.Registry;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.voc.FormConfig;
import me.fusiondev.fusionpixelmon.voc.GenderConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class GenderShop extends BaseShop {
    public GenderShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.GENDER;
    }


    GenderConfig config = FusionPixelmon.getInstance().getConfiguration().getGenderConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.GenderTitle(), "pokeeditor-gender", 5)
                .setInfoItemData(config.GenderInfoTitle(),
                        config.GenderInfoString1(),
                        config.GenderInfoString2())
                .setSelectedItemName(config.GenderSelectedTitle())
                .setSelectedOption(getOption());
        InvPage page = builder.build();
        Registry reg = FusionPixelmon.getRegistry();

        if (shops.pokemon.getGender() == Gender.None) {
            AbstractItemStack genderStack = reg.getItemTypesRegistry().STAINED_HARDENED_CLAY().to();
            genderStack.setColour(DyeColor.YELLOW);

            //ItemStack genderStack = ItemStack.builder().itemType(ItemTypes.STAINED_HARDENED_CLAY).build();
            //genderStack.offer(Keys.DYE_COLOR, DyeColors.YELLOW);
            InvItem item1 = new InvItem(genderStack, "§b§l"+config.GenderNoSex());
            page.setItem(22, item1, event -> builder.setSelectedItem(item1.getItemStack()));
        } else {
            AbstractItemStack maleStack = reg.getItemTypesRegistry().STAINED_HARDENED_CLAY().to();
            maleStack.setColour(DyeColor.LIGHT_BLUE);

            //ItemStack maleStack = ItemStack.builder().itemType(ItemTypes.STAINED_HARDENED_CLAY).build();
            //maleStack.offer(Keys.DYE_COLOR, DyeColors.LIGHT_BLUE);
            InvItem item1 = new InvItem(maleStack, "§b§l"+config.GenderInvMale());
            item1.setLore(config.GenderSetMale());
            page.setItem(21, item1, event -> {
                if (shops.pokemon.getGender() != Gender.Male) shops.getSelectedOptions().put(getOption(), "§b"+config.GenderSelectedMale());
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item1.getItemStack());
            });

            AbstractItemStack femaleStack = reg.getItemTypesRegistry().STAINED_HARDENED_CLAY().to();
            femaleStack.setColour(DyeColor.MAGENTA);

            //ItemStack femaleStack = ItemStack.builder().itemType(ItemTypes.STAINED_HARDENED_CLAY).build();
            //femaleStack.offer(Keys.DYE_COLOR, DyeColors.MAGENTA);
            InvItem item2 = new InvItem(femaleStack, "§d§l"+config.GenderInvFemale());
            item2.setLore(config.GenderSetFemale());
            page.setItem(23, item2, event -> {
                if (shops.pokemon.getGender() != Gender.Female) shops.getSelectedOptions().put(getOption(), "§d"+config.GenderSelectedFemale());
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item2.getItemStack());
            });
        }
        return page;
    }

    @Override
    public int prices(Object value) {
        return getPriceOf(ConfigKeyConstants.CHANGE, 1000);
    }

    @Override
    protected void priceSummaries() {
        GenderConfig config = FusionPixelmon.getInstance().getConfiguration().getGenderConfig();
        addPriceSummary(config.GenderPriceSummary(), getPriceOf(ConfigKeyConstants.CHANGE, 1000));
    }

    @Override
    public void purchaseAction(Object value) {
        if (value.toString().contains(config.GenderInvFemale())) shops.pokemon.setGender(Gender.Female);
        else if (value.toString().contains(config.GenderInvMale())) shops.pokemon.setGender(Gender.Male);
    }

    private static class ConfigKeyConstants {
        private static final String CHANGE = "修改";
    }
}
