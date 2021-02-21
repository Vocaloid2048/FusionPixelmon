package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.api.enums.ExperienceGainType;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemTypes;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.impl.TimeUtils;
import me.fusiondev.fusionpixelmon.voc.LevelConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class LevelShop extends BaseShop {
    public LevelShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.LEVEL;
    }


    LevelConfig config = FusionPixelmon.getInstance().getConfiguration().getLevelConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.LevelTitle(), "pokeeditor-level", 6)
                .setInfoItemData(config.LevelInfoTitle(),
                        config.LevelInfoString1(),
                        config.LevelInfoString2())
                .setSelectedItemName(config.LevelSelectedTitle())
                .setSelectedSlot(46)
                .setInfoSlot(48)
                .setResetSlot(50)
                .setBackSlot(52)
                .setSelectedOption(getOption());

        InvPage page = builder.build();
        AbstractItemTypes reg = FusionPixelmon.getRegistry().getItemTypesRegistry();

        AbstractItemStack emptyStack = reg.STAINED_GLASS_PANE().to();
        emptyStack.setColour(DyeColor.BLACK);
        //emptyStack.offer(Keys.DYE_COLOR, DyeColors.BLACK);
        InvItem emptyItem = new InvItem(emptyStack, "");
        page.setBackground(emptyItem);

        AbstractItemStack addStack = reg.STAINED_HARDENED_CLAY().to();
        addStack.setColour(DyeColor.LIME);
        //addStack.offer(Keys.DYE_COLOR, DyeColors.LIME);
        InvItem item1 = new InvItem(addStack, "§a§l"+config.LevelIncreaseLvl());
        if (FusionPixelmon.getModule().equals("forge")) {
            item1.setLore(
                    config.LevelPressIncrease()
            );
        } else {
            item1.setLore(
                    config.LevelPressIncrease(),
                    "",
                    "§a"+config.LevelNotes(),
                    "  "+config.LevelLeftClick()+" §a+1 "+config.LevelZName(),
                    "  "+config.LevelLeftClick()+" §a+10 "+config.LevelZName()
            );
        }
        int[] item1slots = new int[]{
                10, 11, 12,
                19, 20, 21,
                28, 29, 30
        };
        int[] item2slots = new int[]{
                14, 15, 16,
                23, 24, 25,
                32, 33, 34
        };

        for (int slots1 : item1slots) {
            page.setItem(slots1, item1, event -> {
                int levels = (int) shops.getSelectedOptions().getOrDefault(getOption(), 0);
                int add = 1;
                if (event.isShift()) add = 10;
                if (shops.pokemon.getLevel() + levels + add > 100) {
                    add = 100 - shops.pokemon.getLevel() - levels;
                    // 100 = lvl + lvls + add
                    // 100 - lvl = lvls + add
                    // 100 - lvl - lvls = add
                }
                if (shops.pokemon.getLevel() + levels + add <= 100) {
                    shops.getSelectedOptions().put(getOption(), levels + add);
                }
                builder.setSelectedItem(item1.getItemStack());
            });
        }

        AbstractItemStack removeStack = reg.STAINED_HARDENED_CLAY().to();
        removeStack.setColour(DyeColor.RED);
        //removeStack.offer(Keys.DYE_COLOR, DyeColors.RED);
        InvItem item2 = new InvItem(removeStack, "§c§l"+config.LevelDecreaseLvl());
        if (FusionPixelmon.getModule().equals("forge")) {
            item2.setLore(
                    config.LevelPressDecrease()
            );
        } else {
            item2.setLore(
                    config.LevelPressDecrease(),
                    "",
                    "§c"+config.LevelNotes(),
                    "  "+config.LevelLeftClick()+" §c-1 "+config.LevelZName(),
                    "  "+config.LevelLeftClickShift()+" §c-10 "+config.LevelZName()
            );
        }
        for (int slots2 : item2slots) {
            page.setItem(slots2, item2, event -> {
                int levels = (int) shops.getSelectedOptions().getOrDefault(getOption(), 0);
                int add = 1;
                if (event.isShift()) add = 10;
                if (shops.pokemon.getLevel() + levels - add < 1) {
                    add = shops.pokemon.getLevel() + levels - 1;
                    // 1 = lvl + lvls - add
                    // 1 + add = lvl + lvls
                    // add = lvl + lvls - 1
                }
                if (shops.pokemon.getLevel() + levels - add > 0) {
                    shops.getSelectedOptions().put(getOption(), levels - add);
                }
                builder.setSelectedItem(item2.getItemStack());
            });
        }
        return page;
    }

    @Override
    public int prices(Object value) {
        int levels = (int) value;
        return (levels > 0) ? levels * getPriceOf(ConfigKeyConstants.ADD_LEVEL, 100) : Math.abs(levels) * getPriceOf(ConfigKeyConstants.REMOVE_LEVEL, 10);
    }

    @Override
    protected void priceSummaries() {
        LevelConfig config = FusionPixelmon.getInstance().getConfiguration().getLevelConfig();
        addPriceSummary(config.LevelIncreaseLvl(), getPriceOf(ConfigKeyConstants.ADD_LEVEL, 100) + " "+config.LevelEach());
        addPriceSummary(config.LevelDecreaseLvl(), getPriceOf(ConfigKeyConstants.REMOVE_LEVEL, 10) +  " "+config.LevelEach());
    }

    @Override
    public void purchaseAction(Object value) {
        int levels = (int) value;
        if (levels > 0) {
            shops.pokemon.retrieve();
            float health = shops.pokemon.getHealthPercentage();
            shops.pokemon.setHealth(0);
            TimeUtils.setTimeout(() -> {
                for (int i = 1; i <= levels; i++)
                    shops.pokemon.getLevelContainer().awardEXP(shops.pokemon.getExperienceToLevelUp(), ExperienceGainType.BATTLE);
                shops.pokemon.setHealthPercentage(health);
            }, 1000);
        } else shops.pokemon.setLevel(shops.pokemon.getLevel() + levels);
    }

    private static class ConfigKeyConstants {
        private static final String ADD_LEVEL = "add-per-level";
        private static final String REMOVE_LEVEL = "remove-per-level";
    }
}
