package de.canitzp.hosenlab2.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Pos {

    private World world;
    private int x, y, z;

    public Pos(World world, int x, int y, int z){
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public TileEntity getTileEntity(){
        return world.getTileEntity(x, y, z);
    }

    public Block getBlock(){
        return world.getBlock(x, y, z);
    }
    public Block getBlock(int y){
        return world.getBlock(x, y, z);
    }

    public void setBlock(Block block){
        world.setBlock(x, y, z, block);
    }
     public void setBlock(Block block, int y){
         world.setBlock(x, y, z, block);
     }

    public void setBlockWithMeta(Block block, int meta){
        world.setBlock(x, y, z, block, meta, 3);
    }

    public boolean isServer(){
        return !world.isRemote;
    }

    public boolean existBlock(){
        return world.blockExists(x, y, z);
    }

    public boolean existBlock(int y){
        return world.blockExists(x, y, z);
    }

    public boolean existBlock(Block block){
        return world.getBlock(x, y, z) == block;
    }

    public boolean existBlock(Block block, int y){
        return world.getBlock(x, y, z) == block;
    }

    public void updateBlock(){
        this.updateBlock(20);
    }

    public void updateBlock(int ticks){
        world.scheduleBlockUpdate(x, y, z, this.getBlock(), ticks);
    }
}
