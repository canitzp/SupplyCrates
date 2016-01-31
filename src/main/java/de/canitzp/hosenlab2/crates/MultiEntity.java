package de.canitzp.hosenlab2.crates;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * @author canitzp
 */
public class MultiEntity {

    private final World world;
    private Class entity;
    private int amount;
    private boolean randomColor;

    public MultiEntity(Class<? extends Entity> entity, World world, int amount){
        this.amount = amount;
        this.entity = entity;
        this.world = world;
    }

    public Class getEntity() {
        return entity;
    }

    public int getAmount() {
        return amount;
    }

    public World getWorld() {
        return world;
    }

    public boolean isRandomColor() {
        return randomColor;
    }

    public MultiEntity setRandomColor() {
        this.randomColor = true;
        return this;
    }

    public String toString(){
        return entity.toString() + " " + world + " " + amount;
    }
}
