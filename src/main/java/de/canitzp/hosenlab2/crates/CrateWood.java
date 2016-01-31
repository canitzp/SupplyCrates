package de.canitzp.hosenlab2.crates;

import com.google.common.collect.Lists;
import crazypants.enderzoo.entity.EntityDireSlime;
import crazypants.enderzoo.entity.EntityDireWolf;
import crazypants.enderzoo.entity.EntityWitherCat;
import de.canitzp.hosenlab2.items.ItemRegistry;
import de.canitzp.hosenlab2.items.Items;
import de.canitzp.hosenlab2.util.Pos;
import erebus.entity.*;
import ganymedes01.etfuturum.entities.EntityRabbit;
import ganymedes01.etfuturum.entities.EntityZombieVillager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;


/**
 * @author canitzp
 */
public class CrateWood extends CrateBase{

    private static void init(Pos pos){
        World world = pos.getWorld();
        /**
         * Special Drops:
         */
        //Larixine
        EntitySquid larixine = new EntitySquid(world);
        larixine.setCustomNameTag("LariXine");
        addEntity(larixine);
        //UltimateHuhn:
        EntityChicken ultimateHose = new EntityChicken(world);
        ultimateHose.setCustomNameTag("Ultimate Hose");
        addEntity(ultimateHose);
        //HasenFriky:
        EntityRabbit frikyMediaLP = new EntityRabbit(world);
        frikyMediaLP.setCustomNameTag("FrikyMediaLP");
        addEntity(frikyMediaLP);
        //ZombiePeck:
        EntityZombieVillager ellpeck = new EntityZombieVillager(world);
        ellpeck.setCustomNameTag("Ellpeck");
        ellpeck.setCurrentItemOrArmor(0, new ItemStack(Items.drill));
        addEntity(ellpeck);
        //KittyVanCat:
        EntityOcelot kittyVanCat = new EntityOcelot(world);
        kittyVanCat.setCustomNameTag("KittyVanCat");
        kittyVanCat.setTamed(true);
        addEntity(kittyVanCat);
        //Darkstar:
        EntityBlackWidow darkstar = new EntityBlackWidow(world);
        darkstar.setCustomNameTag("Darkstar");
        addEntity(darkstar);
        //DJGummikuh:
        EntityCow djcow = new EntityCow(world);
        djcow.setCustomNameTag("DJGummikuh");
        addEntity(djcow);
        //xdjackiexd:
        EntityOcelot xdjackiexd = new EntityOcelot(world);
        xdjackiexd.setCustomNameTag("xdjackiexd");
        xdjackiexd.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
        xdjackiexd.setAttackTarget(pos.getWorld().getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 15));
        addEntity(xdjackiexd);
        //Filbasisch:
        addMultiEntityString(new MultiEntityString(EntitySilverfish.class, world, 8, "Filbasisch"));
        //Burningstar:
        EntityBlaze burningstar = new EntityBlaze(world);
        burningstar.setCustomNameTag("Burningstar");
        addEntity(burningstar);
        //Gost & Shaggydog:
        EntityDireWolf dogs1 = new EntityDireWolf(world), dogs2 = new EntityDireWolf(world);
        dogs1.setCustomNameTag("Ghost");
        dogs2.setCustomNameTag("Shaggydog");
        addList(Lists.newArrayList(dogs1, dogs2));
        //WildWool:
        EntityDireWolf wildWool = new EntityDireWolf(world);
        wildWool.setCustomNameTag("WildWool");
        addEntity(wildWool);
        //Eisenkater:
        EntityWitherCat eisenkater = new EntityWitherCat(world);
        eisenkater.setCustomNameTag("Eisenkater");
        addEntity(eisenkater);
        //drach3nfreund:
        EntityVillager drach3nfreund = new EntityVillager(world);
        drach3nfreund.setProfession(MathHelper.getRandomIntegerInRange(world.rand, 0, 4));
        drach3nfreund.setCustomNameTag("drach3nfreund");
        addEntity(drach3nfreund);
        //Harter Humbuck:
        EntityIronGolem harterHumbuck = new EntityIronGolem(world);
        harterHumbuck.setCustomNameTag("Harter Humbuck");
        addEntity(harterHumbuck);
        //Deadio:
        EntityDireSlime deadio = new EntityDireSlime(world);
        deadio.setCustomNameTag("Deadio");
        addEntity(deadio);
        //R1COAL3x:
        ItemStack r1COAL3x = new ItemStack(Blocks.coal_block);
        r1COAL3x.setStackDisplayName("R1COAL3x");
        addItemStack(r1COAL3x);
        //Passierschein A38:
        ItemStack passierscheinA38= new ItemStack(Items.paper);
        passierscheinA38.setStackDisplayName("Passierschein A38");
        addItemStack(passierscheinA38);
        //1 Spider "FranziFreak", 4 Cave Spider "Franzi":
        addList(Lists.newArrayList(new MultiEntityString(EntitySpider.class, world, 1, "FranziFreak"), new MultiEntityString(EntityCaveSpider.class, world, 4, "Franzi")));
        //Bat "Grunzwanzling", 16xIronIngot:
        addList(Lists.newArrayList(new MultiEntityString(EntityBat.class, world, 1, "Grunzwanzling"), new ItemStack(Items.iron_ingot, 16)));
        //Angry ZombiePigMan "NoobsterLP":
        EntityPigZombie noobsterLP = new EntityPigZombie(world);
        noobsterLP.setCustomNameTag("NoobsterLP");
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setShort("Anger", (short) (400 + world.rand.nextInt(400)));
        noobsterLP.writeEntityToNBT(nbt);
        addEntity(noobsterLP);
        //Walking Redstone Block "redtech13":
        EntityAnimatedBlock redtech13 = new EntityAnimatedBlock(world);
        redtech13.setBlock(Blocks.redstone_block, 0);
        redtech13.setCustomNameTag("redtech13");
        addEntity(redtech13);
        //Sawmp Wisp "Navi":
        addMultiEntity(new MultiEntityString(EntityWisp.class, world, 1, "Navi"));
        //Wolf "Mima":
        EntityWolf mima = new EntityWolf(world);
        mima.setCustomNameTag("Mima");
        mima.setTamed(true);
        mima.setPathToEntity((PathEntity)null);
        mima.setAttackTarget((EntityLivingBase)null);
        mima.setHealth(20.0F);
        mima.func_152115_b(world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 16).getUniqueID().toString());
        mima.worldObj.setEntityState(mima, (byte)7);
        addEntity(mima);
        //Pink Sheep "Mannerschnitte":
        EntitySheep mannerschnitte = new EntitySheep(world);
        mannerschnitte.setFleeceColor(6);
        mannerschnitte.setCustomNameTag("Mannerschnitte");
        addList(Lists.newArrayList(mannerschnitte, new ItemStack(Blocks.wool, 16, 6)));
        //Wither Cat "Mattzimann", Wither Cat "MaxiKing":
        EntityWitherCat mattzimann = new EntityWitherCat(world);
        mattzimann.setCustomNameTag("Mattzimann");
        EntityWitherCat maxiKing = new EntityWitherCat(world);
        maxiKing.setCustomNameTag("MaxiKing");
        addList(Lists.newArrayList(mattzimann, maxiKing));


        /**
         * Entities:
         */
        addMultiEntity(new MultiEntity(EntityDireSlime.class, world, 3));
        addMultiEntity(new MultiEntity(EntityBeetleLarva.class, world, 3));
        addEntity(new EntityWasp(world));
        addList(Lists.newArrayList(new EntityMosquito(world), new MultiEntity(EntityFly.class, world, 2)));
        addEntity(new EntitySolifuge(world));
        addEntity(new EntityLocust(world));
        addMultiEntity(new MultiEntity(EntityBlackWidow.class, world, 2));
        addMultiEntity(new MultiEntity(EntityMoneySpider.class, world, 2));
        addEntity(new EntityJumpingSpider(world));
        addEntity(new EntityChameleonTick(world));
        addEntity(new EntityMidgeSwarm(world));
        addMultiEntity(new MultiEntity(EntityPunchroom.class, world, 2));
        addMultiEntity(new MultiEntity(EntityBlackAnt.class, world, 5));
        addMultiEntity(new MultiEntity(EntityPondSkater.class, world, 2));
        addMultiEntity(new MultiEntity(EntityRabbit.class, world, 15).setRandomColor());
        addMultiEntity(new MultiEntity(EntityCaveSpider.class, world, 3));
        addMultiEntity(new MultiEntity(EntitySheep.class, world, 5).setRandomColor());
        addMultiEntity(new MultiEntity(EntityBloodSnail.class, world, 6));
        addMultiEntity(new MultiEntity(EntityWheatWeevil.class, world, 3));
        addMultiEntity(new MultiEntity(EntityWoodlouse.class, world, 5));

        /**
         * Blocks & Items:
         */
        ItemStack mySword1 = new ItemStack(Items.mytrilSword);
        mySword1.addEnchantment(Enchantment.smite, 2);
        mySword1.setStackDisplayName(EnumChatFormatting.AQUA + "Blaui-Aui");
        addItemStack(mySword1);
        addList(Lists.newArrayList(Items.bronze_boots, Items.bronze_helmet, Items.bronze_leggings, Items.bronze_chestplate));
        addItemStack(new ItemStack(Items.mahoganyLog, 16));
        addItemStack(new ItemStack(Items.baobabLog, 16));
        addItemStack(new ItemStack(Items.cypressLog, 16));
        addItemStack(new ItemStack(Items.mucussLog, 16));
        addItemStack(new ItemStack(Items.bambooTorch, 16));
        ItemStack rottenWoodDoor1 = new ItemStack(Items.rottenDoor);
        rottenWoodDoor1.setStackDisplayName("Trollololo");
        addItemStack(rottenWoodDoor1);
        addItemStack(new ItemStack(Items.actAddFood, 10, 4));
        addItemStack(new ItemStack(Items.actAddFood, 5, 11));
        addItemStack(new ItemStack(Items.actAddFood, 2, 8));
        addList(Lists.newArrayList(new ItemStack(Items.saltOre, 5), new ItemStack(Items.salt, 20)));
        addItemStack(new ItemStack(Items.saltyBackedPotato, 10));
        addItemStack(new ItemStack(Items.saltyCookedBeef, 10));
        addItemStack(new ItemStack(Items.saltyCookedFish, 10));
        addItemStack(new ItemStack(Items.saltMuffin, 5));
        addList(Lists.newArrayList(new ItemStack(Items.prismarineShard, 16), new ItemStack(Items.prismarineCrystals, 16)));
        addItemStack(new ItemStack(Items.ironChestBlock, 2));
        addItemStack(new ItemStack(Items.painting, 8));
        addItemStack(new ItemStack(Items.experience_bottle, 8));
        addItemStack(new ItemStack(Items.cloudinabottle, 4));
        addItem(ItemRegistry.hosePassport);
        addItem(ItemRegistry.ellpeckPassport);
        addItem(ItemRegistry.xdjackiexdPassport);
        addItem(ItemRegistry.nullxDDPassport);
        addItemStack(new ItemStack(Items.ender_pearl, 16));
        addList(Lists.newArrayList(new ItemStack(Items.craftingClay, 32, 0), new ItemStack(Items.craftingClay, 32, 1), new ItemStack(Items.craftingClay, 32, 2)));
    }

    public static void getList(Pos pos) {
        list.clear();
        init(pos);
    }

    public static List<Object> getListWood(Pos pos){
        getList(pos);
        return list;
    }

}
