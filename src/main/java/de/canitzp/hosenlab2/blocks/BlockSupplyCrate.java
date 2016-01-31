package de.canitzp.hosenlab2.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.Hosenlab2;
import de.canitzp.hosenlab2.blocks.hosencorpSupplyCrate.Drop;
import de.canitzp.hosenlab2.crates.CrateDiamond;
import de.canitzp.hosenlab2.crates.CrateIron;
import de.canitzp.hosenlab2.crates.CrateWood;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateDiamond;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateIron;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateWood;
import de.canitzp.hosenlab2.util.Pos;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSupplyCrate extends BlockContainer{

    private CrateTier tier;

    public BlockSupplyCrate(CrateTier tier) {
        super(Material.wood);
        this.tier = tier;
        setCreativeTab(Hosenlab2.tabHosenlab2);
        setBlockName("hosenlab2.supplyCrate" + tier.getName());
        setBlockTextureName("hosenlab2:supplyCrate" + tier.getName());
        GameRegistry.registerBlock(this, "supplyCrate" + tier.getName());
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        Pos pos = new Pos(world, x, y, z);
        switch (this.tier){
            case WOOD:
                new Drop(pos).drop(CrateWood.getListWood(pos));
                break;
            case IRON:
                new Drop(pos).drop(CrateIron.getListIron(pos));
                break;
            case DIAMOND:
                new Drop(pos).drop(CrateDiamond.getListDiamond(pos));
                break;
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        this.onBlockDestroyedByPlayer(world, x, y, z, 0);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }

    @Override
    public int getRenderType() {
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
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        switch (this.tier){
            case WOOD: return new TileEntitySupplyCrateWood();
            case IRON: return new TileEntitySupplyCrateIron();
            case DIAMOND: return new TileEntitySupplyCrateDiamond();
        }
        return null;
    }

    public enum CrateTier{
        WOOD("MK1"),
        IRON("MK2"),
        DIAMOND("MK3");

        private String name;

        CrateTier(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
