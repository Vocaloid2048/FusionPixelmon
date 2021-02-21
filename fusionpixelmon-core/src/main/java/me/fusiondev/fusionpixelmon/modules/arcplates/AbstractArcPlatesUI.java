package me.fusiondev.fusionpixelmon.modules.arcplates;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.Registry;
import me.fusiondev.fusionpixelmon.api.AbstractPlayer;
import me.fusiondev.fusionpixelmon.api.colour.Color;
import me.fusiondev.fusionpixelmon.api.colour.DyeColor;
import me.fusiondev.fusionpixelmon.api.inventory.InvItem;
import me.fusiondev.fusionpixelmon.api.inventory.InvPage;
import me.fusiondev.fusionpixelmon.api.items.AbstractItemStack;
import me.fusiondev.fusionpixelmon.api.pixelmon.ArcPlates;
import me.fusiondev.fusionpixelmon.api.ui.events.Event;
import me.fusiondev.fusionpixelmon.data.ArcPlateData;
import me.fusiondev.fusionpixelmon.impl.GrammarUtils;
import me.fusiondev.fusionpixelmon.modules.arcplates.config.ArcPlatesConfig;
import me.fusiondev.fusionpixelmon.voc.AbilityConfig;
import me.fusiondev.fusionpixelmon.voc.ArcPlateConfig;
import me.fusiondev.fusionpixelmon.voc.TranslateConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

/**
 * An interface which provides a method of storing and quick switching between
 * Arceus Plates to change Arceus' type and form.
 * The data is persisted by serialising to [config]/arcplates.
 * Supports multiple Players and multiple separate Arceus pokemon per player.
 */
public abstract class AbstractArcPlatesUI {

    /**
     * The number of rows in the ArcPlates UI.
     */
    protected static final int ROWS = 5;
    /**
     * The slots for the background in the UI.
     */
    protected static final int[] BACKGROUND_SLOTS = {0, 1, 9, 10, 18, 19, 27, 28, 36, 37};

    /**
     * Cooldown variable to prevent duping.
     */
    protected boolean enabled = true;

    private final File arcplatesDataFile;

    public AbstractArcPlatesUI(File arcplatesDataFile) {
        this.arcplatesDataFile = arcplatesDataFile;
    }

    protected AbstractPlayer player;
    protected Pokemon pokemon;
    protected ArcPlateData data;
    protected InvPage page;

    protected Registry reg = FusionPixelmon.getRegistry();

    /**
     * Launches the Arc Plates Storage interface for the specified
     * Player and Pokemon. Only an Arceus Pokemon should be passed
     * as this feature is irrelevant for other Pokemon.
     *
     * @param player  the player.
     * @param pokemon the Arceus pokemon.
     */

    ArcPlateConfig config = FusionPixelmon.getInstance().getConfiguration().getArcPlateConfig();
    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();
    public void launch(AbstractPlayer player, Pokemon pokemon) {
        if (pokemon.getSpecies() != EnumSpecies.Arceus) {
            throw new IllegalArgumentException(config.ArcPlatesNotArc());
        }
        this.player = player;
        this.pokemon = pokemon;
        this.data = new ArcPlateData(arcplatesDataFile, pokemon.getUUID());
        this.page = new InvPage("§8"+config.ArcPlatesPlates(), "arcplates", ROWS);

        create();
    }

