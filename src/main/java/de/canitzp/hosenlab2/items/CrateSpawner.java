package de.canitzp.hosenlab2.items;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.UUID;

public class CrateSpawner extends Item {

    private Block tier = Blocks.air;

    public CrateSpawner(String tier){
        setCreativeTab(Hosenlab2.tabHosenlab2);
        setTextureName("hosenlab2:crateSpawner" + tier);
        setUnlocalizedName("hosenlab2.crateSpawner" + tier);
        setMaxStackSize(1);
        if(tier.equals("MK1"))this.tier = BlockRegistry.crateMK1;
        if(tier.equals("MK2"))this.tier = BlockRegistry.crateMK2;
        if(tier.equals("MK3"))this.tier = BlockRegistry.crateMK3;
        GameRegistry.registerItem(this, "crateSpawner" + tier);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
        if (player.getUniqueID().equals(UUID.fromString("cb7b293a-5031-484e-b5be-b4f2f4e92726")) || player.getUniqueID().equals(UUID.fromString("3f5f0663-bb91-41f1-8aaa-361dbf47dc3d")) || player.capabilities.isCreativeMode) {
            if(world != null && stack != null && player.posX != hitX && player.posY != hitY + 1 && player.posY != hitY + 2 &&player.posZ != hitZ) {
                if (world.getBlock(x, y, z).getMaterial() == Material.vine || (world.getBlock(x, y, z).getMaterial() == Material.plants && world.getBlock(x, y - 1, z).isBlockNormalCube())) {
                    world.setBlock(x, y, z, tier);
                    return true;
                }
                int side = getMovingObjectPositionFromPlayer(world, player, true).sideHit;
                if (side == 0) {
                    world.setBlock(x, y - 1, z, tier);
                    return true;
                } else if (side == 1) {
                    world.setBlock(x, y + 1, z, tier);
                    return true;
                } else if (side == 2) {
                    world.setBlock(x, y, z - 1, tier);
                    return true;
                } else if (side == 3) {
                    world.setBlock(x, y, z + 1, tier);
                    return true;
                } else if (side == 4) {
                    world.setBlock(x - 1, y, z, tier);
                    return true;
                } else if (side == 5) {
                    world.setBlock(x + 1, y, z, tier);
                    return true;
                }
            }
        }
        return false;
    }
}
