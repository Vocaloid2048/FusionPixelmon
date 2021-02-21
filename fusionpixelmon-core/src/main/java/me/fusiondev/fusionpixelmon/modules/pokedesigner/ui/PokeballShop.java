package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.pixelmon.IPokemonWrapper;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.voc.PokeBallConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

public class PokeballShop extends BaseShop {
    public PokeballShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.POKEBALL;
    }

    PokeBallConfig config = FusionPixelmon.getInstance().getConfiguration().getPokeBallConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.PokeBallTitle(), "pokeeditor-pokeball", 6)
                .setInfoItemData(config.PokeBallInfoTitle(),
                        config.PokeBallInfoString1(),
                        config.PokeBallInfoString2())
                .setSelectedItemName(config.PokeBallSelectedTitle())
                .setSelectedSlot(46)
                .setInfoSlot(48)
                .setResetSlot(50)
                .setBackSlot(52)
                .border(true)
                .setSelectedOption(getOption());

        InvPage page = builder.build();

        //page.setBackground(emptyItem);

        int slot = 9;
        for (EnumPokeballs pokeballs : EnumPokeballs.values()) {
            String pokeBallS = pokeballs.name();
            String pokeBallX = pokeballs.name();
            if (Tconfig.Translation() == true){
            if(pokeballs.name().equals("PokeBall")){pokeBallS =config.PokeBallPokeBall();}
            if(pokeballs.name().equals("DreamBall")){pokeBallS =config.PokeBallDreamBall();}
            if(pokeballs.name().equals("GreatBall")){pokeBallS =config.PokeBallGreatBall();}
            if(pokeballs.name().equals("UltraBall")){pokeBallS =config.PokeBallUltraBall();}
            if(pokeballs.name().equals("MasterBall")){pokeBallS =config.PokeBallMasterBall();}
            if(pokeballs.name().equals("LevelBall")){pokeBallS =config.PokeBallLevelBall();}
            if(pokeballs.name().equals("MoonBall")){pokeBallS =config.PokeBallMoonBall();}
            if(pokeballs.name().equals("FriendBall")){pokeBallS =config.PokeBallFriendBall();}
            if(pokeballs.name().equals("LoveBall")){pokeBallS =config.PokeBallLoveBall();}
            if(pokeballs.name().equals("SafariBall")){pokeBallS =config.PokeBallSafariBall();}
            if(pokeballs.name().equals("HeavyBall")){pokeBallS =config.PokeBallHeavyBall();}
            if(pokeballs.name().equals("FastBall")){pokeBallS =config.PokeBallFastBall();}
            if(pokeballs.name().equals("RepeatBall")){pokeBallS =config.PokeBallRepeatBall();}
            if(pokeballs.name().equals("TimerBall")){pokeBallS =config.PokeBallTimerBall();}
            if(pokeballs.name().equals("NestBall")){pokeBallS =config.PokeBallNestBall();}
            if(pokeballs.name().equals("NetBall")){pokeBallS =config.PokeBallNetBall();}
            if(pokeballs.name().equals("DiveBall")){pokeBallS =config.PokeBallDiveBall();}
            if(pokeballs.name().equals("LuxuryBall")){pokeBallS =config.PokeBallLuxuryBall();}
            if(pokeballs.name().equals("HealBall")){pokeBallS =config.PokeBallHealBall();}
            if(pokeballs.name().equals("DuskBall")){pokeBallS =config.PokeBallDuskBall();}
            if(pokeballs.name().equals("ParkBall")){pokeBallS =config.PokeBallParkBall();}
            if(pokeballs.name().equals("QuickBall")){pokeBallS =config.PokeBallQuickBall();}
            if(pokeballs.name().equals("LureBall")){pokeBallS =config.PokeBallLureBall();}
            if(pokeballs.name().equals("SportBall")){pokeBallS =config.PokeBallSportBall();}
            if(pokeballs.name().equals("CherishBall")){pokeBallS =config.PokeBallCherishBall();}
            if(pokeballs.name().equals("PremierBall")){pokeBallS =config.PokeBallPremierBall();}
            if(pokeballs.name().equals("GSBall")){pokeBallS =config.PokeBallGSBall();}
            if(pokeballs.name().equals("BeastBall")){pokeBallS =config.PokeBallBeastBall();}
            }
            String finalPokeBallS = pokeBallS;
            String finalPokeBallX = pokeBallX;
            if (pokeballs == EnumPokeballs.BeastBall && !IPokemonWrapper.isUltraBeast(shops.pokemon)) continue;
            InvItem item = new InvItem(REG.getPixelmonUtils().getPixelmonItemStack(pokeballs.getFilenamePrefix()), "§3§l" + finalPokeBallS);


            page.setItem(slot, item, event -> {
                if (shops.pokemon.getCaughtBall() != pokeballs) shops.getSelectedOptions().put(getOption(), pokeballs);
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item.getItemStack());
            });
            slot++;
        }
        return page;
    }

    @Override
    public int prices(Object value) {
        // Base Code , bcz get String -> EnumPokeballs Bug so deleted
        // EnumPokeballs ball = (EnumPokeballs) value;

        String ball = value.toString();
        int cost = getPriceOf(config.PokeBallREGULAR(), 300);
        if (ball.equals("紀念球") || ball.equals("GS球")||ball.equals(config.PokeBallPremierBall()) || ball.equals(config.PokeBallGSBall()))
            cost = getPriceOf(config.PokeBallSPECIAL(), 400);
        else if (ball.equals("大師球") || ball.equals("公園球")||ball.equals(config.PokeBallMasterBall()) || ball.equals(config.PokeBallParkBall()))
            cost = getPriceOf(config.PokeBallGOD(), 600);
        else if (ball.equals("究極球")||ball.equals(config.PokeBallBeastBall()))
            cost = getPriceOf(config.PokeBallBEAST(), 800);
        return cost;
    }

    @Override
    protected void priceSummaries() {
        PokeBallConfig config = FusionPixelmon.getInstance().getConfiguration().getPokeBallConfig();
        addPriceSummary(config.PokeBallNormal(), getPriceOf(ConfigKeyConstants.REGULAR, 300));
        addPriceSummary(config.PokeBallPremierBall(), getPriceOf(ConfigKeyConstants.SPECIAL, 400));
        addPriceSummary(config.PokeBallGSBall(), getPriceOf(ConfigKeyConstants.SPECIAL, 400));
        addPriceSummary(config.PokeBallMasterBall(), getPriceOf(ConfigKeyConstants.GOD, 600));
        addPriceSummary(config.PokeBallParkBall(), getPriceOf(ConfigKeyConstants.GOD, 600));
        if (IPokemonWrapper.isUltraBeast(shops.pokemon))
            addPriceSummary(config.PokeBallBeastBall(), getPriceOf(ConfigKeyConstants.BEAST, 800));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setCaughtBall((EnumPokeballs) value);
    }

    private static class ConfigKeyConstants {
        private static final String REGULAR = "一般";
        private static final String SPECIAL = "特殊";
        private static final String GOD = "神級";
        private static final String BEAST = "究極級";
    }
}
