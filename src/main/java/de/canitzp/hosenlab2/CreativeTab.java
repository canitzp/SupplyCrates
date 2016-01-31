package de.canitzp.hosenlab2;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by canitzp on 24.09.2015.
 */
public class CreativeTab extends CreativeTabs {
    public CreativeTab(String name) {
        super(name);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }
}