    /**
     * Creates and opens the ArcPlates inventory UI.
     */
    protected void create() {
        // Save data to file upon closing GUI
        page.getEventHandler().add(Event.CLOSE_INVENTORY, (event, player1) -> data.save());

        // Handle inventory action
        page.getEventHandler().add(Event.CLICK_INVENTORY, this::clickInventory);

        // Background items
        AbstractItemStack backgroundStack = reg.getItemTypesRegistry().STAINED_GLASS_PANE()
                .to().setColour(DyeColor.BLACK);
        InvItem backgroundItem = new InvItem(backgroundStack, "");
        for (int backSlot : BACKGROUND_SLOTS) page.setItem(backSlot, backgroundItem);

        // GUI page runnable task
        page.setRunnable(() -> {
            for (ArcPlates.Plate plate : ArcPlates.Plate.values()) {
                AbstractItemStack stack;
                String name = "";
                if (!data.hasPlate(plate.i)) {
                    stack = plate.type.to();
                    if (plate.colour != null) stack.setColour(plate.colour);
                } else {
                    stack = FusionPixelmon.getRegistry().getPixelmonUtils().getPixelmonItemStack(plate.plate.name().toLowerCase() + "_plate");
                    String plateS = GrammarUtils.cap(plate.name());
                    if (Tconfig.Translation() == true){
                    if(GrammarUtils.cap(plate.name()).equals("Meadow")){plateS = "碧綠石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Flame")){plateS = "火球石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Splash")){plateS = "水滴石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Sky")){plateS = "藍天石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Insect")){plateS = "玉蟲石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Toxic")){plateS = "劇毒石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Zap")){plateS = "雷電石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Mind")){plateS = "神奇石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Stone")){plateS = "岩石石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Earth")){plateS = "大地石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Dread")){plateS = "惡顏石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Spooky")){plateS = "妖怪石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Iron")){plateS = "鋼鐵石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Fist")){plateS = "拳頭石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Icicle")){plateS = "冰柱石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Draco")){plateS = "龍之石板";}
                    if(GrammarUtils.cap(plate.name()).equals("Pixie")){plateS = "妖精石板";}}

                    name = "§a" +plateS;
                }
                page.setDynamicItem(plate.slot, new InvItem(stack, name));
            }

            if (FusionPixelmon.getInstance().getConfiguration().getArcPlates().getHovering().isEnabled()) {
                AbstractItemStack hoveringStack = reg.getItemTypesRegistry().DYE().to();
                EntityPixelmon entityPixelmon = pokemon.getPixelmonIfExists();

                hoveringStack.setColour(isActive(entityPixelmon) ? DyeColor.LIME : DyeColor.RED);
                InvItem hoveringItem = new InvItem(hoveringStack, "§b§l"+config.ArcPlatesPlateMove()).setLore(config.ArcPlatesPlateMoveInfo());
                page.setDynamicItem(27, hoveringItem, event -> {
                    if (entityPixelmon != null && entityPixelmon.isAddedToWorld()) {
                        deactivateForPlayer(entityPixelmon);
                        if (!isActive(entityPixelmon)) {
                            createRing(entityPixelmon);
                        } else {
                            deleteRing(entityPixelmon);
                            deactivate(entityPixelmon);
                        }
                    } else player.sendMessage(Color.RED + config.ArcPlatesPlateCallArc());
                });
            }
        });

        InvItem infoItem = new InvItem(reg.getItemTypesRegistry().PAPER(), "§b§l"+config.ArcPlatesPlateSave()).setLore(
                "",
                config.ArcPlatesPlateInfo1(),
                config.ArcPlatesPlateInfo1L(),
                config.ArcPlatesPlateInfo1R(),
                config.ArcPlatesPlateInfo2(),
                config.ArcPlatesPlateInfo2L()
        );
        int infoItemSlot = FusionPixelmon.getInstance().getConfiguration().getArcPlates().getHovering().isEnabled() ? 9 : 18;
        page.setItem(infoItemSlot, infoItem);

        reg.getInvInventory().openPage(player, page);
    }

    protected abstract void clickInventory(Object event, AbstractPlayer player);

    /**
     * Gets the plate ID from the slot where the plate is.
     *
     * @param slot the current slot location.
     * @return the ID of the plate at the specified slot.
     */
    protected int getIDFromSlot(int slot) {
        // todo plate slots are in ascending order, can break out of loop with plates.slot > slot if not found
        for (ArcPlates.Plate plate : ArcPlates.Plate.values()) if (plate.slot == slot) return plate.i;
        return -1;
    }


    /**
     * Stores the pixelmon entities and whether their ArcPlates hovering is enabled.
     * Realistically entities are only found in this map if hovering is enabled, as they
     * are removed upon disabling. Map is used to utilize it's O(1) lookup.
     */
    public static final HashMap<EntityPixelmon, Foxx> ACTIVATED = new HashMap<>();

    /**
     * Checks if the specified pixelmon entity has ArcPlates hovering enabled.
     *
     * @param entityPixelmon the pokemon entity.
     * @return true if the pixelmon entity is not null and has ArcPlates hovering active.
     */
    public static boolean isActive(EntityPixelmon entityPixelmon) {
        return entityPixelmon != null && ACTIVATED.containsKey(entityPixelmon);
    }

    /**
     * Activates ArcPlates hovering for the specified pixelmon entity.
     *
     * @param entityPixelmon the pokemon entity.
     */
    public void activate(EntityPixelmon entityPixelmon) {
        ACTIVATED.put(entityPixelmon, new Foxx());
    }

    /**
     * Deactivates ArcPlates hovering for the specified pixelmon entity.
     *
     * @param entityPixelmon the pokemon entity.
     */
    public void deactivate(EntityPixelmon entityPixelmon) {
        ACTIVATED.remove(entityPixelmon);
    }

    public Foxx get(EntityPixelmon entityPixelmon) {
        return ACTIVATED.get(entityPixelmon);
    }

    /**
     * Deactivates all the other active ArcPlates hoverings,
     * other than the specified Arceus entity's
     *
     * @param entityPixelmon the pokemon entity.
     */
    protected void deactivateForPlayer(EntityPixelmon entityPixelmon) {
        Optional<PlayerPartyStorage> partyStorage = entityPixelmon.getPlayerStorage();
        if (!partyStorage.isPresent()) return;
        for (int i = 0; i < 6; i++) {
            Pokemon pokemon = partyStorage.get().get(i);
            if (pokemon == null || pokemon.getSpecies() != EnumSpecies.Arceus || pokemon.getPixelmonIfExists() == entityPixelmon) {
                continue;
            }
            if (isActive(pokemon.getPixelmonIfExists())) {
                EntityPixelmon entityPixelmon1 = pokemon.getPixelmonIfExists();
                deleteRing(entityPixelmon1);
                deactivate(entityPixelmon1);
            }
        }
    }

    /**
     * Destroys all ArcPlate armor stands that are activate
     * in the world. This is intended to destroy any ArcPlate
     * armor stands active when shutting down the world.
     */
    public void cleanup() {
        ACTIVATED.forEach((entityPixelmon, exists) -> deleteRing(entityPixelmon));
        ACTIVATED.clear();
    }

    /**
     * Creates the ring around the specified pokemon entity.
     *
     * @param pokemonEntity the pokemon entity.
     */
    public abstract void createRing(EntityPixelmon pokemonEntity);

    /**
     * Deletes the ring around the specified pokemon entity.
     *
     * @param pokemonEntity the pokemon entity.
     */
    public abstract void deleteRing(EntityPixelmon pokemonEntity);

    public static final String ARMOR_STAND_NAME = "arceus_plate_stand";
    ///kill @e[type=armor_stand,name=arceus_plate_stand]

    private static final int RADIUS = 5;
    private static final int PLATES = ArcPlates.Plate.values().length;
    private int timeInterval = 0;

    /**
     * Loops through the plates for the ArcPlates hovering, and calculates the coordinates
     * of each point.
     * https://math.stackexchange.com/questions/1030655/how-do-we-find-points-on-a-circle-equidistant-from-each-other
     *
     * @param x0       the x origin.
     * @param y0       the y origin
     * @param runnable the LoopRunnable executor.
     */
    protected void loop(double x0, double y0, /*double z0, double angle,*/ LoopRunnable runnable) {
        double radian;
        for (ArcPlates.Plate plate : ArcPlates.Plate.values()) {
            if (data.hasPlate(plate.i)) {
                radian = 2 * Math.PI * (plate.i + timeInterval) / PLATES;
                double x = x0 + RADIUS * Math.cos(radian);
                double y = y0 + RADIUS * Math.sin(radian);
                runnable.run(x, y, plate);
                /*
                 * tan(theta)=opp/adj
                 * where theta is 45d
                 * tan(45)=z/x
                 * z=x*tan(45)
                 * where x is x0-x
                 */
                //double z = ((x0 - x) * -Math.tan(Math.toRadians(angle))) + z0;
                //runnable.run(x, y, z, plate);
            }
        }
        timeInterval++;
        if (timeInterval == PLATES) timeInterval = 0;
    }

    protected interface LoopRunnable {
        void run(double x, double y, ArcPlates.Plate plate);
    }
}
