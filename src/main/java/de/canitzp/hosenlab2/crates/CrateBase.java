package de.canitzp.hosenlab2.crates;

import com.google.common.collect.Lists;
import de.canitzp.hosenlab2.blocks.hosencorpSupplyCrate.structures.ISpawn;
import de.canitzp.hosenlab2.items.Items;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * @author canitzp
 */
public class CrateBase {

    protected static List<Object> list = Lists.newArrayList();

    protected CrateBase(){}

    public  void addBlock(Block block){
        list.add(block);
    }

    public void addString(String name){
        Block block = Block.getBlockFromName(name);
        Item item = Items.getItemFromName(name);
        if(block != null){
            addBlock(block);
        }
        if(item != null){
            addItem(item);
        }
    }

    protected static void addItem(Item item){
        list.add(item);
    }

    protected static void addItemStack(ItemStack stack){
        list.add(stack);
    }

    protected static void addList(List list){
        CrateBase.list.add(list);
    }

    protected static void addEntity(Entity entity){
        list.add(entity);
    }

    protected static void addStructure(ISpawn spawn){
        list.add(spawn);
    }

    protected static void addMultiEntity(MultiEntity multiEntity){
        list.add(multiEntity);
    }

    protected static void addMultiEntityString(MultiEntityString multiEntity){
        list.add(multiEntity);
    }

}
