package me.fusiondev.fusionpixelmon.modules.pokedesigner.ui;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.enums.forms.IEnumForm;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.ui.BaseShop;
import me.fusiondev.fusionpixelmon.api.ui.Shops;
import me.fusiondev.fusionpixelmon.voc.EvolutionConfig;
import me.fusiondev.fusionpixelmon.voc.FormConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

import java.util.List;

public class FormShop extends BaseShop {
    public FormShop(Shops shops) {
        super(shops);
    }

    @Override
    public Shops.Options getOption() {
        return Shops.Options.FORM;
    }

    FormConfig config = FusionPixelmon.getInstance().getConfiguration().getFormConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();
    @Override
    public InvPage buildPage() {
        Builder builder = new Builder("§0"+config.FormTitle(), "pokeeditor-form", 6)
                .setInfoItemData(config.FormInfoTitle(),
                        config.FormInfoString1(),
                        config.FormInfoString2(),
                        "",
                        config.FormInfoNote1())
                .setSelectedItemName(config.FormSelectedTitle())
                .setSelectedSlot(46)
                .setInfoSlot(48)
                .setResetSlot(50)
                .setBackSlot(52)
                .border(true)
                .setSelectedOption(getOption());
        InvPage page = builder.build();

        PokemonSpec spec = PokemonSpec.from(shops.pokemon.getSpecies().getPokemonName());
        spec.boss = null;
        Pokemon pokemon = spec.create();
        pokemon.setShiny(shops.pokemon.isShiny());

        int i = 9;
        List<IEnumForm> forms = pokemon.getSpecies().getPossibleForms(true);
        for (IEnumForm form : forms) {
            pokemon.setForm(form);
            InvItem item = new InvItem(REG.getPixelmonUtils().getPokeSprite(pokemon), (pokemon.isShiny() ? "§3"+config.FormShiny() : "§3") + pokemon.getSpecies().getPokemonName() + " §8(§e" + form.getLocalizedName() + "§8)");
            page.setItem(i, item, event -> {
                if (shops.pokemon.getFormEnum() != form) shops.getSelectedOptions().put(getOption(), form);
                else shops.getSelectedOptions().remove(getOption());
                builder.setSelectedItem(item.getItemStack());
            });
            i++;
        }
        return page;
    }

    @Override
    public int prices(Object value) {
        return getPriceOf(ConfigKeyConstants.CHANGE, 4000);
    }

    @Override
    protected void priceSummaries() {
        FormConfig config = FusionPixelmon.getInstance().getConfiguration().getFormConfig();
        addPriceSummary(config.FormPriceSummery(), getPriceOf(ConfigKeyConstants.CHANGE, 4000));
    }

    @Override
    public void purchaseAction(Object value) {
        shops.pokemon.setForm((IEnumForm) value);
    }

    private static class ConfigKeyConstants {
        private static final String CHANGE = "修改";
    }
}
