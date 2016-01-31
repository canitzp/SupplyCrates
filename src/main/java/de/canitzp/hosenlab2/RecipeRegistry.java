package de.canitzp.hosenlab2;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import de.canitzp.hosenlab2.items.ItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class RecipeRegistry {

    public static void init(){
        GameRegistry.addSmelting(ItemRegistry.dustBauxite, getOreDictItem("ingotAluminum"), 2F);
        GameRegistry.addSmelting(BlockRegistry.oreCopper, getOreDictItem("ingotCopper"), 2);
        GameRegistry.addSmelting(BlockRegistry.oreTin, getOreDictItem("ingotTin"), 2);
        GameRegistry.addSmelting(BlockRegistry.oreSilver, getOreDictItem("ingotSilver"), 2);
        GameRegistry.addSmelting(BlockRegistry.oreNickel, getOreDictItem("ingotNickel"), 2);
        GameRegistry.addSmelting(BlockRegistry.oreLead, getOreDictItem("ingotLead"), 2);
        GameRegistry.addSmelting(BlockRegistry.oreBauxite, getOreDictItem("ingotAluminum"), 2);
    }

    public static ItemStack getOreDictItem(String name){
        ArrayList<ItemStack> tList = OreDictionary.getOres(name);
        if(!tList.isEmpty() && tList.get(0) != null){
            return tList.get(0).copy();
        }
        return new ItemStack(Blocks.fire);
    }
}
