package me.fusiondev.fusionpixelmon.impl.pixelmon;

import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.EVStore;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import me.fusiondev.fusionpixelmon.FusionPixelmon;
import me.fusiondev.fusionpixelmon.api.pixelmon.IPokemonWrapper;
import me.fusiondev.fusionpixelmon.impl.GrammarUtils;
import me.fusiondev.fusionpixelmon.voc.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.pixelmonmod.pixelmon.enums.EnumNature.natureFromString;

/**
 * Contains information on the Pokemon.
 */
public class PokemonWrapper implements IPokemonWrapper {
    private final Pokemon pokemon;

    TranslateConfig Tconfig = FusionPixelmon.getInstance().getConfiguration().getTranslationConfig();
    public PokemonWrapper(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String getTitle() {
        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return "§b" + getName() + config.ZenWrapperLEVEL()+"" + pokemon.getLevel() + getIfShiny();
    }

    @Override
    public String getIfShiny() {
        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return pokemon.isShiny() ? config.ZenWrapperSHINY() : "";
    }

    @Override
    public String getSpeciesName() {
        /**
         * Base Code
        return pokemon.getSpecies().getPokemonName();
         */
        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String pokeNameS = pokemon.getSpecies().getPokemonName();//Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.abomasnow.name")){pokeNameS ="暴雪王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.abra.name")){pokeNameS ="凱西";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.absol.name")){pokeNameS ="阿勃梭魯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.accelgor.name")){pokeNameS ="敏捷蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aegislash.name")){pokeNameS ="堅盾劍怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aerodactyl.name")){pokeNameS ="化石翼龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aggron.name")){pokeNameS ="波士可多拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aipom.name")){pokeNameS ="長尾怪手";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.alakazam.name")){pokeNameS ="胡地";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.alcremie.name")){pokeNameS ="霜奶仙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.alomomola.name")){pokeNameS ="保母曼波";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.altaria.name")){pokeNameS ="七夕青鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.amaura.name")){pokeNameS ="冰雪龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ambipom.name")){pokeNameS ="雙尾怪手";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.amoonguss.name")){pokeNameS ="敗露球菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ampharos.name")){pokeNameS ="電龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.anorith.name")){pokeNameS ="太古羽蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.appletun.name")){pokeNameS ="豐蜜龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.applin.name")){pokeNameS ="啃果蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.araquanid.name")){pokeNameS ="滴蛛霸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arbok.name")){pokeNameS ="阿柏怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arcanine.name")){pokeNameS ="風速狗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arceus.name")){pokeNameS ="阿爾宙斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.archen.name")){pokeNameS ="始祖小鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.archeops.name")){pokeNameS ="始祖大鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arctovish.name")){pokeNameS ="鰓魚海獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arctozolt.name")){pokeNameS ="雷鳥海獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ariados.name")){pokeNameS ="阿利多斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.armaldo.name")){pokeNameS ="太古盔甲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aromatisse.name")){pokeNameS ="芳香精";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aron.name")){pokeNameS ="可可多拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.arrokuda.name")){pokeNameS ="刺梭魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.articuno.name")){pokeNameS ="急凍鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.audino.name")){pokeNameS ="差不多娃娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.aurorus.name")){pokeNameS ="冰雪巨龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.avalugg.name")){pokeNameS ="冰岩怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.axew.name")){pokeNameS ="牙牙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.azelf.name")){pokeNameS ="亞克諾姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.azumarill.name")){pokeNameS ="瑪力露麗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.azurill.name")){pokeNameS ="露力麗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bagon.name")){pokeNameS ="寶貝龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.baltoy.name")){pokeNameS ="天秤偶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.banette.name")){pokeNameS ="詛咒娃娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.barbaracle.name")){pokeNameS ="龜足巨鎧";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.barboach.name")){pokeNameS ="泥泥鰍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.barraskewda.name")){pokeNameS ="戽斗尖梭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.basculin.name")){pokeNameS ="野蠻鱸魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bastiodon.name")){pokeNameS ="護城龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bayleef.name")){pokeNameS ="月桂葉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.beartic.name")){pokeNameS ="凍原熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.beautifly.name")){pokeNameS ="狩獵鳳蝶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.beedrill.name")){pokeNameS ="大針蜂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.beheeyem.name")){pokeNameS ="大宇怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.beldum.name")){pokeNameS ="鐵啞鈴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bellossom.name")){pokeNameS ="美麗花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bellsprout.name")){pokeNameS ="喇叭芽";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bergmite.name")){pokeNameS ="冰寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bewear.name")){pokeNameS ="穿著熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bibarel.name")){pokeNameS ="大尾狸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bidoof.name")){pokeNameS ="大牙狸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.binacle.name")){pokeNameS ="龜腳腳";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bisharp.name")){pokeNameS ="劈斬司令";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blacephalon.name")){pokeNameS ="砰頭小丑";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blastoise.name")){pokeNameS ="水箭龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blaziken.name")){pokeNameS ="火焰雞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blipbug.name")){pokeNameS ="索偵蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blissey.name")){pokeNameS ="幸福蛋";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.blitzle.name")){pokeNameS ="斑斑馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.boldore.name")){pokeNameS ="地幔岩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.boltund.name")){pokeNameS ="逐電犬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bonsly.name")){pokeNameS ="盆才怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bouffalant.name")){pokeNameS ="爆炸頭水牛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bounsweet.name")){pokeNameS ="甜竹竹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.braixen.name")){pokeNameS ="長尾火狐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.braviary.name")){pokeNameS ="勇士雄鷹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.breloom.name")){pokeNameS ="斗笠菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.brionne.name")){pokeNameS ="花漾海獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bronzong.name")){pokeNameS ="青銅鐘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bronzor.name")){pokeNameS ="銅鏡怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bruxish.name")){pokeNameS ="磨牙彩皮魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.budew.name")){pokeNameS ="含羞苞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.buizel.name")){pokeNameS ="泳圈鼬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bulbasaur.name")){pokeNameS ="妙蛙種子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.buneary.name")){pokeNameS ="捲捲耳";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.bunnelby.name")){pokeNameS ="掘掘兔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.burmy.name")){pokeNameS ="結草兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.butterfree.name")){pokeNameS ="巴大蝶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.buzzwole.name")){pokeNameS ="爆肌蚊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cacnea.name")){pokeNameS ="刺球仙人掌";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cacturne.name")){pokeNameS ="夢歌仙人掌";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.camerupt.name")){pokeNameS ="噴火駝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.carbink.name")){pokeNameS ="小碎鑽";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.carkol.name")){pokeNameS ="大炭車";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.carnivine.name")){pokeNameS ="尖牙籠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.carracosta.name")){pokeNameS ="肋骨海龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.carvanha.name")){pokeNameS ="利牙魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cascoon.name")){pokeNameS ="盾甲繭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.castform.name")){pokeNameS ="飄浮泡泡";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.caterpie.name")){pokeNameS ="綠毛蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.celebi.name")){pokeNameS ="時拉比";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.celesteela.name")){pokeNameS ="鐵火輝夜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.centiskorch.name")){pokeNameS ="焚焰蚣";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chandelure.name")){pokeNameS ="水晶燈火靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chansey.name")){pokeNameS ="吉利蛋";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.charizard.name")){pokeNameS ="噴火龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.charjabug.name")){pokeNameS ="蟲電寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.charmander.name")){pokeNameS ="小火龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.charmeleon.name")){pokeNameS ="火恐龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chatot.name")){pokeNameS ="聒噪鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cherrim.name")){pokeNameS ="櫻花兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cherubi.name")){pokeNameS ="櫻花寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chesnaught.name")){pokeNameS ="布里卡隆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chespin.name")){pokeNameS ="哈力栗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chewtle.name")){pokeNameS ="咬咬龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chikorita.name")){pokeNameS ="菊草葉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chimchar.name")){pokeNameS ="小火焰猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chimecho.name")){pokeNameS ="風鈴鈴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chinchou.name")){pokeNameS ="燈籠魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.chingling.name")){pokeNameS ="鈴鐺響";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cinccino.name")){pokeNameS ="奇諾栗鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cinderace.name")){pokeNameS ="閃焰王牌";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clamperl.name")){pokeNameS ="珍珠貝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clauncher.name")){pokeNameS ="鐵臂槍蝦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clawitzer.name")){pokeNameS ="鋼炮臂蝦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.claydol.name")){pokeNameS ="念力土偶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clefable.name")){pokeNameS ="皮可西";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clefairy.name")){pokeNameS ="皮皮";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cleffa.name")){pokeNameS ="皮寶寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.clobbopus.name")){pokeNameS ="拳拳蛸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cloyster.name")){pokeNameS ="刺甲貝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.coalossal.name")){pokeNameS ="巨炭山";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cobalion.name")){pokeNameS ="勾帕路翁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cofagrigus.name")){pokeNameS ="死神棺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.combee.name")){pokeNameS ="三蜜蜂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.combusken.name")){pokeNameS ="力壯雞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.comfey.name")){pokeNameS ="花療環環";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.conkeldurr.name")){pokeNameS ="修建老匠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.copperajah.name")){pokeNameS ="大王銅象";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.corphish.name")){pokeNameS ="龍蝦小兵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.corsola.name")){pokeNameS ="太陽珊瑚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.corviknight.name")){pokeNameS ="鋼鎧鴉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.corvisquire.name")){pokeNameS ="藍鴉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cosmoem.name")){pokeNameS ="科斯莫姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cosmog.name")){pokeNameS ="科斯莫古";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cottonee.name")){pokeNameS ="木棉球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.crabominable.name")){pokeNameS ="好勝毛蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.crabrawler.name")){pokeNameS ="好勝蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cradily.name")){pokeNameS ="搖籃百合";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cramorant.name")){pokeNameS ="古月鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cranidos.name")){pokeNameS ="頭蓋龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.crawdaunt.name")){pokeNameS ="鐵螯龍蝦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cresselia.name")){pokeNameS ="克雷色利亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.croagunk.name")){pokeNameS ="不良蛙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.crobat.name")){pokeNameS ="叉字蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.croconaw.name")){pokeNameS ="藍鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.crustle.name")){pokeNameS ="岩殿居蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cryogonal.name")){pokeNameS ="幾何雪花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cubchoo.name")){pokeNameS ="噴嚏熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cubone.name")){pokeNameS ="卡拉卡拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cufant.name")){pokeNameS ="銅象";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cursola.name")){pokeNameS ="魔靈珊瑚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cutiefly.name")){pokeNameS ="萌虻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.cyndaquil.name")){pokeNameS ="火球鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.darkrai.name")){pokeNameS ="達克萊伊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.darmanitan.name")){pokeNameS ="達摩狒狒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dartrix.name")){pokeNameS ="投羽梟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.darumaka.name")){pokeNameS ="火紅不倒翁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.decidueye.name")){pokeNameS ="狙射樹梟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dedenne.name")){pokeNameS ="咚咚鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.deerling.name")){pokeNameS ="四季鹿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.deino.name")){pokeNameS ="單首龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.delcatty.name")){pokeNameS ="優雅貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.delibird.name")){pokeNameS ="信使鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.delphox.name")){pokeNameS ="妖火紅狐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.deoxys.name")){pokeNameS ="代歐奇希斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dewgong.name")){pokeNameS ="白海獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dewott.name")){pokeNameS ="雙刃丸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dewpider.name")){pokeNameS ="滴蛛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dhelmise.name")){pokeNameS ="破破舵輪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dialga.name")){pokeNameS ="帝牙盧卡";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.diancie.name")){pokeNameS ="蒂安希";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.diggersby.name")){pokeNameS ="掘地兔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.diglett.name")){pokeNameS ="地鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ditto.name")){pokeNameS ="百變怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dodrio.name")){pokeNameS ="嘟嘟利";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.doduo.name")){pokeNameS ="嘟嘟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.donphan.name")){pokeNameS ="頓甲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dottler.name")){pokeNameS ="天罩蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.doublade.name")){pokeNameS ="雙劍鞘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dracovish.name")){pokeNameS ="鰓魚龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dracozolt.name")){pokeNameS ="雷鳥龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dragalge.name")){pokeNameS ="毒藻龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dragapult.name")){pokeNameS ="多龍巴魯托";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dragonair.name")){pokeNameS ="哈克龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dragonite.name")){pokeNameS ="快龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dragonitebajancanadian.name")){pokeNameS ="Bajan的快龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drakloak.name")){pokeNameS ="多龍奇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drampa.name")){pokeNameS ="老翁龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drapion.name")){pokeNameS ="龍王蠍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dratini.name")){pokeNameS ="迷你龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drednaw.name")){pokeNameS ="暴噬龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dreepy.name")){pokeNameS ="多龍梅西亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drifblim.name")){pokeNameS ="隨風球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drifloon.name")){pokeNameS ="飄飄球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drilbur.name")){pokeNameS ="螺釘地鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drizzile.name")){pokeNameS ="變澀蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.drowzee.name")){pokeNameS ="催眠貘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.druddigon.name")){pokeNameS ="赤面龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dubwool.name")){pokeNameS ="毛毛角羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ducklett.name")){pokeNameS ="鴨寶寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dugtrio.name")){pokeNameS ="三地鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dunsparce.name")){pokeNameS ="土龍弟弟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.duosion.name")){pokeNameS ="雙卵細胞球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.duraludon.name")){pokeNameS ="鋁鋼龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.durant.name")){pokeNameS ="鐵蟻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dusclops.name")){pokeNameS ="彷徨夜靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dusknoir.name")){pokeNameS ="黑夜魔靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.duskull.name")){pokeNameS ="夜巡靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dustox.name")){pokeNameS ="毒粉蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.dwebble.name")){pokeNameS ="石居蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eelektrik.name")){pokeNameS ="麻麻鰻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eelektross.name")){pokeNameS ="麻麻鰻魚王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eevee.name")){pokeNameS ="伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ghostwolfeevee.name")){pokeNameS ="Ghostwolf的伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eiscue.name")){pokeNameS ="冰砌鵝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ekans.name")){pokeNameS ="阿柏蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eldegoss.name")){pokeNameS ="白蓬蓬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.electabuzz.name")){pokeNameS ="電擊獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.electivire.name")){pokeNameS ="電擊魔獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.electrike.name")){pokeNameS ="落雷獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.electrode.name")){pokeNameS ="頑皮雷彈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.elekid.name")){pokeNameS ="電擊怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.elgyem.name")){pokeNameS ="小灰怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.emboar.name")){pokeNameS ="炎武王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.emolga.name")){pokeNameS ="電飛鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.empoleon.name")){pokeNameS ="帝王拿波";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.entei.name")){pokeNameS ="炎帝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.escavalier.name")){pokeNameS ="騎士蝸牛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.espeon.name")){pokeNameS ="太陽伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.espurr.name")){pokeNameS ="妙喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.eternatus.name")){pokeNameS ="無極汰那";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.excadrill.name")){pokeNameS ="龍頭地鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.exeggcute.name")){pokeNameS ="蛋蛋";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.exeggutor.name")){pokeNameS ="椰蛋樹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.exploud.name")){pokeNameS ="爆音怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.falinks.name")){pokeNameS ="列陣兵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.farfetchd.name")){pokeNameS ="大蔥鴨";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fearow.name")){pokeNameS ="大嘴雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.feebas.name")){pokeNameS ="醜醜魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fennekin.name")){pokeNameS ="火狐狸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.feraligatr.name")){pokeNameS ="大力鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ferroseed.name")){pokeNameS ="種子鐵球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ferrothorn.name")){pokeNameS ="堅果啞鈴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.finneon.name")){pokeNameS ="螢光魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.flaaffy.name")){pokeNameS ="茸茸羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.flabebe.name")){pokeNameS ="花蓓蓓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.flapple.name")){pokeNameS ="蘋裹龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.flareon.name")){pokeNameS ="火伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fletchinder.name")){pokeNameS ="火箭雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fletchling.name")){pokeNameS ="小箭雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.floatzel.name")){pokeNameS ="浮潛鼬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.floette.name")){pokeNameS ="花葉蒂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.florges.name")){pokeNameS ="花潔夫人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.flygon.name")){pokeNameS ="沙漠蜻蜓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fomantis.name")){pokeNameS ="偽螳草";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.foongus.name")){pokeNameS ="哎呀球菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.forretress.name")){pokeNameS ="佛烈托斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.fraxure.name")){pokeNameS ="斧牙龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.frillish.name")){pokeNameS ="輕飄飄";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.froakie.name")){pokeNameS ="呱呱泡蛙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.frogadier.name")){pokeNameS ="呱頭蛙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.froslass.name")){pokeNameS ="雪妖女";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.frosmoth.name")){pokeNameS ="雪絨蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.furfrou.name")){pokeNameS ="多麗米亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.furret.name")){pokeNameS ="大尾立";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gabite.name")){pokeNameS ="尖牙陸鯊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gallade.name")){pokeNameS ="艾路雷朵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.galvantula.name")){pokeNameS ="電蜘蛛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.garbodor.name")){pokeNameS ="灰塵山";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.garchomp.name")){pokeNameS ="烈咬陸鯊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gardevoir.name")){pokeNameS ="沙奈朵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gastly.name")){pokeNameS ="鬼斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gastrodon.name")){pokeNameS ="海兔獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.genesect.name")){pokeNameS ="蓋諾賽克特";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gengar.name")){pokeNameS ="耿鬼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.geodude.name")){pokeNameS ="小拳石";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gible.name")){pokeNameS ="圓陸鯊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gigalith.name")){pokeNameS ="龐岩怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.girafarig.name")){pokeNameS ="麒麟奇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.giratina.name")){pokeNameS ="騎拉帝納";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.glaceon.name")){pokeNameS ="冰伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.glalie.name")){pokeNameS ="冰鬼護";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.glameow.name")){pokeNameS ="魅力喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gligar.name")){pokeNameS ="天蠍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gliscor.name")){pokeNameS ="天蠍王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gloom.name")){pokeNameS ="臭臭花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gogoat.name")){pokeNameS ="坐騎山羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golbat.name")){pokeNameS ="大嘴蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.goldeen.name")){pokeNameS ="角金魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golduck.name")){pokeNameS ="哥達鴨";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golem.name")){pokeNameS ="隆隆岩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golett.name")){pokeNameS ="泥偶小人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golisopod.name")){pokeNameS ="具甲武者";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.golurk.name")){pokeNameS ="泥偶巨人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.goodra.name")){pokeNameS ="黏美龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.goomy.name")){pokeNameS ="黏黏寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gorebyss.name")){pokeNameS ="櫻花魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gossifleur.name")){pokeNameS ="幼棉棉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gothita.name")){pokeNameS ="哥德寶寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gothitelle.name")){pokeNameS ="哥德小姐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gothorita.name")){pokeNameS ="哥德小童";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gourgeist.name")){pokeNameS ="南瓜怪人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.granbull.name")){pokeNameS ="布魯皇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grapploct.name")){pokeNameS ="八爪武師";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.graveler.name")){pokeNameS ="隆隆石";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.greedent.name")){pokeNameS ="藏飽栗鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.greninja.name")){pokeNameS ="甲賀忍蛙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grimer.name")){pokeNameS ="臭泥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grimmsnarl.name")){pokeNameS ="長毛巨魔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grookey.name")){pokeNameS ="敲音猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grotle.name")){pokeNameS ="樹林龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.groudon.name")){pokeNameS ="固拉多";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grovyle.name")){pokeNameS ="森林蜥蜴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.growlithe.name")){pokeNameS ="卡蒂狗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grubbin.name")){pokeNameS ="強顎雞母蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.grumpig.name")){pokeNameS ="噗噗豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gulpin.name")){pokeNameS ="溶食獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gumshoos.name")){pokeNameS ="貓鼬探長";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gurdurr.name")){pokeNameS ="鐵骨土人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.guzzlord.name")){pokeNameS ="惡食大王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.gyarados.name")){pokeNameS ="暴鯉龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hakamo-o.name")){pokeNameS ="鱗甲龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.happiny.name")){pokeNameS ="小福蛋";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hariyama.name")){pokeNameS ="鐵掌力士";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hatenna.name")){pokeNameS ="迷布莉姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hatterene.name")){pokeNameS ="布莉姆溫";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hattrem.name")){pokeNameS ="提布莉姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.haunter.name")){pokeNameS ="鬼斯通";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hawlucha.name")){pokeNameS ="摔角鷹人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.haxorus.name")){pokeNameS ="雙斧戰龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.heatmor.name")){pokeNameS ="熔蟻獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.heatran.name")){pokeNameS ="席多藍恩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.heliolisk.name")){pokeNameS ="光電傘蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.helioptile.name")){pokeNameS ="傘電蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.heracross.name")){pokeNameS ="赫拉克羅斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.herdier.name")){pokeNameS ="哈約克";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hippopotas.name")){pokeNameS ="沙河馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hippowdon.name")){pokeNameS ="河馬獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hitmonchan.name")){pokeNameS ="快拳郎";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hitmonlee.name")){pokeNameS ="飛腿郎";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hitmontop.name")){pokeNameS ="戰舞郎";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ho-oh.name")){pokeNameS ="鳳王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.honchkrow.name")){pokeNameS ="烏鴉頭頭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.honedge.name")){pokeNameS ="獨劍鞘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hoopa.name")){pokeNameS ="胡帕";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hoothoot.name")){pokeNameS ="咕咕";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hoppip.name")){pokeNameS ="毽子草";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.horsea.name")){pokeNameS ="墨海馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.houndoom.name")){pokeNameS ="黑魯加";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.houndour.name")){pokeNameS ="戴魯比";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.huntail.name")){pokeNameS ="獵斑魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hydreigon.name")){pokeNameS ="三首惡龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.hypno.name")){pokeNameS ="引夢貘人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.igglybuff.name")){pokeNameS ="寶寶丁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.illumise.name")){pokeNameS ="甜甜螢";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.impidimp.name")){pokeNameS ="搗蛋小妖";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.incineroar.name")){pokeNameS ="熾焰咆哮虎";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.indeedee.name")){pokeNameS ="愛管侍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.infernape.name")){pokeNameS ="烈焰猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.inkay.name")){pokeNameS ="好啦魷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.inteleon.name")){pokeNameS ="千面避役";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ivysaur.name")){pokeNameS ="妙蛙草";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jangmo-o.name")){pokeNameS ="心鱗寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jellicent.name")){pokeNameS ="胖嘟嘟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jigglypuff.name")){pokeNameS ="胖丁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jirachi.name")){pokeNameS ="基拉祈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jolteon.name")){pokeNameS ="雷伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.joltik.name")){pokeNameS ="電電蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jumpluff.name")){pokeNameS ="毽子棉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.jynx.name")){pokeNameS ="迷唇姐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kabuto.name")){pokeNameS ="化石盔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kabutops.name")){pokeNameS ="鐮刀盔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kadabra.name")){pokeNameS ="勇基拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kakuna.name")){pokeNameS ="鐵殼蛹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kangaskhan.name")){pokeNameS ="袋獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.karrablast.name")){pokeNameS ="蓋蓋蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kartana.name")){pokeNameS ="紙御劍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kecleon.name")){pokeNameS ="變隱龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.keldeo.name")){pokeNameS ="凱路迪歐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kingdra.name")){pokeNameS ="刺龍王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kingler.name")){pokeNameS ="巨鉗蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kirlia.name")){pokeNameS ="奇魯莉安";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.klang.name")){pokeNameS ="齒輪組";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.klefki.name")){pokeNameS ="鑰圈兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.klink.name")){pokeNameS ="齒輪兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.klinklang.name")){pokeNameS ="齒輪怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.koffing.name")){pokeNameS ="瓦斯彈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.komala.name")){pokeNameS ="樹枕尾熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kommo-o.name")){pokeNameS ="杖尾鱗甲龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.krabby.name")){pokeNameS ="大鉗蟹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kricketot.name")){pokeNameS ="圓法師";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kricketune.name")){pokeNameS ="音箱蟀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.krokorok.name")){pokeNameS ="混混鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.krookodile.name")){pokeNameS ="流氓鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kyogre.name")){pokeNameS ="蓋歐卡";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.kyurem.name")){pokeNameS ="酋雷姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lairon.name")){pokeNameS ="可多拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lampent.name")){pokeNameS ="燈火幽靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.landorus.name")){pokeNameS ="土地雲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lanturn.name")){pokeNameS ="電燈怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lapras.name")){pokeNameS ="拉普拉斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.larvesta.name")){pokeNameS ="燃燒蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.larvitar.name")){pokeNameS ="幼基拉斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.latias.name")){pokeNameS ="拉帝亞斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.latios.name")){pokeNameS ="拉帝歐斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.leafeon.name")){pokeNameS ="葉伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.leavanny.name")){pokeNameS ="保母蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ledian.name")){pokeNameS ="安瓢蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ledyba.name")){pokeNameS ="芭瓢蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lickilicky.name")){pokeNameS ="大舌舔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lickitung.name")){pokeNameS ="大舌頭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.liepard.name")){pokeNameS ="酷豹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lileep.name")){pokeNameS ="觸手百合";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lilligant.name")){pokeNameS ="裙兒小姐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lillipup.name")){pokeNameS ="小約克";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.linoone.name")){pokeNameS ="直衝熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.litleo.name")){pokeNameS ="小獅獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.litten.name")){pokeNameS ="火斑喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.litwick.name")){pokeNameS ="燭光靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lombre.name")){pokeNameS ="蓮帽小童";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lopunny.name")){pokeNameS ="長耳兔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lotad.name")){pokeNameS ="蓮葉童子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.loudred.name")){pokeNameS ="吼爆彈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lucario.name")){pokeNameS ="路卡利歐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ludicolo.name")){pokeNameS ="樂天河童";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lugia.name")){pokeNameS ="洛奇亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lumineon.name")){pokeNameS ="霓虹魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lunala.name")){pokeNameS ="露奈雅拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lunatone.name")){pokeNameS ="月石";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lurantis.name")){pokeNameS ="蘭螳花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.luvdisc.name")){pokeNameS ="愛心魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.luxio.name")){pokeNameS ="勒克貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.luxray.name")){pokeNameS ="倫琴貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.lycanroc.name")){pokeNameS ="鬃岩狼人";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.machamp.name")){pokeNameS ="怪力";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.machoke.name")){pokeNameS ="豪力";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.machop.name")){pokeNameS ="腕力";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magby.name")){pokeNameS ="鴨嘴寶寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magcargo.name")){pokeNameS ="熔岩蝸牛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magearna.name")){pokeNameS ="瑪機雅娜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magikarp.name")){pokeNameS ="鯉魚王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magmar.name")){pokeNameS ="鴨嘴火獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magmortar.name")){pokeNameS ="鴨嘴炎獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magnemite.name")){pokeNameS ="小磁怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magneton.name")){pokeNameS ="三合一磁怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.magnezone.name")){pokeNameS ="自爆磁怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.makuhita.name")){pokeNameS ="幕下力士";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.malamar.name")){pokeNameS ="烏賊王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mamoswine.name")){pokeNameS ="象牙豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.manaphy.name")){pokeNameS ="瑪納霏";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mandibuzz.name")){pokeNameS ="禿鷹娜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.manectric.name")){pokeNameS ="雷電獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mankey.name")){pokeNameS ="猴怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mantine.name")){pokeNameS ="巨翅飛魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mantyke.name")){pokeNameS ="小球飛魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.maractus.name")){pokeNameS ="沙鈴仙人掌";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mareanie.name")){pokeNameS ="好壞星";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mareep.name")){pokeNameS ="咩利羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.marill.name")){pokeNameS ="瑪力露";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.marowak.name")){pokeNameS ="嘎啦嘎啦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.marshadow.name")){pokeNameS ="瑪夏多";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.marshtomp.name")){pokeNameS ="沼躍魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.masquerain.name")){pokeNameS ="雨翅蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mawile.name")){pokeNameS ="大嘴娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.medicham.name")){pokeNameS ="恰雷姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meditite.name")){pokeNameS ="瑪沙那";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meganium.name")){pokeNameS ="大竺葵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.melmetal.name")){pokeNameS ="美錄梅塔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meloetta.name")){pokeNameS ="美洛耶塔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meltan.name")){pokeNameS ="美錄坦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meowstic.name")){pokeNameS ="超能妙喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.meowth.name")){pokeNameS ="喵喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mesprit.name")){pokeNameS ="艾姆利多";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.metagross.name")){pokeNameS ="巨金怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.metang.name")){pokeNameS ="金屬怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.metapod.name")){pokeNameS ="鐵甲蛹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mew.name")){pokeNameS ="夢幻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mewtwo.name")){pokeNameS ="超夢";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slymewtwo.name")){pokeNameS ="Slyfox的超夢";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mienfoo.name")){pokeNameS ="功夫鼬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mienshao.name")){pokeNameS ="師父鼬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mightyena.name")){pokeNameS ="大狼犬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.milcery.name")){pokeNameS ="小仙奶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.milotic.name")){pokeNameS ="美納斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.miltank.name")){pokeNameS ="大奶罐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mimejr.name")){pokeNameS ="魔尼尼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mimikyu.name")){pokeNameS ="謎擬Ｑ";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.minccino.name")){pokeNameS ="泡沫栗鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.minior.name")){pokeNameS ="小隕星";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.minun.name")){pokeNameS ="負電拍拍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.misdreavus.name")){pokeNameS ="夢妖";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mismagius.name")){pokeNameS ="夢妖魔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.missingno.name")){pokeNameS ="缺少";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.moltres.name")){pokeNameS ="火焰鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.monferno.name")){pokeNameS ="猛火猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.morelull.name")){pokeNameS ="睡睡菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.morgrem.name")){pokeNameS ="詐唬魔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.morpeko.name")){pokeNameS ="莫魯貝可";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mothim.name")){pokeNameS ="紳士蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mrmime.name")){pokeNameS ="魔牆人偶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mrrime.name")){pokeNameS ="踏冰人偶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mudbray.name")){pokeNameS ="泥驢仔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mudkip.name")){pokeNameS ="水躍魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.mudsdale.name")){pokeNameS ="重泥挽馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.muk.name")){pokeNameS ="臭臭泥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.munchlax.name")){pokeNameS ="小卡比獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.munna.name")){pokeNameS ="食夢夢";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.murkrow.name")){pokeNameS ="黑暗鴉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.musharna.name")){pokeNameS ="夢夢蝕";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.naganadel.name")){pokeNameS ="四顎針龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.natu.name")){pokeNameS ="天然雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.necrozma.name")){pokeNameS ="奈克洛茲瑪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nickit.name")){pokeNameS ="偷兒狐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidoking.name")){pokeNameS ="尼多王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidoqueen.name")){pokeNameS ="尼多后";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidoranfemale.name")){pokeNameS ="尼多蘭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidoranmale.name")){pokeNameS ="尼多朗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidorina.name")){pokeNameS ="尼多娜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nidorino.name")){pokeNameS ="尼多力諾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nihilego.name")){pokeNameS ="虛吾伊德";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nincada.name")){pokeNameS ="土居忍士";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ninetales.name")){pokeNameS ="九尾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ninjask.name")){pokeNameS ="鐵面忍者";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.noctowl.name")){pokeNameS ="貓頭夜鷹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.noibat.name")){pokeNameS ="嗡蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.noivern.name")){pokeNameS ="音波龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nosepass.name")){pokeNameS ="朝北鼻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.numel.name")){pokeNameS ="呆火駝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.nuzleaf.name")){pokeNameS ="長鼻葉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.obstagoon.name")){pokeNameS ="堵攔熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.octillery.name")){pokeNameS ="章魚桶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.oddish.name")){pokeNameS ="走路草";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.omanyte.name")){pokeNameS ="菊石獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.omastar.name")){pokeNameS ="多刺菊石獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.onix.name")){pokeNameS ="大岩蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.oranguru.name")){pokeNameS ="智揮猩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.orbeetle.name")){pokeNameS ="以歐路普";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.oricorio.name")){pokeNameS ="花舞鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.oshawott.name")){pokeNameS ="水水獺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pachirisu.name")){pokeNameS ="帕奇利茲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.palkia.name")){pokeNameS ="帕路奇亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.palossand.name")){pokeNameS ="噬沙堡爺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.palpitoad.name")){pokeNameS ="藍蟾蜍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pancham.name")){pokeNameS ="頑皮熊貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pangoro.name")){pokeNameS ="流氓熊貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.panpour.name")){pokeNameS ="冷水猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pansage.name")){pokeNameS ="花椰猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pansear.name")){pokeNameS ="爆香猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.paras.name")){pokeNameS ="派拉斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.parasect.name")){pokeNameS ="派拉斯特";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.passimian.name")){pokeNameS ="投擲猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.patrat.name")){pokeNameS ="探探鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pawniard.name")){pokeNameS ="駒刀小兵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pelipper.name")){pokeNameS ="大嘴鷗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.perrserker.name")){pokeNameS ="喵頭目";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.persian.name")){pokeNameS ="貓老大";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.petilil.name")){pokeNameS ="百合根娃娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.phanpy.name")){pokeNameS ="小小象";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.phantump.name")){pokeNameS ="小木靈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pheromosa.name")){pokeNameS ="費洛美螂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.phione.name")){pokeNameS ="霏歐納";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pichu.name")){pokeNameS ="皮丘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pidgeot.name")){pokeNameS ="大比鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pidgeotto.name")){pokeNameS ="比比鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pidgey.name")){pokeNameS ="波波";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pidove.name")){pokeNameS ="豆豆鴿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pignite.name")){pokeNameS ="炒炒豬      ";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pikachu.name")){pokeNameS ="皮卡丘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pikipek.name")){pokeNameS ="小篤兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.piloswine.name")){pokeNameS ="長毛豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pincurchin.name")){pokeNameS ="啪嚓海膽";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pineco.name")){pokeNameS ="榛果球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pinsir.name")){pokeNameS ="凱羅斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.piplup.name")){pokeNameS ="波加曼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.plusle.name")){pokeNameS ="正電拍拍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.poipole.name")){pokeNameS ="毒貝比";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.politoed.name")){pokeNameS ="蚊香蛙皇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.poliwag.name")){pokeNameS ="蚊香蝌蚪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.poliwhirl.name")){pokeNameS ="蚊香君";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.poliwrath.name")){pokeNameS ="蚊香泳士";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.polteageist.name")){pokeNameS ="怖思壺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ponyta.name")){pokeNameS ="小火馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.poochyena.name")){pokeNameS ="土狼犬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.popplio.name")){pokeNameS ="球球海獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.porygon-z.name")){pokeNameS ="多邊獸Z";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.porygonzjerome.name")){pokeNameS ="Jerome的多邊獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.porygon.name")){pokeNameS ="多邊獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.porygon2.name")){pokeNameS ="多邊獸II";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.primarina.name")){pokeNameS ="西獅海壬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.primeape.name")){pokeNameS ="火爆猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.prinplup.name")){pokeNameS ="波皇子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.probopass.name")){pokeNameS ="大朝北鼻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.psyduck.name")){pokeNameS ="可達鴨";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pumpkaboo.name")){pokeNameS ="南瓜精";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pupitar.name")){pokeNameS ="沙基拉斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.purrloin.name")){pokeNameS ="扒手貓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.purugly.name")){pokeNameS ="東施喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pyroar.name")){pokeNameS ="火炎獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pyukumuku.name")){pokeNameS ="拳海參";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.quagsire.name")){pokeNameS ="沼王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.quilava.name")){pokeNameS ="火岩鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.quilladin.name")){pokeNameS ="胖胖哈力";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.qwilfish.name")){pokeNameS ="千針魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.raboot.name")){pokeNameS ="騰蹴小將";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.raichu.name")){pokeNameS ="雷丘";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.raikou.name")){pokeNameS ="雷公";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ralts.name")){pokeNameS ="拉魯拉絲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rampardos.name")){pokeNameS ="戰槌龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rapidash.name")){pokeNameS ="烈焰馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.raticate.name")){pokeNameS ="拉達";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rattata.name")){pokeNameS ="小拉達";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rayquaza.name")){pokeNameS ="烈空坐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.regice.name")){pokeNameS ="雷吉艾斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.regigigas.name")){pokeNameS ="雷吉奇卡斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.regirock.name")){pokeNameS ="雷吉洛克";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.registeel.name")){pokeNameS ="雷吉斯奇魯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.relicanth.name")){pokeNameS ="古空棘魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.remoraid.name")){pokeNameS ="鐵炮魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.reshiram.name")){pokeNameS ="萊希拉姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.reuniclus.name")){pokeNameS ="人造細胞卵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.regidrago.name")){pokeNameS ="雷吉鐸拉戈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rhydon.name")){pokeNameS ="鑽角犀獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rhyhorn.name")){pokeNameS ="獨角犀牛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rhyperior.name")){pokeNameS ="超甲狂犀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ribombee.name")){pokeNameS ="蝶結萌虻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rillaboom.name")){pokeNameS ="轟擂金剛猩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.riolu.name")){pokeNameS ="利歐路";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rockruff.name")){pokeNameS ="岩狗狗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.roggenrola.name")){pokeNameS ="石丸子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rolycoly.name")){pokeNameS ="小炭仔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rookidee.name")){pokeNameS ="稚山雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.roselia.name")){pokeNameS ="毒薔薇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.roserade.name")){pokeNameS ="羅絲雷朵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rotom.name")){pokeNameS ="洛托姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rowlet.name")){pokeNameS ="木木梟";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.rufflet.name")){pokeNameS ="毛頭小鷹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.runerigus.name")){pokeNameS ="死神板";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sableye.name")){pokeNameS ="勾魂眼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.salamence.name")){pokeNameS ="暴飛龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.salandit.name")){pokeNameS ="夜盜火蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.salazzle.name")){pokeNameS ="焰后蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.samurott.name")){pokeNameS ="大劍鬼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sandaconda.name")){pokeNameS ="沙螺蟒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sandile.name")){pokeNameS ="黑眼鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sandshrew.name")){pokeNameS ="穿山鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sandslash.name")){pokeNameS ="穿山王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sandygast.name")){pokeNameS ="沙丘娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sawk.name")){pokeNameS ="打擊鬼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sawsbuck.name")){pokeNameS ="萌芽鹿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scatterbug.name")){pokeNameS ="粉蝶蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sceptile.name")){pokeNameS ="蜥蜴王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scizor.name")){pokeNameS ="巨鉗螳螂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scolipede.name")){pokeNameS ="蜈蚣王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scorbunny.name")){pokeNameS ="炎兔兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scrafty.name")){pokeNameS ="頭巾混混";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scraggy.name")){pokeNameS ="滑滑小子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.scyther.name")){pokeNameS ="飛天螳螂";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seadra.name")){pokeNameS ="海刺龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seaking.name")){pokeNameS ="金魚王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sealeo.name")){pokeNameS ="海魔獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seedot.name")){pokeNameS ="橡實果";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seel.name")){pokeNameS ="小海獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seismitoad.name")){pokeNameS ="蟾蜍王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sentret.name")){pokeNameS ="尾立";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.pixeldipsentret.name")){pokeNameS ="Pixeldip的尾立";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.serperior.name")){pokeNameS ="君主蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.servine.name")){pokeNameS ="青藤蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.seviper.name")){pokeNameS ="飯匙蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sewaddle.name")){pokeNameS ="蟲寶包";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sharpedo.name")){pokeNameS ="巨牙鯊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shaymin.name")){pokeNameS ="謝米";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shedinja.name")){pokeNameS ="脫殼忍者";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shelgon.name")){pokeNameS ="甲殼龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shellder.name")){pokeNameS ="大舌貝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shellos.name")){pokeNameS ="無殼海兔";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shelmet.name")){pokeNameS ="小嘴蝸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shieldon.name")){pokeNameS ="盾甲龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shiftry.name")){pokeNameS ="狡猾天狗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shiinotic.name")){pokeNameS ="燈罩夜菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shinx.name")){pokeNameS ="小貓怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shroomish.name")){pokeNameS ="蘑蘑菇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shuckle.name")){pokeNameS ="壺壺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.shuppet.name")){pokeNameS ="怨影娃娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sigilyph.name")){pokeNameS ="象徵鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.silcoon.name")){pokeNameS ="甲殼繭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.silicobra.name")){pokeNameS ="沙包蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.silvally.name")){pokeNameS ="銀伴戰獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.simipour.name")){pokeNameS ="冷水猿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.simisage.name")){pokeNameS ="花椰猿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.simisear.name")){pokeNameS ="爆香猿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sinistea.name")){pokeNameS ="來悲茶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sirfetchd.name")){pokeNameS ="蔥遊兵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sizzlipede.name")){pokeNameS ="燒火蚣";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skarmory.name")){pokeNameS ="盔甲鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skiddo.name")){pokeNameS ="坐騎小羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skiploom.name")){pokeNameS ="毽子花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skitty.name")){pokeNameS ="向尾喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skorupi.name")){pokeNameS ="鉗尾蠍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skrelp.name")){pokeNameS ="垃垃藻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skuntank.name")){pokeNameS ="坦克臭鼬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.skwovet.name")){pokeNameS ="貪心栗鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slaking.name")){pokeNameS ="請假王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slakoth.name")){pokeNameS ="懶人獺";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sliggoo.name")){pokeNameS ="黏美兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slowbro.name")){pokeNameS ="呆殼獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slowking.name")){pokeNameS ="呆呆王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slowpoke.name")){pokeNameS ="呆呆獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slugma.name")){pokeNameS ="熔岩蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.slurpuff.name")){pokeNameS ="胖甜妮";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.smeargle.name")){pokeNameS ="圖圖犬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.smoochum.name")){pokeNameS ="迷唇娃";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sneasel.name")){pokeNameS ="狃拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snivy.name")){pokeNameS ="藤藤蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snom.name")){pokeNameS ="雪吞蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snorlax.name")){pokeNameS ="卡比獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snorunt.name")){pokeNameS ="雪童子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snover.name")){pokeNameS ="雪笠怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.snubbull.name")){pokeNameS ="布魯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sobble.name")){pokeNameS ="淚眼蜥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.solgaleo.name")){pokeNameS ="索爾迦雷歐";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.solosis.name")){pokeNameS ="單卵細胞球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.solrock.name")){pokeNameS ="太陽岩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spearow.name")){pokeNameS ="烈雀";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spewpa.name")){pokeNameS ="粉蝶蛹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spheal.name")){pokeNameS ="海豹球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spinarak.name")){pokeNameS ="圓絲蛛";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spinda.name")){pokeNameS ="晃晃斑";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spiritomb.name")){pokeNameS ="花岩怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spoink.name")){pokeNameS ="跳跳豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.spritzee.name")){pokeNameS ="粉香香";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.squirtle.name")){pokeNameS ="傑尼龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stakataka.name")){pokeNameS ="壘磊石";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stantler.name")){pokeNameS ="驚角鹿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.staraptor.name")){pokeNameS ="姆克鷹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.staravia.name")){pokeNameS ="姆克鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.starly.name")){pokeNameS ="姆克兒";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.starmie.name")){pokeNameS ="寶石海星";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.staryu.name")){pokeNameS ="海星星";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.steelix.name")){pokeNameS ="大鋼蛇";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.steenee.name")){pokeNameS ="甜舞妮";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stonjourner.name")){pokeNameS ="巨石丁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stoutland.name")){pokeNameS ="長毛狗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stufful.name")){pokeNameS ="童偶熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stunfisk.name")){pokeNameS ="泥巴魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.stunky.name")){pokeNameS ="臭鼬噗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sudowoodo.name")){pokeNameS ="樹才怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.suicune.name")){pokeNameS ="水君";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sunflora.name")){pokeNameS ="向日花怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sunkern.name")){pokeNameS ="向日種子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.surskit.name")){pokeNameS ="溜溜糖球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swablu.name")){pokeNameS ="青綿鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swadloon.name")){pokeNameS ="寶包繭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swalot.name")){pokeNameS ="吞食獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swampert.name")){pokeNameS ="巨沼怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swanna.name")){pokeNameS ="舞天鵝";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swellow.name")){pokeNameS ="大王燕";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swinub.name")){pokeNameS ="小山豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swirlix.name")){pokeNameS ="綿綿泡芙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.swoobat.name")){pokeNameS ="心蝙蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.sylveon.name")){pokeNameS ="仙子伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.taillow.name")){pokeNameS ="傲骨燕";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.talonflame.name")){pokeNameS ="烈箭鷹";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tangela.name")){pokeNameS ="蔓藤怪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tangrowth.name")){pokeNameS ="巨蔓藤";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tapubulu.name")){pokeNameS ="卡璞・哞哞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tapufini.name")){pokeNameS ="卡璞・鰭鰭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tapukoko.name")){pokeNameS ="卡璞・鳴鳴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tapulele.name")){pokeNameS ="卡璞・蝶蝶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tauros.name")){pokeNameS ="肯泰羅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.teddiursa.name")){pokeNameS ="熊寶寶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tentacool.name")){pokeNameS ="瑪瑙水母";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tentacruel.name")){pokeNameS ="毒刺水母";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tepig.name")){pokeNameS ="暖暖豬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.terrakion.name")){pokeNameS ="代拉基翁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.thievul.name")){pokeNameS ="狐大盜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.throh.name")){pokeNameS ="投摔鬼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.thundurus.name")){pokeNameS ="雷電雲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.thwackey.name")){pokeNameS ="啪咚猴";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.timburr.name")){pokeNameS ="搬運小匠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tirtouga.name")){pokeNameS ="原蓋海龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.togedemaru.name")){pokeNameS ="托戈德瑪爾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.togekiss.name")){pokeNameS ="波克基斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.togepi.name")){pokeNameS ="波克比";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.togetic.name")){pokeNameS ="波克基古";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.torchic.name")){pokeNameS ="火稚雞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.torkoal.name")){pokeNameS ="煤炭龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tornadus.name")){pokeNameS ="龍捲雲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.torracat.name")){pokeNameS ="炎熱喵";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.torterra.name")){pokeNameS ="土台龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.totodile.name")){pokeNameS ="小鋸鱷";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.toucannon.name")){pokeNameS ="銃嘴大鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.toxapex.name")){pokeNameS ="超壞星";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.toxel.name")){pokeNameS ="毒電嬰";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.toxicroak.name")){pokeNameS ="毒骷蛙";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.toxtricity.name")){pokeNameS ="顫弦蠑螈";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tranquill.name")){pokeNameS ="咕咕鴿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.trapinch.name")){pokeNameS ="大顎蟻";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.treecko.name")){pokeNameS ="木守宮";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.trevenant.name")){pokeNameS ="朽木妖";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tropius.name")){pokeNameS ="熱帶龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.trubbish.name")){pokeNameS ="破破袋";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.trumbeak.name")){pokeNameS ="喇叭啄鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tsareena.name")){pokeNameS ="甜冷美后";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.turtonator.name")){pokeNameS ="爆焰龜獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.turtwig.name")){pokeNameS ="草苗龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tympole.name")){pokeNameS ="圓蝌蚪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tynamo.name")){pokeNameS ="麻麻小魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.typenull.name")){pokeNameS ="屬性：空";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.typhlosion.name")){pokeNameS ="火爆獸";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tyranitar.name")){pokeNameS ="班基拉斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tyrantrum.name")){pokeNameS ="怪顎龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tyrogue.name")){pokeNameS ="無畏小子";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.tyrunt.name")){pokeNameS ="寶寶暴龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.umbreon.name")){pokeNameS ="月亮伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.unfezant.name")){pokeNameS ="高傲雉雞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.unown.name")){pokeNameS ="未知圖騰";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.ursaring.name")){pokeNameS ="圈圈熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.uxie.name")){pokeNameS ="由克希";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vanillish.name")){pokeNameS ="多多冰";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vanillite.name")){pokeNameS ="迷你冰";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vanilluxe.name")){pokeNameS ="雙倍多多冰";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vaporeon.name")){pokeNameS ="水伊布";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.venipede.name")){pokeNameS ="百足蜈蚣";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.venomoth.name")){pokeNameS ="摩魯蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.venonat.name")){pokeNameS ="毛球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.venusaur.name")){pokeNameS ="妙蛙花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vespiquen.name")){pokeNameS ="蜂女王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vibrava.name")){pokeNameS ="超音波幼蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.victini.name")){pokeNameS ="比克提尼";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.victreebel.name")){pokeNameS ="大食花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vigoroth.name")){pokeNameS ="過動猿";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vikavolt.name")){pokeNameS ="鍬農炮蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vileplume.name")){pokeNameS ="霸王花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.virizion.name")){pokeNameS ="畢力吉翁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vivillon.name")){pokeNameS ="彩粉蝶";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.volbeat.name")){pokeNameS ="電螢蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.volcanion.name")){pokeNameS ="波爾凱尼恩";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.volcarona.name")){pokeNameS ="火神蛾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.voltorb.name")){pokeNameS ="霹靂電球";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vullaby.name")){pokeNameS ="禿鷹丫頭";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.vulpix.name")){pokeNameS ="六尾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wailmer.name")){pokeNameS ="吼吼鯨";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wailord.name")){pokeNameS ="吼鯨王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.walrein.name")){pokeNameS ="帝牙海獅";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wartortle.name")){pokeNameS ="卡咪龜";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.watchog.name")){pokeNameS ="步哨鼠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.weavile.name")){pokeNameS ="瑪狃拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.weedle.name")){pokeNameS ="獨角蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.weepinbell.name")){pokeNameS ="口呆花";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.weezing.name")){pokeNameS ="雙彈瓦斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.whimsicott.name")){pokeNameS ="風妖精";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.whirlipede.name")){pokeNameS ="車輪毬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.whiscash.name")){pokeNameS ="鯰魚王";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.whismur.name")){pokeNameS ="咕妞妞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wigglytuff.name")){pokeNameS ="胖可丁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wimpod.name")){pokeNameS ="膽小蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wingull.name")){pokeNameS ="長翅鷗";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wishiwashi.name")){pokeNameS ="弱丁魚";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wobbuffet.name")){pokeNameS ="果然翁";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.woobat.name")){pokeNameS ="滾滾蝙蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wooloo.name")){pokeNameS ="毛辮羊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wooper.name")){pokeNameS ="烏波";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wormadam.name")){pokeNameS ="結草貴婦";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wurmple.name")){pokeNameS ="刺尾蟲";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.wynaut.name")){pokeNameS ="小果然";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.xatu.name")){pokeNameS ="天然鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.xerneas.name")){pokeNameS ="哲爾尼亞斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.xerneasmoosecraft.name")){pokeNameS ="Moose的哲爾尼亞斯";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.xurkitree.name")){pokeNameS ="電束木";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yamask.name")){pokeNameS ="哭哭面具";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yamper.name")){pokeNameS ="來電汪";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yanma.name")){pokeNameS ="蜻蜻蜓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yanmega.name")){pokeNameS ="遠古巨蜓";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yungoos.name")){pokeNameS ="貓鼬少";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.yveltal.name")){pokeNameS ="伊裴爾塔爾";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zacian.name")){pokeNameS ="蒼響";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zamazenta.name")){pokeNameS ="藏瑪然特";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zangoose.name")){pokeNameS ="貓鼬斬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zapdos.name")){pokeNameS ="閃電鳥";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zebstrika.name")){pokeNameS ="雷電斑馬";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zekrom.name")){pokeNameS ="捷克羅姆";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zeraora.name")){pokeNameS ="捷拉奧拉";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zigzagoon.name")){pokeNameS ="蛇紋熊";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zoroark.name")){pokeNameS ="索羅亞克";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zorua.name")){pokeNameS ="索羅亞";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zubat.name")){pokeNameS ="超音蝠";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zweilous.name")){pokeNameS ="雙首暴龍";}
        if (pokemon.getSpecies().getUnlocalizedName().equals("pixelmon.zygarde.name")){pokeNameS ="基格爾德";}}

        return pokeNameS;

    }

