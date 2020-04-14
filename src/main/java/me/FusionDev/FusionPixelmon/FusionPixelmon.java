package me.FusionDev.FusionPixelmon;

import com.google.inject.Inject;
import me.FusionDev.FusionPixelmon.apis.UpdateChecker;
import me.FusionDev.FusionPixelmon.commands.ArcPlatesCmd;
import me.FusionDev.FusionPixelmon.commands.PokeDesignerCmd;

import me.FusionDev.FusionPixelmon.config.ConfigManager;
import me.FusionDev.FusionPixelmon.config.configs.Config;
import me.FusionDev.FusionPixelmon.inventory.InvInventory;
import me.FusionDev.FusionPixelmon.pixelmon.PokeShrinesListener;
import me.FusionDev.FusionPixelmon.pixelmon.PixelmonAPI;
import me.FusionDev.FusionPixelmon.pixelmon.PixelmonEvents;
import net.minecraftforge.common.MinecraftForge;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.*;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.ShapedCraftingRecipe;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static com.pixelmonmod.pixelmon.Pixelmon.EVENT_BUS;

@Plugin(id = FusionPixelmon.ID,
        name = FusionPixelmon.NAME,
        version = FusionPixelmon.VERSION,
        authors = {"BrendonCurmi/FusionDev"},
        description = "A plugin/mod hybrid that adds a little extra to Pixelmon servers!",
        dependencies = {
                @Dependency(id = "pixelmon", version = "7.0.8"),
                @Dependency(id = "spongeapi", version = "7.1.0")
        })
public class FusionPixelmon extends PluginInfo {

    // todo warning evolve down, cant evolve up if special evolve conditions
    // todo if change form and do something to affect form, wasted money
    // todo may need to update the lvl thing for nature as well

    /**
     * Contains a reference to this (soft) singleton class.
     */
    private static FusionPixelmon instance;

    public Path configDir;
    private Logger logger;
    private Config config;

    /**
     * Main class constructor that gets called by Sponge's classloader.
     *
     * @param pluginContainer the container passed by Sponge.
     */
    @Inject
    public FusionPixelmon(@ConfigDir(sharedRoot = false) Path configDir, Logger logger, PluginContainer pluginContainer) {
        FusionPixelmon.instance = this;
        this.configDir = configDir;
        this.logger = logger;
    }

    @Listener
    public void preInit(GamePreInitializationEvent event) {
        // Configs
        try {
            Files.createDirectories(this.configDir);
        } catch (IOException ex) {
            logger.error("Error loading '" + configDir.toString() + "' directory", ex);
        }

        try {
            Path path = Paths.get(this.configDir.toString(), ID + ".conf");

            if (!Files.exists(path)) {
                Optional<Asset> asset = Sponge.getAssetManager().getAsset(this, "default.conf");
                if (asset.isPresent()) asset.get().copyToFile(path);
            }

            // Load main config
            ConfigManager configManager = new ConfigManager(path);
            config = configManager.getNode().getValue(Config.type);

            // Load PokeDesigner config
            getConfig().getPokeDesignerConfig().loadPokeDesignerConfig(configManager.getLoader());
        } catch (IOException | ObjectMappingException ex) {
            logger.error("Config file could not be loaded", ex);
        }

        // Register commands through Sponge
        if (getConfig().isArcPlateEnabled()) {
            Sponge.getCommandManager().register(instance, CommandSpec.builder()
                    .description(Text.of("Opens the ArcPlates GUI to store your Type Plates for your Arceus"))
                    .permission(CMD_PERM + "arc")
                    .executor(new ArcPlatesCmd())
                    .build(), "arc");
        }

        if (getConfig().getPokeDesignerConfig().isEnabled()) {
            Sponge.getCommandManager().register(instance, CommandSpec.builder()
                    .description(Text.of("Open the PokeDesigner GUI to design your Pokemon"))
                    .permission(CMD_PERM + "pokedesigner")
                    .executor(new PokeDesignerCmd())
                    .build(), "pokedesigner", "pd");
        }

        // Register event listeners through Sponge
        if (!getConfig().getPickableShrines().isEmpty()) {
            Sponge.getEventManager().registerListeners(this, new PokeShrinesListener());
        }

        // Register pixelmon events through Forge
        if (getConfig().isAntiFallDamageEnabled()) {
            PixelmonEvents pixelmonEvents = new PixelmonEvents();
            MinecraftForge.EVENT_BUS.register(pixelmonEvents);
            EVENT_BUS.register(pixelmonEvents);
        }
    }

    @Listener
    public void init(GameInitializationEvent event) {
        if (getConfig().isMasterballCraftingEnabled()) {
            // Add Master Ball crafting recipe back
            ItemStack dye = ItemStack.builder().itemType(ItemTypes.DYE).build();
            dye.offer(Keys.DYE_COLOR, DyeColors.PURPLE);
            Sponge.getRegistry().getCraftingRecipeRegistry().register(
                    ShapedCraftingRecipe.builder()
                            .aisle("PPP", "OBO", "DDD")
                            .where('P', Ingredient.of(dye))
                            .where('O', Ingredient.of(ItemTypes.OBSIDIAN))
                            .where('B', Ingredient.of(ItemTypes.STONE_BUTTON))
                            .where('D', Ingredient.of(ItemTypes.DIAMOND))
                            .result(PixelmonAPI.getPixelmonItemStack("master_ball"))
                            .build("master_ball", this)
            );
        }
    }

    @Listener
    public void postInit(GamePostInitializationEvent event) {
        InvInventory.runUpdater();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Successfully running FusionPixelmon v" + VERSION + "!");
        try {
            UpdateChecker.check(logger);
        } catch (IOException ignored) {
            // If an exception occurs, just don't check for newer versions
        }
    }

    @Listener
    public void onServerStop(GameStoppedServerEvent event) {
        logger.info("Successfully stopped FusionPixelmon!");
    }

    public static FusionPixelmon getInstance() {
        return FusionPixelmon.instance;
    }

    public Config getConfig() {
        return FusionPixelmon.instance.config;
    }
}