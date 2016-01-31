package de.canitzp.hosenlab2.crates;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * @author canitzp
 */
public class MultiEntityString extends MultiEntity{

    private String name;

    public MultiEntityString(Class<? extends Entity> entity, World world, int amount, String name) {
        super(entity, world, amount);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
