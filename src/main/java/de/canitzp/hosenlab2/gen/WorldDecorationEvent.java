package de.canitzp.hosenlab2.gen;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

/**
 * @author Ellpeck
 * I copied this from Ellpecks Mod "ActuallyAdditions"
 * https://github.com/Ellpeck/ActuallyAdditions/blob/master/src/main/java/ellpeck/actuallyadditions/event/WorldDecorationEvent.java
 */
public class WorldDecorationEvent {

    @SubscribeEvent
    public void onWorldDecoration(DecorateBiomeEvent.Decorate event){
        if((event.getResult() == Event.Result.ALLOW || event.getResult() == Event.Result.DEFAULT)){
            genPlantNormally(BlockRegistry.crateMK1, 0, 1, Material.grass, event);
            genPlantNormally(BlockRegistry.crateMK2, 0, 1, Material.grass, event);
            genPlantNormally(BlockRegistry.crateMK3, 0, 1, Material.grass, event);
            genPlantNormally(BlockRegistry.crateMK1, 0, 1, Material.rock, event);
            genPlantNormally(BlockRegistry.crateMK2, 0, 1, Material.rock, event);
            genPlantNormally(BlockRegistry.crateMK3, 0, 1, Material.rock, event);
        }
    }

    private void genPlantNormally(Block plant, int meta, int amount, Material blockBelow, DecorateBiomeEvent event) {
        for (int i = 0; i < amount; i++) {
            if(event.rand.nextInt(1000) == 0){
                int genX = event.chunkX + event.rand.nextInt(16) + 8;
                int genZ = event.chunkZ + event.rand.nextInt(16) + 8;
                int genY = event.world.getTopSolidOrLiquidBlock(genX, genZ) - 1;
                if (event.world.getBlock(genX, genY, genZ).getMaterial() == blockBelow) {
                    event.world.setBlock(genX, genY + 1, genZ, plant, meta, 2);
                }
            }

        }
    }

}
