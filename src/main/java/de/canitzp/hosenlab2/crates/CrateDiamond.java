package de.canitzp.hosenlab2.crates;

import com.google.common.collect.Lists;
import de.canitzp.hosenlab2.items.Items;
import de.canitzp.hosenlab2.util.Pos;
import erebus.ModItems;
import erebus.entity.*;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * @author canitzp
 */
public class CrateDiamond extends CrateBase {

    private static void init(World world){
        /**
         * Entities:
         */
        addEntity(new EntityRhinoBeetle(world));
        addEntity(new EntityBombardierBeetle(world));
        addMultiEntity(new MultiEntity(EntityBlaze.class, world, 5));
        //1 Charged Creeper, 2 Normal:
        EntityCreeper chargedCreeper = new EntityCreeper(world);
        chargedCreeper.setCreeperState(17);
        addList(Lists.newArrayList(chargedCreeper, new EntityCreeper(world), new EntityCreeper(world)));
        //3 Wither Skeleton, 2 Normal:
        EntitySkeleton skeleton1 = new EntitySkeleton(world), skeleton2 = new EntitySkeleton(world), skeleton3 = new EntitySkeleton(world);
        skeleton1.setSkeletonType(1); skeleton2.setSkeletonType(1); skeleton3.setSkeletonType(1);
        addList(Lists.newArrayList(skeleton1, skeleton2, skeleton3, new EntitySkeleton(world), new EntitySkeleton(world)));
        addMultiEntity(new MultiEntity(EntityBotFly.class, world, 8));
        addMultiEntity(new MultiEntity(EntityScorpion.class, world, 4));
        addMultiEntity(new MultiEntity(EntityAntlion.class, world, 6));
        addMultiEntity(new MultiEntity(EntityVelvetWorm.class, world, 5));
        addEntity(new EntityTitanBeetle(world));
        addEntity(new EntityLavaWebSpider(world));
        addList(Lists.newArrayList(new EntityAntlionMiniBoss(world), new EntityAntlion(world), new EntityAntlion(world)));

        EntityEnderCrystal flyingEnderCrystal = new EntityEnderCrystal(world);
        EntityBat bat = new EntityBat(world);
        bat.addPotionEffect(new PotionEffect(14, 2000000000, 0, false));
        bat.setCustomNameTag("alsderda");
        flyingEnderCrystal.mountEntity(new EntityBat(world));
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("ExplosionPower", 50);
        flyingEnderCrystal.writeToNBT(nbt);
        addList(Lists.newArrayList(bat, flyingEnderCrystal));


        /**
         * Blocks & Items:
         */
        addItem(Items.illumenite_sword);
        addItem(ModItems.warHammer);
        addItem(ModItems.wandOfAnimation);
        ItemStack tfighter = new ItemStack(Items.drill, 1, 2);
        tfighter.setStackDisplayName(EnumChatFormatting.DARK_PURPLE + "TFighter");
        addItemStack(tfighter);
    }

    public static void getList(Pos pos) {
        CrateIron.getList(pos);
        init(pos.getWorld());
    }

    public static List<Object> getListDiamond(Pos pos){
        getList(pos);
        return list;
    }
}
