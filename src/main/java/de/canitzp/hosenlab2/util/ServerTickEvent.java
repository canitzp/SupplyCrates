package de.canitzp.hosenlab2.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @author canitzp
 */
public class ServerTickEvent {

    @SubscribeEvent
    public void onServerTick(TickEvent.PlayerTickEvent event){
        if(!event.player.worldObj.isRemote){
            if(event.player.getCurrentArmor(2) != null && event.player.getCurrentArmor(2).getItem() == Items.diamond_chestplate){
                NBTTagCompound nbt = event.player.getCurrentArmor(2).stackTagCompound;
                if(nbt.getBoolean("isNegative")){
                    event.player.addPotionEffect(new PotionEffect(Potion.wither.getId(), 1, 2));
                }
            }
        }
    }
}
