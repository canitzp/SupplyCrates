package de.canitzp.hosenlab2.items;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemDust extends Item {

    public ItemDust(String name){
        setUnlocalizedName("hosenlab2." + name);
        setCreativeTab(Hosenlab2.tabHosenlab2);
        setTextureName("hosenlab2:" + name);
        GameRegistry.registerItem(this, name);
        OreDictionary.registerOre(name, this);
    }

}
