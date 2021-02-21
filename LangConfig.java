package me.fusiondev.fusionpixelmon.voc;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * LangConfig was added by Voc-夜芷冰
 */

@Plugin(id="fusionlanguage" , name="Language File" , version = "1.11.0") // According to the plugin's version
public class LangConfig {
    @Inject
    @DefaultConfig(sharedRoot = false)
    public ConfigurationLoader<CommentedConfigurationNode> configurationLoader = null;

    @Inject
    @DefaultConfig(sharedRoot = false)
    public File configuration = null;

    @Inject
    Logger logger;

    public CommentedConfigurationNode configurationNode = null;

    @Listener
    public void onInit (GamePreInitializationEvent event){
        try{
            if (!configuration.exists()){
                configuration.createNewFile();
                configurationNode = configurationLoader.load();

                /**
                 * I must tell you, better not to read them else you have enough time and you know what I'm talking about
                 * This is the default String (en-UK) [I'm tring to not using the US translation, if I made mistakes pls let me know, I will replace it as soon as possible]
                 * if need translation of zh-HK / zh-TW, I'll put the way of it into readme.md
                 * Finally, thx for giving me a chance to help translation, 3Q ~
                 */

                /**
                 * Edit at 20210220, base on FusionPixelmon 1.11.0 | PixelmonMod 8.1.0
                 */

                partMain();

                configurationLoader.save(configurationNode);
            }
            configurationNode = configurationLoader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public CommentedConfigurationNode rootNode (){
        return configurationNode;
    }

    public void partMain(){
        configurationNode.getNode("Ability","AbilityTitle").setValue("Ability Modification");
        configurationNode.getNode("Ability","AbilityInfoTitle").setValue("Ability Info");
        configurationNode.getNode("Ability","AbilityInfoString1").setValue("To pick an ability for your Pokemon");
        configurationNode.getNode("Ability","AbilityInfoString2").setValue("simply select one of the possible options on the right.");
        configurationNode.getNode("Ability","AbilitySelectedTitle").setValue("Selected Ability");
        configurationNode.getNode("Ability","AbilityNormalSummary").setValue("Regular Ability");
        configurationNode.getNode("Ability","AbilitySpecialSummary").setValue("Special Ability");
        configurationNode.getNode("Ability","AbilityREGULAR").setValue("regular");
        configurationNode.getNode("Ability","AbilitySPECIAL").setValue("special");
        configurationNode.getNode("Evolution","EvolutionTitle").setValue("Evolution Modification");
        configurationNode.getNode("Evolution","EvolutionInfoTitle").setValue("Evolution Info");
        configurationNode.getNode("Evolution","EvolutionInfoString1").setValue("To modify the evolution of your Pokemon");
        configurationNode.getNode("Evolution","EvolutionInfoString2").setValue("simply use the above options.");
        configurationNode.getNode("Evolution","EvolutionInfoNote1").setValue("Note: can only get evolutions obtained by levelling.");
        configurationNode.getNode("Evolution","EvolutionInfoNote2").setValue("Evolving down may not permit to evolve back up.");
        configurationNode.getNode("Evolution","EvolutionSelectedTitle").setValue("Selected Evolution");
        configurationNode.getNode("Evolution","EvolutionPriceSummary").setValue("Change Evolution");
        configurationNode.getNode("Evolution","EvolutionCHANGE").setValue("change");
        configurationNode.getNode("Evolution","EvolutionNameS").setValue("Unknown");
        configurationNode.getNode("Form","FormTitle").setValue("Form Modification");
        configurationNode.getNode("Form","FormInfoTitle").setValue("Form Info");
        configurationNode.getNode("Form","FormInfoString1").setValue("To select a form for your Pokemon");
        configurationNode.getNode("Form","FormInfoString2").setValue("select one of the above options.");
        configurationNode.getNode("Form","FormInfoNote1").setValue("Note: Pokemon can revert/change form from held item change.");

        configurationNode.getNode("Form","FormSelectedTitle").setValue("Selected Form");
        configurationNode.getNode("Form","FormShiny").setValue("Shiny");
        configurationNode.getNode("Form","FormPriceSummery").setValue("Form Change");
        configurationNode.getNode("Form","FormCHANGE").setValue("change");
        configurationNode.getNode("Gender","GenderTitle").setValue("Gender Modification");
        configurationNode.getNode("Gender","GenderInfoTitle").setValue("Gender Info");
        configurationNode.getNode("Gender","GenderInfoString1").setValue("To pick a gender for your Pokemon");
        configurationNode.getNode("Gender","GenderInfoString2").setValue("simply select one of the options on the right.");
        configurationNode.getNode("Gender","GenderSelectedTitle").setValue("Selected Gender");
        configurationNode.getNode("Gender","GenderNoSex").setValue("None");
        configurationNode.getNode("Gender","GenderInvMale").setValue("Male");
        configurationNode.getNode("Gender","GenderSetMale").setValue("Click here to select the §bMale §7gender.");
        configurationNode.getNode("Gender","GenderSelectedMale").setValue("Male");
        configurationNode.getNode("Gender","GenderInvFemale").setValue("Female");
        configurationNode.getNode("Gender","GenderSetFemale").setValue("Click here to select the §dFemale §7gender.");
        configurationNode.getNode("Gender","GenderSelectedFemale").setValue("Female");
        configurationNode.getNode("Gender","GenderPriceSummary").setValue("Gender Change");
        configurationNode.getNode("Gender","GenderCHANGE").setValue("change");
        configurationNode.getNode("Shop","ShopLEVEL").setValue("Level");
        configurationNode.getNode("Shop","ShopABILITY").setValue("Ability");
        configurationNode.getNode("Shop","ShopNATURE").setValue("Nature");
        configurationNode.getNode("Shop","ShopIVEV").setValue("IVs/EVs");
        configurationNode.getNode("Shop","ShopGENDER").setValue("Gender");
        configurationNode.getNode("Shop","ShopGROWTH").setValue("Growth");
        configurationNode.getNode("Shop","ShopSHINY").setValue("Shiny");
        configurationNode.getNode("Shop","ShopPOKEBALL").setValue("Pokeball");
        configurationNode.getNode("Shop","ShopFORM").setValue("Form");
        configurationNode.getNode("Shop","ShopEVOLUTION").setValue("Evolution");
        configurationNode.getNode("Shop","ShopNICK").setValue("Nick");
        configurationNode.getNode("Shop","ShopMOVE").setValue("Moves");
        configurationNode.getNode("Shop","ShopConfirm").setValue("Confirm");
        configurationNode.getNode("Shop","ShopCheckoutAsk").setValue("This will take you to the final checkout page.");
        configurationNode.getNode("Shop","ShopCancel").setValue("Cancel");
        configurationNode.getNode("Shop","ShopCurrBalance").setValue("§2Current Balance: §a");
        configurationNode.getNode("Shop","ShopChoosedPokemon").setValue("Selected Pokemon");
        configurationNode.getNode("Shop","ShopCheckoutTitle").setValue("Checkout");
        configurationNode.getNode("Shop","ShopConfirmInfo1").setValue("Your total cost is: §c");
        configurationNode.getNode("Shop","ShopConfirmInfo2").setValue("Clicking this button will confirm your purchase.");
        configurationNode.getNode("Shop","ShopConfirmInfo3").setValue("Once clicked, changes cannot be reversed.");
        configurationNode.getNode("Shop","ShopConfirmInfo4").setValue("Your updated balance will be §a");
        configurationNode.getNode("Shop","ShopConfirmInfoLackOfMoney").setValue("You are not able to make this purchase.");
        configurationNode.getNode("Shop","ShopConfirmInfoError").setValue("You are not able to make this transaction");
        configurationNode.getNode("Shop","ShopConfirmDONE").setValue("Successfully edited your Pokemon!");
        configurationNode.getNode("Shop","ShopBuy").setValue("Purchasing");
        configurationNode.getNode("Shop","ShopPressRefresh").setValue("[click to refresh]");
        configurationNode.getNode("Shop","ShopCurrentCost").setValue("Current Cost:");
        configurationNode.getNode("Shop","ShopEditAskPart1").setValue("Click here if you wish to modify your Pokemon's ");
        configurationNode.getNode("Shop","ShopEditAskPart2").setValue(".");
        configurationNode.getNode("Shop","ShopPrice").setValue("Prices:");
        configurationNode.getNode("IVEV","IVEVTitle").setValue("IV/EV Modification");
        configurationNode.getNode("IVEV","IVEVInfoTitle").setValue("IV/EV Info");
        configurationNode.getNode("IVEV","IVEVInfoString1").setValue("To modify the IVs/EVs for your Pokemon");
        configurationNode.getNode("IVEV","IVEVInfoString2").setValue("simply use the options.");
        configurationNode.getNode("IVEV","IVEVNotes").setValue("Note:");
        configurationNode.getNode("IVEV","IVEVLeftClick").setValue("Left Click:");
        configurationNode.getNode("IVEV","IVEVLeftClickShift").setValue("Left Click + Shift:");
        configurationNode.getNode("IVEV","IVEVHP").setValue("HP");
        configurationNode.getNode("IVEV","IVEVATK").setValue("ATK");
        configurationNode.getNode("IVEV","IVEVDEF").setValue("DEF");
        configurationNode.getNode("IVEV","IVEVSATK").setValue("SA");
        configurationNode.getNode("IVEV","IVEVSDEF").setValue("SD");
        configurationNode.getNode("IVEV","IVEVSPD").setValue("SPD");
        configurationNode.getNode("IVEV","IVEVDecrease").setValue("Decrease");
        configurationNode.getNode("IVEV","IVEVIncrease").setValue("Increase");
        configurationNode.getNode("IVEV","IVEVCurrent").setValue("Current:");
        configurationNode.getNode("IVEV","IVEVCurrentTotal").setValue("Current Total:");
        configurationNode.getNode("IVEV","IVEVRequested").setValue("Requested:");
        configurationNode.getNode("IVEV","IVEVRequestedTotal").setValue("Requested Total:");
        configurationNode.getNode("IVEV","IVEVEach").setValue("per");
        configurationNode.getNode("Level","LevelTitle").setValue("Level Modification");
        configurationNode.getNode("Level","LevelInfoTitle").setValue("Level Info");
        configurationNode.getNode("Level","LevelInfoString1").setValue("To modify the levels for your Pokemon");
        configurationNode.getNode("Level","LevelInfoString2").setValue("simply use the above options.");
        configurationNode.getNode("Level","LevelSelectedTitle").setValue("Selected Levels");
        configurationNode.getNode("Level","LevelIncreaseLvl").setValue("Add Level");
        configurationNode.getNode("Level","LevelPressIncrease").setValue("Click here to increase the level of your pokemon.");
        configurationNode.getNode("Level","LevelNotes").setValue("Note:");
        configurationNode.getNode("Level","LevelLeftClick").setValue("Left Click:");
        configurationNode.getNode("Level","LevelLeftClickShift").setValue("Left Click + Shift:");
        configurationNode.getNode("Level","LevelDecreaseLvl").setValue("Remove Level");
        configurationNode.getNode("Level","LevelPressDecrease").setValue("Click here to decrease the");
        configurationNode.getNode("Level","LevelEach").setValue("per level");
        configurationNode.getNode("Move","MoveTitle").setValue("Move Modification");
        configurationNode.getNode("Move","MoveInfoTitle").setValue("Move Info");
        configurationNode.getNode("Move","MoveInfoString1").setValue("To pick a move for your Pokemon simply");
        configurationNode.getNode("Move","MoveInfoString2").setValue("click the move you wish to replace and");
        configurationNode.getNode("Move","MoveInfoString3").setValue("then choose the move you wish to learn instead.");
        configurationNode.getNode("Move","MoveSelectedTitle").setValue("Selected Move");
        configurationNode.getNode("Move","MoveMoveS").setValue("None");
        configurationNode.getNode("Move","MoveLetStudy").setValue("Teach your Pokemon this move");
        configurationNode.getNode("Move","MovePreviousPage").setValue("Back");
        configurationNode.getNode("Move","MoveNextPage").setValue("Next");
        configurationNode.getNode("Move","MovePriceSummary").setValue("Change Move");
        configurationNode.getNode("Move","MoveEach").setValue("per move");
        configurationNode.getNode("Move","MoveCHANGE").setValue("change-move");
        configurationNode.getNode("Nature","NatureTitle").setValue("Nature Modification");
        configurationNode.getNode("Nature","NatureInfoTitle").setValue("Nature Info");
        configurationNode.getNode("Nature","NatureInfoString1").setValue("To pick a nature for your Pokemon");
        configurationNode.getNode("Nature","NatureInfoString2").setValue("simply select one of the options on the right.");
        configurationNode.getNode("Nature","NatureSelectedTitle").setValue("Selected Nature");
        configurationNode.getNode("Nature","NatureIncreased").setValue("Boosted:");
        configurationNode.getNode("Nature","NatureDecreased").setValue("Lowered:");
        configurationNode.getNode("Nature","NaturePriceSummary").setValue("Nature Change");
        configurationNode.getNode("Nature","NatureCHANGE").setValue("change");
        configurationNode.getNode("Nature","NatureHP").setValue("HP");
        configurationNode.getNode("Nature","NatureATK").setValue("Attack");
        configurationNode.getNode("Nature","NatureDEF").setValue("Defence");
        configurationNode.getNode("Nature","NatureSATK").setValue("Special Attack");
        configurationNode.getNode("Nature","NatureSDEF").setValue("Special Defence");
        configurationNode.getNode("Nature","NatureSPD").setValue("Speed");
        configurationNode.getNode("Nick","NickTitle").setValue("Nick Modification");
        configurationNode.getNode("Nick","NickInfoTitle").setValue("Nick Info");
        configurationNode.getNode("Nick","NickInfoString1").setValue("To pick a nick colour or style for your");
        configurationNode.getNode("Nick","NickInfoString2").setValue("Pokemon simply use the options above.");
        configurationNode.getNode("Nick","NickInfoString3").setValue("Colours and styles can be bought at once.");
        configurationNode.getNode("Nick","NickSelectedTitle").setValue("Selected Nick Colour");
        configurationNode.getNode("Nick","NickDarkRed").setValue("Dark red");
        configurationNode.getNode("Nick","NickRed").setValue("Red red");
        configurationNode.getNode("Nick","NickGold").setValue("Gold");
        configurationNode.getNode("Nick","NickYellow").setValue("Yellow");
        configurationNode.getNode("Nick","NickDarkGreen").setValue("Dark Green");
        configurationNode.getNode("Nick","NickGreen").setValue("Green");
        configurationNode.getNode("Nick","NickAqua").setValue("Aqua");
        configurationNode.getNode("Nick","NickDarkAqua").setValue("Dark Aqua");
        configurationNode.getNode("Nick","NickDarkBlue").setValue("Dark Blue");
        configurationNode.getNode("Nick","NickBlue").setValue("Blue");
        configurationNode.getNode("Nick","NickLightPurple").setValue("Light Purple");
        configurationNode.getNode("Nick","NickPurple").setValue("Purple");
        configurationNode.getNode("Nick","NickWhite").setValue("White");
        configurationNode.getNode("Nick","NickGray").setValue("Gray");
        configurationNode.getNode("Nick","NickDarkGray").setValue("Dark Gray");
        configurationNode.getNode("Nick","NickBlack").setValue("Black");
        configurationNode.getNode("Nick","NickObfuscated").setValue("Obfuscated");
        configurationNode.getNode("Nick","NickBold").setValue("Bold");
        configurationNode.getNode("Nick","NickStrikethrough").setValue("Strikethrough");
        configurationNode.getNode("Nick","NickUnderline").setValue("Underline");
        configurationNode.getNode("Nick","NickItalic").setValue("Italic");
        configurationNode.getNode("Nick","NickReset").setValue("Reset");
        configurationNode.getNode("Nick","NickcolorPriceSummary").setValue("change-colour");
        configurationNode.getNode("Nick","NickthemePriceSummary").setValue("change-style");
        configurationNode.getNode("PokeBall","PokeBallTitle").setValue("okeball Modification");
        configurationNode.getNode("PokeBall","PokeBallInfoTitle").setValue("Pokeball Info");
        configurationNode.getNode("PokeBall","PokeBallInfoString1").setValue("To pick the Pokeball for your Pokemon");
        configurationNode.getNode("PokeBall","PokeBallInfoString2").setValue("simply use the options above.");
        configurationNode.getNode("PokeBall","PokeBallSelectedTitle").setValue("Selected Pokeball");
        configurationNode.getNode("PokeBall","PokeBallREGULAR").setValue("regular");
        configurationNode.getNode("PokeBall","PokeBallSPECIAL").setValue("special");
        configurationNode.getNode("PokeBall","PokeBallGOD").setValue("god");
        configurationNode.getNode("PokeBall","PokeBallBEAST").setValue("beast");
        configurationNode.getNode("Shiny","ShinyTitle").setValue("Shininess Modification");
        configurationNode.getNode("Shiny","ShinyInfoTitle").setValue("Shiny Info");
        configurationNode.getNode("Shiny","ShinyInfoString1").setValue("To select the shininess of");
        configurationNode.getNode("Shiny","ShinyInfoString2").setValue("your Pokemon simply select one of the options on the right.");
        configurationNode.getNode("Shiny","ShinySelectedTitle").setValue("Selected Shininess");
        configurationNode.getNode("Shiny","ShinyShinyTrue").setValue("§6§lShiny");
        configurationNode.getNode("Shiny","ShinyShinyTrueChoose").setValue("Click here to select the §6Shiny §7option.");
        configurationNode.getNode("Shiny","ShinyShinyFalse").setValue("§8§lNon-Shiny");
        configurationNode.getNode("Shiny","ShinyShinyFalseChoose").setValue("Click here to select the §8Non-Shiny §7option.");
        configurationNode.getNode("Shiny","ShinyshinyAPriceSummay").setValue("Add Shininess");
        configurationNode.getNode("Shiny","ShinyshinyRPriceSummary").setValue("Remove Shininess");
        configurationNode.getNode("Shiny","ShinynormalAPriceSummary").setValue("add");
        configurationNode.getNode("Shiny","ShinynormalRPriceSummary").setValue("remove");

    }

    public String AbilityTitle() { return String.valueOf(configurationNode.getNode("AbilityTitle","AbilityTitle").getValue());}
    public String AbilityInfoTitle() { return String.valueOf(configurationNode.getNode("Ability","AbilityInfoTitle").getValue());}
    public String AbilityInfoString1() { return String.valueOf(configurationNode.getNode("Ability","AbilityInfoString1").getValue());}
    public String AbilityInfoString2() { return String.valueOf(configurationNode.getNode("Ability","AbilityInfoString2").getValue());}
    public String AbilitySelectedTitle() { return String.valueOf(configurationNode.getNode("Ability","AbilitySelectedTitle").getValue());}
    public String AbilityNormalSummary() { return String.valueOf(configurationNode.getNode("Ability","AbilityNormalSummary").getValue());}
    public String AbilitySpecialSummary() { return String.valueOf(configurationNode.getNode("Ability","AbilitySpecialSummary").getValue());}
    public String AbilityREGULAR() { return String.valueOf(configurationNode.getNode("Ability","AbilityREGULAR").getValue());}
    public String AbilitySPECIAL() { return String.valueOf(configurationNode.getNode("Ability","AbilitySPECIAL").getValue());}
    public String EvolutionTitle() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionTitle").getValue());}
    public String EvolutionInfoTitle() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionInfoTitle").getValue());}
    public String EvolutionInfoString1() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionInfoString1").getValue());}
    public String EvolutionInfoString2() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionInfoString2").getValue());}
    public String EvolutionInfoNote1() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionInfoNote1").getValue());}
    public String EvolutionInfoNote2() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionInfoNote2").getValue());}
    public String EvolutionSelectedTitle() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionSelectedTitle").getValue());}
    public String EvolutionPriceSummary() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionPriceSummary").getValue());}
    public String EvolutionCHANGE() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionCHANGE").getValue());}
    public String EvolutionNameS() { return String.valueOf(configurationNode.getNode("Evolution","EvolutionNameS").getValue());}
    public String FormTitle() { return String.valueOf(configurationNode.getNode("Form","FormTitle").getValue());}
    public String FormInfoTitle() { return String.valueOf(configurationNode.getNode("Form","FormInfoTitle").getValue());}
    public String FormInfoString1() { return String.valueOf(configurationNode.getNode("Form","FormInfoString1").getValue());}
    public String FormInfoString2() { return String.valueOf(configurationNode.getNode("Form","FormInfoString2").getValue());}
    public String FormInfoNote1() { return String.valueOf(configurationNode.getNode("Form","FormInfoNote1").getValue());}

    public String FormSelectedTitle() { return String.valueOf(configurationNode.getNode("Form","FormSelectedTitle").getValue());}
    public String FormShiny() { return String.valueOf(configurationNode.getNode("Form","FormShiny").getValue());}
    public String FormPriceSummery() { return String.valueOf(configurationNode.getNode("Form","FormPriceSummery").getValue());}
    public String FormCHANGE() { return String.valueOf(configurationNode.getNode("Form","FormCHANGE").getValue());}
    public String GenderTitle() { return String.valueOf(configurationNode.getNode("Gender","GenderTitle").getValue());}
    public String GenderInfoTitle() { return String.valueOf(configurationNode.getNode("Gender","GenderInfoTitle").getValue());}
    public String GenderInfoString1() { return String.valueOf(configurationNode.getNode("Gender","GenderInfoString1").getValue());}
    public String GenderInfoString2() { return String.valueOf(configurationNode.getNode("Gender","GenderInfoString2").getValue());}
    public String GenderSelectedTitle() { return String.valueOf(configurationNode.getNode("Gender","GenderSelectedTitle").getValue());}
    public String GenderNoSex() { return String.valueOf(configurationNode.getNode("Gender","GenderNoSex").getValue());}
    public String GenderInvMale() { return String.valueOf(configurationNode.getNode("Gender","GenderInvMale").getValue());}
    public String GenderSetMale() { return String.valueOf(configurationNode.getNode("Gender","GenderSetMale").getValue());}
    public String GenderSelectedMale() { return String.valueOf(configurationNode.getNode("Gender","GenderSelectedMale").getValue());}
    public String GenderInvFemale() { return String.valueOf(configurationNode.getNode("Gender","GenderInvFemale").getValue());}
    public String GenderSetFemale() { return String.valueOf(configurationNode.getNode("Gender","GenderSetFemale").getValue());}
    public String GenderSelectedFemale() { return String.valueOf(configurationNode.getNode("Gender","GenderSelectedFemale").getValue());}
    public String GenderPriceSummary() { return String.valueOf(configurationNode.getNode("Gender","GenderPriceSummary").getValue());}
    public String GenderCHANGE() { return String.valueOf(configurationNode.getNode("Gender","GenderCHANGE").getValue());}
    public String ShopLEVEL() { return String.valueOf(configurationNode.getNode("Shop","ShopLEVEL").getValue());}
    public String ShopABILITY() { return String.valueOf(configurationNode.getNode("Shop","ShopABILITY").getValue());}
    public String ShopNATURE() { return String.valueOf(configurationNode.getNode("Shop","ShopNATURE").getValue());}
    public String ShopIVEV() { return String.valueOf(configurationNode.getNode("Shop","ShopIVEV").getValue());}
    public String ShopGENDER() { return String.valueOf(configurationNode.getNode("Shop","ShopGENDER").getValue());}
    public String ShopGROWTH() { return String.valueOf(configurationNode.getNode("Shop","ShopGROWTH").getValue());}
    public String ShopSHINY() { return String.valueOf(configurationNode.getNode("Shop","ShopSHINY").getValue());}
    public String ShopPOKEBALL() { return String.valueOf(configurationNode.getNode("Shop","ShopPOKEBALL").getValue());}
    public String ShopFORM() { return String.valueOf(configurationNode.getNode("Shop","ShopFORM").getValue());}
    public String ShopEVOLUTION() { return String.valueOf(configurationNode.getNode("Shop","ShopEVOLUTION").getValue());}
    public String ShopNICK() { return String.valueOf(configurationNode.getNode("Shop","ShopNICK").getValue());}
    public String ShopMOVE() { return String.valueOf(configurationNode.getNode("Shop","ShopMOVE").getValue());}
    public String ShopConfirm() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirm").getValue());}
    public String ShopCheckoutAsk() { return String.valueOf(configurationNode.getNode("Shop","ShopCheckoutAsk").getValue());}
    public String ShopCancel() { return String.valueOf(configurationNode.getNode("Shop","ShopCancel").getValue());}
    public String ShopCurrBalance() { return String.valueOf(configurationNode.getNode("Shop","ShopCurrBalance").getValue());}
    public String ShopChoosedPokemon() { return String.valueOf(configurationNode.getNode("Shop","ShopChoosedPokemon").getValue());}
    public String ShopCheckoutTitle() { return String.valueOf(configurationNode.getNode("Shop","ShopCheckoutTitle").getValue());}
    public String ShopConfirmInfo1() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfo1").getValue());}
    public String ShopConfirmInfo2() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfo2").getValue());}
    public String ShopConfirmInfo3() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfo3").getValue());}
    public String ShopConfirmInfo4() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfo4").getValue());}
    public String ShopConfirmInfoLackOfMoney() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfoLackOfMoney").getValue());}
    public String ShopConfirmInfoError() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmInfoError").getValue());}
    public String ShopConfirmDONE() { return String.valueOf(configurationNode.getNode("Shop","ShopConfirmDONE").getValue());}
    public String ShopBuy() { return String.valueOf(configurationNode.getNode("Shop","ShopBuy").getValue());}
    public String ShopPressRefresh() { return String.valueOf(configurationNode.getNode("Shop","ShopPressRefresh").getValue());}
    public String ShopCurrentCost() { return String.valueOf(configurationNode.getNode("Shop","ShopCurrentCost").getValue());}
    public String ShopEditAskPart1() { return String.valueOf(configurationNode.getNode("Shop","ShopEditAskPart1").getValue());}
    public String ShopEditAskPart2() { return String.valueOf(configurationNode.getNode("Shop","ShopEditAskPart2").getValue());}
    public String ShopPrice() { return String.valueOf(configurationNode.getNode("Shop","ShopPrice").getValue());}
    public String IVEVTitle() { return String.valueOf(configurationNode.getNode("IVEV","IVEVTitle").getValue());}
    public String IVEVInfoTitle() { return String.valueOf(configurationNode.getNode("IVEV","IVEVInfoTitle").getValue());}
    public String IVEVInfoString1() { return String.valueOf(configurationNode.getNode("IVEV","IVEVInfoString1").getValue());}
    public String IVEVInfoString2() { return String.valueOf(configurationNode.getNode("IVEV","IVEVInfoString2").getValue());}
    public String IVEVNotes() { return String.valueOf(configurationNode.getNode("IVEV","IVEVNotes").getValue());}
    public String IVEVLeftClick() { return String.valueOf(configurationNode.getNode("IVEV","IVEVLeftClick").getValue());}
    public String IVEVLeftClickShift() { return String.valueOf(configurationNode.getNode("IVEV","IVEVLeftClickShift").getValue());}
    public String IVEVHP() { return String.valueOf(configurationNode.getNode("IVEV","IVEVHP").getValue());}
    public String IVEVATK() { return String.valueOf(configurationNode.getNode("IVEV","IVEVATK").getValue());}
    public String IVEVDEF() { return String.valueOf(configurationNode.getNode("IVEV","IVEVDEF").getValue());}
    public String IVEVSATK() { return String.valueOf(configurationNode.getNode("IVEV","IVEVSATK").getValue());}
    public String IVEVSDEF() { return String.valueOf(configurationNode.getNode("IVEV","IVEVSDEF").getValue());}
    public String IVEVSPD() { return String.valueOf(configurationNode.getNode("IVEV","IVEVSPD").getValue());}
    public String IVEVDecrease() { return String.valueOf(configurationNode.getNode("IVEV","IVEVDecrease").getValue());}
    public String IVEVIncrease() { return String.valueOf(configurationNode.getNode("IVEV","IVEVIncrease").getValue());}
    public String IVEVCurrent() { return String.valueOf(configurationNode.getNode("IVEV","IVEVCurrent").getValue());}
    public String IVEVCurrentTotal() { return String.valueOf(configurationNode.getNode("IVEV","IVEVCurrentTotal").getValue());}
    public String IVEVRequested() { return String.valueOf(configurationNode.getNode("IVEV","IVEVRequested").getValue());}
    public String IVEVRequestedTotal() { return String.valueOf(configurationNode.getNode("IVEV","IVEVRequestedTotal").getValue());}
    public String IVEVEach() { return String.valueOf(configurationNode.getNode("IVEV","IVEVEach").getValue());}
    public String LevelTitle() { return String.valueOf(configurationNode.getNode("Level","LevelTitle").getValue());}
    public String LevelInfoTitle() { return String.valueOf(configurationNode.getNode("Level","LevelInfoTitle").getValue());}
    public String LevelInfoString1() { return String.valueOf(configurationNode.getNode("Level","LevelInfoString1").getValue());}
    public String LevelInfoString2() { return String.valueOf(configurationNode.getNode("Level","LevelInfoString2").getValue());}
    public String LevelSelectedTitle() { return String.valueOf(configurationNode.getNode("Level","LevelSelectedTitle").getValue());}
    public String LevelIncreaseLvl() { return String.valueOf(configurationNode.getNode("Level","LevelIncreaseLvl").getValue());}
    public String LevelPressIncrease() { return String.valueOf(configurationNode.getNode("Level","LevelPressIncrease").getValue());}
    public String LevelNotes() { return String.valueOf(configurationNode.getNode("Level","LevelNotes").getValue());}
    public String LevelLeftClick() { return String.valueOf(configurationNode.getNode("Level","LevelLeftClick").getValue());}
    public String LevelLeftClickShift() { return String.valueOf(configurationNode.getNode("Level","LevelLeftClickShift").getValue());}
    public String LevelDecreaseLvl() { return String.valueOf(configurationNode.getNode("Level","LevelDecreaseLvl").getValue());}
    public String LevelPressDecrease() { return String.valueOf(configurationNode.getNode("Level","LevelPressDecrease").getValue());}
    public String LevelEach() { return String.valueOf(configurationNode.getNode("Level","LevelEach").getValue());}
    public String MoveTitle() { return String.valueOf(configurationNode.getNode("Move","MoveTitle").getValue());}
    public String MoveInfoTitle() { return String.valueOf(configurationNode.getNode("Move","MoveInfoTitle").getValue());}
    public String MoveInfoString1() { return String.valueOf(configurationNode.getNode("Move","MoveInfoString1").getValue());}
    public String MoveInfoString2() { return String.valueOf(configurationNode.getNode("Move","MoveInfoString2").getValue());}
    public String MoveInfoString3() { return String.valueOf(configurationNode.getNode("Move","MoveInfoString3").getValue());}
    public String MoveSelectedTitle() { return String.valueOf(configurationNode.getNode("Move","MoveSelectedTitle").getValue());}
    public String MoveMoveS() { return String.valueOf(configurationNode.getNode("Move","MoveMoveS").getValue());}
    public String MoveLetStudy() { return String.valueOf(configurationNode.getNode("Move","MoveLetStudy").getValue());}
    public String MovePreviousPage() { return String.valueOf(configurationNode.getNode("Move","MovePreviousPage").getValue());}
    public String MoveNextPage() { return String.valueOf(configurationNode.getNode("Move","MoveNextPage").getValue());}
    public String MovePriceSummary() { return String.valueOf(configurationNode.getNode("Move","MovePriceSummary").getValue());}
    public String MoveEach() { return String.valueOf(configurationNode.getNode("Move","MoveEach").getValue());}
    public String MoveCHANGE() { return String.valueOf(configurationNode.getNode("Move","MoveCHANGE").getValue());}
    public String NatureTitle() { return String.valueOf(configurationNode.getNode("Nature","NatureTitle").getValue());}
    public String NatureInfoTitle() { return String.valueOf(configurationNode.getNode("Nature","NatureInfoTitle").getValue());}
    public String NatureInfoString1() { return String.valueOf(configurationNode.getNode("Nature","NatureInfoString1").getValue());}
    public String NatureInfoString2() { return String.valueOf(configurationNode.getNode("Nature","NatureInfoString2").getValue());}
    public String NatureSelectedTitle() { return String.valueOf(configurationNode.getNode("Nature","NatureSelectedTitle").getValue());}
    public String NatureIncreased() { return String.valueOf(configurationNode.getNode("Nature","NatureIncreased").getValue());}
    public String NatureDecreased() { return String.valueOf(configurationNode.getNode("Nature","NatureDecreased").getValue());}
    public String NaturePriceSummary() { return String.valueOf(configurationNode.getNode("Nature","NaturePriceSummary").getValue());}
    public String NatureCHANGE() { return String.valueOf(configurationNode.getNode("Nature","NatureCHANGE").getValue());}
    public String NatureHP() { return String.valueOf(configurationNode.getNode("Nature","NatureHP").getValue());}
    public String NatureATK() { return String.valueOf(configurationNode.getNode("Nature","NatureATK").getValue());}
    public String NatureDEF() { return String.valueOf(configurationNode.getNode("Nature","NatureDEF").getValue());}
    public String NatureSATK() { return String.valueOf(configurationNode.getNode("Nature","NatureSATK").getValue());}
    public String NatureSDEF() { return String.valueOf(configurationNode.getNode("Nature","NatureSDEF").getValue());}
    public String NatureSPD() { return String.valueOf(configurationNode.getNode("Nature","NatureSPD").getValue());}
    public String NickTitle() { return String.valueOf(configurationNode.getNode("Nick","NickTitle").getValue());}
    public String NickInfoTitle() { return String.valueOf(configurationNode.getNode("Nick","NickInfoTitle").getValue());}
    public String NickInfoString1() { return String.valueOf(configurationNode.getNode("Nick","NickInfoString1").getValue());}
    public String NickInfoString2() { return String.valueOf(configurationNode.getNode("Nick","NickInfoString2").getValue());}
    public String NickInfoString3() { return String.valueOf(configurationNode.getNode("Nick","NickInfoString3").getValue());}
    public String NickSelectedTitle() { return String.valueOf(configurationNode.getNode("Nick","NickSelectedTitle").getValue());}
    public String NickDarkRed() { return String.valueOf(configurationNode.getNode("Nick","NickDarkRed").getValue());}
    public String NickRed() { return String.valueOf(configurationNode.getNode("Nick","NickRed").getValue());}
    public String NickGold() { return String.valueOf(configurationNode.getNode("Nick","NickGold").getValue());}
    public String NickYellow() { return String.valueOf(configurationNode.getNode("Nick","NickYellow").getValue());}
    public String NickDarkGreen() { return String.valueOf(configurationNode.getNode("Nick","NickDarkGreen").getValue());}
    public String NickGreen() { return String.valueOf(configurationNode.getNode("Nick","NickGreen").getValue());}
    public String NickAqua() { return String.valueOf(configurationNode.getNode("Nick","NickAqua").getValue());}
    public String NickDarkAqua() { return String.valueOf(configurationNode.getNode("Nick","NickDarkAqua").getValue());}
    public String NickDarkBlue() { return String.valueOf(configurationNode.getNode("Nick","NickDarkBlue").getValue());}
    public String NickBlue() { return String.valueOf(configurationNode.getNode("Nick","NickBlue").getValue());}
    public String NickLightPurple() { return String.valueOf(configurationNode.getNode("Nick","NickLightPurple").getValue());}
    public String NickPurple() { return String.valueOf(configurationNode.getNode("Nick","NickPurple").getValue());}
    public String NickWhite() { return String.valueOf(configurationNode.getNode("Nick","NickWhite").getValue());}
    public String NickGray() { return String.valueOf(configurationNode.getNode("Nick","NickGray").getValue());}
    public String NickDarkGray() { return String.valueOf(configurationNode.getNode("Nick","NickDarkGray").getValue());}
    public String NickBlack() { return String.valueOf(configurationNode.getNode("Nick","NickBlack").getValue());}
    public String NickObfuscated() { return String.valueOf(configurationNode.getNode("Nick","NickObfuscated").getValue());}
    public String NickBold() { return String.valueOf(configurationNode.getNode("Nick","NickBold").getValue());}
    public String NickStrikethrough() { return String.valueOf(configurationNode.getNode("Nick","NickStrikethrough").getValue());}
    public String NickUnderline() { return String.valueOf(configurationNode.getNode("Nick","NickUnderline").getValue());}
    public String NickItalic() { return String.valueOf(configurationNode.getNode("Nick","NickItalic").getValue());}
    public String NickReset() { return String.valueOf(configurationNode.getNode("Nick","NickReset").getValue());}
    public String NickcolorPriceSummary() { return String.valueOf(configurationNode.getNode("Nick","NickcolorPriceSummary").getValue());}
    public String NickthemePriceSummary() { return String.valueOf(configurationNode.getNode("Nick","NickthemePriceSummary").getValue());}
    public String PokeBallTitle() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallTitle").getValue());}
    public String PokeBallInfoTitle() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallInfoTitle").getValue());}
    public String PokeBallInfoString1() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallInfoString1").getValue());}
    public String PokeBallInfoString2() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallInfoString2").getValue());}
    public String PokeBallSelectedTitle() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallSelectedTitle").getValue());}
    public String PokeBallREGULAR() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallREGULAR").getValue());}
    public String PokeBallSPECIAL() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallSPECIAL").getValue());}
    public String PokeBallGOD() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallGOD").getValue());}
    public String PokeBallBEAST() { return String.valueOf(configurationNode.getNode("PokeBall","PokeBallBEAST").getValue());}
    public String ShinyTitle() { return String.valueOf(configurationNode.getNode("Shiny","ShinyTitle").getValue());}
    public String ShinyInfoTitle() { return String.valueOf(configurationNode.getNode("Shiny","ShinyInfoTitle").getValue());}
    public String ShinyInfoString1() { return String.valueOf(configurationNode.getNode("Shiny","ShinyInfoString1").getValue());}
    public String ShinyInfoString2() { return String.valueOf(configurationNode.getNode("Shiny","ShinyInfoString2").getValue());}
    public String ShinySelectedTitle() { return String.valueOf(configurationNode.getNode("Shiny","ShinySelectedTitle").getValue());}
    public String ShinyShinyTrue() { return String.valueOf(configurationNode.getNode("Shiny","ShinyShinyTrue").getValue());}
    public String ShinyShinyTrueChoose() { return String.valueOf(configurationNode.getNode("Shiny","ShinyShinyTrueChoose").getValue());}
    public String ShinyShinyFalse() { return String.valueOf(configurationNode.getNode("Shiny","ShinyShinyFalse").getValue());}
    public String ShinyShinyFalseChoose() { return String.valueOf(configurationNode.getNode("Shiny","ShinyShinyFalseChoose").getValue());}
    public String ShinynormalRPriceSummary() { return String.valueOf(configurationNode.getNode("Shiny","ShinyshinyRPriceSummary").getValue());}
    public String ShinyshinyRPriceSummary() { return String.valueOf(configurationNode.getNode("Shiny","ShinynormalPriceSummary").getValue());}
    public String ShinynormalAPriceSummary() { return String.valueOf(configurationNode.getNode("Shiny","ShinynormalAPriceSummary").getValue());}
    public String ShinyshinyAPriceSummay() { return String.valueOf(configurationNode.getNode("Shiny","ShinyshinyAPriceSummay").getValue());}
}
