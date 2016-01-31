package de.canitzp.hosenlab2.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import de.canitzp.hosenlab2.blocks.BlockRegistry;
import de.canitzp.hosenlab2.blocks.BlockSupplyCrate;
import de.canitzp.hosenlab2.items.ItemRegistry;
import de.canitzp.hosenlab2.renderer.PassportCheckerRenderer;
import de.canitzp.hosenlab2.renderer.PassportItemRenderer;
import de.canitzp.hosenlab2.renderer.SupplyCrateRenderer;
import de.canitzp.hosenlab2.tileEntities.PassportChecker;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateDiamond;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateIron;
import de.canitzp.hosenlab2.tileEntities.TileEntitySupplyCrateWood;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class Client extends Common {

    @Override
    public void renderItems(){
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.hosePassport, new PassportItemRenderer("xdqmhose"));
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.ellpeckPassport, new PassportItemRenderer("Ellpeck"));
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.xdjackiexdPassport, new PassportItemRenderer("xdjackiexd"));
        MinecraftForgeClient.registerItemRenderer(ItemRegistry.nullxDDPassport, new PassportItemRenderer("0xDD"));

        ClientRegistry.bindTileEntitySpecialRenderer(PassportChecker.class, new PassportCheckerRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.passportChecker), new PassportCheckerRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySupplyCrateWood.class, new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.WOOD));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.crateMK1), new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.WOOD));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySupplyCrateIron.class, new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.IRON));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.crateMK2), new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.IRON));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySupplyCrateDiamond.class, new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.DIAMOND));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.crateMK3), new SupplyCrateRenderer(BlockSupplyCrate.CrateTier.DIAMOND));
    }
}
