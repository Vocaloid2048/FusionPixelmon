package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.entities.pixelmon.stats.EVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.IVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.pixelmon.IPokemonWrapper;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.impl.GrammarUtils;
import me.fusiondev.fusionpixelmon.impl.MathUtils;
import me.fusiondev.fusionpixelmon.impl.pixelmon.PokemonWrapper;
import me.fusiondev.fusionpixelmon.voc.IVEVConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class IVEVShop extends BaseShop {

    private final int[] IV_CACHE;
    private final int[] EV_CACHE;

    public IVEVShop(Shops shops) {
        super(shops, true);
        IV_CACHE = IPokemonWrapper.getIVArray(shops.pokemon);
        EV_CACHE = IPokemonWrapper.getEVArray(shops.pokemon);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.IVEV;
    }

    private static final InvItem SUBTRACTION_ITEM = new InvItem(REG.getItemTypesRegistry().STAINED_HARDENED_CLAY().to().setColour(DyeColor.RED), "");
    private static final InvItem ADDITION_ITEM = new InvItem(REG.getItemTypesRegistry().STAINED_HARDENED_CLAY().to().setColour(DyeColor.GREEN), "");


    IVEVConfig config = FusionPixelmon.getInstance().getConfiguration().getIVEVConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();

    private static final int ROWS = 6;

    @Override
    public InvPage buildPage() {
        final IVEVAction[] ACTION = new IVEVAction[1];
        ACTION[0] = new IVEVAction();

        Builder builder = new Builder("§0"+config.IVEVTitle(), "pokeeditor-ivef", ROWS)
                .setInfoItemData(config.IVEVInfoTitle(),
                        config.IVEVInfoString1(),
                        config.IVEVInfoString2())
                .setSelectedSlot(-2)
                .onReset(() -> {
                    ACTION[0].IV.clear();
                    ACTION[0].EV.clear();
                })
                .setSelectedOption(getOption());
        InvPage page = builder.build();

        for (int i = 0; i < ROWS; i++) page.setItem(4 + (9 * i), EMPTY_ITEM);

//        action = ((IVEVAction) getSelectedOptions().getOrDefault(Options.IVEV, new IVEVAction()));
        shops.getSelectedOptions().remove(getOption());


        int totalIV = IntStream.of(IV_CACHE).sum();
        int totalEV = IntStream.of(EV_CACHE).sum();

        String[] sub = new String[]{"", config.IVEVNotes(), "  "+config.IVEVLeftClick()+" §c-1", "  "+config.IVEVLeftClickShift()+" §c-10"};
        String[] add = new String[]{"", config.IVEVNotes(), "  "+config.IVEVLeftClick()+" §a+1", "  "+config.IVEVLeftClickShift()+" §a+10"};


        InvItem[][] items = new InvItem[IVEVOption.values().length][5];

        String optName;
        int i1 = 0;
        for (IVEVOption type : IVEVOption.values()) {
            optName = GrammarUtils.underscoreToSpace(type.name());
            String optS = "";
            if (Tconfig.Translation() == true){
            if (optName.equals("HP")){optS = config.IVEVHP();}
            if (optName.equals("Attack")){optS = config.IVEVATK();}
            if (optName.equals("Defence")){optS = config.IVEVDEF();}
            if (optName.equals("Special Attack")){optS = config.IVEVSATK();}
            if (optName.equals("Special Defence")){optS = config.IVEVSDEF();}
            if (optName.equals("Speed")){optS = config.IVEVSPD();}
            }

            items[i1][0] = new InvItem(REG.getPixelmonUtils().getPixelmonItemStack(type.getItemID()), "§3§l" + optS);
            page.setItem(i1 * 9, items[i1][0]);

            items[i1][1] = SUBTRACTION_ITEM.copy("§c§l"+config.IVEVDecrease()+ optS +" " + "EVs");
            items[i1][2] = ADDITION_ITEM.copy("§a§l"+config.IVEVIncrease()+ optS + " " +"EVs");
            items[i1][3] = SUBTRACTION_ITEM.copy("§c§l"+config.IVEVDecrease()+ optS +" " + "IVs");
            items[i1][4] = ADDITION_ITEM.copy("§a§l"+config.IVEVIncrease()+ optS +" " + "IVs");
            i1++;
        }


        page.setRunnable(() -> {
            int i = 0;

            int requestedIV = ACTION[0].getRequestedIV();
            int requestedEV = ACTION[0].getRequestedEV();

            for (IVEVOption type : IVEVOption.values()) {
                items[i][1].setLore(
                        lore(IPokemonWrapper.beautifyEV(EV_CACHE[i]),
                                IPokemonWrapper.beautifyTally(totalEV, EVStore.MAX_TOTAL_EVS),
                                IPokemonWrapper.beautifyEV(EV_CACHE[i] + ACTION[0].EV.getOrDefault(type.getStatsType(), 0)),
                                IPokemonWrapper.beautifyTally(totalEV + requestedEV, EVStore.MAX_TOTAL_EVS)),
                        sub
                );
                page.setDynamicItem((i * 9) + 2, items[i][1], event -> {
                    int delta = 1;
                    if (event.isShift()) delta = 10;
                    ACTION[0].removeEV(type.getStatsType(), delta);
                    shops.getSelectedOptions().put(getOption(), ACTION[0]);
                    ACTION[0] = (IVEVAction) shops.getSelectedOptions().get(getOption());
                });

                items[i][2].setLore(
                        lore(IPokemonWrapper.beautifyEV(EV_CACHE[i]),
                                IPokemonWrapper.beautifyTally(totalEV, EVStore.MAX_TOTAL_EVS),
                                IPokemonWrapper.beautifyEV(EV_CACHE[i] + ACTION[0].EV.getOrDefault(type.getStatsType(), 0)),
                                IPokemonWrapper.beautifyTally(totalEV + requestedEV, EVStore.MAX_TOTAL_EVS)),
                        add
                );
                page.setDynamicItem((i * 9) + 3, items[i][2], event -> {
                    int delta = 1;
                    if (event.isShift()) delta = 10;
                    ACTION[0].addEV(type.getStatsType(), delta, totalEV);
                    shops.getSelectedOptions().put(getOption(), ACTION[0]);
                    ACTION[0] = (IVEVAction) shops.getSelectedOptions().get(getOption());
                });

                items[i][3].setLore(
                        lore(IPokemonWrapper.beautifyIV(IV_CACHE[i]),
                                IPokemonWrapper.beautifyTally(totalIV, IVStore.MAX_IVS * IV_CACHE.length),
                                IPokemonWrapper.beautifyIV(IV_CACHE[i] + ACTION[0].IV.getOrDefault(type.getStatsType(), 0)),
                                IPokemonWrapper.beautifyTally(totalIV + requestedIV, IVStore.MAX_IVS * IV_CACHE.length)),
                        sub
                );
                page.setDynamicItem((i * 9) + 5, items[i][3], event -> {
                    int delta = 1;
                    if (event.isShift()) delta = 10;
                    ACTION[0].removeIV(type.getStatsType(), delta);
                    shops.getSelectedOptions().put(getOption(), ACTION[0]);
                    ACTION[0] = (IVEVAction) shops.getSelectedOptions().get(getOption());
                });

                items[i][4].setLore(
                        lore(IPokemonWrapper.beautifyIV(IV_CACHE[i]),
                                IPokemonWrapper.beautifyTally(totalIV, IVStore.MAX_IVS * IV_CACHE.length),
                                IPokemonWrapper.beautifyIV(IV_CACHE[i] + ACTION[0].IV.getOrDefault(type.getStatsType(), 0)),
                                IPokemonWrapper.beautifyTally(totalIV + requestedIV, IVStore.MAX_IVS * IV_CACHE.length)),
                        add
                );
                page.setDynamicItem((i * 9) + 6, items[i][4], event -> {
                    int delta = 1;
                    if (event.isShift()) delta = 10;
                    ACTION[0].addIV(type.getStatsType(), delta);
                    shops.getSelectedOptions().put(getOption(), ACTION[0]);
                    ACTION[0] = (IVEVAction) shops.getSelectedOptions().get(getOption());
                });
                i++;
            }
        });
        return page;
    }

    private static String[] lore(String current, String currentTotal, String requested, String requestedTotal) {
        IVEVConfig config = FusionPixelmon.getInstance().getConfiguration().getIVEVConfig();
        return new String[]{config.IVEVCurrent()+" " + current, config.IVEVCurrentTotal()+" " + currentTotal, "", config.IVEVRequested()+" " + requested, config.IVEVRequestedTotal()+" " + requestedTotal};
    }
    @Override
    public int prices(Object value) {
        IVEVAction action = ((IVEVAction) value);
        int totalCost = 0;
        for (int i : action.IV.values()) {
            if (i > 0) totalCost += i * getPriceOf(ConfigKeyConstants.ADD_IV, 600);
            else if (i < 0) totalCost += -i * getPriceOf(ConfigKeyConstants.REMOVE_IV, 5);
        }

        for (int i : action.EV.values()) {
            totalCost += Math.abs(i) * getPriceOf(ConfigKeyConstants.CHANGE_EV, 5);
        }
        return totalCost;
    }

    @Override
    protected void priceSummaries() {
        IVEVConfig config = FusionPixelmon.getInstance().getConfiguration().getIVEVConfig();
        addPriceSummary(config.IVEVIncrease(), getPriceOf(ConfigKeyConstants.ADD_IV, 600) + " "+config.IVEVEach()+" IV");
        addPriceSummary(config.IVEVDecrease(), getPriceOf(ConfigKeyConstants.REMOVE_IV, 5) + " "+config.IVEVEach()+" IV");
        String changeEV = getPriceOf(ConfigKeyConstants.CHANGE_EV, 5) + " "+config.IVEVEach()+" IV";
        addPriceSummary(config.IVEVIncrease(), changeEV);
        addPriceSummary(config.IVEVDecrease(), changeEV);
    }

    @Override
    public List<String> purchaseSummary(Shops.Options key, Object value) {
        IVEVAction action = (IVEVAction) value;
        List<String> list = new ArrayList<>(PokemonWrapper.getStats("IV", action.IV, IV_CACHE, IVStore.MAX_IVS * 6));
        list.add("");
        list.addAll(PokemonWrapper.getStats("EV", action.EV, EV_CACHE, EVStore.MAX_TOTAL_EVS));
        return list;
    }

    @Override
    public void purchaseAction(Object value) {
        IVEVShop.IVEVAction action = (IVEVShop.IVEVAction) value;
        int lvl;
        for (Map.Entry<StatsType, Integer> entry : action.EV.entrySet()) {
            lvl = shops.pokemon.getEVs().get(entry.getKey());
            lvl = MathUtils.clamp(lvl + entry.getValue(), 0, EVStore.MAX_EVS);
            shops.pokemon.getEVs().set(entry.getKey(), lvl);
        }
        for (Map.Entry<StatsType, Integer> entry : action.IV.entrySet()) {
            lvl = shops.pokemon.getIVs().get(entry.getKey());
            lvl = MathUtils.clamp(lvl + entry.getValue(), 0, IVStore.MAX_IVS);
            shops.pokemon.getIVs().set(entry.getKey(), lvl);
        }

        // Quickly change and restore the Pokemon's level, to update the stats in the Stats menu
        int level = shops.pokemon.getLevel();
        shops.pokemon.setLevel(level - 1);
        shops.pokemon.setLevel(level);
    }

    private static class ConfigKeyConstants {
        private static final String ADD_IV = "add-iv";
        private static final String REMOVE_IV = "remove-iv";
        private static final String CHANGE_EV = "change-ev";
    }

    enum IVEVOption {
        HP("power_weight", StatsType.HP),
        Attack("power_bracer", StatsType.Attack),
        Defence("power_belt", StatsType.Defence),
        Special_Attack("power_lens", StatsType.SpecialAttack),
        Special_Defence("power_band", StatsType.SpecialDefence),
        Speed("power_anklet", StatsType.Speed);

        private String itemID;
        private StatsType statsType;

        IVEVOption(String itemID, StatsType statsType) {
            this.itemID = itemID;
            this.statsType = statsType;
        }

        public String getItemID() {
            return itemID;
        }

        public StatsType getStatsType() {
            return statsType;
        }
    }

    public class IVEVAction {
        private final HashMap<StatsType, Integer> IV = new HashMap<>();
        private final HashMap<StatsType, Integer> EV = new HashMap<>();

        public int getRequestedIV() {
            int total = 0;
            for (int i : IV.values()) total += i;
            return total;
        }

        public int getRequestedEV() {
            int total = 0;
            for (int i : EV.values()) total += i;
            return total;
        }

        public void addIV(StatsType statsType, int i) {
            int lvl = IV.getOrDefault(statsType, 0) + i;
            int iv = shops.pokemon.getIVs().get(statsType);
            if (iv + lvl > IVStore.MAX_IVS) {
                lvl = IVStore.MAX_IVS - iv;
                // 31 = iv + lvl + i
                // lvl + i = 31 - iv
            }

            IV.put(statsType, lvl);
        }

        public void removeIV(StatsType statsType, int i) {
            int lvl = IV.getOrDefault(statsType, 0) - i;
            int iv = shops.pokemon.getIVs().get(statsType);
            if (iv + lvl < 0) {
                lvl = -iv;
                // 0 = iv - lvl
                // lvl = iv
            }
            IV.put(statsType, lvl);
        }

        public void addEV(StatsType statsType, int i, int total) {
            int lvl = EV.getOrDefault(statsType, 0) + i;
            int ev = shops.pokemon.getEVs().get(statsType);
            if (ev + lvl > EVStore.MAX_EVS) {
                lvl = EVStore.MAX_EVS - ev;
                // 252 = iv + lvl
                // lvl = 252 - iv
            }

            if (total + (getRequestedEV() - EV.getOrDefault(statsType, 0)) + lvl > EVStore.MAX_TOTAL_EVS) {
                // 510 = total + req + lvl
                // lvl = 510 - total - req
                lvl = EVStore.MAX_TOTAL_EVS - total - (getRequestedEV() - EV.getOrDefault(statsType, 0));
            }
            EV.put(statsType, lvl);
        }

        public void removeEV(StatsType statsType, int i) {
            int lvl = EV.getOrDefault(statsType, 0) - i;
            int ev = shops.pokemon.getEVs().get(statsType);
            if (ev + lvl < 0) {
                lvl = -ev;
                // 0 = iv - lvl
                // lvl = iv
            }
            EV.put(statsType, lvl);
        }
    }
}
