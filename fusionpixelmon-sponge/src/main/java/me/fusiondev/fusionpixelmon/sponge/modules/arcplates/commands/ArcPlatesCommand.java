package me.fusiondev.fusionpixelmon.sponge.modules.arcplates.commands;

import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.AbstractPlayer;
import me.fusiondev.fusionpixelmon.api.colour.Color;
import me.fusiondev.fusionpixelmon.sponge.SpongeAdapter;
import me.fusiondev.fusionpixelmon.sponge.modules.arcplates.SpongeArcPlates;
import me.fusiondev.fusionpixelmon.ui.PokeSelectorUI;
import me.fusiondev.fusionpixelmon.voc.ZenConfig;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.plugin.meta.util.NonnullByDefault;

@NonnullByDefault
public class ArcPlatesCommand implements CommandExecutor {
    ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        if (!(src instanceof Player)) {
            src.sendMessage(Text.of(Color.RED + config.ZenCMDErrorPlayer()));
            return CommandResult.empty();
        }

        Player player = (Player) src;
        AbstractPlayer abstractPlayer = SpongeAdapter.adapt(player);
        new PokeSelectorUI(abstractPlayer, config.ZenArcDesign(), "arceusselector", pokemon -> {
            if (pokemon.getSpecies() == EnumSpecies.Arceus) new SpongeArcPlates().launch(abstractPlayer, pokemon);
            else player.sendMessage(Text.of(Color.RED + config.ZenCMDArcOnly()));
        });
        return CommandResult.success();
    }
}
