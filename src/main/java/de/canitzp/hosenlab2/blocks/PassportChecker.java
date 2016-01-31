package de.canitzp.hosenlab2.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.items.ItemPassport;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class PassportChecker extends BlockContainer {

    public PassportChecker() {
        super(Material.iron);
        setBlockName("hosenlab2.passportChecker");
        setBlockTextureName("hosenlab2:passportChecker");
        setCreativeTab(Hosenlab2.tabHosenlab2);
        GameRegistry.registerBlock(this, "passportChecker");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
        ItemStack playerItemStack = player.getCurrentEquippedItem();
        de.canitzp.hosenlab2.tileEntities.PassportChecker tile = (de.canitzp.hosenlab2.tileEntities.PassportChecker) world.getTileEntity(x, y, z);
        if(playerItemStack != null && playerItemStack.getItem() instanceof ItemPassport && world.getBlockMetadata(x, y, z) <= 4){
            if(tile.code != null && tile.code.equals(((ItemPassport) playerItemStack.getItem()).getCode())){
                tile.activated = true;
                world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 5, 3);
                world.notifyBlockOfNeighborChange(x, y, z, this);
                world.scheduleBlockUpdate(x, y, z, this, 20);
            } else if(tile.code != null && !tile.code.equals(((ItemPassport) playerItemStack.getItem()).getCode())){
                return true;
            } else {
                tile.code = ((ItemPassport) playerItemStack.getItem()).getCode();
            }
            return true;
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        if(!world.isRemote){
            if(!world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) >= 5){
                world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 5, 3);
                world.notifyBlockOfNeighborChange(x, y, z, this);
            }
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rnd) {
        if(!world.isRemote){
            de.canitzp.hosenlab2.tileEntities.PassportChecker tile = (de.canitzp.hosenlab2.tileEntities.PassportChecker) world.getTileEntity(x, y, z);
            if(tile.activated && tile.tick == 0){
                world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 5, 3);
                world.scheduleBlockUpdate(x, y, z, this, 0);
                world.notifyBlockOfNeighborChange(x, y, z, this);
                tile.activated = false;
            } else if(tile.activated){
                tile.tick--;
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
        int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        de.canitzp.hosenlab2.tileEntities.PassportChecker tile = (de.canitzp.hosenlab2.tileEntities.PassportChecker) world.getTileEntity(x, y, z);
        if(rotation == 0){
            world.setBlockMetadataWithNotify(x, y, z, 2, 0);
        }
        if(rotation == 1){
            world.setBlockMetadataWithNotify(x, y, z, 1, 3);
        }
        if(rotation == 2){
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }
        if(rotation == 3){
            world.setBlockMetadataWithNotify(x, y, z, 3, 3);
        }
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
        return (p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_)) >= 5 ? 15 : 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int x, int y, int z, int meta) {
        int i1 = iBlockAccess.getBlockMetadata(x, y, z);

        if (i1 <= 4) {
            return 0;
        } else {
            return 15;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new de.canitzp.hosenlab2.tileEntities.PassportChecker();
    }
}