    @Override
    public String getName() {
        return (pokemon.getNickname() == null || pokemon.getNickname().isEmpty()) ? getSpeciesName() : pokemon.getNickname();
    }

    @Override
    public String getAbility()
    {
        /**
         * The base Code
            return "§7能力: §e" + pokemon.getAbility().getLocalizedName();
         */

        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String abilityS = pokemon.getAbility().getLocalizedName(); //Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Adaptability.name")){abilityS ="適應力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Aerilate.name")){abilityS ="飛行皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Aftermath.name")){abilityS ="引爆";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.AirLock.name")){abilityS ="氣閘";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Analytic.name")){abilityS ="分析";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.AngerPoint.name")){abilityS ="憤怒穴位";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Anticipation.name")){abilityS ="危險預知";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ArenaTrap.name")){abilityS ="沙穴";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.AromaVeil.name")){abilityS ="芳香幕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.AuraBreak.name")){abilityS ="氣場破壞";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BadDreams.name")){abilityS ="夢魘";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BallFetch.name")){abilityS ="撿球";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Ball Fetch.name")){abilityS ="撿球";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Battery.name")){abilityS ="蓄電池";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BattleArmour.name")){abilityS ="戰鬥盔甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BattleBond.name")){abilityS ="牽絆變身";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BeastBoost.name")){abilityS ="異獸提升";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Berserk.name")){abilityS ="怒火沖天";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.BigPecks.name")){abilityS ="健壯胸肌";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Blaze.name")){abilityS ="猛火";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Bulletproof.name")){abilityS ="防彈";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CheekPouch.name")){abilityS ="頰囊";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Chlorophyll.name")){abilityS ="葉綠素";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ClearBody.name")){abilityS ="恆淨之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CloudNine.name")){abilityS ="無關天氣";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ColorChange.name")){abilityS ="變色";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Comatose.name")){abilityS ="絕對睡眠";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Competitive.name")){abilityS ="好勝";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CompoundEyes.name")){abilityS ="複眼";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Contrary.name")){abilityS ="唱反調";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Corrosion.name")){abilityS ="腐蝕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CottonDown.name")){abilityS ="棉絮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CursedBody.name")){abilityS ="詛咒之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.CuteCharm.name")){abilityS ="迷人之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Damp.name")){abilityS ="濕氣";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Dancer.name")){abilityS ="舞者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DarkAura.name")){abilityS ="暗黑氣場";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DauntlessSheild.name")){abilityS ="不屈之盾";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Dazzling.name")){abilityS ="鮮艷之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Defeatist.name")){abilityS ="軟弱";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Defiant.name")){abilityS ="不服輸";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Disguise.name")){abilityS ="畫皮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Download.name")){abilityS ="下載";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DragonsMaw.name")){abilityS ="龍顎";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Drizzle.name")){abilityS ="降雨";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Drought.name")){abilityS ="日照";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DrySkin.name")){abilityS ="乾燥皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.EarlyBird.name")){abilityS ="早起";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.EffectSpore.name")){abilityS ="孢子";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ElectricSurge.name")){abilityS ="電氣製造者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.EmergencyExit.name")){abilityS ="危險迴避";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Error.name")){abilityS ="§k?§r錯誤§k?§r";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FairyAura.name")){abilityS ="妖精氣場";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Filter.name")){abilityS ="過濾";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FlameBody.name")){abilityS ="火焰之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FlareBoost.name")){abilityS ="受熱激升";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FlashFire.name")){abilityS ="引火";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FlowerGift.name")){abilityS ="花之禮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FlowerVeil.name")){abilityS ="花幕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Fluffy.name")){abilityS ="毛茸茸";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Forecast.name")){abilityS ="陰晴不定";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Forewarn.name")){abilityS ="預知夢";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FriendGuard.name")){abilityS ="友情防守";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Frisk.name")){abilityS ="察覺";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FullMetalBody.name")){abilityS ="金屬防護";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.FurCoat.name")){abilityS ="毛皮大衣";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.GaleWings.name")){abilityS ="疾風之翼";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Galvanize.name")){abilityS ="電氣皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Gluttony.name")){abilityS ="貪吃鬼";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Gooey.name")){abilityS ="黏滑";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.GorillaTactics.name")){abilityS ="一猩一意";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.GrassPelt.name")){abilityS ="草之毛皮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.GrassySurge.name")){abilityS ="青草製造者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.GulpMissile.name")){abilityS ="一口飛彈";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Guts.name")){abilityS ="毅力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Harvest.name")){abilityS ="收穫";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Healer.name")){abilityS ="治癒之心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Heatproof.name")){abilityS ="耐熱";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.HeavyMetal.name")){abilityS ="重金屬";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.HoneyGather.name")){abilityS ="採蜜";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.HugePower.name")){abilityS ="大力士";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.HungerSwitch.name")){abilityS ="飽了又餓";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Hustle.name")){abilityS ="活力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Hydration.name")){abilityS ="濕潤之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.HyperCutter.name")){abilityS ="怪力鉗";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IceBody.name")){abilityS ="冰凍之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IceFace.name")){abilityS ="結凍頭";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IceScales.name")){abilityS ="冰鱗粉";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Illuminate.name")){abilityS ="發光";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Illusion.name")){abilityS ="幻覺";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Immunity.name")){abilityS ="免疫";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Imposter.name")){abilityS ="變身者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Infiltrator.name")){abilityS ="穿透";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.InnardsOut.name")){abilityS ="飛出的內在物";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.InnerFocus.name")){abilityS ="精神力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Insomnia.name")){abilityS ="不眠";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Intimidate.name")){abilityS ="威嚇";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IntrepidSword.name")){abilityS ="不撓之劍";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IronBarbs.name")){abilityS ="鐵刺";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.IronFist.name")){abilityS ="鐵拳";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Justified.name")){abilityS ="正義之心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.KeenEye.name")){abilityS ="銳利目光";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Klutz.name")){abilityS ="笨拙";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LeafGuard.name")){abilityS ="葉子防守";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Levitate.name")){abilityS ="飄浮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Libero.name")){abilityS ="自由者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LightMetal.name")){abilityS ="輕金屬";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LightningRod.name")){abilityS ="避雷針";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Limber.name")){abilityS ="柔軟";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LiquidOoze.name")){abilityS ="污泥漿";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LiquidVoice.name")){abilityS ="濕潤之聲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.LongReach.name")){abilityS ="遠隔";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MagicBounce.name")){abilityS ="魔法鏡";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MagicGuard.name")){abilityS ="魔法防守";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Magician.name")){abilityS ="魔術師";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MagmaArmor.name")){abilityS ="熔岩鎧甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MagnetPull.name")){abilityS ="磁力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MarvelScale.name")){abilityS ="神奇鱗片";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MegaLauncher.name")){abilityS ="超級發射器";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Merciless.name")){abilityS ="不仁不義";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Mimicry.name")){abilityS ="擬態";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Minus.name")){abilityS ="負電";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MirrorArmor.name")){abilityS ="鏡甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MistySurge.name")){abilityS ="薄霧製造者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MoldBreaker.name")){abilityS ="破格";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Moody.name")){abilityS ="心情不定";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.MotorDrive.name")){abilityS ="電氣引擎";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Moxie.name")){abilityS ="自信過度";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Multiscale.name")){abilityS ="多重鱗片";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Multitype.name")){abilityS ="多元系";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Mummy.name")){abilityS ="木乃伊";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.NaturalCure.name")){abilityS ="自然回復";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.NoGuard.name")){abilityS ="無防守";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Normalize.name")){abilityS ="一般皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Neuroforce.name")){abilityS ="腦核之力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.NeutralizingGas.name")){abilityS ="化學變化氣體";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Oblivious.name")){abilityS ="遲鈍";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Overcoat.name")){abilityS ="防塵";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Overgrow.name")){abilityS ="茂盛";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.OwnTempo.name")){abilityS ="我行我素";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ParentalBond.name")){abilityS ="親子愛";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PastelVeil.name")){abilityS ="粉彩護幕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PerishBody.name")){abilityS ="滅亡之軀";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Pickpocket.name")){abilityS ="順手牽羊";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Pickup.name")){abilityS ="撿拾";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Pixilate.name")){abilityS ="妖精皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Plus.name")){abilityS ="正電";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PoisonHeal.name")){abilityS ="毒療";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PoisonPoint.name")){abilityS ="毒刺";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PoisonTouch.name")){abilityS ="毒手";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PowerConstruct.name")){abilityS ="群聚變形";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PowerOfAlchemy.name")){abilityS ="化學之力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PowerSpot.name")){abilityS ="能量點";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Prankster.name")){abilityS ="惡作劇之心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Pressure.name")){abilityS ="壓迫感";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PrismArmor.name")){abilityS ="稜鏡裝甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PropellerTail.name")){abilityS ="螺旋尾鰭";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Protean.name")){abilityS ="變幻自如";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PsychicSurge.name")){abilityS ="精神製造者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PunkRock.name")){abilityS ="龐克搖滾";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PurePower.name")){abilityS ="瑜珈神力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.QueenlyMajesty.name")){abilityS ="女王的威嚴";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.QuickFeet.name")){abilityS ="飛毛腿";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.QuickDraw.name")){abilityS ="速擊";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.RainDish.name")){abilityS ="雨盤";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Rattled.name")){abilityS ="膽怯";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Receiver.name")){abilityS ="接球手";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Reckless.name")){abilityS ="捨身";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Refrigerate.name")){abilityS ="冰凍皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Regenerator.name")){abilityS ="再生力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Ripen.name")){abilityS ="熟成";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Rivalry.name")){abilityS ="鬥爭心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.RKSSystem.name")){abilityS ="ＡＲ系統";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.RockHead.name")){abilityS ="堅硬腦袋";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.RoughSkin.name")){abilityS ="粗糙皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.RunAway.name")){abilityS ="逃跑";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SandForce.name")){abilityS ="沙之力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SandRush.name")){abilityS ="撥沙";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SandSpit.name")){abilityS ="吐沙";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SandStream.name")){abilityS ="揚沙";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SandVeil.name")){abilityS ="沙隱";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SapSipper.name")){abilityS ="食草";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Schooling.name")){abilityS ="魚群";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Scrappy.name")){abilityS ="膽量";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ScreenCleaner.name")){abilityS ="除障";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SereneGrace.name")){abilityS ="天恩";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShadowShield.name")){abilityS ="幻影防守";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShadowTag.name")){abilityS ="踩影";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShedSkin.name")){abilityS ="蛻皮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SheerForce.name")){abilityS ="強行";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShellArmour.name")){abilityS ="硬殼盔甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShieldDust.name")){abilityS ="鱗粉";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ShieldsDown.name")){abilityS ="界限盾殼";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Simple.name")){abilityS ="單純";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SkillLink.name")){abilityS ="連續攻擊";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SlowStart.name")){abilityS ="慢啟動";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SlushRush.name")){abilityS ="撥雪";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Sniper.name")){abilityS ="狙擊手";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SnowCloak.name")){abilityS ="雪隱";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SnowWarning.name")){abilityS ="降雪";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SolarPower.name")){abilityS ="太陽之力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SolidRock.name")){abilityS ="堅硬岩石";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SoulHeart.name")){abilityS ="魂心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Soundproof.name")){abilityS ="隔音";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SpeedBoost.name")){abilityS ="加速";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Stakeout.name")){abilityS ="監視";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Stall.name")){abilityS ="慢出";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Stalwart.name")){abilityS ="堅毅";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Stamina.name")){abilityS ="持久力";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.StanceChange.name")){abilityS ="戰鬥切換";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Static.name")){abilityS ="靜電";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Steadfast.name")){abilityS ="不屈之心";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SteamEngine.name")){abilityS ="蒸汽機";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Steelworker.name")){abilityS ="鋼能力者";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SteelySpirit.name")){abilityS ="鋼之意志";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Stench.name")){abilityS ="惡臭";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.StickyHold.name")){abilityS ="黏著";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.StormDrain.name")){abilityS ="引水";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.StrongJaw.name")){abilityS ="強壯之顎";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Sturdy.name")){abilityS ="結實";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SuctionCups.name")){abilityS ="吸盤";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SuperLuck.name")){abilityS ="超幸運";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SurgeSurfer.name")){abilityS ="衝浪之尾";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Swarm.name")){abilityS ="蟲之預感";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SweetVeil.name")){abilityS ="甜幕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.SwiftSwim.name")){abilityS ="悠游自如";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Symbiosis.name")){abilityS ="共生";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Synchronize.name")){abilityS ="同步";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.TangledFeet.name")){abilityS ="蹣跚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.TanglingHair.name")){abilityS ="捲髮";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Technician.name")){abilityS ="技術高手";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Telepathy.name")){abilityS ="心靈感應";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Teravolt.name")){abilityS ="兆級電壓";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ThickFat.name")){abilityS ="厚脂肪";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.TintedLens.name")){abilityS ="有色眼鏡";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Torrent.name")){abilityS ="激流";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ToughClaws.name")){abilityS ="硬爪";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ToxicBoost.name")){abilityS ="中毒激升";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Trace.name")){abilityS ="複製";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Triage.name")){abilityS ="先行治療";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Truant.name")){abilityS ="懶惰";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Turboblaze.name")){abilityS ="渦輪火焰";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Unaware.name")){abilityS ="純樸";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Unburden.name")){abilityS ="輕裝";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.Unnerve.name")){abilityS ="緊張感";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.UnseenFist.name")){abilityS ="無形拳";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.VictoryStar.name")){abilityS ="勝利之星";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.VitalSpirit.name")){abilityS ="幹勁";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.VoltAbsorb.name")){abilityS ="蓄電";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WanderingSpirit.name")){abilityS ="遊魂";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WaterAbsorb.name")){abilityS ="儲水";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WaterBubble.name")){abilityS ="水泡";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WaterCompaction.name")){abilityS ="遇水凝固";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WaterVeil.name")){abilityS ="水幕";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WeakArmor.name")){abilityS ="碎裂鎧甲";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WhiteSmoke.name")){abilityS ="白色煙霧";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WimpOut.name")){abilityS ="躍躍欲逃";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WonderGuard.name")){abilityS ="神奇守護";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.WonderSkin.name")){abilityS ="奇蹟皮膚";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ZenMode.name")){abilityS ="達摩模式";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DeltaStream.name")){abilityS ="德爾塔氣流";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.DesolateLand.name")){abilityS ="終結之地";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.PrimordialSea.name")){abilityS ="始源之海";}
        if (pokemon.getAbility().getUnlocalizedName().equals("ability.ComingSoon.name")){abilityS ="敬請期待！";}}
        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperABILITY() + abilityS;
    }

    @Override
    public String getNature(boolean showMint) {
        /**
         * The base Code
        // gets the base nature, not the mint nature
        //return "§7性格: §e" + pokemon.getBaseNature().getLocalizedName() + (showMint && pokemon.getMintNature() != null ? " (+ " + pokemon.getMintNature() + " Mint)" : "");
         */

        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String natureS = pokemon.getNature().getLocalizedName() ; //Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.adamant")){natureS ="固執";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.bashful")){natureS ="害羞";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.bold")){natureS ="大膽";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.brave")){natureS ="勇敢";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.calm")){natureS ="溫和";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.careful")){natureS ="慎重";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.docile")){natureS ="坦率";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.gentle")){natureS ="溫順";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.hardy")){natureS ="勤奮";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.hasty")){natureS ="急躁";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.impish")){natureS ="淘氣";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.jolly")){natureS ="爽朗";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.lax")){natureS ="樂天";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.lonely")){natureS ="怕寂寞";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.mild")){natureS ="慢吞吞";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.modest")){natureS ="內斂";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.naive")){natureS ="天真";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.naughty")){natureS ="頑皮";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.quiet")){natureS ="冷靜";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.quirky")){natureS ="浮躁";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.rash")){natureS ="馬虎";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.relaxed")){natureS ="悠閒";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.sassy")){natureS ="自大";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.serious")){natureS ="認真";}
        if (pokemon.getNature().getUnlocalizedName().equals("enum.nature.timid")){natureS ="膽小";}}


        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperNATURE() + natureS;
    }


    @Override
    public String getGender() {

        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        String gender;
        switch (pokemon.getGender()) {
            default:
            case None:
                gender = config.ZenWrapperNoSex();
                break;
            case Male:
                gender = config.ZenWrapperMale();
                break;
            case Female:
                gender = config.ZenWrapperFemale();
                break;
        }
        return config.ZenWrapperGENDER() + " "+gender;
    }

    @Override
    public String getSize() {
        /**
         * Base Code
        return "§7體型: §e" + pokemon.getGrowth().name();
         */
        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String sizeS = pokemon.getGrowth().getLocalizedName();//Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.microscopic")){sizeS ="微小";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.pygmy")){sizeS ="侏儒";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.runt")){sizeS ="矮小";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.small")){sizeS ="小";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.ordinary")){sizeS ="普通";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.huge")){sizeS ="大";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.giant")){sizeS ="龐大";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.enormous")){sizeS ="巨大";}
        if (pokemon.getGrowth().getUnlocalizedName().equals("enum.growth.ginormous")){sizeS ="超巨大";}}

        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperGROWTH() +  sizeS;
    }

    @Override
    public String getForm() {
        /**
         * Base Code
        return "§7形態: §e" + pokemon.getFormEnum().getLocalizedName();
         */
        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String formS = pokemon.getFormEnum().getLocalizedName(); //Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.noform")){formS ="無";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.mega")){formS ="Mega";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.megax")){formS ="Mega X";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.megay")){formS ="Mega Y";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.primal")){formS ="原始回歸";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.base")){formS ="一般";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.roasted")){formS ="烤過";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.zombie")){formS ="殭屍";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.online")){formS ="贈品";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.drowned")){formS ="淹死";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.valentine")){formS ="情人節";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.rainbow")){formS ="彩虹";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.alien")){formS ="外星人";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.real")){formS ="真實";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.alter")){formS ="Alter";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.pink")){formS ="粉红色";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.summer")){formS ="夏天";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.crystal")){formS ="水晶";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.rocket")){formS ="火箭";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.creator")){formS ="創作者";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.valencian")){formS ="巴倫西亞";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.zombie.mega")){formS ="Mega殭屍";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.online.mega")){formS ="Mega贈品";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.drowned.mega")){formS ="Mega淹死";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.valentine.mega")){formS ="Mega情人節";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.rainbow.mega")){formS ="Mega彩虹";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.alien.mega")){formS ="Mega外星人";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.real.mega")){formS ="Mega真實";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.alter.mega")){formS ="Mega Alter";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.pink.mega")){formS ="Mega粉红色";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.summer.mega")){formS ="Mega夏天";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.crystal.mega")){formS ="Mega水晶";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.strike")){formS ="侵襲";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.zombiex")){formS ="Mega X 殭屍";}
        if (pokemon.getFormEnum().getUnlocalizedName().equals("pixelmon.generic.form.zombiey")){formS ="Mega Y 殭屍";}}

        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperEVOLUTION() + formS;
    }

    @Override

    public String getCaughtBall() {

        /**
         * Base Code
         return "§7精靈球: §e" + pokemon.getCaughtBall().name();
         */
        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String pokeBallS = pokemon.getCaughtBall().getLocalizedName();//Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.poke_ball.name")){pokeBallS ="精靈球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.dream_ball.name")){pokeBallS ="夢境球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.great_ball.name")){pokeBallS ="超級球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.ultra_ball.name")){pokeBallS ="高級球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.master_ball.name")){pokeBallS ="大師球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.level_ball.name")){pokeBallS ="等級球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.moon_ball.name")){pokeBallS ="月亮球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.friend_ball.name")){pokeBallS ="友友球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.love_ball.name")){pokeBallS ="甜蜜球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.safari_ball.name")){pokeBallS ="狩獵球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.heavy_ball.name")){pokeBallS ="沉重球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.fast_ball.name")){pokeBallS ="速度球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.repeat_ball.name")){pokeBallS ="重複球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.timer_ball.name")){pokeBallS ="計時球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.nest_ball.name")){pokeBallS ="巢穴球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.net_ball.name")){pokeBallS ="捕網球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.dive_ball.name")){pokeBallS ="潛水球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.luxury_ball.name")){pokeBallS ="豪華球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.heal_ball.name")){pokeBallS ="治癒球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.dusk_ball.name")){pokeBallS ="黑暗球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.park_ball.name")){pokeBallS ="公園球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.quick_ball.name")){pokeBallS ="先機球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.lure_ball.name")){pokeBallS ="誘餌球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.sport_ball.name")){pokeBallS ="競賽球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.cherish_ball.name")){pokeBallS ="貴重球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.premier_ball.name")){pokeBallS ="紀念球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.gs_ball.name")){pokeBallS ="GS球";}
        if (pokemon.getCaughtBall().getUnlocalizedName().equals("item.beast_ball.name")){pokeBallS ="究極球";}}

        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperPOKEBALL() + pokeBallS;
    }

    @Override
    public boolean hasSpecialTexture() {
        return pokemon.getForm() > 0 && !pokemon.getFormEnum().isDefaultForm();
    }

    @Override
    public boolean hasTexture() {
        return hasSpecialTexture() || !pokemon.getCustomTexture().isEmpty();
    }

    @Override
    public String getTexture() {

        /**
         *
         * return "§7皮膚: §e"
         *                 + GrammarUtils.cap(hasSpecialTexture()
         *                 ? pokemon.getFormEnum().getLocalizedName()
         *                 : pokemon.getCustomTexture());
         */
        // Code created by Voc-夜芷冰 , only suitable for zh-HK (Tried another way to get the translation from Pixelmon's lang file but failed)
        String textureS = GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getLocalizedName(): pokemon.getCustomTexture());//Unknown , to avoid output nothing (not null)
        if (Tconfig.Translation() == true){
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.noform")){textureS ="無";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.mega")){textureS ="Mega";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.megax")){textureS ="Mega X";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.megay")){textureS ="Mega Y";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.primal")){textureS ="原始回歸";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.base")){textureS ="一般";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.roasted")){textureS ="烤過";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.zombie")){textureS ="殭屍";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.online")){textureS ="贈品";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.drowned")){textureS ="淹死";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.valentine")){textureS ="情人節";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.rainbow")){textureS ="彩虹";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.alien")){textureS ="外星人";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.real")){textureS ="真實";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.alter")){textureS ="Alter";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.pink")){textureS ="粉红色";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.summer")){textureS ="夏天";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.crystal")){textureS ="水晶";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.rocket")){textureS ="火箭";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.creator")){textureS ="創作者";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.valencian")){textureS ="巴倫西亞";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.zombie.mega")){textureS ="Mega殭屍";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.online.mega")){textureS ="Mega贈品";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.drowned.mega")){textureS ="Mega淹死";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.valentine.mega")){textureS ="Mega情人節";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.rainbow.mega")){textureS ="Mega彩虹";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.alien.mega")){textureS ="Mega外星人";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.real.mega")){textureS ="Mega真實";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.alter.mega")){textureS ="Mega Alter";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.pink.mega")){textureS ="Mega粉红色";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.summer.mega")){textureS ="Mega夏天";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.crystal.mega")){textureS ="Mega水晶";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.strike")){textureS ="侵襲";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.zombiex")){textureS ="Mega X 殭屍";}
        if (GrammarUtils.cap(hasSpecialTexture()? pokemon.getFormEnum().getUnlocalizedName(): pokemon.getCustomTexture()).equals("Pixelmon.generic.form.zombiey")){textureS ="Mega Y 殭屍";}}

        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperFORM()+ textureS;

    }

    @Override
    public String getPokerus() {
        ZenConfig config = FusionPixelmon.getInstance().getConfiguration().getZenConfig();
        return config.ZenWrapperPokeurs();
    }

    // Base Code
    // private static final String STATS = "§8(§cHP§8/§cA§8/§cD§8/§cSA§8/§cSD§8/§cSPD§8)";

    private static final String STATS = FusionPixelmon.getInstance().getConfiguration().getZenConfig().ZenWrapperStats();

    public static List<String> getStats(String ivev, HashMap<StatsType, Integer> stats, int[] cache, int max) {
        StringBuilder s = new StringBuilder("    §8(§e");
        StatsType[] types = StatsType.getStatValues();
        int total = 0;
        int newVal;
        for (int i = 0; i < types.length; i++) {
            if (s.length() > 9) s.append("§8/§e");
            newVal = stats.getOrDefault(types[i], 0) + cache[i];
            total += newVal;
            s.append(newVal);
        }
        s.append("§8)");

        List<String> result = new ArrayList<>();
        result.add(ivev + ": " + IPokemonWrapper.beautifyTally(total, max));
        result.add(s.toString());
        result.add("    " + STATS);
        return result;
    }

    @Override
    public List<String> getIVs() {
        int total = 0;
        int max = 186;// 31 max IV * 6 stat types
        for (StatsType stats : StatsType.getStatValues()) total += pokemon.getIVs().get(stats);
        List<String> result = new ArrayList<>();
        result.add("IVs: " + IPokemonWrapper.beautifyTally(total, max));
        result.add(
                "    §8(§e" + pokemon.getIVs().get(StatsType.HP) +
                        "§8/§e" + pokemon.getIVs().get(StatsType.Attack) +
                        "§8/§e" + pokemon.getIVs().get(StatsType.Defence) +
                        "§8/§e" + pokemon.getIVs().get(StatsType.SpecialAttack) +
                        "§8/§e" + pokemon.getIVs().get(StatsType.SpecialDefence) +
                        "§8/§e" + pokemon.getIVs().get(StatsType.Speed) + "§8)");
        result.add("    " + STATS);
        return result;
    }

    @Override
    public List<String> getEVs() {
        int total = 0;
        int max = EVStore.MAX_TOTAL_EVS;// 510
        for (StatsType stats : StatsType.getStatValues()) total += pokemon.getEVs().get(stats);
        List<String> result = new ArrayList<>();
        result.add("EVs: " + IPokemonWrapper.beautifyTally(total, max));
        result.add(
                "    §8(§e" + pokemon.getEVs().get(StatsType.HP) +
                        "§8/§e" + pokemon.getEVs().get(StatsType.Attack) +
                        "§8/§e" + pokemon.getEVs().get(StatsType.Defence) +
                        "§8/§e" + pokemon.getEVs().get(StatsType.SpecialAttack) +
                        "§8/§e" + pokemon.getEVs().get(StatsType.SpecialDefence) +
                        "§8/§e" + pokemon.getEVs().get(StatsType.Speed) + "§8)");
        result.add("    " + STATS);
        return result;
    }
}
