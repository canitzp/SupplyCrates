package de.canitzp.hosenlab2.items;

import de.canitzp.hosenlab2.Hosenlab2;
import net.minecraft.item.Item;

/**
 * @author canitzp
 */
public class Items extends net.minecraft.init.Items{

    //Decorative Stuff:
    public static final Item cloudinabottle = getItemFromName("");
    public static final Item craftingClay = getItemFromName("");
    public static final Item prismarineShard = getItemFromName("etfuturum:prismarine_shard");
    public static final Item prismarineCrystals = getItemFromName("etfuturum:prismarine_crystals");

    //IronChests:
    public static final Item ironChestBlock = getItemFromName("");

    //Wood:
    public static final Item mahoganyLog = getItemFromName("erebus:logMahogany");
    public static final Item baobabLog = getItemFromName("erebus:logBaobab");
    public static final Item cypressLog = getItemFromName("erebus:logCypress");
    public static final Item mucussLog = getItemFromName("erebus:logMucuss");
    public static final Item bambooTorch = getItemFromName("erebus:bambooTorch");
    public static final Item rottenDoor = getItemFromName("erebus:door_rotten");

    //Food:
    public static final Item actAddFood = getItemFromName("ActuallyAdditions:itemFood");
    public static final Item saltOre = getItemFromName("SaltOre:saltOre");
    public static final Item salt = getItemFromName("SaltMod:salt");
    public static final Item saltyBackedPotato = getItemFromName("SaltMod:saltPotatoBacked");
    public static final Item saltyCookedBeef = getItemFromName("SaltMod:saltBeefCooked");
    public static final Item saltyCookedFish = getItemFromName("SaltMod:saltFishCodCooked");
    public static final Item saltMuffin = getItemFromName("SaltMod:muffin");

    //Weapons & Tools:
    public static final Item mytrilSword = getItemFromName("");
    public static final Item bronze_boots = getItemFromName("");
    public static final Item bronze_helmet = getItemFromName("");
    public static final Item bronze_leggings = getItemFromName("");
    public static final Item bronze_chestplate = getItemFromName("");
    public static final Item mythril_bow = getItemFromName("");
    public static final Item adamantium_helmet = getItemFromName("");
    public static final Item adamantium_boots = getItemFromName("");
    public static final Item adamantium_leggings = getItemFromName("");
    public static final Item adamantium_chestplate = getItemFromName("");
    public static final Item illumenite_sword = getItemFromName("");
    public static final Item drill = getItemFromName("ActuallyAdditions:itemDrill");
    public static final Item obsidianHelmet = getItemFromName("ActuallyAdditions:itemHelmObsidian");
    public static final Item obsidianChestplate = getItemFromName("ActuallyAdditions:itemChestObsidian");
    public static final Item obsidianLeggins = getItemFromName("ActuallyAdditions:itemPantsObsidian");
    public static final Item obsidianShoes = getItemFromName("ActuallyAdditions:itemBootsObsidian");
    public static final Item advancedLeafBlower = getItemFromName("ActuallyAdditions:itemLeafBlowerAdvanced");
    public static final Item projectRedPart = getItemFromName("ProjectRed:Core:projectred.core.part");
    public static final Item projectRedBackpack = getItemFromName("ProjectRed:Exploration:projectred.exploration.backpack");
    public static final Item peridotSword = getItemFromName("ProjectRed:Exploration:projectred.exploration.swordperidot");
    public static final Item sapphirePickaxe = getItemFromName("ProjectRed:Exploration:projectred.exploration.pickaxesapphire");
    public static final Item rubyShovel = getItemFromName("ProjectRed:Exploration:projectred.exploration.shovelruby");


    public static Item getItemFromName(String name) {
        if (Item.itemRegistry.containsKey(name)) {
            return (Item)Item.itemRegistry.getObject(name);
        }
        else {
            try {
                return (Item)Item.itemRegistry.getObjectById(Integer.parseInt(name));
            }
            catch (NumberFormatException numberformatexception) {
                return null;
            }
        }
    }

}
