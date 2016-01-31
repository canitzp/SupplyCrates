package de.canitzp.hosenlab2.crates;

import com.google.common.collect.Lists;
import com.inventorypets.InventoryPets;
import crazypants.enderzoo.entity.EntityConcussionCreeper;
import de.canitzp.hosenlab2.items.Items;
import de.canitzp.hosenlab2.util.Pos;
import erebus.ModItems;
import erebus.entity.*;
import gravestone.entity.monster.EntitySkullCrawler;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import tubeTransportSystem.item.ItemTube;

import java.util.List;

/**
 * @author canitzp
 */
public class CrateIron extends CrateBase {

    private static void init(Pos pos){
        World world = pos.getWorld();
        /**
         * Special Stuff:
         */
        //Charged Creeper "corpofdead":
        EntityCreeper corpofdead = new EntityCreeper(world);
        corpofdead.setCreeperState(1);
        corpofdead.setCustomNameTag("corpofdead");
        addEntity(corpofdead);
        //Charged Creeper "ChrisSchroeder01":
        EntityCreeper chrisSchroeder01 = new EntityCreeper(world);
        corpofdead.setCreeperState(1);
        corpofdead.setCustomNameTag("ChrisSchroeder01");
        addEntity(chrisSchroeder01);
        //2 Mooshroom, 1 Mooshroom "Larhanfu":
        addList(Lists.newArrayList(new MultiEntity(EntityMooshroom.class, world, 2), new MultiEntityString(EntityMooshroom.class, world, 1, "Larhanfu")));
        //Giant Zombie "Zombiefleischer":
        addMultiEntityString(new MultiEntityString(EntityGiantZombie.class, world, 1, "Zombiefleischer"));

        /**
         * Entities:
         */
        addMultiEntity(new MultiEntity(EntityCentipede.class, world, 2));
        addEntity(new EntityTarantula(world));
        addEntity(new EntityScorpion(world));
        addEntity(new EntityPrayingMantis(world));
        addMultiEntity(new MultiEntity(EntityFireAnt.class, world, 5));
        addMultiEntity(new MultiEntity(EntityCicada.class, world, 2));
        addMultiEntity(new MultiEntity(EntityTarantulaBaby.class, world, 10));
        addMultiEntity(new MultiEntity(EntityLeech.class, world, 4));
        addMultiEntity(new MultiEntity(EntityConcussionCreeper.class, world, 3));
        //KSP-Creeper:
        EntityCreeper crepperJeb = new EntityCreeper(world), creeperBob = new EntityCreeper(world), creeperBill = new EntityCreeper(world);
        crepperJeb.setCustomNameTag("Jeb"); creeperBill.setCustomNameTag("Bill"); creeperBob.setCustomNameTag("Bob");
        addList(Lists.newArrayList(crepperJeb, creeperBob, creeperBill));
        addMultiEntity(new MultiEntity(EntityBlaze.class, world, 3));
        //2 Wither, 1 Normal:
        EntitySkeleton skeleton1 = new EntitySkeleton(world), skeleton2 = new EntitySkeleton(world), skeleton3 = new EntitySkeleton(world);
        skeleton1.setSkeletonType(1); skeleton2.setSkeletonType(1);
        addList(Lists.newArrayList(skeleton1, skeleton2, skeleton3));
        addMultiEntity(new MultiEntity(EntitySkullCrawler.class, world, 3));
        addMultiEntity(new MultiEntity(EntityBotFly.class, world, 2));
        addMultiEntity(new MultiEntity(EntityAntlion.class, world, 2));
        addMultiEntity(new MultiEntity(EntityPrayingMantis.class, world, 3));
        addMultiEntity(new MultiEntity(EntityZombieAnt.class, world, 2));
        addMultiEntity(new MultiEntity(EntitySnapper.class, world, 5));
        addMultiEntity(new MultiEntity(EntityMagmaCrawler.class, world, 5));

        /**
         * Blocks & Items:
         */
        addList(Lists.newArrayList(Items.mythril_bow, new ItemStack(Items.arrow, 64)));
        addList(Lists.newArrayList(Items.adamantium_helmet, Items.adamantium_boots));
        ItemStack hosantosLeggins = new ItemStack(Items.adamantium_leggings);
        hosantosLeggins.setStackDisplayName(EnumChatFormatting.GREEN + "Hosantos");
        addList(Lists.newArrayList(hosantosLeggins, Items.adamantium_chestplate));
        addList(Lists.newArrayList(ModItems.rhinoExoskeletonBody, ModItems.rhinoExoskeletonBoots, ModItems.rhinoExoskeletonHelmet, ModItems.rhinoExoskeletonLegs));
        addItem(Items.advancedLeafBlower);
        addList(Lists.newArrayList(Items.obsidianHelmet, Items.obsidianChestplate, Items.obsidianLeggins, Items.obsidianShoes));
        addItemStack(new ItemStack(Items.actAddFood, 10, 18));
        addItemStack(new ItemStack(Items.projectRedBackpack, 1, 0));
        addItemStack(new ItemStack(Items.projectRedBackpack, 1, 4));
        addItemStack(new ItemStack(Items.projectRedBackpack, 1, 12));
        addList(Lists.newArrayList(Items.peridotSword, Items.sapphirePickaxe, Items.rubyShovel));
        addItemStack(new ItemStack(Items.projectRedPart, 10, 23));
        addItemStack(new ItemStack(Items.projectRedPart, 10, 33));
        addItemStack(new ItemStack(Items.projectRedPart, 10, 30));
        addItemStack(new ItemStack(Items.projectRedPart, 10, 32));
        addItem(InventoryPets.petBanana);
        addItem(InventoryPets.petPingot);
        addItem(InventoryPets.petCraftingTable);
        addItem(InventoryPets.petLoot);
        addItem(InventoryPets.petCreeper);
        addItem(InventoryPets.petDubstep);
        addItem(InventoryPets.petMoon);
        addItem(InventoryPets.petChest);
        addItem(InventoryPets.petBed);
        addItem(InventoryPets.petMagmaCube);
        addItem(InventoryPets.petDoubleChest);
        addList(Lists.newArrayList(new ItemStack(ganymedes01.etfuturum.ModBlocks.chorus_plant, 32), new ItemStack(Blocks.end_stone, 10)));
        addItem(ModItems.waterStriders);
        addItemStack(new ItemStack(ItemTube.instance, 32, 0));
    }

    public static void getList(Pos pos) {
        CrateWood.getList(pos);
        init(pos);
    }

    public static List<Object> getListIron(Pos pos){
        getList(pos);
        return list;
    }

}
