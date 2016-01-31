package de.canitzp.hosenlab2.gen;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.util.Random;

public class OreGeneration implements IWorldGenerator {


    public static void init(){
        GameRegistry.registerWorldGenerator(new OreGeneration(), 10);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.terrainType == WorldType.FLAT) return;
        switch(world.provider.dimensionId){
            case -1:
                generateNether(world, random, chunkX*16, chunkZ*16);
            case 1:
                generateEnd(world, random, chunkX*16, chunkZ*16);
            default:
                generateSurface(world, random, chunkX*16, chunkZ*16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        addOreSpawn(BlockRegistry.oreCopper, 0, Blocks.stone, world, random, x, z, 8, MathHelper.getRandomIntegerInRange(new Random(), 6, 20), 40, 85);
        addOreSpawn(BlockRegistry.oreTin, 0, Blocks.stone, world, random, x, z, 8, MathHelper.getRandomIntegerInRange(new Random(), 6, 18), 35, 70);
        addOreSpawn(BlockRegistry.oreBauxite, 0, Blocks.stone, world, random, x, z, 4, MathHelper.getRandomIntegerInRange(new Random(), 3, 15), 10, 45);
        addOreSpawn(BlockRegistry.oreLead, 0, Blocks.stone, world, random, x, z, 3, MathHelper.getRandomIntegerInRange(new Random(), 2, 10), 5, 30);
        addOreSpawn(BlockRegistry.oreSilver, 0, Blocks.stone, world, random, x, z, 3, MathHelper.getRandomIntegerInRange(new Random(), 0, 12), 0, 25);
        addOreSpawn(BlockRegistry.oreNickel, 0, Blocks.stone, world, random, x, z, 2, MathHelper.getRandomIntegerInRange(new Random(), 0, 15), 0, 20);
    }

    private void generateEnd(World world, Random random, int i, int i1) {

    }

    private void generateNether(World world, Random random, int i, int i1) {

    }
    public void addOreSpawn(Block block, int meta, Block blockIn, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY){
        if(maxY > minY){
            int yDiff = maxY - minY;
            for(int i = 0; i < chancesToSpawn; i++){
                int posX = blockXPos + random.nextInt(16);
                int posY = minY + random.nextInt(yDiff);
                int posZ = blockZPos + random.nextInt(16);
                new WorldGenMinable(block, meta, maxVeinSize, blockIn).generate(world, random, posX, posY, posZ);
            }
        }
    }


}

