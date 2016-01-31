package de.canitzp.hosenlab2.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class BlockOre extends Block{

    public BlockOre(String name, int harvestLevel) {
        super(Material.rock);
        setCreativeTab(Hosenlab2.tabHosenlab2);
        setBlockName("hosenlab2." + name);
        setBlockTextureName("hosenlab2:" + name);
        setHardness(3F);
        setHarvestLevel("pickaxe", harvestLevel);
        setResistance(5F);
        GameRegistry.registerBlock(this, name);
        OreDictionary.registerOre(name,this);
    }



}
