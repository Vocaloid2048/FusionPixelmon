package me.fusiondev.fusionpixelmon.modules.pokedesigner.config;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import info.pixelmon.repack.ninja.leaping.configurate.commented.CommentedConfigurationNode;
import info.pixelmon.repack.ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.ObjectMappingException;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.Setting;
import info.pixelmon.repack.ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigSerializable
public class PokeDesignerConfig {
    @Setting("blacklisted-pokemon")
    public List<EnumSpecies> blacklistedPokemon = ImmutableList.of();
    @Setting("poke-selector-gui-title")
    private String pokeSelectorGuiTitle;
    @Setting("gui-title")
    private String guiTitle;
    @Setting("shop-currency")
    private String currency;
    private static final String DEFAULT_CURRENCY = "pokedollar";

    /**
     * Checks if the specified species is blacklisted from the PokeDesigner.
     *
     * @param species the species to check.
     * @return true if the species is blacklisted; otherwise false.
     */
    public boolean containsBlackListedPokemon(EnumSpecies species) {
        return blacklistedPokemon.contains(species);
    }

    public String getPokeSelectorGuiTitle() {
        return pokeSelectorGuiTitle;
    }

    public String getGuiTitle() {
        return guiTitle;
    }

    public boolean useCurrency() {
        return !currency.equalsIgnoreCase(DEFAULT_CURRENCY);
    }

    public String getCurrency() {
        return currency;
    }

    @ConfigSerializable
    public static class ShopConfig {
        @SuppressWarnings("UnstableApiUsage")
        public final static TypeToken<ShopConfig> TYPE = TypeToken.of(ShopConfig.class);

        @Setting
        private boolean enabled;
        @Setting("prices")
        private HashMap<String, Integer> prices;

        public boolean isEnabled() {
            return enabled;
        }

        public HashMap<String, Integer> getPrices() {
            return prices;
        }
    }

    /**
     * The string name of the loaded shops mapped to their shop configs.
     */
    private HashMap<String, ShopConfig> shops = new HashMap<>();

    /**
     * Checks if the PokeDesigner is enabled.
     *
     * @return true if PokeDesigner is enabled; otherwise false.
     */
    public boolean isEnabled() {
        return !shops.isEmpty();
    }

    /**
     * Checks if the specified shop config is loaded.
     *
     * @param name the shop name.
     * @return true if the shop config is loaded/enabled/exists; otherwise false.
     */
    public boolean existsShop(String name) {
        return shops.containsKey(name);
    }

    /**
     * Removes the specified shop if the shop config is loaded.
     *
     * @param name the shop name.
     */
    public void removeShop(String name) {
        if (existsShop(name)) shops.remove(name);
    }

    /**
     * Gets the config of the specified name.
     *
     * @param name the shop name.
     * @return the shop config if found; otherwise null.
     */
    public ShopConfig getShopNamed(String name) {
        return shops.getOrDefault(name, null);
    }

    /**
     * Loads the PokeDesigner configuration from the config file in the specified loader.
     *
     * @param loader the loader.
     * @throws IOException            if an I/O exception occurs.
     * @throws ObjectMappingException if an object mapping exception occurs.
     */
    @SuppressWarnings("UnstableApiUsage")
    public void loadPokeDesignerConfig(HoconConfigurationLoader loader) throws IOException, ObjectMappingException {
        CommentedConfigurationNode configRoot = loader.load();
        Map<Object, ? extends CommentedConfigurationNode> map = configRoot.getNode("pokedesigner", "shops").getChildrenMap();
        for (Object key : map.keySet()) {
            String name = (String) key;
            ShopConfig shopConfig = configRoot.getNode("pokedesigner", "shops", name).getValue(ShopConfig.TYPE);
            if (shopConfig != null) {
                shops.put(name, shopConfig);
            }
        }
        loader.save(configRoot);
    }

}
