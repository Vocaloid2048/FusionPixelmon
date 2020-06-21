package me.fusiondev.fusionpixelmon.spigot.modules.pokedesigner.gui;

import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.spigot.SpigotAdapter;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AbilityShop extends BaseShop {
    public AbilityShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.ABILITY;
    }

    private int abilitySlot = 0;

    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0Ability Modification", "pokeeditor-ability", 5)
                .setInfoItemData("Ability Info",
                        "To pick an ability for your Pokemon",
                        "simply select one of the possible",
                        "options on the right.")
                .setSelectedItemName("Selected Ability")
                .setSelectedOption(getOption());
        InvPage page = builder.build();

        int[] slots = new int[]{20, 22, 24};
        DyeColor[] colors = new DyeColor[]{DyeColor.GREEN, DyeColor.YELLOW, DyeColor.RED};
        String[] allAbilities = shops.pokemon.getBaseStats().abilities;
        for (int i = 0; i < allAbilities.length; i++) {
            if (allAbilities[i] == null || (i == 1 && allAbilities[1].equals(allAbilities[0]))) {
                InvItem item = new InvItem(SpigotAdapter.adapt(Material.BARRIER), "§c§lN/A");
                page.setItem(slots[i], item);
            } else {
                String ability = allAbilities[i];
                AbstractItemStack abilityStack = SpigotAdapter.adapt(new ItemStack(Material.STAINED_CLAY));
                abilityStack.setColour(colors[i]);
//                abilityStack.offer(Keys.DYE_COLOR, colors[i]);
                InvItem item = new InvItem(abilityStack, "§3§l" + ability);
                int finalI = i;
                page.setItem(slots[i], item, event -> {
                    if (!shops.pokemon.getAbilityName().equalsIgnoreCase(ability)) {
                        abilitySlot = finalI;
                        shops.getSelectedOptions().put(getOption(), ability);
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
        return (abilitySlot == 2) ? getPriceOf(ConfigKeys.SPECIAL, 8000) : getPriceOf(ConfigKeys.REGULAR, 750);
    }

    @Override
    protected void priceSummaries() {
        addPriceSummary("Regular Ability", getPriceOf(ConfigKeys.REGULAR, 750));
        addPriceSummary("Special Ability", getPriceOf(ConfigKeys.SPECIAL, 8000));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setAbility(value.toString());
    }

    private static class ConfigKeys {
        static final String REGULAR = "regular";
        static final String SPECIAL = "special";
    }
}
