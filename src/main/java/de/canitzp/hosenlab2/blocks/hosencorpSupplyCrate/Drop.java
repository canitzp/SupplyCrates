package de.canitzp.hosenlab2.blocks.hosencorpSupplyCrate;

import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.crates.MultiEntity;
import de.canitzp.hosenlab2.crates.MultiEntityString;
import de.canitzp.hosenlab2.util.Pos;
import ganymedes01.etfuturum.entities.EntityRabbit;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Drop {

    private Pos pos;

    public Drop(Pos pos) {
        this.pos = pos;
    }

    public void drop(List<Object> objects) {
        if(objects.size() >= 1){
            int i = pos.getWorld().rand.nextInt(objects.size());
            if(objects.get(i) instanceof List){
                for(Object o : (List)objects.get(i)){
                    if(!dropList(o)){
                        drop(objects);
                    }
                }
            } else {
                if(!dropList(objects.get(i))){
                    drop(objects);
                }
            }
            objects.clear();
        } else {
            Hosenlab2.logger.error("There is an UniverseError.(List<CrateObjects>.size() <= 0)");
        }
    }

    @SuppressWarnings("unchecked")
    private boolean dropList(Object object) {
        if (pos.isServer() && object != null) {
            if (object instanceof Block) {
                ItemStack stack = new ItemStack((Block) object);
                spawnItem(stack);
            }
            if (object instanceof Item) {
                ItemStack stack = new ItemStack((Item) object);
                spawnItem(stack);
            }
            if (object instanceof ItemStack) {
                if(((ItemStack) object).getItem() != null){
                    spawnItem((ItemStack) object);
                } else {
                    return false;
                }
            }
            if (object instanceof Entity) {
                spawnEntity((Entity) object);
            }
            if (object instanceof MultiEntityString) {
                for (int i = 0; ((MultiEntityString) object).getAmount() != i; i++) {
                    Object entity;
                    try {
                        entity = ((MultiEntityString) object).getEntity().getConstructor(World.class).newInstance(((MultiEntityString) object).getWorld());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    if (entity instanceof EntityLiving) {
                        ((EntityLiving) entity).setCustomNameTag(((MultiEntityString) object).getName());
                    }
                    spawnEntity((Entity) entity);
                }
            }
            if (object instanceof MultiEntity) {
                for (int i = 0; ((MultiEntity) object).getAmount() != i; i++) {
                    Object entity;
                    try {
                        entity = ((MultiEntity) object).getEntity().getConstructor(World.class).newInstance(((MultiEntity) object).getWorld());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                    if (entity instanceof EntityRabbit && ((MultiEntity) object).isRandomColor()) {
                        ((EntityRabbit) entity).setRabbitType(MathHelper.getRandomIntegerInRange(((MultiEntity) object).getWorld().rand, 0, 18));
                    }
                    if (entity instanceof EntitySheep && ((MultiEntity) object).isRandomColor()) {
                        ((EntitySheep) entity).setFleeceColor(MathHelper.getRandomIntegerInRange(((MultiEntity) object).getWorld().rand, 0, 16));
                    }
                    spawnEntity((Entity) entity);
                }
            }
        } else if(pos.isServer()){
            return false;
        }
        return true;
    }

    private void spawnItem(ItemStack stack){
        if(stack != null && stack.getItem() != null){
            Random rand = pos.getWorld().rand;
            EntityItem entityItem;
            float dX = rand.nextFloat()*0.8F+0.1F;
            float dY = rand.nextFloat()*0.8F+0.5F;
            float dZ = rand.nextFloat()*0.8F+0.1F;
            entityItem = new EntityItem(pos.getWorld(), pos.getX() + dX, pos.getY() + dY, pos.getZ() + dZ, stack);
            if (stack.hasTagCompound()) {
                entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
            }
            float factor = 0.05F;
            entityItem.motionX = rand.nextGaussian()*factor;
            entityItem.motionY = rand.nextGaussian()*factor+0.2F;
            entityItem.motionZ = rand.nextGaussian()*factor;
            pos.getWorld().spawnEntityInWorld(entityItem);
        } else {
            System.out.println("ItemStack or Item is null");
        }

    }

    private void spawnEntity(Entity entity){
        Random rand = pos.getWorld().rand;
        float dX = rand.nextFloat()*0.8F+0.1F;
        float dZ = rand.nextFloat()*0.8F+0.1F;
        float factor = 0.05F;
        entity.motionX = rand.nextGaussian()*factor;
        entity.motionZ = rand.nextGaussian()*factor;
        entity.setLocationAndAngles(pos.getX() + dX, pos.getY() + 0.5, pos.getZ() + dZ, MathHelper.wrapAngleTo180_float(rand.nextFloat() * 360.0F), 0.0F);
        if(entity instanceof EntityLiving){
            ((EntityLiving) entity).rotationYawHead = ((EntityLiving)entity).rotationYaw;
            ((EntityLiving) entity).renderYawOffset = ((EntityLiving)entity).rotationYaw;
            ((EntityLiving) entity).playLivingSound();
        }
        pos.getWorld().spawnEntityInWorld(entity);
    }
}